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
 * $Id: GenPackageGeneratorAdapter.java,v 1.2 2006/05/01 17:55:53 davidms Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.CodeGenEcorePlugin;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @since 2.2.0
 */
public class GenPackageGeneratorAdapter extends GenBaseGeneratorAdapter
{
  protected static final int PACKAGE_CLASS_ID = 0;
  protected static final int FaCTORY_CLASS_ID = 1;
  protected static final int XML_PROCESSOR_CLASS_ID = 2;
  protected static final int VALIDATOR_CLASS_ID = 3;
  protected static final int SWITCH_CLASS_ID = 4;
  protected static final int ADAPTER_FACTORY_CLASS_ID = 5;
  protected static final int RESOURCE_FACTORY_CLASS_ID = 6;
  protected static final int RESOURCE_CLASS_ID = 7;
  protected static final int ITEM_PROVIDER_ADAPTER_FACTORY_ID = 8;
  protected static final int EDITOR_ID = 9;
  protected static final int MODEL_WIZARD_ID = 10;
  protected static final int ACTION_BAR_CONTRIBUTOR_ID = 11;
  protected static final int PACKAGE_TEST_SUITE_ID = 12;
  protected static final int PACKAGE_EXAMPLE_ID = 13;

  private static final JETEmitterDescriptor[] JET_EMITTER_DESCRIPTORS =
  {
    new JETEmitterDescriptor("model/PackageClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.PackageClass"),
    new JETEmitterDescriptor("model/FactoryClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.FactoryClass"),
    new JETEmitterDescriptor("model/XMLProcessorClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.XMLProcessorClass"),
    new JETEmitterDescriptor("model/ValidatorClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ValidatorClass"),
    new JETEmitterDescriptor("model/SwitchClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.SwitchClass"),
    new JETEmitterDescriptor("model/AdapterFactoryClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.AdapterFactoryClass"),
    new JETEmitterDescriptor("model/ResourceFactoryClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ResourceFactoryClass"),
    new JETEmitterDescriptor("model/ResourceClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ResourceClass"),
    new JETEmitterDescriptor("edit/ItemProviderAdapterFactory.javajet", "org.eclipse.emf.codegen.ecore.templates.edit.ItemProviderAdapterFactory"),
    new JETEmitterDescriptor("editor/Editor.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.Editor"),
    new JETEmitterDescriptor("editor/ModelWizard.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.ModelWizard"),
    new JETEmitterDescriptor("editor/ActionBarContributor.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.ActionBarContributor"),
    new JETEmitterDescriptor("model.tests/PackageTestSuite.javajet", "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageTestSuite"),
    new JETEmitterDescriptor("model.tests/PackageExample.javajet", "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageExample")
  };

  protected static final int MODEL_ICON_ID = 0;
  protected static final int MODEL_WIZARD_ICON_ID = 1;

  private static final String[] INPUT_PATH_NAMES = { "editor/ModelFile.gif", "editor/NewModel.gif" };

