/**
 * <copyright>
 * </copyright>
 *
 * $Id: Address.java,v 1.1 2007/01/18 15:50:24 marcelop Exp $
 */
package org.eclipse.emf.test.models.ipo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.test.models.ipo.Address#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.ipo.Address#getStreet <em>Street</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.ipo.Address#getCity <em>City</em>}</li>
 * </ul>
 * </p>
 *
 * @model extendedMetaData="name='Address' kind='elementOnly'"
 * @generated
 */
public interface Address
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
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.ipo.Address#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Street</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Street</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Street</em>' attribute.
   * @see #setStreet(String)
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='street'"
   * @generated
   */
  String getStreet();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.ipo.Address#getStreet <em>Street</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Street</em>' attribute.
   * @see #getStreet()
   * @generated
   */
  void setStreet(String value);

  /**
   * Returns the value of the '<em><b>City</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>City</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>City</em>' attribute.
   * @see #setCity(String)
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='city'"
   * @generated
   */
  String getCity();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.ipo.Address#getCity <em>City</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>City</em>' attribute.
   * @see #getCity()
   * @generated
   */
  void setCity(String value);

} // Address
