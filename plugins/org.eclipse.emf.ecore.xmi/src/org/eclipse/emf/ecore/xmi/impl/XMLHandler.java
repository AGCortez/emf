/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
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
 * $Id: XMLHandler.java,v 1.38 2005/09/13 14:07:16 elena Exp $
 */
package org.eclipse.emf.ecore.xmi.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.ClassNotFoundException;
import org.eclipse.emf.ecore.xmi.EcoreBuilder;
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
import org.eclipse.emf.ecore.xmi.IllegalValueException;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.eclipse.emf.ecore.xmi.UnresolvedReferenceException;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMIPlugin;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLOptions;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.util.DefaultEcoreBuilder;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;


/**
 * This class is a generic interface for loading XML files and
 * creating EObjects from them. Its subclasses include the SAXXMLHandler
 * class, which wraps this class in a SAX default handler.
 */
public abstract class XMLHandler
{
  protected static final String ERROR_TYPE = "error";
  protected static final String OBJECT_TYPE = "object";
  protected static final String UNKNOWN_FEATURE_TYPE = "unknownFeature";
  protected static final String DOCUMENT_ROOT_TYPE = "documentRoot";

  protected final static String TYPE_ATTRIB = XMLResource.XSI_NS + ":" + XMLResource.TYPE;
  protected final static String NIL_ATTRIB = XMLResource.XSI_NS + ":" + XMLResource.NIL;
  protected final static String SCHEMA_LOCATION_ATTRIB = XMLResource.XSI_NS + ":" + XMLResource.SCHEMA_LOCATION;
  protected final static String NO_NAMESPACE_SCHEMA_LOCATION_ATTRIB = XMLResource.XSI_NS + ":" + XMLResource.NO_NAMESPACE_SCHEMA_LOCATION;

  protected final static boolean DEBUG_DEMANDED_PACKAGES = false;
  
  protected static class MyStack extends ArrayList
  {
    public MyStack()
    {
    }

    public Object peek()
    {
      int size = size();
      return size == 0 ? null : get(size - 1);
    }

    public void push(Object o)
    {
      add(o);
    }

    public Object pop()
    {
      int size = size();
      return size == 0 ?  null : remove(size - 1);
    }
  }

  /**
   * For unresolved forward references, the line number where the incorrect id
   * appeared in an XML resource is needed, so the Value for the forward reference
   * and the line number where the forward reference occurred must be saved until
   * the end of the XML resource is encountered.
   */
  protected static class SingleReference
  {
    private EObject object;
    private EStructuralFeature feature;
    private Object value;
    private int position;
    private int lineNumber;
    private int columnNumber;

    public SingleReference(EObject object,
                    EStructuralFeature feature,
                    Object value,
                    int position,
                    int lineNumber,
                    int columnNumber)
    {
      this.object       = object;
      this.feature      = feature;
      this.value        = value;
      this.position     = position;
      this.lineNumber   = lineNumber;
      this.columnNumber = columnNumber;
    }

    public EObject getObject()
    {
      return object;
    }

    public EStructuralFeature getFeature()
    {
      return feature;
    }

    public Object getValue()
    {
      return value;
    }

    public int getPosition()
    {
      return position;
    }

    public int getLineNumber()
    {
      return lineNumber;
    }

    public int getColumnNumber()
    {
      return columnNumber;
    }
  }

  protected static class ManyReference implements XMLHelper.ManyReference
  {
    private EObject object;
    private EStructuralFeature feature;
    private Object[] values;
    private int[] positions;
    private int lineNumber;
    private int columnNumber;

    ManyReference(EObject object,
                  EStructuralFeature feature,
                  Object[] values,
                  int[] positions,
                  int lineNumber,
                  int columnNumber)
    {
      this.object       = object;
      this.feature      = feature;
      this.values       = values;
      this.positions    = positions;
      this.lineNumber   = lineNumber;
      this.columnNumber = columnNumber;
    }

    public EObject getObject()
    {
      return object;
    }

    public EStructuralFeature getFeature()
    {
      return feature;
    }

    public Object[] getValues()
    {
      return values;
    }

    public int[] getPositions()
    {
      return positions;
    }

    public int getLineNumber()
    {
      return lineNumber;
    }

    public int getColumnNumber()
    {
      return columnNumber;
    }
  }

  protected XMLResource xmlResource;
  protected XMLHelper helper;
  protected MyStack elements;
  protected MyStack objects;
  protected MyStack types;
  protected MyStack mixedTargets;
  protected Map prefixesToFactories;
  protected Map urisToLocations;
  protected Map externalURIToLocations;
  protected boolean processSchemaLocations;
  protected InternalEList extent;
  protected ResourceSet resourceSet;
  protected EPackage.Registry packageRegistry;
  protected URI resourceURI;
  protected boolean resolve;
  protected boolean oldStyleProxyURIs;
  protected boolean disableNotify;
  protected StringBuffer text;
  protected boolean isIDREF;
  protected boolean isSimpleFeature;
  protected List sameDocumentProxies;
  protected List forwardSingleReferences;
  protected List forwardManyReferences;
  protected Object[] identifiers;
  protected int[] positions;
  protected static final int ARRAY_SIZE = 64;
  protected static final int REFERENCE_THRESHOLD = 5;
  protected int capacity;
  protected Set notFeatures;
  protected String idAttribute;
  protected String hrefAttribute;
  protected XMLResource.XMLMap xmlMap;
  protected ExtendedMetaData extendedMetaData;
  protected EClass anyType;
  protected EClass anySimpleType;
  protected boolean recordUnknownFeature;
  protected boolean recordAnyTypeNSDecls;
  protected Map eObjectToExtensionMap;
  protected EStructuralFeature contextFeature;
  protected EPackage xmlSchemaTypePackage = XMLTypePackage.eINSTANCE;
  protected boolean deferIDREFResolution;
  protected boolean processAnyXML;
  protected EcoreBuilder ecoreBuilder;

