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
 * $Id: GenModelPackage.java,v 1.19 2005/06/08 06:18:44 nickb Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent 
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each interface,</li>
 *   <li>each operation of each class or interface,</li>
 *   <li>each enum,</li>
 *   <li>each literal of each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory
 * @generated
 */
public interface GenModelPackage extends EPackage{

  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "genmodel";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/emf/2002/GenModel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "genmodel";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GenModelPackage eINSTANCE = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenBaseImpl <em>Gen Base</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenBaseImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenBase()
   * @generated
   */
  int GEN_BASE = 4;

  /**
   * The number of structural features of the the '<em>Gen Base</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_BASE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl <em>Gen Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenModel()
   * @generated
   */
  int GEN_MODEL = 0;

  /**
   * The feature id for the '<em><b>Copyright Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__COPYRIGHT_TEXT = GEN_BASE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Model Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__MODEL_DIRECTORY = GEN_BASE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Creation Commands</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__CREATION_COMMANDS = GEN_BASE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Creation Icons</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__CREATION_ICONS = GEN_BASE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Edit Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__EDIT_DIRECTORY = GEN_BASE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Editor Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__EDITOR_DIRECTORY = GEN_BASE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Model Plugin ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__MODEL_PLUGIN_ID = GEN_BASE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Template Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__TEMPLATE_DIRECTORY = GEN_BASE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Runtime Jar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__RUNTIME_JAR = GEN_BASE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Foreign Model</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__FOREIGN_MODEL = GEN_BASE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Dynamic Templates</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__DYNAMIC_TEMPLATES = GEN_BASE_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Redirection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__REDIRECTION = GEN_BASE_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Force Overwrite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__FORCE_OVERWRITE = GEN_BASE_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Non Externalized String Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__NON_EXTERNALIZED_STRING_TAG = GEN_BASE_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Model Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__MODEL_NAME = GEN_BASE_FEATURE_COUNT + 14;

  /**
   * The feature id for the '<em><b>Model Plugin Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__MODEL_PLUGIN_CLASS = GEN_BASE_FEATURE_COUNT + 15;

  /**
   * The feature id for the '<em><b>Edit Plugin Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__EDIT_PLUGIN_CLASS = GEN_BASE_FEATURE_COUNT + 16;

  /**
   * The feature id for the '<em><b>Editor Plugin Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__EDITOR_PLUGIN_CLASS = GEN_BASE_FEATURE_COUNT + 17;

  /**
   * The feature id for the '<em><b>Update Classpath</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__UPDATE_CLASSPATH = GEN_BASE_FEATURE_COUNT + 18;

  /**
   * The feature id for the '<em><b>Generate Schema</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__GENERATE_SCHEMA = GEN_BASE_FEATURE_COUNT + 19;

  /**
   * The feature id for the '<em><b>Non NLS Markers</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__NON_NLS_MARKERS = GEN_BASE_FEATURE_COUNT + 20;

  /**
   * The feature id for the '<em><b>Static Packages</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__STATIC_PACKAGES = GEN_BASE_FEATURE_COUNT + 21;

  /**
   * The feature id for the '<em><b>Model Plugin Variables</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__MODEL_PLUGIN_VARIABLES = GEN_BASE_FEATURE_COUNT + 22;

  /**
   * The feature id for the '<em><b>Root Extends Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__ROOT_EXTENDS_INTERFACE = GEN_BASE_FEATURE_COUNT + 23;

  /**
   * The feature id for the '<em><b>Root Extends Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__ROOT_EXTENDS_CLASS = GEN_BASE_FEATURE_COUNT + 24;

  /**
   * The feature id for the '<em><b>Root Implements Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE = GEN_BASE_FEATURE_COUNT + 25;

  /**
   * The feature id for the '<em><b>Suppress EMF Types</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__SUPPRESS_EMF_TYPES = GEN_BASE_FEATURE_COUNT + 26;

  /**
   * The feature id for the '<em><b>Feature Map Wrapper Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE = GEN_BASE_FEATURE_COUNT + 27;

  /**
   * The feature id for the '<em><b>Feature Map Wrapper Internal Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE = GEN_BASE_FEATURE_COUNT + 28;

  /**
   * The feature id for the '<em><b>Feature Map Wrapper Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS = GEN_BASE_FEATURE_COUNT + 29;

  /**
   * The feature id for the '<em><b>Runtime Compatibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__RUNTIME_COMPATIBILITY = GEN_BASE_FEATURE_COUNT + 30;

  /**
   * The feature id for the '<em><b>Rich Client Platform</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__RICH_CLIENT_PLATFORM = GEN_BASE_FEATURE_COUNT + 31;

  /**
   * The feature id for the '<em><b>Reflective Delegation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__REFLECTIVE_DELEGATION = GEN_BASE_FEATURE_COUNT + 32;

  /**
   * The feature id for the '<em><b>Code Formatting</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__CODE_FORMATTING = GEN_BASE_FEATURE_COUNT + 33;

  /**
   * The feature id for the '<em><b>Tests Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__TESTS_DIRECTORY = GEN_BASE_FEATURE_COUNT + 34;

  /**
   * The feature id for the '<em><b>Test Suite Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__TEST_SUITE_CLASS = GEN_BASE_FEATURE_COUNT + 35;

  /**
   * The feature id for the '<em><b>Boolean Flags Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__BOOLEAN_FLAGS_FIELD = GEN_BASE_FEATURE_COUNT + 36;

  /**
   * The feature id for the '<em><b>Boolean Flags Reserved Bits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS = GEN_BASE_FEATURE_COUNT + 37;

  /**
   * The feature id for the '<em><b>Importer ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__IMPORTER_ID = GEN_BASE_FEATURE_COUNT + 38;

  /**
   * The feature id for the '<em><b>Bundle Manifest</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__BUNDLE_MANIFEST = GEN_BASE_FEATURE_COUNT + 39;

  /**
   * The feature id for the '<em><b>Gen Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__GEN_PACKAGES = GEN_BASE_FEATURE_COUNT + 40;

  /**
   * The feature id for the '<em><b>Used Gen Packages</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL__USED_GEN_PACKAGES = GEN_BASE_FEATURE_COUNT + 41;

  /**
   * The number of structural features of the the '<em>Gen Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_MODEL_FEATURE_COUNT = GEN_BASE_FEATURE_COUNT + 42;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl <em>Gen Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenPackage()
   * @generated
   */
  int GEN_PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__PREFIX = GEN_BASE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Base Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__BASE_PACKAGE = GEN_BASE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__RESOURCE = GEN_BASE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Disposable Provider Factory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY = GEN_BASE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Adapter Factory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__ADAPTER_FACTORY = GEN_BASE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Load Initialization</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__LOAD_INITIALIZATION = GEN_BASE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Interface Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Class Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__CLASS_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Utility Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Provider Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Presentation Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Tests Package Suffix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__TESTS_PACKAGE_SUFFIX = GEN_BASE_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Generate Example Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GENERATE_EXAMPLE_CLASS = GEN_BASE_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Ecore Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__ECORE_PACKAGE = GEN_BASE_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Gen Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GEN_MODEL = GEN_BASE_FEATURE_COUNT + 14;

