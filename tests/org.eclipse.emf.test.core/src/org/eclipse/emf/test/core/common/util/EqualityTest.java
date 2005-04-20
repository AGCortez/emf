/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EqualityTest.java,v 1.4 2005/04/20 16:17:16 marcelop Exp $
 */
package org.eclipse.emf.test.core.common.util;


import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.test.core.featuremap.supplier.PurchaseOrder;
import org.eclipse.emf.test.core.featuremap.supplier.Supplier;
import org.eclipse.emf.test.core.featuremap.supplier.SupplierFactory;
import org.eclipse.emf.test.models.customer.AddressType;
import org.eclipse.emf.test.models.customer.CreditInfo;
import org.eclipse.emf.test.models.customer.CustomerFactory;
import org.eclipse.emf.test.models.customer.CustomerType;


public class EqualityTest extends TestCase
{
  private static SupplierFactory supplierFactoryInstance;

  private static PurchaseOrder po1;

  private static PurchaseOrder po2;

  private static Supplier supplier1;

  private static Supplier supplier2;

  private static CustomerFactory customerFactoryInstance;

  private static CustomerType customer1;

  private static CustomerType customer2;

  private static AddressType address1;

  private static AddressType address2;

  private static CreditInfo credit1;

  private static CreditInfo credit2;
  
  private static EPackage employeePackage;

  private static EClass employeeClass;

  private static EAttribute nameAttr;

  private static EReference employeesRef;

  private static EAttribute ratingsAttr;

  private static EAttribute ordersAttr;

  private static EAttribute preferredAttr;

  private static EAttribute standardAttr;

  /*
   * @see TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    if (employeePackage == null)
    {
      employeePackage = getEmployeePackage();
    }
    
    supplierFactoryInstance = SupplierFactory.eINSTANCE;
    po1 = supplierFactoryInstance.createPurchaseOrder();
    po2 = supplierFactoryInstance.createPurchaseOrder();
    supplier1 = supplierFactoryInstance.createSupplier();
    supplier2 = supplierFactoryInstance.createSupplier();

    customerFactoryInstance = CustomerFactory.eINSTANCE;
    customer1 = customerFactoryInstance.createCustomerType();
    customer2 = customerFactoryInstance.createCustomerType();
    address1 = customerFactoryInstance.createUSAddr();
    address2 = customerFactoryInstance.createUSAddr();
    credit1 = customerFactoryInstance.createCreditInfo();
    credit2 = customerFactoryInstance.createCreditInfo();
  }

  /*
   * @see TestCase#tearDown()
   */
  protected void tearDown() throws Exception
  {
    super.tearDown();
  }

  /**
   * Constructor for CompareTest.
   * @param name
   */
  public EqualityTest(String name)
  {
    super(name);
  }

  public static Test suite()
  {
    TestSuite ts = new TestSuite("EqualityTest");
    ts.addTest(new EqualityTest("shallowTest"));
    ts.addTest(new EqualityTest("featureMapTest"));
    ts.addTest(new EqualityTest("deepTest"));
    ts.addTest(new EqualityTest("crossReferenceTest"));
    return ts;
  }

