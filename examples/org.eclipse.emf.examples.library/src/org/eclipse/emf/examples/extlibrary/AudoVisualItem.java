/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: AudoVisualItem.java,v 1.1 2005/11/10 18:55:52 marcelop Exp $
 */
package org.eclipse.emf.examples.extlibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audo Visual Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#getMinutesLength <em>Minutes Length</em>}</li>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#isDamaged <em>Damaged</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getAudoVisualItem()
 * @model abstract="true"
 * @generated
 */
public interface AudoVisualItem extends CirculatingItem
{
  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getAudoVisualItem_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Minutes Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Minutes Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minutes Length</em>' attribute.
   * @see #setMinutesLength(int)
   * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getAudoVisualItem_MinutesLength()
   * @model required="true"
   * @generated
   */
  int getMinutesLength();

  /**
   * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#getMinutesLength <em>Minutes Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minutes Length</em>' attribute.
   * @see #getMinutesLength()
   * @generated
   */
  void setMinutesLength(int value);

  /**
   * Returns the value of the '<em><b>Damaged</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Damaged</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Damaged</em>' attribute.
   * @see #setDamaged(boolean)
   * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getAudoVisualItem_Damaged()
   * @model
   * @generated
   */
  boolean isDamaged();

  /**
   * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.AudoVisualItem#isDamaged <em>Damaged</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Damaged</em>' attribute.
   * @see #isDamaged()
   * @generated
   */
  void setDamaged(boolean value);

} // AudoVisualItem