  /**
   */
  public XMLHandler(XMLResource xmlResource, XMLHelper helper, Map options)
  {
    this.xmlResource = xmlResource;
    this.helper = helper;
    elements = new MyStack();
    objects  = new MyStack();
    mixedTargets = new MyStack();

    types    = new MyStack();
    prefixesToFactories = new HashMap();
    forwardSingleReferences = new LinkedList();
    forwardManyReferences   = new LinkedList();
    sameDocumentProxies = new LinkedList();
    identifiers = new Object[ARRAY_SIZE];
    positions   = new int[ARRAY_SIZE];
    capacity    = ARRAY_SIZE;
    resourceSet  = xmlResource.getResourceSet();
    packageRegistry = resourceSet == null ? EPackage.Registry.INSTANCE : resourceSet.getPackageRegistry();
    resourceURI  = xmlResource.getURI();
    extent       = (InternalEList) xmlResource.getContents();
    resolve      = resourceURI != null && resourceURI.isHierarchical() && !resourceURI.isRelative();

    eObjectToExtensionMap = xmlResource.getEObjectToExtensionMap();
    eObjectToExtensionMap.clear();
    
    helper.setOptions(options);

    if (Boolean.TRUE.equals(options.get(XMLResource.OPTION_DISABLE_NOTIFY)))
      disableNotify = true;

    notFeatures = new HashSet();
    notFeatures.add(TYPE_ATTRIB);
    notFeatures.add(SCHEMA_LOCATION_ATTRIB);
    notFeatures.add(NO_NAMESPACE_SCHEMA_LOCATION_ATTRIB);

    xmlMap = (XMLResource.XMLMap) options.get(XMLResource.OPTION_XML_MAP);
    helper.setXMLMap(xmlMap);
    if (xmlMap != null)
    {
      idAttribute = xmlMap.getIDAttributeName();
    }

    Object extendedMetaDataOption = options.get(XMLResource.OPTION_EXTENDED_META_DATA);
    setExtendedMetaDataOption(extendedMetaDataOption);

    recordUnknownFeature = Boolean.TRUE.equals(options.get(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE));  
    if (recordUnknownFeature && extendedMetaData == null)
    {
      setExtendedMetaDataOption(Boolean.TRUE);
    }
    
    XMLOptions xmlOptions = (XMLOptions)options.get(XMLResource.OPTION_XML_OPTIONS);
    if (xmlOptions != null)
    {
      processSchemaLocations = xmlOptions.isProcessSchemaLocations();
      externalURIToLocations = xmlOptions.getExternalSchemaLocations();

      if (processSchemaLocations || externalURIToLocations != null)
      {
        if (extendedMetaData == null)
        {
          setExtendedMetaDataOption(Boolean.TRUE);
        }
        ecoreBuilder = xmlOptions.getEcoreBuilder();
        if (ecoreBuilder == null)
        {
          ecoreBuilder = new DefaultEcoreBuilder(extendedMetaData);
        }
      }
      processAnyXML = xmlOptions.isProcessAnyXML();
      if (processAnyXML && extendedMetaData == null)
      {
        setExtendedMetaDataOption(Boolean.TRUE);
      }
    }

    if (extendedMetaData != null)
    {
      AnyType anyType = XMLTypeFactory.eINSTANCE.createAnyType();
      mixedTargets.push(anyType.getMixed());
      text = new StringBuffer();
    }
    
    anyType = (EClass)options.get(XMLResource.OPTION_ANY_TYPE);
    anySimpleType = (EClass)options.get(XMLResource.OPTION_ANY_SIMPLE_TYPE);

    if (anyType == null)
    {
      anyType = XMLTypePackage.eINSTANCE.getAnyType();
      anySimpleType = XMLTypePackage.eINSTANCE.getSimpleAnyType();
    }
    
    helper.setAnySimpleType(anySimpleType);
    
    eClassFeatureNamePairToEStructuralFeatureMap = (Map)options.get(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP);
    if (eClassFeatureNamePairToEStructuralFeatureMap == null)
    {
      eClassFeatureNamePairToEStructuralFeatureMap = new HashMap();
    }
    
    recordAnyTypeNSDecls = Boolean.TRUE.equals(options.get(XMLResource.OPTION_RECORD_ANY_TYPE_NAMESPACE_DECLARATIONS));
    
    hrefAttribute = XMLResource.HREF;
    
    if (Boolean.FALSE.equals(options.get(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE)))
    {
      hrefAttribute = null;
    }
    
    if (Boolean.TRUE.equals(options.get(XMLResource.OPTION_DEFER_IDREF_RESOLUTION)))
    {
      helper.setCheckForDuplicates(deferIDREFResolution = true);
    }
  }

  protected void setExtendedMetaDataOption(Object extendedMetaDataOption)
  {
    if (extendedMetaDataOption instanceof Boolean)
    {
      if (extendedMetaDataOption.equals(Boolean.TRUE))
      {
        extendedMetaData = 
          resourceSet == null ?
            ExtendedMetaData.INSTANCE :
            new BasicExtendedMetaData(resourceSet.getPackageRegistry());
        if (xmlResource != null)
        {
          xmlResource.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
        }
      }
      else
      {
        extendedMetaData = null;
      }
    }
    else
    {
      extendedMetaData = (ExtendedMetaData)extendedMetaDataOption;
    }

    helper.setExtendedMetaData(extendedMetaData);
  }

  /**
   * Process the XML attributes for the newly created object.
   */
  protected abstract void handleObjectAttribs(EObject obj);

  /**
   * Process the XML namespace declarations.
   */
  protected abstract void handleNamespaceAttribs();

  /**
   * Returns true if the xsi:nil attribute is in the list of attributes.
   */
  protected abstract boolean isNull();

  /**
   * Sets the current attributes and returns the old ones.
   */
  protected abstract Object setAttributes(Object attributes);

  /**
   * Sets the object that might be used for determining the line and
   * column number.
   */
  protected abstract void setLocator(Object locator);

  /**
   * Returns the xsi type attribute's value.
   */
  protected abstract String getXSIType();

  public void startDocument()
  {
  }

  /**
   * This method determines whether to make an object or not, then makes an
   * object based on the XML attributes and the metamodel.
   */
  public void startElement(String uri, String localName, String name)
  {
    helper.pushContext();
    if (text != null && mixedTargets.peek() != null)
    {
      handleMixedText();
    }

    elements.push(name);

    handleNamespaceAttribs();

    // Turning on namespace awareness is very expensive so this simulates the effect.
    //
    int index = name.indexOf(":");
    String prefix = "";
    localName = name;
    if (index != -1)
    {
      prefix    = name.substring(0, index);
      localName = name.substring(index + 1);
    }

    processElement(name, prefix, localName);
  }

  protected void processElement(String name, String prefix, String localName)
  {
    if (isError())
    {
      types.push(ERROR_TYPE);
    }
    else
    {
      if (objects.isEmpty())
      {
        createTopObject(prefix, localName);
      }
      else
      {
        handleFeature(prefix, localName);
      }
    }
  }

  protected void handleForwardReferences()
  {
    handleForwardReferences(false);
  }