  public void shallowTest()
  {
    // basic == and null comparisons
    assertTrue(EcoreUtil.equals(po1, po1));
    assertTrue(EcoreUtil.equals(null, null));
    assertTrue(!EcoreUtil.equals(null, po1));
    assertTrue(!EcoreUtil.equals(po1, null));

    // the eClass is different.
    assertTrue(!EcoreUtil.equals(po1, supplier1));

    assertTrue(EcoreUtil.equals(po1, po2));
    // make sure copy and areEquals are consistent
    EObject po1Copy = EcoreUtil.copy(po1);
    assertTrue(EcoreUtil.equals(po1, po1Copy));

    // customer1's ID is unset
    customer2.setID("987654321");
    assertTrue(!EcoreUtil.equals(customer1, customer2));

    supplier1.setName("BlueLabel");
    // supplier2's name is unset
    assertTrue(!EcoreUtil.equals(supplier1, supplier2));

    supplier1.eUnset(supplier1.eClass().getEStructuralFeature("name"));
    assertTrue(EcoreUtil.equals(supplier1, supplier2));

    // test attribute
    address1.setTown("New Orleans");
    assertTrue(!EcoreUtil.equals(address1, address2));
    address2.setTown("Chicago");
    assertTrue(!EcoreUtil.equals(address1, address2));
    address2.setTown(null);
    assertTrue(!EcoreUtil.equals(address1, address2));
    assertTrue(!EcoreUtil.equals(address2, address1));
    address1.setTown(null);
    assertTrue(EcoreUtil.equals(address1, address2));

    // make sure copy and areEqual are consistent
    address1.setStreet("Satchmo road");
    address1.setTown("LA");
    EObject address1Copy = EcoreUtil.copy(address1);
    assertTrue(EcoreUtil.equals(address1Copy, address1));

    // test multiplicity-many attributes
    EObject employee1 = createEmployee("Mr. J. C.");
    EObject employee2 = EcoreUtil.copy(employee1);
    assertTrue(EcoreUtil.equals(employee1, employee2));
    List ratings1 = (List)employee1.eGet(ratingsAttr);
    List ratings2 = (List)employee2.eGet(ratingsAttr);
    ratings1.add(new Integer(456));
    ratings1.add(new Integer(123));
    ratings2.add(new Integer(123));
    ratings2.add(new Integer(456));
    assertTrue(!EcoreUtil.equals(employee1, employee2));
    ratings1.clear();
    ratings2.clear();
    ratings1.add(new Integer(123));
    ratings1.add(new Integer(456));
    ratings2.add(new Integer(123));
    ratings2.add(new Integer(456));
    assertTrue(EcoreUtil.equals(employee1, employee2));
  }

  public void featureMapTest()
  {
    supplier1 = supplierFactoryInstance.createSupplier();
    supplier2 = supplierFactoryInstance.createSupplier();
    po1 = supplierFactoryInstance.createPurchaseOrder();
    po2 = supplierFactoryInstance.createPurchaseOrder();

    // test FeatureMaps with EReference Entries
    assertTrue(EcoreUtil.equals(supplier1, supplier2));
    supplier1.getPreferredOrders().add(po1);
    po2.setId("newID");
    supplier2.getPreferredOrders().add(po2);
    assertTrue(!EcoreUtil.equals(supplier1, supplier2));
    supplier1.getPreferredOrders().clear();
    supplier2.getPreferredOrders().clear();
    assertTrue(EcoreUtil.equals(supplier1, supplier2));
    supplier1.getStandardOrders().add(po1);
    supplier1.getPreferredOrders().add(po2);
    supplier1.getStandardOrders().add(EcoreUtil.copy(po2));
    supplier2.getStandardOrders().add(EcoreUtil.copy(po1));
    supplier2.getPreferredOrders().add(EcoreUtil.copy(po2));
    supplier2.getStandardOrders().add(EcoreUtil.copy(po2));
    assertTrue(EcoreUtil.equals(supplier1, supplier2));

    EObject employee1 = createEmployee("Mr. M. D.");
    EObject employee2 = EcoreUtil.copy(employee1);

    // test FeatureMaps with EAttributes entries
    assertTrue(EcoreUtil.equals(employee1, employee2));
    List standards1 = (List)employee1.eGet(standardAttr);
    standards1.add("abcd");
    assertTrue(!EcoreUtil.equals(employee1, employee2));
    List standards2 = (List)employee2.eGet(standardAttr);
    standards2.add("abcd");
    assertTrue(EcoreUtil.equals(employee1, employee2));
    standards1.add("efgh");
    List preferreds2 = (List)employee2.eGet(preferredAttr);
    preferreds2.add("efgh");
    assertTrue(!EcoreUtil.equals(employee1, employee2));
    List preferreds1 = (List)employee1.eGet(preferredAttr);
    preferreds1.add("efgh");
    standards1.remove("efgh");
    assertTrue(EcoreUtil.equals(employee1, employee2));

  }

