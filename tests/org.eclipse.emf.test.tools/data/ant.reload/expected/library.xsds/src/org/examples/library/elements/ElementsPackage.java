/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.examples.library.elements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.examples.library.hr.HrPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.examples.library.elements.ElementsFactory
 * @generated
 */
public interface ElementsPackage extends EPackage{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String copyright = "This is my code.";

  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "elements";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.eclipse.org/Library1";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "library1";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ElementsPackage eINSTANCE = org.examples.library.elements.impl.ElementsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.examples.library.elements.impl.BookImpl <em>Book</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.examples.library.elements.impl.BookImpl
   * @see org.examples.library.elements.impl.ElementsPackageImpl#getBook()
   * @generated
   */
  int BOOK = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__TITLE = 0;

  /**
   * The feature id for the '<em><b>Pages</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__PAGES = 1;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__CATEGORY = 2;

  /**
   * The feature id for the '<em><b>Author</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__AUTHOR = 3;

  /**
   * The number of structural features of the the '<em>Book</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.examples.library.elements.impl.WriterImpl <em>Writer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.examples.library.elements.impl.WriterImpl
   * @see org.examples.library.elements.impl.ElementsPackageImpl#getWriter()
   * @generated
   */
  int WRITER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRITER__NAME = HrPackage.PERSON__NAME;

  /**
   * The feature id for the '<em><b>Library</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRITER__LIBRARY = HrPackage.PERSON__LIBRARY;

  /**
   * The feature id for the '<em><b>Books</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRITER__BOOKS = HrPackage.PERSON_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the the '<em>Writer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRITER_FEATURE_COUNT = HrPackage.PERSON_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.examples.library.elements.BookCategory <em>Book Category</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.examples.library.elements.BookCategory
   * @see org.examples.library.elements.impl.ElementsPackageImpl#getBookCategory()
   * @generated
   */
  int BOOK_CATEGORY = 2;

  /**
   * The meta object id for the '<em>Book Category Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.examples.library.elements.BookCategory
   * @see org.examples.library.elements.impl.ElementsPackageImpl#getBookCategoryObject()
   * @generated
   */
  int BOOK_CATEGORY_OBJECT = 3;


  /**
   * Returns the meta object for class '{@link org.examples.library.elements.Book <em>Book</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Book</em>'.
   * @see org.examples.library.elements.Book
   * @generated
   */
  EClass getBook();

  /**
   * Returns the meta object for the attribute '{@link org.examples.library.elements.Book#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.examples.library.elements.Book#getTitle()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_Title();

  /**
   * Returns the meta object for the attribute '{@link org.examples.library.elements.Book#getPages <em>Pages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pages</em>'.
   * @see org.examples.library.elements.Book#getPages()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_Pages();

  /**
   * Returns the meta object for the attribute '{@link org.examples.library.elements.Book#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see org.examples.library.elements.Book#getCategory()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_Category();

  /**
   * Returns the meta object for the attribute '{@link org.examples.library.elements.Book#getAuthor <em>Author</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Author</em>'.
   * @see org.examples.library.elements.Book#getAuthor()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_Author();

  /**
   * Returns the meta object for class '{@link org.examples.library.elements.Writer <em>Writer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Writer</em>'.
   * @see org.examples.library.elements.Writer
   * @generated
   */
  EClass getWriter();

  /**
   * Returns the meta object for the attribute list '{@link org.examples.library.elements.Writer#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Books</em>'.
   * @see org.examples.library.elements.Writer#getBooks()
   * @see #getWriter()
   * @generated
   */
  EAttribute getWriter_Books();

  /**
   * Returns the meta object for enum '{@link org.examples.library.elements.BookCategory <em>Book Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Book Category</em>'.
   * @see org.examples.library.elements.BookCategory
   * @generated
   */
  EEnum getBookCategory();

  /**
   * Returns the meta object for data type '{@link org.examples.library.elements.BookCategory <em>Book Category Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Book Category Object</em>'.
   * @see org.examples.library.elements.BookCategory
   * @model instanceClass="org.examples.library.elements.BookCategory"
   *        extendedMetaData="name='BookCategory:Object' baseType='BookCategory'" 
   * @generated
   */
  EDataType getBookCategoryObject();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ElementsFactory getElementsFactory();

} //ElementsPackage