  /**
   * The feature id for the '<em><b>Gen Enums</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GEN_ENUMS = GEN_BASE_FEATURE_COUNT + 15;

  /**
   * The feature id for the '<em><b>Gen Data Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GEN_DATA_TYPES = GEN_BASE_FEATURE_COUNT + 16;

  /**
   * The feature id for the '<em><b>Gen Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GEN_CLASSES = GEN_BASE_FEATURE_COUNT + 17;

  /**
   * The feature id for the '<em><b>Nested Gen Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__NESTED_GEN_PACKAGES = GEN_BASE_FEATURE_COUNT + 18;

  /**
   * The feature id for the '<em><b>Gen Classifiers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE__GEN_CLASSIFIERS = GEN_BASE_FEATURE_COUNT + 19;

  /**
   * The number of structural features of the the '<em>Gen Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PACKAGE_FEATURE_COUNT = GEN_BASE_FEATURE_COUNT + 20;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassifierImpl <em>Gen Classifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassifierImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenClassifier()
   * @generated
   */
  int GEN_CLASSIFIER = 7;

  /**
   * The feature id for the '<em><b>Gen Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASSIFIER__GEN_PACKAGE = GEN_BASE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the the '<em>Gen Classifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASSIFIER_FEATURE_COUNT = GEN_BASE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassImpl <em>Gen Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenClass()
   * @generated
   */
  int GEN_CLASS = 2;