  public void deepTest()
  {
    customer1 = customerFactoryInstance.createCustomerType();
    customer2 = customerFactoryInstance.createCustomerType();
    address1 = customerFactoryInstance.createUSAddr();
    address2 = customerFactoryInstance.createUSAddr();

    // differ on a String value
    assertTrue(EcoreUtil.equals(customer1, customer2));
    address1.setTown("New Orleans");
    address2.setTown("Chicago");
    customer1.setAddress(address1);
    customer2.setAddress(address2);
    assertTrue(!EcoreUtil.equals(customer1, customer2));
    address1.setTown(address2.getTown());
    assertTrue(EcoreUtil.equals(customer1, customer2));

    // differ on a Date value
    address1.setTown(address2.getTown());
    assertTrue(EcoreUtil.equals(customer1, customer2));
    long now = System.currentTimeMillis();
    Date date1 = new Date(now);
    Date date2 = new Date(now + 3600000);
    credit1.setExpireDate(date1);
    credit2.setExpireDate(date2);
    customer1.setCreditCard(credit1);
    customer2.setCreditCard(credit2);
    assertTrue(!EcoreUtil.equals(customer1, customer2));
    credit1.setExpireDate(credit2.getExpireDate());
    assertTrue(EcoreUtil.equals(customer2, customer1));

    // credit1 and credit2 don't have the same container but are areEqual anyway.
    address1.setTown("Montreal");
    assertTrue(EcoreUtil.equals(credit1, credit2));
  }
  
  //Test cases described in cases.gif, where all circles
  //  are shallow-areEqual DataObjects.
  // Note that no two objects in r1, r2, ..., r8 are areEqual.
  public void crossReferenceTest()
  {
    EObject employee1 = createEmployee("Mr. J. C.");
    EObject employee2 = EcoreUtil.copy(employee1);
    EObject employee3 = EcoreUtil.copy(employee2);
    assertTrue(EcoreUtil.equals(employee1, employee3));

    // adding employee2 to employee1's employees
    List employees1 = (List)employee1.eGet(employeesRef);
    employees1.add(employee2);
    // adding employee3 to employee1's employees
    employees1.add(employee3);
    // adding employee2 to employee3's employees
    List employees3 = (List)employee3.eGet(employeesRef);
    employees3.add(employee2);

    // create a clone of this employee graph
    // Cross-Referencer could be used instead.
    EObject employee1Prime = EcoreUtil.copy(employee1);
    EObject employee2Prime = EcoreUtil.copy(employee2);
    EObject employee3Prime = EcoreUtil.copy(employee3);
    List employees1Prime = (List)employee1Prime.eGet(employeesRef);
    employees1Prime.clear();
    employees1Prime.add(employee2Prime);
    employees1Prime.add(employee3Prime);
    List employees3Prime = (List)employee3Prime.eGet(employeesRef);
    employees3Prime.clear();
    employees3Prime.add(employee2Prime);
    assertTrue(EcoreUtil.equals(employee1, employee1Prime));

    employees3Prime.clear();
    employees3Prime.add(employee1Prime);
    // employee1 is r1, employee1Prime is r2.
    assertTrue(!EcoreUtil.equals(employee1, employee1Prime));

    employees3Prime.clear();
    employees3Prime.add(employee2);
    // employee1 is r4, employee1Prime is r3.
    assertTrue(!EcoreUtil.equals(employee1, employee1Prime));
    employees3.clear();
    employees3.add(employee2Prime);
    assertTrue(EcoreUtil.equals(employee1, employee1Prime));

    List employees2 = (List)employee2.eGet(employeesRef);
    List employees2Prime = (List)employee2Prime.eGet(employeesRef);

    employees1.clear();
    employees2.clear();
    employees3.clear();
    employees1Prime.clear();
    employees2Prime.clear();
    employees3Prime.clear();

    employees1.add(employee2);
    employees1Prime.add(employee2Prime);
    employees2.add(employee3);
    employees2Prime.add(employee3Prime);
    assertTrue(EcoreUtil.equals(employee1, employee1Prime));
    employees3.add(employee2);
    employees3Prime.add(employee1Prime);
    // employee1 is r5, employee1Prime is r6
    assertTrue(!EcoreUtil.equals(employee1, employee1Prime));
    employees3Prime.clear();
    employees3Prime.add(employee2Prime);
    assertTrue(EcoreUtil.equals(employee1, employee1Prime));

    employees2.clear();
    employees2Prime.clear();
    employees2.add(employee1Prime);
    employees2Prime.add(employee1Prime);
    // employee1 is r7, employee1Prime is r8.
    assertTrue(!EcoreUtil.equals(employee1Prime, employee1));
    employees2Prime.clear();
    employees2Prime.add(employee1);
    assertTrue(EcoreUtil.equals(employee1Prime, employee1));
  }