  /**
   * Check if the values of the forward references have been set (they may
   * have been set due to a bi-directional reference being set).  If not,
   * set them.
   * If this is called during end document processing, errors should be diagnosed.
   * If it is called in the middle of a document, 
   * we need to clean up the forward reference lists to avoid reprocessing resolved references again later.
   */
  protected void handleForwardReferences(boolean isEndDocument)
  {
    // Handle the same document proxies, which may have problems resulting from the
    // other end of a bidirectional reference being handled as an IDREF rather than as a proxy.
    // When we are done with these, we know that funny proxies are now resolved as if they were handled as IDREFs.
    //
    for (Iterator i = sameDocumentProxies.iterator(); i.hasNext(); )
    {
      InternalEObject proxy = (InternalEObject)i.next();

      // Look through all the references...
      //
      LOOP:
      for (Iterator j = proxy.eClass().getEAllReferences().iterator(); j.hasNext(); )
      {
        // And find the one that holds this proxy.
        //
        EReference eReference = (EReference)j.next();
        EReference oppositeEReference = eReference.getEOpposite();
        if (oppositeEReference != null && proxy.eIsSet(eReference))
        {
          // Try to resolve the proxy locally.
          //
          EObject resolvedEObject = xmlResource.getEObject(proxy.eProxyURI().fragment());
          if (resolvedEObject != null)
          {
            // We won't need to process this again later.
            //
            if (!isEndDocument)
            {
              i.remove();
            }

            // Compute the holder of the proxy
            //
            EObject proxyHolder = (EObject)(eReference.isMany() ? ((List)proxy.eGet(eReference)).get(0) : proxy.eGet(eReference));

            // If the proxy holder can hold many values,
            // it may contain a duplicate that resulted when the other end was processed as an IDREF
            // and hence did both sides of the bidirectional relation.
            //
            if (oppositeEReference.isMany())
            {
              // So if the resolved object is also present...
              //
              InternalEList holderContents = (InternalEList)proxyHolder.eGet(oppositeEReference);
              List basicHolderContents = holderContents.basicList();
              int resolvedEObjectIndex = basicHolderContents.indexOf(resolvedEObject);
              if (resolvedEObjectIndex != -1)
              {
                // Move the resolved object to the right place, remove the proxy, and we're done.
                //
                int proxyIndex = basicHolderContents.indexOf(proxy);
                holderContents.move(proxyIndex, resolvedEObjectIndex);
                holderContents.remove(proxyIndex > resolvedEObjectIndex ? proxyIndex  - 1 : proxyIndex + 1);
                break LOOP;
              }
            }

            // If the resolved object doesn't contain a reference to the proxy holder as it should.
            //
            if (eReference.isMany() ?
                  !((InternalEList)resolvedEObject.eGet(eReference)).basicList().contains(proxyHolder) :
                  resolvedEObject.eGet(eReference) != proxyHolder)
            {
              // The proxy needs to be replaced in a way that updates both ends of the reference.
              //
              if (oppositeEReference.isMany())
              {
                InternalEList proxyHolderList = (InternalEList)proxyHolder.eGet(oppositeEReference);
                proxyHolderList.setUnique(proxyHolderList.indexOf(proxy), resolvedEObject);
              }
              else
              {
                proxyHolder.eSet(oppositeEReference, resolvedEObject);
              }
            }
          }

          break;
        }
      }
    }

    for (Iterator i = forwardSingleReferences.iterator(); i.hasNext(); )
    {
      SingleReference ref = (SingleReference) i.next();
      EObject obj = xmlResource.getEObject((String) ref.getValue());

      if (obj != null)
      {
        // We won't need to process this again later.
        if (!isEndDocument)
        {
          i.remove();
        }
        EStructuralFeature feature = ref.getFeature();
        setFeatureValue(ref.getObject(), feature, obj, ref.getPosition());
      }
      else if (isEndDocument)
      {
        error
          (new UnresolvedReferenceException
            ((String) ref.getValue(),
             getLocation(),
             ref.getLineNumber(),
             ref.getColumnNumber()));
      }
    }

    for (Iterator i = forwardManyReferences.iterator(); i.hasNext(); )
    {
      ManyReference ref = (ManyReference) i.next();
      Object[] values = ref.getValues();

      boolean failure = false;
      for (int j = 0, l = values.length; j < l; j++)
      {
        String id = (String) values[j];
        EObject obj = xmlResource.getEObject(id);
        values[j] = obj;

        if (obj == null)
        {
          failure = true;
          if (isEndDocument)
          {
            error
              (new UnresolvedReferenceException
                (id,
                 getLocation(),
                 ref.getLineNumber(),
                 ref.getColumnNumber()));
          }
        }
      }

      if (!failure)
      {
        if (!isEndDocument)
        {
          i.remove();
        }
        setFeatureValues(ref);
      }
      else if (isEndDocument)
      {
        // At least set the references that we were able to resolve, if any.
        //
        setFeatureValues(ref);
      }
    }
  }

  /**
   * Check if the values of the forward references have been set (they may
   * have been set due to a bi-directional reference being set).  If not,
   * set them.
   */
  public void endDocument()
  {
    helper.recordPrefixToURIMapping();
    handleForwardReferences(true);

    if (disableNotify) 
    {
      for (Iterator i = xmlResource.getAllContents(); i.hasNext(); )
      {
        EObject eObject = (EObject)i.next();
        eObject.eSetDeliver(true);
      }
    }

    if (extendedMetaData != null)
    {
      if (extent.size() == 1)
      {
        EObject root = (EObject)extent.get(0);
        recordNamespacesSchemaLocations(root);     
      }

      if (DEBUG_DEMANDED_PACKAGES)
      {
        // EATM temporary for debug purposes only.
        //
        Collection demandedPackages = EcoreUtil.copyAll(extendedMetaData.demandedPackages());
        for (Iterator i = demandedPackages.iterator(); i.hasNext();)
        {
          EPackage ePackage = (EPackage)i.next();
          ePackage.setName(ePackage.getNsURI());
        }
        extent.addAll(demandedPackages);
      }
    }
  }
  
  protected EMap recordNamespacesSchemaLocations(EObject root)
  {
    EClass eClass = root.eClass();
    EReference xmlnsPrefixMapFeature = extendedMetaData.getXMLNSPrefixMapFeature(eClass);
    EMap xmlnsPrefixMap = null;
    if (xmlnsPrefixMapFeature != null)
    {
      xmlnsPrefixMap = (EMap)root.eGet(xmlnsPrefixMapFeature);
      xmlnsPrefixMap.putAll(helper.getPrefixToNamespaceMap());
    }

    if (urisToLocations != null)
    {
      EReference xsiSchemaLocationMapFeature = extendedMetaData.getXSISchemaLocationMapFeature(eClass);
      if (xsiSchemaLocationMapFeature != null)
      {
        EMap xsiSchemaLocationMap = (EMap)root.eGet(xsiSchemaLocationMapFeature);
        for (Iterator i = urisToLocations.entrySet().iterator(); i.hasNext(); )
        {
          Map.Entry entry = (Map.Entry)i.next();
          xsiSchemaLocationMap.put(entry.getKey(), entry.getValue().toString());
        }
      }
    }
    return xmlnsPrefixMap;
  }

  /**
   * Create an object based on the prefix and type name.
   */
  protected EObject createObjectByType(String prefix, String name, boolean top)
  {
    if (top)
    {
      handleTopLocations(prefix, name);
    }

    EFactory eFactory = getFactoryForPrefix(prefix);
    if (eFactory == null && prefix.equals("") && helper.getURI(prefix) == null)
    {
      EPackage ePackage = handleMissingPackage(null);
      if (ePackage == null)
      {
        error
          (new PackageNotFoundException
             (null,
              getLocation(),
              getLineNumber(),
              getColumnNumber()));
      }
      else
      {
        eFactory = ePackage.getEFactoryInstance();
      }
    }

    if (extendedMetaData != null && eFactory != null)
    {
      EClass eClass = extendedMetaData.getDocumentRoot(eFactory.getEPackage());
      if (eClass != null)
      {
        // EATM Kind of hacky.
        String typeName = extendedMetaData.getName(eClass);
        EObject newObject = helper.createObject(eFactory, typeName);
        validateCreateObjectFromFactory(eFactory, typeName, newObject);
        if (top)
        {
          processTopObject(newObject);
          handleFeature(prefix, name);
        }
        return newObject;
      }
    }

    EObject newObject = createObjectFromFactory(eFactory, name);
    validateCreateObjectFromFactory(eFactory, name, newObject);
    if (top)
    {
      processTopObject(newObject);
      // check for simple feature
      if (extendedMetaData != null && newObject != null)
      {
        EStructuralFeature simpleFeature = extendedMetaData.getSimpleFeature(newObject.eClass());
        if (simpleFeature != null)
        {
          isSimpleFeature = true;
          isIDREF = simpleFeature instanceof EReference;
          objects.push(null);
          mixedTargets.push(null);
          types.push(simpleFeature);
          text = new StringBuffer();
        }
      }
    }
    return newObject;
  }

  protected void createTopObject(String prefix, String name)
  {
    createObjectByType(prefix, name, true);
  }

  /**
   * Add object to extent and call processObject.
   */
  protected void processTopObject(EObject object)
  {
    if (object != null)
    {
      extent.addUnique(object);

      if (extendedMetaData != null)
      {
        FeatureMap featureMap = (FeatureMap)mixedTargets.pop();
        EStructuralFeature target = extendedMetaData.getMixedFeature(object.eClass());
        if (target != null)
        {
          FeatureMap otherFeatureMap = (FeatureMap)object.eGet(target);
          for (Iterator i = featureMap.iterator(); i.hasNext(); )
          {
            FeatureMap.Entry entry = (FeatureMap.Entry)i.next();

            // Ignore a whitespace only text entry at the beginning.
            //
            if (entry.getEStructuralFeature() !=  XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text() ||
                  !"".equals(XMLTypeUtil.normalize(entry.getValue().toString(), true)))
            {
              otherFeatureMap.add(entry.getEStructuralFeature(), entry.getValue());
            }
          }
        }
        text = null;
      }
    }

    processObject(object);
  }