  /**
   * The feature id for the '<em><b>Gen Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__GEN_PACKAGE = GEN_CLASSIFIER__GEN_PACKAGE;

  /**
   * The feature id for the '<em><b>Provider</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__PROVIDER = GEN_CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__IMAGE = GEN_CLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ecore Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__ECORE_CLASS = GEN_CLASSIFIER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Gen Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__GEN_FEATURES = GEN_CLASSIFIER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Gen Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__GEN_OPERATIONS = GEN_CLASSIFIER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Label Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS__LABEL_FEATURE = GEN_CLASSIFIER_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the the '<em>Gen Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CLASS_FEATURE_COUNT = GEN_CLASSIFIER_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypedElementImpl <em>Gen Typed Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypedElementImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenTypedElement()
   * @generated
   */
  int GEN_TYPED_ELEMENT = 11;

  /**
   * The number of structural features of the the '<em>Gen Typed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_TYPED_ELEMENT_FEATURE_COUNT = GEN_BASE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl <em>Gen Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenFeature()
   * @generated
   */
  int GEN_FEATURE = 3;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__PROPERTY = GEN_TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Notify</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__NOTIFY = GEN_TYPED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Children</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__CHILDREN = GEN_TYPED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Create Child</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__CREATE_CHILD = GEN_TYPED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Property Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__PROPERTY_CATEGORY = GEN_TYPED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Property Filter Flags</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__PROPERTY_FILTER_FLAGS = GEN_TYPED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Property Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__PROPERTY_DESCRIPTION = GEN_TYPED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Gen Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__GEN_CLASS = GEN_TYPED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Ecore Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE__ECORE_FEATURE = GEN_TYPED_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the the '<em>Gen Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_FEATURE_FEATURE_COUNT = GEN_TYPED_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenDataTypeImpl <em>Gen Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenDataTypeImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenDataType()
   * @generated
   */
  int GEN_DATA_TYPE = 8;

  /**
   * The feature id for the '<em><b>Gen Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_DATA_TYPE__GEN_PACKAGE = GEN_CLASSIFIER__GEN_PACKAGE;

  /**
   * The feature id for the '<em><b>Ecore Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_DATA_TYPE__ECORE_DATA_TYPE = GEN_CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the the '<em>Gen Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_DATA_TYPE_FEATURE_COUNT = GEN_CLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumImpl <em>Gen Enum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenEnum()
   * @generated
   */
  int GEN_ENUM = 5;

  /**
   * The feature id for the '<em><b>Gen Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM__GEN_PACKAGE = GEN_DATA_TYPE__GEN_PACKAGE;

  /**
   * The feature id for the '<em><b>Ecore Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM__ECORE_DATA_TYPE = GEN_DATA_TYPE__ECORE_DATA_TYPE;

  /**
   * The feature id for the '<em><b>Ecore Enum</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM__ECORE_ENUM = GEN_DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Gen Enum Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM__GEN_ENUM_LITERALS = GEN_DATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the the '<em>Gen Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM_FEATURE_COUNT = GEN_DATA_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumLiteralImpl <em>Gen Enum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumLiteralImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenEnumLiteral()
   * @generated
   */
  int GEN_ENUM_LITERAL = 6;

  /**
   * The feature id for the '<em><b>Gen Enum</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM_LITERAL__GEN_ENUM = GEN_BASE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ecore Enum Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL = GEN_BASE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the the '<em>Gen Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_ENUM_LITERAL_FEATURE_COUNT = GEN_BASE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenOperationImpl <em>Gen Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenOperationImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenOperation()
   * @generated
   */
  int GEN_OPERATION = 9;

  /**
   * The feature id for the '<em><b>Gen Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_OPERATION__GEN_CLASS = GEN_TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ecore Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_OPERATION__ECORE_OPERATION = GEN_TYPED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Gen Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_OPERATION__GEN_PARAMETERS = GEN_TYPED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the the '<em>Gen Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_OPERATION_FEATURE_COUNT = GEN_TYPED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenParameterImpl <em>Gen Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenParameterImpl
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenParameter()
   * @generated
   */
  int GEN_PARAMETER = 10;

