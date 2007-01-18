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
 * $Id: NameType.java,v 1.2 2007/01/18 22:06:38 marcelop Exp $
 */
package org.eclipse.emf.test.models.personal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.test.models.personal.NameType#getFamily <em>Family</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.personal.NameType#getGiven <em>Given</em>}</li>
 * </ul>
 * </p>
 *
 * @model extendedMetaData="name='nameType' kind='elementOnly'"
 * @generated
 */
public interface NameType
{
  /**
   * Returns the value of the '<em><b>Family</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Family</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Family</em>' attribute.
   * @see #setFamily(String)
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='family' namespace='##targetNamespace'"
   * @generated
   */
  String getFamily();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.personal.NameType#getFamily <em>Family</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Family</em>' attribute.
   * @see #getFamily()
   * @generated
   */
  void setFamily(String value);

  /**
   * Returns the value of the '<em><b>Given</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Given</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Given</em>' attribute.
   * @see #setGiven(String)
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='given' namespace='##targetNamespace'"
   * @generated
   */
  String getGiven();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.personal.NameType#getGiven <em>Given</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Given</em>' attribute.
   * @see #getGiven()
   * @generated
   */
  void setGiven(String value);

} // NameType
