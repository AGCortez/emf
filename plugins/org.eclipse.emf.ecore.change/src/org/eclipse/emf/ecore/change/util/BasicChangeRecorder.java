/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.  This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BasicChangeRecorder.java,v 1.1 2007/01/31 16:29:49 marcelop Exp $
 */
package org.eclipse.emf.ecore.change.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.ResourceChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;


/**
 * This class provides the basic methods required to implement a change recorder.
 * @since 2.3
 */
public class BasicChangeRecorder extends ListDifferenceAnalyzer
{
  protected boolean recording;
  
  protected ChangeDescription changeDescription;

  /**
   * @return true if this change recorder is recording or false otherwise.
   */
  public boolean isRecording()
  {
    return recording;
  }
  
  protected void setRecording(boolean recording)
  {
    this.recording = recording;
  }
  
  protected ChangeDescription getChangeDescription()
  {
    return changeDescription;
  }
  
  protected void setChangeDescription(ChangeDescription changeDescription)
  {
    this.changeDescription = changeDescription;
  }
  
  /**
   * Disposes this change recorder.  This method ends a recording without 
   * consolidating the changes.
   */
  public void dispose()
  {
    changeDescription = null;
  }

  /**
   * <p>Summarizes the changes made to the analysed objects on the {@link ChangeDescription change description}
   * returned by the {@link #endRecording()} without ending the recording.</p>

   * <p>This method doesn't do anything if this ChangeRecorder is not recording.</p>
   * 
   * @return the {@link ChangeDescription} or <tt class="code">null</tt> if there is nothing being recorded.
   */
  public ChangeDescription summarize()
  {
    if (isRecording())
    {
      consolidateChanges();
      return getChangeDescription();
    }
    return null;
  }
  
  /**
   * Ends the recording and consolidates the changes on the {@link ChangeDescription change description}.
   * @return the {@link ChangeDescription} or <tt class="code">null</tt> if there is nothing being recorded.
   */
  public ChangeDescription endRecording()
  {
    if (isRecording())
    {
      setRecording(false);
      consolidateChanges();
      return getChangeDescription();
    }
    return null;
  }  
  
  /**
   * Consolidates the changes that have happen since the last consolidation.
   */
  protected void consolidateChanges()
  {
    ChangeDescription changeDescription = getChangeDescription();
    for (Map.Entry<EObject, EList<FeatureChange>> entry : changeDescription.getObjectChanges())
    {
      EObject eObject = entry.getKey();
      for (FeatureChange featureChange : entry.getValue())
      {
        finalizeChange(featureChange, eObject);
      }
    }

    for (ResourceChange resourceChange : changeDescription.getResourceChanges())
    {
      finalizeChange(resourceChange);
    }    
  }
  
  protected boolean shouldRecord(EStructuralFeature feature, EObject eObject)
  {
    return isRecording() &&
      !feature.isDerived() &&
      feature != EcorePackage.Literals.ECLASS__ESUPER_TYPES &&
      feature != EcorePackage.Literals.ETYPED_ELEMENT__ETYPE &&
      feature != EcorePackage.Literals.EOPERATION__EEXCEPTIONS;
  }  
  
  protected void finalizeChange(ResourceChange change)
  {
    EList<Object> oldList = new BasicEList.FastCompare<Object>(change.getResource().getContents());
    EList<?> newList = change.getValue();
    change.getListChanges().clear();
    createListChanges(oldList, newList, change.getListChanges());
  }

  protected void finalizeChange(FeatureChange change, EObject eObject)
  {
    if (change.isSet())
    {
      EStructuralFeature feature = change.getFeature();
      if (feature.isMany())
      {
        EList<Object> oldList = new BasicEList<Object>((EList<?>)eObject.eGet(feature));
        EList<?> newList = (EList<?>)change.getValue();
        EList<ListChange> listChanges = change.getListChanges();
        listChanges.clear();
        createListChanges(oldList, newList, listChanges);
      }
    }
  }

  protected EList<ResourceChange> getResourceChanges()
  {
    return getChangeDescription().getResourceChanges();
  }

  protected ResourceChange getResourceChange(Resource resource)
  {
    List<ResourceChange> resourceChanges = getResourceChanges();
    for (int i = 0, size = resourceChanges.size(); i < size;)
    {
      ResourceChange resourceChange = resourceChanges.get(i++);
      if (resourceChange.getResource() == resource)
      {
        return resourceChange;
      }
    }
    return null;
  }  
  
  protected List<FeatureChange> getFeatureChanges(EObject eObject)
  {
    ChangeDescription changeDescription = getChangeDescription();
    List<FeatureChange> featureChanges = changeDescription.getObjectChanges().get(eObject);
    if (featureChanges == null)
    {
      Map.Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(eObject);
      changeDescription.getObjectChanges().add(entry);
      featureChanges = entry.getValue();
    }
    return featureChanges;
  }

  protected FeatureChange getFeatureChange(List<FeatureChange> featureChanges, EStructuralFeature eStructuralFeature)
  {
    EObjectContainmentEList<FeatureChange> changes = (EObjectContainmentEList<FeatureChange>)featureChanges;
    for (int i = 0, size = changes.size(); i < size;)
    {
      FeatureChange featureChange = changes.get(i++);
      if (featureChange.getFeature() == eStructuralFeature)
      {
        return featureChange;
      }
    }
    return null;
  }  
  
  protected FeatureChange createFeatureChange(EObject eObject, EStructuralFeature eStructuralFeature, Object value, boolean isSet)
  {
    return ChangeFactory.eINSTANCE.createFeatureChange(eStructuralFeature, value, isSet);
  }

  protected ResourceChange createResourceChange(Resource resource, EList<Object> value)
  {
    return ChangeFactory.eINSTANCE.createResourceChange(resource, value);
  }

  protected ChangeDescription createChangeDescription()
  {
    return ChangeFactory.eINSTANCE.createChangeDescription();
  }
}