  public GenPackageGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory)
  {
    super(generatorAdapterFactory);
  }

  protected Collection getGenerateModelChildren(Object object)
  {
    GenPackage genPackage = (GenPackage)object;
    List result = new ArrayList(genPackage.getGenClasses());
    result.addAll(genPackage.getGenEnums());
    result.addAll(genPackage.getNestedGenPackages());
    return result;
  }

  protected Collection getGenerateEditChildren(Object object)
  {
    GenPackage genPackage = (GenPackage)object;
    List result = new ArrayList(genPackage.getGenClasses());
    result.addAll(genPackage.getNestedGenPackages());
    return result;
  }

  protected Collection getGenerateTestsChildren(Object object)
  {
    GenPackage genPackage = (GenPackage)object;
    List result = new ArrayList(genPackage.getGenClasses());
    result.addAll(genPackage.getNestedGenPackages());
    return result;
  }

  protected Diagnostic doPreGenerate(Object object, Object projectType)
  {
    if (MODEL_PROJECT_TYPE.equals(projectType))
    {
      ((GenPackage)object).prepareCache();
      return Diagnostic.OK_INSTANCE;
    }
    return super.doPreGenerate(object, projectType);
  }

  protected Diagnostic doPostGenerate(Object object, Object projectType)
  {
    if (MODEL_PROJECT_TYPE.equals(projectType))
    {
      ((GenPackage)object).clearCache();
      return Diagnostic.OK_INSTANCE;
    }
    return super.doPreGenerate(object, projectType);
  }

  protected JETEmitterDescriptor[] getJETEmitterDescriptors()
  {
    return JET_EMITTER_DESCRIPTORS;
  }

  protected String[] getInputPathNames()
  {
    return INPUT_PATH_NAMES;
  }

  protected Diagnostic generateModel(Object object, Monitor monitor)
  {
    monitor.beginTask("", 13);

    GenPackage genPackage = (GenPackage)object;
    message = CodeGenEcorePlugin.INSTANCE.getString
      ("_UI_GeneratingPackage_message", new Object[] { genPackage.getPackageInterfaceName() });
    monitor.subTask(message);

    GenModel genModel = genPackage.getGenModel();
    ensureProjectExists
      (genModel.getModelDirectory(), genPackage, MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));

    generateSchema(genPackage, monitor);
    generatePackageSerialization(genPackage, monitor);
    generatePackageInterface(genPackage, monitor);
    generatePackageClass(genPackage, monitor);
    generateFactoryInterface(genPackage, monitor);
    generateFactoryClass(genPackage, monitor);
    generateXMLProcessorClass(genPackage, monitor);
    generateValidatorClass(genPackage, monitor);
    generateSwitchClass(genPackage, monitor);
    generateAdapterFactoryClass(genPackage, monitor);
    generateResourceFactoryClass(genPackage, monitor);
    generateResourceClass(genPackage, monitor);

    return Diagnostic.OK_INSTANCE;
  }

  protected void generateSchema(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.getGenModel().isGenerateSchema())
    {
      // This functionality should eventually go away, as it is replaced by model exporters.
      // We'll just delegate to the deprecated GenPackage method. The monitor isn't used, so we won't pass it.
      //
      genPackage.generateSchema();
    }
    monitor.worked(1);      
  }

  protected void generatePackageSerialization(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.isLoadingInitialization())
    {
      monitor = createMonitor(monitor, 1);

      try
      {
        monitor.beginTask("", 2);

        GenModel genModel = genPackage.getGenModel();
        String targetPathName = genModel.getModelDirectory() + "/" + genPackage.getClassPackageName().replace('.', '/') + "/" +
          genPackage.getSerializedPackageFilename();
        message = CodeGenEcorePlugin.INSTANCE.getString("_UI_GeneratingPackageSerialization_message", new Object[] { targetPathName });
        monitor.subTask(message);

        URI targetFile = toURI(targetPathName);
        ensureContainerExists(targetFile.trimSegments(1), createMonitor(monitor, 1));

        Resource outputResource = genPackage.getEcorePackage().eResource();
        ResourceSet set = outputResource.getResourceSet();
        URI targetURI = toPlatformResourceURI(targetFile);

        Map oldURIs = new HashMap();

        // Set URIs of EPackage-containing resources: output resource to desired target URI, and others to package
        // namespace URIs (so cross-references will be resolved via package registry when deserialized). 
        //
        for (Iterator i = set.getResources().iterator(); i.hasNext(); )
        {
          Resource resource = (Resource)i.next();
          List contents = resource.getContents();
  
          if (!contents.isEmpty() && contents.get(0) instanceof EPackage)
          {
            EPackage ePackage = (EPackage)contents.get(0);
            oldURIs.put(resource, resource.getURI());
            resource.setURI(resource == outputResource ? targetURI : URI.createURI(ePackage.getNsURI()));
          }        
        }

        try
        {
          outputResource.save(null);
        }
        catch (IOException exception)
        {
          //DMS handle this well.
          CodeGenEcorePlugin.INSTANCE.log(exception);
        }

        // Restore original resource URI values.
        //
        for (Iterator i = set.getResources().iterator(); i.hasNext(); )
        {
          Resource resource = (Resource)i.next();
          List contents = resource.getContents();
  
          if (!contents.isEmpty() && contents.get(0) instanceof EPackage)
          {
            resource.setURI((URI)oldURIs.get(resource));
          }        
        }
      }
      finally
      {
        monitor.done();
      }
    }
    else
    {
      monitor.worked(1);
    }
  }    

  protected void generatePackageInterface(GenPackage genPackage, Monitor monitor)
  {
    GenModel genModel = genPackage.getGenModel();

    if (genPackage.hasClassifiers() && !genModel.isSuppressEMFMetaData() && !genModel.isSuppressInterfaces())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaInterface_message", new Object[] { genPackage.getQualifiedPackageInterfaceName() });
      monitor.subTask(message);
      generateJava
        (genModel.getModelDirectory(),
         genPackage.getReflectionPackageName(),
         genPackage.getPackageInterfaceName(),
         getJETEmitter(getJETEmitterDescriptors(), PACKAGE_CLASS_ID),
         new Object[] { new Object[] { genPackage, Boolean.TRUE, Boolean.FALSE }},
         createMonitor(monitor, 1)); 
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generatePackageClass(GenPackage genPackage, Monitor monitor)
  {
    GenModel genModel = genPackage.getGenModel();

    if (genPackage.hasClassifiers())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedPackageClassName() });
      monitor.subTask(message);
      generateJava
        (genModel.getModelDirectory(),
         genPackage.getReflectionClassPackageName(),
         genPackage.getPackageClassName(),
         getJETEmitter(getJETEmitterDescriptors(), PACKAGE_CLASS_ID),
         new Object[]
         {
           new Object[] 
           {
             genPackage, 
             genModel.isSuppressEMFMetaData() || genModel.isSuppressInterfaces() ? Boolean.TRUE: Boolean.FALSE, 
             Boolean.TRUE 
           }
         },
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateFactoryInterface(GenPackage genPackage, Monitor monitor)
  {
    GenModel genModel = genPackage.getGenModel();

    if (genPackage.hasClassifiers() && !genModel.isSuppressInterfaces())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaInterface_message", new Object[] { genPackage.getQualifiedFactoryInterfaceName() });
      monitor.subTask(message);
      generateJava
        (genModel.getModelDirectory(),
         genPackage.getReflectionPackageName(), 
         genPackage.getFactoryInterfaceName(),
         getJETEmitter(getJETEmitterDescriptors(), FaCTORY_CLASS_ID),
         new Object[] { new Object[] { genPackage, Boolean.TRUE, Boolean.FALSE }},
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateFactoryClass(GenPackage genPackage, Monitor monitor)
  {
    GenModel genModel = genPackage.getGenModel();

    if (genPackage.hasClassifiers())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedFactoryClassName() });
      monitor.subTask(message);
      generateJava
      (genModel.getModelDirectory(),
       genPackage.getReflectionClassPackageName(),
       genPackage.getFactoryClassName(),
       getJETEmitter(getJETEmitterDescriptors(), FaCTORY_CLASS_ID),
       new Object[] { new Object[] { genPackage, genModel.isSuppressInterfaces() ? Boolean.TRUE : Boolean.FALSE, Boolean.TRUE }},
       createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateXMLProcessorClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.getResource().getValue() == GenResourceKind.XML)
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] {  genPackage.getQualifiedXMLProcessorClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getXMLProcessorClassName(),
         getJETEmitter(getJETEmitterDescriptors(), XML_PROCESSOR_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateValidatorClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.hasConstraints())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedValidatorClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getValidatorClassName(),
         getJETEmitter(getJETEmitterDescriptors(), VALIDATOR_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateSwitchClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.isAdapterFactory() && !genPackage.getGenClasses().isEmpty())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedSwitchClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getSwitchClassName(),
         getJETEmitter(getJETEmitterDescriptors(), SWITCH_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateAdapterFactoryClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.isAdapterFactory() && !genPackage.getGenClasses().isEmpty())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedAdapterFactoryClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getAdapterFactoryClassName(),
         getJETEmitter(getJETEmitterDescriptors(), ADAPTER_FACTORY_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateResourceFactoryClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.getResource() != GenResourceKind.NONE_LITERAL)
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedResourceFactoryClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getResourceFactoryClassName(),
         getJETEmitter(getJETEmitterDescriptors(), RESOURCE_FACTORY_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateResourceClass(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.getResource() != GenResourceKind.NONE_LITERAL)
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedResourceClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getModelDirectory(),
         genPackage.getUtilitiesPackageName(),
         genPackage.getResourceClassName(),
         getJETEmitter(getJETEmitterDescriptors(), RESOURCE_CLASS_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected Diagnostic generateEdit(Object object, Monitor monitor)
  {
    monitor.beginTask("", 2);

    GenPackage genPackage = (GenPackage)object;
    message = CodeGenEcorePlugin.INSTANCE.getString
      ("_UI_GeneratingItemProvidersForPackage_message", new Object[] { genPackage.getPackageInterfaceName() });
    monitor.subTask(message);

    GenModel genModel = genPackage.getGenModel();
    ensureProjectExists
      (genModel.getEditDirectory(), genPackage, EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));

    generateItemProviderAdapterFactory(genPackage, monitor);

    return Diagnostic.OK_INSTANCE;
  }

  protected void generateItemProviderAdapterFactory(GenPackage genPackage, Monitor monitor)
  {
    if (!genPackage.getGenClasses().isEmpty())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedItemProviderAdapterFactoryClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getEditDirectory(),
         genPackage.getProviderPackageName(),
         genPackage.getItemProviderAdapterFactoryClassName(),
         getJETEmitter(getJETEmitterDescriptors(), ITEM_PROVIDER_ADAPTER_FACTORY_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected Diagnostic generateEditor(Object object, Monitor monitor)
  {
    monitor.beginTask("", 6);

    GenPackage genPackage = (GenPackage)object;
    message = CodeGenEcorePlugin.INSTANCE.getString
      ("_UI_GeneratingEditorForPackage_message", new Object[] { genPackage.getPackageInterfaceName() });
    monitor.subTask(message);

    GenModel genModel = genPackage.getGenModel();
    ensureProjectExists
      (genModel.getEditDirectory(), genPackage, EDITOR_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));

    generateEditor(genPackage, monitor);
    generateModelWizard(genPackage, monitor);
    generateActionBarContributor(genPackage, monitor);
    generateModelIcon(genPackage, monitor);
    generateModelWizardIcon(genPackage, monitor);

    return Diagnostic.OK_INSTANCE;
  }

  protected void generateEditor(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasConcreteClasses())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedEditorClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getEditorDirectory(),
         genPackage.getPresentationPackageName(),
         genPackage.getEditorClassName(),
         getJETEmitter(getJETEmitterDescriptors(), EDITOR_ID),
         null,
         createMonitor(monitor, 1)); 
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateModelWizard(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasConcreteClasses())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedModelWizardClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getEditorDirectory(),
         genPackage.getPresentationPackageName(),
         genPackage.getModelWizardClassName(),
         getJETEmitter(getJETEmitterDescriptors(), MODEL_WIZARD_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateActionBarContributor(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasConcreteClasses())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedActionBarContributorClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getEditorDirectory(),
         genPackage.getPresentationPackageName(),
         genPackage.getActionBarContributorClassName(),
         getJETEmitter(getJETEmitterDescriptors(), ACTION_BAR_CONTRIBUTOR_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateModelIcon(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasConcreteClasses())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingModelIcon_message", new Object[] { genPackage.getModelIconFileName() });
      monitor.subTask(message);
      generateGIF
        (genPackage.getModelIconFileName(),
         getGIFEmitter(getInputPathNames(), MODEL_ICON_ID),
         genPackage.getPrefix(),
         null,
         false,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generateModelWizardIcon(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasConcreteClasses())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingModelWizardIcon_message", new Object[] { genPackage.getModelWizardIconFileName() });
      monitor.subTask(message);
      generateGIF
        (genPackage.getModelWizardIconFileName(),
         getGIFEmitter(getInputPathNames(), MODEL_WIZARD_ICON_ID),
         genPackage.getPrefix(),
         null,
         false,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected Diagnostic generateTests(Object object, Monitor monitor)
  {
    monitor.beginTask("", 3);

    GenPackage genPackage = (GenPackage)object;
    message = CodeGenEcorePlugin.INSTANCE.getString
      ("_UI_GeneratingTestsForPackage_message", new Object[] { genPackage.getPackageInterfaceName() });
    monitor.subTask(message);

    GenModel genModel = genPackage.getGenModel();
    ensureProjectExists
      (genModel.getEditDirectory(), genPackage, TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));

    generatePackageTestSuite(genPackage, monitor);
    generatePackageExample(genPackage, monitor);

    return Diagnostic.OK_INSTANCE;
  }

  protected void generatePackageTestSuite(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedTestSuiteClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getTestsDirectory(),
         genPackage.getTestsPackageName(),
         genPackage.getTestSuiteClassName(),
         getJETEmitter(getJETEmitterDescriptors(), PACKAGE_TEST_SUITE_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }

  protected void generatePackageExample(GenPackage genPackage, Monitor monitor)
  {
    if (genPackage.hasClassifiers() && genPackage.isGenerateExampleClass())
    {
      message = CodeGenEcorePlugin.INSTANCE.getString
        ("_UI_GeneratingJavaClass_message", new Object[] { genPackage.getQualifiedExampleClassName() });
      monitor.subTask(message);
      generateJava
        (genPackage.getGenModel().getTestsDirectory(),
         genPackage.getTestsPackageName(),
         genPackage.getExampleClassName(),
         getJETEmitter(getJETEmitterDescriptors(), PACKAGE_EXAMPLE_ID),
         null,
         createMonitor(monitor, 1));
    }
    else
    {
      monitor.worked(1);
    }
  }
}
