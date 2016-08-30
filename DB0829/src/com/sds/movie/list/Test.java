package com.sds.movie.list;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;//쿼리문을 담당!!
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE"
					,"java0819"
					,"java0819");
			System.out.println(con);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		File file=new File("c:/MovieDB.xlsx");
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			
			//열린 파일에 대해 sheet를 접근해보자!!
			XSSFSheet moive=workbook.getSheet("movie");
			int total=moive.getPhysicalNumberOfRows();
		
			
			for(int i=1; i<total; i++){
				XSSFRow row=moive.getRow(i);
				
				//하나의 레코드가 완료되는 시점!!
				String sql="insert into movie(movie_id, title, genre_id, showtime, openday,img)";
				sql=sql+"values(seq_movie.nextval,?,?,?,?,?)";
				
				try {
					pstmt=con.prepareStatement(sql);
					for(int a=0; a<5; a++){
						XSSFCell cell=row.getCell(a);
						
						if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING){
							
							pstmt.setString(a+1, cell.getStringCellValue());
						}else if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
							pstmt.setInt(a+1, (int)cell.getNumericCellValue());
						}
					}
					System.out.println(sql);
					pstmt.executeUpdate();//쿼리문 수행!!
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
