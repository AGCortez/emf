package org.eclipse.emf.codegen.ecore.templates.model;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class Class
{
  protected static String nl;
  public static synchronized Class create(String lineSeparator)
  {
    nl = lineSeparator;
    Class result = new Class();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**";
  protected final String TEXT_3 = NL + " * ";
  protected final String TEXT_4 = NL + " * <copyright>" + NL + " * </copyright>";
  protected final String TEXT_5 = NL + " *" + NL + " * ";
  protected final String TEXT_6 = "Id";
  protected final String TEXT_7 = NL + " */";
  protected final String TEXT_8 = NL + "package ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "package ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the model object '<em><b>";
  protected final String TEXT_15 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_16 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_17 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_18 = NL + " *";
  protected final String TEXT_19 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
  protected final String TEXT_20 = NL + " *   <li>{@link ";
  protected final String TEXT_21 = "#";
  protected final String TEXT_22 = " <em>";
  protected final String TEXT_23 = "</em>}</li>";
  protected final String TEXT_24 = NL + " * </ul>" + NL + " * </p>";
  protected final String TEXT_25 = NL + " *";
  protected final String TEXT_26 = NL + " * @see ";
  protected final String TEXT_27 = "#get";
  protected final String TEXT_28 = "()";
  protected final String TEXT_29 = NL + " * @model ";
  protected final String TEXT_30 = NL + " *        ";
  protected final String TEXT_31 = NL + " * @model";
  protected final String TEXT_32 = NL + " * @extends ";
  protected final String TEXT_33 = NL + " * @generated" + NL + " */";
  protected final String TEXT_34 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
  protected final String TEXT_35 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
  protected final String TEXT_36 = NL + " * The following features are implemented:" + NL + " * <ul>";
  protected final String TEXT_37 = NL + " *   <li>{@link ";
  protected final String TEXT_38 = "#";
  protected final String TEXT_39 = " <em>";
  protected final String TEXT_40 = "</em>}</li>";
  protected final String TEXT_41 = NL + " * </ul>";
  protected final String TEXT_42 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
  protected final String TEXT_43 = NL + "public";
  protected final String TEXT_44 = " abstract";
  protected final String TEXT_45 = " class ";
  protected final String TEXT_46 = NL + "public interface ";
  protected final String TEXT_47 = NL + "{";
  protected final String TEXT_48 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_49 = " copyright = ";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_53 = " mofDriverNumber = \"";
  protected final String TEXT_54 = "\";";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
  protected final String TEXT_57 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
  protected final String TEXT_58 = ";" + NL;
  protected final String TEXT_59 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_60 = ";" + NL;
  protected final String TEXT_61 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_62 = " = 0;" + NL;
  protected final String TEXT_63 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_64 = "() <em>";
  protected final String TEXT_65 = "</em>}' ";
  protected final String TEXT_66 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_67 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = ";" + NL;
  protected final String TEXT_70 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_71 = "() <em>";
  protected final String TEXT_72 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_73 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_74 = "[] ";
  protected final String TEXT_75 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_76 = " [0];" + NL;
  protected final String TEXT_77 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_78 = "() <em>";
  protected final String TEXT_79 = "</em>}' ";
  protected final String TEXT_80 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_81 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_82 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_83 = NL + "\tprotected static final ";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = "; // TODO The default value literal \"";
  protected final String TEXT_86 = "\" is not valid.";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";";
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_91 = " = 0;" + NL;
  protected final String TEXT_92 = NL + "\t/**" + NL + "\t * The flag representing the value of the '{@link #";
  protected final String TEXT_93 = "() <em>";
  protected final String TEXT_94 = "</em>}' ";
  protected final String TEXT_95 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_96 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_97 = "_EFLAG = 1 ";
  protected final String TEXT_98 = ";" + NL;
  protected final String TEXT_99 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_100 = "() <em>";
  protected final String TEXT_101 = "</em>}' ";
  protected final String TEXT_102 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_103 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_104 = " ";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL;
  protected final String TEXT_107 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_108 = " = 0;" + NL;
  protected final String TEXT_109 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_110 = " ";
  protected final String TEXT_111 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_112 = "_ESETFLAG = 1 ";
  protected final String TEXT_113 = ";" + NL;
  protected final String TEXT_114 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_115 = " ";
  protected final String TEXT_116 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_117 = "ESet;" + NL;
  protected final String TEXT_118 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_119 = "()" + NL + "\t{" + NL + "\t\tsuper();";
  protected final String TEXT_120 = NL + "\t\t";
  protected final String TEXT_121 = " |= ";
  protected final String TEXT_122 = "_EFLAG;";
  protected final String TEXT_123 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_124 = NL + "\t@Override";
  protected final String TEXT_125 = NL + "\tprotected ";
  protected final String TEXT_126 = " eStaticClass()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_127 = ";" + NL + "\t}" + NL;
  protected final String TEXT_128 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_129 = NL + "\t@Override";
  protected final String TEXT_130 = NL + "\tprotected int eStaticFeatureCount()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_131 = ";" + NL + "\t}" + NL;
  protected final String TEXT_132 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_133 = NL + "\t";
  protected final String TEXT_134 = "[] ";
  protected final String TEXT_135 = "();" + NL;
  protected final String TEXT_136 = NL + "\tpublic ";
  protected final String TEXT_137 = "[] ";
  protected final String TEXT_138 = "()" + NL + "\t{";
  protected final String TEXT_139 = NL + "\t\t";
  protected final String TEXT_140 = " list = (";
  protected final String TEXT_141 = ")";
  protected final String TEXT_142 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_143 = "_EEMPTY_ARRAY;";
  protected final String TEXT_144 = NL + "\t\tif (";
  protected final String TEXT_145 = " == null || ";
  protected final String TEXT_146 = ".isEmpty()) return ";
  protected final String TEXT_147 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_148 = " list = (";
  protected final String TEXT_149 = ")";
  protected final String TEXT_150 = ";";
  protected final String TEXT_151 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_152 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_153 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_154 = NL + "\t";
  protected final String TEXT_155 = " get";
  protected final String TEXT_156 = "(int index);" + NL;
  protected final String TEXT_157 = NL + "\tpublic ";
  protected final String TEXT_158 = " get";
  protected final String TEXT_159 = "(int index)" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_160 = ")";
  protected final String TEXT_161 = "().get(index);" + NL + "\t}" + NL;
  protected final String TEXT_162 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_163 = NL + "\tint get";
  protected final String TEXT_164 = "Length();" + NL;
  protected final String TEXT_165 = NL + "\tpublic int get";
  protected final String TEXT_166 = "Length()" + NL + "\t{";
  protected final String TEXT_167 = NL + "\t\treturn ";
  protected final String TEXT_168 = "().size();";
  protected final String TEXT_169 = NL + "\t\treturn ";
  protected final String TEXT_170 = " == null ? 0 : ";
  protected final String TEXT_171 = ".size();";
  protected final String TEXT_172 = NL + "\t}" + NL;
  protected final String TEXT_173 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_174 = NL + "\tvoid set";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = "[] new";
  protected final String TEXT_177 = ");" + NL;
  protected final String TEXT_178 = NL + "\tpublic void set";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = "[] new";
  protected final String TEXT_181 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_182 = ")";
  protected final String TEXT_183 = "()).setData(new";
  protected final String TEXT_184 = ".length, new";
  protected final String TEXT_185 = ");" + NL + "\t}" + NL;
  protected final String TEXT_186 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_187 = NL + "\tvoid set";
  protected final String TEXT_188 = "(int index, ";
  protected final String TEXT_189 = " element);" + NL;
  protected final String TEXT_190 = NL + "\tpublic void set";
  protected final String TEXT_191 = "(int index, ";
  protected final String TEXT_192 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_193 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_194 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
  protected final String TEXT_195 = "</b></em>' ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = NL + "\t * The key is of type ";
  protected final String TEXT_198 = "list of {@link ";
  protected final String TEXT_199 = "}";
  protected final String TEXT_200 = "{@link ";
  protected final String TEXT_201 = "}";
  protected final String TEXT_202 = "," + NL + "\t * and the value is of type ";
  protected final String TEXT_203 = "list of {@link ";
  protected final String TEXT_204 = "}";
  protected final String TEXT_205 = "{@link ";
  protected final String TEXT_206 = "}";
  protected final String TEXT_207 = ",";
  protected final String TEXT_208 = NL + "\t * The list contents are of type {@link ";
  protected final String TEXT_209 = "}.";
  protected final String TEXT_210 = NL + "\t * The default value is <code>";
  protected final String TEXT_211 = "</code>.";
  protected final String TEXT_212 = NL + "\t * The literals are from the enumeration {@link ";
  protected final String TEXT_213 = "}.";
  protected final String TEXT_214 = NL + "\t * It is bidirectional and its opposite is '{@link ";
  protected final String TEXT_215 = "#";
  protected final String TEXT_216 = " <em>";
  protected final String TEXT_217 = "</em>}'.";
  protected final String TEXT_218 = NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_219 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
  protected final String TEXT_220 = "</em>' ";
  protected final String TEXT_221 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_222 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_223 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_224 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_225 = NL + "\t * @return the value of the '<em>";
  protected final String TEXT_226 = "</em>' ";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = NL + "\t * @see ";
  protected final String TEXT_229 = NL + "\t * @see #isSet";
  protected final String TEXT_230 = "()";
  protected final String TEXT_231 = NL + "\t * @see #unset";
  protected final String TEXT_232 = "()";
  protected final String TEXT_233 = NL + "\t * @see #set";
  protected final String TEXT_234 = "(";
  protected final String TEXT_235 = ")";
  protected final String TEXT_236 = NL + "\t * @see ";
  protected final String TEXT_237 = "#get";
  protected final String TEXT_238 = "()";
  protected final String TEXT_239 = NL + "\t * @see ";
  protected final String TEXT_240 = "#";
  protected final String TEXT_241 = NL + "\t * @model ";
  protected final String TEXT_242 = NL + "\t *        ";
  protected final String TEXT_243 = NL + "\t * @model";
  protected final String TEXT_244 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_245 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_246 = NL + "\t";
  protected final String TEXT_247 = " ";
  protected final String TEXT_248 = "();" + NL;
  protected final String TEXT_249 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_250 = NL + "\tpublic ";
  protected final String TEXT_251 = " ";
  protected final String TEXT_252 = "()" + NL + "\t{";
  protected final String TEXT_253 = NL + "\t\treturn ";
  protected final String TEXT_254 = "(";
  protected final String TEXT_255 = "(";
  protected final String TEXT_256 = ")eGet(";
  protected final String TEXT_257 = ", true)";
  protected final String TEXT_258 = ").";
  protected final String TEXT_259 = "()";
  protected final String TEXT_260 = ";";
  protected final String TEXT_261 = NL + "\t\t";
  protected final String TEXT_262 = " ";
  protected final String TEXT_263 = " = (";
  protected final String TEXT_264 = ")eVirtualGet(";
  protected final String TEXT_265 = ");";
  protected final String TEXT_266 = NL + "\t\tif (";
  protected final String TEXT_267 = " == null)" + NL + "\t\t{";
  protected final String TEXT_268 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_269 = ", ";
  protected final String TEXT_270 = " = new ";
  protected final String TEXT_271 = ");";
  protected final String TEXT_272 = NL + "\t\t\t";
  protected final String TEXT_273 = " = new ";
  protected final String TEXT_274 = ";";
  protected final String TEXT_275 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_276 = ";";
  protected final String TEXT_277 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_278 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_279 = ")eContainer();";
  protected final String TEXT_280 = NL + "\t\t";
  protected final String TEXT_281 = " ";
  protected final String TEXT_282 = " = (";
  protected final String TEXT_283 = ")eVirtualGet(";
  protected final String TEXT_284 = ", ";
  protected final String TEXT_285 = ");";
  protected final String TEXT_286 = NL + "\t\tif (";
  protected final String TEXT_287 = " != null && ";
  protected final String TEXT_288 = ".eIsProxy())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_289 = " old";
  protected final String TEXT_290 = " = (";
  protected final String TEXT_291 = ")";
  protected final String TEXT_292 = ";" + NL + "\t\t\t";
  protected final String TEXT_293 = " = ";
  protected final String TEXT_294 = "eResolveProxy(old";
  protected final String TEXT_295 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_296 = " != old";
  protected final String TEXT_297 = ")" + NL + "\t\t\t{";
  protected final String TEXT_298 = NL + "\t\t\t\t";
  protected final String TEXT_299 = " new";
  protected final String TEXT_300 = " = (";
  protected final String TEXT_301 = ")";
  protected final String TEXT_302 = ";";
  protected final String TEXT_303 = NL + "\t\t\t\t";
  protected final String TEXT_304 = " msgs = old";
  protected final String TEXT_305 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_306 = ", null, null);";
  protected final String TEXT_307 = NL + "\t\t\t\t";
  protected final String TEXT_308 = " msgs =  old";
  protected final String TEXT_309 = ".eInverseRemove(this, ";
  protected final String TEXT_310 = ", ";
  protected final String TEXT_311 = ".class, null);";
  protected final String TEXT_312 = NL + "\t\t\t\tif (new";
  protected final String TEXT_313 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_314 = NL + "\t\t\t\t\tmsgs = new";
  protected final String TEXT_315 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_316 = ", null, msgs);";
  protected final String TEXT_317 = NL + "\t\t\t\t\tmsgs =  new";
  protected final String TEXT_318 = ".eInverseAdd(this, ";
  protected final String TEXT_319 = ", ";
  protected final String TEXT_320 = ".class, msgs);";
  protected final String TEXT_321 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (msgs != null) msgs.dispatch();";
  protected final String TEXT_322 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_323 = ", ";
  protected final String TEXT_324 = ");";
  protected final String TEXT_325 = NL + "\t\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\t\teNotify(new ";
  protected final String TEXT_326 = "(this, ";
  protected final String TEXT_327 = ".RESOLVE, ";
  protected final String TEXT_328 = ", old";
  protected final String TEXT_329 = ", ";
  protected final String TEXT_330 = "));";
  protected final String TEXT_331 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_332 = NL + "\t\treturn (";
  protected final String TEXT_333 = ")eVirtualGet(";
  protected final String TEXT_334 = ", ";
  protected final String TEXT_335 = ");";
  protected final String TEXT_336 = NL + "\t\treturn (";
  protected final String TEXT_337 = " & ";
  protected final String TEXT_338 = "_EFLAG) != 0;";
  protected final String TEXT_339 = NL + "\t\treturn ";
  protected final String TEXT_340 = ";";
  protected final String TEXT_341 = NL + "\t\t";
  protected final String TEXT_342 = " ";
  protected final String TEXT_343 = " = basicGet";
  protected final String TEXT_344 = "();" + NL + "\t\treturn ";
  protected final String TEXT_345 = " != null && ";
  protected final String TEXT_346 = ".eIsProxy() ? ";
  protected final String TEXT_347 = "eResolveProxy((";
  protected final String TEXT_348 = ")";
  protected final String TEXT_349 = ") : ";
  protected final String TEXT_350 = ";";
  protected final String TEXT_351 = NL + "\t\treturn new ";
  protected final String TEXT_352 = "((";
  protected final String TEXT_353 = ".Internal)((";
  protected final String TEXT_354 = ".Internal.Wrapper)get";
  protected final String TEXT_355 = "()).featureMap().";
  protected final String TEXT_356 = "list(";
  protected final String TEXT_357 = "));";
  protected final String TEXT_358 = NL + "\t\treturn (";
  protected final String TEXT_359 = ")get";
  protected final String TEXT_360 = "().";
  protected final String TEXT_361 = "list(";
  protected final String TEXT_362 = ");";
  protected final String TEXT_363 = NL + "\t\treturn ((";
  protected final String TEXT_364 = ".Internal.Wrapper)get";
  protected final String TEXT_365 = "()).featureMap().list(";
  protected final String TEXT_366 = ");";
  protected final String TEXT_367 = NL + "\t\treturn get";
  protected final String TEXT_368 = "().list(";
  protected final String TEXT_369 = ");";
  protected final String TEXT_370 = NL + "\t\treturn ";
  protected final String TEXT_371 = "(";
  protected final String TEXT_372 = "(";
  protected final String TEXT_373 = ")";
  protected final String TEXT_374 = "((";
  protected final String TEXT_375 = ".Internal.Wrapper)get";
  protected final String TEXT_376 = "()).featureMap().get(";
  protected final String TEXT_377 = ", true)";
  protected final String TEXT_378 = ").";
  protected final String TEXT_379 = "()";
  protected final String TEXT_380 = ";";
  protected final String TEXT_381 = NL + "\t\treturn ";
  protected final String TEXT_382 = "(";
  protected final String TEXT_383 = "(";
  protected final String TEXT_384 = ")";
  protected final String TEXT_385 = "get";
  protected final String TEXT_386 = "().get(";
  protected final String TEXT_387 = ", true)";
  protected final String TEXT_388 = ").";
  protected final String TEXT_389 = "()";
  protected final String TEXT_390 = ";";
  protected final String TEXT_391 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_392 = "' ";
  protected final String TEXT_393 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT";
  protected final String TEXT_394 = NL + "\t\t// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting" + NL + "\t\t// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.";
  protected final String TEXT_395 = "EcoreEMap";
  protected final String TEXT_396 = "BasicFeatureMap";
  protected final String TEXT_397 = "EcoreEList";
  protected final String TEXT_398 = " should be used.";
  protected final String TEXT_399 = NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_400 = NL + "\t}" + NL;
  protected final String TEXT_401 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_402 = NL + "\tpublic ";
  protected final String TEXT_403 = " basicGet";
  protected final String TEXT_404 = "()" + NL + "\t{";
  protected final String TEXT_405 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_406 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_407 = ")eInternalContainer();";
  protected final String TEXT_408 = NL + "\t\treturn (";
  protected final String TEXT_409 = ")eVirtualGet(";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "\t\treturn ";
  protected final String TEXT_412 = ";";
  protected final String TEXT_413 = NL + "\t\treturn (";
  protected final String TEXT_414 = ")((";
  protected final String TEXT_415 = ".Internal.Wrapper)get";
  protected final String TEXT_416 = "()).featureMap().get(";
  protected final String TEXT_417 = ", false);";
  protected final String TEXT_418 = NL + "\t\treturn (";
  protected final String TEXT_419 = ")get";
  protected final String TEXT_420 = "().get(";
  protected final String TEXT_421 = ", false);";
  protected final String TEXT_422 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_423 = "' ";
  protected final String TEXT_424 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_425 = NL + "\t}" + NL;
  protected final String TEXT_426 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_427 = NL + "\tpublic ";
  protected final String TEXT_428 = " basicSet";
  protected final String TEXT_429 = "(";
  protected final String TEXT_430 = " new";
  protected final String TEXT_431 = ", ";
  protected final String TEXT_432 = " msgs)" + NL + "\t{";
  protected final String TEXT_433 = NL + "\t\tmsgs = eBasicSetContainer((";
  protected final String TEXT_434 = ")new";
  protected final String TEXT_435 = ", ";
  protected final String TEXT_436 = ", msgs);";
  protected final String TEXT_437 = NL + "\t\treturn msgs;";
  protected final String TEXT_438 = NL + "\t\tObject old";
  protected final String TEXT_439 = " = eVirtualSet(";
  protected final String TEXT_440 = ", new";
  protected final String TEXT_441 = ");";
  protected final String TEXT_442 = NL + "\t\t";
  protected final String TEXT_443 = " old";
  protected final String TEXT_444 = " = ";
  protected final String TEXT_445 = ";" + NL + "\t\t";
  protected final String TEXT_446 = " = new";
  protected final String TEXT_447 = ";";
  protected final String TEXT_448 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_449 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_450 = NL + "\t\tboolean old";
  protected final String TEXT_451 = "ESet = (";
  protected final String TEXT_452 = " & ";
  protected final String TEXT_453 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_454 = " |= ";
  protected final String TEXT_455 = "_ESETFLAG;";
  protected final String TEXT_456 = NL + "\t\tboolean old";
  protected final String TEXT_457 = "ESet = ";
  protected final String TEXT_458 = "ESet;" + NL + "\t\t";
  protected final String TEXT_459 = "ESet = true;";
  protected final String TEXT_460 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{";
  protected final String TEXT_461 = NL + "\t\t\t";
  protected final String TEXT_462 = " notification = new ";
  protected final String TEXT_463 = "(this, ";
  protected final String TEXT_464 = ".SET, ";
  protected final String TEXT_465 = ", ";
  protected final String TEXT_466 = "isSetChange ? null : old";
  protected final String TEXT_467 = "old";
  protected final String TEXT_468 = ", new";
  protected final String TEXT_469 = ", ";
  protected final String TEXT_470 = "isSetChange";
  protected final String TEXT_471 = "!old";
  protected final String TEXT_472 = "ESet";
  protected final String TEXT_473 = ");";
  protected final String TEXT_474 = NL + "\t\t\t";
  protected final String TEXT_475 = " notification = new ";
  protected final String TEXT_476 = "(this, ";
  protected final String TEXT_477 = ".SET, ";
  protected final String TEXT_478 = ", ";
  protected final String TEXT_479 = "old";
  protected final String TEXT_480 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_481 = "old";
  protected final String TEXT_482 = ", new";
  protected final String TEXT_483 = ");";
  protected final String TEXT_484 = NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}";
  protected final String TEXT_485 = NL + "\t\treturn msgs;";
  protected final String TEXT_486 = NL + "\t\treturn ((";
  protected final String TEXT_487 = ".Internal)((";
  protected final String TEXT_488 = ".Internal.Wrapper)get";
  protected final String TEXT_489 = "()).featureMap()).basicAdd(";
  protected final String TEXT_490 = ", new";
  protected final String TEXT_491 = ", msgs);";
  protected final String TEXT_492 = NL + "\t\treturn ((";
  protected final String TEXT_493 = ".Internal)get";
  protected final String TEXT_494 = "()).basicAdd(";
  protected final String TEXT_495 = ", new";
  protected final String TEXT_496 = ", msgs);";
  protected final String TEXT_497 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_498 = "' ";
  protected final String TEXT_499 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_500 = NL + "\t}" + NL;
  protected final String TEXT_501 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_502 = "#";
  protected final String TEXT_503 = " <em>";
  protected final String TEXT_504 = "</em>}' ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_507 = "</em>' ";
  protected final String TEXT_508 = ".";
  protected final String TEXT_509 = NL + "\t * @see ";
  protected final String TEXT_510 = NL + "\t * @see #isSet";
  protected final String TEXT_511 = "()";
  protected final String TEXT_512 = NL + "\t * @see #unset";
  protected final String TEXT_513 = "()";
  protected final String TEXT_514 = NL + "\t * @see #";
  protected final String TEXT_515 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_516 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_517 = NL + "\tvoid set";
  protected final String TEXT_518 = "(";
  protected final String TEXT_519 = " value);" + NL;
  protected final String TEXT_520 = NL + "\tpublic void set";
  protected final String TEXT_521 = "(";
  protected final String TEXT_522 = " new";
  protected final String TEXT_523 = ")" + NL + "\t{";
  protected final String TEXT_524 = NL + "\t\teSet(";
  protected final String TEXT_525 = ", ";
  protected final String TEXT_526 = "new ";
  protected final String TEXT_527 = "(";
  protected final String TEXT_528 = "new";
  protected final String TEXT_529 = ")";
  protected final String TEXT_530 = ");";
  protected final String TEXT_531 = NL + "\t\tif (new";
  protected final String TEXT_532 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_533 = " && new";
  protected final String TEXT_534 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_535 = ".isAncestor(this, ";
  protected final String TEXT_536 = "new";
  protected final String TEXT_537 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_538 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_539 = NL + "\t\t\t";
  protected final String TEXT_540 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_541 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_542 = ")new";
  protected final String TEXT_543 = ").eInverseAdd(this, ";
  protected final String TEXT_544 = ", ";
  protected final String TEXT_545 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_546 = "(";
  protected final String TEXT_547 = "new";
  protected final String TEXT_548 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_549 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_550 = "(this, ";
  protected final String TEXT_551 = ".SET, ";
  protected final String TEXT_552 = ", new";
  protected final String TEXT_553 = ", new";
  protected final String TEXT_554 = "));";
  protected final String TEXT_555 = NL + "\t\t";
  protected final String TEXT_556 = " ";
  protected final String TEXT_557 = " = (";
  protected final String TEXT_558 = ")eVirtualGet(";
  protected final String TEXT_559 = ");";
  protected final String TEXT_560 = NL + "\t\tif (new";
  protected final String TEXT_561 = " != ";
  protected final String TEXT_562 = ")" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_563 = " msgs = null;" + NL + "\t\t\tif (";
  protected final String TEXT_564 = " != null)";
  protected final String TEXT_565 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_566 = ")";
  protected final String TEXT_567 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_568 = ", null, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_569 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_570 = ")new";
  protected final String TEXT_571 = ").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_572 = ", null, msgs);";
  protected final String TEXT_573 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_574 = ")";
  protected final String TEXT_575 = ").eInverseRemove(this, ";
  protected final String TEXT_576 = ", ";
  protected final String TEXT_577 = ".class, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_578 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_579 = ")new";
  protected final String TEXT_580 = ").eInverseAdd(this, ";
  protected final String TEXT_581 = ", ";
  protected final String TEXT_582 = ".class, msgs);";
  protected final String TEXT_583 = NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_584 = "(";
  protected final String TEXT_585 = "new";
  protected final String TEXT_586 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_587 = NL + "\t\telse" + NL + "\t\t{";
  protected final String TEXT_588 = NL + "\t\t\tboolean old";
  protected final String TEXT_589 = "ESet = eVirtualIsSet(";
  protected final String TEXT_590 = ");";
  protected final String TEXT_591 = NL + "\t\t\tboolean old";
  protected final String TEXT_592 = "ESet = (";
  protected final String TEXT_593 = " & ";
  protected final String TEXT_594 = "_ESETFLAG) != 0;";
  protected final String TEXT_595 = NL + "\t\t\t";
  protected final String TEXT_596 = " |= ";
  protected final String TEXT_597 = "_ESETFLAG;";
  protected final String TEXT_598 = NL + "\t\t\tboolean old";
  protected final String TEXT_599 = "ESet = ";
  protected final String TEXT_600 = "ESet;";
  protected final String TEXT_601 = NL + "\t\t\t";
  protected final String TEXT_602 = "ESet = true;";
  protected final String TEXT_603 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_604 = "(this, ";
  protected final String TEXT_605 = ".SET, ";
  protected final String TEXT_606 = ", new";
  protected final String TEXT_607 = ", new";
  protected final String TEXT_608 = ", !old";
  protected final String TEXT_609 = "ESet));";
  protected final String TEXT_610 = NL + "\t\t}";
  protected final String TEXT_611 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_612 = "(this, ";
  protected final String TEXT_613 = ".SET, ";
  protected final String TEXT_614 = ", new";
  protected final String TEXT_615 = ", new";
  protected final String TEXT_616 = "));";
  protected final String TEXT_617 = NL + "\t\t";
  protected final String TEXT_618 = " old";
  protected final String TEXT_619 = " = (";
  protected final String TEXT_620 = " & ";
  protected final String TEXT_621 = "_EFLAG) != 0;";
  protected final String TEXT_622 = NL + "\t\tif (new";
  protected final String TEXT_623 = ") ";
  protected final String TEXT_624 = " |= ";
  protected final String TEXT_625 = "_EFLAG; else ";
  protected final String TEXT_626 = " &= ~";
  protected final String TEXT_627 = "_EFLAG;";
  protected final String TEXT_628 = NL + "\t\t";
  protected final String TEXT_629 = " old";
  protected final String TEXT_630 = " = ";
  protected final String TEXT_631 = ";";
  protected final String TEXT_632 = NL + "\t\t";
  protected final String TEXT_633 = " ";
  protected final String TEXT_634 = " = new";
  protected final String TEXT_635 = " == null ? ";
  protected final String TEXT_636 = " : new";
  protected final String TEXT_637 = ";";
  protected final String TEXT_638 = NL + "\t\t";
  protected final String TEXT_639 = " = new";
  protected final String TEXT_640 = " == null ? ";
  protected final String TEXT_641 = " : new";
  protected final String TEXT_642 = ";";
  protected final String TEXT_643 = NL + "\t\t";
  protected final String TEXT_644 = " ";
  protected final String TEXT_645 = " = ";
  protected final String TEXT_646 = "new";
  protected final String TEXT_647 = ";";
  protected final String TEXT_648 = NL + "\t\t";
  protected final String TEXT_649 = " = ";
  protected final String TEXT_650 = "new";
  protected final String TEXT_651 = ";";
  protected final String TEXT_652 = NL + "\t\tObject old";
  protected final String TEXT_653 = " = eVirtualSet(";
  protected final String TEXT_654 = ", ";
  protected final String TEXT_655 = ");";
  protected final String TEXT_656 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_657 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_658 = NL + "\t\tboolean old";
  protected final String TEXT_659 = "ESet = (";
  protected final String TEXT_660 = " & ";
  protected final String TEXT_661 = "_ESETFLAG) != 0;";
  protected final String TEXT_662 = NL + "\t\t";
  protected final String TEXT_663 = " |= ";
  protected final String TEXT_664 = "_ESETFLAG;";
  protected final String TEXT_665 = NL + "\t\tboolean old";
  protected final String TEXT_666 = "ESet = ";
  protected final String TEXT_667 = "ESet;";
  protected final String TEXT_668 = NL + "\t\t";
  protected final String TEXT_669 = "ESet = true;";
  protected final String TEXT_670 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_671 = "(this, ";
  protected final String TEXT_672 = ".SET, ";
  protected final String TEXT_673 = ", ";
  protected final String TEXT_674 = "isSetChange ? ";
  protected final String TEXT_675 = " : old";
  protected final String TEXT_676 = "old";
  protected final String TEXT_677 = ", ";
  protected final String TEXT_678 = "new";
  protected final String TEXT_679 = ", ";
  protected final String TEXT_680 = "isSetChange";
  protected final String TEXT_681 = "!old";
  protected final String TEXT_682 = "ESet";
  protected final String TEXT_683 = "));";
  protected final String TEXT_684 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_685 = "(this, ";
  protected final String TEXT_686 = ".SET, ";
  protected final String TEXT_687 = ", ";
  protected final String TEXT_688 = "old";
  protected final String TEXT_689 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_690 = " : old";
  protected final String TEXT_691 = "old";
  protected final String TEXT_692 = ", ";
  protected final String TEXT_693 = "new";
  protected final String TEXT_694 = "));";
  protected final String TEXT_695 = NL + "\t\t((";
  protected final String TEXT_696 = ".Internal)((";
  protected final String TEXT_697 = ".Internal.Wrapper)get";
  protected final String TEXT_698 = "()).featureMap()).set(";
  protected final String TEXT_699 = ", ";
  protected final String TEXT_700 = "new ";
  protected final String TEXT_701 = "(";
  protected final String TEXT_702 = "new";
  protected final String TEXT_703 = ")";
  protected final String TEXT_704 = ");";
  protected final String TEXT_705 = NL + "\t\t((";
  protected final String TEXT_706 = ".Internal)get";
  protected final String TEXT_707 = "()).set(";
  protected final String TEXT_708 = ", ";
  protected final String TEXT_709 = "new ";
  protected final String TEXT_710 = "(";
  protected final String TEXT_711 = "new";
  protected final String TEXT_712 = ")";
  protected final String TEXT_713 = ");";
  protected final String TEXT_714 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_715 = "' ";
  protected final String TEXT_716 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_717 = NL + "\t}" + NL;
  protected final String TEXT_718 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_719 = NL + "\tpublic ";
  protected final String TEXT_720 = " basicUnset";
  protected final String TEXT_721 = "(";
  protected final String TEXT_722 = " msgs)" + NL + "\t{";
  protected final String TEXT_723 = NL + "\t\tObject old";
  protected final String TEXT_724 = " = eVirtualUnset(";
  protected final String TEXT_725 = ");";
  protected final String TEXT_726 = NL + "\t\t";
  protected final String TEXT_727 = " old";
  protected final String TEXT_728 = " = ";
  protected final String TEXT_729 = ";" + NL + "\t\t";
  protected final String TEXT_730 = " = null;";
  protected final String TEXT_731 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_732 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_733 = NL + "\t\tboolean old";
  protected final String TEXT_734 = "ESet = (";
  protected final String TEXT_735 = " & ";
  protected final String TEXT_736 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_737 = " &= ~";
  protected final String TEXT_738 = "_ESETFLAG;";
  protected final String TEXT_739 = NL + "\t\tboolean old";
  protected final String TEXT_740 = "ESet = ";
  protected final String TEXT_741 = "ESet;" + NL + "\t\t";
  protected final String TEXT_742 = "ESet = false;";
  protected final String TEXT_743 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_744 = " notification = new ";
  protected final String TEXT_745 = "(this, ";
  protected final String TEXT_746 = ".UNSET, ";
  protected final String TEXT_747 = ", ";
  protected final String TEXT_748 = "isSetChange ? old";
  protected final String TEXT_749 = " : null";
  protected final String TEXT_750 = "old";
  protected final String TEXT_751 = ", null, ";
  protected final String TEXT_752 = "isSetChange";
  protected final String TEXT_753 = "old";
  protected final String TEXT_754 = "ESet";
  protected final String TEXT_755 = ");" + NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}" + NL + "\t\treturn msgs;";
  protected final String TEXT_756 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_757 = "' ";
  protected final String TEXT_758 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_759 = NL + "\t}" + NL;
  protected final String TEXT_760 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_761 = "#";
  protected final String TEXT_762 = " <em>";
  protected final String TEXT_763 = "</em>}' ";
  protected final String TEXT_764 = ".";
  protected final String TEXT_765 = NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_766 = NL + "\t * @see #isSet";
  protected final String TEXT_767 = "()";
  protected final String TEXT_768 = NL + "\t * @see #";
  protected final String TEXT_769 = "()";
  protected final String TEXT_770 = NL + "\t * @see #set";
  protected final String TEXT_771 = "(";
  protected final String TEXT_772 = ")";
  protected final String TEXT_773 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_774 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_775 = NL + "\tvoid unset";
  protected final String TEXT_776 = "();" + NL;
  protected final String TEXT_777 = NL + "\tpublic void unset";
  protected final String TEXT_778 = "()" + NL + "\t{";
  protected final String TEXT_779 = NL + "\t\teUnset(";
  protected final String TEXT_780 = ");";
  protected final String TEXT_781 = NL + "\t\t";
  protected final String TEXT_782 = " ";
  protected final String TEXT_783 = " = (";
  protected final String TEXT_784 = ")eVirtualGet(";
  protected final String TEXT_785 = ");";
  protected final String TEXT_786 = NL + "\t\tif (";
  protected final String TEXT_787 = " != null) ((";
  protected final String TEXT_788 = ".Unsettable";
  protected final String TEXT_789 = ")";
  protected final String TEXT_790 = ").unset();";
  protected final String TEXT_791 = NL + "\t\t";
  protected final String TEXT_792 = " ";
  protected final String TEXT_793 = " = (";
  protected final String TEXT_794 = ")eVirtualGet(";
  protected final String TEXT_795 = ");";
  protected final String TEXT_796 = NL + "\t\tif (";
  protected final String TEXT_797 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_798 = " msgs = null;";
  protected final String TEXT_799 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_800 = ")";
  protected final String TEXT_801 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_802 = ", null, msgs);";
  protected final String TEXT_803 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_804 = ")";
  protected final String TEXT_805 = ").eInverseRemove(this, ";
  protected final String TEXT_806 = ", ";
  protected final String TEXT_807 = ".class, msgs);";
  protected final String TEXT_808 = NL + "\t\t\tmsgs = basicUnset";
  protected final String TEXT_809 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{";
  protected final String TEXT_810 = NL + "\t\t\tboolean old";
  protected final String TEXT_811 = "ESet = eVirtualIsSet(";
  protected final String TEXT_812 = ");";
  protected final String TEXT_813 = NL + "\t\t\tboolean old";
  protected final String TEXT_814 = "ESet = (";
  protected final String TEXT_815 = " & ";
  protected final String TEXT_816 = "_ESETFLAG) != 0;";
  protected final String TEXT_817 = NL + "\t\t\t";
  protected final String TEXT_818 = " &= ~";
  protected final String TEXT_819 = "_ESETFLAG;";
  protected final String TEXT_820 = NL + "\t\t\tboolean old";
  protected final String TEXT_821 = "ESet = ";
  protected final String TEXT_822 = "ESet;";
  protected final String TEXT_823 = NL + "\t\t\t";
  protected final String TEXT_824 = "ESet = false;";
  protected final String TEXT_825 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_826 = "(this, ";
  protected final String TEXT_827 = ".UNSET, ";
  protected final String TEXT_828 = ", null, null, old";
  protected final String TEXT_829 = "ESet));";
  protected final String TEXT_830 = NL + "\t\t}";
  protected final String TEXT_831 = NL + "\t\t";
  protected final String TEXT_832 = " old";
  protected final String TEXT_833 = " = (";
  protected final String TEXT_834 = " & ";
  protected final String TEXT_835 = "_EFLAG) != 0;";
  protected final String TEXT_836 = NL + "\t\tObject old";
  protected final String TEXT_837 = " = eVirtualUnset(";
  protected final String TEXT_838 = ");";
  protected final String TEXT_839 = NL + "\t\t";
  protected final String TEXT_840 = " old";
  protected final String TEXT_841 = " = ";
  protected final String TEXT_842 = ";";
  protected final String TEXT_843 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_844 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_845 = NL + "\t\tboolean old";
  protected final String TEXT_846 = "ESet = (";
  protected final String TEXT_847 = " & ";
  protected final String TEXT_848 = "_ESETFLAG) != 0;";
  protected final String TEXT_849 = NL + "\t\tboolean old";
  protected final String TEXT_850 = "ESet = ";
  protected final String TEXT_851 = "ESet;";
  protected final String TEXT_852 = NL + "\t\t";
  protected final String TEXT_853 = " = null;";
  protected final String TEXT_854 = NL + "\t\t";
  protected final String TEXT_855 = " &= ~";
  protected final String TEXT_856 = "_ESETFLAG;";
  protected final String TEXT_857 = NL + "\t\t";
  protected final String TEXT_858 = "ESet = false;";
  protected final String TEXT_859 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_860 = "(this, ";
  protected final String TEXT_861 = ".UNSET, ";
  protected final String TEXT_862 = ", ";
  protected final String TEXT_863 = "isSetChange ? old";
  protected final String TEXT_864 = " : null";
  protected final String TEXT_865 = "old";
  protected final String TEXT_866 = ", null, ";
  protected final String TEXT_867 = "isSetChange";
  protected final String TEXT_868 = "old";
  protected final String TEXT_869 = "ESet";
  protected final String TEXT_870 = "));";
  protected final String TEXT_871 = NL + "\t\tif (";
  protected final String TEXT_872 = ") ";
  protected final String TEXT_873 = " |= ";
  protected final String TEXT_874 = "_EFLAG; else ";
  protected final String TEXT_875 = " &= ~";
  protected final String TEXT_876 = "_EFLAG;";
  protected final String TEXT_877 = NL + "\t\t";
  protected final String TEXT_878 = " = ";
  protected final String TEXT_879 = ";";
  protected final String TEXT_880 = NL + "\t\t";
  protected final String TEXT_881 = " &= ~";
  protected final String TEXT_882 = "_ESETFLAG;";
  protected final String TEXT_883 = NL + "\t\t";
  protected final String TEXT_884 = "ESet = false;";
  protected final String TEXT_885 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_886 = "(this, ";
  protected final String TEXT_887 = ".UNSET, ";
  protected final String TEXT_888 = ", ";
  protected final String TEXT_889 = "isSetChange ? old";
  protected final String TEXT_890 = " : ";
  protected final String TEXT_891 = "old";
  protected final String TEXT_892 = ", ";
  protected final String TEXT_893 = ", ";
  protected final String TEXT_894 = "isSetChange";
  protected final String TEXT_895 = "old";
  protected final String TEXT_896 = "ESet";
  protected final String TEXT_897 = "));";
  protected final String TEXT_898 = NL + "\t\t((";
  protected final String TEXT_899 = ".Internal)((";
  protected final String TEXT_900 = ".Internal.Wrapper)get";
  protected final String TEXT_901 = "()).featureMap()).clear(";
  protected final String TEXT_902 = ");";
  protected final String TEXT_903 = NL + "\t\t((";
  protected final String TEXT_904 = ".Internal)get";
  protected final String TEXT_905 = "()).clear(";
  protected final String TEXT_906 = ");";
  protected final String TEXT_907 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_908 = "' ";
  protected final String TEXT_909 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_910 = NL + "\t}" + NL;
  protected final String TEXT_911 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_912 = "#";
  protected final String TEXT_913 = " <em>";
  protected final String TEXT_914 = "</em>}' ";
  protected final String TEXT_915 = " is set.";
  protected final String TEXT_916 = NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_917 = "</em>' ";
  protected final String TEXT_918 = " is set.";
  protected final String TEXT_919 = NL + "\t * @see #unset";
  protected final String TEXT_920 = "()";
  protected final String TEXT_921 = NL + "\t * @see #";
  protected final String TEXT_922 = "()";
  protected final String TEXT_923 = NL + "\t * @see #set";
  protected final String TEXT_924 = "(";
  protected final String TEXT_925 = ")";
  protected final String TEXT_926 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_927 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_928 = NL + "\tboolean isSet";
  protected final String TEXT_929 = "();" + NL;
  protected final String TEXT_930 = NL + "\tpublic boolean isSet";
  protected final String TEXT_931 = "()" + NL + "\t{";
  protected final String TEXT_932 = NL + "\t\treturn eIsSet(";
  protected final String TEXT_933 = ");";
  protected final String TEXT_934 = NL + "\t\t";
  protected final String TEXT_935 = " ";
  protected final String TEXT_936 = " = (";
  protected final String TEXT_937 = ")eVirtualGet(";
  protected final String TEXT_938 = ");";
  protected final String TEXT_939 = NL + "\t\treturn ";
  protected final String TEXT_940 = " != null && ((";
  protected final String TEXT_941 = ".Unsettable";
  protected final String TEXT_942 = ")";
  protected final String TEXT_943 = ").isSet();";
  protected final String TEXT_944 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_945 = ");";
  protected final String TEXT_946 = NL + "\t\treturn (";
  protected final String TEXT_947 = " & ";
  protected final String TEXT_948 = "_ESETFLAG) != 0;";
  protected final String TEXT_949 = NL + "\t\treturn ";
  protected final String TEXT_950 = "ESet;";
  protected final String TEXT_951 = NL + "\t\treturn !((";
  protected final String TEXT_952 = ".Internal)((";
  protected final String TEXT_953 = ".Internal.Wrapper)get";
  protected final String TEXT_954 = "()).featureMap()).isEmpty(";
  protected final String TEXT_955 = ");";
  protected final String TEXT_956 = NL + "\t\treturn !((";
  protected final String TEXT_957 = ".Internal)get";
  protected final String TEXT_958 = "()).isEmpty(";
  protected final String TEXT_959 = ");";
  protected final String TEXT_960 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_961 = "' ";
  protected final String TEXT_962 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_963 = NL + "\t}" + NL;
  protected final String TEXT_964 = NL + "\t/**";
  protected final String TEXT_965 = NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_966 = NL + "\t * <!-- begin-model-doc -->";
  protected final String TEXT_967 = NL + "\t * ";
  protected final String TEXT_968 = NL + "\t * @param ";
  protected final String TEXT_969 = NL + "\t *   ";
  protected final String TEXT_970 = NL + "\t * @param ";
  protected final String TEXT_971 = " ";
  protected final String TEXT_972 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_973 = NL + "\t * @model ";
  protected final String TEXT_974 = NL + "\t *        ";
  protected final String TEXT_975 = NL + "\t * @model";
  protected final String TEXT_976 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_977 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_978 = NL + "\t";
  protected final String TEXT_979 = " ";
  protected final String TEXT_980 = "(";
  protected final String TEXT_981 = ")";
  protected final String TEXT_982 = ";" + NL;
  protected final String TEXT_983 = NL + "\tpublic ";
  protected final String TEXT_984 = " ";
  protected final String TEXT_985 = "(";
  protected final String TEXT_986 = ")";
  protected final String TEXT_987 = NL + "\t{";
  protected final String TEXT_988 = NL + "\t\t";
  protected final String TEXT_989 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_990 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_991 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_992 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_993 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_994 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_995 = ".";
  protected final String TEXT_996 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_997 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_998 = "\", ";
  protected final String TEXT_999 = ".getObjectLabel(this, ";
  protected final String TEXT_1000 = ") }),";
  protected final String TEXT_1001 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_1002 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_1003 = NL + "\t}" + NL;
  protected final String TEXT_1004 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1005 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_1006 = NL + "\t@Override";
  protected final String TEXT_1007 = NL + "\tpublic ";
  protected final String TEXT_1008 = " eInverseAdd(";
  protected final String TEXT_1009 = " otherEnd, int featureID, ";
  protected final String TEXT_1010 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1011 = NL + "\t\t\tcase ";
  protected final String TEXT_1012 = ":";
  protected final String TEXT_1013 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1014 = "(";
  protected final String TEXT_1015 = ".InternalMapView";
  protected final String TEXT_1016 = ")";
  protected final String TEXT_1017 = "()).eMap()).basicAdd(otherEnd, msgs);";
  protected final String TEXT_1018 = NL + "\t\t\t\treturn (";
  protected final String TEXT_1019 = "()).basicAdd(otherEnd, msgs);";
  protected final String TEXT_1020 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);";
  protected final String TEXT_1021 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1022 = "((";
  protected final String TEXT_1023 = ")otherEnd, msgs);";
  protected final String TEXT_1024 = NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_1025 = ", msgs);";
  protected final String TEXT_1026 = NL + "\t\t\t\t";
  protected final String TEXT_1027 = " ";
  protected final String TEXT_1028 = " = (";
  protected final String TEXT_1029 = ")eVirtualGet(";
  protected final String TEXT_1030 = ");";
  protected final String TEXT_1031 = NL + "\t\t\t\tif (";
  protected final String TEXT_1032 = " != null)";
  protected final String TEXT_1033 = NL + "\t\t\t\t\tmsgs = ((";
  protected final String TEXT_1034 = ")";
  protected final String TEXT_1035 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_1036 = ", null, msgs);";
  protected final String TEXT_1037 = NL + "\t\t\t\t\tmsgs = ((";
  protected final String TEXT_1038 = ")";
  protected final String TEXT_1039 = ").eInverseRemove(this, ";
  protected final String TEXT_1040 = ", ";
  protected final String TEXT_1041 = ".class, msgs);";
  protected final String TEXT_1042 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1043 = "((";
  protected final String TEXT_1044 = ")otherEnd, msgs);";
  protected final String TEXT_1045 = NL + "\t\t}";
  protected final String TEXT_1046 = NL + "\t\treturn super.eInverseAdd(otherEnd, featureID, msgs);";
  protected final String TEXT_1047 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, featureID, msgs);";
  protected final String TEXT_1048 = NL + "\t}" + NL;
  protected final String TEXT_1049 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1050 = NL + "\t@Override";
  protected final String TEXT_1051 = NL + "\tpublic ";
  protected final String TEXT_1052 = " eInverseRemove(";
  protected final String TEXT_1053 = " otherEnd, int featureID, ";
  protected final String TEXT_1054 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1055 = NL + "\t\t\tcase ";
  protected final String TEXT_1056 = ":";
  protected final String TEXT_1057 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1058 = ")((";
  protected final String TEXT_1059 = ".InternalMapView";
  protected final String TEXT_1060 = ")";
  protected final String TEXT_1061 = "()).eMap()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1062 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1063 = ")((";
  protected final String TEXT_1064 = ".Internal.Wrapper)";
  protected final String TEXT_1065 = "()).featureMap()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1066 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1067 = ")";
  protected final String TEXT_1068 = "()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1069 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_1070 = ", msgs);";
  protected final String TEXT_1071 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_1072 = "(msgs);";
  protected final String TEXT_1073 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1074 = "(null, msgs);";
  protected final String TEXT_1075 = NL + "\t\t}";
  protected final String TEXT_1076 = NL + "\t\treturn super.eInverseRemove(otherEnd, featureID, msgs);";
  protected final String TEXT_1077 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, featureID, msgs);";
  protected final String TEXT_1078 = NL + "\t}" + NL;
  protected final String TEXT_1079 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1080 = NL + "\t@Override";
  protected final String TEXT_1081 = NL + "\tpublic ";
  protected final String TEXT_1082 = " eBasicRemoveFromContainerFeature(";
  protected final String TEXT_1083 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_1084 = NL + "\t\t\tcase ";
  protected final String TEXT_1085 = ":" + NL + "\t\t\t\treturn eInternalContainer().eInverseRemove(this, ";
  protected final String TEXT_1086 = ", ";
  protected final String TEXT_1087 = ".class, msgs);";
  protected final String TEXT_1088 = NL + "\t\t}";
  protected final String TEXT_1089 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(msgs);";
  protected final String TEXT_1090 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(msgs);";
  protected final String TEXT_1091 = NL + "\t}" + NL;
  protected final String TEXT_1092 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1093 = NL + "\t@Override";
  protected final String TEXT_1094 = NL + "\tpublic Object eGet(int featureID, boolean resolve, boolean coreType)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1095 = NL + "\t\t\tcase ";
  protected final String TEXT_1096 = ":";
  protected final String TEXT_1097 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1098 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1099 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1100 = "(";
  protected final String TEXT_1101 = "());";
  protected final String TEXT_1102 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1103 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1104 = "();";
  protected final String TEXT_1105 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1106 = ".InternalMapView";
  protected final String TEXT_1107 = ")";
  protected final String TEXT_1108 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1109 = "();";
  protected final String TEXT_1110 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1111 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1112 = "().map();";
  protected final String TEXT_1113 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1114 = ".Internal.Wrapper)";
  protected final String TEXT_1115 = "()).featureMap();" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1116 = "();";
  protected final String TEXT_1117 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1118 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1119 = ".Internal)";
  protected final String TEXT_1120 = "()).getWrapper();";
  protected final String TEXT_1121 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1122 = "();";
  protected final String TEXT_1123 = NL + "\t\t}";
  protected final String TEXT_1124 = NL + "\t\treturn super.eGet(featureID, resolve, coreType);";
  protected final String TEXT_1125 = NL + "\t\treturn eDynamicGet(featureID, resolve, coreType);";
  protected final String TEXT_1126 = NL + "\t}" + NL;
  protected final String TEXT_1127 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1128 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_1129 = NL + "\t@Override";
  protected final String TEXT_1130 = NL + "\tpublic void eSet(int featureID, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1131 = NL + "\t\t\tcase ";
  protected final String TEXT_1132 = ":";
  protected final String TEXT_1133 = NL + "\t\t\t\t((";
  protected final String TEXT_1134 = ".Internal)((";
  protected final String TEXT_1135 = ".Internal.Wrapper)";
  protected final String TEXT_1136 = "()).featureMap()).set(newValue);";
  protected final String TEXT_1137 = NL + "\t\t\t\t((";
  protected final String TEXT_1138 = ".Internal)";
  protected final String TEXT_1139 = "()).set(newValue);";
  protected final String TEXT_1140 = NL + "\t\t\t\t((";
  protected final String TEXT_1141 = ".Setting)((";
  protected final String TEXT_1142 = ".InternalMapView";
  protected final String TEXT_1143 = ")";
  protected final String TEXT_1144 = "()).eMap()).set(newValue);";
  protected final String TEXT_1145 = NL + "\t\t\t\t((";
  protected final String TEXT_1146 = ".Setting)";
  protected final String TEXT_1147 = "()).set(newValue);";
  protected final String TEXT_1148 = NL + "\t\t\t\t";
  protected final String TEXT_1149 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1150 = "().addAll((";
  protected final String TEXT_1151 = "<? extends ";
  protected final String TEXT_1152 = ">";
  protected final String TEXT_1153 = ")newValue);";
  protected final String TEXT_1154 = NL + "\t\t\t\tset";
  protected final String TEXT_1155 = "(((";
  protected final String TEXT_1156 = ")newValue).";
  protected final String TEXT_1157 = "());";
  protected final String TEXT_1158 = NL + "\t\t\t\tset";
  protected final String TEXT_1159 = "(";
  protected final String TEXT_1160 = "(";
  protected final String TEXT_1161 = ")";
  protected final String TEXT_1162 = "newValue);";
  protected final String TEXT_1163 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1164 = NL + "\t\t}";
  protected final String TEXT_1165 = NL + "\t\tsuper.eSet(featureID, newValue);";
  protected final String TEXT_1166 = NL + "\t\teDynamicSet(featureID, newValue);";
  protected final String TEXT_1167 = NL + "\t}" + NL;
  protected final String TEXT_1168 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1169 = NL + "\t@Override";
  protected final String TEXT_1170 = NL + "\tpublic void eUnset(int featureID)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1171 = NL + "\t\t\tcase ";
  protected final String TEXT_1172 = ":";
  protected final String TEXT_1173 = NL + "\t\t\t\t((";
  protected final String TEXT_1174 = ".Internal.Wrapper)";
  protected final String TEXT_1175 = "()).featureMap().clear();";
  protected final String TEXT_1176 = NL + "\t\t\t\t";
  protected final String TEXT_1177 = "().clear();";
  protected final String TEXT_1178 = NL + "\t\t\t\tunset";
  protected final String TEXT_1179 = "();";
  protected final String TEXT_1180 = NL + "\t\t\t\tset";
  protected final String TEXT_1181 = "((";
  protected final String TEXT_1182 = ")null);";
  protected final String TEXT_1183 = NL + "\t\t\t\tset";
  protected final String TEXT_1184 = "(";
  protected final String TEXT_1185 = ");";
  protected final String TEXT_1186 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1187 = NL + "\t\t}";
  protected final String TEXT_1188 = NL + "\t\tsuper.eUnset(featureID);";
  protected final String TEXT_1189 = NL + "\t\teDynamicUnset(featureID);";
  protected final String TEXT_1190 = NL + "\t}" + NL;
  protected final String TEXT_1191 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1192 = NL + "\t@Override";
  protected final String TEXT_1193 = NL + "\tpublic boolean eIsSet(int featureID)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1194 = NL + "\t\t\tcase ";
  protected final String TEXT_1195 = ":";
  protected final String TEXT_1196 = NL + "\t\t\t\treturn !((";
  protected final String TEXT_1197 = ".Internal.Wrapper)";
  protected final String TEXT_1198 = "()).featureMap().isEmpty();";
  protected final String TEXT_1199 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1200 = " != null && !";
  protected final String TEXT_1201 = ".featureMap().isEmpty();";
  protected final String TEXT_1202 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1203 = " != null && !";
  protected final String TEXT_1204 = ".isEmpty();";
  protected final String TEXT_1205 = NL + "\t\t\t\t";
  protected final String TEXT_1206 = " ";
  protected final String TEXT_1207 = " = (";
  protected final String TEXT_1208 = ")eVirtualGet(";
  protected final String TEXT_1209 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1210 = " != null && !";
  protected final String TEXT_1211 = ".isEmpty();";
  protected final String TEXT_1212 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1213 = "().isEmpty();";
  protected final String TEXT_1214 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1215 = "();";
  protected final String TEXT_1216 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1217 = " != null;";
  protected final String TEXT_1218 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1219 = ") != null;";
  protected final String TEXT_1220 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1221 = "() != null;";
  protected final String TEXT_1222 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1223 = " != null;";
  protected final String TEXT_1224 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1225 = ") != null;";
  protected final String TEXT_1226 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1227 = "() != null;";
  protected final String TEXT_1228 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1229 = " & ";
  protected final String TEXT_1230 = "_EFLAG) != 0) != ";
  protected final String TEXT_1231 = ";";
  protected final String TEXT_1232 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1233 = " != ";
  protected final String TEXT_1234 = ";";
  protected final String TEXT_1235 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1236 = ", ";
  protected final String TEXT_1237 = ") != ";
  protected final String TEXT_1238 = ";";
  protected final String TEXT_1239 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1240 = "() != ";
  protected final String TEXT_1241 = ";";
  protected final String TEXT_1242 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1243 = " == null ? ";
  protected final String TEXT_1244 = " != null : !";
  protected final String TEXT_1245 = ".equals(";
  protected final String TEXT_1246 = ");";
  protected final String TEXT_1247 = NL + "\t\t\t\t";
  protected final String TEXT_1248 = " ";
  protected final String TEXT_1249 = " = (";
  protected final String TEXT_1250 = ")eVirtualGet(";
  protected final String TEXT_1251 = ", ";
  protected final String TEXT_1252 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1253 = " == null ? ";
  protected final String TEXT_1254 = " != null : !";
  protected final String TEXT_1255 = ".equals(";
  protected final String TEXT_1256 = ");";
  protected final String TEXT_1257 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1258 = " == null ? ";
  protected final String TEXT_1259 = "() != null : !";
  protected final String TEXT_1260 = ".equals(";
  protected final String TEXT_1261 = "());";
  protected final String TEXT_1262 = NL + "\t\t}";
  protected final String TEXT_1263 = NL + "\t\treturn super.eIsSet(featureID);";
  protected final String TEXT_1264 = NL + "\t\treturn eDynamicIsSet(featureID);";
  protected final String TEXT_1265 = NL + "\t}" + NL;
  protected final String TEXT_1266 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1267 = NL + "\t@Override";
  protected final String TEXT_1268 = NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class";
  protected final String TEXT_1269 = " baseClass)" + NL + "\t{";
  protected final String TEXT_1270 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1271 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1272 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1273 = ": return ";
  protected final String TEXT_1274 = ";";
  protected final String TEXT_1275 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1276 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1277 = NL + "\t@Override";
  protected final String TEXT_1278 = NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class";
  protected final String TEXT_1279 = " baseClass)" + NL + "\t{";
  protected final String TEXT_1280 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1281 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1282 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1283 = ": return ";
  protected final String TEXT_1284 = ";";
  protected final String TEXT_1285 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1286 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1287 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1288 = NL + "\t@Override";
  protected final String TEXT_1289 = NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1290 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1291 = NL + "\t@Override";
  protected final String TEXT_1292 = NL + "\tprotected void eSetVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1293 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1294 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1295 = NL + "\t@Override";
  protected final String TEXT_1296 = NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1297 = NL + "\t\t\tcase ";
  protected final String TEXT_1298 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1299 = ";";
  protected final String TEXT_1300 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1301 = NL + "\t@Override";
  protected final String TEXT_1302 = NL + "\tprotected void eSetVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1303 = NL + "\t\t\tcase ";
  protected final String TEXT_1304 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1305 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1306 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1307 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1308 = NL + "\t@Override";
  protected final String TEXT_1309 = NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (eIsProxy()) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1310 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1311 = ": \");";
  protected final String TEXT_1312 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1313 = ": \");";
  protected final String TEXT_1314 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1315 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1316 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1317 = NL + "\t\tif (";
  protected final String TEXT_1318 = "(";
  protected final String TEXT_1319 = " & ";
  protected final String TEXT_1320 = "_ESETFLAG) != 0";
  protected final String TEXT_1321 = "ESet";
  protected final String TEXT_1322 = ") result.append((";
  protected final String TEXT_1323 = " & ";
  protected final String TEXT_1324 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1325 = NL + "\t\tif (";
  protected final String TEXT_1326 = "(";
  protected final String TEXT_1327 = " & ";
  protected final String TEXT_1328 = "_ESETFLAG) != 0";
  protected final String TEXT_1329 = "ESet";
  protected final String TEXT_1330 = ") result.append(";
  protected final String TEXT_1331 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1332 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1333 = ", ";
  protected final String TEXT_1334 = "));";
  protected final String TEXT_1335 = NL + "\t\tresult.append((";
  protected final String TEXT_1336 = " & ";
  protected final String TEXT_1337 = "_EFLAG) != 0);";
  protected final String TEXT_1338 = NL + "\t\tresult.append(";
  protected final String TEXT_1339 = ");";
  protected final String TEXT_1340 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1341 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_1342 = " theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1343 = " getKey()" + NL + "\t{";
  protected final String TEXT_1344 = NL + "\t\treturn new ";
  protected final String TEXT_1345 = "(getTypedKey());";
  protected final String TEXT_1346 = NL + "\t\treturn getTypedKey();";
  protected final String TEXT_1347 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(";
  protected final String TEXT_1348 = " key)" + NL + "\t{";
  protected final String TEXT_1349 = NL + "\t\tgetTypedKey().addAll(";
  protected final String TEXT_1350 = "(";
  protected final String TEXT_1351 = ")";
  protected final String TEXT_1352 = "key);";
  protected final String TEXT_1353 = NL + "\t\tsetTypedKey(key);";
  protected final String TEXT_1354 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1355 = ")key).";
  protected final String TEXT_1356 = "());";
  protected final String TEXT_1357 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1358 = ")key);";
  protected final String TEXT_1359 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1360 = " getValue()" + NL + "\t{";
  protected final String TEXT_1361 = NL + "\t\treturn new ";
  protected final String TEXT_1362 = "(getTypedValue());";
  protected final String TEXT_1363 = NL + "\t\treturn getTypedValue();";
  protected final String TEXT_1364 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1365 = " setValue(";
  protected final String TEXT_1366 = " value)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1367 = " oldValue = getValue();";
  protected final String TEXT_1368 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll(";
  protected final String TEXT_1369 = "(";
  protected final String TEXT_1370 = ")";
  protected final String TEXT_1371 = "value);";
  protected final String TEXT_1372 = NL + "\t\tsetTypedValue(value);";
  protected final String TEXT_1373 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1374 = ")value).";
  protected final String TEXT_1375 = "());";
  protected final String TEXT_1376 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1377 = ")value);";
  protected final String TEXT_1378 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1379 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_1380 = NL + "\tpublic ";
  protected final String TEXT_1381 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1382 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1383 = ")container.eGet(eContainmentFeature());" + NL + "\t}" + NL;
  protected final String TEXT_1384 = NL + "} //";
  protected final String TEXT_1385 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
 */

    final GenClass genClass = (GenClass)((Object[])argument)[0]; final GenPackage genPackage = genClass.getGenPackage(); final GenModel genModel=genPackage.getGenModel();
    final boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); final boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
    final String publicStaticFinalFlag = isImplementation ? "public static final " : "";
    final String singleWildcard = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? "<?>" : "";
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    {GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_4);
    }}
    stringBuffer.append(TEXT_5);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_6);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_7);
    if (isInterface) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genPackage.getClassPackageName());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    genModel.markImportLocation(stringBuffer, genPackage);
    stringBuffer.append(TEXT_13);
    if (isInterface) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_15);
    if (genClass.hasDocumentation()) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if (!genClass.getGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_19);
    for (GenFeature genFeature : genClass.getGenFeatures()) {
    if (!genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_23);
    }
    }
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_28);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_31);
    }}
    if (genClass.needsRootExtendsInterfaceExtendsTag()) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
    }
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_35);
    if (!genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_36);
    for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_43);
    if (genClass.isAbstract()) {
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(genClass.getTypeParameters().trim());
    stringBuffer.append(genClass.getClassExtends());
    stringBuffer.append(genClass.getClassImplements());
    } else {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genClass.getInterfaceName());
    stringBuffer.append(genClass.getTypeParameters().trim());
    stringBuffer.append(genClass.getInterfaceExtends());
    }
    stringBuffer.append(TEXT_47);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_51);
    }
    if (isImplementation && genModel.getDriverNumber() != null) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genModel.getDriverNumber());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_55);
    }
    if (isImplementation && genClass.isJavaIOSerializable()) {
    stringBuffer.append(TEXT_56);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_58);
    }
    { List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
    if (!eVirtualIndexBitFields.isEmpty()) {
    for (String eVirtualIndexBitField : eVirtualIndexBitFields) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eVirtualIndexBitField);
    stringBuffer.append(TEXT_60);
    }
    }
    }
    }
    if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genModel.getBooleanFlagsField());
    stringBuffer.append(TEXT_62);
    }
    if (isImplementation && !genModel.isReflectiveDelegation()) {
    for (GenFeature genFeature : genClass.getDeclaredFieldGenFeatures()) {
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_69);
    }
    if (genModel.isArrayAccessors() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_76);
    }
    } else {
    if (genFeature.hasEDefault() && (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable()))) { String staticDefaultValue = genFeature.getStaticDefaultValue();
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_81);
    if (genModel.useGenerics() && genFeature.isListDataType() && genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genFeature.getEDefault());
    if ("".equals(staticDefaultValue)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getEcoreFeature().getDefaultValueLiteral());
    stringBuffer.append(TEXT_86);
    } else {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(staticDefaultValue);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genModel.getNonNLS(staticDefaultValue));
    }
    stringBuffer.append(TEXT_89);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    if (genClass.getFlagIndex(genFeature) > 31 && genClass.getFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append("<< " + genClass.getFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getSafeName());
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_106);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) {
    if (genClass.getESetFlagIndex(genFeature) > 31 && genClass.getESetFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append("<< " + genClass.getESetFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_117);
    }
    }
    }
    //Class/declaredFieldGenFeature.override.javajetinc
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_119);
    for (GenFeature genFeature : genClass.getFlagGenFeatures("true")) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_127);
    }
    if (isImplementation && genModel.getFeatureDelegation() == GenDelegationKind.REFLECTIVE_LITERAL && (genClass.getClassExtendsGenClass() == null || genClass.getClassExtendsGenClass().getGenModel().getFeatureDelegation() != GenDelegationKind.REFLECTIVE_LITERAL)) {
    stringBuffer.append(TEXT_128);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genClass.getClassExtendsGenClass() == null ? 0 : genClass.getClassExtendsGenClass().getAllGenFeatures().size());
    stringBuffer.append(TEXT_131);
    }
    //Class/reflectiveDelegation.override.javajetinc
    new Runnable() { public void run() {
    for (GenFeature genFeature : (isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures())) {
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_132);
    if (!isImplementation) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_135);
    } else {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_138);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_143);
    } else {
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    if (!isImplementation) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    if (!isImplementation) {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_164);
    } else {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_166);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_168);
    } else {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    if (!isImplementation) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_177);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    if (!isImplementation) {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_189);
    } else {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_193);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_196);
    if (genFeature.isListType()) {
    if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
    stringBuffer.append(TEXT_197);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(keyFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_199);
    } else {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(keyFeature.getType());
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(valueFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_204);
    } else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(valueFeature.getType());
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType()))) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_209);
    }
    } else if (genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_211);
    }
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    stringBuffer.append(TEXT_213);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(reverseGenFeature.getFormattedName());
    stringBuffer.append(TEXT_217);
    }
    }
    stringBuffer.append(TEXT_218);
    if (!genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    if (genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_227);
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_228);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_230);
    }
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_232);
    }
    }
    if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_233);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genFeature.getRawImportedBoundType());
    stringBuffer.append(TEXT_235);
    }
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_238);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    }
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_241);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_242);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_243);
    }}
    stringBuffer.append(TEXT_244);
    //Class/getGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_245);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/getGenFeature.annotations.insert.javajetinc
    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_248);
    } else {
    if (genModel.useGenerics() && ((genFeature.isContainer() || genFeature.isResolveProxies()) && !genFeature.isListType() && !genModel.isReflectiveDelegation() && genFeature.isUncheckedCast() || genFeature.isListDataType() && genFeature.hasDelegateFeature())) {
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_252);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_253);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_254);
    }
    stringBuffer.append(TEXT_255);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_257);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_259);
    }
    stringBuffer.append(TEXT_260);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_267);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_271);
    } else {
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_275);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_276);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_279);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_287);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_297);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_298);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_302);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_305);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_306);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_313);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_316);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_318);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_324);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_325);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_330);
    }
    stringBuffer.append(TEXT_331);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_335);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_338);
    } else {
    stringBuffer.append(TEXT_339);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_340);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_347);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_350);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (genFeature.isFeatureMapType()) {
    String featureMapEntryTemplateArgument = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? "<" + genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap") + ".Entry>" : "";
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_351);
    stringBuffer.append(genFeature.getImportedEffectiveFeatureMapWrapperClass());
    stringBuffer.append(TEXT_352);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_355);
    stringBuffer.append(featureMapEntryTemplateArgument);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_357);
    } else {
    stringBuffer.append(TEXT_358);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(featureMapEntryTemplateArgument);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_362);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_366);
    } else {
    stringBuffer.append(TEXT_367);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_369);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_370);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_371);
    }
    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_373);
    }
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_377);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_378);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_379);
    }
    stringBuffer.append(TEXT_380);
    } else {
    stringBuffer.append(TEXT_381);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_382);
    }
    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_387);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_389);
    }
    stringBuffer.append(TEXT_390);
    }
    }
    } else {
    stringBuffer.append(TEXT_391);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_393);
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_394);
    if (genFeature.isMapType()) {
    stringBuffer.append(TEXT_395);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_396);
    } else {
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    }
    stringBuffer.append(TEXT_399);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_400);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_401);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/basicGetGenFeature.annotations.insert.javajetinc
    }
    stringBuffer.append(TEXT_402);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_404);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_407);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_410);
    } else {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_412);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_414);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_416);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_417);
    } else {
    stringBuffer.append(TEXT_418);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_421);
    }
    } else {
    stringBuffer.append(TEXT_422);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_424);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_425);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_426);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/basicSetGenFeature.annotations.insert.javajetinc
    }
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_432);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(TEXT_437);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_441);
    } else {
    stringBuffer.append(TEXT_442);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_445);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_446);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_447);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_449);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_451);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_455);
    } else {
    stringBuffer.append(TEXT_456);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_457);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_459);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_460);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_465);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_466);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_467);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_469);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_470);
    } else {
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_472);
    }
    stringBuffer.append(TEXT_473);
    } else {
    stringBuffer.append(TEXT_474);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_478);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_479);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_482);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    }
    stringBuffer.append(TEXT_485);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_486);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_491);
    } else {
    stringBuffer.append(TEXT_492);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_494);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_495);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_496);
    }
    } else {
    stringBuffer.append(TEXT_497);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_498);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_499);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_500);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_501);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_508);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_510);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_511);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_512);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_513);
    }
    }
    stringBuffer.append(TEXT_514);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_515);
    //Class/setGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_516);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/setGenFeature.annotations.insert.javajetinc
    }
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_519);
    } else {
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_523);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_524);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_525);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_527);
    }
    stringBuffer.append(TEXT_528);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_529);
    }
    stringBuffer.append(TEXT_530);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_547);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_548);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_553);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_554);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_555);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_559);
    }
    stringBuffer.append(TEXT_560);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_564);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_565);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_569);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_572);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_573);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_575);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_578);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_580);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_582);
    }
    stringBuffer.append(TEXT_583);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_585);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_586);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_587);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_588);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_589);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_590);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_591);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_594);
    }
    stringBuffer.append(TEXT_595);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_597);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_599);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_600);
    }
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_602);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_609);
    }
    stringBuffer.append(TEXT_610);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_611);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_615);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_616);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_617);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_618);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_621);
    }
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_627);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_628);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_629);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_630);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_631);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_632);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_634);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_635);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_636);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_637);
    } else {
    stringBuffer.append(TEXT_638);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_639);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_640);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_642);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_644);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_645);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_646);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_647);
    } else {
    stringBuffer.append(TEXT_648);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_649);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_650);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_651);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_652);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_653);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_655);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_656);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_657);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_658);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_659);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_661);
    }
    stringBuffer.append(TEXT_662);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_664);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_665);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_666);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_667);
    }
    stringBuffer.append(TEXT_668);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_669);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_670);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_673);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_674);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_675);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_676);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_677);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_678);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_679);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_680);
    } else {
    stringBuffer.append(TEXT_681);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_682);
    }
    stringBuffer.append(TEXT_683);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_684);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_687);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_688);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_689);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_690);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_691);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_692);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_693);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_694);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_695);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_698);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_699);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_700);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_701);
    }
    stringBuffer.append(TEXT_702);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_703);
    }
    stringBuffer.append(TEXT_704);
    } else {
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_707);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_708);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_709);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_710);
    }
    stringBuffer.append(TEXT_711);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_712);
    }
    stringBuffer.append(TEXT_713);
    }
    } else {
    stringBuffer.append(TEXT_714);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_715);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_716);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_717);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_718);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/basicUnsetGenFeature.annotations.insert.javajetinc
    }
    stringBuffer.append(TEXT_719);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_721);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_722);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_723);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_724);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_725);
    } else {
    stringBuffer.append(TEXT_726);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_727);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_728);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_729);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_730);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_731);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_732);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_733);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_734);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_738);
    } else {
    stringBuffer.append(TEXT_739);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_740);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_741);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_742);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_743);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_747);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_748);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_749);
    } else {
    stringBuffer.append(TEXT_750);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_751);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_752);
    } else {
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_754);
    }
    stringBuffer.append(TEXT_755);
    }
    } else {
    stringBuffer.append(TEXT_756);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_758);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_759);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_760);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_761);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_762);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_763);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_764);
    stringBuffer.append(TEXT_765);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_766);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_767);
    }
    stringBuffer.append(TEXT_768);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_769);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_770);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_771);
    stringBuffer.append(genFeature.getRawImportedBoundType());
    stringBuffer.append(TEXT_772);
    }
    stringBuffer.append(TEXT_773);
    //Class/unsetGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_774);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_776);
    } else {
    stringBuffer.append(TEXT_777);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_778);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_779);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_780);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_781);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_784);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_785);
    }
    stringBuffer.append(TEXT_786);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_787);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_790);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_791);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_795);
    }
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_797);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_798);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_799);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_801);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_802);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_803);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_805);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_807);
    }
    stringBuffer.append(TEXT_808);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_809);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_810);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_811);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_812);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_813);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_816);
    }
    stringBuffer.append(TEXT_817);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_819);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_820);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_821);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_822);
    }
    stringBuffer.append(TEXT_823);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_824);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_825);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_829);
    }
    stringBuffer.append(TEXT_830);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_831);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_832);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_833);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_835);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_836);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_837);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_838);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_839);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_840);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_841);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_842);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_843);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_844);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_845);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_846);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_848);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_849);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_850);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_851);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_852);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_853);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_854);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_856);
    } else {
    stringBuffer.append(TEXT_857);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_858);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_859);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_862);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_863);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_864);
    } else {
    stringBuffer.append(TEXT_865);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_866);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_867);
    } else {
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_869);
    }
    stringBuffer.append(TEXT_870);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_871);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_872);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_874);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_876);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_877);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_878);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_879);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_880);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_882);
    } else {
    stringBuffer.append(TEXT_883);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_884);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_885);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_888);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_889);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_890);
    stringBuffer.append(genFeature.getEDefault());
    } else {
    stringBuffer.append(TEXT_891);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_892);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_893);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_894);
    } else {
    stringBuffer.append(TEXT_895);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_896);
    }
    stringBuffer.append(TEXT_897);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_898);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_901);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_902);
    } else {
    stringBuffer.append(TEXT_903);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_905);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_906);
    }
    } else {
    stringBuffer.append(TEXT_907);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_908);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_909);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_910);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_911);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_912);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_913);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_914);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_915);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_917);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_918);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_919);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_920);
    }
    stringBuffer.append(TEXT_921);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_922);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_923);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_924);
    stringBuffer.append(genFeature.getRawImportedBoundType());
    stringBuffer.append(TEXT_925);
    }
    stringBuffer.append(TEXT_926);
    //Class/isSetGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_927);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/isSetGenFeature.annotations.insert.javajetinc
    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_928);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_929);
    } else {
    stringBuffer.append(TEXT_930);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_931);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_932);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_933);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_934);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_935);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_936);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_937);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_938);
    }
    stringBuffer.append(TEXT_939);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_940);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_942);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_943);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_944);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_945);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_946);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_948);
    } else {
    stringBuffer.append(TEXT_949);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_950);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_951);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_954);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_955);
    } else {
    stringBuffer.append(TEXT_956);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_958);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_959);
    }
    } else {
    stringBuffer.append(TEXT_960);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_961);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_962);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_963);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }//for
    }}.run();
    for (GenOperation genOperation : (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations())) {
    if (isInterface) {
    stringBuffer.append(TEXT_964);
    stringBuffer.append(TEXT_965);
    if (genOperation.hasDocumentation() || genOperation.hasParameterDocumentation()) {
    stringBuffer.append(TEXT_966);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_967);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    }
    for (GenParameter genParameter : genOperation.getGenParameters()) {
    if (genParameter.hasDocumentation()) { String documentation = genParameter.getDocumentation("");
    if (documentation.contains("\n") || documentation.contains("\r")) {
    stringBuffer.append(TEXT_968);
    stringBuffer.append(genParameter.getName());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(genParameter.getDocumentation(genModel.getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_970);
    stringBuffer.append(genParameter.getName());
    stringBuffer.append(TEXT_971);
    stringBuffer.append(genParameter.getDocumentation(genModel.getIndentation(stringBuffer)));
    }
    }
    }
    stringBuffer.append(TEXT_972);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_973);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_974);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_975);
    }}
    stringBuffer.append(TEXT_976);
    //Class/genOperation.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_977);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/genOperation.annotations.insert.javajetinc
    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_978);
    stringBuffer.append(genOperation.getTypeParameters());
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_979);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_980);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_981);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_982);
    } else {
    stringBuffer.append(TEXT_983);
    stringBuffer.append(genOperation.getTypeParameters());
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_984);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_985);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_986);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_987);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_988);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = genOperation.getGenParameters().get(0).getName(); String context = genOperation.getGenParameters().get(1).getName();
    stringBuffer.append(TEXT_989);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_990);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_994);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_995);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_998);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_1001);
    } else {
    stringBuffer.append(TEXT_1002);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_1003);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_1004);
    if (genModel.useGenerics()) {
    for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
    if (genFeature.isUncheckedCast()) {
    stringBuffer.append(TEXT_1005);
    break; }
    }
    }
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1006);
    }
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1010);
    for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1012);
    if (genFeature.isListType()) { String cast = "("  + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + (!genModel.useGenerics() ? ")" : "<" + genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject") + ">)(" + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + "<?>)");
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(cast);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(genFeature.getImportedMapTemplateArguments());
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1017);
    } else {
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cast);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1019);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_1020);
    if (genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1023);
    } else {
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1025);
    }
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1030);
    }
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1032);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1036);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1041);
    }
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1044);
    }
    }
    stringBuffer.append(TEXT_1045);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1046);
    } else {
    stringBuffer.append(TEXT_1047);
    }
    stringBuffer.append(TEXT_1048);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_1049);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1050);
    }
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1054);
    for (GenFeature genFeature : genClass.getEInverseRemoveGenFeatures()) {
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1056);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(genFeature.getImportedMapTemplateArguments());
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1061);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1065);
    } else {
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1068);
    }
    } else if (genFeature.isContainer() && !genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1070);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1072);
    } else {
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1074);
    }
    }
    stringBuffer.append(TEXT_1075);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1076);
    } else {
    stringBuffer.append(TEXT_1077);
    }
    stringBuffer.append(TEXT_1078);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_1079);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1080);
    }
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1083);
    for (GenFeature genFeature : genClass.getEBasicRemoveFromContainerGenFeatures()) {
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1087);
    }
    stringBuffer.append(TEXT_1088);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1089);
    } else {
    stringBuffer.append(TEXT_1090);
    }
    stringBuffer.append(TEXT_1091);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEGetGenFeatures())) {
    stringBuffer.append(TEXT_1092);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1093);
    }
    stringBuffer.append(TEXT_1094);
    for (GenFeature genFeature : genClass.getEGetGenFeatures()) {
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1096);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1098);
    } else {
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1101);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1104);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(genFeature.getImportedMapTemplateArguments());
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1109);
    } else {
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1112);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1116);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1120);
    } else {
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1122);
    }
    }
    stringBuffer.append(TEXT_1123);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1124);
    } else {
    stringBuffer.append(TEXT_1125);
    }
    stringBuffer.append(TEXT_1126);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1127);
    if (genModel.useGenerics()) {
    for (GenFeature genFeature : genClass.getESetGenFeatures()) {
    if (genFeature.isUncheckedCast() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_1128);
    break; }
    }
    }
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1129);
    }
    stringBuffer.append(TEXT_1130);
    for (GenFeature genFeature : genClass.getESetGenFeatures()) {
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1132);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1136);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1139);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(genFeature.getImportedMapTemplateArguments());
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1144);
    } else {
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1147);
    }
    } else {
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_1152);
    }
    stringBuffer.append(TEXT_1153);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1157);
    } else {
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1159);
    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType() || !genFeature.getRawType().equals(genFeature.getType())) {
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1161);
    }
    stringBuffer.append(TEXT_1162);
    }
    stringBuffer.append(TEXT_1163);
    }
    stringBuffer.append(TEXT_1164);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1165);
    } else {
    stringBuffer.append(TEXT_1166);
    }
    stringBuffer.append(TEXT_1167);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEUnsetGenFeatures())) {
    stringBuffer.append(TEXT_1168);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1169);
    }
    stringBuffer.append(TEXT_1170);
    for (GenFeature genFeature : genClass.getEUnsetGenFeatures()) {
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1172);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1175);
    } else {
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1177);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1179);
    } else if (!genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1182);
    } else {
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1185);
    }
    stringBuffer.append(TEXT_1186);
    }
    stringBuffer.append(TEXT_1187);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1188);
    } else {
    stringBuffer.append(TEXT_1189);
    }
    stringBuffer.append(TEXT_1190);
    //Class/eUnset.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEIsSetGenFeatures())) {
    stringBuffer.append(TEXT_1191);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1192);
    }
    stringBuffer.append(TEXT_1193);
    for (GenFeature genFeature : genClass.getEIsSetGenFeatures()) {
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1195);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1198);
    } else {
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1201);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1204);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1211);
    } else {
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1213);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1215);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1217);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1219);
    } else {
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1221);
    }
    }
    } else if (!genFeature.hasEDefault()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1223);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1225);
    } else {
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1227);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1231);
    } else {
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1234);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1238);
    } else {
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1241);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1246);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1256);
    } else {
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1261);
    }
    }
    }
    }
    stringBuffer.append(TEXT_1262);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1263);
    } else {
    stringBuffer.append(TEXT_1264);
    }
    stringBuffer.append(TEXT_1265);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1266);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1267);
    }
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_1269);
    for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1271);
    for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1274);
    }
    stringBuffer.append(TEXT_1275);
    }
    stringBuffer.append(TEXT_1276);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1277);
    }
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_1279);
    for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1281);
    for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1284);
    }
    stringBuffer.append(TEXT_1285);
    }
    stringBuffer.append(TEXT_1286);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1287);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1288);
    }
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1290);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1291);
    }
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1293);
    }
    { List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
    if (!eVirtualIndexBitFields.isEmpty()) { List<String> allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList<String>());
    stringBuffer.append(TEXT_1294);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1295);
    }
    stringBuffer.append(TEXT_1296);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1299);
    }
    stringBuffer.append(TEXT_1300);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1301);
    }
    stringBuffer.append(TEXT_1302);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1305);
    }
    stringBuffer.append(TEXT_1306);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1307);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_1308);
    }
    stringBuffer.append(TEXT_1309);
    { boolean first = true;
    for (GenFeature genFeature : genClass.getToStringGenFeatures()) {
    if (first) { first = false;
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1317);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1320);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1321);
    }
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1325);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1328);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1329);
    }
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_1334);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1337);
    } else {
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1339);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1340);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    String objectType = genModel.getImportedName("java.lang.Object");
    String keyType = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? keyFeature.getObjectType() : objectType;
    String valueType = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? valueFeature.getObjectType() : objectType;
    String eMapType = genModel.getImportedName("org.eclipse.emf.common.util.EMap") + (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? "<" + keyType + ", " + valueType + ">" : "");
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_1343);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1345);
    } else {
    stringBuffer.append(TEXT_1346);
    }
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_1348);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1349);
    if (!genModel.useGenerics()) {
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1351);
    }
    stringBuffer.append(TEXT_1352);
    } else if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
    stringBuffer.append(TEXT_1353);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1356);
    } else {
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1358);
    }
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(valueType);
    stringBuffer.append(TEXT_1360);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1362);
    } else {
    stringBuffer.append(TEXT_1363);
    }
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(valueType);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(valueType);
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(valueType);
    stringBuffer.append(TEXT_1367);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1368);
    if (!genModel.useGenerics()) {
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1370);
    }
    stringBuffer.append(TEXT_1371);
    } else if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
    stringBuffer.append(TEXT_1372);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1375);
    } else {
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1377);
    }
    stringBuffer.append(TEXT_1378);
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_1379);
    }
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(eMapType);
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(eMapType);
    stringBuffer.append(TEXT_1383);
    }
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_1385);
    return stringBuffer.toString();
  }
}
