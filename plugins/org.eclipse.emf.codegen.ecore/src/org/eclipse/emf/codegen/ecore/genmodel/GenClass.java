/**
 * <copyright> 
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GenClass.java,v 1.19 2005/11/25 22:14:17 emerks Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass <em>Ecore Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures <em>Gen Features</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations <em>Gen Operations</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature <em>Label Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass()
 * @model
 * @generated
 */
public interface GenClass extends GenClassifier
{
  /**
   * Returns the value of the '<em><b>Provider</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Provider</em>' attribute isn't clear, 
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provider</em>' attribute.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind
   * @see #setProvider(GenProviderKind)
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_Provider()
   * @model
   * @generated
   */
  GenProviderKind getProvider();

  /**
   * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider <em>Provider</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Provider</em>' attribute.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind
   * @see #getProvider()
   * @generated
   */
  void setProvider(GenProviderKind value);

  /**
   * Returns the value of the '<em><b>Image</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Image</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image</em>' attribute.
   * @see #setImage(boolean)
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_Image()
   * @model default="true"
   * @generated
   */
  boolean isImage();

  /**
   * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage <em>Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image</em>' attribute.
   * @see #isImage()
   * @generated
   */
  void setImage(boolean value);

  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dynamic</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(boolean)
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_Dynamic()
   * @model
   * @generated
   */
  boolean isDynamic();

  /**
   * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isDynamic <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' attribute.
   * @see #isDynamic()
   * @generated
   */
  void setDynamic(boolean value);

  /**
   * Returns the value of the '<em><b>Ecore Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ecore Class</em>' reference isn't clear, 
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ecore Class</em>' reference.
   * @see #setEcoreClass(EClass)
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_EcoreClass()
   * @model required="true"
   * @generated
   */
  EClass getEcoreClass();

  /**
   * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass <em>Ecore Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ecore Class</em>' reference.
   * @see #getEcoreClass()
   * @generated
   */
  void setEcoreClass(EClass value);

  /**
   * Returns the value of the '<em><b>Gen Features</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass <em>Gen Class</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gen Features</em>' reference list isn't clear, 
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gen Features</em>' containment reference list.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_GenFeatures()
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass
   * @model type="org.eclipse.emf.codegen.ecore.genmodel.GenFeature" opposite="genClass" containment="true"
   * @generated
   */
  EList getGenFeatures();

  /**
   * Returns the value of the '<em><b>Gen Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass <em>Gen Class</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gen Operations</em>' reference list isn't clear, 
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gen Operations</em>' containment reference list.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_GenOperations()
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass
   * @model type="org.eclipse.emf.codegen.ecore.genmodel.GenOperation" opposite="genClass" containment="true"
   * @generated
   */
  EList getGenOperations();

  /**
   * Returns the value of the '<em><b>Label Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Feature</em>' reference isn't clear, 
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label Feature</em>' reference.
   * @see #setLabelFeature(GenFeature)
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage#getGenClass_LabelFeature()
   * @model
   * @generated
   */
  GenFeature getLabelFeature();

  /**
   * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature <em>Label Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Feature</em>' reference.
   * @see #getLabelFeature()
   * @generated
   */
  void setLabelFeature(GenFeature value);

  /**
   * This should only be called when there is actually an interface being
   * generated (i.e. when, for certain, this is not an external interface).
   * Otherwise, getImportedInterfaceName() should be used.
   */
  String getInterfaceName();

  String getQualifiedInterfaceName();
  String getImportedInterfaceName();

  String getClassName();
  String getQualifiedClassName();
  String getImportedClassName();

  /**
   * This returns the name uncapitalized. Callers that plan to use this name
   * without appending a suffix should call getSafeUncapInterfaceName() to
   * make sure it's not a reserved word.
   */  
  String getUncapName();

  List/*of GenClass*/ getBaseGenClasses();
  List/*of GenClass*/ getAllBaseGenClasses();

  /**
   * Like getAllBaseGenClasses(), this returns the GenClasses for all of the
   * supertypes, but the result is ordered by a breadth-first search, making
   * it appropriate for use in the switch class.
   */
  List/*of GenClass*/ getSwitchGenClasses();

  /**
   * This returns the GenClass for the first immediate supertype.
   */
  GenClass getBaseGenClass();

  /**
   * This walks up the chain of GenClasses defined by getBaseGenClass() and
   * returns the first that does not represent an abstract class or an
   * interface; that is, the instantiable class that the implementation
   * class should extended.
   */
  GenClass getClassExtendsGenClass();

  String getClassExtends();
  String getClassImplements();
  String getInterfaceExtends();
  boolean needsRootExtendsInterfaceExtendsTag();

  List/*of GenFeature*/ getAllGenFeatures();
  List/*of GenFeature*/ getInheritedGenFeatures();
  List/*of GenOperation*/ getAllGenOperations();

