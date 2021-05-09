/*
 * package com.uiFramework.KTCTC.helper.excel;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.FileNotFoundException; import java.io.IOException; import
 * java.util.ArrayList; import java.util.HashMap;
 * 
 * import org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class BotExcelReader { private XSSFSheet sh = null; private XSSFRow
 * row = null; private XSSFCell cel = null; private int numOfRow =0; public
 * BotExcelReader(String excelName, String sheetName) { File f = new
 * File(System.getProperty("user.dir") + "\\Resources\\ExcelFiles\\"+excelName);
 * 
 * FileInputStream fis = null; try { fis = new FileInputStream(f); } catch
 * (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * XSSFWorkbook workbook = null; try { workbook = new XSSFWorkbook(fis); } catch
 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * XSSFSheet sh = workbook.getSheet(sheetName); numOfRow = sh.getLastRowNum();
 * 
 * 
 * }
 * 
 * public ArrayList<Object> getAllKeysListFromExcel() {
 * 
 * 
 * ArrayList<Object> keys = new ArrayList<>(); for (int i=1;i<=numOfRow;i++) {
 * row = sh.getRow(i); cel = row.getCell(0); Object data1 =
 * getCellValueFromCel(cel); keys.add(data1);
 * 
 * } return keys; }
 * 
 * public ArrayList<Object> getAllValuesFromExcel() { ArrayList<Object> value =
 * new ArrayList<>(); for (int i=1;i<=numOfRow;i++) { row = sh.getRow(i); cel =
 * row.getCell(1); Object data1 = getCellValueFromCel(cel); value.add(data1);
 * 
 * } return value;
 * 
 * } public HashMap<Object,Object> getKeyValuePairFromExcel1() { Object key =
 * null; Object value = null; HashMap<Object, Object> data = new HashMap<>();
 * 
 * for (int i =1;i<=numOfRow;i++) { row = sh.getRow(i);
 * 
 * for (int j=0;j<=1;j++) { cel = row.getCell(j); if (j<1) { key =
 * getCellValueFromCel(cel); } else { value = getCellValueFromCel(cel); }
 * 
 * } data.put(key, value);
 * 
 * 
 * }
 * 
 * 
 * return data;
 * 
 * }
 * 
 * public HashMap<Object,Object> getKeyValuePairFromExcel() { ArrayList<Object>
 * keys = getAllKeysListFromExcel(); ArrayList<Object> values =
 * getAllValuesFromExcel(); HashMap<Object, Object> data = new HashMap<>(); for
 * (int i =0;i<keys.size();i++) { data.put(keys.get(i), values.get(i));
 * 
 * }
 * 
 * 
 * return data;
 * 
 * }
 * 
 * 
 * 
 * private Object getCellValueFromCel(XSSFCell cel) { Object data = null; switch
 * (cel.getCellType()) { case STRING: data = cel.getStringCellValue(); break;
 * case BOOLEAN: data = cel.getBooleanCellValue(); break; case NUMERIC: data =
 * cel.getNumericCellValue(); break; case FORMULA: data = cel.getCellFormula();
 * break; case BLANK: data = "Blank"; break;
 * 
 * default: data = "Blank"; break; } return data;
 * 
 * }
 * 
 * }
 */