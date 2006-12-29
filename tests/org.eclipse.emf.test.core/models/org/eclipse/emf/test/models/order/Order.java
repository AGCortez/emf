/**
 * <copyright>
 * </copyright>
 *
 * $Id: Order.java,v 1.2 2006/12/29 21:49:52 marcelop Exp $
 */
package org.eclipse.emf.test.models.order;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes a movie order which includes date and the list of movies
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.test.models.order.Order#getDateRequested <em>Date Requested</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.order.Order#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.order.Order#getMovies <em>Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.test.models.order.OrderPackage#getOrder()
 * @model extendedMetaData="name='order' kind='elementOnly'"
 * @generated
 */
public interface Order extends EObject
{
  /**
   * Returns the value of the '<em><b>Date Requested</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Requested</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Requested</em>' attribute.
   * @see #setDateRequested(Object)
   * @see org.eclipse.emf.test.models.order.OrderPackage#getOrder_DateRequested()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date"
   *        extendedMetaData="kind='element' name='dateRequested'"
   * @generated
   */
  Object getDateRequested();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.order.Order#getDateRequested <em>Date Requested</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Requested</em>' attribute.
   * @see #getDateRequested()
   * @generated
   */
  void setDateRequested(Object value);

  /**
   * Returns the value of the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Updated</em>' attribute.
   * @see #setLastUpdated(Object)
   * @see org.eclipse.emf.test.models.order.OrderPackage#getOrder_LastUpdated()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date"
   *        extendedMetaData="kind='element' name='lastUpdated'"
   * @generated
   */
  Object getLastUpdated();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.order.Order#getLastUpdated <em>Last Updated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Updated</em>' attribute.
   * @see #getLastUpdated()
   * @generated
   */
  void setLastUpdated(Object value);

  /**
   * Returns the value of the '<em><b>Movies</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Movies</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Movies</em>' attribute.
   * @see #setMovies(List<String>)
   * @see org.eclipse.emf.test.models.order.OrderPackage#getOrder_Movies()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.IDREFS" required="true" many="false"
   *        extendedMetaData="kind='element' name='movies'"
   * @generated
   */
  List<String> getMovies();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.order.Order#getMovies <em>Movies</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Movies</em>' attribute.
   * @see #getMovies()
   * @generated
   */
  void setMovies(List<String> value);

} // Order