  String getFeatureID(GenFeature genFeature);
  String getQualifiedFeatureID(GenFeature genFeature);
  String getOperationID(GenOperation genOperation);
  String getFeatureValue(GenFeature genFeature);
  String getLocalFeatureIndex(GenFeature genFeature);
  String getFlagsField(GenFeature genFeature);
  int getFlagIndex(GenFeature genFeature);
  String getESetFlagsField(GenFeature genFeature);
  int getESetFlagIndex(GenFeature genFeature);

  String getFeatureCountID();
  String getQualifiedFeatureCountID();
  String getFeatureCountValue();
  int getFeatureCount();

  boolean isEObject();
  boolean isEObjectExtension();
  String getCastFromEObject();
  boolean isAbstract();
  String getAbstractFlag();
  boolean isInterface();
  String getInterfaceFlag();

  /**
   * This indicates that there is already an existing interface for this
   * class or interface, so none will be generated.  Any other generated
   * that wishes to refer to its interface should use the value from 
   * getQualifiedInterfaceName() or getImportedInterfaceName().
   */
  boolean isExternalInterface();

  boolean isMapEntry();
  GenFeature getMapEntryKeyFeature();
  GenFeature getMapEntryValueFeature();

  List/*of GenClass*/ getImplementedGenClasses();
  List/*of GenFeature*/ getImplementedGenFeatures();
  List/*of GenOperation*/ getImplementedGenOperations();

  // Returns whether this class implements any of the given features.
  public boolean implementsAny(Collection genFeatures);

  List/*of GenClass*/ getExtendedGenClasses();
  List/*of GenFeature*/ getExtendedGenFeatures();
  List/*of GenOperation*/ getExtendedGenOperations();

  List/*of GenFeature*/ getDeclaredFieldGenFeatures();

  List/*of GenFeature*/ getDeclaredGenFeatures();
  List/*of GenOperation*/ getDeclaredGenOperations();

  List/*of GenFeature*/ getFlagGenFeatures();
  List/*of GenFeature*/ getFlagGenFeatures(String staticDefaultValue);

  List/*of GenFeature*/ getESetGenFeatures();
  List/*of GenFeature*/ getEInverseAddGenFeatures();
  List/*of GenFeature*/ getEInverseRemoveGenFeatures();
  List/*of GenFeature*/ getEBasicRemoveFromContainerGenFeatures();
  List/*of GenFeature*/ getToStringGenFeatures();

  List/*of GenClass*/ getMixinGenClasses();
  List/*of GenFeature*/ getMixinGenFeatures();
  List/*of GenOperation*/ getMixinGenOperations();

  void initialize(EClass eClass);
  //
  // EMFEdit generation
  //

  String getProviderClassName();
  String getQualifiedProviderClassName();
  String getImportedProviderClassName();
  boolean isProviderSingleton();

  String getProviderBaseClassName();
  List/*of GenClass*/ getProviderImplementedGenClasses();

  List/*of GenFeature*/ getLabelFeatureCandidates();
  List/*of GenFeature*/ getPropertyFeatures();

  List/*of GenFeature*/ getNotifyFeatures();
  List/*of GenFeature*/ getLabelNotifyFeatures();
  List/*of GenFeature*/ getContentNotifyFeatures();
  List/*of GenFeature*/ getLabelAndContentNotifyFeatures();

  List/*of GenFeature*/ getChildrenFeatures();
  List/*of GenFeature*/ getAllChildrenFeatures();

  List/*of GenFeature*/ getCreateChildFeatures();
  List/*of GenFeature*/ getAllCreateChildFeatures();
  List/*of GenFeature*/ getCrossPackageCreateChildFeatures();
  List/*of GenFeature*/ getSharedClassCreateChildFeatures();
  boolean hasFeatureMapCreateChildFeatures();

  List/*of GenClass*/ getChildrenClasses(GenFeature genFeature);
  List/*of GenClass*/ getCrossPackageChildrenClasses(GenFeature genFeature);

  String getItemProviderAdapterFactoryClassName();

  String getTestCaseClassName();
  String getQualifiedTestCaseClassName();
  String getImportedTestCaseClassName();
  
  String getModelInfo();

  boolean reconcile(GenClass oldGenClassVersion);

  List/*of GenOperation*/ getInvariantOperations();
  GenOperation getInvariantOperation(String constraint);

  boolean isDocumentRoot();
  GenFeature getMixedGenFeature();
  
  String getListConstructor(GenFeature genFeature);

  boolean isModelRoot();

  boolean isFlag(GenFeature genFeature);
  boolean isESetFlag(GenFeature genFeature);

  boolean isField(GenFeature genFeature);
  boolean isESetField(GenFeature genFeature);  

  boolean hasTests();

  String getEVirtualValuesField();
  List/*of String*/ getEVirtualIndexBitFields(List eVirtualIndexBitFields);
  List/*of String*/ getAllEVirtualIndexBitFields(List allEVirtualIndexBitFields);
}
