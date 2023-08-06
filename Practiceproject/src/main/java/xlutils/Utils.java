package xlutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utils {
	public static FileInputStream fi;
	public static FileOutputStream fo ;
	public static Workbook wb ;
	public static Sheet sht ; 
	public static Row row;
	public static Cell cvalue;
	public static Cell cell;
	public static CellStyle style ;
	

	
		public static int getrowcount (String File , String Sheet) throws IOException {
		 fi = new FileInputStream(File);
		 wb = new XSSFWorkbook(fi); 
		sht =  wb.getSheet(Sheet);
		 int rowcount  = sht.getLastRowNum();
		 fi.close();
		 wb.close();
		 return rowcount ;
		 
		}
		
		public static int getcolumnconut(String File, String Sheet, int rownum) throws IOException {
			 fi = new FileInputStream(File);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(Sheet);
		    row = sht.getRow(rownum);
		    short colnum  =  row.getLastCellNum();
		    fi.close();
			wb.close();
			return colnum; 
		}
		
		
		public static String getstringdata(String File, String Sheet, int rownum, int colnum) throws IOException {
			 fi = new FileInputStream(File);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(Sheet);
		    row = sht.getRow(rownum);
		    String data;
		    try {
		    	 cvalue =  row.getCell(colnum);
		  	   data  =  cvalue.getStringCellValue();
				
			} catch (Exception e) {
				data = " ";
				System.out.println("Empty data ");
			}
		 
		   return data; 
			
			
		}

		public static boolean  getbooldata(String File, String Sheet, int rownum, int colnum) throws IOException {
			 fi = new FileInputStream(File);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(Sheet);
		    row = sht.getRow(rownum);
		   boolean res;
		    try {
		    	 cvalue =  row.getCell(colnum);
		  	   res  =  cvalue.getBooleanCellValue();
				
			} catch (Exception e) {
				res = false;
				
			}
		 
		   return res; 
	}
		
		
		
		public static double  getNumdata(String File, String Sheet, int rownum, int colnum) throws IOException {
			 fi = new FileInputStream(File);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(Sheet);
		    row = sht.getRow(rownum);
		   double res;
		    try {
		    	 cvalue =  row.getCell(colnum);
		  	   res  =  cvalue.getNumericCellValue();
				
			} catch (Exception e) {
				res = 0.0;
			}
		    fi.close();
		   return res; 
	}
		
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
			 fi = new FileInputStream(xlfile);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(xlsheet);
		    row = sht.getRow(rownum);
		    cell = row.createCell(colnum);
		    cell.setCellValue(data);
		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
			wb.close();
			fi.close();
			fo.close();	
		    
		}
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,boolean data) throws IOException {
			 fi = new FileInputStream(xlfile);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(xlsheet);
		    row = sht.getRow(rownum);
		    cell = row.createCell(colnum);
		    cell.setCellValue(data);
		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
			wb.close();
			fi.close();
			fo.close();	
		
		}
		
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,double data) throws IOException {
			 fi = new FileInputStream(xlfile);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(xlsheet);
		    row = sht.getRow(rownum);
		    cell = row.createCell(colnum);
		    cell.setCellValue(data);
		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
			wb.close();
			fi.close();
			fo.close();	
	}
		
		public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
			 fi = new FileInputStream(xlfile);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(xlsheet);
		    row = sht.getRow(rownum);
			cell = row.getCell(colnum);
	        style =  wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        cell.setCellStyle(style);
	        fo = new FileOutputStream(xlfile);
		    wb.write(fo);
			wb.close();
			fi.close();
			fo.close();	
	        
			
		}
		
		public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
			 fi = new FileInputStream(xlfile);
			 wb = new XSSFWorkbook(fi); 
			sht =  wb.getSheet(xlsheet);
		    row = sht.getRow(rownum);
			cell = row.getCell(colnum);
	       style =  wb.createCellStyle();
	       style.setFillForegroundColor(IndexedColors.RED.getIndex());
	       style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	       cell.setCellStyle(style);
	       fo = new FileOutputStream(xlfile);
		    wb.write(fo);
			wb.close();
			fi.close();
			fo.close();	
		
	}


}
