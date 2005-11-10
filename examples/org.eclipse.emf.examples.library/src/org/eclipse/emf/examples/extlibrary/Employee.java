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
 * $Id: Employee.java,v 1.1 2005/11/10 18:55:52 marcelop Exp $
 */
package org.eclipse.emf.examples.extlibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.Employee#getManager <em>Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends Person
{
  /**
   * Returns the value of the '<em><b>Manager</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Manager</em>' reference.
   * @see #setManager(Employee)
   * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getEmployee_Manager()
   * @model
   * @generated
   */
  Employee getManager();

  /**
   * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.Employee#getManager <em>Manager</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Manager</em>' reference.
   * @see #getManager()
   * @generated
   */
  void setManager(Employee value);

} // Employee
