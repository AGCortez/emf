/**
 * <copyright>
 * </copyright>
 *
 * $Id: Supplier.java,v 1.1 2005/03/04 21:51:04 bportier Exp $
 */
package com.example.sdo.epo;

import commonj.sdo.Sequence;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sdo.epo.Supplier#getName <em>Name</em>}</li>
 *   <li>{@link com.example.sdo.epo.Supplier#getOrders <em>Orders</em>}</li>
 *   <li>{@link com.example.sdo.epo.Supplier#getPriorityOrders <em>Priority Orders</em>}</li>
 *   <li>{@link com.example.sdo.epo.Supplier#getStandardOrders <em>Standard Orders</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.sdo.epo.EPOPackage#getSupplier()
 * @model
 * @generated
 */
public interface Supplier {
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
	 * @see com.example.sdo.epo.EPOPackage#getSupplier_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.example.sdo.epo.Supplier#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Orders</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orders</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orders</em>' attribute list.
	 * @see com.example.sdo.epo.EPOPackage#getSupplier_Orders()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	Sequence getOrders();

	/**
	 * Returns the value of the '<em><b>Priority Orders</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.sdo.epo.PurchaseOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Orders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Orders</em>' containment reference list.
	 * @see com.example.sdo.epo.EPOPackage#getSupplier_PriorityOrders()
	 * @model type="com.example.epo.PurchaseOrder" containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#orders'"
	 * @generated
	 */
	List getPriorityOrders();

	/**
	 * Returns the value of the '<em><b>Standard Orders</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.sdo.epo.PurchaseOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Orders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Orders</em>' containment reference list.
	 * @see com.example.sdo.epo.EPOPackage#getSupplier_StandardOrders()
	 * @model type="com.example.epo.PurchaseOrder" containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#orders'"
	 * @generated
	 */
	List getStandardOrders();

} // Supplier
