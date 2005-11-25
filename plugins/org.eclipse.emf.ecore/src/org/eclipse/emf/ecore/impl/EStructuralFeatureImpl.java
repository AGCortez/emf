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
 * $Id: EStructuralFeatureImpl.java,v 1.17 2005/11/25 15:36:20 emerks Exp $
 */
package org.eclipse.emf.ecore.impl;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.NotificationChainImpl;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EStructural Feature</b></em>'.
 * @extends EStructuralFeature.Internal, BasicExtendedMetaData.EStructuralFeatureExtendedMetaData.Holder
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#isVolatile <em>Volatile</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#isUnsettable <em>Unsettable</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EStructuralFeatureImpl#getEContainingClass <em>EContaining Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EStructuralFeatureImpl extends ETypedElementImpl implements EStructuralFeature, EStructuralFeature.Internal, BasicExtendedMetaData.EStructuralFeatureExtendedMetaData.Holder
{
  protected int featureID = -1;
  protected Class containerClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EStructuralFeatureImpl()
  {
    super();
    eFlags |= CHANGEABLE_EFLAG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return EcorePackage.Literals.ESTRUCTURAL_FEATURE;
  }

  protected Object defaultValue = null;
  protected EFactory defaultValueFactory = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public Object getDefaultValue()
  {
    EClassifier eType = getEType();
    String literal = getDefaultValueLiteral();

    if (literal == null && eType != null)
    {
      return eType.getDefaultValue();
    }
    else if (eType instanceof EDataType)
    {
      EFactory factory = eType.getEPackage().getEFactoryInstance();
      if (factory != defaultValueFactory)
      {
        defaultValueFactory = factory;
        EDataType eDataType = (EDataType)eType;
        if (eDataType.isSerializable())
        {
          defaultValue = factory.createFromString((EDataType)eType, literal);
        }
      }
      return defaultValue;
    }
    return null;
  }

  public void setDefaultValue(Object newDefaultValue)
  {
    EClassifier eType = getEType();
    if (eType instanceof EDataType)
    {
      EFactory factory = eType.getEPackage().getEFactoryInstance();
      String literal = factory.convertToString((EDataType)eType, newDefaultValue);
      defaultValueFactory = null;
      setDefaultValueLiteralGen(literal);
      return;
    }
    throw new IllegalStateException("Cannot serialize value to object without an EDataType eType");
  }

  public void setDefaultValueLiteral(String newDefaultValueLiteral)
  {
    defaultValueFactory = null;
    setDefaultValueLiteralGen(newDefaultValueLiteral);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultValueLiteralGen(String newDefaultValueLiteral)
  {
    String oldDefaultValueLiteral = defaultValueLiteral;
    defaultValueLiteral = newDefaultValueLiteral;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL, oldDefaultValueLiteral, defaultValueLiteral));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnsettable()
  {
    return (eFlags & UNSETTABLE_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnsettable(boolean newUnsettable)
  {
    boolean oldUnsettable = (eFlags & UNSETTABLE_EFLAG) != 0;
    if (newUnsettable) eFlags |= UNSETTABLE_EFLAG; else eFlags &= ~UNSETTABLE_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE, oldUnsettable, newUnsettable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDerived()
  {
    return (eFlags & DERIVED_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerived(boolean newDerived)
  {
    boolean oldDerived = (eFlags & DERIVED_EFLAG) != 0;
    if (newDerived) eFlags |= DERIVED_EFLAG; else eFlags &= ~DERIVED_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__DERIVED, oldDerived, newDerived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEContainingClass()
  {
    if (eContainerFeatureID != EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS) return null;
    return (EClass)eContainer();
  }

  /**
   * The default value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isChangeable()
   * @generated
   * @ordered
   */
  protected static final boolean CHANGEABLE_EDEFAULT = true;

  /**
   * The flag representing the value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isChangeable()
   * @generated
   * @ordered
   */
  protected static final int CHANGEABLE_EFLAG = 1 << 10;

  /**
   * The default value of the '{@link #isVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVolatile()
   * @generated
   * @ordered
   */
  protected static final boolean VOLATILE_EDEFAULT = false;

  /**
   * The flag representing the value of the '{@link #isVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVolatile()
   * @generated
   * @ordered
   */
  protected static final int VOLATILE_EFLAG = 1 << 11;

  /**
   * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected static final boolean TRANSIENT_EDEFAULT = false;

  /**
   * The flag representing the value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected static final int TRANSIENT_EFLAG = 1 << 12;

  /**
   * The default value of the '{@link #getDefaultValueLiteral() <em>Default Value Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultValueLiteral()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_VALUE_LITERAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefaultValueLiteral() <em>Default Value Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultValueLiteral()
   * @generated
   * @ordered
   */
  protected String defaultValueLiteral = DEFAULT_VALUE_LITERAL_EDEFAULT;

  /**
   * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultValue()
   * @generated
   * @ordered
   */
  protected static final Object DEFAULT_VALUE_EDEFAULT = null;

  /**
   * The default value of the '{@link #isUnsettable() <em>Unsettable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnsettable()
   * @generated
   * @ordered
   */
  protected static final boolean UNSETTABLE_EDEFAULT = false;

  /**
   * The flag representing the value of the '{@link #isUnsettable() <em>Unsettable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnsettable()
   * @generated
   * @ordered
   */
  protected static final int UNSETTABLE_EFLAG = 1 << 13;

  /**
   * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final boolean DERIVED_EDEFAULT = false;

  /**
   * The flag representing the value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final int DERIVED_EFLAG = 1 << 14;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTransient()
  {
    return (eFlags & TRANSIENT_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransient(boolean newTransient)
  {
    boolean oldTransient = (eFlags & TRANSIENT_EFLAG) != 0;
    if (newTransient) eFlags |= TRANSIENT_EFLAG; else eFlags &= ~TRANSIENT_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT, oldTransient, newTransient));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVolatile()
  {
    return (eFlags & VOLATILE_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolatile(boolean newVolatile)
  {
    boolean oldVolatile = (eFlags & VOLATILE_EFLAG) != 0;
    if (newVolatile) eFlags |= VOLATILE_EFLAG; else eFlags &= ~VOLATILE_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE, oldVolatile, newVolatile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isChangeable()
  {
    return (eFlags & CHANGEABLE_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeable(boolean newChangeable)
  {
    boolean oldChangeable = (eFlags & CHANGEABLE_EFLAG) != 0;
    if (newChangeable) eFlags |= CHANGEABLE_EFLAG; else eFlags &= ~CHANGEABLE_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE, oldChangeable, newChangeable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultValueLiteral()
  {
    return defaultValueLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (changeable: ");
    result.append((eFlags & CHANGEABLE_EFLAG) != 0);
    result.append(", volatile: ");
    result.append((eFlags & VOLATILE_EFLAG) != 0);
    result.append(", transient: ");
    result.append((eFlags & TRANSIENT_EFLAG) != 0);
    result.append(", defaultValueLiteral: ");
    result.append(defaultValueLiteral);
    result.append(", unsettable: ");
    result.append((eFlags & UNSETTABLE_EFLAG) != 0);
    result.append(", derived: ");
    result.append((eFlags & DERIVED_EFLAG) != 0);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated modifiable
   */
  public int getFeatureID()
  {
    return featureID;
  }

  public void setFeatureID(int featureID)
  {
    this.featureID = featureID;
  }

  /**
   * @generated modifiable
   */
  public Class getContainerClass()
  {
    return containerClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
      case EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS, msgs);
    }
    return eDynamicInverseAdd(otherEnd, featureID, null, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
      case EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS:
        return eBasicSetContainer(null, EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS, msgs);
    }
    return eDynamicInverseRemove(otherEnd, featureID, null, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS:
        return eInternalContainer().eInverseRemove(this, EcorePackage.ECLASS__ESTRUCTURAL_FEATURES, EClass.class, msgs);
    }
    return eDynamicBasicRemoveFromContainer(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        return getEAnnotations();
      case EcorePackage.ESTRUCTURAL_FEATURE__NAME:
        return getName();
      case EcorePackage.ESTRUCTURAL_FEATURE__ORDERED:
        return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNIQUE:
        return isUnique() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__LOWER_BOUND:
        return new Integer(getLowerBound());
      case EcorePackage.ESTRUCTURAL_FEATURE__UPPER_BOUND:
        return new Integer(getUpperBound());
      case EcorePackage.ESTRUCTURAL_FEATURE__MANY:
        return isMany() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__REQUIRED:
        return isRequired() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__ETYPE:
        if (resolve) return getEType();
        return basicGetEType();
      case EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE:
        return isChangeable() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE:
        return isVolatile() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT:
        return isTransient() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL:
        return getDefaultValueLiteral();
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE:
        return getDefaultValue();
      case EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE:
        return isUnsettable() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__DERIVED:
        return isDerived() ? Boolean.TRUE : Boolean.FALSE;
      case EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS:
        return getEContainingClass();
    }
    return eDynamicGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        getEAnnotations().clear();
        getEAnnotations().addAll((Collection)newValue);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__NAME:
        setName((String)newValue);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__ORDERED:
        setOrdered(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNIQUE:
        setUnique(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__LOWER_BOUND:
        setLowerBound(((Integer)newValue).intValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UPPER_BOUND:
        setUpperBound(((Integer)newValue).intValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__ETYPE:
        setEType((EClassifier)newValue);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE:
        setChangeable(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE:
        setVolatile(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT:
        setTransient(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL:
        setDefaultValueLiteral((String)newValue);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE:
        setUnsettable(((Boolean)newValue).booleanValue());
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__DERIVED:
        setDerived(((Boolean)newValue).booleanValue());
        return;
    }
    eDynamicSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        getEAnnotations().clear();
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__ETYPE:
        setEType((EClassifier)null);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE:
        setChangeable(CHANGEABLE_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE:
        setVolatile(VOLATILE_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT:
        setTransient(TRANSIENT_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL:
        setDefaultValueLiteral(DEFAULT_VALUE_LITERAL_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE:
        setUnsettable(UNSETTABLE_EDEFAULT);
        return;
      case EcorePackage.ESTRUCTURAL_FEATURE__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
    }
    eDynamicUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS:
        return eAnnotations != null && !eAnnotations.isEmpty();
      case EcorePackage.ESTRUCTURAL_FEATURE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EcorePackage.ESTRUCTURAL_FEATURE__ORDERED:
        return ((eFlags & ORDERED_EFLAG) != 0) != ORDERED_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__UNIQUE:
        return ((eFlags & UNIQUE_EFLAG) != 0) != UNIQUE_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__MANY:
        return isMany() != MANY_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__REQUIRED:
        return isRequired() != REQUIRED_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__ETYPE:
        return eType != null;
      case EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE:
        return ((eFlags & CHANGEABLE_EFLAG) != 0) != CHANGEABLE_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE:
        return ((eFlags & VOLATILE_EFLAG) != 0) != VOLATILE_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT:
        return ((eFlags & TRANSIENT_EFLAG) != 0) != TRANSIENT_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL:
        return DEFAULT_VALUE_LITERAL_EDEFAULT == null ? defaultValueLiteral != null : !DEFAULT_VALUE_LITERAL_EDEFAULT.equals(defaultValueLiteral);
      case EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE:
        return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
      case EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE:
        return ((eFlags & UNSETTABLE_EFLAG) != 0) != UNSETTABLE_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__DERIVED:
        return ((eFlags & DERIVED_EFLAG) != 0) != DERIVED_EDEFAULT;
      case EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS:
        return getEContainingClass() != null;
    }
    return eDynamicIsSet(featureID);
  }

  public void setContainerClass(Class containerClass)
  {
    this.containerClass = containerClass;
  }

  protected boolean isResolveProxies()
  {
    return false;
  }

  protected boolean isContainer()
  {
    return false;
  }

  protected boolean isContainment()
  {
    return false;
  }

  protected EReference getEOpposite()
  {
    return null;
  }

  protected EStructuralFeature.Internal.SettingDelegate settingDelegate;

  public EStructuralFeature.Internal.SettingDelegate getSettingDelegate()
  {
    if (settingDelegate == null)
    {
      EClass eClass  = getEContainingClass();
      eClass.getFeatureCount();
      EReference eOpposite = getEOpposite();
      if (eOpposite != null)
      {
        eOpposite.getEContainingClass().getFeatureCount();
      }

      EClassifier eType = getEType();
      Class dataClass = EcoreUtil.wrapperClassFor(eType.getInstanceClass());
      Object defaultValue = getDefaultValue();
      Object intrinsicDefaultValue = eType.getDefaultValue();

      EStructuralFeature featureMapFeature;
      if (isDerived() && 
            (((featureMapFeature = ExtendedMetaData.INSTANCE.getMixedFeature(eClass)) != null && 
               featureMapFeature != this) ||
              ((featureMapFeature = ExtendedMetaData.INSTANCE.getGroup(this)) != null)))
      {
        settingDelegate = new InternalSettingDelegateFeatureMapDelegator(this, featureMapFeature);
      }
      else if (isMany())
      {
        if (isContainment())
        {
          if (eOpposite == null)
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_UNSETTABLE_DYNAMIC_RESOLVE, this);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_UNSETTABLE_DYNAMIC, this);
                }
              }
              else
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.CONTAINMENT_UNSETTABLE_RESOLVE, dataClass, this);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.CONTAINMENT_UNSETTABLE, dataClass, this);
                }
              }
            }
            else
            {
              if (dataClass == null)
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_DYNAMIC, this);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_DYNAMIC_RESOLVE, this);
                }
              }
              else if (dataClass == Map.Entry.class)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EMAP, BasicEMap.Entry.class, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.CONTAINMENT, dataClass, this);
              }
            }
          }
          else
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC_RESOLVE, this, eOpposite);
                }   
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC, this, eOpposite);
                }   
              }
              else
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_UNSETTABLE_RESOLVE, dataClass, this, eOpposite);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_UNSETTABLE, dataClass, this, eOpposite);
                }
              }
            }
            else
            {
              if (dataClass == null)
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_DYNAMIC_RESOLVE, this, eOpposite);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_DYNAMIC, this, eOpposite);
                }
              }
              
              else
              {
                if (isResolveProxies())
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE_RESOLVE, dataClass, this, eOpposite);
                }
                else
                {
                  settingDelegate = 
                    new InternalSettingDelegateMany
                      (InternalSettingDelegateMany.CONTAINMENT_INVERSE, dataClass, this, eOpposite);
                }
              }
            }
          }
        }
        else if (eType instanceof EDataType)
        {
          if (dataClass == FeatureMap.Entry.class)
          {
            settingDelegate = createFeatureMapSettingDelegate();
          }
          else if (isUnique())
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNIQUE_UNSETTABLE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNIQUE_UNSETTABLE, dataClass, this);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNIQUE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNIQUE, dataClass, this);
              }
            }
          }
          else
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNSETTABLE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_UNSETTABLE, dataClass, this);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.DATA, dataClass, this);
              }
            }
          }
        }
        else if (eOpposite == null)
        {
          if (isResolveProxies())
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_RESOLVE_UNSETTABLE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_RESOLVE_UNSETTABLE, dataClass, this);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_RESOLVE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_RESOLVE, dataClass, this);
              }
            }
          }
          else
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_UNSETTABLE_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_UNSETTABLE, dataClass, this);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT_DYNAMIC, this);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.EOBJECT, dataClass, this);
              }
            }
          }
        }
        else if (eOpposite.isMany())
        {
          if (isResolveProxies())
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_RESOLVE_UNSETTABLE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_RESOLVE_UNSETTABLE, dataClass, this, eOpposite);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_RESOLVE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_RESOLVE, dataClass, this, eOpposite);
              }
            }
          }
          else
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_UNSETTABLE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_UNSETTABLE, dataClass, this, eOpposite);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.MANY_INVERSE, dataClass, this, eOpposite);
              }
            }
          }
        }
        else 
        {
          if (isResolveProxies())
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_RESOLVE_UNSETTABLE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_RESOLVE_UNSETTABLE, dataClass, this, eOpposite);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_RESOLVE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_RESOLVE, dataClass, this, eOpposite);
              }
            }
          }
          else
          {
            if (isUnsettable())
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_UNSETTABLE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_UNSETTABLE, dataClass, this, eOpposite);
              }
            }
            else
            {
              if (dataClass == null)
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE_DYNAMIC, this, eOpposite);
              }
              else
              {
                settingDelegate = 
                  new InternalSettingDelegateMany
                    (InternalSettingDelegateMany.INVERSE, dataClass, this, eOpposite);
              }
            }
          }
        }
      }
      else if (isContainer())
      {
        if (isResolveProxies())
        {
          settingDelegate = new InternalSettingDelegateSingleContainerResolving((EClass)eType, this, eOpposite);
        }
        else
        {
          settingDelegate = new InternalSettingDelegateSingleContainer((EClass)eType, this, eOpposite);
        }
      }
      else if (eType instanceof EDataType)
      {
        if (dataClass == FeatureMap.Entry.class)
        {
          settingDelegate = createFeatureMapSettingDelegate();
        }
        else if (isUnsettable())
        {
          if (dataClass == null)
          {
            settingDelegate = new InternalSettingDelegateSingleDataUnsettableDynamic((EDataType)eType, defaultValue, intrinsicDefaultValue, this);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleDataUnsettableStatic(dataClass, defaultValue, intrinsicDefaultValue, this);
          }
        }
        else
        {
          if (dataClass == null)
          {
            settingDelegate = new InternalSettingDelegateSingleDataDynamic((EDataType)eType, defaultValue, intrinsicDefaultValue, this);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleDataStatic(dataClass, defaultValue, intrinsicDefaultValue, this);
          }
        }
      }
      else if (isContainment())
      {
        if (eOpposite == null)
        {
          if (isUnsettable())
          {
            if (isResolveProxies())
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentUnsettableResolving((EClass)eType, this);
            }
            else
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentUnsettable((EClass)eType, this);
            }
          }
          else
          {
            if (isResolveProxies())
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentResolving((EClass)eType, this);
            }
            else
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainment((EClass)eType, this);
            }
          }
        }
        else
        {
          if (isUnsettable())
          {
            if (isResolveProxies())
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettableResolving((EClass)eType, this, eOpposite);
            }
            else
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettable((EClass)eType, this, eOpposite);
            }
          }
          else
          {
            if (isResolveProxies())
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentWithInverseResolving((EClass)eType, this, eOpposite);
            }
            else
            {
              settingDelegate = new InternalSettingDelegateSingleEObjectContainmentWithInverse((EClass)eType, this, eOpposite);
            }
          }
        }
      }
      else if (isResolveProxies())
      {
        if (eOpposite == null)
        {
          if (isUnsettable())
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectResolvingUnsettable((EClass)eType, this);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectResolving((EClass)eType, this);
          }
        }
        else
        {
          if (isUnsettable())
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectResolvingWithInverseUnsettable((EClass)eType, this, eOpposite);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectResolvingWithInverse((EClass)eType, this, eOpposite);
          }
        }
      }
      else 
      {
        if (eOpposite == null)
        {
          if (isUnsettable())
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectUnsettable((EClass)eType, this);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleEObject((EClass)eType, this);
          }
        }
        else
        {
          if (isUnsettable())
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectWithInverseUnsettable((EClass)eType, this, eOpposite);
          }
          else
          {
            settingDelegate = new InternalSettingDelegateSingleEObjectWithInverse((EClass)eType, this, eOpposite);
          }
        }
      }
    }

    return settingDelegate;
  }

  protected EStructuralFeature.Internal.SettingDelegate createFeatureMapSettingDelegate()
  {
    return new InternalSettingDelegateMany(InternalSettingDelegateMany.FEATURE_MAP, this);
  }

  public void setSettingDelegate(EStructuralFeature.Internal.SettingDelegate settingDelegate)
  {
    this.settingDelegate = settingDelegate;
  }

  public static class InternalSettingDelegateFeatureMapDelegator implements EStructuralFeature.Internal.SettingDelegate
  {
    protected EStructuralFeature feature;
    protected EStructuralFeature featureMapFeature;

    public InternalSettingDelegateFeatureMapDelegator(EStructuralFeature feature, EStructuralFeature featureMapFeature)
    {
      this.feature = feature;
      this.featureMapFeature = featureMapFeature;
    }

    protected EStructuralFeature.Setting createDynamicSetting(InternalEObject owner)
    {
      return ((FeatureMap.Internal)owner.eGet(featureMapFeature)).setting(feature);
    }

    public EStructuralFeature.Setting dynamicSetting(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      return createDynamicSetting(owner);
    }

    public Object dynamicGet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, boolean resolve, boolean coreType)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      return featureMap.setting(feature).get(resolve);
    }

    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      featureMap.setting(feature).set(newValue);
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      featureMap.setting(feature).unset();
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      return featureMap.setting(feature).isSet();
    }

    public NotificationChain dynamicInverseAdd
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      return featureMap.basicAdd(feature, otherEnd, notifications);
    }

    public NotificationChain dynamicInverseRemove
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)owner.eGet(featureMapFeature);
      return featureMap.basicRemove(feature, otherEnd, notifications);
    }
  }

  public static class InternalSettingDelegateMany implements EStructuralFeature.Internal.SettingDelegate
  {
    public static final int CONTAINMENT_UNSETTABLE_DYNAMIC = 0;
    public static final int CONTAINMENT_UNSETTABLE = 1;
    public static final int CONTAINMENT_DYNAMIC = 2;
    public static final int CONTAINMENT = 3;
    public static final int CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC = 4;
    public static final int CONTAINMENT_INVERSE_UNSETTABLE = 5;
    public static final int CONTAINMENT_INVERSE_DYNAMIC = 6;
    public static final int CONTAINMENT_INVERSE = 7;
    public static final int DATA_UNIQUE_UNSETTABLE_DYNAMIC = 8;
    public static final int DATA_UNIQUE_UNSETTABLE = 9;
    public static final int DATA_UNIQUE_DYNAMIC = 10;
    public static final int DATA_UNIQUE = 11;
    public static final int DATA_UNSETTABLE_DYNAMIC = 12;
    public static final int DATA_UNSETTABLE = 13;
    public static final int DATA_DYNAMIC = 14;
    public static final int DATA = 15;
    public static final int EOBJECT_RESOLVE_UNSETTABLE_DYNAMIC = 16;
    public static final int EOBJECT_RESOLVE_UNSETTABLE = 17;
    public static final int EOBJECT_RESOLVE_DYNAMIC = 18;
    public static final int EOBJECT_RESOLVE = 19;
    public static final int EOBJECT_UNSETTABLE_DYNAMIC = 20;
    public static final int EOBJECT_UNSETTABLE = 21;
    public static final int EOBJECT_DYNAMIC = 22;
    public static final int EOBJECT = 23;
    public static final int MANY_INVERSE_RESOLVE_UNSETTABLE_DYNAMIC = 24;
    public static final int MANY_INVERSE_RESOLVE_UNSETTABLE = 25;
    public static final int MANY_INVERSE_RESOLVE_DYNAMIC = 26;
    public static final int MANY_INVERSE_RESOLVE = 27;
    public static final int MANY_INVERSE_UNSETTABLE_DYNAMIC = 28;
    public static final int MANY_INVERSE_UNSETTABLE = 29;
    public static final int MANY_INVERSE_DYNAMIC = 30;
    public static final int MANY_INVERSE = 31;
    public static final int INVERSE_RESOLVE_UNSETTABLE_DYNAMIC = 32;
    public static final int INVERSE_RESOLVE_UNSETTABLE = 33;
    public static final int INVERSE_RESOLVE_DYNAMIC = 34;
    public static final int INVERSE_RESOLVE = 35;
    public static final int INVERSE_UNSETTABLE_DYNAMIC = 36;
    public static final int INVERSE_UNSETTABLE = 37;
    public static final int INVERSE_DYNAMIC = 38;
    public static final int INVERSE = 39;
    public static final int FEATURE_MAP = 40;
    public static final int EMAP = 41;
    public static final int CONTAINMENT_UNSETTABLE_DYNAMIC_RESOLVE = 42;
    public static final int CONTAINMENT_UNSETTABLE_RESOLVE = 43;
    public static final int CONTAINMENT_DYNAMIC_RESOLVE = 44;
    public static final int CONTAINMENT_RESOLVE = 45;
    public static final int CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC_RESOLVE = 46;
    public static final int CONTAINMENT_INVERSE_UNSETTABLE_RESOLVE = 47;
    public static final int CONTAINMENT_INVERSE_DYNAMIC_RESOLVE = 48;
    public static final int CONTAINMENT_INVERSE_RESOLVE = 49;

    protected int style;
    protected int dynamicKind;
    protected Class dataClass;
    protected EStructuralFeature feature;
    protected EReference inverseFeature;

    public InternalSettingDelegateMany(int style, Class dataClass, EStructuralFeature feature)
    {
      this.style = style;
      this.dataClass = dataClass;
      this.feature = feature;
    }

    public InternalSettingDelegateMany(int style, EStructuralFeature feature)
    {
      this.style = style;
      this.dataClass = Object.class;
      this.dynamicKind = EcoreEList.Generic.kind(feature);
      this.feature = feature;
    }

    public InternalSettingDelegateMany(int style, Class dataClass, EStructuralFeature feature, EReference inverseFeature)
    {
      this.style = style;
      this.dataClass = dataClass;
      this.feature = feature;
      this.inverseFeature = inverseFeature;
    }

    public InternalSettingDelegateMany(int style, EStructuralFeature feature, EReference inverseFeature)
    {
      this.style = style;
      this.dataClass = Object.class;
      this.dynamicKind = EcoreEList.Generic.kind(feature);
      this.feature = feature;
      this.inverseFeature = inverseFeature;
    }

    protected EStructuralFeature.Setting createDynamicSetting(InternalEObject owner)
    {
      switch (style)
      {
        case CONTAINMENT_UNSETTABLE_DYNAMIC:
        case CONTAINMENT_DYNAMIC:
        case CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC:
        case CONTAINMENT_INVERSE_DYNAMIC:
        case CONTAINMENT_UNSETTABLE_DYNAMIC_RESOLVE:
        case CONTAINMENT_DYNAMIC_RESOLVE:
        case CONTAINMENT_INVERSE_UNSETTABLE_DYNAMIC_RESOLVE:
        case CONTAINMENT_INVERSE_DYNAMIC_RESOLVE:
        case DATA_UNIQUE_UNSETTABLE_DYNAMIC:
        case DATA_UNIQUE_DYNAMIC:
        case DATA_UNSETTABLE_DYNAMIC:
        case DATA_DYNAMIC:
        case EOBJECT_RESOLVE_UNSETTABLE_DYNAMIC:
        case EOBJECT_RESOLVE_DYNAMIC:
        case EOBJECT_UNSETTABLE_DYNAMIC:
        case EOBJECT_DYNAMIC:
        case MANY_INVERSE_RESOLVE_UNSETTABLE_DYNAMIC:
        case MANY_INVERSE_RESOLVE_DYNAMIC:
        case MANY_INVERSE_UNSETTABLE_DYNAMIC:
        case MANY_INVERSE_DYNAMIC:
        case INVERSE_RESOLVE_UNSETTABLE_DYNAMIC:
        case INVERSE_RESOLVE_DYNAMIC:
        case INVERSE_UNSETTABLE_DYNAMIC:
        case INVERSE_DYNAMIC:
          return new EcoreEList.Dynamic(dynamicKind, dataClass, owner, feature);
        case CONTAINMENT_UNSETTABLE:
          return new EObjectContainmentEList.Unsettable(dataClass, owner, feature.getFeatureID());
        case CONTAINMENT_UNSETTABLE_RESOLVE:
          return new EObjectContainmentEList.Unsettable.Resolving(dataClass, owner, feature.getFeatureID());
        case CONTAINMENT:
          return new EObjectContainmentEList(dataClass, owner, feature.getFeatureID());
        case CONTAINMENT_RESOLVE:
          return new EObjectContainmentEList.Resolving(dataClass, owner, feature.getFeatureID());
        case EMAP:
          return new EcoreEMap((EClass)feature.getEType(), dataClass, owner, feature.getFeatureID());
        case CONTAINMENT_INVERSE_UNSETTABLE:
          return new EObjectContainmentWithInverseEList.Unsettable(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case CONTAINMENT_INVERSE_UNSETTABLE_RESOLVE:
          return new EObjectContainmentWithInverseEList.Unsettable.Resolving(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case CONTAINMENT_INVERSE:
          return new EObjectContainmentWithInverseEList(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case CONTAINMENT_INVERSE_RESOLVE:
          return new EObjectContainmentWithInverseEList.Resolving(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case DATA_UNIQUE_UNSETTABLE:
          return new EDataTypeUniqueEList.Unsettable(dataClass, owner, feature.getFeatureID());
        case DATA_UNIQUE:
          return new EDataTypeUniqueEList(dataClass, owner, feature.getFeatureID());
        case DATA_UNSETTABLE:
          return new EDataTypeEList.Unsettable(dataClass, owner, feature.getFeatureID());
        case DATA:
          return new EDataTypeEList(dataClass, owner, feature.getFeatureID());
        case EOBJECT_RESOLVE_UNSETTABLE:
          return new EObjectResolvingEList.Unsettable(dataClass, owner, feature.getFeatureID());
        case EOBJECT_RESOLVE:
          return new EObjectResolvingEList(dataClass, owner, feature.getFeatureID());
        case EOBJECT_UNSETTABLE:
          return new EObjectEList.Unsettable(dataClass, owner, feature.getFeatureID());
        case EOBJECT:
          return new EObjectEList(dataClass, owner, feature.getFeatureID());
        case MANY_INVERSE_RESOLVE_UNSETTABLE:
          return new EObjectWithInverseResolvingEList.Unsettable.ManyInverse(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case MANY_INVERSE_RESOLVE:
          return new EObjectWithInverseResolvingEList.ManyInverse(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case MANY_INVERSE_UNSETTABLE:
          return new EObjectWithInverseEList.Unsettable.ManyInverse(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case MANY_INVERSE:
          return new EObjectWithInverseEList.ManyInverse(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case INVERSE_RESOLVE_UNSETTABLE:
          return new EObjectWithInverseResolvingEList.Unsettable(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case INVERSE_RESOLVE:
          return new EObjectWithInverseResolvingEList(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case INVERSE_UNSETTABLE:
          return new EObjectWithInverseEList.Unsettable(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case INVERSE:
          return new EObjectWithInverseEList(dataClass, owner, feature.getFeatureID(), inverseFeature.getFeatureID());
        case FEATURE_MAP:
          return new BasicFeatureMap(owner, feature.getFeatureID());
        default:
          throw new RuntimeException("Unknown feature style: " + style);
      }
    }

    public EStructuralFeature.Setting dynamicSetting(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        settings.dynamicSet(index, setting = createDynamicSetting(owner));
      }

      return
        setting instanceof EStructuralFeature.Setting ?
          (EStructuralFeature.Setting)setting :
          new SettingMany(owner, feature, (List)settings.dynamicGet(index));
    }

    public Object dynamicGet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, boolean resolve, boolean coreType)
    {
      Object result = settings.dynamicGet(index);
      if (result == null)
      {
        settings.dynamicSet(index, result = createDynamicSetting(owner));
      }
      if (!coreType)
      {
        switch (style)
        {
          case EMAP : return ((EMap)result).map();
          case FEATURE_MAP : return ((FeatureMap.Internal)result).getWrapper();
        }
      }
      return result;
    }

    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)settings.dynamicGet(index);
      if (setting == null)
      {
        settings.dynamicSet(index, setting = createDynamicSetting(owner));
      }
      setting.set(newValue);
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)settings.dynamicGet(index);
      if (setting == null)
      {
        settings.dynamicSet(index, setting = createDynamicSetting(owner));
      }
      setting.unset();
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        return false;
      }
      else 
      {
        return ((EStructuralFeature.Setting)setting).isSet();
      }
    }

    public NotificationChain dynamicInverseAdd
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        settings.dynamicSet(index, setting = createDynamicSetting(owner));
      }
      return ((InternalEList)setting).basicAdd(otherEnd, notifications);
    }

    public NotificationChain dynamicInverseRemove
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      Object setting = settings.dynamicGet(index);
      if (setting != null)
      {
        notifications = ((InternalEList)setting).basicRemove(otherEnd, notifications);
      }
      return notifications;
    }
  }

  public static abstract class InternalSettingDelegateSingle implements EStructuralFeature.Internal.SettingDelegate
  {
    public static final Object NIL = EStructuralFeature.Internal.DynamicValueHolder.NIL;

    protected EStructuralFeature feature;

    public InternalSettingDelegateSingle(EStructuralFeature feature)
    {
      this.feature = feature;
    }

    public EStructuralFeature.Setting dynamicSetting(final InternalEObject owner, final EStructuralFeature.Internal.DynamicValueHolder settings, final int index)
    {
      return
        new EStructuralFeature.Setting()
        {
          public EObject getEObject()
          {
            return owner;
          }

          public EStructuralFeature getEStructuralFeature()
          {
            return feature;
          }

          public Object get(boolean resolve)
          {
            return dynamicGet(owner, settings, index, resolve, true);
          }

          public void set(Object newValue)
          {
            dynamicSet(owner, settings, index, newValue);
          }

          public boolean isSet()
          {
            return dynamicIsSet(owner, settings, index);
          }

          public void unset()
          {
            dynamicUnset(owner, settings, index);
          }
        };
    }

    public NotificationChain dynamicInverseAdd
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      throw new UnsupportedOperationException();
    }

    public NotificationChain dynamicInverseRemove
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      throw new UnsupportedOperationException();
    }
  }

  public static class InternalSettingDelegateSingleContainer extends InternalSettingDelegateSingle
  {
    protected EClass eClass;
    protected EReference inverseFeature;

    public InternalSettingDelegateSingleContainer(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(feature);
      this.eClass = eClass;
      this.inverseFeature = inverseFeature;
    }

    public Object dynamicGet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, boolean resolve, boolean coreType)
    {
      return owner.eContainmentFeature() == inverseFeature ? isResolveProxies() && resolve ? owner.eContainer() : owner.eInternalContainer() : null;
    }

    protected boolean isResolveProxies()
    {
      return false;
    }

    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      if (newValue != null && !eClass.isInstance(newValue))
      {
        throw 
          new ClassCastException
            ("The value of type '" + 
               (newValue instanceof EObject ? ((EObject)newValue).eClass().toString() : newValue.getClass().toString()) + 
               "' must be of type '" + eClass + "'");
      }

      EObject eContainer = owner.eInternalContainer();
      int featureID = owner.eClass().getFeatureID(feature);
      if (newValue != eContainer || (owner.eContainerFeatureID() != featureID && newValue != null))
      {
        if (EcoreUtil.isAncestor(owner, (EObject)newValue))
          throw new IllegalArgumentException("Recursive containment not allowed for " + owner.toString());

        NotificationChain notifications = null;
        if (eContainer != null)
        {
          notifications = owner.eBasicRemoveFromContainer(notifications);
        }

        InternalEObject internalEObject = (InternalEObject)newValue;
        if (newValue != null)
        {
          notifications = 
            internalEObject.eInverseAdd
              (owner, internalEObject.eClass().getFeatureID(inverseFeature), null, notifications);
        }

        notifications = owner.eBasicSetContainer(internalEObject, featureID, notifications);
        if (notifications != null) notifications.dispatch();
      }
      else
      {
        if (owner.eNotificationRequired())
          owner.eNotify(new ENotificationImpl(owner, Notification.SET, featureID, newValue, newValue));
      }
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      EObject eContainer = owner.eInternalContainer();
      if (eContainer != null)
      {
        NotificationChain notifications = null;
        if (eContainer != null)
        {
          notifications = owner.eBasicRemoveFromContainer(notifications);
        }
        int featureID = owner.eClass().getFeatureID(feature);
        notifications = owner.eBasicSetContainer(null, featureID, notifications);
        if (notifications != null) notifications.dispatch();
      }
      else
      {
        if (owner.eNotificationRequired())
          owner.eNotify(new ENotificationImpl(owner, Notification.SET, feature, null, null));
      }
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      int featureID = owner.eClass().getFeatureID(feature);
      return owner.eInternalContainer() != null && owner.eContainerFeatureID() == featureID;
    }

    public NotificationChain dynamicInverseAdd
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      if (owner.eInternalContainer() != null)
      {
        notifications = owner.eBasicRemoveFromContainer(notifications);
      }
      int featureID = owner.eClass().getFeatureID(feature);
      return owner.eBasicSetContainer(otherEnd, featureID, notifications);
    }

    public NotificationChain dynamicInverseRemove
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      if (owner.eInternalContainer() != null)
      {
        notifications = owner.eBasicRemoveFromContainer(notifications);
      }
      int featureID = owner.eClass().getFeatureID(feature);
      return owner.eBasicSetContainer(null, featureID, notifications);
    }
  }
  
  public static class InternalSettingDelegateSingleContainerResolving extends InternalSettingDelegateSingleContainer
  {
    public InternalSettingDelegateSingleContainerResolving(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }
    
    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleData extends InternalSettingDelegateSingle
  {
    protected Object defaultValue;
    protected Object intrinsicDefaultValue;

    public InternalSettingDelegateSingleData(Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(feature);
      this.defaultValue = defaultValue;
      this.intrinsicDefaultValue = intrinsicDefaultValue;
    }

    protected void validate(Object object)
    {
      throw new ClassCastException();
    }

    public Object dynamicGet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, boolean resolve, boolean coreType)
    {
      Object result = settings.dynamicGet(index);
      if (result == null)
      {
        return this.defaultValue;
      }
      else if (result == NIL)
      {
        return null;
      }
      else
      {
        return result;
      }
    }

    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      if (owner.eNotificationRequired())
      {
        Object oldValue = dynamicGet(owner, settings, index, false, true);

        if (newValue == null)
        {
          if (intrinsicDefaultValue != null)
          {
            settings.dynamicSet(index, null);
            newValue = defaultValue;
          }
          else if (defaultValue != null)
          {
            settings.dynamicSet(index, NIL);
          }
          else
          {
            settings.dynamicSet(index, null);
          }
        }
        else
        {
          validate(newValue);
          settings.dynamicSet(index, newValue);
        }

        owner.eNotify
          (new ENotificationImpl
             (owner, 
              Notification.SET, 
              feature, 
              oldValue, 
              newValue));
      }
      else
      {
        if (newValue == null)
        {
          if (intrinsicDefaultValue != null)
          {
            settings.dynamicSet(index, null);
          }
          else if (defaultValue != null)
          {
            settings.dynamicSet(index, NIL);
          }
          else
          {
            settings.dynamicSet(index, null);
          }
        }
        else
        {
          validate(newValue);
          settings.dynamicSet(index, newValue);
        }
      }
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      if (owner.eNotificationRequired())
      {
        Object oldValue = dynamicGet(owner, settings, index, false, true);
        settings.dynamicUnset(index);
        owner.eNotify
          (new ENotificationImpl
             (owner, Notification.SET, feature, oldValue, this.defaultValue));
      }
      else
      {
        settings.dynamicUnset(index);
      }
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        return false;
      }
      else if (setting == NIL)
      {
        return true;
      }
      else
      {
        return !setting.equals(this.defaultValue);
      }
    }
  }

  public static class InternalSettingDelegateSingleDataDynamic extends InternalSettingDelegateSingleData
  {
    protected EDataType eDataType;

    public InternalSettingDelegateSingleDataDynamic(EDataType eDataType, Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(defaultValue, intrinsicDefaultValue, feature);
      this.eDataType = eDataType;
    }

    protected void validate(Object object)
    {
      if (!eDataType.isInstance(object))
      {
        throw new ClassCastException("The value of type '" + object.getClass() + "' must be of type '" + eDataType + "'");
      }
    }
  }

  public static class InternalSettingDelegateSingleDataStatic extends InternalSettingDelegateSingleData
  {
    protected Class dataClass;

    public InternalSettingDelegateSingleDataStatic(Class dataClass, Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(defaultValue, intrinsicDefaultValue, feature);
      this.dataClass = dataClass;
    }

    protected void validate(Object object)
    {
      if (!dataClass.isInstance(object))
      {
        throw new ClassCastException("The value of type '" + object.getClass() + "' must be of type '" + dataClass + "'");
      }
    }
  }

  public static class InternalSettingDelegateSingleDataUnsettable extends InternalSettingDelegateSingleData
  {
    public InternalSettingDelegateSingleDataUnsettable(Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(defaultValue, intrinsicDefaultValue, feature);
    }

    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      if (owner.eNotificationRequired())
      {
        boolean oldIsSet = true;
        Object oldValue = settings.dynamicGet(index);
        if (oldValue == null)
        {
          oldIsSet = false;
          oldValue = this.defaultValue;
        }
        else if (oldValue == NIL)
        {
          oldValue = null;
        }

        if (newValue == null)
        {
          if (intrinsicDefaultValue != null)
          {
            settings.dynamicSet(index, null);
            newValue = this.defaultValue;
          }
          else
          {
            settings.dynamicSet(index, NIL);
          }
        }
        else
        {
          validate(newValue);
          settings.dynamicSet(index, newValue);
        }

        owner.eNotify
          (new ENotificationImpl
             (owner, 
              Notification.SET, 
              feature, 
              oldValue, 
              newValue,
              !oldIsSet));
      }
      else
      {
        if (newValue == null)
        {
          if (intrinsicDefaultValue != null)
          {
            settings.dynamicSet(index, null);
          }
          else 
          {
            settings.dynamicSet(index, NIL);
          }
        }
        else
        {
          validate(newValue);
          settings.dynamicSet(index, newValue);
        }
      }
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      if (owner.eNotificationRequired())
      {
        boolean oldIsSet = true;
        Object oldValue = settings.dynamicGet(index);
        if (oldValue == null)
        {
          oldIsSet = false;
          oldValue = this.defaultValue;
        }
        else if (oldValue == NIL)
        {
          oldValue = null;
        }
        settings.dynamicUnset(index);
        owner.eNotify
          (new ENotificationImpl
             (owner, Notification.UNSET, feature, oldValue, this.defaultValue, oldIsSet));
      }
      else
      {
        settings.dynamicUnset(index);
      }
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        return false;
      }
      else
      {
        return true;
      }
    }
  }

  public static class InternalSettingDelegateSingleDataUnsettableDynamic extends InternalSettingDelegateSingleDataUnsettable
  {
    protected EDataType eDataType;

    public InternalSettingDelegateSingleDataUnsettableDynamic(EDataType eDataType, Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(defaultValue, intrinsicDefaultValue, feature);
      this.eDataType = eDataType;
    }

    protected void validate(Object object)
    {
      if (!eDataType.isInstance(object))
      {
        throw new ClassCastException("The value of type '" + object.getClass() + "' must be of type '" + eDataType + "'");
      }
    }
  }

  public static class InternalSettingDelegateSingleDataUnsettableStatic extends InternalSettingDelegateSingleDataUnsettable
  {
    protected Class dataClass;

    public InternalSettingDelegateSingleDataUnsettableStatic(Class dataClass, Object defaultValue, Object intrinsicDefaultValue, EStructuralFeature feature)
    {
      super(defaultValue, intrinsicDefaultValue, feature);
      this.dataClass = dataClass;
    }

    protected void validate(Object object)
    {
      if (!dataClass.isInstance(object))
      {
        throw new ClassCastException("The value of type '" + object.getClass() + "' must be of type '" + dataClass + "'");
      }
    }
  }

  public static class InternalSettingDelegateSingleEObject extends InternalSettingDelegateSingle
  {
    protected EClass eClass;
    protected EReference inverseFeature;

    public InternalSettingDelegateSingleEObject(EClass eClass, EStructuralFeature feature)
    {
      super(feature);
      this.eClass = eClass;
    }

    public InternalSettingDelegateSingleEObject(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(feature);
      this.eClass = eClass;
      this.inverseFeature = inverseFeature;
    }

    protected boolean isUnsettable()
    {
      return false;
    }

    protected boolean hasInverse()
    {
      return false;
    }

    protected boolean isContainment()
    {
      return false;
    }

    protected boolean isResolveProxies()
    {
      return false;
    }

    public Object dynamicGet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, boolean resolve, boolean coreType)
    {
      Object result = settings.dynamicGet(index);
      if (isUnsettable() && result == NIL)
      {
        return null;
      }
      else if (isResolveProxies() && resolve && result != null)
      {
        InternalEObject oldEObject = (InternalEObject)result;
        if (oldEObject.eIsProxy())
        {
          EObject resolvedEObject = owner.eResolveProxy(oldEObject);
          if (oldEObject != resolvedEObject)
          {
            if (!eClass.isInstance(resolvedEObject))
            {
              throw new ClassCastException("The value of type '" + resolvedEObject.getClass() + "' must be of type '" + eClass + "'");
            }
            
            settings.dynamicSet(index, result = resolvedEObject);
            
            if (isContainment())
            {
              InternalEObject newEObject = (InternalEObject)resolvedEObject;
              NotificationChain notificationChain = dynamicInverseRemove(owner, settings, index, oldEObject, null);
              if (newEObject.eInternalContainer() == null)
              {
                notificationChain = dynamicInverseAdd(owner, settings, index, newEObject, notificationChain);
              }
              if (notificationChain != null)
              {
                notificationChain.dispatch();
              }
            }
            if (owner.eNotificationRequired())
            {
              owner.eNotify
                (new ENotificationImpl(owner, Notification.RESOLVE, feature, oldEObject, resolvedEObject));
            }
          }
        }

        return result;
      }
      else
      {
        return result;
      }
    }


    public void dynamicSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, Object newValue)
    {
      Object oldValue = settings.dynamicGet(index);
      boolean oldIsSet = oldValue != null;
      if (isUnsettable() && oldValue == NIL)
      {
        oldValue = null;
      }

      NotificationChain notifications = null;
      if (hasInverse())
      {
        if (oldValue != newValue)
        {
          if (oldValue != null)
          {
            InternalEObject internalEObject = (InternalEObject)oldValue;
            notifications = 
              internalEObject.eInverseRemove
                (owner,
                 internalEObject.eClass().getFeatureID(inverseFeature),
                 null,
                 notifications);
          }
          if (newValue != null)
          {
            InternalEObject internalEObject = (InternalEObject)newValue;
            notifications =
              internalEObject.eInverseAdd
                (owner,
                 internalEObject.eClass().getFeatureID(inverseFeature),
                 null,
                 notifications);
          }
        }
      }
      else if (isContainment())
      {
        if (oldValue != newValue)
        {
          if (oldValue != null)
          {
            notifications = 
              ((InternalEObject)oldValue).eInverseRemove
                (owner,
                 InternalEObject.EOPPOSITE_FEATURE_BASE - feature.getFeatureID(),
                 null,
                 notifications);
          }
          if (newValue != null)
          {
            notifications = 
              ((InternalEObject)newValue).eInverseAdd
                (owner,
                 InternalEObject.EOPPOSITE_FEATURE_BASE - feature.getFeatureID(),
                 null,
                 notifications);
          }
        }
      }

      if (newValue == null && isUnsettable())
      {
        settings.dynamicSet(index, NIL);
      }
      else
      {
        settings.dynamicSet(index, newValue);
      }

      if (owner.eNotificationRequired())
      {
        Notification notification = 
          new ENotificationImpl
            (owner, 
             Notification.SET, 
             feature,
             oldValue, 
             newValue,
             isUnsettable() && !oldIsSet);
        if (notifications == null)
        {
          owner.eNotify(notification);
        }
        else
        {
          notifications.add(notification);
          notifications.dispatch();
        }
      }
      else if (notifications != null)
      {
        notifications.dispatch();
      }
    }

    public void dynamicUnset(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object oldValue = settings.dynamicGet(index);
      if (isUnsettable() && oldValue == NIL)
      {
        oldValue = null;
      }

      NotificationChain notifications = null;
      if (oldValue != null)
      {
        if (hasInverse())
        {
          InternalEObject internalEObject = (InternalEObject)oldValue;
          notifications = 
            internalEObject.eInverseRemove
              (owner,
               internalEObject.eClass().getFeatureID(inverseFeature),
               null,
               notifications);
        }
        else if (isContainment())
        {
          notifications = 
            ((InternalEObject)oldValue).eInverseRemove
              (owner,
               InternalEObject.EOPPOSITE_FEATURE_BASE - feature.getFeatureID(),
               null,
               notifications);
        }
      }

      settings.dynamicUnset(index);

      if (owner.eNotificationRequired())
      {
        Notification notification = 
          new ENotificationImpl
            (owner, 
             isUnsettable() ? Notification.UNSET : Notification.SET, 
             feature,
             oldValue, 
             null);
        if (notifications == null)
        {
          owner.eNotify(notification);
        }
        else
        {
          notifications.add(notification);
          notifications.dispatch();
        }
      }
      else if (notifications != null)
      {
        notifications.dispatch();
      }
    }

    public boolean dynamicIsSet(InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index)
    {
      Object setting = settings.dynamicGet(index);
      if (setting == null)
      {
        return false;
      }
      else if (setting == NIL)
      {
        return true;
      }
      else if (isUnsettable())
      {
        return true;
      }
      else
      {
        return setting != null;
      }
    }

    public NotificationChain dynamicInverseAdd
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      Object oldValue = settings.dynamicGet(index);
      if (oldValue == NIL)
      {
        oldValue = null;
      }

      if (hasInverse())
      {
        if (oldValue != otherEnd && oldValue != null)
        {
          InternalEObject internalEObject = (InternalEObject)oldValue;
          notifications = 
            internalEObject.eInverseRemove
              (owner,
               internalEObject.eClass().getFeatureID(inverseFeature),
               null,
               notifications);
        }
      }
      else if (isContainment())
      {
        if (oldValue != null)
        {
          notifications = 
            ((InternalEObject)oldValue).eInverseRemove
              (owner,
               InternalEObject.EOPPOSITE_FEATURE_BASE - feature.getFeatureID(),
               null,
               notifications);
        }
      }

      settings.dynamicSet(index, otherEnd);

      if (owner.eNotificationRequired())
      {
        if (notifications == null) notifications = new NotificationChainImpl(4);
        notifications.add
          (new ENotificationImpl
             (owner, 
              Notification.SET, 
              feature,
              oldValue, 
              otherEnd));
      }

      return notifications;
    }

    public NotificationChain dynamicInverseRemove
      (InternalEObject owner, EStructuralFeature.Internal.DynamicValueHolder settings, int index, InternalEObject otherEnd, NotificationChain notifications)
    {
      Object oldValue = settings.dynamicGet(index);
      if (oldValue == NIL)
      {
        oldValue = null;
      }

      settings.dynamicUnset(index);

      if (owner.eNotificationRequired())
      {
        if (notifications == null) notifications = new NotificationChainImpl(4);
        if (isUnsettable())
        {
          notifications.add(new ENotificationImpl(owner, Notification.UNSET, feature, oldValue, null));
        }
        else
        {
          notifications.add(new ENotificationImpl(owner, Notification.SET, feature, oldValue, null));
        }
      }

      return notifications;
    }
  }

  public static class InternalSettingDelegateSingleEObjectUnsettable extends InternalSettingDelegateSingleEObject
  {
    public InternalSettingDelegateSingleEObjectUnsettable(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectWithInverse extends InternalSettingDelegateSingleEObject
  {
    public InternalSettingDelegateSingleEObjectWithInverse(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean hasInverse()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectWithInverseUnsettable extends InternalSettingDelegateSingleEObjectWithInverse
  {
    public InternalSettingDelegateSingleEObjectWithInverseUnsettable(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectContainment extends InternalSettingDelegateSingleEObject
  {
    public InternalSettingDelegateSingleEObjectContainment(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    public InternalSettingDelegateSingleEObjectContainment(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean isContainment()
    {
      return true;
    }
  }
  
  public static class InternalSettingDelegateSingleEObjectContainmentResolving extends InternalSettingDelegateSingleEObjectContainment 
  {
    public InternalSettingDelegateSingleEObjectContainmentResolving(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }
    
    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectContainmentWithInverse extends InternalSettingDelegateSingleEObjectContainment
  {
    public InternalSettingDelegateSingleEObjectContainmentWithInverse(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean hasInverse()
    {
      return true;
    }
  }
  
  public static class InternalSettingDelegateSingleEObjectContainmentWithInverseResolving extends InternalSettingDelegateSingleEObjectContainmentWithInverse 
  {
    public InternalSettingDelegateSingleEObjectContainmentWithInverseResolving(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }
    
    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectContainmentUnsettable extends InternalSettingDelegateSingleEObjectContainment
  {
    public InternalSettingDelegateSingleEObjectContainmentUnsettable(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }
  
  public static class InternalSettingDelegateSingleEObjectContainmentUnsettableResolving extends InternalSettingDelegateSingleEObjectContainmentUnsettable 
  {
    public InternalSettingDelegateSingleEObjectContainmentUnsettableResolving(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettable extends InternalSettingDelegateSingleEObjectContainmentWithInverse
  {
    public InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettable(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }
  
  public static class InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettableResolving extends InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettable 
  {
    public InternalSettingDelegateSingleEObjectContainmentWithInverseUnsettableResolving(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }
    
    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectResolving extends InternalSettingDelegateSingleEObject
  {
    public InternalSettingDelegateSingleEObjectResolving(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    public InternalSettingDelegateSingleEObjectResolving(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean isResolveProxies()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectResolvingUnsettable extends InternalSettingDelegateSingleEObject
  {
    public InternalSettingDelegateSingleEObjectResolvingUnsettable(EClass eClass, EStructuralFeature feature)
    {
      super(eClass, feature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectResolvingWithInverse extends InternalSettingDelegateSingleEObjectResolving
  {
    public InternalSettingDelegateSingleEObjectResolvingWithInverse(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean hasInverse()
    {
      return true;
    }
  }

  public static class InternalSettingDelegateSingleEObjectResolvingWithInverseUnsettable extends InternalSettingDelegateSingleEObjectResolvingWithInverse
  {
    public InternalSettingDelegateSingleEObjectResolvingWithInverseUnsettable(EClass eClass, EStructuralFeature feature, EReference inverseFeature)
    {
      super(eClass, feature, inverseFeature);
    }

    protected boolean isUnsettable()
    {
      return true;
    }
  }

  public static class SettingMany implements EStructuralFeature.Setting
  {
    protected EObject owner;
    protected EStructuralFeature eStructuralFeature;
    protected List list;
    public SettingMany(EObject owner, EStructuralFeature eStructuralFeature, List list)
    {
      this.list = list;
    }

    public EObject getEObject()
    {
      return owner;
    }

    public EStructuralFeature getEStructuralFeature()
    {
      return eStructuralFeature;
    }

    public Object get(boolean resolve)
    {
      return list;
    }

    public void set(Object newValue)
    {
      list.clear();
      list.addAll((List)newValue);
    }

    public boolean isSet()
    {
      return 
        list instanceof InternalEList.Unsettable ? 
          ((InternalEList.Unsettable)list).isSet() :
          !list.isEmpty();
    }

    public void unset()
    {
      if (list instanceof InternalEList.Unsettable)
      {
        ((InternalEList.Unsettable)list).unset();
      }
      else
      {
        list.clear();
      }
    }
  }

  protected EClassifier cachedEType;
  protected boolean cachedIsFeatureMap;

  public boolean isFeatureMap()
  {
    if (cachedEType != eType)
    {
      cachedEType = getEType();
      cachedIsFeatureMap = eType != null && eType.getInstanceClassName() == "org.eclipse.emf.ecore.util.FeatureMap$Entry";
    }
    return cachedIsFeatureMap;
  }

  protected BasicExtendedMetaData.EStructuralFeatureExtendedMetaData eStructuralFeatureExtendedMetaData;

  public BasicExtendedMetaData.EStructuralFeatureExtendedMetaData getExtendedMetaData()
  {
    return eStructuralFeatureExtendedMetaData;
  }

  public void setExtendedMetaData(BasicExtendedMetaData.EStructuralFeatureExtendedMetaData eStructuralFeatureExtendedMetaData)
  {
    this.eStructuralFeatureExtendedMetaData = eStructuralFeatureExtendedMetaData;
  }
}
