/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrderPackageImpl.java,v 1.1 2004/06/16 18:01:17 elena Exp $
 */
package org.eclipse.emf.test.models.order.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.ecore.xml.type.impl.XMLTypePackageImpl;

import org.eclipse.emf.test.models.customer.CustomerPackage;

import org.eclipse.emf.test.models.customer.impl.CustomerPackageImpl;

import org.eclipse.emf.test.models.movie.db.DbPackage;

import org.eclipse.emf.test.models.movie.db.impl.DbPackageImpl;

import org.eclipse.emf.test.models.order.CustomerOrder;
import org.eclipse.emf.test.models.order.DocumentRoot;
import org.eclipse.emf.test.models.order.Order;
import org.eclipse.emf.test.models.order.OrderFactory;
import org.eclipse.emf.test.models.order.OrderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrderPackageImpl extends EPackageImpl implements OrderPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customerOrderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orderEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.emf.test.models.order.OrderPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private OrderPackageImpl()
  {
    super(eNS_URI, OrderFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static OrderPackage init()
  {
    if (isInited) return (OrderPackage)EPackage.Registry.INSTANCE.get(OrderPackage.eNS_URI);

    // Obtain or create and register package
    OrderPackageImpl theOrderPackage = (OrderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OrderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OrderPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackageImpl.init();

    // Obtain or create and register interdependencies
    DbPackageImpl theDbPackage = (DbPackageImpl)(EPackage.Registry.INSTANCE.get(DbPackage.eNS_URI) instanceof EPackage ? EPackage.Registry.INSTANCE.get(DbPackage.eNS_URI) : DbPackageImpl.eINSTANCE);
    CustomerPackageImpl theCustomerPackage = (CustomerPackageImpl)(EPackage.Registry.INSTANCE.get(CustomerPackage.eNS_URI) instanceof EPackage ? EPackage.Registry.INSTANCE.get(CustomerPackage.eNS_URI) : CustomerPackageImpl.eINSTANCE);

    // Create package meta-data objects
    theOrderPackage.createPackageContents();
    theDbPackage.createPackageContents();
    theCustomerPackage.createPackageContents();

    // Initialize created meta-data
    theOrderPackage.initializePackageContents();
    theDbPackage.initializePackageContents();
    theCustomerPackage.initializePackageContents();

    return theOrderPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomerOrder()
  {
    return customerOrderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomerOrder_MoviesToSee()
  {
    return (EReference)customerOrderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomerOrder_MoviesSeen()
  {
    return (EReference)customerOrderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCustomerOrder_Any()
  {
    return (EAttribute)customerOrderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCustomerOrder_CustomerID()
  {
    return (EAttribute)customerOrderEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentRoot()
  {
    return documentRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentRoot_Mixed()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XMLNSPrefixMap()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XSISchemaLocation()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_Order()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrder()
  {
    return orderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrder_DateRequested()
  {
    return (EAttribute)orderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrder_LastUpdated()
  {
    return (EAttribute)orderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrder_Movies()
  {
    return (EAttribute)orderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderFactory getOrderFactory()
  {
    return (OrderFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    customerOrderEClass = createEClass(CUSTOMER_ORDER);
    createEReference(customerOrderEClass, CUSTOMER_ORDER__MOVIES_TO_SEE);
    createEReference(customerOrderEClass, CUSTOMER_ORDER__MOVIES_SEEN);
    createEAttribute(customerOrderEClass, CUSTOMER_ORDER__ANY);
    createEAttribute(customerOrderEClass, CUSTOMER_ORDER__CUSTOMER_ID);

    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__ORDER);

    orderEClass = createEClass(ORDER);
    createEAttribute(orderEClass, ORDER__DATE_REQUESTED);
    createEAttribute(orderEClass, ORDER__LAST_UPDATED);
    createEAttribute(orderEClass, ORDER__MOVIES);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackageImpl theXMLTypePackage = (XMLTypePackageImpl)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(customerOrderEClass, CustomerOrder.class, "CustomerOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCustomerOrder_MoviesToSee(), this.getOrder(), null, "moviesToSee", null, 1, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCustomerOrder_MoviesSeen(), this.getOrder(), null, "moviesSeen", null, 0, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomerOrder_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 1, -1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomerOrder_CustomerID(), theXMLTypePackage.getIDREF(), "customerID", null, 0, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_Order(), this.getCustomerOrder(), null, "order", null, 0, -2, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(orderEClass, Order.class, "Order", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrder_DateRequested(), theXMLTypePackage.getDate(), "dateRequested", null, 0, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOrder_LastUpdated(), theXMLTypePackage.getDate(), "lastUpdated", null, 0, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOrder_Movies(), theXMLTypePackage.getIDREFS(), "movies", null, 1, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
    // null
    createNullAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (customerOrderEClass, 
       source, 
       new String[] 
       {
       "name", "customerOrder",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getCustomerOrder_MoviesToSee(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "moviesToSee"
       });		
    addAnnotation
      (getCustomerOrder_MoviesSeen(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "moviesSeen"
       });		
    addAnnotation
      (getCustomerOrder_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "http://org/eclipse/emf/test/models/Customer http://org/eclipse/emf/test/models/MovieDB",
       "name", ":2",
       "processing", "strict"
       });		
    addAnnotation
      (getCustomerOrder_CustomerID(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "customerID"
       });		
    addAnnotation
      (documentRootEClass, 
       source, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });		
    addAnnotation
      (getDocumentRoot_Mixed(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });		
    addAnnotation
      (getDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });		
    addAnnotation
      (getDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });		
    addAnnotation
      (getDocumentRoot_Order(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "order",
       "namespace", "##targetNamespace"
       });				
    addAnnotation
      (orderEClass, 
       source, 
       new String[] 
       {
       "name", "order",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getOrder_DateRequested(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "dateRequested"
       });		
    addAnnotation
      (getOrder_LastUpdated(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "lastUpdated"
       });		
    addAnnotation
      (getOrder_Movies(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "movies"
       });
  }

  /**
   * Initializes the annotations for <b>null</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createNullAnnotations()
  {
    String source = null;													
    addAnnotation
      (orderEClass, 
       source, 
       new String[] 
       {
       "appinfo", "\r\n           <hasElement>date</hasElement>\r\n        "
       });				
  }

} //OrderPackageImpl
