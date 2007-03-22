/**
 * <copyright> 
 *
 * Copyright (c) 2002-2007 IBM Corporation and others.
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
 * $Id: GenModelImpl.java,v 1.79 2007/03/22 15:48:26 davidms Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel.impl;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;

import org.eclipse.emf.codegen.ecore.CodeGenEcorePlugin;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.codegen.util.ImportManager;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GenModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getCopyrightText <em>Copyright Text</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getModelDirectory <em>Model Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isCreationCommands <em>Creation Commands</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isCreationIcons <em>Creation Icons</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isCreationSubmenus <em>Creation Submenus</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getEditDirectory <em>Edit Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getEditorDirectory <em>Editor Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getModelPluginID <em>Model Plugin ID</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getTemplateDirectory <em>Template Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isRuntimeJar <em>Runtime Jar</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getForeignModel <em>Foreign Model</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isDynamicTemplates <em>Dynamic Templates</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getRedirection <em>Redirection</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isForceOverwrite <em>Force Overwrite</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getNonExternalizedStringTag <em>Non Externalized String Tag</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getModelPluginClass <em>Model Plugin Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getEditPluginClass <em>Edit Plugin Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getEditorPluginClass <em>Editor Plugin Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isUpdateClasspath <em>Update Classpath</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isGenerateSchema <em>Generate Schema</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isNonNLSMarkers <em>Non NLS Markers</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getStaticPackages <em>Static Packages</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getModelPluginVariables <em>Model Plugin Variables</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getRootExtendsInterface <em>Root Extends Interface</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getRootExtendsClass <em>Root Extends Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getRootImplementsInterface <em>Root Implements Interface</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressEMFTypes <em>Suppress EMF Types</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressEMFMetaData <em>Suppress EMF Meta Data</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressEMFModelTags <em>Suppress EMF Model Tags</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressInterfaces <em>Suppress Interfaces</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getFeatureMapWrapperInterface <em>Feature Map Wrapper Interface</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getFeatureMapWrapperInternalInterface <em>Feature Map Wrapper Internal Interface</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getFeatureMapWrapperClass <em>Feature Map Wrapper Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isRuntimeCompatibility <em>Runtime Compatibility</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isRichClientPlatform <em>Rich Client Platform</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isReflectiveDelegation <em>Reflective Delegation</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isCodeFormatting <em>Code Formatting</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getTestsDirectory <em>Tests Directory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getTestSuiteClass <em>Test Suite Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getBooleanFlagsField <em>Boolean Flags Field</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getBooleanFlagsReservedBits <em>Boolean Flags Reserved Bits</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getImporterID <em>Importer ID</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isBundleManifest <em>Bundle Manifest</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getFeatureDelegation <em>Feature Delegation</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isContainmentProxies <em>Containment Proxies</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isMinimalReflectiveMethods <em>Minimal Reflective Methods</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressContainment <em>Suppress Containment</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressNotification <em>Suppress Notification</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isArrayAccessors <em>Array Accessors</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#isSuppressUnsettable <em>Suppress Unsettable</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getFacadeHelperClass <em>Facade Helper Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getComplianceLevel <em>Compliance Level</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getGenPackages <em>Gen Packages</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl#getUsedGenPackages <em>Used Gen Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenModelImpl extends GenBaseImpl implements GenModel
{
  /**
   * The default value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCopyrightText()
   * @generated
   * @ordered
   */
  protected static final String COPYRIGHT_TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCopyrightText()
   * @generated
   * @ordered
   */
  protected String copyrightText = COPYRIGHT_TEXT_EDEFAULT;

  /**
   * The default value of the '{@link #getModelDirectory() <em>Model Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelDirectory()
   * @generated
   * @ordered
   */
  protected static final String MODEL_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModelDirectory() <em>Model Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelDirectory()
   * @generated
   * @ordered
   */
  protected String modelDirectory = MODEL_DIRECTORY_EDEFAULT;

  /**
   * The default value of the '{@link #isCreationCommands() <em>Creation Commands</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationCommands()
   * @generated
   * @ordered
   */
  protected static final boolean CREATION_COMMANDS_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isCreationCommands() <em>Creation Commands</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationCommands()
   * @generated
   * @ordered
   */
  protected boolean creationCommands = CREATION_COMMANDS_EDEFAULT;

  /**
   * The default value of the '{@link #isCreationIcons() <em>Creation Icons</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationIcons()
   * @generated
   * @ordered
   */
  protected static final boolean CREATION_ICONS_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isCreationIcons() <em>Creation Icons</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationIcons()
   * @generated
   * @ordered
   */
  protected boolean creationIcons = CREATION_ICONS_EDEFAULT;

  /**
   * The default value of the '{@link #isCreationSubmenus() <em>Creation Submenus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationSubmenus()
   * @generated
   * @ordered
   */
  protected static final boolean CREATION_SUBMENUS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCreationSubmenus() <em>Creation Submenus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCreationSubmenus()
   * @generated
   * @ordered
   */
  protected boolean creationSubmenus = CREATION_SUBMENUS_EDEFAULT;

  /**
   * The default value of the '{@link #getEditDirectory() <em>Edit Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditDirectory()
   * @generated
   * @ordered
   */
  protected static final String EDIT_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEditDirectory() <em>Edit Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditDirectory()
   * @generated
   * @ordered
   */
  protected String editDirectory = EDIT_DIRECTORY_EDEFAULT;

  /**
   * This is true if the Edit Directory attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean editDirectoryESet;

  /**
   * The default value of the '{@link #getEditorDirectory() <em>Editor Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditorDirectory()
   * @generated
   * @ordered
   */
  protected static final String EDITOR_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEditorDirectory() <em>Editor Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditorDirectory()
   * @generated
   * @ordered
   */
  protected String editorDirectory = EDITOR_DIRECTORY_EDEFAULT;

  /**
   * This is true if the Editor Directory attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean editorDirectoryESet;

  /**
   * The default value of the '{@link #getModelPluginID() <em>Model Plugin ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelPluginID()
   * @generated
   * @ordered
   */
  protected static final String MODEL_PLUGIN_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModelPluginID() <em>Model Plugin ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelPluginID()
   * @generated
   * @ordered
   */
  protected String modelPluginID = MODEL_PLUGIN_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getTemplateDirectory() <em>Template Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateDirectory()
   * @generated
   * @ordered
   */
  protected static final String TEMPLATE_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTemplateDirectory() <em>Template Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateDirectory()
   * @generated
   * @ordered
   */
  protected String templateDirectory = TEMPLATE_DIRECTORY_EDEFAULT;

  /**
   * The default value of the '{@link #isRuntimeJar() <em>Runtime Jar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRuntimeJar()
   * @generated
   * @ordered
   */
  protected static final boolean RUNTIME_JAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRuntimeJar() <em>Runtime Jar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRuntimeJar()
   * @generated
   * @ordered
   */
  protected boolean runtimeJar = RUNTIME_JAR_EDEFAULT;

  /**
   * The cached value of the '{@link #getForeignModel() <em>Foreign Model</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForeignModel()
   * @generated
   * @ordered
   */
  protected EList<String> foreignModel;

  /**
   * The default value of the '{@link #isDynamicTemplates() <em>Dynamic Templates</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamicTemplates()
   * @generated
   * @ordered
   */
  protected static final boolean DYNAMIC_TEMPLATES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDynamicTemplates() <em>Dynamic Templates</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamicTemplates()
   * @generated
   * @ordered
   */
  protected boolean dynamicTemplates = DYNAMIC_TEMPLATES_EDEFAULT;

  /**
   * The default value of the '{@link #getRedirection() <em>Redirection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedirection()
   * @generated
   * @ordered
   */
  protected static final String REDIRECTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRedirection() <em>Redirection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedirection()
   * @generated
   * @ordered
   */
  protected String redirection = REDIRECTION_EDEFAULT;

  /**
   * The default value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForceOverwrite()
   * @generated
   * @ordered
   */
  protected static final boolean FORCE_OVERWRITE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForceOverwrite()
   * @generated
   * @ordered
   */
  protected boolean forceOverwrite = FORCE_OVERWRITE_EDEFAULT;

  /**
   * The default value of the '{@link #getNonExternalizedStringTag() <em>Non Externalized String Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonExternalizedStringTag()
   * @generated
   * @ordered
   */
  protected static final String NON_EXTERNALIZED_STRING_TAG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNonExternalizedStringTag() <em>Non Externalized String Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonExternalizedStringTag()
   * @generated
   * @ordered
   */
  protected String nonExternalizedStringTag = NON_EXTERNALIZED_STRING_TAG_EDEFAULT;

  /**
   * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelName()
   * @generated
   * @ordered
   */
  protected static final String MODEL_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelName()
   * @generated
   * @ordered
   */
  protected String modelName = MODEL_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getModelPluginClass() <em>Model Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelPluginClass()
   * @generated
   * @ordered
   */
  protected static final String MODEL_PLUGIN_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModelPluginClass() <em>Model Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelPluginClass()
   * @generated
   * @ordered
   */
  protected String modelPluginClass = MODEL_PLUGIN_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getEditPluginClass() <em>Edit Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditPluginClass()
   * @generated
   * @ordered
   */
  protected static final String EDIT_PLUGIN_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEditPluginClass() <em>Edit Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditPluginClass()
   * @generated
   * @ordered
   */
  protected String editPluginClass = EDIT_PLUGIN_CLASS_EDEFAULT;

  /**
   * This is true if the Edit Plugin Class attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean editPluginClassESet;

  /**
   * The default value of the '{@link #getEditorPluginClass() <em>Editor Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditorPluginClass()
   * @generated
   * @ordered
   */
  protected static final String EDITOR_PLUGIN_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEditorPluginClass() <em>Editor Plugin Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditorPluginClass()
   * @generated
   * @ordered
   */
  protected String editorPluginClass = EDITOR_PLUGIN_CLASS_EDEFAULT;

  /**
   * This is true if the Editor Plugin Class attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean editorPluginClassESet;

  /**
   * The default value of the '{@link #isUpdateClasspath() <em>Update Classpath</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpdateClasspath()
   * @generated
   * @ordered
   */
  protected static final boolean UPDATE_CLASSPATH_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isUpdateClasspath() <em>Update Classpath</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpdateClasspath()
   * @generated
   * @ordered
   */
  protected boolean updateClasspath = UPDATE_CLASSPATH_EDEFAULT;

  /**
   * The default value of the '{@link #isGenerateSchema() <em>Generate Schema</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerateSchema()
   * @generated
   * @ordered
   */
  protected static final boolean GENERATE_SCHEMA_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGenerateSchema() <em>Generate Schema</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerateSchema()
   * @generated
   * @ordered
   */
  protected boolean generateSchema = GENERATE_SCHEMA_EDEFAULT;

  /**
   * The default value of the '{@link #isNonNLSMarkers() <em>Non NLS Markers</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonNLSMarkers()
   * @generated
   * @ordered
   */
  protected static final boolean NON_NLS_MARKERS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNonNLSMarkers() <em>Non NLS Markers</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonNLSMarkers()
   * @generated
   * @ordered
   */
  protected boolean nonNLSMarkers = NON_NLS_MARKERS_EDEFAULT;

  /**
   * The cached value of the '{@link #getStaticPackages() <em>Static Packages</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStaticPackages()
   * @generated
   * @ordered
   */
  protected EList<String> staticPackages;

  /**
   * The cached value of the '{@link #getModelPluginVariables() <em>Model Plugin Variables</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelPluginVariables()
   * @generated
   * @ordered
   */
  protected EList<String> modelPluginVariables;

  /**
   * The default value of the '{@link #getRootExtendsInterface() <em>Root Extends Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootExtendsInterface()
   * @generated
   * @ordered
   */
  protected static final String ROOT_EXTENDS_INTERFACE_EDEFAULT = "org.eclipse.emf.ecore.EObject";

  /**
   * The cached value of the '{@link #getRootExtendsInterface() <em>Root Extends Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootExtendsInterface()
   * @generated
   * @ordered
   */
  protected String rootExtendsInterface = ROOT_EXTENDS_INTERFACE_EDEFAULT;

  /**
   * The default value of the '{@link #getRootExtendsClass() <em>Root Extends Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootExtendsClass()
   * @generated
   * @ordered
   */
  protected static final String ROOT_EXTENDS_CLASS_EDEFAULT = "org.eclipse.emf.ecore.impl.EObjectImpl";

  /**
   * The cached value of the '{@link #getRootExtendsClass() <em>Root Extends Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootExtendsClass()
   * @generated
   * @ordered
   */
  protected String rootExtendsClass = ROOT_EXTENDS_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getRootImplementsInterface() <em>Root Implements Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootImplementsInterface()
   * @generated
   * @ordered
   */
  protected static final String ROOT_IMPLEMENTS_INTERFACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRootImplementsInterface() <em>Root Implements Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootImplementsInterface()
   * @generated
   * @ordered
   */
  protected String rootImplementsInterface = ROOT_IMPLEMENTS_INTERFACE_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressEMFTypes() <em>Suppress EMF Types</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFTypes()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_EMF_TYPES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressEMFTypes() <em>Suppress EMF Types</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFTypes()
   * @generated
   * @ordered
   */
  protected boolean suppressEMFTypes = SUPPRESS_EMF_TYPES_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressEMFMetaData() <em>Suppress EMF Meta Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFMetaData()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_EMF_META_DATA_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressEMFMetaData() <em>Suppress EMF Meta Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFMetaData()
   * @generated
   * @ordered
   */
  protected boolean suppressEMFMetaData = SUPPRESS_EMF_META_DATA_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressEMFModelTags() <em>Suppress EMF Model Tags</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFModelTags()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_EMF_MODEL_TAGS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressEMFModelTags() <em>Suppress EMF Model Tags</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressEMFModelTags()
   * @generated
   * @ordered
   */
  protected boolean suppressEMFModelTags = SUPPRESS_EMF_MODEL_TAGS_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressInterfaces() <em>Suppress Interfaces</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressInterfaces()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_INTERFACES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressInterfaces() <em>Suppress Interfaces</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressInterfaces()
   * @generated
   * @ordered
   */
  protected boolean suppressInterfaces = SUPPRESS_INTERFACES_EDEFAULT;

  /**
   * The default value of the '{@link #getFeatureMapWrapperInterface() <em>Feature Map Wrapper Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperInterface()
   * @generated
   * @ordered
   */
  protected static final String FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeatureMapWrapperInterface() <em>Feature Map Wrapper Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperInterface()
   * @generated
   * @ordered
   */
  protected String featureMapWrapperInterface = FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT;

  /**
   * The default value of the '{@link #getFeatureMapWrapperInternalInterface() <em>Feature Map Wrapper Internal Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperInternalInterface()
   * @generated
   * @ordered
   */
  protected static final String FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeatureMapWrapperInternalInterface() <em>Feature Map Wrapper Internal Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperInternalInterface()
   * @generated
   * @ordered
   */
  protected String featureMapWrapperInternalInterface = FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT;

  /**
   * The default value of the '{@link #getFeatureMapWrapperClass() <em>Feature Map Wrapper Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperClass()
   * @generated
   * @ordered
   */
  protected static final String FEATURE_MAP_WRAPPER_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeatureMapWrapperClass() <em>Feature Map Wrapper Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureMapWrapperClass()
   * @generated
   * @ordered
   */
  protected String featureMapWrapperClass = FEATURE_MAP_WRAPPER_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #isRuntimeCompatibility() <em>Runtime Compatibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRuntimeCompatibility()
   * @generated
   * @ordered
   */
  protected static final boolean RUNTIME_COMPATIBILITY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRuntimeCompatibility() <em>Runtime Compatibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRuntimeCompatibility()
   * @generated
   * @ordered
   */
  protected boolean runtimeCompatibility = RUNTIME_COMPATIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isRichClientPlatform() <em>Rich Client Platform</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRichClientPlatform()
   * @generated
   * @ordered
   */
  protected static final boolean RICH_CLIENT_PLATFORM_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRichClientPlatform() <em>Rich Client Platform</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRichClientPlatform()
   * @generated
   * @ordered
   */
  protected boolean richClientPlatform = RICH_CLIENT_PLATFORM_EDEFAULT;

  /**
   * The default value of the '{@link #isReflectiveDelegation() <em>Reflective Delegation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReflectiveDelegation()
   * @generated
   * @ordered
   */
  protected static final boolean REFLECTIVE_DELEGATION_EDEFAULT = false;

  /**
   * The default value of the '{@link #isCodeFormatting() <em>Code Formatting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCodeFormatting()
   * @generated
   * @ordered
   */
  protected static final boolean CODE_FORMATTING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCodeFormatting() <em>Code Formatting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCodeFormatting()
   * @generated
   * @ordered
   */
  protected boolean codeFormatting = CODE_FORMATTING_EDEFAULT;

  /**
   * The default value of the '{@link #getTestsDirectory() <em>Tests Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestsDirectory()
   * @generated
   * @ordered
   */
  protected static final String TESTS_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTestsDirectory() <em>Tests Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestsDirectory()
   * @generated
   * @ordered
   */
  protected String testsDirectory = TESTS_DIRECTORY_EDEFAULT;

  /**
   * This is true if the Tests Directory attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean testsDirectoryESet;

  /**
   * The default value of the '{@link #getTestSuiteClass() <em>Test Suite Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestSuiteClass()
   * @generated
   * @ordered
   */
  protected static final String TEST_SUITE_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTestSuiteClass() <em>Test Suite Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestSuiteClass()
   * @generated
   * @ordered
   */
  protected String testSuiteClass = TEST_SUITE_CLASS_EDEFAULT;

  /**
   * This is true if the Test Suite Class attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean testSuiteClassESet;

  /**
   * The default value of the '{@link #getBooleanFlagsField() <em>Boolean Flags Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanFlagsField()
   * @generated
   * @ordered
   */
  protected static final String BOOLEAN_FLAGS_FIELD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBooleanFlagsField() <em>Boolean Flags Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanFlagsField()
   * @generated
   * @ordered
   */
  protected String booleanFlagsField = BOOLEAN_FLAGS_FIELD_EDEFAULT;

  /**
   * The default value of the '{@link #getBooleanFlagsReservedBits() <em>Boolean Flags Reserved Bits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanFlagsReservedBits()
   * @generated
   * @ordered
   */
  protected static final int BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getBooleanFlagsReservedBits() <em>Boolean Flags Reserved Bits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanFlagsReservedBits()
   * @generated
   * @ordered
   */
  protected int booleanFlagsReservedBits = BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT;

  /**
   * The default value of the '{@link #getImporterID() <em>Importer ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImporterID()
   * @generated
   * @ordered
   */
  protected static final String IMPORTER_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImporterID() <em>Importer ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImporterID()
   * @generated
   * @ordered
   */
  protected String importerID = IMPORTER_ID_EDEFAULT;

  /**
   * The default value of the '{@link #isBundleManifest() <em>Bundle Manifest</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBundleManifest()
   * @generated
   * @ordered
   */
  protected static final boolean BUNDLE_MANIFEST_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isBundleManifest() <em>Bundle Manifest</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBundleManifest()
   * @generated
   * @ordered
   */
  protected boolean bundleManifest = BUNDLE_MANIFEST_EDEFAULT;

  /**
   * The default value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureDelegation()
   * @generated
   * @ordered
   */
  protected static final GenDelegationKind FEATURE_DELEGATION_EDEFAULT = GenDelegationKind.NONE_LITERAL;

  /**
   * The cached value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureDelegation()
   * @generated
   * @ordered
   */
  protected GenDelegationKind featureDelegation = FEATURE_DELEGATION_EDEFAULT;

  /**
   * The default value of the '{@link #isContainmentProxies() <em>Containment Proxies</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainmentProxies()
   * @generated
   * @ordered
   */
  protected static final boolean CONTAINMENT_PROXIES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isContainmentProxies() <em>Containment Proxies</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainmentProxies()
   * @generated
   * @ordered
   */
  protected boolean containmentProxies = CONTAINMENT_PROXIES_EDEFAULT;

  /**
   * The default value of the '{@link #isMinimalReflectiveMethods() <em>Minimal Reflective Methods</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMinimalReflectiveMethods()
   * @generated
   * @ordered
   */
  protected static final boolean MINIMAL_REFLECTIVE_METHODS_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isMinimalReflectiveMethods() <em>Minimal Reflective Methods</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMinimalReflectiveMethods()
   * @generated
   * @ordered
   */
  protected boolean minimalReflectiveMethods = MINIMAL_REFLECTIVE_METHODS_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressContainment() <em>Suppress Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressContainment()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_CONTAINMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressContainment() <em>Suppress Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressContainment()
   * @generated
   * @ordered
   */
  protected boolean suppressContainment = SUPPRESS_CONTAINMENT_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressNotification() <em>Suppress Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressNotification()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_NOTIFICATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressNotification() <em>Suppress Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressNotification()
   * @generated
   * @ordered
   */
  protected boolean suppressNotification = SUPPRESS_NOTIFICATION_EDEFAULT;

  /**
   * The default value of the '{@link #isArrayAccessors() <em>Array Accessors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArrayAccessors()
   * @generated
   * @ordered
   */
  protected static final boolean ARRAY_ACCESSORS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isArrayAccessors() <em>Array Accessors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArrayAccessors()
   * @generated
   * @ordered
   */
  protected boolean arrayAccessors = ARRAY_ACCESSORS_EDEFAULT;

  /**
   * The default value of the '{@link #isSuppressUnsettable() <em>Suppress Unsettable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressUnsettable()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_UNSETTABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSuppressUnsettable() <em>Suppress Unsettable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressUnsettable()
   * @generated
   * @ordered
   */
  protected boolean suppressUnsettable = SUPPRESS_UNSETTABLE_EDEFAULT;

  /**
   * The default value of the '{@link #getFacadeHelperClass() <em>Facade Helper Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * This value should be always equals to JMerger.DEFAULT_FACADE_HELPER_CLASS.
   * <!-- end-user-doc -->
   * @see #getFacadeHelperClass()
   * @generated
   * @ordered
   */
  protected static final String FACADE_HELPER_CLASS_EDEFAULT = "org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper";

  /**
   * The cached value of the '{@link #getFacadeHelperClass() <em>Facade Helper Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFacadeHelperClass()
   * @generated
   * @ordered
   */
  protected String facadeHelperClass = FACADE_HELPER_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getComplianceLevel() <em>Compliance Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplianceLevel()
   * @generated
   * @ordered
   */
  protected static final GenJDKLevel COMPLIANCE_LEVEL_EDEFAULT = GenJDKLevel.JDK14_LITERAL;

  /**
   * The cached value of the '{@link #getComplianceLevel() <em>Compliance Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplianceLevel()
   * @generated
   * @ordered
   */
  protected GenJDKLevel complianceLevel = COMPLIANCE_LEVEL_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenPackages() <em>Gen Packages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenPackages()
   * @generated
   * @ordered
   */
  protected EList<GenPackage> genPackages;

  protected EList<GenPackage> staticGenPackages = null;

  /**
   * The cached value of the '{@link #getUsedGenPackages() <em>Used Gen Packages</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsedGenPackages()
   * @generated
   * @ordered
   */
  protected EList<GenPackage> usedGenPackages;
  
  protected boolean validateModel = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  protected GenModelImpl() 
  {
    super();
  }
  
  @Override
  public GenModel getGenModel()
  {
    return this;
  }
  
  Map<EPackage, GenPackage> ePackageToGenPackageMap;

  @Override
  public GenPackage findGenPackage(EPackage ePackage)
  {
    GenPackage result;
    if (ePackageToGenPackageMap == null)
    {
      ePackageToGenPackageMap = new HashMap<EPackage, GenPackage>();
      result = null;
    }
    else
    {
      result = ePackageToGenPackageMap.get(ePackage);
      if (result != null)
      {
        return result;
      }
    }

    if (ePackage == EcorePackage.eINSTANCE)
    {
      if (ecoreGenPackage == null)
      {
        GenModel ecoreGenModel = getGenModel().createGenModel();
        ecoreGenModel.initialize(Collections.singleton(EcorePackage.eINSTANCE));
        ecoreGenModel.setImportManager(getImportManager());
        ecoreGenPackage = ecoreGenModel.getGenPackages().get(0);
        ecoreGenPackage.setPrefix("Ecore");
        ecoreGenPackage.setBasePackage("org.eclipse.emf");
      }
      result = ecoreGenPackage;
    }
    else if (ePackage == XMLTypePackage.eINSTANCE)
    {
      if (xmlTypeGenPackage == null)
      {
        GenModel xmlTypeGenModel = getGenModel().createGenModel();
        xmlTypeGenModel.initialize(Collections.singleton(XMLTypePackage.eINSTANCE));
        xmlTypeGenModel.setImportManager(getImportManager());
        xmlTypeGenPackage = xmlTypeGenModel.getGenPackages().get(0);
        xmlTypeGenPackage.setPrefix("XMLType");
        xmlTypeGenPackage.setBasePackage("org.eclipse.emf.ecore.xml");
        xmlTypeGenPackage.setDataTypeConverters(true);
      }
      result = xmlTypeGenPackage;
    }
    else if (ePackage == XMLNamespacePackage.eINSTANCE)
    {
      if (xmlNamespaceGenPackage == null)
      {
        GenModel xmlNamespaceGenModel = getGenModel().createGenModel();
        xmlNamespaceGenModel.initialize(Collections.singleton(XMLNamespacePackage.eINSTANCE));
        xmlNamespaceGenModel.setImportManager(getImportManager());
        xmlNamespaceGenPackage = xmlNamespaceGenModel.getGenPackages().get(0);
        xmlNamespaceGenPackage.setPrefix("XMLNamespace");
        xmlNamespaceGenPackage.setBasePackage("org.eclipse.emf.ecore.xml");
      }
      result = xmlNamespaceGenPackage;
    }
    else if (ePackage != null)
    {
      for (Iterator<GenPackage> pIter = getAllGenPackages().iterator(); pIter.hasNext() && result == null; )
      {
        GenPackage genPackage = pIter.next();
        result = findGenPackageHelper(genPackage, ePackage);
      }
    }
    
    ePackageToGenPackageMap.put(ePackage, result);

    return result;
  }
  
  Map<EClassifier, GenClassifier> eClassifierToGenClassifierMap;
  
  @Override
  protected GenClass findGenClass(EClass eClass)
  {
    if (eClassifierToGenClassifierMap == null)
    {
      eClassifierToGenClassifierMap = new HashMap<EClassifier, GenClassifier>();
    }
    else
    {
      GenClass result = (GenClass)eClassifierToGenClassifierMap.get(eClass);
      if (result != null)
      {
        return result;
      }
    }

    EPackage ePackage = eClass.getEPackage();
    GenPackage genPackage = findGenPackage(ePackage);
    if (genPackage != null)
    {
      EPackage targetEPackage = genPackage.getEcorePackage();
      EClassifier targetEClassifier = targetEPackage == ePackage ? eClass : targetEPackage.getEClassifier(eClass.getName());
      EList<GenClass> genClasses = genPackage.getGenClasses();
      GenClass[] genClassesData = (GenClass[])((BasicEList<GenClass>)genClasses).data();
      for (int i = 0, size = genClasses.size(); i < size; ++i)
      {
        GenClass genClass = genClassesData[i];
        if (targetEClassifier == genClass.getEcoreClass())
        {
          eClassifierToGenClassifierMap.put(eClass, genClass);
          return genClass;
        }
      }
    }
    return null;
  }
  
  @Override
  protected GenEnum findGenEnum(EEnum eEnum)
  {
    if (eClassifierToGenClassifierMap == null)
    {
      eClassifierToGenClassifierMap = new HashMap<EClassifier, GenClassifier>();
    }
    else
    {
      GenEnum result = (GenEnum)eClassifierToGenClassifierMap.get(eEnum);
      if (result != null)
      {
        return result;
      }
    }

    GenPackage genPackage = findGenPackage(eEnum.getEPackage());
    if (genPackage != null)
    {
      for (GenEnum genEnum : genPackage.getGenEnums())
      {
        if (eEnum.getName().equals(genEnum.getEcoreEnum().getName())) //FB TBD different objects for ecore model!
        {
          eClassifierToGenClassifierMap.put(eEnum, genEnum);
          return genEnum;
        }
      }
    }
    return null;
  }

  @Override
  protected GenDataType findGenDataType(EDataType eDataType)
  {
    if (eClassifierToGenClassifierMap == null)
    {
      eClassifierToGenClassifierMap = new HashMap<EClassifier, GenClassifier>();
    }
    else
    {
      GenDataType result = (GenDataType)eClassifierToGenClassifierMap.get(eDataType);
      if (result != null)
      {
        return result;
      }
    }

    GenPackage genPackage = findGenPackage(eDataType.getEPackage());
    if (genPackage != null)
    {
      for (GenDataType genDataType : genPackage.getGenDataTypes())
      {
        if (eDataType.getName().equals(genDataType.getEcoreDataType().getName())) //FB TBD different objects for ecore model!
        {
          eClassifierToGenClassifierMap.put(eDataType, genDataType);
          return genDataType;
        }
      }
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GenModelPackage.Literals.GEN_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCopyrightText()
  {
    return copyrightText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCopyrightText(String newCopyrightText)
  {
    String oldCopyrightText = copyrightText;
    copyrightText = newCopyrightText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__COPYRIGHT_TEXT, oldCopyrightText, copyrightText));
  }

  protected String getSourceFragmentPath()
  {
    return "src";
  }

  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelDirectory()
  {
    return modelDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelDirectoryGen()
  {
    return modelDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelDirectory(String newModelDirectory)
  {
    String oldModelDirectory = modelDirectory;
    modelDirectory = newModelDirectory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__MODEL_DIRECTORY, oldModelDirectory, modelDirectory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCreationCommands()
  {
    return creationCommands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreationCommands(boolean newCreationCommands)
  {
    boolean oldCreationCommands = creationCommands;
    creationCommands = newCreationCommands;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__CREATION_COMMANDS, oldCreationCommands, creationCommands));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCreationIcons()
  {
    return creationIcons;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreationIcons(boolean newCreationIcons)
  {
    boolean oldCreationIcons = creationIcons;
    creationIcons = newCreationIcons;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__CREATION_ICONS, oldCreationIcons, creationIcons));
  }

  protected ImportManager importManager;
  protected StringBuffer importStringBuffer;
  protected int importInsertionPoint;
  protected boolean canGenerate;

  public void markImportLocation(StringBuffer stringBuffer, GenPackage genPackage)
  {
    markImportLocation(stringBuffer);
    importManager.addJavaLangImports(genPackage.getJavaLangConflicts());
  }

  public void markImportLocation(StringBuffer stringBuffer)
  {
    importStringBuffer = stringBuffer;
    importInsertionPoint = stringBuffer.length();
    importManager.addCompilationUnitImports(stringBuffer.toString());
  }

  public void emitSortedImports()
  {
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
  }

  public String getImportedName(String qualifiedName)
  {
    int index = qualifiedName.indexOf("<");
    if (index >= 0)
    {
      String baseName = qualifiedName.substring(0, index);
      StringBuilder result = new StringBuilder(getImportedName(baseName));
      result.append("<");
      for (int start = ++index,  end = qualifiedName.lastIndexOf(">") +  1; index < end; ++index)
      {
        char character = qualifiedName.charAt(index);
        switch (character)
        {
          case ' ': 
          case ',': 
          case '<': 
          case '>': 
          case '&': 
          {
            if (start != index)
            {
              String segment = qualifiedName.substring(start, index);
              result.append(getImportedName(segment));
            }
            result.append(character);
            start = index + 1;
            break;
          }
          default:
          {
            break;
          }
        }
      }
      return result.toString();
    }
   
    index = qualifiedName.indexOf("$");
    String baseName = index == -1 ? qualifiedName : qualifiedName.substring(0, index);
    if (baseName.contains("."))
    {
      importManager.addImport(index == -1 ? qualifiedName : qualifiedName.substring(0, index));
      return importManager.getImportedName(qualifiedName);
    }
    else
    {
      return qualifiedName;
    }
  }

  public void addImport(String qualifiedName)
  {
    importManager.addImport(qualifiedName);
  }

  public void addPseudoImport(String qualifiedName)
  {
    importManager.addPseudoImport(qualifiedName);
  }

  @Override
  public ImportManager getImportManager()
  {
    return importManager;
  }

  @Override
  public void setImportManager(ImportManager importManager)
  {
    this.importManager = importManager;

    // We also need to set it on any GenModels holding any used or static packages that may be refered to.
    //
    for (GenPackage genPackage : getUsedGenPackages())
    {
      genPackage.getGenModel().setImportManager(importManager);
    }

    for (GenPackage genPackage : getStaticGenPackages())
    {
      genPackage.getGenModel().setImportManager(importManager);
    }

    // And we need to set it on any cached GenModels holding the special Ecore and XML packages.
    //
    if (ecoreGenPackage != null && ecoreGenPackage.getGenModel().getImportManager() != importManager)
    {
      ecoreGenPackage.getGenModel().setImportManager(importManager);
    }
    if (xmlTypeGenPackage != null && xmlTypeGenPackage.getGenModel().getImportManager() != importManager)
    {
      xmlTypeGenPackage.getGenModel().setImportManager(importManager);
    }
    if (xmlNamespaceGenPackage != null && xmlNamespaceGenPackage.getGenModel().getImportManager() != importManager)
    {
      xmlNamespaceGenPackage.getGenModel().setImportManager(importManager);
    }
  }

  public String getDriverNumber()
  {
    //TBD
    // EATM return "jet0000";
    return null;
  }

  public String getDate()
  {
    //TBD
    // EATM return "mm-dd-yyyy";
    return null;
  }

  public String getNonNLS()
  {
    return isNonNLSMarkers() ? " //$NON-NLS-1$" : "";
  }

  public String getNonNLS(int i)
  {
    if (isNonNLSMarkers())
    {
      StringBuffer result = new StringBuffer(15);
      result.append(" //$NON-NLS-");
      result.append(i);
      result.append('$');
      return result.toString();
    }
    return "";
  }

  public String getNonNLS(String s)
  {
    return getNonNLS(s, 1);
  }

  public String getNonNLS(String s, int i)
  {
    if (s == null) return "";

    StringBuffer result = new StringBuffer(15);
    boolean openQuote = true;
    int j = s.indexOf('\"');

    while (j != -1)
    {
      if (openQuote) result.append(getNonNLS(i++));
      openQuote = !openQuote;
      j = s.indexOf('\"', j + 1);
    }
    return result.toString();
  }

  public void initialize(Collection<? extends EPackage> ePackages)
  {
    LOOP:
    for (EPackage ePackage : ePackages)
    {
      for (GenPackage genPackage : getGenPackages())
      {
        if (genPackage.getEcorePackage() == ePackage)
        {
          genPackage.initialize(ePackage);
          continue LOOP;
        }
      }

      GenPackage genPackage = createGenPackage();
      getGenPackages().add(genPackage);
      genPackage.initialize(ePackage);
    }
  }

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String jControlModelName = "emf-merge.xml";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String interfaceTemplateName = "model/Interface.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String classTemplateName = "model/Class.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String enumClassTemplateName = "model/EnumClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String packageClassTemplateName = "model/PackageClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String factoryInterfaceTemplateName = "model/FactoryInterface.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String factoryClassTemplateName = "model/FactoryClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String adapterFactoryClassTemplateName = "model/AdapterFactoryClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String switchClassTemplateName = "model/SwitchClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String validatorSwitchClassTemplateName = "model/ValidatorClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String xmlProcessorClassTemplateName = "model/XMLProcessorClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String pluginXMLTemplateName = "model/plugin.xmljet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String manifestMFTemplateName = "model/manifest.mfjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String pluginPropertiesTemplateName = "model/plugin.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String buildPropertiesTemplateName = "model/build.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String modelPluginTemplateName = "model/Plugin.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String resourceTemplateName = "model/ResourceClass.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String resourceFactoryTemplateName = "model/ResourceFactoryClass.javajet";


  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String [] templatePath = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JControlModel jControlModel = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter interfaceEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter classEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter enumClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter packageInterfaceEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter packageClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter factoryInterfaceEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter factoryClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter adapterFactoryClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter switchClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter validatorSwitchClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter xmlProcessorClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter pluginXMLEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter manifestMFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter pluginPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter buildPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter modelPluginClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter resourceClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter resourceFactoryClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.Generator.Options Generator.Options} provides an
   * equivalent way to obtain this information. This method will be removed after 2.2.
   */
  @Deprecated
  protected String [] getTemplatePath()
  {
    if (templatePath == null)
    {
      templatePath = new String[2];
    }
    String theTemplateDirectory = getTemplateDirectory();
    templatePath[0] = 
      !isDynamicTemplates() ? 
        null :
        theTemplateDirectory != null && theTemplateDirectory.indexOf(":") == -1 ? 
          URI.createPlatformResourceURI(theTemplateDirectory).toString() :
          theTemplateDirectory;
    templatePath[1] =  CodeGenEcorePlugin.INSTANCE.getBaseURL().toString() + "templates";
    return templatePath;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.Generator.Options Generator.Options} provides an
   * equivalent way to obtain this information. This method will be removed after 2.2.
   */
  @Deprecated
  public String getMergeRulesLocation()
  {
    return JETCompiler.find(getTemplatePath(), jControlModelName);
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.Generator Generator} provides an equivalent to this method.
   * This method will be removed after 2.2.
   */
  @Deprecated
  public JControlModel getJControlModel()
  {
    if (jControlModel == null)
    {
      jControlModel = new JControlModel();
    }
    return jControlModel;
  }

  /**
   * @deprecated in EMF 2.2. This field will be removed after 2.2.
   */
  @Deprecated
  public static final Class<?>[] OBJECT_ARGUMENT = new Class[]{ Object.class };

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Deprecated
  public void setMethod(JETEmitter jetEmitter, String className)
  {
    if (!isDynamicTemplates())
    {
      try
      {
        Class emitterClass = getClass().getClassLoader().loadClass(className);
        Method emitterMethod = emitterClass.getDeclaredMethod("generate", OBJECT_ARGUMENT);
        jetEmitter.setMethod(emitterMethod);
      }
      catch (Exception exception)
      {
        // It's okay for there not be a precompiled template, so fail quietly.
        // exception.printStackTrace();
      }
    }
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter createJETEmitter(String relativeTemplateURI)
  {
    JETEmitter jetEmitter = 
      new JETEmitter(getTemplatePath(), relativeTemplateURI, getClass().getClassLoader())
      {
        @Override
        public void initialize(Monitor progressMonitor) throws JETException
        {
          if (getClasspathEntries().isEmpty())
          {
            addClasspathEntries(this);
          }
          super.initialize(progressMonitor);
        }
      };
    return jetEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  protected void addClasspathEntries(JETEmitter jetEmitter) throws JETException
  {
    jetEmitter.addVariable("EMF_CODEGEN", "org.eclipse.emf.codegen");
    jetEmitter.addVariable("EMF_CODEGEN_ECORE", "org.eclipse.emf.codegen.ecore");
    jetEmitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
    jetEmitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getClassEmitter()
  {
    if (classEmitter == null)
    {
      classEmitter = createJETEmitter(classTemplateName);
      setMethod(classEmitter, "org.eclipse.emf.codegen.ecore.templates.model.Class");
    }
    return classEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEnumClassEmitter()
  {
    if (enumClassEmitter == null)
    {
      enumClassEmitter = createJETEmitter(enumClassTemplateName);
      setMethod(enumClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.EnumClass");
    }
    return enumClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getFactoryClassEmitter()
  {
    if (factoryClassEmitter == null)
    {
      factoryClassEmitter = createJETEmitter(factoryClassTemplateName);
      setMethod(factoryClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.FactoryClass");
    }
    return factoryClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getPackageClassEmitter()
  {
    if (packageClassEmitter == null)
    {
      packageClassEmitter = createJETEmitter(packageClassTemplateName);
      setMethod(packageClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.PackageClass");
    }
    return packageClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getAdapterFactoryClassEmitter()
  {
    if (adapterFactoryClassEmitter == null)
    {
      adapterFactoryClassEmitter = createJETEmitter(adapterFactoryClassTemplateName);
      setMethod(adapterFactoryClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.AdapterFactoryClass");
    }
    return adapterFactoryClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getSwitchClassEmitter()
  {
    if (switchClassEmitter == null)
    {
      switchClassEmitter = createJETEmitter(switchClassTemplateName);
      setMethod(switchClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.SwitchClass");
    }
    return switchClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getValidatorClassEmitter()
  {
    if (validatorSwitchClassEmitter == null)
    {
      validatorSwitchClassEmitter = createJETEmitter(validatorSwitchClassTemplateName);
      setMethod(validatorSwitchClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.ValidatorClass");
    }
    return validatorSwitchClassEmitter;
  }
  
  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getXMLProcessorClassEmitter()
  {
    if (xmlProcessorClassEmitter == null)
    {
      xmlProcessorClassEmitter = createJETEmitter(xmlProcessorClassTemplateName);
      setMethod(xmlProcessorClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.XMLProcessorClass");
    }
    return xmlProcessorClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getPluginXMLEmitter()
  {
    if (pluginXMLEmitter == null)
    {
      pluginXMLEmitter = createJETEmitter(pluginXMLTemplateName);
      setMethod(pluginXMLEmitter, "org.eclipse.emf.codegen.ecore.templates.model.PluginXML");
    }
    return pluginXMLEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getManifestMFEmitter()
  {
    if (manifestMFEmitter == null)
    {
      manifestMFEmitter = createJETEmitter(manifestMFTemplateName);
      setMethod(manifestMFEmitter, "org.eclipse.emf.codegen.ecore.templates.model.ManifestMF");
    }
    return manifestMFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getPluginPropertiesEmitter()
  {
    if (pluginPropertiesEmitter == null)
    {
      pluginPropertiesEmitter = createJETEmitter(pluginPropertiesTemplateName);
      setMethod(pluginPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.model.PluginProperties");
    }
    return pluginPropertiesEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getBuildPropertiesEmitter()
  {
    if (buildPropertiesEmitter == null)
    {
      buildPropertiesEmitter = createJETEmitter(buildPropertiesTemplateName);
      setMethod(buildPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.model.BuildProperties");
    }
    return buildPropertiesEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getModelPluginClassEmitter()
  {
    if (modelPluginClassEmitter == null)
    {
      modelPluginClassEmitter = createJETEmitter(modelPluginTemplateName);
      setMethod(modelPluginClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.Plugin");
    }
    return modelPluginClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getResourceClassEmitter()
  {
    if (resourceClassEmitter == null)
    {
      resourceClassEmitter = createJETEmitter(resourceTemplateName);
      setMethod(resourceClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.ResourceClass");
    }
    return resourceClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getResourceFactoryClassEmitter()
  {
    if (resourceFactoryClassEmitter == null)
    {
      resourceFactoryClassEmitter = createJETEmitter(resourceFactoryTemplateName);
      setMethod(resourceFactoryClassEmitter, "org.eclipse.emf.codegen.ecore.templates.model.ResourceFactoryClass");
    }
    return resourceFactoryClassEmitter;
  }

  protected boolean hasModelSupport()
  {
    return !isBlank(getModelDirectory());
    // Don't care about plugin class; we can generate a model without one.
  }

  @Override
  public boolean canGenerate()
  {
    return canGenerate && hasModelSupport();
  }

  public void setCanGenerate(boolean canGenerate)
  {
    this.canGenerate = canGenerate;
  }

  public IStatus validate()
  {
    return BasicDiagnostic.toIStatus(diagnose());
  }
  
  public boolean isValidateModel()
  {
    return validateModel;
  }
  
  public void setValidateModel(boolean validateModel)
  {
    this.validateModel = validateModel;
  }

  public Diagnostic diagnose()
  {
    BasicDiagnostic status =
      new BasicDiagnostic
        (CodeGenEcorePlugin.INSTANCE.getSymbolicName(),
         0,
         CodeGenEcorePlugin.INSTANCE.getString("_UI_ProblemsEncounteredInTheModel_message"),
         null);

    List<EObject> all = new ArrayList<EObject>(getGenPackages());
    all.addAll(getUsedGenPackages());
    for (EObject eObject : new ArrayList<EObject>(all))
    {
      EObject root = EcoreUtil.getRootContainer(((GenPackage)eObject).getEcorePackage());
      if (!all.contains(root))
      {
        all.add(root);
      }
    }

    all.addAll(getGenAnnotations());
    Map<EObject, Collection<EStructuralFeature.Setting>> map = EcoreUtil.UnresolvedProxyCrossReferencer.find(all);
    if (!map.isEmpty())
    {
      for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map.entrySet())
      {
        EObject unresolvedProxy = entry.getKey();
        BasicDiagnostic nestedStatus =
          new BasicDiagnostic
            (CodeGenEcorePlugin.INSTANCE.getSymbolicName(),
             0,
             CodeGenEcorePlugin.INSTANCE.getString
               ("_UI_UnableToResolveProxy_message", new Object [] { EcoreUtil.getURI(unresolvedProxy) }),
             null);

        for (EStructuralFeature.Setting setting : entry.getValue())
        {
          if (!setting.getEStructuralFeature().isDerived())
          {
            nestedStatus.add
              (new BasicDiagnostic
                (Diagnostic.ERROR,
                    CodeGenEcorePlugin.INSTANCE.getSymbolicName(),
                 0,
                 CodeGenEcorePlugin.INSTANCE.getString
                   ("_UI_ItsUseIsBy_message", new Object [] { EcoreUtil.getURI(setting.getEObject()) }),
                 null));
          }
        }

        status.add(nestedStatus);
      }
    }
    else
    {
      List<EPackage> referencedEPackages = new UniqueEList<EPackage>();
      for (EObject object : all)
      {
        if (object instanceof EPackage)
        {
          EPackage ePackage = (EPackage)object;
          for (Iterator<EObject> j = ePackage.eAllContents(); j.hasNext();)
          {
            EObject eObject = j.next();
            for (EObject o : eObject.eCrossReferences())
            {
              if (o instanceof EClassifier)
              {
                EClassifier eClassifier = (EClassifier)o;
                referencedEPackages.add(eClassifier.getEPackage());
              }
            }
          }
        }
      }
    
      for (EPackage ePackage : referencedEPackages)
      {
        GenPackage genPackage = findGenPackage(ePackage);
        if (genPackage == null)
        {
          status.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
                  CodeGenEcorePlugin.INSTANCE.getSymbolicName(),
               0,
               CodeGenEcorePlugin.INSTANCE.getString("_UI_ThePackageIsNeeded_message", new Object [] { EcoreUtil.getURI(ePackage) }),
               null));
        }
        else if (genPackage.getEcorePackage() != ePackage)
        {
          status.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
                  CodeGenEcorePlugin.INSTANCE.getSymbolicName(),
               0,
               CodeGenEcorePlugin.INSTANCE.getString
                 ("_UI_ThePackageHasTheSameNamespaceURI", 
                  new Object [] { EcoreUtil.getURI(ePackage), ePackage.getNsURI(), EcoreUtil.getURI(genPackage.getEcorePackage()) }),
               null));
        }
      }

      if (isValidateModel())
      {
        for (GenPackage genPackage : getAllGenPackages())
        {
          EPackage ePackage = genPackage.getEcorePackage();
          if (ePackage != null)
          {
            Diagnostician diagnostician = 
              new Diagnostician(EValidator.Registry.INSTANCE)
              {
                @Override
                public String getObjectLabel(EObject object)
                {
                  return EcoreUtil.getURI(object).toString();
                }
              };
            Diagnostic diagnostic = diagnostician.validate(ePackage);
            if (diagnostic.getSeverity() == Diagnostic.ERROR)
            {
              status.addAll(diagnostic);
            }
            else if (diagnostic.getSeverity() == Diagnostic.WARNING)
            {
              // If there are any warnings other than raw type warnings, include all the warnings.
              //
              for (Diagnostic child : diagnostic.getChildren())
              {
                if (!EcoreValidator.DIAGNOSTIC_SOURCE.equals(child.getSource()) ||
                      child.getCode() != EcoreValidator.CONSISTENT_ARGUMENTS_NONE)
                {
                  status.addAll(diagnostic);
                  break;
                }
              }
            }
          }
        }
      }
    }

    return status;
  }

  protected ExtendedMetaData extendedMetaData;
  
  @Override
  public ExtendedMetaData getExtendedMetaData()
  {
    if (extendedMetaData == null)
    {
      extendedMetaData = 
        new BasicExtendedMetaData
          (eResource() == null || eResource().getResourceSet() == null ? 
             new EPackageRegistryImpl(EPackage.Registry.INSTANCE) :
             eResource().getResourceSet().getPackageRegistry());
      populateExtendedMetaData(getGenPackages());
      populateExtendedMetaData(getStaticGenPackages());
      populateExtendedMetaData(getUsedGenPackages());

      if (extendedMetaData.getPackage(ExtendedMetaData.XML_SCHEMA_URI) == null)
      {
        extendedMetaData.putPackage(ExtendedMetaData.XML_SCHEMA_URI, extendedMetaData.getPackage(XMLTypePackage.eNS_URI));
      }
    }
    return extendedMetaData;
  }

  protected void populateExtendedMetaData(List<GenPackage> genPackages)
  {
    for (GenPackage genPackage : genPackages)
    {
      EPackage ePackage = genPackage.getEcorePackage();
      if (ePackage != null)  // genPackage can be a broken proxy
      {
        if (!EcorePackage.eNS_URI.equals(ePackage.getNsURI()) && ! GenModelPackage.eNS_URI.equals(ePackage.getNsURI()))
        {
          extendedMetaData.putPackage(ePackage.getNsURI(), ePackage);
        }
        populateExtendedMetaData(genPackage.getSubGenPackages());
      }
    }
  }

  public boolean hasPluginSupport()
  {
    return !isBlank(getModelPluginID());
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.Generator Generator} should be used to generate code.
   * This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Override
  @Deprecated
  public void generate(Monitor progressMonitor)
  {
    try
    {
      if (!canGenerate()) return;

      getStaticGenPackages();

      progressMonitor.beginTask("", getGenPackages().size() + 3);
      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingPackages_message"));

      // Force the project to be setup properly.
      //
      if (isUpdateClasspath() && EMFPlugin.IS_ECLIPSE_RUNNING)
      {
        EclipseUtil.findOrCreateContainer
          ((GenModel)this,
           createMonitor(progressMonitor, 1), 
           Generator.EMF_MODEL_PROJECT_STYLE, 
           getEffectiveModelPluginVariables(),
           getModelDirectory(), 
           true);
      }

      for (Iterator iter = getGenPackages().iterator(); iter.hasNext(); )
      {
        GenPackage genPackage = (GenPackage)iter.next();
        progressMonitor.subTask
          (CodeGenEcorePlugin.INSTANCE.getString
             ("_UI_GeneratingJavaPackage_message", new Object [] { genPackage.getInterfacePackageName() }));
        genPackage.generate(createMonitor(progressMonitor, 1));
      }

      if (hasModelPluginClass())
      {
        progressMonitor.subTask
          (CodeGenEcorePlugin.INSTANCE.getString
             ("_UI_GeneratingJavaClass_message", new Object [] { getQualifiedModelPluginClassName() }));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_MODEL_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getModelDirectory(),
           getModelPluginPackageName(),
           getModelPluginClassName(),
           getModelPluginClassEmitter());
      }

      if (hasPluginSupport())
      {
        if (!sameModelEditProject() && !sameModelEditorProject())
        {
          if (isBundleManifest())
          {
            progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingModelManifestMF_message"));
            generate
              (createMonitor(progressMonitor, 1),
               Generator.EMF_MODEL_PROJECT_STYLE,
               getEffectiveModelPluginVariables(),
               getModelProjectDirectory() + "/META-INF/MANIFEST.MF",
               getManifestMFEmitter());          
          }
          
          progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingModelPluginXML_message"));
          generate
            (createMonitor(progressMonitor, 1),
             Generator.EMF_MODEL_PROJECT_STYLE,
             getEffectiveModelPluginVariables(),
             getModelProjectDirectory() + "/plugin.xml",
             getPluginXMLEmitter());
        }
  
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingModelPluginProperties_message"));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_MODEL_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getModelProjectDirectory() + "/plugin.properties",
           getPluginPropertiesEmitter());
        
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingModelBuildProperties_message"));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_MODEL_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getModelProjectDirectory() + "/build.properties",
           getBuildPropertiesEmitter());       
      }
    }
    finally
    {
      progressMonitor.done();
    }
  }

  public boolean hasEditSupport()
  {
    return 
      hasPluginSupport() &&
      !isBlank(getEditPluginClassToUse()) &&
      !isBlank(getEditDirectory());
  }

  @Override
  public boolean canGenerateEdit()
  {
    return canGenerate && hasEditSupport();
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.Generator Generator} should be used to generate code.
   * This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Override
  @Deprecated
  public void generateEdit(Monitor progressMonitor)
  {
    try
    {
      if (!canGenerateEdit()) return;

      getStaticGenPackages();

      progressMonitor.beginTask("", getGenPackages().size() + 1);

      // Force the project to be setup properly.
      //
      if (EMFPlugin.IS_ECLIPSE_RUNNING && isUpdateClasspath())
      {
        EclipseUtil.findOrCreateContainer
          ((GenModel)this,
           createMonitor(progressMonitor, 1), 
           Generator.EMF_EDIT_PROJECT_STYLE, 
           getEffectiveModelPluginVariables(),
           getEditDirectory(), 
           true);
      }

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditPackages_message"));
      for (Iterator iter = getGenPackages().iterator(); iter.hasNext(); )
      {
        GenPackage genPackage = (GenPackage)iter.next();
        progressMonitor.subTask
          (CodeGenEcorePlugin.INSTANCE.getString
             ("_UI_GeneratingJavaPackage_message", new Object [] { genPackage.getInterfacePackageName() }));
        genPackage.generateEdit(createMonitor(progressMonitor, 1));
      }

      if (!sameEditEditorProject())
      {
        progressMonitor.subTask
          (CodeGenEcorePlugin.INSTANCE.getString
             ("_UI_GeneratingJavaClass_message", new Object [] { getQualifiedEditPluginClassName() }));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_EDIT_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getEditPluginDirectory(),
           getEditPluginPackageName(),
           getEditPluginClassName(),
           getEditPluginClassEmitter());

        if (isBundleManifest())
        {
          progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditManifestMF_message"));
          generate
            (createMonitor(progressMonitor, 1),
             Generator.EMF_EDIT_PROJECT_STYLE,
             getEffectiveModelPluginVariables(),
             getEditProjectDirectory() + "/META-INF/MANIFEST.MF",
             getEditManifestMFEmitter());
        }
        
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditPluginXML_message"));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_EDIT_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getEditProjectDirectory() + "/plugin.xml",
           getEditPluginXMLEmitter());
      }

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditPluginProperties_message"));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDIT_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditProjectDirectory() + "/plugin.properties",
         getEditPluginPropertiesEmitter());

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditBuildProperties_message"));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDIT_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditProjectDirectory() + "/build.properties",
         getEditBuildPropertiesEmitter());
    }
    finally
    {
      progressMonitor.done();
    }
  }

  public boolean hasEditorSupport()
  {
    return 
      hasPluginSupport() &&
      !isBlank(getEditorPluginClassToUse()) &&
      !isBlank(getEditorDirectory());
  }

  @Override
  public boolean canGenerateEditor()
  {
    return canGenerate && hasEditorSupport();
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.Generator Generator} should be used to generate code.
   * This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Override
  @Deprecated
  public void generateEditor(Monitor progressMonitor)
  {
    try
    {
      if (!canGenerateEditor()) return;

      getStaticGenPackages();

      progressMonitor.beginTask("", getGenPackages().size() + 1);

      // Force the project to be setup properly.
      //
      if (EMFPlugin.IS_ECLIPSE_RUNNING && isUpdateClasspath())
      {
        EclipseUtil.findOrCreateContainer
          ((GenModel)this,
           createMonitor(progressMonitor, 1), 
           Generator.EMF_EDITOR_PROJECT_STYLE, 
           getEffectiveModelPluginVariables(),
           getEditorDirectory(), 
           true);
      }

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditorPackages_message"));
      for (Iterator iter = getGenPackages().iterator(); iter.hasNext(); )
      {
        GenPackage genPackage = (GenPackage)iter.next();
        progressMonitor.subTask
          (CodeGenEcorePlugin.INSTANCE.getString
             ("_UI_GeneratingJavaPackage_message", new Object [] { genPackage.getInterfacePackageName() }));
        genPackage.generateEditor(createMonitor(progressMonitor, 1));
      }

      progressMonitor.subTask
        (CodeGenEcorePlugin.INSTANCE.getString
           ("_UI_GeneratingJavaClass_message", new Object [] { getQualifiedEditorPluginClassName() }));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDITOR_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditorPluginDirectory(),
         getEditorPluginPackageName(),
         getEditorPluginClassName(),
         getEditorPluginClassEmitter());

      if (isBundleManifest())
      {
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditorManifestMF_message"));
        generate
          (createMonitor(progressMonitor, 1),
           Generator.EMF_EDITOR_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getEditorProjectDirectory() + "/META-INF/MANIFEST.MF",
           getEditorManifestMFEmitter());
      }
      
      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditorPluginXML_message"));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDITOR_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditorProjectDirectory() + "/plugin.xml",
         getEditorPluginXMLEmitter());
            
      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditorPluginProperties_message"));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDITOR_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditorProjectDirectory() + "/plugin.properties",
         getEditorPluginPropertiesEmitter());

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingEditorBuildProperties_message"));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDITOR_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditorProjectDirectory() + "/build.properties",
         getEditorBuildPropertiesEmitter());
      
      if (getGenModel().isRichClientPlatform())
      {
        progressMonitor.subTask
        (CodeGenEcorePlugin.INSTANCE.getString
           ("_UI_GeneratingJavaClass_message", new Object [] { getQualifiedEditorAdvisorClassName() }));
      generate
        (createMonitor(progressMonitor, 1),
         Generator.EMF_EDITOR_PROJECT_STYLE,
         getEffectiveModelPluginVariables(),
         getEditorPluginDirectory(),
         getEditorPluginPackageName(),
         getEditorAdvisorClassName(),
         getEditorAdvisorEmitter());
      }      
    }
    finally
    {
      progressMonitor.done();
    }
  }
  
  /**
   * @deprecated In EMF 2.2, schema generation is properly done via a model exporter. This method will be removed after 2.2.
   */
  @Override
  @Deprecated
  public boolean canGenerateSchema()
  {
    return canGenerate();
  }
  
  /**
   * @deprecated In EMF 2.2, schema generation is properly done via a model exporter. This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Override
  @Deprecated
  public void generateSchema(Monitor progressMonitor)
  {
    for (Iterator i = getGenPackages().iterator(); i.hasNext();)
    {
      ((GenPackage)i.next()).generateSchema(createMonitor(progressMonitor, 1));
    }
  }
  
  public boolean hasTestSupport()
  {
    return hasModelSupport() && !isBlank(getTestsDirectory());
  }

  @Override
  public boolean canGenerateTests()
  {
    return canGenerate && hasTestSupport();
  }

  /**
   * @deprecated In EMF 2.2, schema generation is properly done via a model exporter. This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Override
  @Deprecated
  public void generateTests(Monitor progressMonitor)
  {
    try
    {
      if (!canGenerateTests())
        return;

      progressMonitor.beginTask("", getGenPackages().size() + 4);

      if (isUpdateClasspath() && EMFPlugin.IS_ECLIPSE_RUNNING)
      {
        EclipseUtil.findOrCreateContainer
          ((GenModel)this,
           createMonitor(progressMonitor, 1),
           Generator.EMF_TESTS_PROJECT_STYLE,
           getEffectiveModelPluginVariables(),
           getTestsDirectory(),
           true);
      }

      progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingTestsPackages_message"));
      for (Iterator genPackages = getGenPackages().iterator(); genPackages.hasNext();)
      {
        GenPackage genPackage = (GenPackage)genPackages.next();
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString(
          "_UI_GeneratingJavaPackage_message",
          new Object []{ genPackage.getTestsPackageName() }));
        genPackage.generateTests(createMonitor(progressMonitor, 1));
      }

      if (!isBlank(getTestSuiteClass()))
      {
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString(
          "_UI_GeneratingJavaClass_message",
          new Object []{ getQualifiedTestSuiteClassName() }));
        generate(
          createMonitor(progressMonitor, 1),
          Generator.EMF_TESTS_PROJECT_STYLE,
          getEffectiveModelPluginVariables(),
          getTestsDirectory(),
          getTestSuitePackageName(),
          getTestSuiteClassName(),
          getModelTestSuiteEmitter());
      }

      if (!sameModelTestsProject())
      {
        if (isBundleManifest())
        {
          progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingTestsManifestMF_message"));
          generate
            (createMonitor(progressMonitor, 1),
             Generator.EMF_TESTS_PROJECT_STYLE,
             getEffectiveModelPluginVariables(),
             getTestsProjectDirectory() + "/META-INF/MANIFEST.MF",
             getTestsManifestMFEmitter());
        }        
        
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingTestsPluginXML_message"));
        generate(
          createMonitor(progressMonitor, 1),
          Generator.EMF_TESTS_PROJECT_STYLE,
          getEffectiveModelPluginVariables(),
          getTestsProjectDirectory() + "/plugin.xml",
          getTestsPluginXMLEmitter());
        
        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingTestsPluginProperties_message"));
        generate(
          createMonitor(progressMonitor, 1),
          Generator.EMF_TESTS_PROJECT_STYLE,
          getEffectiveModelPluginVariables(),
          getTestsProjectDirectory() + "/plugin.properties",
          getTestsPluginPropertiesEmitter());

        progressMonitor.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingTestsBuildProperties_message"));
        generate(
          createMonitor(progressMonitor, 1),
          Generator.EMF_TESTS_PROJECT_STYLE,
          getEffectiveModelPluginVariables(),
          getTestsProjectDirectory() + "/build.properties",
          getTestsBuildPropertiesEmitter());
      }
    }
    finally
    {
      progressMonitor.done();
    }
  }
  
  //
  // EMFEdit generation
  //

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String itemProviderTemplateName = "edit/ItemProvider.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String itemProviderAdapterFactoryTemplateName = "edit/ItemProviderAdapterFactory.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editPluginTemplateName = "edit/Plugin.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editPluginXMLTemplateName = "edit/plugin.xmljet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editManifestMFTemplateName = "edit/manifest.mfjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editPluginPropertiesTemplateName = "edit/plugin.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editBuildPropertiesTemplateName = "edit/build.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String itemGIFName = "edit/Item.gif";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String createChildGIFName = "edit/CreateChild.gif";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorTemplateName = "editor/Editor.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String actionBarContributorTemplateName = "editor/ActionBarContributor.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String modelWizardTemplateName = "editor/ModelWizard.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String advisorTemplateName = "editor/Advisor.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorPluginTemplateName = "editor/Plugin.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorPluginXMLTemplateName = "editor/plugin.xmljet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorManifestMFTemplateName = "editor/manifest.mfjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorPluginPropertiesTemplateName = "editor/plugin.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String editorBuildPropertiesTemplateName = "editor/build.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String modelGIFName = "editor/ModelFile.gif";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String modelWizardGIFName = "editor/NewModel.gif";


  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter itemProviderEmitter = null;
 //   protected JETEmitter extendedItemProviderEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter itemProviderAdapterFactoryEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editPluginClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editPluginXMLEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editManifestMFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editPluginPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editBuildPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected GIFEmitter itemGIFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected GIFEmitter createChildGIFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter actionBarContributorEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter modelWizardEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter advisorEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorPluginClassEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorManifestMFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorPluginXMLEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorPluginPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter editorBuildPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected GIFEmitter modelGIFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected GIFEmitter modelWizardGIFEmitter = null;

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getItemProviderEmitter()
  {
    if (itemProviderEmitter == null)
    {
      itemProviderEmitter = createJETEmitter(itemProviderTemplateName);
      setMethod(itemProviderEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.ItemProvider");
    }
    return itemProviderEmitter;
  }

 //   public JETEmitter getExtendedItemProviderEmitter()
 //   {
 //     if (extendedItemProviderEmitter == null)
 //     {
 //       extendedItemProviderEmitter = createJETEmitter(extendedItemProviderTemplateName);
 //       setMethod(extendedItemProviderEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.ExtendedItemProvider");
 //     }
 //     return extendedItemProviderEmitter;
 //   }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getItemProviderAdapterFactoryEmitter()
  {
    if (itemProviderAdapterFactoryEmitter == null)
    {
      itemProviderAdapterFactoryEmitter = createJETEmitter(itemProviderAdapterFactoryTemplateName);
      setMethod(itemProviderAdapterFactoryEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.ItemProviderAdapterFactory");
    }
    return itemProviderAdapterFactoryEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditPluginClassEmitter()
  {
    if (editPluginClassEmitter == null)
    {
      editPluginClassEmitter = createJETEmitter(editPluginTemplateName);
      setMethod(editPluginClassEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.Plugin");
    }
    return editPluginClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditPluginXMLEmitter()
  {
    if (editPluginXMLEmitter == null)
    {
      editPluginXMLEmitter = createJETEmitter(editPluginXMLTemplateName);
      setMethod(editPluginXMLEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.PluginXML");
    }
    return editPluginXMLEmitter;
  }
  
  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditManifestMFEmitter()
  {
    if (editManifestMFEmitter == null)
    {
      editManifestMFEmitter = createJETEmitter(editManifestMFTemplateName);
      setMethod(editManifestMFEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.ManifestMF");
    }

    return editManifestMFEmitter;
  }  

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditPluginPropertiesEmitter()
  {
    if (editPluginPropertiesEmitter == null)
    {
      editPluginPropertiesEmitter = createJETEmitter(editPluginPropertiesTemplateName);
      setMethod(editPluginPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.PluginProperties");
    }
    return editPluginPropertiesEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditBuildPropertiesEmitter()
  {
    if (editBuildPropertiesEmitter == null)
    {
      editBuildPropertiesEmitter = createJETEmitter(editBuildPropertiesTemplateName);
      setMethod(editBuildPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.edit.BuildProperties");
    }
    return editBuildPropertiesEmitter;
  }
  
  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public GIFEmitter getItemGIFEmitter()
  {
    if (itemGIFEmitter == null)
    {
      itemGIFEmitter = new GIFEmitter(JETCompiler.find(getTemplatePath(), itemGIFName));
    }
    return itemGIFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public GIFEmitter getCreateChildGIFEmitter()
  {
    if (createChildGIFEmitter == null)
    {
      createChildGIFEmitter = new GIFEmitter(JETCompiler.find(getTemplatePath(), createChildGIFName));
    }
    return createChildGIFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public GIFEmitter getModelGIFEmitter()
  {
    if (modelGIFEmitter == null)
    {
      modelGIFEmitter = new GIFEmitter(JETCompiler.find(getTemplatePath(), modelGIFName));
    }
    return modelGIFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public GIFEmitter getModelWizardGIFEmitter()
  {
    if (modelWizardGIFEmitter == null)
    {
      modelWizardGIFEmitter = new GIFEmitter(JETCompiler.find(getTemplatePath(), modelWizardGIFName));
    }
    return modelWizardGIFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorEmitter()
  {
    if (editorEmitter == null)
    {
      editorEmitter = createJETEmitter(editorTemplateName);
      setMethod(editorEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.Editor");
    }
    return editorEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getActionBarContributorEmitter()
  {
    if (actionBarContributorEmitter == null)
    {
      actionBarContributorEmitter = createJETEmitter(actionBarContributorTemplateName);
      setMethod(actionBarContributorEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.ActionBarContributor");
    }
    return actionBarContributorEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getModelWizardEmitter()
  {
    if (modelWizardEmitter == null)
    {
      modelWizardEmitter = createJETEmitter(modelWizardTemplateName);
      setMethod(modelWizardEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.ModelWizard");
    }
    return modelWizardEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorAdvisorEmitter()
  {
    if (advisorEmitter == null)
    {
      advisorEmitter = createJETEmitter(advisorTemplateName);
      setMethod(advisorEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.Advisor");
    }
    return advisorEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorPluginClassEmitter()
  {
    if (editorPluginClassEmitter == null)
    {
      editorPluginClassEmitter = createJETEmitter(editorPluginTemplateName);
      setMethod(editorPluginClassEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.Plugin");
    }
    return editorPluginClassEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorPluginXMLEmitter()
  {
    if (editorPluginXMLEmitter == null)
    {
      editorPluginXMLEmitter = createJETEmitter(editorPluginXMLTemplateName);
      setMethod(editorPluginXMLEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.PluginXML");
    }
    return editorPluginXMLEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorManifestMFEmitter()
  {
    if (editorManifestMFEmitter == null)
    {
      editorManifestMFEmitter = createJETEmitter(editorManifestMFTemplateName);
      setMethod(editorManifestMFEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.ManifestMF");
    }
    return editorManifestMFEmitter;
  }  

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorPluginPropertiesEmitter()
  {
    if (editorPluginPropertiesEmitter == null)
    {
      editorPluginPropertiesEmitter = createJETEmitter(editorPluginPropertiesTemplateName);
      setMethod(editorPluginPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.PluginProperties");
    }
    return editorPluginPropertiesEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getEditorBuildPropertiesEmitter()
  {
    if (editorBuildPropertiesEmitter == null)
    {
      editorBuildPropertiesEmitter = createJETEmitter(editorBuildPropertiesTemplateName);
      setMethod(editorBuildPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.editor.BuildProperties");
    }
    return editorBuildPropertiesEmitter;
  }

  //
  // Tests generation
  //

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String testCaseTemplateName = "model.tests/TestCase.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String modelTestSuiteTemplateName = "model.tests/ModelTestSuite.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String packageTestSuiteTemplateName = "model.tests/PackageTestSuite.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String packageExampleTemplateName = "model.tests/PackageExample.javajet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String testsPluginXMLTemplateName = "model.tests/plugin.xmljet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String testsManifestMFTemplateName = "model.tests/manifest.mfjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String testsPluginPropertiesTemplateName = "model.tests/plugin.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected String testsBuildPropertiesTemplateName = "model.tests/build.propertiesjet";

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter testCaseEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter modelTestSuiteEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter packageTestSuiteEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter packageExampleEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter testsPluginXMLEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter testsManifestMFEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter testsPluginPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @Deprecated
  protected JETEmitter testsBuildPropertiesEmitter = null;

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getTestCaseEmitter()
  {
    if (testCaseEmitter == null)
    {
      testCaseEmitter = createJETEmitter(testCaseTemplateName);
      setMethod(testCaseEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.TestCase");
    }

    return testCaseEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getModelTestSuiteEmitter()
  {
    if (modelTestSuiteEmitter == null)
    {
      modelTestSuiteEmitter = createJETEmitter(modelTestSuiteTemplateName);
      setMethod(modelTestSuiteEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.ModelTestSuite");
    }

    return modelTestSuiteEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getPackageTestSuiteEmitter()
  {
    if (packageTestSuiteEmitter == null)
    {
      packageTestSuiteEmitter = createJETEmitter(packageTestSuiteTemplateName);
      setMethod(packageTestSuiteEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageTestSuite");
    }

    return packageTestSuiteEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getPackageExampleEmitter()
  {
    if (packageExampleEmitter == null)
    {
      packageExampleEmitter = createJETEmitter(packageExampleTemplateName);
      setMethod(packageExampleEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageExample");
    }
    return packageExampleEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getTestsPluginXMLEmitter()
  {
    if (testsPluginXMLEmitter == null)
    {
      testsPluginXMLEmitter = createJETEmitter(testsPluginXMLTemplateName);
      setMethod(testsPluginXMLEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.PluginXML");
    }
    return testsPluginXMLEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getTestsManifestMFEmitter()
  {
    if (testsManifestMFEmitter == null)
    {
      testsManifestMFEmitter = createJETEmitter(testsManifestMFTemplateName);
      setMethod(testsManifestMFEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.ManifestMF");
    }
    return testsManifestMFEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getTestsPluginPropertiesEmitter()
  {
    if (testsPluginPropertiesEmitter == null)
    {
      testsPluginPropertiesEmitter = createJETEmitter(testsPluginPropertiesTemplateName);
      setMethod(testsPluginPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.PluginProperties");
    }
    return testsPluginPropertiesEmitter;
  }

  /**
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public JETEmitter getTestsBuildPropertiesEmitter()
  {
    if (testsBuildPropertiesEmitter == null)
    {
      testsBuildPropertiesEmitter = createJETEmitter(testsBuildPropertiesTemplateName);
      setMethod(testsBuildPropertiesEmitter, "org.eclipse.emf.codegen.ecore.templates.model.tests.BuildProperties");
    }
    return testsBuildPropertiesEmitter;
  }

  protected String getPluginDirectory(boolean isSet, String baseDirectory, String suffix)
  {
    if (!isSet)
    {
      String modelProject = getModelProject();
      if (modelProject != null)
      {
        return new StringBuffer("/").append(modelProject).append(suffix).append(getSourceFragmentPath()).toString();
      }
    }
    return baseDirectory;
  }
  
  public String getEditDirectory()
  {
    return getPluginDirectory(isSetEditDirectory(), getEditDirectoryGen(), ".edit/");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEditDirectoryGen()
  {
    return editDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEditDirectory(String newEditDirectory)
  {
    String oldEditDirectory = editDirectory;
    editDirectory = newEditDirectory;
    boolean oldEditDirectoryESet = editDirectoryESet;
    editDirectoryESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__EDIT_DIRECTORY, oldEditDirectory, editDirectory, !oldEditDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEditDirectory()
  {
    String oldEditDirectory = editDirectory;
    boolean oldEditDirectoryESet = editDirectoryESet;
    editDirectory = EDIT_DIRECTORY_EDEFAULT;
    editDirectoryESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__EDIT_DIRECTORY, oldEditDirectory, EDIT_DIRECTORY_EDEFAULT, oldEditDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEditDirectory()
  {
    return editDirectoryESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCreationSubmenus()
  {
    return creationSubmenus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreationSubmenus(boolean newCreationSubmenus)
  {
    boolean oldCreationSubmenus = creationSubmenus;
    creationSubmenus = newCreationSubmenus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__CREATION_SUBMENUS, oldCreationSubmenus, creationSubmenus));
  }

  public String getEditorDirectory()
  {
    return getPluginDirectory(isSetEditorDirectory(), getEditorDirectoryGen(), ".editor/");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEditorDirectoryGen()
  {
    return editorDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEditorDirectory(String newEditorDirectory)
  {
    String oldEditorDirectory = editorDirectory;
    editorDirectory = newEditorDirectory;
    boolean oldEditorDirectoryESet = editorDirectoryESet;
    editorDirectoryESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY, oldEditorDirectory, editorDirectory, !oldEditorDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEditorDirectory()
  {
    String oldEditorDirectory = editorDirectory;
    boolean oldEditorDirectoryESet = editorDirectoryESet;
    editorDirectory = EDITOR_DIRECTORY_EDEFAULT;
    editorDirectoryESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY, oldEditorDirectory, EDITOR_DIRECTORY_EDEFAULT, oldEditorDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEditorDirectory()
  {
    return editorDirectoryESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelPluginID()
  {
    return modelPluginID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelPluginID(String newModelPluginID)
  {
    String oldModelPluginID = modelPluginID;
    modelPluginID = newModelPluginID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__MODEL_PLUGIN_ID, oldModelPluginID, modelPluginID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTemplateDirectory()
  {
    return templateDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateDirectory(String newTemplateDirectory)
  {
    String oldTemplateDirectory = templateDirectory;
    templateDirectory = newTemplateDirectory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__TEMPLATE_DIRECTORY, oldTemplateDirectory, templateDirectory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRuntimeJar()
  {
    return runtimeJar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuntimeJar(boolean newRuntimeJar)
  {
    boolean oldRuntimeJar = runtimeJar;
    runtimeJar = newRuntimeJar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__RUNTIME_JAR, oldRuntimeJar, runtimeJar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getForeignModel()
  {
    if (foreignModel == null)
    {
      foreignModel = new EDataTypeUniqueEList<String>(String.class, this, GenModelPackage.GEN_MODEL__FOREIGN_MODEL);
    }
    return foreignModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDynamicTemplates()
  {
    return dynamicTemplates;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynamicTemplates(boolean newDynamicTemplates)
  {
    boolean oldDynamicTemplates = dynamicTemplates;
    dynamicTemplates = newDynamicTemplates;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__DYNAMIC_TEMPLATES, oldDynamicTemplates, dynamicTemplates));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRedirection()
  {
    return redirection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedirection(String newRedirection)
  {
    String oldRedirection = redirection;
    redirection = newRedirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__REDIRECTION, oldRedirection, redirection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isForceOverwrite()
  {
    return forceOverwrite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForceOverwrite(boolean newForceOverwrite)
  {
    boolean oldForceOverwrite = forceOverwrite;
    forceOverwrite = newForceOverwrite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FORCE_OVERWRITE, oldForceOverwrite, forceOverwrite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNonExternalizedStringTag()
  {
    return nonExternalizedStringTag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonExternalizedStringTagGen(String newNonExternalizedStringTag)
  {
    String oldNonExternalizedStringTag = nonExternalizedStringTag;
    nonExternalizedStringTag = newNonExternalizedStringTag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG, oldNonExternalizedStringTag, nonExternalizedStringTag));
  }

  public void setNonExternalizedStringTag(String newNonExternalizedStringTag)
  {
    setNonNLSMarkersGen(newNonExternalizedStringTag != null);
    setNonExternalizedStringTagGen(null);
  }

  @Override
  public String getName()
  {
    return getModelName();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelName()
  {
    return modelName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelName(String newModelName)
  {
    String oldModelName = modelName;
    modelName = newModelName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__MODEL_NAME, oldModelName, modelName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelPluginClass()
  {
    return modelPluginClass;
  }

  protected String getPluginClass(boolean isSet, String baseName, String packageSuffix, String classSuffix)
  {
    if (!isSet)
    {
      String modelName = getModelName();
      if (!isBlank(modelName))
      {
        String mainPackage = getMainPackage();
        if (mainPackage != null)
        {
          StringBuffer pluginClass = new StringBuffer(mainPackage);
          if (!isBlank(packageSuffix))
          {
            pluginClass.append(".").append(packageSuffix);
          }
          pluginClass.append(".").append(CodeGenUtil.validJavaIdentifier(modelName)). append(classSuffix);
          return pluginClass.toString();
        }
      }
    }
    return baseName;    
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelPluginClass(String newModelPluginClass)
  {
    String oldModelPluginClass = modelPluginClass;
    modelPluginClass = newModelPluginClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS, oldModelPluginClass, modelPluginClass));
  }

  public String getEditPluginClass()
  {
    String suffix = GenPackageImpl.PROVIDER_PACKAGE_SUFFIX_EDEFAULT;
    GenPackage genPackage = getMainGenPackage();
    if (genPackage != null)
    {
      suffix = genPackage.getProviderPackageSuffix();
    }
    return getPluginClass(isSetEditPluginClass(), getEditPluginClassGen(), suffix, "EditPlugin");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEditPluginClassGen()
  {
    return editPluginClass;
  }

  protected String getModelProject()
  {
    String modelDirectory = getModelDirectory();
    if (!isBlank(modelDirectory))
    {
      return URI.createURI(modelDirectory).segment(0);
    }
    return null;
  }

  protected String getMainPackage()
  {
    GenPackage genPackage = getMainGenPackage();
    return genPackage != null ? genPackage.getQualifiedPackageName() : getModelDirectory();
  }
  
  protected GenPackage getMainGenPackage()
  {
    if (!getGenPackages().isEmpty())
    {
      GenPackage genPackage = getGenPackages().get(0);
      while (genPackage.getGenClassifiers().isEmpty() && !genPackage.getNestedGenPackages().isEmpty())
      {
        genPackage = genPackage.getNestedGenPackages().get(0);
      }
      return genPackage;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEditPluginClass(String newEditPluginClass)
  {
    String oldEditPluginClass = editPluginClass;
    editPluginClass = newEditPluginClass;
    boolean oldEditPluginClassESet = editPluginClassESet;
    editPluginClassESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS, oldEditPluginClass, editPluginClass, !oldEditPluginClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEditPluginClass()
  {
    String oldEditPluginClass = editPluginClass;
    boolean oldEditPluginClassESet = editPluginClassESet;
    editPluginClass = EDIT_PLUGIN_CLASS_EDEFAULT;
    editPluginClassESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS, oldEditPluginClass, EDIT_PLUGIN_CLASS_EDEFAULT, oldEditPluginClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEditPluginClass()
  {
    return editPluginClassESet;
  }

  public String getEditorPluginClass()
  {
    String suffix = GenPackageImpl.PRESENTATION_PACKAGE_SUFFIX_EDEFAULT;
    GenPackage genPackage = getMainGenPackage();
    if (genPackage != null)
    {
      suffix = genPackage.getPresentationPackageSuffix();
    }    
    return getPluginClass(isSetEditorPluginClass(), getEditorPluginClassGen(), suffix, "EditorPlugin");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEditorPluginClassGen()
  {
    return editorPluginClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEditorPluginClass(String newEditorPluginClass)
  {
    String oldEditorPluginClass = editorPluginClass;
    editorPluginClass = newEditorPluginClass;
    boolean oldEditorPluginClassESet = editorPluginClassESet;
    editorPluginClassESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS, oldEditorPluginClass, editorPluginClass, !oldEditorPluginClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEditorPluginClass()
  {
    String oldEditorPluginClass = editorPluginClass;
    boolean oldEditorPluginClassESet = editorPluginClassESet;
    editorPluginClass = EDITOR_PLUGIN_CLASS_EDEFAULT;
    editorPluginClassESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS, oldEditorPluginClass, EDITOR_PLUGIN_CLASS_EDEFAULT, oldEditorPluginClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEditorPluginClass()
  {
    return editorPluginClassESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUpdateClasspath()
  {
    return updateClasspath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateClasspath(boolean newUpdateClasspath)
  {
    boolean oldUpdateClasspath = updateClasspath;
    updateClasspath = newUpdateClasspath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__UPDATE_CLASSPATH, oldUpdateClasspath, updateClasspath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGenerateSchema()
  {
    return generateSchema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerateSchema(boolean newGenerateSchema)
  {
    boolean oldGenerateSchema = generateSchema;
    generateSchema = newGenerateSchema;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__GENERATE_SCHEMA, oldGenerateSchema, generateSchema));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNonNLSMarkers()
  {
    return nonNLSMarkers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonNLSMarkersGen(boolean newNonNLSMarkers)
  {
    boolean oldNonNLSMarkers = nonNLSMarkers;
    nonNLSMarkers = newNonNLSMarkers;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__NON_NLS_MARKERS, oldNonNLSMarkers, nonNLSMarkers));
  }

  public void setNonNLSMarkers(boolean newNonNLSMarkers)
  {
    setNonNLSMarkersGen(newNonNLSMarkers);
    setNonExternalizedStringTagGen(null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<String> getStaticPackages()
  {
    if (staticPackages == null)
    {
      staticPackages = 
        new EDataTypeUniqueEList<String>(String.class, this, GenModelPackage.GEN_MODEL__STATIC_PACKAGES)
        {
          private static final long serialVersionUID = 1L;

          @Override
          protected void didChange()
          {
            super.didChange();
            staticGenPackages = null;
          }
        };
    }
    return staticPackages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getModelPluginVariables()
  {
    if (modelPluginVariables == null)
    {
      modelPluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenModelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES);
    }
    return modelPluginVariables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRootExtendsInterface()
  {
    return rootExtendsInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootExtendsInterface(String newRootExtendsInterface)
  {
    String oldRootExtendsInterface = rootExtendsInterface;
    rootExtendsInterface = newRootExtendsInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE, oldRootExtendsInterface, rootExtendsInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRootExtendsClass()
  {
    return rootExtendsClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootExtendsClass(String newRootExtendsClass)
  {
    String oldRootExtendsClass = rootExtendsClass;
    rootExtendsClass = newRootExtendsClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS, oldRootExtendsClass, rootExtendsClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRootImplementsInterface()
  {
    return rootImplementsInterface;
  }

  protected GenClass rootImplementsInterfaceGenClass;

  public GenClass getRootImplementsInterfaceGenClass()
  {
    if (rootImplementsInterfaceGenClass == null && !isBlank(rootImplementsInterface))
    {
      for (GenPackage genPackage : getAllGenUsedAndStaticGenPackagesWithClassifiers())
      {
        for (GenClass genClass : genPackage.getGenClasses())
        {
          if (genClass.getQualifiedInterfaceName().equals(rootImplementsInterface))
          {
            return rootImplementsInterfaceGenClass = genClass;
          }
        }
      }
    }

    return rootImplementsInterfaceGenClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootImplementsInterfaceGen(String newRootImplementsInterface)
  {
    String oldRootImplementsInterface = rootImplementsInterface;
    rootImplementsInterface = newRootImplementsInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE, oldRootImplementsInterface, rootImplementsInterface));
  }

  public void setRootImplementsInterface(String newRootImplementsInterface)
  {
    setRootImplementsInterfaceGen(newRootImplementsInterface);
    rootImplementsInterfaceGenClass = null;
  }

  public List<String> getEffectiveModelPluginVariables()
  {
    return getModelPluginVariables();
  }

  public List<String> getEffectiveModelPluginIDs()
  {
    List<String> result = new ArrayList<String>(getModelPluginVariables());
    for (ListIterator<String> i = result.listIterator(); i.hasNext(); )
    {
      String variable = i.next();
      int index = variable.indexOf("=");
      if (index != -1)
      {
        i.set(variable.substring(index + 1));
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressEMFTypes()
  {
    return suppressEMFTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressEMFTypes(boolean newSuppressEMFTypes)
  {
    boolean oldSuppressEMFTypes = suppressEMFTypes;
    suppressEMFTypes = newSuppressEMFTypes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES, oldSuppressEMFTypes, suppressEMFTypes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressEMFMetaData()
  {
    return suppressEMFMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressEMFMetaData(boolean newSuppressEMFMetaData)
  {
    boolean oldSuppressEMFMetaData = suppressEMFMetaData;
    suppressEMFMetaData = newSuppressEMFMetaData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA, oldSuppressEMFMetaData, suppressEMFMetaData));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressEMFModelTags()
  {
    return suppressEMFModelTags;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressEMFModelTags(boolean newSuppressEMFModelTags)
  {
    boolean oldSuppressEMFModelTags = suppressEMFModelTags;
    suppressEMFModelTags = newSuppressEMFModelTags;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS, oldSuppressEMFModelTags, suppressEMFModelTags));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressInterfaces()
  {
    return suppressInterfaces;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressInterfaces(boolean newSuppressInterfaces)
  {
    boolean oldSuppressInterfaces = suppressInterfaces;
    suppressInterfaces = newSuppressInterfaces;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_INTERFACES, oldSuppressInterfaces, suppressInterfaces));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFeatureMapWrapperInterface()
  {
    return featureMapWrapperInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureMapWrapperInterface(String newFeatureMapWrapperInterface)
  {
    String oldFeatureMapWrapperInterface = featureMapWrapperInterface;
    featureMapWrapperInterface = newFeatureMapWrapperInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE, oldFeatureMapWrapperInterface, featureMapWrapperInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFeatureMapWrapperInternalInterface()
  {
    return featureMapWrapperInternalInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureMapWrapperInternalInterface(String newFeatureMapWrapperInternalInterface)
  {
    String oldFeatureMapWrapperInternalInterface = featureMapWrapperInternalInterface;
    featureMapWrapperInternalInterface = newFeatureMapWrapperInternalInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE, oldFeatureMapWrapperInternalInterface, featureMapWrapperInternalInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFeatureMapWrapperClass()
  {
    return featureMapWrapperClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureMapWrapperClass(String newFeatureMapWrapperClass)
  {
    String oldFeatureMapWrapperClass = featureMapWrapperClass;
    featureMapWrapperClass = newFeatureMapWrapperClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS, oldFeatureMapWrapperClass, featureMapWrapperClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRuntimeCompatibility()
  {
    return runtimeCompatibility;
  }

  public boolean needsRuntimeCompatibility()
  {
    return isRuntimeCompatibility() && !isRichClientPlatform();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuntimeCompatibility(boolean newRuntimeCompatibility)
  {
    boolean oldRuntimeCompatibility = runtimeCompatibility;
    runtimeCompatibility = newRuntimeCompatibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY, oldRuntimeCompatibility, runtimeCompatibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRichClientPlatform()
  {
    return richClientPlatform;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRichClientPlatform(boolean newRichClientPlatform)
  {
    boolean oldRichClientPlatform = richClientPlatform;
    richClientPlatform = newRichClientPlatform;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM, oldRichClientPlatform, richClientPlatform));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isReflectiveDelegation()
  {
    return getFeatureDelegation() == GenDelegationKind.REFLECTIVE_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setReflectiveDelegation(boolean newReflectiveDelegation)
  {
    setFeatureDelegation(newReflectiveDelegation ? GenDelegationKind.REFLECTIVE_LITERAL : GenDelegationKind.NONE_LITERAL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCodeFormatting()
  {
    return codeFormatting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodeFormatting(boolean newCodeFormatting)
  {
    boolean oldCodeFormatting = codeFormatting;
    codeFormatting = newCodeFormatting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__CODE_FORMATTING, oldCodeFormatting, codeFormatting));
  }

  public String getTestsDirectory()
  {
    return getPluginDirectory(isSetTestsDirectory(), getTestsDirectoryGen(), ".tests/");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTestsDirectoryGen()
  {
    return testsDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTestsDirectory(String newTestsDirectory)
  {
    String oldTestsDirectory = testsDirectory;
    testsDirectory = newTestsDirectory;
    boolean oldTestsDirectoryESet = testsDirectoryESet;
    testsDirectoryESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__TESTS_DIRECTORY, oldTestsDirectory, testsDirectory, !oldTestsDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTestsDirectory()
  {
    String oldTestsDirectory = testsDirectory;
    boolean oldTestsDirectoryESet = testsDirectoryESet;
    testsDirectory = TESTS_DIRECTORY_EDEFAULT;
    testsDirectoryESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__TESTS_DIRECTORY, oldTestsDirectory, TESTS_DIRECTORY_EDEFAULT, oldTestsDirectoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTestsDirectory()
  {
    return testsDirectoryESet;
  }

  public String getTestSuiteClass()
  {
    String suffix = GenPackageImpl.TESTS_PACKAGE_SUFFIX_EDEFAULT;
    GenPackage genPackage = getMainGenPackage();
    if (genPackage != null)
    {
      suffix = genPackage.getTestsPackageSuffix();
    }        
    return getPluginClass(isSetTestSuiteClass(), getTestSuiteClassGen(), suffix, "AllTests");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTestSuiteClassGen()
  {
    return testSuiteClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTestSuiteClass(String newTestSuiteClass)
  {
    String oldTestSuiteClass = testSuiteClass;
    testSuiteClass = newTestSuiteClass;
    boolean oldTestSuiteClassESet = testSuiteClassESet;
    testSuiteClassESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS, oldTestSuiteClass, testSuiteClass, !oldTestSuiteClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTestSuiteClass()
  {
    String oldTestSuiteClass = testSuiteClass;
    boolean oldTestSuiteClassESet = testSuiteClassESet;
    testSuiteClass = TEST_SUITE_CLASS_EDEFAULT;
    testSuiteClassESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS, oldTestSuiteClass, TEST_SUITE_CLASS_EDEFAULT, oldTestSuiteClassESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTestSuiteClass()
  {
    return testSuiteClassESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBooleanFlagsField()
  {
    return booleanFlagsField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBooleanFlagsField(String newBooleanFlagsField)
  {
    String oldBooleanFlagsField = booleanFlagsField;
    booleanFlagsField = newBooleanFlagsField;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD, oldBooleanFlagsField, booleanFlagsField));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getBooleanFlagsReservedBits()
  {
    return booleanFlagsReservedBits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBooleanFlagsReservedBits(int newBooleanFlagsReservedBits)
  {
    int oldBooleanFlagsReservedBits = booleanFlagsReservedBits;
    booleanFlagsReservedBits = newBooleanFlagsReservedBits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS, oldBooleanFlagsReservedBits, booleanFlagsReservedBits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImporterID()
  {
    return importerID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImporterID(String newImporterID)
  {
    String oldImporterID = importerID;
    importerID = newImporterID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__IMPORTER_ID, oldImporterID, importerID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBundleManifest()
  {
    return bundleManifest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBundleManifest(boolean newBundleManifest)
  {
    boolean oldBundleManifest = bundleManifest;
    bundleManifest = newBundleManifest;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__BUNDLE_MANIFEST, oldBundleManifest, bundleManifest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GenDelegationKind getFeatureDelegation()
  {
    return featureDelegation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureDelegation(GenDelegationKind newFeatureDelegation)
  {
    GenDelegationKind oldFeatureDelegation = featureDelegation;
    featureDelegation = newFeatureDelegation == null ? FEATURE_DELEGATION_EDEFAULT : newFeatureDelegation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FEATURE_DELEGATION, oldFeatureDelegation, featureDelegation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isContainmentProxies()
  {
    return containmentProxies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainmentProxies(boolean newContainmentProxies)
  {
    boolean oldContainmentProxies = containmentProxies;
    containmentProxies = newContainmentProxies;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__CONTAINMENT_PROXIES, oldContainmentProxies, containmentProxies));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMinimalReflectiveMethods()
  {
    return minimalReflectiveMethods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinimalReflectiveMethods(boolean newMinimalReflectiveMethods)
  {
    boolean oldMinimalReflectiveMethods = minimalReflectiveMethods;
    minimalReflectiveMethods = newMinimalReflectiveMethods;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS, oldMinimalReflectiveMethods, minimalReflectiveMethods));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressContainment()
  {
    return suppressContainment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressContainment(boolean newSuppressContainment)
  {
    boolean oldSuppressContainment = suppressContainment;
    suppressContainment = newSuppressContainment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT, oldSuppressContainment, suppressContainment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressNotification()
  {
    return suppressNotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressNotification(boolean newSuppressNotification)
  {
    boolean oldSuppressNotification = suppressNotification;
    suppressNotification = newSuppressNotification;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION, oldSuppressNotification, suppressNotification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isArrayAccessors()
  {
    return arrayAccessors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayAccessors(boolean newArrayAccessors)
  {
    boolean oldArrayAccessors = arrayAccessors;
    arrayAccessors = newArrayAccessors;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__ARRAY_ACCESSORS, oldArrayAccessors, arrayAccessors));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressUnsettable()
  {
    return suppressUnsettable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressUnsettable(boolean newSuppressUnsettable)
  {
    boolean oldSuppressUnsettable = suppressUnsettable;
    suppressUnsettable = newSuppressUnsettable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE, oldSuppressUnsettable, suppressUnsettable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFacadeHelperClass()
  {
    return facadeHelperClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFacadeHelperClass(String newFacadeHelperClass)
  {
    String oldFacadeHelperClass = facadeHelperClass;
    facadeHelperClass = newFacadeHelperClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__FACADE_HELPER_CLASS, oldFacadeHelperClass, facadeHelperClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GenJDKLevel getComplianceLevel()
  {
    return complianceLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComplianceLevel(GenJDKLevel newComplianceLevel)
  {
    GenJDKLevel oldComplianceLevel = complianceLevel;
    complianceLevel = newComplianceLevel == null ? COMPLIANCE_LEVEL_EDEFAULT : newComplianceLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenModelPackage.GEN_MODEL__COMPLIANCE_LEVEL, oldComplianceLevel, complianceLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GenPackage> getGenPackages()
  {
    if (genPackages == null)
    {
      genPackages = new EObjectContainmentWithInverseEList<GenPackage>(GenPackage.class, this, GenModelPackage.GEN_MODEL__GEN_PACKAGES, GenModelPackage.GEN_PACKAGE__GEN_MODEL);
    }
    return genPackages;
  }

  public EList<GenPackage> getStaticGenPackages()
  {
    if (staticGenPackages == null)
    {
      staticGenPackages = new UniqueEList<GenPackage>();
      LOOP:
      for (String nsURI : getStaticPackages())
      {
        for (GenPackage staticGenPackage : getStaticGenPackages())
        {
          if (staticGenPackage.getNSURI().equals(nsURI))
          {
            continue LOOP;
          }
        }
        EPackage staticEPackage = eResource().getResourceSet().getPackageRegistry().getEPackage(nsURI);
        if (staticEPackage != null)
        {
          // See if a GenModel is registered for the package's URI, and if so, try to load it.
          //
          GenPackage staticGenPackage = null;
          URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsURI);
          if (genModelURI != null)
          {
            try
            {
              Resource genModelResource = eResource().getResourceSet().getResource(genModelURI, true);
              GenModel genModel = (GenModel)genModelResource.getContents().get(0);
              staticGenPackage = genModel.findGenPackage(staticEPackage);
            }
            catch (Exception exception)
            {
              CodeGenEcorePlugin.INSTANCE.log(exception);
            }
          }

          // If that didn't work, just synthesize one.
          //
          if (staticGenPackage == null)
          {
            GenModel genModel = getGenModel().createGenModel();
            staticGenPackage = getGenModel().createGenPackage();
            genModel.getGenPackages().add(staticGenPackage);
            staticGenPackage.initialize(staticEPackage);
          }
          staticGenPackages.add(staticGenPackage);            
        }
      }
    }
    return staticGenPackages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GenPackage> getUsedGenPackages()
  {
    if (usedGenPackages == null)
    {
      usedGenPackages = new EObjectResolvingEList<GenPackage>(GenPackage.class, this, GenModelPackage.GEN_MODEL__USED_GEN_PACKAGES);
    }
    return usedGenPackages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenPackages()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        return ((InternalEList<?>)getGenPackages()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__COPYRIGHT_TEXT:
        return getCopyrightText();
      case GenModelPackage.GEN_MODEL__MODEL_DIRECTORY:
        return getModelDirectory();
      case GenModelPackage.GEN_MODEL__CREATION_COMMANDS:
        return isCreationCommands() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__CREATION_ICONS:
        return isCreationIcons() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__CREATION_SUBMENUS:
        return isCreationSubmenus() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__EDIT_DIRECTORY:
        return getEditDirectory();
      case GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY:
        return getEditorDirectory();
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
        return getModelPluginID();
      case GenModelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
        return getTemplateDirectory();
      case GenModelPackage.GEN_MODEL__RUNTIME_JAR:
        return isRuntimeJar() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__FOREIGN_MODEL:
        return getForeignModel();
      case GenModelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
        return isDynamicTemplates() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__REDIRECTION:
        return getRedirection();
      case GenModelPackage.GEN_MODEL__FORCE_OVERWRITE:
        return isForceOverwrite() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
        return getNonExternalizedStringTag();
      case GenModelPackage.GEN_MODEL__MODEL_NAME:
        return getModelName();
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
        return getModelPluginClass();
      case GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
        return getEditPluginClass();
      case GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
        return getEditorPluginClass();
      case GenModelPackage.GEN_MODEL__UPDATE_CLASSPATH:
        return isUpdateClasspath() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__GENERATE_SCHEMA:
        return isGenerateSchema() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__NON_NLS_MARKERS:
        return isNonNLSMarkers() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__STATIC_PACKAGES:
        return getStaticPackages();
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
        return getModelPluginVariables();
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
        return getRootExtendsInterface();
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
        return getRootExtendsClass();
      case GenModelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
        return getRootImplementsInterface();
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
        return isSuppressEMFTypes() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
        return isSuppressEMFMetaData() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
        return isSuppressEMFModelTags() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
        return isSuppressInterfaces() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
        return getFeatureMapWrapperInterface();
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
        return getFeatureMapWrapperInternalInterface();
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
        return getFeatureMapWrapperClass();
      case GenModelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
        return isRuntimeCompatibility() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
        return isRichClientPlatform() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
        return isReflectiveDelegation() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__CODE_FORMATTING:
        return isCodeFormatting() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__TESTS_DIRECTORY:
        return getTestsDirectory();
      case GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS:
        return getTestSuiteClass();
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
        return getBooleanFlagsField();
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
        return new Integer(getBooleanFlagsReservedBits());
      case GenModelPackage.GEN_MODEL__IMPORTER_ID:
        return getImporterID();
      case GenModelPackage.GEN_MODEL__BUNDLE_MANIFEST:
        return isBundleManifest() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__FEATURE_DELEGATION:
        return getFeatureDelegation();
      case GenModelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
        return isContainmentProxies() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
        return isMinimalReflectiveMethods() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
        return isSuppressContainment() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
        return isSuppressNotification() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__ARRAY_ACCESSORS:
        return isArrayAccessors() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
        return isSuppressUnsettable() ? Boolean.TRUE : Boolean.FALSE;
      case GenModelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
        return getFacadeHelperClass();
      case GenModelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
        return getComplianceLevel();
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        return getGenPackages();
      case GenModelPackage.GEN_MODEL__USED_GEN_PACKAGES:
        return getUsedGenPackages();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__COPYRIGHT_TEXT:
        setCopyrightText((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_DIRECTORY:
        setModelDirectory((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__CREATION_COMMANDS:
        setCreationCommands(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__CREATION_ICONS:
        setCreationIcons(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__CREATION_SUBMENUS:
        setCreationSubmenus(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__EDIT_DIRECTORY:
        setEditDirectory((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY:
        setEditorDirectory((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
        setModelPluginID((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
        setTemplateDirectory((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__RUNTIME_JAR:
        setRuntimeJar(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__FOREIGN_MODEL:
        getForeignModel().clear();
        getForeignModel().addAll((Collection<? extends String>)newValue);
        return;
      case GenModelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
        setDynamicTemplates(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__REDIRECTION:
        setRedirection((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__FORCE_OVERWRITE:
        setForceOverwrite(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
        setNonExternalizedStringTag((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_NAME:
        setModelName((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
        setModelPluginClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
        setEditPluginClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
        setEditorPluginClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__UPDATE_CLASSPATH:
        setUpdateClasspath(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__GENERATE_SCHEMA:
        setGenerateSchema(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__NON_NLS_MARKERS:
        setNonNLSMarkers(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__STATIC_PACKAGES:
        getStaticPackages().clear();
        getStaticPackages().addAll((Collection<? extends String>)newValue);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
        getModelPluginVariables().clear();
        getModelPluginVariables().addAll((Collection<? extends String>)newValue);
        return;
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
        setRootExtendsInterface((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
        setRootExtendsClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
        setRootImplementsInterface((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
        setSuppressEMFTypes(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
        setSuppressEMFMetaData(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
        setSuppressEMFModelTags(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
        setSuppressInterfaces(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
        setFeatureMapWrapperInterface((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
        setFeatureMapWrapperInternalInterface((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
        setFeatureMapWrapperClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
        setRuntimeCompatibility(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
        setRichClientPlatform(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
        setReflectiveDelegation(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__CODE_FORMATTING:
        setCodeFormatting(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__TESTS_DIRECTORY:
        setTestsDirectory((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS:
        setTestSuiteClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
        setBooleanFlagsField((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
        setBooleanFlagsReservedBits(((Integer)newValue).intValue());
        return;
      case GenModelPackage.GEN_MODEL__IMPORTER_ID:
        setImporterID((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__BUNDLE_MANIFEST:
        setBundleManifest(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_DELEGATION:
        setFeatureDelegation((GenDelegationKind)newValue);
        return;
      case GenModelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
        setContainmentProxies(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
        setMinimalReflectiveMethods(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
        setSuppressContainment(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
        setSuppressNotification(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__ARRAY_ACCESSORS:
        setArrayAccessors(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
        setSuppressUnsettable(((Boolean)newValue).booleanValue());
        return;
      case GenModelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
        setFacadeHelperClass((String)newValue);
        return;
      case GenModelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
        setComplianceLevel((GenJDKLevel)newValue);
        return;
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        getGenPackages().clear();
        getGenPackages().addAll((Collection<? extends GenPackage>)newValue);
        return;
      case GenModelPackage.GEN_MODEL__USED_GEN_PACKAGES:
        getUsedGenPackages().clear();
        getUsedGenPackages().addAll((Collection<? extends GenPackage>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__COPYRIGHT_TEXT:
        setCopyrightText(COPYRIGHT_TEXT_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_DIRECTORY:
        setModelDirectory(MODEL_DIRECTORY_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__CREATION_COMMANDS:
        setCreationCommands(CREATION_COMMANDS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__CREATION_ICONS:
        setCreationIcons(CREATION_ICONS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__CREATION_SUBMENUS:
        setCreationSubmenus(CREATION_SUBMENUS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__EDIT_DIRECTORY:
        unsetEditDirectory();
        return;
      case GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY:
        unsetEditorDirectory();
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
        setModelPluginID(MODEL_PLUGIN_ID_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
        setTemplateDirectory(TEMPLATE_DIRECTORY_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__RUNTIME_JAR:
        setRuntimeJar(RUNTIME_JAR_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FOREIGN_MODEL:
        getForeignModel().clear();
        return;
      case GenModelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
        setDynamicTemplates(DYNAMIC_TEMPLATES_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__REDIRECTION:
        setRedirection(REDIRECTION_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FORCE_OVERWRITE:
        setForceOverwrite(FORCE_OVERWRITE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
        setNonExternalizedStringTag(NON_EXTERNALIZED_STRING_TAG_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_NAME:
        setModelName(MODEL_NAME_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
        setModelPluginClass(MODEL_PLUGIN_CLASS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
        unsetEditPluginClass();
        return;
      case GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
        unsetEditorPluginClass();
        return;
      case GenModelPackage.GEN_MODEL__UPDATE_CLASSPATH:
        setUpdateClasspath(UPDATE_CLASSPATH_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__GENERATE_SCHEMA:
        setGenerateSchema(GENERATE_SCHEMA_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__NON_NLS_MARKERS:
        setNonNLSMarkers(NON_NLS_MARKERS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__STATIC_PACKAGES:
        getStaticPackages().clear();
        return;
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
        getModelPluginVariables().clear();
        return;
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
        setRootExtendsInterface(ROOT_EXTENDS_INTERFACE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
        setRootExtendsClass(ROOT_EXTENDS_CLASS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
        setRootImplementsInterface(ROOT_IMPLEMENTS_INTERFACE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
        setSuppressEMFTypes(SUPPRESS_EMF_TYPES_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
        setSuppressEMFMetaData(SUPPRESS_EMF_META_DATA_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
        setSuppressEMFModelTags(SUPPRESS_EMF_MODEL_TAGS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
        setSuppressInterfaces(SUPPRESS_INTERFACES_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
        setFeatureMapWrapperInterface(FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
        setFeatureMapWrapperInternalInterface(FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
        setFeatureMapWrapperClass(FEATURE_MAP_WRAPPER_CLASS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
        setRuntimeCompatibility(RUNTIME_COMPATIBILITY_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
        setRichClientPlatform(RICH_CLIENT_PLATFORM_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
        setReflectiveDelegation(REFLECTIVE_DELEGATION_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__CODE_FORMATTING:
        setCodeFormatting(CODE_FORMATTING_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__TESTS_DIRECTORY:
        unsetTestsDirectory();
        return;
      case GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS:
        unsetTestSuiteClass();
        return;
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
        setBooleanFlagsField(BOOLEAN_FLAGS_FIELD_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
        setBooleanFlagsReservedBits(BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__IMPORTER_ID:
        setImporterID(IMPORTER_ID_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__BUNDLE_MANIFEST:
        setBundleManifest(BUNDLE_MANIFEST_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FEATURE_DELEGATION:
        setFeatureDelegation(FEATURE_DELEGATION_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
        setContainmentProxies(CONTAINMENT_PROXIES_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
        setMinimalReflectiveMethods(MINIMAL_REFLECTIVE_METHODS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
        setSuppressContainment(SUPPRESS_CONTAINMENT_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
        setSuppressNotification(SUPPRESS_NOTIFICATION_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__ARRAY_ACCESSORS:
        setArrayAccessors(ARRAY_ACCESSORS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
        setSuppressUnsettable(SUPPRESS_UNSETTABLE_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
        setFacadeHelperClass(FACADE_HELPER_CLASS_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
        setComplianceLevel(COMPLIANCE_LEVEL_EDEFAULT);
        return;
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        getGenPackages().clear();
        return;
      case GenModelPackage.GEN_MODEL__USED_GEN_PACKAGES:
        getUsedGenPackages().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GenModelPackage.GEN_MODEL__COPYRIGHT_TEXT:
        return COPYRIGHT_TEXT_EDEFAULT == null ? copyrightText != null : !COPYRIGHT_TEXT_EDEFAULT.equals(copyrightText);
      case GenModelPackage.GEN_MODEL__MODEL_DIRECTORY:
        return MODEL_DIRECTORY_EDEFAULT == null ? modelDirectory != null : !MODEL_DIRECTORY_EDEFAULT.equals(modelDirectory);
      case GenModelPackage.GEN_MODEL__CREATION_COMMANDS:
        return creationCommands != CREATION_COMMANDS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__CREATION_ICONS:
        return creationIcons != CREATION_ICONS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__CREATION_SUBMENUS:
        return creationSubmenus != CREATION_SUBMENUS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__EDIT_DIRECTORY:
        return isSetEditDirectory();
      case GenModelPackage.GEN_MODEL__EDITOR_DIRECTORY:
        return isSetEditorDirectory();
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
        return MODEL_PLUGIN_ID_EDEFAULT == null ? modelPluginID != null : !MODEL_PLUGIN_ID_EDEFAULT.equals(modelPluginID);
      case GenModelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
        return TEMPLATE_DIRECTORY_EDEFAULT == null ? templateDirectory != null : !TEMPLATE_DIRECTORY_EDEFAULT.equals(templateDirectory);
      case GenModelPackage.GEN_MODEL__RUNTIME_JAR:
        return runtimeJar != RUNTIME_JAR_EDEFAULT;
      case GenModelPackage.GEN_MODEL__FOREIGN_MODEL:
        return foreignModel != null && !foreignModel.isEmpty();
      case GenModelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
        return dynamicTemplates != DYNAMIC_TEMPLATES_EDEFAULT;
      case GenModelPackage.GEN_MODEL__REDIRECTION:
        return REDIRECTION_EDEFAULT == null ? redirection != null : !REDIRECTION_EDEFAULT.equals(redirection);
      case GenModelPackage.GEN_MODEL__FORCE_OVERWRITE:
        return forceOverwrite != FORCE_OVERWRITE_EDEFAULT;
      case GenModelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
        return NON_EXTERNALIZED_STRING_TAG_EDEFAULT == null ? nonExternalizedStringTag != null : !NON_EXTERNALIZED_STRING_TAG_EDEFAULT.equals(nonExternalizedStringTag);
      case GenModelPackage.GEN_MODEL__MODEL_NAME:
        return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
        return MODEL_PLUGIN_CLASS_EDEFAULT == null ? modelPluginClass != null : !MODEL_PLUGIN_CLASS_EDEFAULT.equals(modelPluginClass);
      case GenModelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
        return isSetEditPluginClass();
      case GenModelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
        return isSetEditorPluginClass();
      case GenModelPackage.GEN_MODEL__UPDATE_CLASSPATH:
        return updateClasspath != UPDATE_CLASSPATH_EDEFAULT;
      case GenModelPackage.GEN_MODEL__GENERATE_SCHEMA:
        return generateSchema != GENERATE_SCHEMA_EDEFAULT;
      case GenModelPackage.GEN_MODEL__NON_NLS_MARKERS:
        return nonNLSMarkers != NON_NLS_MARKERS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__STATIC_PACKAGES:
        return staticPackages != null && !staticPackages.isEmpty();
      case GenModelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
        return modelPluginVariables != null && !modelPluginVariables.isEmpty();
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
        return ROOT_EXTENDS_INTERFACE_EDEFAULT == null ? rootExtendsInterface != null : !ROOT_EXTENDS_INTERFACE_EDEFAULT.equals(rootExtendsInterface);
      case GenModelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
        return ROOT_EXTENDS_CLASS_EDEFAULT == null ? rootExtendsClass != null : !ROOT_EXTENDS_CLASS_EDEFAULT.equals(rootExtendsClass);
      case GenModelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
        return ROOT_IMPLEMENTS_INTERFACE_EDEFAULT == null ? rootImplementsInterface != null : !ROOT_IMPLEMENTS_INTERFACE_EDEFAULT.equals(rootImplementsInterface);
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
        return suppressEMFTypes != SUPPRESS_EMF_TYPES_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
        return suppressEMFMetaData != SUPPRESS_EMF_META_DATA_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
        return suppressEMFModelTags != SUPPRESS_EMF_MODEL_TAGS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
        return suppressInterfaces != SUPPRESS_INTERFACES_EDEFAULT;
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
        return FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT == null ? featureMapWrapperInterface != null : !FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT.equals(featureMapWrapperInterface);
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
        return FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT == null ? featureMapWrapperInternalInterface != null : !FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT.equals(featureMapWrapperInternalInterface);
      case GenModelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
        return FEATURE_MAP_WRAPPER_CLASS_EDEFAULT == null ? featureMapWrapperClass != null : !FEATURE_MAP_WRAPPER_CLASS_EDEFAULT.equals(featureMapWrapperClass);
      case GenModelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
        return runtimeCompatibility != RUNTIME_COMPATIBILITY_EDEFAULT;
      case GenModelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
        return richClientPlatform != RICH_CLIENT_PLATFORM_EDEFAULT;
      case GenModelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
        return isReflectiveDelegation() != REFLECTIVE_DELEGATION_EDEFAULT;
      case GenModelPackage.GEN_MODEL__CODE_FORMATTING:
        return codeFormatting != CODE_FORMATTING_EDEFAULT;
      case GenModelPackage.GEN_MODEL__TESTS_DIRECTORY:
        return isSetTestsDirectory();
      case GenModelPackage.GEN_MODEL__TEST_SUITE_CLASS:
        return isSetTestSuiteClass();
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
        return BOOLEAN_FLAGS_FIELD_EDEFAULT == null ? booleanFlagsField != null : !BOOLEAN_FLAGS_FIELD_EDEFAULT.equals(booleanFlagsField);
      case GenModelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
        return booleanFlagsReservedBits != BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__IMPORTER_ID:
        return IMPORTER_ID_EDEFAULT == null ? importerID != null : !IMPORTER_ID_EDEFAULT.equals(importerID);
      case GenModelPackage.GEN_MODEL__BUNDLE_MANIFEST:
        return bundleManifest != BUNDLE_MANIFEST_EDEFAULT;
      case GenModelPackage.GEN_MODEL__FEATURE_DELEGATION:
        return featureDelegation != FEATURE_DELEGATION_EDEFAULT;
      case GenModelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
        return containmentProxies != CONTAINMENT_PROXIES_EDEFAULT;
      case GenModelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
        return minimalReflectiveMethods != MINIMAL_REFLECTIVE_METHODS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
        return suppressContainment != SUPPRESS_CONTAINMENT_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
        return suppressNotification != SUPPRESS_NOTIFICATION_EDEFAULT;
      case GenModelPackage.GEN_MODEL__ARRAY_ACCESSORS:
        return arrayAccessors != ARRAY_ACCESSORS_EDEFAULT;
      case GenModelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
        return suppressUnsettable != SUPPRESS_UNSETTABLE_EDEFAULT;
      case GenModelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
        return FACADE_HELPER_CLASS_EDEFAULT == null ? facadeHelperClass != null : !FACADE_HELPER_CLASS_EDEFAULT.equals(facadeHelperClass);
      case GenModelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
        return complianceLevel != COMPLIANCE_LEVEL_EDEFAULT;
      case GenModelPackage.GEN_MODEL__GEN_PACKAGES:
        return genPackages != null && !genPackages.isEmpty();
      case GenModelPackage.GEN_MODEL__USED_GEN_PACKAGES:
        return usedGenPackages != null && !usedGenPackages.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (copyrightText: ");
    result.append(copyrightText);
    result.append(", modelDirectory: ");
    result.append(modelDirectory);
    result.append(", creationCommands: ");
    result.append(creationCommands);
    result.append(", creationIcons: ");
    result.append(creationIcons);
    result.append(", creationSubmenus: ");
    result.append(creationSubmenus);
    result.append(", editDirectory: ");
    if (editDirectoryESet) result.append(editDirectory); else result.append("<unset>");
    result.append(", editorDirectory: ");
    if (editorDirectoryESet) result.append(editorDirectory); else result.append("<unset>");
    result.append(", modelPluginID: ");
    result.append(modelPluginID);
    result.append(", templateDirectory: ");
    result.append(templateDirectory);
    result.append(", runtimeJar: ");
    result.append(runtimeJar);
    result.append(", foreignModel: ");
    result.append(foreignModel);
    result.append(", dynamicTemplates: ");
    result.append(dynamicTemplates);
    result.append(", redirection: ");
    result.append(redirection);
    result.append(", forceOverwrite: ");
    result.append(forceOverwrite);
    result.append(", nonExternalizedStringTag: ");
    result.append(nonExternalizedStringTag);
    result.append(", modelName: ");
    result.append(modelName);
    result.append(", modelPluginClass: ");
    result.append(modelPluginClass);
    result.append(", editPluginClass: ");
    if (editPluginClassESet) result.append(editPluginClass); else result.append("<unset>");
    result.append(", editorPluginClass: ");
    if (editorPluginClassESet) result.append(editorPluginClass); else result.append("<unset>");
    result.append(", updateClasspath: ");
    result.append(updateClasspath);
    result.append(", generateSchema: ");
    result.append(generateSchema);
    result.append(", nonNLSMarkers: ");
    result.append(nonNLSMarkers);
    result.append(", staticPackages: ");
    result.append(staticPackages);
    result.append(", modelPluginVariables: ");
    result.append(modelPluginVariables);
    result.append(", rootExtendsInterface: ");
    result.append(rootExtendsInterface);
    result.append(", rootExtendsClass: ");
    result.append(rootExtendsClass);
    result.append(", rootImplementsInterface: ");
    result.append(rootImplementsInterface);
    result.append(", suppressEMFTypes: ");
    result.append(suppressEMFTypes);
    result.append(", suppressEMFMetaData: ");
    result.append(suppressEMFMetaData);
    result.append(", suppressEMFModelTags: ");
    result.append(suppressEMFModelTags);
    result.append(", suppressInterfaces: ");
    result.append(suppressInterfaces);
    result.append(", featureMapWrapperInterface: ");
    result.append(featureMapWrapperInterface);
    result.append(", featureMapWrapperInternalInterface: ");
    result.append(featureMapWrapperInternalInterface);
    result.append(", featureMapWrapperClass: ");
    result.append(featureMapWrapperClass);
    result.append(", runtimeCompatibility: ");
    result.append(runtimeCompatibility);
    result.append(", richClientPlatform: ");
    result.append(richClientPlatform);
    result.append(", codeFormatting: ");
    result.append(codeFormatting);
    result.append(", testsDirectory: ");
    if (testsDirectoryESet) result.append(testsDirectory); else result.append("<unset>");
    result.append(", testSuiteClass: ");
    if (testSuiteClassESet) result.append(testSuiteClass); else result.append("<unset>");
    result.append(", booleanFlagsField: ");
    result.append(booleanFlagsField);
    result.append(", booleanFlagsReservedBits: ");
    result.append(booleanFlagsReservedBits);
    result.append(", importerID: ");
    result.append(importerID);
    result.append(", bundleManifest: ");
    result.append(bundleManifest);
    result.append(", featureDelegation: ");
    result.append(featureDelegation);
    result.append(", containmentProxies: ");
    result.append(containmentProxies);
    result.append(", minimalReflectiveMethods: ");
    result.append(minimalReflectiveMethods);
    result.append(", suppressContainment: ");
    result.append(suppressContainment);
    result.append(", suppressNotification: ");
    result.append(suppressNotification);
    result.append(", arrayAccessors: ");
    result.append(arrayAccessors);
    result.append(", suppressUnsettable: ");
    result.append(suppressUnsettable);
    result.append(", facadeHelperClass: ");
    result.append(facadeHelperClass);
    result.append(", complianceLevel: ");
    result.append(complianceLevel);
    result.append(')');
    return result.toString();
  }

  static protected String getProjectPath(String path)
  {
    int beginIndex = path.startsWith("/") ? 1 : 0;
    int endIndex = path.indexOf("/", beginIndex);
    if (endIndex != -1)
    {
      return path.substring(0, endIndex);
    }
    else
    {
      return path;
    }
  }

  public String getModelProjectDirectory()
  {
    return getProjectPath(getModelDirectory());
  }

  public String getEditProjectDirectory()
  {
    return getProjectPath(getEditDirectory());
  }

  public String getEditorProjectDirectory()
  {
    return getProjectPath(getEditorDirectory());
  }

  public String getTestsProjectDirectory()
  {
    return getProjectPath(getTestsDirectory());
  }

  public boolean sameModelEditProject()
  {
    return getModelProjectDirectory().equals(getEditProjectDirectory());
  }

  public boolean sameEditEditorProject()
  {
    return getEditProjectDirectory().equals(getEditorProjectDirectory());
  }

  public boolean sameModelEditorProject()
  {
    return getModelProjectDirectory().equals(getEditorProjectDirectory());
  }

  public boolean sameModelTestsProject()
  {
    // Different than the Edit and Editor projects, this method is invoked while 
    // generating the model plugin xml.
    return getTestsDirectory() == null ? false : getModelProjectDirectory().equals(getTestsProjectDirectory());
  }

  public String getEditIconsDirectory()
  {
    return getEditProjectDirectory() + "/icons";
  }

  public String getEditorIconsDirectory()
  {
    return getEditorProjectDirectory() + "/icons";
  }

  public String getEditPluginID()
  {
    if (sameModelEditProject())
    {
      return getModelPluginID();
    }
    else
    {
      return getModelPluginID() + ".edit";
    }
  }

  public String getEditorPluginID()
  {
    if (sameEditEditorProject())
    {
      return getEditPluginID();
    }
    else
    {
      return getModelPluginID() + ".editor";
    }
  }

  public String getTestsPluginID()
  {
    if (sameModelTestsProject())
    {
      return getModelPluginID();
    }
    else
    {
      return getModelPluginID() + ".tests";
    }
  }

  public boolean hasModelPluginClass()
  {
    return !sameModelEditProject() && !sameModelEditorProject() &&
      !isBlank(getModelPluginClass());
  }

  protected String getModelPluginClassToUse()
  {
    String result = getModelPluginClass();
    if (isBlank(result) && sameModelEditProject())
    {
      result = getEditPluginClass();
    }
    if (isBlank(result) && sameModelEditorProject())
    {
      result = getEditorPluginClass();
    }
    return result;
  }

  protected String getEditPluginClassToUse()
  {
    String result = null;
    if (sameModelEditProject())
    {
      result = getModelPluginClass();
    }
    if (isBlank(result))
    {
      result = getEditPluginClass();
    }
    if (isBlank(result) && sameEditEditorProject())
    {
      result = getEditorPluginClass();
    }
    return result;
  }

  public String getEditPluginDirectory()
  {
    String result =  getEditDirectory(); 
    String plugin = null;
    if (sameModelEditProject())
    {
      plugin = getModelPluginClass();
      result = getModelDirectory();
    }
    if (isBlank(plugin))
    {
      plugin = getEditPluginClass();
      result = getEditDirectory();
    }
    if (isBlank(plugin) && sameEditEditorProject())
    {
      plugin = getEditorPluginClass();
      result = getEditorDirectory();
    }
    return result;
  }

  protected String getEditorPluginClassToUse()
  {
    String result = null;
    if (sameModelEditorProject())
    {
      result = getModelPluginClass();
    }
    if (isBlank(result) && sameEditEditorProject())
    {
      result = getEditPluginClass();
    }
    if (isBlank(result))
    {
      result = getEditorPluginClass();
    }
    return result;
  }

  public String getEditorPluginDirectory()
  {
    String result =  getEditorDirectory(); 
    String plugin = null;
    if (sameModelEditorProject())
    {
      plugin = getModelPluginClass();
      result = getModelDirectory();
    }
    if (isBlank(plugin) && sameEditEditorProject())
    {
      plugin = getEditPluginClass();
      result = getEditDirectory();
    }
    if (isBlank(plugin))
    {
      plugin = getEditorPluginClass();
      result = getEditorDirectory();
    }
    return result;
  }
  
  protected String getPluginClassName(String baseName, String defaultSuffix)
  {
    if (baseName == null)
    {
      String modelName = getModelName();
      baseName = (isBlank(modelName) ? "" : modelName) + defaultSuffix;
    }
    else
    {
      baseName = CodeGenUtil.getSimpleClassName(baseName);
    }
    return baseName;
  }

  protected String getPluginPackageName(String baseName, String pluginID)
  {
    if (baseName == null)
    {
      baseName = createPackageName(pluginID);
    }
    else
    {
      int index = baseName.lastIndexOf(".");
      if (index == -1)
      {
        baseName = createPackageName(pluginID);
      }
      else
      {
        baseName = CodeGenUtil.getPackageName(baseName);
      }
    }
    return baseName;
  }

  protected String createPackageName(String text)
  {
    return text != null ? text.toLowerCase() : "";
  }

  public String getModelPluginPackageName()
  {
    return getPluginPackageName(getModelPluginClassToUse(), getModelPluginID());
  }

  public String getModelPluginClassName()
  {
    return getPluginClassName(getModelPluginClassToUse(), "Plugin");
  }
  
  public String getQualifiedModelPluginClassName()
  {
    return getModelPluginPackageName() + "." + getModelPluginClassName();
  }

  public String getEditPluginPackageName()
  {
    return getPluginPackageName(getEditPluginClassToUse(), getEditPluginID());
  }
  
  public String getEditPluginClassName()
  {
    return getPluginClassName(getEditPluginClassToUse(), "EditPlugin");
  }

  public String getQualifiedEditPluginClassName()
  {
    return getEditPluginPackageName() + "." + getEditPluginClassName();
  }

  public String getEditorPluginPackageName()
  {
    return getPluginPackageName(getEditorPluginClassToUse(), getEditorPluginID());
  }

  public String getEditorPluginClassName()
  {
    return getPluginClassName(getEditorPluginClassToUse(), "EditorPlugin");
  }

  public String getQualifiedEditorPluginClassName()
  {
    return getEditorPluginPackageName() + "." + getEditorPluginClassName();
  }

  public String getQualifiedEditorAdvisorClassName()
  {
    return getEditorPluginPackageName() + "." + getEditorAdvisorClassName();
  }
  
  public String getEditorAdvisorClassName()
  {
    String modelName = getModelName();
    return (modelName != null ? getModelName() : "") + "EditorAdvisor";
  }

  public boolean hasTestSuiteClass()
  {
    return !isBlank(getTestSuiteClass());
  }

  public String getTestSuitePackageName()
  {
    return getPluginPackageName(getTestSuiteClass(), getTestsPluginID());
  }

  public String getTestSuiteClassName()
  {
    return getPluginClassName(getTestSuiteClass(), "AllTests");
  }

  public String getQualifiedTestSuiteClassName()
  {
    return getTestSuitePackageName() + "." + getTestSuiteClassName();
  }

  protected void getAllGenPackagesWithClassifiersHelper(List<GenPackage> result, List<GenPackage> genPackages)
  {
    for (GenPackage genPackage : genPackages)
    {
      if (genPackage.hasClassifiers())
      {
        result.add(genPackage);
      }
      getAllGenPackagesWithClassifiersHelper(result, genPackage.getNestedGenPackages());
    }
  }

  public List<GenPackage> getAllGenPackagesWithClassifiers()
  {
    List<GenPackage> result = new ArrayList<GenPackage>();
    getAllGenPackagesWithClassifiersHelper(result, getGenPackages());
    return result;
  }

  public List<GenPackage> getAllUsedGenPackagesWithClassifiers()
  {
    List<GenPackage> result = new ArrayList<GenPackage>();
    getAllGenPackagesWithClassifiersHelper(result, getUsedGenPackages());
    return result;
  }

  public List<GenPackage> getAllGenAndUsedGenPackagesWithClassifiers()
  {
    List<GenPackage> result = new ArrayList<GenPackage>();
    getAllGenPackagesWithClassifiersHelper(result, getGenPackages());
    getAllGenPackagesWithClassifiersHelper(result, getUsedGenPackages());
    return result;
  }

  public List<GenPackage> getAllGenUsedAndStaticGenPackagesWithClassifiers()
  {
    List<GenPackage> result = new ArrayList<GenPackage>();
    getAllGenPackagesWithClassifiersHelper(result, getGenPackages());
    getAllGenPackagesWithClassifiersHelper(result, getUsedGenPackages());
    getAllGenPackagesWithClassifiersHelper(result, getStaticGenPackages());
    return result;
  }
  
  public List<String> getModelQualifiedPackageNames()
  {
    EList<String> packageNames = sameModelTestsProject() ?
      (EList<String>)getTestsQualifiedPackageNames() :
      new UniqueEList<String>();
      
    TreeIterator<GenPackage> genPackagesIterator = 
      new AbstractTreeIterator<GenPackage>(getGenPackages(), false)
      {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        @Override
        protected Iterator<GenPackage> getChildren(Object object)
        {
          return object instanceof Collection ? 
            ((Collection<GenPackage>)object).iterator() :
            ((GenPackage)object).getNestedGenPackages().iterator();
        }
      };
    while(genPackagesIterator.hasNext())
    {
      GenPackage genPackage = genPackagesIterator.next();
      addQualifiedModelPackageNames(packageNames, genPackage);
    }
    
    String pluginClassPackage = CodeGenUtil.getPackageName(getModelPluginClassToUse());
    if (!isBlank(pluginClassPackage))
    {
      packageNames.add(pluginClassPackage);
    }
    
    ECollections.sort(packageNames);
    return packageNames;
  }
  
  protected void addQualifiedModelPackageNames(List<String> packageNames, GenPackage genPackage)
  {
    if (genPackage.hasClassifiers())
    {
      packageNames.add(genPackage.getInterfacePackageName());
      packageNames.add(genPackage.getClassPackageName());
      if (genPackage.isAdapterFactory() && !genPackage.getGenClasses().isEmpty() || 
            genPackage.hasClassifiers() && genPackage.hasConstraints() ||
            genPackage.getResource() != GenResourceKind.NONE_LITERAL)
      {
        packageNames.add(genPackage.getUtilitiesPackageName());
      }
      if (!isBlank(genPackage.getMetaDataPackageSuffix()))
      {
        packageNames.add(genPackage.getReflectionPackageName());
      }
    }
  }

  public List<String> getModelRequiredPlugins()
  {
    List<String> result = new UniqueEList<String>();
    result.add(needsRuntimeCompatibility() ? "org.eclipse.core.runtime.compatibility" : "org.eclipse.core.runtime");
    result.add("org.eclipse.emf.ecore");
    result.addAll(getEffectiveModelPluginIDs());
    
    TreeIterator<GenPackage> genPackagesIterator = 
      new AbstractTreeIterator<GenPackage>(getGenPackages(), false)
      {
        private static final long serialVersionUID = 1L;

        @Override
        @SuppressWarnings("unchecked")
        protected Iterator<GenPackage> getChildren(Object object)
        {
          return object instanceof Collection ? 
            ((Collection<GenPackage>)object).iterator() :
            ((GenPackage)object).getNestedGenPackages().iterator();
        }
      };
    while(genPackagesIterator.hasNext())
    {
      GenPackage genPackage = genPackagesIterator.next();
      if (genPackage.getResource() != GenResourceKind.NONE_LITERAL || genPackage.isLoadingInitialization())
      {
        result.add("org.eclipse.emf.ecore.xmi");
        break;
      }
    }
    for (GenPackage genPackage : getUsedGenPackages())
    {
      result.add(genPackage.getGenModel().getModelPluginID());
    }

    if (sameModelTestsProject())
    {
      result.add("org.junit");
    }

    return result;
  }

  public List<String> getEditQualifiedPackageNames()
  {
    EList<String> packageNames = sameModelEditProject() ? 
      (EList<String>)getModelQualifiedPackageNames() :
      new UniqueEList<String>();

    TreeIterator<GenPackage> genPackagesIterator = 
      new AbstractTreeIterator<GenPackage>(getGenPackages(), false)
      {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        @Override
        protected Iterator<GenPackage> getChildren(Object object)
        {
          return object instanceof Collection ? 
            ((Collection<GenPackage>)object).iterator() :
            ((GenPackage)object).getNestedGenPackages().iterator();
        }
      };
    while(genPackagesIterator.hasNext())
    {
      GenPackage genPackage = genPackagesIterator.next();
      addQualifiedEditPackageNames(packageNames, genPackage);
    }
    
    String pluginClassPackage = CodeGenUtil.getPackageName(getEditPluginClassToUse());
    if (!isBlank(pluginClassPackage))
    {
      packageNames.add(pluginClassPackage);
    }
    
    ECollections.sort(packageNames);
    return packageNames;
  }

  protected void addQualifiedEditPackageNames(List<String> packageNames, GenPackage genPackage)
  {
    if (!genPackage.getGenClasses().isEmpty())
    {
      packageNames.add(genPackage.getProviderPackageName());
    }
  }

  public List<String> getEditRequiredPlugins()
  {
    List<String> result = new UniqueEList<String>();
    result.add(needsRuntimeCompatibility() ? "org.eclipse.core.runtime.compatibility" : "org.eclipse.core.runtime");

    if (!sameModelEditProject())
    {
      for (GenPackage genPackage : getGenPackages())
      {
        result.add(genPackage.getGenModel().getModelPluginID());
      }
    }
    else
    {
      result.addAll(getModelRequiredPlugins());
    }
    
    result.add("org.eclipse.emf.edit");
    
    for (GenPackage genPackage : getUsedGenPackages())
    {
      GenModel genModel = genPackage.getGenModel();
      result.add(genModel.getModelPluginID());
      if (genModel.hasEditSupport())
      {
        result.add(genModel.getEditPluginID());
      }
    }
    return result;
  }

  public List<String> getEditorQualifiedPackageNames()
  {
    EList<String> packageNames = sameModelEditorProject() || sameEditEditorProject() ? 
      (EList<String>)getEditQualifiedPackageNames() :
      new UniqueEList<String>();

    TreeIterator<GenPackage> genPackagesIterator = 
      new AbstractTreeIterator<GenPackage>(getGenPackages(), false)
      {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        @Override
        protected Iterator<GenPackage> getChildren(Object object)
        {
          return object instanceof Collection ? 
            ((Collection<GenPackage>)object).iterator() :
            ((GenPackage)object).getNestedGenPackages().iterator();
        }
      };
    while(genPackagesIterator.hasNext())
    {
      GenPackage genPackage = genPackagesIterator.next();
      addQualifiedEditorPackageNames(packageNames, genPackage);
    }

    String pluginClassPackage = CodeGenUtil.getPackageName(getEditorPluginClassToUse());
    if (!isBlank(pluginClassPackage))
    {
      packageNames.add(pluginClassPackage);
    }
    
    ECollections.sort(packageNames);
    return packageNames;
  }

  protected void addQualifiedEditorPackageNames(List<String> packageNames, GenPackage genPackage)
  {
    if (genPackage.hasConcreteClasses())
    {
      packageNames.add(genPackage.getPresentationPackageName());
    }
  }

  public List<String> getEditorRequiredPlugins()
  {
    List<String> result = new UniqueEList<String>();
    result.add(needsRuntimeCompatibility() ? "org.eclipse.core.runtime.compatibility" : "org.eclipse.core.runtime");
    if (!isRichClientPlatform())
    {
      result.add("org.eclipse.core.resources");
    }
    
    if (!sameEditEditorProject())
    {
      for (GenPackage genPackage : getGenPackages())
      {
        GenModel genModel = genPackage.getGenModel();
        if (genModel.hasEditSupport())
        {
          result.add(genModel.getEditPluginID());
        }
      }
    }
    else
    {
      result.addAll(getEditRequiredPlugins());
    }
    result.add("org.eclipse.emf.ecore.xmi");
    result.add("org.eclipse.emf.edit.ui");
    if (!isRichClientPlatform())
    {
      result.add("org.eclipse.ui.ide");
    }
    for (GenPackage genPackage : getUsedGenPackages())
    {
      GenModel genModel = genPackage.getGenModel();
      if (genModel.hasEditSupport())
      {
        result.add(genModel.getEditPluginID());
      }
    }
    return result;
  }

  public List<String> getTestsQualifiedPackageNames()
  {
    EList<String> packageNames = new UniqueEList<String>();

    TreeIterator<GenPackage> genPackagesIterator = 
      new AbstractTreeIterator<GenPackage>(getGenPackages(), false)
      {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        @Override
        protected Iterator<GenPackage> getChildren(Object object)
        {
          return object instanceof Collection ? 
            ((Collection<GenPackage>)object).iterator() :
            ((GenPackage)object).getNestedGenPackages().iterator();
        }
      };
    while(genPackagesIterator.hasNext())
    {
      GenPackage genPackage = genPackagesIterator.next();
      addQualifiedTestsPackageNames(packageNames, genPackage);
    }

    String pluginClassPackage = CodeGenUtil.getPackageName(getTestSuiteClass());
    if (!isBlank(pluginClassPackage))
    {
      packageNames.add(pluginClassPackage);
    }
    
    ECollections.sort(packageNames);
    return packageNames;
  }

  protected void addQualifiedTestsPackageNames(List<String> packageNames, GenPackage genPackage)
  {
    if (genPackage.hasClassifiers())
    {
      packageNames.add(genPackage.getTestsPackageName());
    }
  }

  public List<String> getTestsRequiredPlugins()
  {
    List<String> result = new UniqueEList<String>();
    result.add(needsRuntimeCompatibility() ? "org.eclipse.core.runtime.compatibility" : "org.eclipse.core.runtime");

    result.add(getModelPluginID());
    for (GenPackage genPackage : getUsedGenPackages())
    {
      GenModel genModel = genPackage.getGenModel();
      result.add(genModel.getModelPluginID());
    }

    result.add("org.eclipse.emf.ecore.xmi");
    result.add("org.junit");

    return result;
  }

  public List<String> getEditResourceDelegateImportedPluginClassNames()
  {
    List<String> result = new UniqueEList<String>();
    for (GenPackage genPackage : getUsedGenPackages())
    {
      GenModel genModel = genPackage.getGenModel();
      if (genModel.hasEditSupport())
      {
        result.add(genModel.getImportedName(genModel.getQualifiedEditPluginClassName()));
      }
    }
    return result;
  }

  public boolean reconcile(GenModel oldGenModelVersion)
  {
    boolean result = false;
    if (oldGenModelVersion != null)
    {
      for (GenPackage genPackage : getGenPackages())
      {
        for (GenPackage oldGenPackageVersion : oldGenModelVersion.getGenPackages())
        {
          if (genPackage.reconcile(oldGenPackageVersion))
          {
            result = true;
            break;
          }
        }
      }

      reconcileSettings(oldGenModelVersion);
    }

    return result;
  }

  protected void reconcileSettings(GenModel oldGenModelVersion)
  {
    if (oldGenModelVersion.isSetEditDirectory())
    {
      setEditDirectory(oldGenModelVersion.getEditDirectory());
    }
    else
    {
      unsetEditDirectory();
    }
    if (oldGenModelVersion.isSetEditPluginClass())
    {
      setEditPluginClass(oldGenModelVersion.getEditPluginClass());
    }
    else
    {
      unsetEditPluginClass();
    }
    if (oldGenModelVersion.isSetEditorDirectory())
    {
      setEditorDirectory(oldGenModelVersion.getEditorDirectory());
    }
    else
    {
      unsetEditorDirectory();
    }
    if (oldGenModelVersion.isSetEditorPluginClass())
    {
      setEditorPluginClass(oldGenModelVersion.getEditorPluginClass());
    }
    else
    {
      unsetEditorPluginClass();
    }
    if (oldGenModelVersion.isSetTestsDirectory())
    {
      setTestsDirectory(oldGenModelVersion.getTestsDirectory());
    }
    else
    {
      unsetTestsDirectory();
    }
    if (oldGenModelVersion.isSetTestSuiteClass())
    {
      setTestSuiteClass(oldGenModelVersion.getTestSuiteClass());
    }
    else
    {
      unsetTestSuiteClass();
    }

    setCopyrightText(oldGenModelVersion.getCopyrightText());
    setModelDirectory(oldGenModelVersion.getModelDirectory());
    setCreationCommands(oldGenModelVersion.isCreationCommands());
    setCreationIcons(oldGenModelVersion.isCreationIcons());
    setCreationSubmenus(oldGenModelVersion.isCreationSubmenus());
    setModelPluginID(oldGenModelVersion.getModelPluginID());
    setTemplateDirectory(oldGenModelVersion.getTemplateDirectory());
    setRuntimeJar(oldGenModelVersion.isRuntimeJar());
    setBundleManifest(oldGenModelVersion.isBundleManifest());

    // EATM 
    // Foreign Model

    setDynamicTemplates(oldGenModelVersion.isDynamicTemplates());
    setRedirection(oldGenModelVersion.getRedirection());
    setForceOverwrite(oldGenModelVersion.isForceOverwrite());
    setNonExternalizedStringTag(oldGenModelVersion.getNonExternalizedStringTag());

    setModelName(oldGenModelVersion.getModelName());

    setModelPluginClass(oldGenModelVersion.getModelPluginClass());
    setUpdateClasspath(oldGenModelVersion.isUpdateClasspath()); 
    setGenerateSchema(oldGenModelVersion.isGenerateSchema());
    setNonNLSMarkers(oldGenModelVersion.isNonNLSMarkers());
    getModelPluginVariables().addAll(oldGenModelVersion.getModelPluginVariables());
    getStaticPackages().addAll(oldGenModelVersion.getStaticPackages());
    setRootExtendsInterface(oldGenModelVersion.getRootExtendsInterface());
    setRootImplementsInterface(oldGenModelVersion.getRootImplementsInterface());
    setRootExtendsClass(oldGenModelVersion.getRootExtendsClass());
    setSuppressEMFTypes(oldGenModelVersion.isSuppressEMFTypes());
    setFeatureMapWrapperInterface(oldGenModelVersion.getFeatureMapWrapperInterface());
    setFeatureMapWrapperInternalInterface(oldGenModelVersion.getFeatureMapWrapperInternalInterface());
    setFeatureMapWrapperClass(oldGenModelVersion.getFeatureMapWrapperClass());

    setRuntimeCompatibility(oldGenModelVersion.isRuntimeCompatibility());
    setRichClientPlatform(oldGenModelVersion.isRichClientPlatform());
    setCodeFormatting(oldGenModelVersion.isCodeFormatting());
        
    setBooleanFlagsField(oldGenModelVersion.getBooleanFlagsField());
    setBooleanFlagsReservedBits(oldGenModelVersion.getBooleanFlagsReservedBits());
    
    setFeatureDelegation(oldGenModelVersion.getFeatureDelegation());
    setContainmentProxies(oldGenModelVersion.isContainmentProxies());
    setMinimalReflectiveMethods(oldGenModelVersion.isMinimalReflectiveMethods());
    
    setSuppressEMFMetaData(oldGenModelVersion.isSuppressEMFMetaData());
    setSuppressEMFModelTags(oldGenModelVersion.isSuppressEMFModelTags());
    setSuppressInterfaces(oldGenModelVersion.isSuppressInterfaces());
    setSuppressNotification(oldGenModelVersion.isSuppressNotification());
    setSuppressContainment(oldGenModelVersion.isSuppressContainment());
    setSuppressUnsettable(oldGenModelVersion.isSuppressUnsettable());
    setArrayAccessors(oldGenModelVersion.isArrayAccessors());
    
    reconcileGenAnnotations(oldGenModelVersion);

    setComplianceLevel(oldGenModelVersion.getComplianceLevel());
  }

  public boolean reconcile()
  {
    for (Iterator<GenPackage> i = getGenPackages().iterator(); i.hasNext(); )
    {
      GenPackage genPackage = i.next();
      if (!genPackage.reconcile())
      {
        i.remove();
      }
    }
    for (Iterator<GenPackage> i = getUsedGenPackages().iterator(); i.hasNext(); )
    {
      GenPackage genPackage = i.next();
      if (!genPackage.reconcile())
      {
        i.remove();
      }
    }
    getUsedGenPackages().addAll(computeMissingUsedGenPackages());
    
    return !getGenPackages().isEmpty();
  }
  
  public List<GenPackage> computeMissingUsedGenPackages()
  {
    List<EPackage> missingEPackages = getMissingPackages();
    if (!missingEPackages.isEmpty())
    {
      List<GenModel> allGenModels = new UniqueEList.FastCompare<GenModel>();
      allGenModels.add(this);
      for (int i = 0; i < allGenModels.size(); i++)
      {
        GenModel genModel = allGenModels.get(i);
        for (int j = 0; j < genModel.getUsedGenPackages().size(); j++)
        {
          GenPackage genPackage = genModel.getUsedGenPackages().get(j);
          if (genPackage.getGenModel() != null)
          {
            allGenModels.add(genPackage.getGenModel());
          }
        }
      }

      List<GenPackage> usedGenPackages = new UniqueEList.FastCompare<GenPackage>();
      for (int i = 0; i < missingEPackages.size(); i++)
      {
        EPackage ePackage = missingEPackages.get(i);
        for (int j = 0; j < allGenModels.size(); j++)
        {
          GenModel genModel = allGenModels.get(j);
          GenPackage genPackage = genModel.findGenPackage(ePackage);
          if (genPackage != null)
          {
            usedGenPackages.add(genPackage);
            getMissingPackagesHelper(missingEPackages, Collections.singletonList(genPackage));
            break;
          }
        }
      }    
      return usedGenPackages;
    } 
    else
    {
      return Collections.emptyList();
    }
  }

  public List<EPackage> getMissingPackages()
  {
    List<EPackage> ePackages = new UniqueEList<EPackage>();
    getMissingPackagesHelper(ePackages, getGenPackages());
    getMissingPackagesHelper(ePackages, getUsedGenPackages());
    return ePackages;
  }

  protected void getMissingPackagesHelper(List<EPackage> ePackages, List<GenPackage> genPackages)
  {
    for (GenPackage genPackage : genPackages)
    {
      EPackage ePackage = genPackage.getEcorePackage();
      if (ePackage != null)
      {
        for (Iterator<EObject> j = ePackage.eAllContents(); j.hasNext();)
        {
          EObject eObject = j.next();
          for (Iterator<EObject> k = eObject.eCrossReferences().iterator(); k.hasNext(); )
          {
            EObject o = k.next();
            if (o instanceof EClassifier)
            {
              EClassifier eClassifier = (EClassifier)o;
              if (findGenClassifier(eClassifier) == null)
              {
                ePackages.add(eClassifier.getEPackage());
              }
            }
          }
        }
      }
    }
  }


  public boolean hasXMLDependency()
  {
    for (GenPackage genPackage : getAllGenPackagesWithClassifiers())
    {
      switch (genPackage.getResource().getValue())
      {
        case GenResourceKind.XML:
        case GenResourceKind.XMI:
        {
          return true;
        }
      }
    }
    return false;
  }

  public String getXMLEncodingChoices()
  {
    return CodeGenEcorePlugin.INSTANCE.getString("_UI_XMLEncodingChoices");
  }

  public String getIndentation(StringBuffer stringBuffer)
  {
    int index = stringBuffer.length(); 
    LOOP:
    while (--index >= 0)
    {
      switch (stringBuffer.charAt(index))
      {
        case '\n':
        case '\r':
        {
          break LOOP;
        }
      }
    }
    return stringBuffer.substring(index + 1);
  }

  public List<GenFeature> getAllGenFeatures()
  {
    List<GenFeature> result = new ArrayList<GenFeature>();

    // Any features from one package that delegate to features in another.
    //
    List<GenFeature> delegated = new ArrayList<GenFeature>();

    for (GenPackage genPackage : getAllGenAndUsedGenPackagesWithClassifiers())
    {
      if (genPackage.getGenModel() == this || !genPackage.getGenModel().hasEditSupport())
      {
        for (GenFeature genFeature : genPackage.getAllGenFeatures())
        {
          List<GenFeature> addTo = genFeature.getGenPackage() == genPackage ? result : delegated;
          addTo.add(genFeature);
        }
      }
    }

    // If there are features delegating across packages, add only those that aren't already being generated.
    //
    if (!delegated.isEmpty())
    {
      addNonDuplicates(result, delegated, null);
    }
    return result;
  }

  public List<GenFeature> getFilteredAllGenFeatures()
  {
    ArrayList<GenFeature> result = new ArrayList<GenFeature>();

    // We need to filer out duplicates in the unlikely event that we have two
    // features with the same class-qualifed name. We'll only generate one property
    // string in that case and let the user add the second one mannually, if necessary.
    //
    Set<String> noDupSet = new HashSet<String>();
    for (GenFeature genFeature : getAllGenFeatures())
    {
      if (isCreationCommands() || genFeature.isProperty())
      {
        if (noDupSet.add(genFeature.getGenClass().getName() + "_" + genFeature.getName()))
        {
          result.add(genFeature);
        }
      }
    }
    return result;
  }

  /**
   * @deprecated In EMF 2.2, the Generator-based design renders this field obsolete. It will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Deprecated
  protected Map codeFormatterOptions = null;

  /**
   * Set the code formatter options to be used to {@link #createCodeFormatter create} a new code formatter.
   *  
   * @deprecated In EMF 2.2, the {@link org.eclipse.emf.codegen.ecore.generator.Generator.Options Generator.Options} should be used to
   * record code formatter options in order to be used via the new Generator-based design. This method will be removed after 2.2.
   */
  @SuppressWarnings("unchecked")
  @Deprecated
  public void setCodeFormatterOptions(Map options)
  {
    codeFormatterOptions = options;
  }

  /**
   * Creates and returns a new JDT code formatter.
   * 
   * @deprecated In EMF 2.2, a {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapter GeneratorAdapter} should be used to
   * implement code generation. {@link org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter AbstractGeneratorAdapter} provides
   * an equivalent to this method. This method will be removed after 2.2.
   */
  @Deprecated
  public CodeFormatter createCodeFormatter()
  {
    return ToolFactory.createCodeFormatter(codeFormatterOptions);
  }
  
  public boolean isBooleanFlagsEnabled()
  {
    return !isBlank(getBooleanFlagsField()) && !isReflectiveDelegation();
  }

  public GenModel createGenModel()
  {
    return GenModelFactory.eINSTANCE.createGenModel();
  }

  public GenPackage createGenPackage()
  {
    return GenModelFactory.eINSTANCE.createGenPackage();
  }

  public GenClass createGenClass()
  {
    return GenModelFactory.eINSTANCE.createGenClass();
  }

  public GenFeature createGenFeature()
  {
    return GenModelFactory.eINSTANCE.createGenFeature();
  }

  public GenEnum createGenEnum()
  {
    return GenModelFactory.eINSTANCE.createGenEnum();
  }

  public GenEnumLiteral createGenEnumLiteral()
  {
    return GenModelFactory.eINSTANCE.createGenEnumLiteral();
  }

  public GenDataType createGenDataType()
  {
    return GenModelFactory.eINSTANCE.createGenDataType();
  }

  public GenOperation createGenOperation()
  {
    return GenModelFactory.eINSTANCE.createGenOperation();
  }

  public GenParameter createGenParameter()
  {
    return GenModelFactory.eINSTANCE.createGenParameter();
  }
  
  public GenTypeParameter createGenTypeParameter()
  {
    return GenModelFactory.eINSTANCE.createGenTypeParameter();
  }

  public GenAnnotation createGenAnnotation()
  {
    return GenModelFactory.eINSTANCE.createGenAnnotation();
  }
  
  public GenBase create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case GenModelPackage.GEN_MODEL: return createGenModel();
      case GenModelPackage.GEN_PACKAGE: return createGenPackage();
      case GenModelPackage.GEN_CLASS: return createGenClass();
      case GenModelPackage.GEN_FEATURE: return createGenFeature();
      case GenModelPackage.GEN_ENUM: return createGenEnum();
      case GenModelPackage.GEN_ENUM_LITERAL: return createGenEnumLiteral();
      case GenModelPackage.GEN_DATA_TYPE: return createGenDataType();
      case GenModelPackage.GEN_OPERATION: return createGenOperation();
      case GenModelPackage.GEN_PARAMETER: return createGenParameter();
      case GenModelPackage.GEN_ANNOTATION: return createGenAnnotation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid GenModel classifier");
    }
  }
  
  public Set<String> getPropertyCategories()
  {
    Set<String> categories = new HashSet<String>();
    for (GenFeature genFeature : getFilteredAllGenFeatures())
    {
      String category = genFeature.getPropertyCategory();

      if (!isBlank(category))
      {
        categories.add(category);
      }
    }
    return categories;
  }
  
  public boolean hasLocalGenModel()
  {
    if (eResource() != null && eResource().getURI() != null)
    {
      URI genModelURI = eResource().getURI();
      URI modelDirectory = URI.createURI(getModelDirectory());    
      return 
        genModelURI.isPlatformResource() && 
           modelDirectory.segmentCount() > 0 &&
           genModelURI.segment(1).equals(modelDirectory.segment(0));
    }
    else
    {
      return false;
    }
  }
  
  public String getRelativeGenModelLocation()
  {
    URI genModelURI = eResource().getURI();
    String result = genModelURI.deresolve(genModelURI.trimSegments(genModelURI.segmentCount() - 2).appendSegment("")).toString();
    return result;
  }
  
  public String getPropertyCategoryKey(String category)
  {
    return "_UI_" + CodeGenUtil.validJavaIdentifier(category) + "PropertyCategory";
  }

  public boolean isVirtualDelegation()
  {
    return getFeatureDelegation() == GenDelegationKind.VIRTUAL_LITERAL;
  }
  
  public boolean useClassOverrideAnnotation()
  {
    return getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
  }

  public boolean useGenerics()
  {
    return getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
  }

  @Override
  public GenClassifier findGenClassifier(EClassifier classifier)
  {
    return super.findGenClassifier(classifier);
  }

} //GenModelImpl
