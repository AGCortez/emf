/**
 * <copyright>
 * </copyright>
 *
 * $Id: CustomerValidator.java,v 1.1 2004/11/04 05:52:46 marcelop Exp $
 */
package org.eclipse.emf.test.models.customer.util;

import java.math.BigInteger;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import org.eclipse.emf.test.models.customer.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.test.models.customer.CustomerPackage
 * @generated
 */
public class CustomerValidator extends EObjectValidator
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final CustomerValidator INSTANCE = new CustomerValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.test.models.customer";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * The cached base package validator.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMLTypeValidator xmlTypeValidator;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerValidator()
  {
    xmlTypeValidator = XMLTypeValidator.INSTANCE;
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EPackage getEPackage()
  {
    return CustomerPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresonding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context)
  {
    switch (classifierID)
    {
      case CustomerPackage.ADDRESS_TYPE:
        return validateAddressType((AddressType)value, diagnostics, context);
      case CustomerPackage.CANADA_ADDR:
        return validateCanadaAddr((CanadaAddr)value, diagnostics, context);
      case CustomerPackage.CREDIT_INFO:
        return validateCreditInfo((CreditInfo)value, diagnostics, context);
      case CustomerPackage.CUSTOMER_STYPE:
        return validateCustomersType((CustomersType)value, diagnostics, context);
      case CustomerPackage.CUSTOMER_TYPE:
        return validateCustomerType((CustomerType)value, diagnostics, context);
      case CustomerPackage.DOCUMENT_ROOT:
        return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
      case CustomerPackage.US_ADDR:
        return validateUSAddr((USAddr)value, diagnostics, context);
      case CustomerPackage.US_STATE:
        return validateUSState((Object)value, diagnostics, context);
      case CustomerPackage.US_STATE_OBJECT:
        return validateUSStateObject((USState)value, diagnostics, context);
      case CustomerPackage.ZIP_CODES:
        return validateZipCodes((BigInteger)value, diagnostics, context);
      case CustomerPackage.ZIP_UNION:
        return validateZipUnion(value, diagnostics, context);
      default: 
        return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAddressType(AddressType addressType, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(addressType, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCanadaAddr(CanadaAddr canadaAddr, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(canadaAddr, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCreditInfo(CreditInfo creditInfo, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(creditInfo, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCustomersType(CustomersType customersType, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(customersType, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCustomerType(CustomerType customerType, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(customerType, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateUSAddr(USAddr usAddr, DiagnosticChain diagnostics, Map context)
  {
    return validate_EveryDefaultConstraint(usAddr, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateUSState(Object usState, DiagnosticChain diagnostics, Map context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateUSStateObject(USState usStateObject, DiagnosticChain diagnostics, Map context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateZipCodes(BigInteger zipCodes, DiagnosticChain diagnostics, Map context)
  {
    boolean result = validateZipCodes_Min(zipCodes, diagnostics, context);
    if (result || diagnostics != null) result &= validateZipCodes_Max(zipCodes, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @see #validateZipCodes_Min
   */
  public static final BigInteger ZIP_CODES__MIN__VALUE = new BigInteger("10000");

  /**
   * Validates the Min constraint of '<em>Zip Codes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateZipCodes_Min(BigInteger zipCodes, DiagnosticChain diagnostics, Map context)
  {
    boolean result = zipCodes.compareTo(ZIP_CODES__MIN__VALUE) >= 0;
    if (!result && diagnostics != null) 
      reportMinViolation(CustomerPackage.eINSTANCE.getZipCodes(), zipCodes, ZIP_CODES__MIN__VALUE, true, diagnostics, context);
    return result; 
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @see #validateZipCodes_Max
   */
  public static final BigInteger ZIP_CODES__MAX__VALUE = new BigInteger("99999");

  /**
   * Validates the Max constraint of '<em>Zip Codes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateZipCodes_Max(BigInteger zipCodes, DiagnosticChain diagnostics, Map context)
  {
    boolean result = zipCodes.compareTo(ZIP_CODES__MAX__VALUE) <= 0;
    if (!result && diagnostics != null) 
      reportMaxViolation(CustomerPackage.eINSTANCE.getZipCodes(), zipCodes, ZIP_CODES__MAX__VALUE, true, diagnostics, context);
    return result; 
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateZipUnion(Object zipUnion, DiagnosticChain diagnostics, Map context)
  {
    boolean result = validateZipUnion_MemberTypes(zipUnion, diagnostics, context);
    return result;
  }

  /**
   * Validates the MemberTypes constraint of '<em>Zip Union</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateZipUnion_MemberTypes(Object zipUnion, DiagnosticChain diagnostics, Map context)
  {
    boolean result = true;
    if (CustomerPackage.eINSTANCE.getUSState().isInstance(zipUnion))
    {
      result &= validateUSState((USState)zipUnion, diagnostics, context);
    }
    else if (CustomerPackage.eINSTANCE.getZipCodes().isInstance(zipUnion))
    {
      result &= validateZipCodes((BigInteger)zipUnion, diagnostics, context);
    }
    return result;
  }

} //CustomerValidator