  /**
   * The feature id for the '<em><b>Gen Operation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PARAMETER__GEN_OPERATION = GEN_TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ecore Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PARAMETER__ECORE_PARAMETER = GEN_TYPED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the the '<em>Gen Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_PARAMETER_FEATURE_COUNT = GEN_TYPED_ELEMENT_FEATURE_COUNT + 2;


  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind <em>Gen Provider Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenProviderKind()
   * @generated
   */
  int GEN_PROVIDER_KIND = 12;

  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPropertyKind <em>Gen Property Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPropertyKind
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenPropertyKind()
   * @generated
   */
  int GEN_PROPERTY_KIND = 13;


  /**
   * The meta object id for the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind <em>Gen Resource Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind
   * @see org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl#getGenResourceKind()
   * @generated
   */
  int GEN_RESOURCE_KIND = 14;


  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel <em>Gen Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Model</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel
   * @generated
   */
  EClass getGenModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getCopyrightText <em>Copyright Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Copyright Text</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getCopyrightText()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_CopyrightText();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelDirectory <em>Model Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Directory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelDirectory()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ModelDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCreationCommands <em>Creation Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Creation Commands</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCreationCommands()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_CreationCommands();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCreationIcons <em>Creation Icons</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Creation Icons</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCreationIcons()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_CreationIcons();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditDirectory <em>Edit Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Edit Directory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditDirectory()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_EditDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditorDirectory <em>Editor Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Editor Directory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditorDirectory()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_EditorDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginID <em>Model Plugin ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Plugin ID</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginID()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ModelPluginID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTemplateDirectory <em>Template Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Template Directory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTemplateDirectory()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_TemplateDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRuntimeJar <em>Runtime Jar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Runtime Jar</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRuntimeJar()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RuntimeJar();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getForeignModel <em>Foreign Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Foreign Model</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getForeignModel()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ForeignModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isDynamicTemplates <em>Dynamic Templates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dynamic Templates</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isDynamicTemplates()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_DynamicTemplates();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRedirection <em>Redirection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Redirection</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRedirection()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_Redirection();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isForceOverwrite <em>Force Overwrite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Force Overwrite</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isForceOverwrite()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ForceOverwrite();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getNonExternalizedStringTag <em>Non Externalized String Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Non Externalized String Tag</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getNonExternalizedStringTag()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_NonExternalizedStringTag();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelName <em>Model Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Name</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelName()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ModelName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginClass <em>Model Plugin Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Plugin Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ModelPluginClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditPluginClass <em>Edit Plugin Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Edit Plugin Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditPluginClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_EditPluginClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditorPluginClass <em>Editor Plugin Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Editor Plugin Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getEditorPluginClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_EditorPluginClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isUpdateClasspath <em>Update Classpath</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Update Classpath</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isUpdateClasspath()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_UpdateClasspath();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isGenerateSchema <em>Generate Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generate Schema</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isGenerateSchema()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_GenerateSchema();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isNonNLSMarkers <em>Non NLS Markers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Non NLS Markers</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isNonNLSMarkers()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_NonNLSMarkers();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getStaticPackages <em>Static Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Static Packages</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getStaticPackages()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_StaticPackages();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginVariables <em>Model Plugin Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Model Plugin Variables</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getModelPluginVariables()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ModelPluginVariables();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootExtendsInterface <em>Root Extends Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root Extends Interface</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootExtendsInterface()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RootExtendsInterface();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootExtendsClass <em>Root Extends Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root Extends Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootExtendsClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RootExtendsClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootImplementsInterface <em>Root Implements Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root Implements Interface</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getRootImplementsInterface()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RootImplementsInterface();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isSuppressEMFTypes <em>Suppress EMF Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Suppress EMF Types</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isSuppressEMFTypes()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_SuppressEMFTypes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperInterface <em>Feature Map Wrapper Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature Map Wrapper Interface</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperInterface()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_FeatureMapWrapperInterface();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperInternalInterface <em>Feature Map Wrapper Internal Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature Map Wrapper Internal Interface</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperInternalInterface()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_FeatureMapWrapperInternalInterface();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperClass <em>Feature Map Wrapper Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature Map Wrapper Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getFeatureMapWrapperClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_FeatureMapWrapperClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRuntimeCompatibility <em>Runtime Compatibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Runtime Compatibility</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRuntimeCompatibility()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RuntimeCompatibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRichClientPlatform <em>Rich Client Platform</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rich Client Platform</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isRichClientPlatform()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_RichClientPlatform();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isReflectiveDelegation <em>Reflective Delegation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reflective Delegation</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isReflectiveDelegation()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ReflectiveDelegation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCodeFormatting <em>Code Formatting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code Formatting</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isCodeFormatting()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_CodeFormatting();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTestsDirectory <em>Tests Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tests Directory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTestsDirectory()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_TestsDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTestSuiteClass <em>Test Suite Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Test Suite Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getTestSuiteClass()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_TestSuiteClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getBooleanFlagsField <em>Boolean Flags Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean Flags Field</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getBooleanFlagsField()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_BooleanFlagsField();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getBooleanFlagsReservedBits <em>Boolean Flags Reserved Bits</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean Flags Reserved Bits</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getBooleanFlagsReservedBits()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_BooleanFlagsReservedBits();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getImporterID <em>Importer ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Importer ID</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getImporterID()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_ImporterID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#isBundleManifest <em>Bundle Manifest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bundle Manifest</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#isBundleManifest()
   * @see #getGenModel()
   * @generated
   */
  EAttribute getGenModel_BundleManifest();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getGenPackages <em>Gen Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Packages</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getGenPackages()
   * @see #getGenModel()
   * @generated
   */
  EReference getGenModel_GenPackages();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getUsedGenPackages <em>Used Gen Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Used Gen Packages</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getUsedGenPackages()
   * @see #getGenModel()
   * @generated
   */
  EReference getGenModel_UsedGenPackages();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage <em>Gen Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Package</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage
   * @generated
   */
  EClass getGenPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPrefix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_Prefix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getBasePackage <em>Base Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Base Package</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getBasePackage()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_BasePackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getResource <em>Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Resource</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getResource()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_Resource();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDisposableProviderFactory <em>Disposable Provider Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Disposable Provider Factory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDisposableProviderFactory()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_DisposableProviderFactory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isAdapterFactory <em>Adapter Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adapter Factory</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isAdapterFactory()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_AdapterFactory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLoadInitialization <em>Load Initialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Load Initialization</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLoadInitialization()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_LoadInitialization();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getInterfacePackageSuffix <em>Interface Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getInterfacePackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_InterfacePackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getClassPackageSuffix <em>Class Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getClassPackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_ClassPackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getUtilityPackageSuffix <em>Utility Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Utility Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getUtilityPackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_UtilityPackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getProviderPackageSuffix <em>Provider Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Provider Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getProviderPackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_ProviderPackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPresentationPackageSuffix <em>Presentation Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Presentation Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPresentationPackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_PresentationPackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getTestsPackageSuffix <em>Tests Package Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tests Package Suffix</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getTestsPackageSuffix()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_TestsPackageSuffix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateExampleClass <em>Generate Example Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generate Example Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateExampleClass()
   * @see #getGenPackage()
   * @generated
   */
  EAttribute getGenPackage_GenerateExampleClass();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getEcorePackage <em>Ecore Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Package</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getEcorePackage()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_EcorePackage();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenModel <em>Gen Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Gen Model</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenModel()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_GenModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenEnums <em>Gen Enums</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Enums</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenEnums()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_GenEnums();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenDataTypes <em>Gen Data Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Data Types</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenDataTypes()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_GenDataTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClasses <em>Gen Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Classes</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClasses()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_GenClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getNestedGenPackages <em>Nested Gen Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Gen Packages</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getNestedGenPackages()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_NestedGenPackages();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers <em>Gen Classifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Gen Classifiers</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers()
   * @see #getGenPackage()
   * @generated
   */
  EReference getGenPackage_GenClassifiers();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass <em>Gen Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass
   * @generated
   */
  EClass getGenClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Provider</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider()
   * @see #getGenClass()
   * @generated
   */
  EAttribute getGenClass_Provider();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage <em>Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Image</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage()
   * @see #getGenClass()
   * @generated
   */
  EAttribute getGenClass_Image();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass <em>Ecore Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass()
   * @see #getGenClass()
   * @generated
   */
  EReference getGenClass_EcoreClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures <em>Gen Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Features</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures()
   * @see #getGenClass()
   * @generated
   */
  EReference getGenClass_GenFeatures();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations <em>Gen Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Operations</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations()
   * @see #getGenClass()
   * @generated
   */
  EReference getGenClass_GenOperations();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature <em>Label Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Label Feature</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature()
   * @see #getGenClass()
   * @generated
   */
  EReference getGenClass_LabelFeature();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature <em>Gen Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Feature</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature
   * @generated
   */
  EClass getGenFeature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getProperty()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_Property();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isNotify <em>Notify</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Notify</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isNotify()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_Notify();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Children</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isChildren()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_Children();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild <em>Create Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Create Child</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_CreateChild();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyCategory <em>Property Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property Category</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyCategory()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_PropertyCategory();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyFilterFlags <em>Property Filter Flags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Property Filter Flags</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyFilterFlags()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_PropertyFilterFlags();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyDescription <em>Property Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property Description</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyDescription()
   * @see #getGenFeature()
   * @generated
   */
  EAttribute getGenFeature_PropertyDescription();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass <em>Gen Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Gen Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass()
   * @see #getGenFeature()
   * @generated
   */
  EReference getGenFeature_GenClass();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getEcoreFeature <em>Ecore Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Feature</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getEcoreFeature()
   * @see #getGenFeature()
   * @generated
   */
  EReference getGenFeature_EcoreFeature();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenBase <em>Gen Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Base</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenBase
   * @generated
   */
  EClass getGenBase();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnum <em>Gen Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Enum</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnum
   * @generated
   */
  EClass getGenEnum();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnum#getEcoreEnum <em>Ecore Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Enum</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnum#getEcoreEnum()
   * @see #getGenEnum()
   * @generated
   */
  EReference getGenEnum_EcoreEnum();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnum#getGenEnumLiterals <em>Gen Enum Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Enum Literals</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnum#getGenEnumLiterals()
   * @see #getGenEnum()
   * @generated
   */
  EReference getGenEnum_GenEnumLiterals();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral <em>Gen Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Enum Literal</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral
   * @generated
   */
  EClass getGenEnumLiteral();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral#getGenEnum <em>Gen Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Gen Enum</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral#getGenEnum()
   * @see #getGenEnumLiteral()
   * @generated
   */
  EReference getGenEnumLiteral_GenEnum();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral#getEcoreEnumLiteral <em>Ecore Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Enum Literal</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral#getEcoreEnumLiteral()
   * @see #getGenEnumLiteral()
   * @generated
   */
  EReference getGenEnumLiteral_EcoreEnumLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier <em>Gen Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Classifier</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
   * @generated
   */
  EClass getGenClassifier();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenPackage <em>Gen Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Gen Package</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenPackage()
   * @see #getGenClassifier()
   * @generated
   */
  EReference getGenClassifier_GenPackage();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenDataType <em>Gen Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Data Type</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenDataType
   * @generated
   */
  EClass getGenDataType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenDataType#getEcoreDataType <em>Ecore Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Data Type</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenDataType#getEcoreDataType()
   * @see #getGenDataType()
   * @generated
   */
  EReference getGenDataType_EcoreDataType();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation <em>Gen Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Operation</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation
   * @generated
   */
  EClass getGenOperation();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass <em>Gen Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Gen Class</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass()
   * @see #getGenOperation()
   * @generated
   */
  EReference getGenOperation_GenClass();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getEcoreOperation <em>Ecore Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Operation</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getEcoreOperation()
   * @see #getGenOperation()
   * @generated
   */
  EReference getGenOperation_EcoreOperation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenParameters <em>Gen Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Parameters</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenParameters()
   * @see #getGenOperation()
   * @generated
   */
  EReference getGenOperation_GenParameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter <em>Gen Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Parameter</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenParameter
   * @generated
   */
  EClass getGenParameter();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation <em>Gen Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Gen Operation</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation()
   * @see #getGenParameter()
   * @generated
   */
  EReference getGenParameter_GenOperation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getEcoreParameter <em>Ecore Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ecore Parameter</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getEcoreParameter()
   * @see #getGenParameter()
   * @generated
   */
  EReference getGenParameter_EcoreParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement <em>Gen Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Typed Element</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement
   * @generated
   */
  EClass getGenTypedElement();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind <em>Gen Provider Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Gen Provider Kind</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenProviderKind
   * @generated
   */
  EEnum getGenProviderKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPropertyKind <em>Gen Property Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Gen Property Kind</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenPropertyKind
   * @generated
   */
  EEnum getGenPropertyKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind <em>Gen Resource Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Gen Resource Kind</em>'.
   * @see org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind
   * @generated
   */
  EEnum getGenResourceKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GenModelFactory getGenModelFactory();

} //GenModelPackage
