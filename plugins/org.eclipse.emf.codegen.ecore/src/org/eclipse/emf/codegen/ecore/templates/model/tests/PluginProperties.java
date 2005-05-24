package org.eclipse.emf.codegen.ecore.templates.model.tests;

import org.eclipse.emf.codegen.ecore.genmodel.*;

public class PluginProperties
{
  protected static String nl;
  public static synchronized PluginProperties create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginProperties result = new PluginProperties();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!--";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "/**" + NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " */" + NL + "-->" + NL + "# ====================================================================" + NL + "# To code developer:" + NL + "#   Do NOT change the properties between this line and the" + NL + "#   \"%%% END OF TRANSLATED PROPERTIES %%%\" line." + NL + "#   Make a new property name, append to the end of the file and change" + NL + "#   the code to use the new property." + NL + "# ====================================================================" + NL + "" + NL + "# ====================================================================" + NL + "# %%% END OF TRANSLATED PROPERTIES %%%" + NL + "# ====================================================================" + NL + "" + NL + "pluginName = ";
  protected final String TEXT_6 = " Tests" + NL + "providerName = www.example.org" + NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
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
 */

    GenModel genModel = (GenModel)argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
