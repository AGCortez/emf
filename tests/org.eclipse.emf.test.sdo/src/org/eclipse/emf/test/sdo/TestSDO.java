package org.eclipse.emf.test.sdo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.sdo.EDataGraph;
import org.eclipse.emf.ecore.sdo.EDataObject;
import org.eclipse.emf.ecore.sdo.SDOFactory;
import org.eclipse.emf.ecore.sdo.impl.DynamicEDataObjectImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.example.simple.SimpleFactory;

import commonj.sdo.DataObject;

public class TestSDO extends TestCase
{
  private static final boolean SYSOUT = false;
  
  private ResourceSet resourceSet;
  private EPackage ePackage;
  private EFactory eFactory;
  private EDataGraph eDataGraph;

  public TestSDO(String name)
  {
    super(name);
  }
  
  public static Test suite()
  {
    TestSuite ts = new TestSuite("TestSDO");
    ts.addTest(new TestSDO("testStaticModel"));
    ts.addTest(new TestSDO("testDynamicModel"));
    return ts;
  }
  
  protected void setUp() throws Exception
  {
    EcorePackage.eINSTANCE.getEFactoryInstance();

    eDataGraph = SDOFactory.eINSTANCE.createEDataGraph();
    resourceSet = eDataGraph.getResourceSet();
    Resource model = resourceSet.getResource(URI.createFileURI(EMFTestSDOPlugin.getPluginDirectory() + "/models/model/com.example.simple.ecore"), true);
    if (SYSOUT) model.save(System.out, null);

    ePackage = (EPackage)model.getContents().get(0);
    ePackage.setEFactoryInstance
      (new EFactoryImpl()
       {
         public EObject basicCreate(EClass eClass) 
         {
           return new DynamicEDataObjectImpl(eClass);
         }
       });
    eFactory = ePackage.getEFactoryInstance();
  }
  
  public void testStaticModel() throws Exception
  {
    modelTest(resourceSet, (DataObject)SimpleFactory.eINSTANCE.createQuote());
  }

  public void testDynamicModel() throws Exception
  {
    modelTest(resourceSet, (DataObject)eFactory.create((EClass)ePackage.getEClassifier("Quote")));
  }
  
  protected void tearDown() throws Exception
  {
    EDataObject root = (EDataObject)eFactory.create((EClass)ePackage.getEClassifier("Quote")); 
    EDataObject child = (EDataObject)eFactory.create((EClass)ePackage.getEClassifier("Quote"));
    DataObject grandChild = child.createDataObject("quotes");
    root.getList("quotes").add(child);
    eDataGraph.setERootObject(root);
    if (SYSOUT) eDataGraph.getDataGraphResource().save(System.out, null);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    objectOutputStream.writeObject(eDataGraph);
    objectOutputStream.close();
    InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    EDataGraph otherEDataGraph = (EDataGraph)objectInputStream.readObject();
    if (SYSOUT) otherEDataGraph.getDataGraphResource().save(System.out, null);
  }

  protected void modelTest(ResourceSet resourceSet, DataObject quote) throws Exception
  {
    quote.setString("symbol", "fbnt");
    quote.setString("companyName", "FlyByNightTechnology");
    quote.setBigDecimal("price", new BigDecimal("1000.0"));
    quote.setBigDecimal("open1", new BigDecimal("1000.0"));
    quote.setBigDecimal("high", new BigDecimal("1000.0"));
    quote.setBigDecimal("low", new BigDecimal("1000.0"));
    quote.setDouble("volume", 1000);
    quote.setDouble("change1", 1000);
    
    Resource quoteResource = resourceSet.createResource(URI.createURI("quote.xml"));
    quoteResource.getContents().add(quote);
    
    Map options = new HashMap();
    options.put(XMLResource.OPTION_LINE_WIDTH, new Integer(10));
    if (SYSOUT) quoteResource.save(System.out, options);

    assertEquals("fbnt", quote.getString("symbol"));
  }
}
