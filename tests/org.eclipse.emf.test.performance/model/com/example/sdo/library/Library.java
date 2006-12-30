/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: Library.java,v 1.2 2006/12/30 03:43:52 marcelop Exp $
 */
package com.example.sdo.library;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sdo.library.Library#getName <em>Name</em>}</li>
 *   <li>{@link com.example.sdo.library.Library#getWriters <em>Writers</em>}</li>
 *   <li>{@link com.example.sdo.library.Library#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.sdo.library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.example.sdo.library.LibraryPackage#getLibrary_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.example.sdo.library.Library#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Writers</b></em>' containment reference list.
   * The list contents are of type {@link com.example.sdo.library.Writer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Writers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Writers</em>' containment reference list.
   * @see com.example.sdo.library.LibraryPackage#getLibrary_Writers()
   * @model type="com.example.sdo.library.Writer" containment="true"
   * @generated
   */
  List<Writer> getWriters();

  /**
   * Returns the value of the '<em><b>Books</b></em>' containment reference list.
   * The list contents are of type {@link com.example.sdo.library.Book}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Books</em>' containment reference list.
   * @see com.example.sdo.library.LibraryPackage#getLibrary_Books()
   * @model type="com.example.sdo.library.Book" containment="true"
   * @generated
   */
  List<Book> getBooks();

} // Library