  /**
   * Pop the appropriate stacks and set features whose values are in
   * the content of XML elements.
   */
  public void endElement(String uri, String localName, String name)
  {   
    elements.pop();
    Object type = types.pop();
    if (type == OBJECT_TYPE)
    {
      if (text == null)
      {
        objects.pop();
        mixedTargets.pop();
      }
      else 
      {
        Object object = objects.pop();
        if (mixedTargets.peek() != null && 
              (((EObject)object).eContainer() != null || recordUnknownFeature && eObjectToExtensionMap.containsValue(object))) 
        {
          handleMixedText();
          mixedTargets.pop();
        }
        else
        {
          if (text.length() != 0)
          {
            handleProxy((InternalEObject)object, text.toString().trim());
          }
          mixedTargets.pop();
          text = null;
        }
      } 
    }
    else if (isIDREF)
    {
      objects.pop();
      mixedTargets.pop();
      if (text != null)
      {
        setValueFromId((EObject)objects.peek(), (EReference)type, text.toString());
        text = null;
      }
      isIDREF= false;
    }
    else if (isTextFeatureValue(type))
    {
      EObject eObject = (EObject)objects.pop();
      mixedTargets.pop();
      if (eObject == null)
      {
        eObject = (EObject)objects.peek();
      }
      setFeatureValue(eObject, (EStructuralFeature) type, text == null ? null : text.toString());
      text = null;
    }

    if (isSimpleFeature)
    {
      types.pop();
      objects.pop();
      mixedTargets.pop();
      isSimpleFeature = false;
    }
    helper.popContext();
  }

  protected boolean isTextFeatureValue(Object type)
  {
    return type != ERROR_TYPE;
  }

  public void startPrefixMapping(String prefix, String uri)
  {
    helper.addPrefix(prefix, uri);
  }

  public void endPrefixMapping(String prefix)
  {
  }

  public void characters(char [] ch, int start, int length)
  {
    if (text == null && mixedTargets.peek() != null)
    {
      text = new StringBuffer();
    }

    if (text != null)
    {
      text.append(ch, start, length);
    }
  }

  public void processingInstruction(String target, String data)
  {
    // do nothing
  }

  public void comment(char [] ch, int start, int length) // throws SAXException
  {
    if (mixedTargets.peek() != null)
    {
      if (text != null)
      {
        handleMixedText();
      }

      handleComment(new String(ch, start, length));
    }
  }

  public void startCDATA()
  {
    if (mixedTargets.peek() != null)
    {
      if (text != null)
      {
        handleMixedText();
      }
      text = new StringBuffer();
    }
  }

  public void endCDATA()
  {
    if (mixedTargets.peek() != null && text != null)
    {
      handleCDATA();
    }
  }
  
  public void startDTD(String name, String publicId, String systemId)
  {
    xmlResource.setDoctypeInfo(publicId, systemId);
  }

  protected void handleXMLNSAttribute(String attrib, String value)
  {
    // Handle namespaces
    int index = attrib.indexOf(":");
    String prefix = index == -1 ? "" : attrib.substring(index + 1);
    helper.addPrefix(prefix, value);
  }

  protected void handleXSISchemaLocation(String schemaLocations)
  {
    if (urisToLocations == null)
    {
      urisToLocations = new HashMap();
      xmlResource.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    }

    for (StringTokenizer stringTokenizer = new StringTokenizer(schemaLocations, " "); stringTokenizer.hasMoreTokens(); )
    {
      String key = stringTokenizer.nextToken();
      if (stringTokenizer.hasMoreTokens())
      {
        String value = stringTokenizer.nextToken();
        URI uri = URI.createURI(value);
        if (resolve && uri.isRelative() && uri.hasRelativePath())
        {
          uri = helper.resolve(uri, resourceURI);
        }
        urisToLocations.put(key, uri);
      }
    }
  }

  protected void handleXSINoNamespaceSchemaLocation(String noNamespaceSchemaLocation)
  {
    if (urisToLocations == null)
    {
      urisToLocations = new HashMap();
      xmlResource.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    }

    URI uri = URI.createURI(noNamespaceSchemaLocation);
    if (resolve && uri.isRelative() && uri.hasRelativePath())
    {
      uri = helper.resolve(uri, resourceURI);
    }
    urisToLocations.put(null, uri);
  }

  protected void handleTopLocations(String prefix, String name)
  {
    if (urisToLocations != null)
    {
      // If processSchemaLocations is specified, treat these as XML Schema locations
      if (processSchemaLocations)
      {
        try
        {
          ecoreBuilder.generate(urisToLocations);
        }
        catch (Exception exception)
        {
          XMIPlugin.INSTANCE.log(exception);
        }
      }
      // If externalSchemaLocations are specified, process these ones as well
      try
      {
        if (externalURIToLocations != null)
        {
          ecoreBuilder.generate(externalURIToLocations);
        }
      }
      catch (Exception exception)
      {
        XMIPlugin.INSTANCE.log(exception);
      }

      URI locationForNull = (URI)urisToLocations.get(null);
      if (locationForNull != null && helper.getNoNamespacePackage() == null)
      {
        helper.setNoNamespacePackage(getPackageForURI(locationForNull.toString()));
      }
    }
    else if (externalURIToLocations != null)
    {
      try
      {
        ecoreBuilder.generate(externalURIToLocations);
      }
      catch (Exception exception)
      {
        XMIPlugin.INSTANCE.log(exception);
      }
    }

    if (processAnyXML)
    {
      // Ensure that anything can be handled, even if it's not recognized.
      //
      String namespaceURI = helper.getURI(prefix);
      if (extendedMetaData.getPackage(namespaceURI) == null)
      {
        extendedMetaData.demandFeature(namespaceURI, name, true);
      }
    }
  }