 private static EPackage getEmployeePackage()
  {
    EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
    EcorePackage ecorePackage = EcorePackage.eINSTANCE;

    EPackage employeePackage = ecoreFactory.createEPackage();
    employeePackage.setName("emp");
    employeePackage.setNsPrefix("emp");
    employeePackage.setNsURI("http://www.example.com/Emp");

    employeeClass = ecoreFactory.createEClass();
    employeePackage.getEClassifiers().add(employeeClass);
    employeeClass.setName("Employee");

    EClass poClass = ecoreFactory.createEClass();
    employeePackage.getEClassifiers().add(poClass);
    poClass.setName("PurchaseOrder");

    nameAttr = ecoreFactory.createEAttribute();
    employeeClass.getEStructuralFeatures().add(nameAttr);
    nameAttr.setName("name");
    nameAttr.setEType(ecorePackage.getEString());

    // to test multiplicity-many attributes.
    ratingsAttr = ecoreFactory.createEAttribute();
    employeeClass.getEStructuralFeatures().add(ratingsAttr);
    ratingsAttr.setName("phoneNumbers");
    ratingsAttr.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
    ratingsAttr.setEType(ecorePackage.getEIntegerObject());

    // create a one-way reference to an Employee, employeesRef.
    // This is used to test cases described in cases.gif.
    employeesRef = ecoreFactory.createEReference();
    employeeClass.getEStructuralFeatures().add(employeesRef);
    employeesRef.setName("employees");
    employeesRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
    employeesRef.setEType(employeeClass);

    // to test FeatureMaps with EAttributes Entries
    ordersAttr = ecoreFactory.createEAttribute();
    employeeClass.getEStructuralFeatures().add(ordersAttr);
    ordersAttr.setName("orders");
    ordersAttr.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
    ordersAttr.setEType(ecorePackage.getEFeatureMapEntry());
    ExtendedMetaData.INSTANCE.setFeatureKind(ordersAttr, ExtendedMetaData.GROUP_FEATURE);

    preferredAttr = ecoreFactory.createEAttribute();
    employeeClass.getEStructuralFeatures().add(preferredAttr);
    preferredAttr.setName("preferredOrders");
    preferredAttr.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
    preferredAttr.setEType(ecorePackage.getEString());
    preferredAttr.setVolatile(true);
    preferredAttr.setTransient(true);
    preferredAttr.setDerived(true);
    ExtendedMetaData.INSTANCE.setGroup(preferredAttr, ordersAttr);

    standardAttr = ecoreFactory.createEAttribute();
    employeeClass.getEStructuralFeatures().add(standardAttr);
    standardAttr.setName("standardOrders");
    standardAttr.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
    standardAttr.setEType(ecorePackage.getEString());
    standardAttr.setVolatile(true);
    standardAttr.setTransient(true);
    standardAttr.setDerived(true);
    ExtendedMetaData.INSTANCE.setGroup(standardAttr, ordersAttr);

    return employeePackage;
  }

  private static EObject createEmployee(String name)
  {
    EFactory employeeFactory = employeePackage.getEFactoryInstance();
    EObject employee = employeeFactory.create(employeeClass);
    employee.eSet(nameAttr, name);
    return employee;
  }
}
