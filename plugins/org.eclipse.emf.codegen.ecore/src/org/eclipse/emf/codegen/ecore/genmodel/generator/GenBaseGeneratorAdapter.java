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
 * $Id: GenBaseGeneratorAdapter.java,v 1.3.2.2 2006/11/14 17:59:58 davidms Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel.generator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import org.eclipse.emf.codegen.ecore.CodeGenEcorePlugin;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * A base generator adapter implementation for GenModel elements.
 * 
 * This base defines four project types for code generation and provides implementations of
 * {@link #canGenerate(Object, Object)}, {@link #getGenerateChildren(Object, Object)}, and
 * {@link #doGenerate(Object, Object, Monitor)} that dispatch to project-type-specific methods, which
 * can be overridden in subclasses.
 * 
 * @since 2.2.0
 */
public class GenBaseGeneratorAdapter extends AbstractGeneratorAdapter
{
  /**
   * The project type constant representing a model project.
   * This is the string "org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject".
   */
  public static final String MODEL_PROJECT_TYPE = "org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject";

  /**
   * The project type constant representing an edit project.
   * This is the string "org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject".
   */
  public static final String EDIT_PROJECT_TYPE = "org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject";

  /**
   * The project type constant representing an editor project.
   * This is the string "org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject".
   */
  public static final String EDITOR_PROJECT_TYPE = "org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject";

  /**
   * The project type constant representing a tests project.
   * This is the string "org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject".
   */
  public static final String TESTS_PROJECT_TYPE = "org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject";

  public GenBaseGeneratorAdapter()
  {    
  }

  public GenBaseGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory)
  {
    super(generatorAdapterFactory);
  }

  /**
   * Based on the given project type, dispatches to one of {@link #canGenerateModel(Object)},
   * {@link #canGenerateEdit(Object)}, {@link #canGenerateEditor(Object)}, or {@link #canGenerateTests(Object)}.
   */
  public boolean canGenerate(Object object, Object projectType)
  {
    if (MODEL_PROJECT_TYPE.equals(projectType))
    {
      return canGenerateModel(object);
    }
    else if (EDIT_PROJECT_TYPE.equals(projectType))
    {
      return canGenerateEdit(object);
    }
    else if (EDITOR_PROJECT_TYPE.equals(projectType))
    {
      return canGenerateEditor(object);
    }
    else if (TESTS_PROJECT_TYPE.equals(projectType))
    {
      return canGenerateTests(object);
    }
    return false;
  }

  /**
   * Delegates to the GenMoel element's {@link GenBase#canGenerate() canGenerate()} method.
   */
  public boolean canGenerateModel(Object object)
  {
    return ((GenBase)object).canGenerate();
  }

  /**
   * Delegates to the GenMoel element's {@link GenBase#canGenerateEdit()() canGenerateEdit()} method.
   */
  public boolean canGenerateEdit(Object object)
  {
    return ((GenBase)object).canGenerateEdit();
  }

  /**
   * Delegates to the GenMoel element's {@link GenBase#canGenerateEditor()() canGenerateEditor()} method.
   */
  public boolean canGenerateEditor(Object object)
  {
    return ((GenBase)object).canGenerateEditor();
  }

  /**
   * Delegates to the GenMoel element's {@link GenBase#canGenerateTests() canGenerateTests()} method.
   */
  public boolean canGenerateTests(Object object)
  {
    return ((GenBase)object).canGenerateTests();
  }

  /**
   * Based on the given project type, dispatches to one of {@link #getGenerateModelChildren(Object)},
   * {@link #getGenerateEditChildren(Object)}, {@link #getGenerateEditorChildren(Object)}, or
   * {@link #getGenerateTestsChildren(Object)}.
   */
  public Collection getGenerateChildren(Object object, Object projectType)
  {
    if (MODEL_PROJECT_TYPE.equals(projectType))
    {
      return getGenerateModelChildren(object);
    }
    else if (EDIT_PROJECT_TYPE.equals(projectType))
    {
      return getGenerateEditChildren(object);
    }
    else if (EDITOR_PROJECT_TYPE.equals(projectType))
    {
      return getGenerateEditorChildren(object);
    }
    else if (TESTS_PROJECT_TYPE.equals(projectType))
    {
      return getGenerateTestsChildren(object);
    }
    return Collections.EMPTY_LIST;
  }

  protected Collection getGenerateModelChildren(Object object)
  {
    return Collections.EMPTY_LIST;
  }

  protected Collection getGenerateEditChildren(Object object)
  {
    return Collections.EMPTY_LIST;
  }

  protected Collection getGenerateEditorChildren(Object object)
  {
    return Collections.EMPTY_LIST;
  }

  protected Collection getGenerateTestsChildren(Object object)
  {
    return Collections.EMPTY_LIST;
  }

  /**
   * Returns the container of the given object if it is a GenModel element, and null otherwise. 
   */
  protected Object getParent(Object object)
  {
    Object result = ((GenBase)object).eContainer();
    return result instanceof GenBase ? result : null;
  }

  /**
   * Based on the given project type, dispatches to one of {@link #generateModel(Object, Monitor)},
   * {@link #generateEdit(Object, Monitor)}, {@link #generateEditor(Object, Monitor)}, or
   * {@link #generateTests(Object, Monitor)}.
   */
  public Diagnostic doGenerate(Object object, Object projectType, Monitor monitor)
  {
    if (MODEL_PROJECT_TYPE.equals(projectType))
    {
      return generateModel(object, monitor);
    }
    else if (EDIT_PROJECT_TYPE.equals(projectType))
    {
      return generateEdit(object, monitor);
    }
    else if (EDITOR_PROJECT_TYPE.equals(projectType))
    {
      return generateEditor(object, monitor);
    }
    else if (TESTS_PROJECT_TYPE.equals(projectType))
    {
      return generateTests(object, monitor);
    }
    throw new IllegalArgumentException("Invalid projectType: " + projectType.toString());
  }

  protected Diagnostic generateModel(Object object, Monitor monitor)
  {
    return Diagnostic.OK_INSTANCE;
  }

  protected Diagnostic generateEdit(Object object, Monitor monitor)
  {
    return Diagnostic.OK_INSTANCE;
  }

  protected Diagnostic generateEditor(Object object, Monitor monitor)
  {
    return Diagnostic.OK_INSTANCE;
  }

  protected Diagnostic generateTests(Object object, Monitor monitor)
  {
    return Diagnostic.OK_INSTANCE;
  }

  /**
   * Returns the user-specified portion of the dynamic template path from the GenModel.
   * 
   * <p>This method can be overridden, but to maintain compatibility with 2.2.1, it should not be invoked by subclasses,
   * except from its own overrides. Nor should such overrides be invoked.
   * @since org.eclipse.emf.codegen.ecore 2.2.2
   */
  protected List getUserTemplatePath()
  {
    String templateLocation = ((GenBase)generatingObject).getGenModel().getTemplateDirectory();
    if (templateLocation != null && templateLocation.length() != 0)
    {
      if (templateLocation.indexOf(':') == -1)
      {
        templateLocation = URI.createPlatformResourceURI(templateLocation, true).toString();
      }
      return Collections.singletonList(templateLocation);
    }
    return Collections.EMPTY_LIST;
  }

  /**
   * Adds the default EMF template location to the base portion of the dynamic template path. Subclasses may
   * override this to add to the front of the path, and then invoke this implementation.
   * *
   * <p>To maintain compatibility with 2.2.1, this method should not be invoked by subclasses, except from its own
   * overrides. Nor should such overrides be invoked.
   * @since org.eclipse.emf.codegen.ecore 2.2.2
   */
  protected void addBaseTemplatePathEntries(List templatePath)
  {
    templatePath.add(CodeGenEcorePlugin.INSTANCE.getBaseURL().toString() + "templates");
    super.addBaseTemplatePathEntries(templatePath);
  }

  /**
   * Adds the plug-ins required for GenModel/Ecore-based templates to the <code>JETEmitter</code>'s classpath.
   */
  protected void addClasspathEntries(JETEmitter jetEmitter) throws JETException
  {
    jetEmitter.addVariable("EMF_CODEGEN", "org.eclipse.emf.codegen");
    jetEmitter.addVariable("EMF_CODEGEN_ECORE", "org.eclipse.emf.codegen.ecore");
    jetEmitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
    jetEmitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");
  }

  /**
   * Creates the import manager and stores it on the <code>GenModel</code>, for use its in computing names.
   */
  protected void createImportManager(String packageName, String className)
  {
    super.createImportManager(packageName, className);
    updateImportManager();
  }

  /**
   * Clears the import manager and removes it from the <code>GenModel</code>.
   */
  protected void clearImportManager()
  {
    super.clearImportManager();
    updateImportManager();
  }

  private void updateImportManager()
  {
    if (generatingObject != null)
    {
      ((GenBase)generatingObject).getGenModel().setImportManager(importManager);
    }    
  }

  /**
   * Ensures that a project exists. If not, a properly configured EMF project will be created. Similarly, if the project
   * does exist and <code>force</code> is true, it will be reconfigured to match the default EMF configuration.
   */
  protected void ensureProjectExists(String workspacePath, Object object, Object projectType, boolean force, Monitor monitor)
  {
    try
    {
      if (EMFPlugin.IS_ECLIPSE_RUNNING)
      {
        EclipseHelper.ensureProjectExists(workspacePath, object, projectType, force, monitor);
      }
    }
    finally
    {
      monitor.done();
    }
  }

  /*
   * All Eclipse-dependent operations are delegated to this class. This pattern avoids any runtime failure due to
   * missing dependencies in the standalone case.
   */
  private static class EclipseHelper
  {
    public static boolean ensureProjectExists(String workspacePath, Object object, Object projectType, boolean force, Monitor monitor)
    {
      try
      {
        IPath path = new Path(workspacePath);

        if (path.isAbsolute())
        {
          GenModel genModel = ((GenBase)object).getGenModel();
          IWorkspace workspace = ResourcesPlugin.getWorkspace();
          IProject project = workspace.getRoot().getProject(path.segment(0));

          if (!project.exists() || force)
          {
            IPath projectLocation = null;
            List referencedProjects = new UniqueEList();

            if (project.exists())
            {
              referencedProjects.addAll(Arrays.asList(project.getDescription().getReferencedProjects()));
              projectLocation = project.getDescription().getLocation();
            }
            else
            {
              URI genModelURI = genModel.eResource().getURI();
              if (genModelURI.toString().startsWith("platform:/resource/"))
              {
                IProject genModelProject = workspace.getRoot().getProject(genModelURI.segments()[1]);
                projectLocation = genModelProject.getDescription().getLocation();
              }
            }

            IProject modelProject = workspace.getRoot().getProject(genModel.getModelProjectDirectory());
            IPath javaSource = new Path(genModel.getModelDirectory());

            //DMS factor this into a method? Use a non-static subclass? 
            int style = 0;
            if (MODEL_PROJECT_TYPE.equals(projectType))  style = Generator.EMF_MODEL_PROJECT_STYLE;
            if (EDIT_PROJECT_TYPE.equals(projectType))   style = Generator.EMF_EDIT_PROJECT_STYLE;
            if (EDITOR_PROJECT_TYPE.equals(projectType)) style = Generator.EMF_EDITOR_PROJECT_STYLE;
            if (TESTS_PROJECT_TYPE.equals(projectType))  style = Generator.EMF_TESTS_PROJECT_STYLE;

            if ((style & Generator.EMF_TESTS_PROJECT_STYLE) != 0)
            {
              IProject testsProject = workspace.getRoot().getProject(genModel.getTestsProjectDirectory());

              if (!genModel.sameModelTestsProject()) 
              {
                javaSource = new Path(genModel.getTestsDirectory());
  
                if (testsProject.exists())
                {
                  projectLocation = testsProject.getDescription().getLocation();
                }

                referencedProjects.add(modelProject);
                referencedProjects.addAll(Arrays.asList(modelProject.getDescription().getReferencedProjects()));
              }
            }
            else if ((style & Generator.EMF_MODEL_PROJECT_STYLE) == 0 && genModel.hasEditSupport())
            {
              IProject editProject = workspace.getRoot().getProject(genModel.getEditProjectDirectory());

              if (!genModel.sameModelEditProject())
              {
                javaSource = new Path(genModel.getEditDirectory());
                if (editProject.exists())
                {
                  projectLocation = editProject.getDescription().getLocation();
                }

                referencedProjects.add(modelProject);
              }
  
              for (Iterator i = genModel.getUsedGenPackages().iterator(); i.hasNext(); )
              {
                GenModel otherGenModel = ((GenPackage)i.next()).getGenModel();
                if (otherGenModel.hasEditSupport())
                {
                  IProject otherEditProject = workspace.getRoot().getProject(otherGenModel.getEditProjectDirectory());
                  if (otherEditProject.exists())
                  {
                    referencedProjects.add(otherEditProject);
                    referencedProjects.addAll(Arrays.asList(otherEditProject.getDescription().getReferencedProjects()));
                  }
                }
              }

              if ((style & Generator.EMF_EDIT_PROJECT_STYLE) == 0 && genModel.hasEditorSupport())
              {
                javaSource = new Path(genModel.getEditorDirectory());
                if (!genModel.sameEditEditorProject())
                {
                  referencedProjects.add(editProject);
                  referencedProjects.addAll(Arrays.asList(editProject.getDescription().getReferencedProjects()));
                }
              }
            }

            //  Remove any non-Java dependencies from being added.
            //
            for (Iterator i = referencedProjects.iterator(); i.hasNext(); )
            {
              IProject referencedProject = (IProject)i.next();
              IJavaProject referencedJavaProject = JavaCore.create(referencedProject);
              if (!referencedJavaProject.exists())
              {
                i.remove();
              }
            }

            if (projectLocation != null)
            {
              projectLocation = projectLocation.removeLastSegments(1).append(javaSource.segment(0));
            }

            if (genModel.hasXMLDependency())
            {
              style |= Generator.EMF_XML_PROJECT_STYLE;
            }

            if ((style & Generator.EMF_MODEL_PROJECT_STYLE) == 0 || genModel.hasPluginSupport())
            {
              style |= Generator.EMF_PLUGIN_PROJECT_STYLE;
            }

            Generator.createEMFProject
              (javaSource,
               projectLocation, 
               referencedProjects, 
               monitor, 
               style,
               genModel.getEffectiveModelPluginVariables());
          }
          return workspace.getRoot().getProject(path.segment(0)).exists();
        }
      }
      catch (Exception exception)
      { 
        //DMS should we let this exception out?
        CodeGenEcorePlugin.INSTANCE.log(exception);
      }
      return false;
    }
  }
}