  /**
   * The XML element represents a feature. There are two
   * cases to handle:
   *   1. The feature has a type that is a datatype.
   *   2. The feature has a type that is a class.
   */
  protected void handleFeature(String prefix, String name)
  {
    EObject peekObject = (EObject) objects.peek();

    // This happens when processing an element with simple content that has elements content even though it shouldn't.
    //
    if (peekObject == null)
    {
      types.push(ERROR_TYPE);
      error
        (new FeatureNotFoundException
          (name,
           null,
           getLocation(),
           getLineNumber(),
           getColumnNumber()));
      return;
    }

    EStructuralFeature feature = getFeature(peekObject, prefix, name, true);
    if (feature != null)
    {
      int kind = helper.getFeatureKind(feature);
      if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY)
      {
        objects.push(null);
        mixedTargets.push(null);
        types.push(feature);
        if (!isNull())
        {
          text = new StringBuffer();
        }
      }
      else if (extendedMetaData != null)
      {
        EReference eReference = (EReference)feature;
        boolean isContainment = eReference.isContainment();      
        if (!isContainment && !eReference.isResolveProxies() && extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE)
        {
          isIDREF = true;
          objects.push(null);
          mixedTargets.push(null);
          types.push(feature);
          text = new StringBuffer();
        }
        else
        {
          createObject(peekObject, feature);
          EObject childObject = (EObject) objects.peek();
          if (childObject != null)
          {
            if (isContainment)
            {
              EStructuralFeature simpleFeature = extendedMetaData.getSimpleFeature(childObject.eClass());
              if (simpleFeature != null)
              {
                isSimpleFeature = true;
                isIDREF = simpleFeature instanceof EReference;
                objects.push(null);
                mixedTargets.push(null);
                types.push(simpleFeature);
                text = new StringBuffer();
              }
            }
            else if (!childObject.eIsProxy())
            {
              text = new StringBuffer();
            }
          }
        }
      }
      else 
      {
        createObject(peekObject, feature);
      }
    }
    else
    {
      // Try to get a general-content feature.
      // Use a pattern that's not possible any other way.
      //
      if (xmlMap != null && (feature = getFeature(peekObject, null, "", true)) != null)
      {
        EFactory eFactory = getFactoryForPrefix(prefix);

        // This is for the case for a local unqualified element that has been bound.
        //
        if (eFactory == null)
        {
          eFactory = feature.getEContainingClass().getEPackage().getEFactoryInstance();
        }

        EObject newObject = createObjectFromFactory(eFactory, name);
        newObject = validateCreateObjectFromFactory(eFactory, name, newObject, feature);
        if (newObject != null)
        {
          setFeatureValue(peekObject, feature, newObject);
        }
        processObject(newObject);
      }
      else
      {
        // This handles the case of a substitution group.
        //
        if (xmlMap != null)
        {
          EFactory eFactory = getFactoryForPrefix(prefix);
          EObject newObject = createObjectFromFactory(eFactory, name);
          validateCreateObjectFromFactory(eFactory, name, newObject);
          if (newObject != null)
          {
            for (Iterator i = peekObject.eClass().getEAllReferences().iterator(); i.hasNext(); )
            {
              EReference eReference = (EReference)i.next();
              if (eReference.getEType().isInstance(newObject))
              {
                setFeatureValue(peekObject, eReference, newObject);
                processObject(newObject);
                return;
              }
            }
          }
        }
       
        handleUnknownFeature(prefix, name, true, peekObject, null);
      }
    }
  }

  protected int getLineNumber()
  {
    return -1;
  }

  protected int getColumnNumber()
  {
    return -1;
  }

  protected String getLocation()
  {
    return resourceURI == null ? "" : resourceURI.toString();
  }
  
  protected AnyType getExtension(EObject peekObject)
  {
    AnyType anyType = (AnyType)eObjectToExtensionMap.get(peekObject);
    if (anyType == null)
    {
      anyType = XMLTypeFactory.eINSTANCE.createAnyType();
      eObjectToExtensionMap.put(peekObject, anyType);
    }
    return anyType;
  }

  protected void handleUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value)
  {
    if (recordUnknownFeature)
    {
      recordUnknownFeature(prefix, name, isElement, peekObject, value);
    }
    else
    {
      reportUnknownFeature(prefix, name, isElement, peekObject, value);
    }
  }

  protected void recordUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value)
  {
    if (isElement)
    {
      AnyType anyType = getExtension(peekObject);
      objects.push(anyType);
      mixedTargets.push(anyType.getAny());
      types.push(UNKNOWN_FEATURE_TYPE);

      handleFeature(prefix, name);

      objects.remove(objects.size() - 2);
      mixedTargets.remove(mixedTargets.size() - 2);
      types.remove(types.size() - 2);
    }
    else
    {
      AnyType anyType = getExtension(peekObject);
      setAttribValue(anyType, prefix == null ? name : prefix + ":" + name, value);
    }
  }

  protected void reportUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value)
  {
    types.push(ERROR_TYPE);
    error
      (new FeatureNotFoundException
        (name,
         peekObject,
         getLocation(),
         getLineNumber(),
         getColumnNumber()));
  }
  
  public void error(XMIException e)
  {
    xmlResource.getErrors().add(e);
  }

  public void warning(XMIException e)
  {
    xmlResource.getWarnings().add(e);
  }

  public void fatalError(XMIException e)
  {
    xmlResource.getErrors().add(e);
  }

  /**
   * Create an object based on the given feature and attributes.
   */
  protected void createObject(EObject peekObject, EStructuralFeature feature)
  {
    if (isNull())
    {
      setFeatureValue(peekObject, feature, null);
      objects.push(null);
      mixedTargets.push(null);
      types.push(OBJECT_TYPE);
    }
    else
    {
      String xsiType = getXSIType();
      if (xsiType != null)
      {
        createObjectFromTypeName(peekObject, xsiType, feature);
      }
      else
      {
        createObjectFromFeatureType(peekObject, feature);
        // This check is redundant -- see handleFeature method (EL)
        /*if (extendedMetaData != null && !((EReference)feature).isContainment())
        {
          text = new StringBuffer();
        }*/
        if (xmlMap != null && !((EReference)feature).isContainment())
        {
          XMLResource.XMLInfo info = xmlMap.getInfo(feature);
          if (info != null && info.getXMLRepresentation() == XMLResource.XMLInfo.ELEMENT)
          {
            text = new StringBuffer();
          }
        }
      }
    }
  }

  /**
   * Create an object from the given qualified type name.
   */
  protected EObject createObjectFromTypeName(EObject peekObject, String typeQName, EStructuralFeature feature)
  {
    String typeName = null;
    String prefix = "";
    int index = typeQName.indexOf(":");
    if (index > 0)
    {
      prefix = typeQName.substring(0, index);
      typeName = typeQName.substring(index + 1);
    }
    else
    {
      typeName = typeQName;
    }

    contextFeature = feature;
    EFactory eFactory = getFactoryForPrefix(prefix);
    contextFeature = null;

    if (eFactory == null && prefix.equals("") && helper.getURI(prefix) == null)
    {
      contextFeature = feature;
      EPackage ePackage = handleMissingPackage(null);
      contextFeature = null;
      if (ePackage == null)
      {
        error
          (new PackageNotFoundException
             (null,
              getLocation(),
              getLineNumber(),
              getColumnNumber()));
      }
      else
      {
        eFactory = ePackage.getEFactoryInstance();
      }
    }

    EObject obj = createObjectFromFactory(eFactory, typeName);
    obj = validateCreateObjectFromFactory(eFactory, typeName, obj, feature);

    if (obj != null)
    {
      if (contextFeature == null)
      {
        setFeatureValue(peekObject, feature, obj);
      }
      else
      {
        contextFeature = null;
      }
    }

    processObject(obj);

    return obj;
  }

  /**
   * Create an object based on the type of the given feature.
   */
  protected EObject createObjectFromFeatureType(EObject peekObject, EStructuralFeature feature)
  {
    String typeName = null;
    EFactory factory = null;
    EClassifier eType = null;

    if (feature != null && (eType = feature.getEType()) != null)
    {
      if (extendedMetaData != null && 
            eType == EcorePackage.eINSTANCE.getEObject() &&
            extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE)
      {
        typeName = extendedMetaData.getName(anyType);
        factory = anyType.getEPackage().getEFactoryInstance();
      }
      else
      {
        EClass eClass = (EClass) eType;
        typeName = extendedMetaData == null ? eClass.getName() : extendedMetaData.getName(eClass);
        factory = eClass.getEPackage().getEFactoryInstance();
      }
    }

    EObject obj = createObjectFromFactory(factory, typeName);
    obj = validateCreateObjectFromFactory(factory, typeName, obj, feature);
    if (obj != null)
    {
      setFeatureValue(peekObject, feature, obj);
    }

    processObject(obj);
    return obj;
  }

  /**
   * Create an object given a content helper, a factory, and a type name,
   * and process the XML attributes.
   */
  protected EObject createObjectFromFactory(EFactory factory, String typeName)
  {
    EObject newObject = null;

    if (factory != null)
    {
      newObject = helper.createObject(factory, typeName);

      if (newObject != null)
      {
        if (disableNotify)
          newObject.eSetDeliver(false);

        handleObjectAttribs(newObject);
      }
/*
      else
      {
        error
          (new ClassNotFoundException
            (typeName,
             factory,
             getLocation(),
             getLineNumber(),
             getColumnNumber()));
      }
*/
    }

    return newObject;
  }

  protected void validateCreateObjectFromFactory(EFactory factory, String typeName, EObject newObject)
  {
    if (newObject == null)
    {
      error
        (new ClassNotFoundException
          (typeName,
           factory,
           getLocation(),
           getLineNumber(),
           getColumnNumber()));
    }
  }

  protected EObject validateCreateObjectFromFactory(EFactory factory, String typeName, EObject newObject, EStructuralFeature feature)
  {
    if (newObject != null)
    {
      if (extendedMetaData != null)
      {
        Collection demandedPackages = extendedMetaData.demandedPackages();
        if (!demandedPackages.isEmpty() && demandedPackages.contains(newObject.eClass().getEPackage()))
        {
          if (recordUnknownFeature)
          {
            EObject peekObject = (EObject)objects.peek();
            if (!(peekObject instanceof AnyType))
            {
              AnyType anyType = getExtension((EObject)objects.peek());
              EStructuralFeature entryFeature = 
                extendedMetaData.demandFeature(extendedMetaData.getNamespace(feature), extendedMetaData.getName(feature), true);
              anyType.getAny().add(entryFeature, newObject);
              contextFeature = entryFeature;
            }
            return newObject;
          }
          else
          {
            String namespace = extendedMetaData.getNamespace(feature);
            String name = extendedMetaData.getName(feature);
            EStructuralFeature wildcardFeature = 
              extendedMetaData.getElementWildcardAffiliation(((EObject)objects.peek()).eClass(), namespace, name);
            if (wildcardFeature != null)
            {
              switch (extendedMetaData.getProcessingKind(wildcardFeature))
              {
                case ExtendedMetaData.LAX_PROCESSING:
                case ExtendedMetaData.SKIP_PROCESSING:
                {
                  return newObject;
                }
              }
            }
          }

          newObject = null;
        }
      }
    }
    else if (feature != null && factory != null && extendedMetaData != null)
    {
      if (recordUnknownFeature || processAnyXML)
      {
        factory = 
          extendedMetaData.demandType
            (extendedMetaData.getNamespace(factory.getEPackage()), typeName).getEPackage().getEFactoryInstance();
        EObject result = createObjectFromFactory(factory, typeName);
        EObject peekObject = (EObject)objects.peek();
        if (!(peekObject instanceof AnyType))
        {
          AnyType anyType = getExtension((EObject)objects.peek());
          EStructuralFeature entryFeature = 
            extendedMetaData.demandFeature(extendedMetaData.getNamespace(feature), extendedMetaData.getName(feature), true);
          anyType.getAny().add(entryFeature, result);
          contextFeature = entryFeature;
        }
        return result;
      }
      else
      {
        String namespace = extendedMetaData.getNamespace(feature);
        String name = extendedMetaData.getName(feature);
        EStructuralFeature wildcardFeature = 
          extendedMetaData.getElementWildcardAffiliation(((EObject)objects.peek()).eClass(), namespace, name);
        if (wildcardFeature != null)
        {
          switch (extendedMetaData.getProcessingKind(wildcardFeature))
          {
            case ExtendedMetaData.LAX_PROCESSING:
            case ExtendedMetaData.SKIP_PROCESSING:
            {
              // EATM Demand create metadata; needs to depend on processing mode...
              factory = 
                extendedMetaData.demandType
                  (extendedMetaData.getNamespace(factory.getEPackage()), typeName).getEPackage().getEFactoryInstance();
              return createObjectFromFactory(factory, typeName);
            }
          }
        }
      }
    }

    validateCreateObjectFromFactory(factory, typeName, newObject);
    return newObject;
  }

  /**
   * Add object to appropriate stacks.
   */
  protected void processObject(EObject object)
  {
    if (recordAnyTypeNSDecls && object instanceof AnyType)
    {
      FeatureMap featureMap = ((AnyType)object).getAnyAttribute();
      for (Iterator i = helper.getAnyContentPrefixToURIMapping().entrySet().iterator(); i.hasNext();)
      {
        Map.Entry entry = (Map.Entry)i.next();
        Object uri = entry.getValue();
        featureMap.add(extendedMetaData.demandFeature(ExtendedMetaData.XMLNS_URI, (String)entry.getKey(), false), uri == null ? "" : uri);
      }
    }

    if (object != null)
    {
      objects.push(object);
      types.push(OBJECT_TYPE);

      if (extendedMetaData != null)
      {
        EStructuralFeature mixedFeature = extendedMetaData.getMixedFeature(object.eClass());
        if (mixedFeature != null)
        {
          mixedTargets.push(object.eGet(mixedFeature));
        }
        else
        {
          mixedTargets.push(null);
        }
      }
      else
      {
        mixedTargets.push(null);
      }
    }
    else
    {
      types.push(ERROR_TYPE);
    }
  }

  protected EFactory getFactoryForPrefix(String prefix)
  {
    EFactory factory = (EFactory) prefixesToFactories.get(prefix);
    if (factory == null)
    {
      String uriString = helper.getURI(prefix);
      EPackage ePackage = getPackageForURI(uriString);

      if (ePackage == null && uriString == null && prefix.equals(""))
      {
        ePackage = helper.getNoNamespacePackage();
      }


      if (ePackage != null)
      {
        factory = ePackage.getEFactoryInstance();
        prefixesToFactories.put(prefix, factory);
      }
    }

    return factory;
  }

  /**
   * Attempt to get the namespace for the given prefix, then return
   * ERegister.getPackage() or null.
   */
  protected EPackage getPackageForURI(String uriString)
  {
    if (uriString == null)
    {
      return null;
    }

    EPackage ePackage = 
      extendedMetaData == null ?
        packageRegistry.getEPackage(uriString) :
        extendedMetaData.getPackage(uriString);

    if (ePackage != null && ePackage.eIsProxy())
    {
      ePackage = null;
    }

    if (ePackage == null)
    {
      URI uri = URI.createURI(uriString);
      if (uri.scheme() == null)
      {
        // This only works for old globally registered things.
        for (Iterator entries = packageRegistry.entrySet().iterator(); entries.hasNext(); )
        {
          Map.Entry entry = (Map.Entry)entries.next();
          String nsURI = (String)entry.getKey();
          if (nsURI != null &&
                nsURI.endsWith(uriString) &&
                nsURI.charAt(nsURI.length() - uriString.length() - 1) == '/')
          {
            oldStyleProxyURIs = true;
            return (EPackage)entry.getValue();
          }
        }
      }

      if (urisToLocations != null)
      {
        URI locationURI = (URI)urisToLocations.get(uriString);
        if (locationURI != null)
        {
          uri = locationURI;
        }
      }

      String fragment = uri.fragment();
      Resource resource = null;

      if ("java".equalsIgnoreCase(uri.scheme()) && uri.authority() != null)
      {
        try
        {
          String className = uri.authority();
          Class javaClass = Class.forName(className, true, Thread.currentThread().getContextClassLoader());
          Field field = javaClass.getField("eINSTANCE");
          resource = ((EPackage)field.get(null)).eResource();
        }
        catch (Exception exception)
        {
        }
      }

      if (resource == null && resourceSet != null)
      {
        URI trimmedURI = uri.trimFragment();
        resource = resourceSet.getResource(trimmedURI, false);
        if (resource != null)
        {
          if (!resource.isLoaded())
          {
            try
            {
              resource.load(resourceSet.getLoadOptions());
            }
            catch (IOException exception)
            {
            }
          }
        }
        else if (!XMLResource.XML_SCHEMA_URI.equals(uriString))
        {
          try
          {
            InputStream inputStream = getURIConverter().createInputStream(trimmedURI);
            resource = resourceSet.createResource(trimmedURI);
            if (resource == null)
            {
              inputStream.close();
            }
            else
            {
              resource.load(inputStream, resourceSet.getLoadOptions());
            }
          }
          catch (IOException exception)
          {
          }
        }
      }

      if (resource != null)
      {
        Object content = null;
        if (fragment != null)
        {
          content = resource.getEObject(fragment);
        }
        else
        {
          List contents = resource.getContents();
          if (!contents.isEmpty())
          {
            content = contents.get(0);
          }
        }

        if (content instanceof EPackage)
        {
          ePackage = (EPackage)content;
          if (extendedMetaData != null)
          {
            extendedMetaData.putPackage(extendedMetaData.getNamespace(ePackage), ePackage);
          }
          else
          {
            resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
          }
        }
      }
    }

    if (ePackage == null)
    {
      ePackage = handleMissingPackage(uriString);
    }

    if (ePackage == null)
    {
      error
        (new PackageNotFoundException
           (uriString,
            getLocation(),
            getLineNumber(),
            getColumnNumber()));
    }

    return ePackage;
  }

  protected EPackage handleMissingPackage(String uriString)
  {
    if (XMLResource.XML_SCHEMA_URI.equals(uriString))
    {
      return xmlSchemaTypePackage;
    }
    else if (extendedMetaData != null)
    {
      if (recordUnknownFeature)
      {
        return extendedMetaData.demandPackage(uriString);
      }
      else if (processAnyXML && objects.isEmpty())
      {
        return extendedMetaData.demandPackage(uriString);
      }
      else if (contextFeature != null)
      {
        String namespace = extendedMetaData.getNamespace(contextFeature);
        String name = extendedMetaData.getName(contextFeature);
        EStructuralFeature wildcardFeature = 
          extendedMetaData.getElementWildcardAffiliation(((EObject)objects.peek()).eClass(), namespace, name);
        if (wildcardFeature != null)
        {
          switch (extendedMetaData.getProcessingKind(wildcardFeature))
          {
            case ExtendedMetaData.LAX_PROCESSING:
            case ExtendedMetaData.SKIP_PROCESSING:
            {
              return extendedMetaData.demandPackage(uriString);
            }
          }
        }
      }
    }

    return null;
  }

  protected URIConverter getURIConverter()
  {
    return resourceSet.getURIConverter();
  }

  protected void setFeatureValue(EObject object, EStructuralFeature feature, Object value)
  {
    setFeatureValue(object, feature, value, -1);
  }

  /**
   * Set the given feature of the given object to the given value.
   */
  protected void setFeatureValue(EObject object, EStructuralFeature feature, Object value, int position)
  {
    try
    {
      helper.setValue(object, feature, value, position);
    }
    catch (RuntimeException e)
    {
      error
        (new IllegalValueException
           (object,
            feature,
            value,
            e,
            getLocation(),
            getLineNumber(),
            getColumnNumber()));
    }
  }

  /**
   * Set the values for the given multi-valued forward reference.
   */
  protected void setFeatureValues(ManyReference reference)
  {
    List xmiExceptions = helper.setManyReference(reference, getLocation());

    if (xmiExceptions != null)
      for (Iterator i = xmiExceptions.iterator(); i.hasNext(); )
      {
        XMIException exception = (XMIException) i.next();
        error(exception);
      }
  }

  /**
   * Create a feature with the given name for the given object with the
   * given values.
   */
  protected void setAttribValue(EObject object, String name, String value)
  {
    int index = name.indexOf(":");

    // We use null here instead of "" because an attribute without a prefix is considered to have the null target namespace...
    String prefix = null;
    String localName = name;
    if (index != -1)
    {
      prefix    = name.substring(0, index);
      localName = name.substring(index + 1);
    }

    EStructuralFeature feature = getFeature(object, prefix, localName, false);
    if (feature == null)
    {
      handleUnknownFeature(prefix, localName, false, object, value);
    }
    else
    {
      int kind = helper.getFeatureKind(feature);

      if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY)
      {
        setFeatureValue(object, feature, value, -2);
      }
      else
      {
        setValueFromId(object, (EReference)feature, value);
      }
    }
  }

  /**
   * Create a ValueLine object and put it in the list
   * of references to resolve at the end of the document.
   */
  protected void setValueFromId(EObject object, EReference eReference, String ids)
  {
    StringTokenizer st = new StringTokenizer(ids);

    boolean isFirstID = true;
    boolean mustAdd = deferIDREFResolution;
    boolean mustAddOrNotOppositeIsMany = false;

    int size = 0;
    String qName = null;
    int position = 0;
    while (st.hasMoreTokens())
    {
      String id = st.nextToken();
      int index = id.indexOf("#");
      if (index != -1)
      {
        if (index == 0)
        {
          id = id.substring(1);
        }
        else
        {
          Object oldAttributes = setAttributes(null);
          // Create a proxy in the correct way and pop it.
          //
          InternalEObject proxy =
            (InternalEObject)
              (qName == null ?
                 createObjectFromFeatureType(object, eReference) :
                 createObjectFromTypeName(object, qName, eReference));
          setAttributes(oldAttributes);
          handleProxy(proxy, id);
          objects.pop();
          types.pop();
          mixedTargets.pop();

          qName = null;
          ++position;
          continue;
        }
      }
      else if (id.indexOf(":") != -1)
      {
        qName = id;
        continue;
      }

      if (!deferIDREFResolution)
      {
        if (isFirstID)
        {
          EReference eOpposite = eReference.getEOpposite();
          mustAdd = eOpposite == null || eOpposite.isTransient() || eReference.isMany();
          mustAddOrNotOppositeIsMany = mustAdd || !eOpposite.isMany();
          isFirstID = false;
        }
  
        if (mustAddOrNotOppositeIsMany)
        {
          EObject resolvedEObject = xmlResource.getEObject(id);
          if (resolvedEObject != null)
          {
            setFeatureValue(object, eReference, resolvedEObject);
            qName = null;
            ++position;
            continue;
          }
        }
      } 

      if (mustAdd)
      {
        if (size == capacity)
          growArrays();

        identifiers[size] = id;
        positions[size]   = position;
        ++size;
      }
      qName = null;
      ++position;
    }

    if (position == 0)
    {
      setFeatureValue(object, eReference, null, -2);
    }
    else if (size <= REFERENCE_THRESHOLD)
    {
      for (int i = 0; i < size; i++)
      {
        SingleReference ref = new SingleReference
                                   (object,
                                    eReference,
                                    identifiers[i],
                                    positions[i],
                                    getLineNumber(),
                                    getColumnNumber());
        forwardSingleReferences.add(ref);
      }
    }
    else
    {
      Object[] values = new Object[size];
      int[] currentPositions = new int[size];
      System.arraycopy(identifiers, 0, values, 0, size);
      System.arraycopy(positions, 0, currentPositions, 0, size);

      ManyReference ref = new ManyReference
                                 (object,
                                  eReference,
                                  values,
                                  currentPositions,
                                  getLineNumber(),
                                  getColumnNumber());
      forwardManyReferences.add(ref);
    }
  }

  protected void handleProxy(InternalEObject proxy, String uriLiteral)
  {
    URI proxyURI;
    if (oldStyleProxyURIs)
    {
      proxy.eSetProxyURI(proxyURI = URI.createURI(uriLiteral.startsWith("/") ? uriLiteral : "/" + uriLiteral));
    }
    else
    {
      URI uri = URI.createURI(uriLiteral);
      if (resolve && 
            uri.isRelative() && 
            uri.hasRelativePath() && 
            (extendedMetaData == null ?
              !packageRegistry.containsKey(uri.trimFragment().toString()) :
              extendedMetaData.getPackage(uri.trimFragment().toString()) == null))
      {
        uri = helper.resolve(uri, resourceURI);
      }
      proxy.eSetProxyURI(proxyURI = uri);
    }

    // Test for a same document reference that would usually be handled as an IDREF.
    //
    if (proxyURI.trimFragment().equals(resourceURI))
    {
      sameDocumentProxies.add(proxy);
    }
  }

  protected void growArrays() {
    int oldCapacity = capacity;
    capacity = capacity * 2;
    Object[] newIdentifiers = new Object[capacity];
    int[] newPositions = new int[capacity];
    System.arraycopy(identifiers, 0, newIdentifiers, 0, oldCapacity);
    System.arraycopy(positions, 0, newPositions, 0, oldCapacity);
    identifiers = newIdentifiers;
    positions = newPositions;
  }

  /**
   * Returns true if there was an error in the last XML element; false otherwise.
   */
  protected boolean isError()
  {
    return types.peek() == ERROR_TYPE;
  }

  static class EClassFeatureNamePair
  {
    public EClass eClass;
    public String featureName;
    public String namespaceURI;
    public boolean isElement;

    public boolean equals(Object that)
    {
      EClassFeatureNamePair typedThat = (EClassFeatureNamePair)that;
      return  
        typedThat.eClass == eClass && 
        typedThat.isElement == isElement &&
        typedThat.featureName.equals(featureName) &&
        (typedThat.namespaceURI != null ? typedThat.namespaceURI.equals(namespaceURI): namespaceURI == null);         
    }

    public int hashCode()
    {
      return eClass.hashCode() ^ featureName.hashCode() ^ (namespaceURI == null ? 0 : namespaceURI.hashCode()) + (isElement ? 0 : 1);
    }
  }

  Map eClassFeatureNamePairToEStructuralFeatureMap = null;
  EClassFeatureNamePair eClassFeatureNamePair = new  EClassFeatureNamePair();

  /**
   * @deprecated
   */
  protected EStructuralFeature getFeature(EObject object, String prefix, String name)
  {
    EClass eClass = object.eClass();
    String namespace = helper.getURI(prefix);
    EStructuralFeature result = helper.getFeature(eClass, namespace, name, true);
    if (result == null)
    {
      helper.getFeature(eClass, namespace, name, false);
    }
    return result;
  }

  /**
   * Get the EStructuralFeature from the metaObject for the given object
   * and feature name.
   */
  protected EStructuralFeature getFeature(EObject object, String prefix, String name, boolean isElement)
  {
    String namespace = helper.getURI(prefix);
    EClass eClass = object.eClass();
    eClassFeatureNamePair.eClass = eClass;
    eClassFeatureNamePair.featureName = name;
    eClassFeatureNamePair.namespaceURI = namespace;
    eClassFeatureNamePair.isElement = isElement;
    EStructuralFeature result = (EStructuralFeature)eClassFeatureNamePairToEStructuralFeatureMap.get(eClassFeatureNamePair);
    if (result == null)
    {
      result = helper.getFeature(eClass, namespace, name, isElement);

      if (result == null)
      {
        if (extendedMetaData != null)
        {
          EStructuralFeature wildcardFeature = 
            isElement ? 
              extendedMetaData.getElementWildcardAffiliation(eClass, namespace, name) :
              extendedMetaData.getAttributeWildcardAffiliation(eClass, namespace, name);
          if (wildcardFeature != null)
          {
            switch (extendedMetaData.getProcessingKind(wildcardFeature))
            {
              case ExtendedMetaData.LAX_PROCESSING:
              case ExtendedMetaData.SKIP_PROCESSING:
              {
                // EATM Demand create metadata.
                result = extendedMetaData.demandFeature(namespace, name, isElement);
                break;
              }
            }
          }
        }
        else
        {
          // EATM Call the deprecated method which does the same thing 
          // but might have an override in older code.
          result = getFeature(object, prefix, name);
        }
      }

      EClassFeatureNamePair entry = new EClassFeatureNamePair();
      entry.eClass = eClass;
      entry.featureName = name;
      entry.namespaceURI = namespace;
      entry.isElement = isElement;
      eClassFeatureNamePairToEStructuralFeatureMap.put(entry, result);
    }

    return result;
  }

  /**
   * Searches the array of bytes to determine the XML
   * encoding.
   */
  public static String getXMLEncoding(byte[] bytes)
  {
    String javaEncoding = null;

    if (bytes.length >= 4)
    {
      if (((bytes[0] == -2) && (bytes[1] == -1))  ||
          ((bytes[0] == 0) && (bytes[1] == 60)))
        javaEncoding = "UnicodeBig";
      else if (((bytes[0] == -1) && (bytes[1] == -2)) ||
                ((bytes[0] == 60) && (bytes[1] == 0)))
        javaEncoding = "UnicodeLittle";
      else if ((bytes[0] == -17) && (bytes[1] == -69) && (bytes[2] == -65))
        javaEncoding = "UTF8";
    }

    String header = null;

    try
    {
      if (javaEncoding != null)
        header = new String(bytes, 0, bytes.length, javaEncoding);
      else
        header = new String(bytes, 0, bytes.length);
    }
    catch (UnsupportedEncodingException e)
    {
      return null;
    }

    if (!header.startsWith("<?xml"))
      return "UTF-8";

    int endOfXMLPI = header.indexOf("?>");
    int encodingIndex = header.indexOf("encoding", 6);

    if ((encodingIndex == -1) || (encodingIndex > endOfXMLPI))
      return "UTF-8";

    int firstQuoteIndex = header.indexOf("\"", encodingIndex);
    int lastQuoteIndex;

    if ((firstQuoteIndex == -1) || (firstQuoteIndex > endOfXMLPI))
    {
      firstQuoteIndex = header.indexOf("'", encodingIndex);
      lastQuoteIndex = header.indexOf("'", firstQuoteIndex + 1);
    }
    else
      lastQuoteIndex = header.indexOf("\"", firstQuoteIndex + 1);

    return header.substring(firstQuoteIndex + 1, lastQuoteIndex);
  }

  protected void handleComment(String comment)
  {
    FeatureMap featureMap = (FeatureMap)mixedTargets.peek();
    featureMap.add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment(), comment);
    text = null;
  }
  protected void handleMixedText()
  {
    FeatureMap featureMap = (FeatureMap)mixedTargets.peek();
    featureMap.add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text(), text.toString());
    text = null;
  }

  protected void handleCDATA()
  {
    FeatureMap featureMap = (FeatureMap)mixedTargets.peek();
    featureMap.add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA(), text.toString());
    text = null;
  }
  
  protected EcoreBuilder createEcoreBuilder(Map options, ExtendedMetaData extendedMetaData)
  {
    return new DefaultEcoreBuilder(extendedMetaData);
  }
}
