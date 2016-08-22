package com.sds.db;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.	PreparedStatement;
import java.sql.ResultSet;

class MemberAPP{
	String url="jdbc:mariadb://localhost:3306/iot";
	String user="root";
	String password="";
	
	Connection con;//���� ��, �� ���� ������ ������ ��ü!!
	PreparedStatement pstmt;//���� ���� ��ü!
	ResultSet rs;//���̺��� ������ ������ ��ü!!

	public MemberAPP(){
		
		try{
			//mariadb�� jdbc ����̹�(static ����) �ε�!
			Class.forName("org.mariadb.jdbc.Driver");

			//mariadb�� ��������!!
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				System.out.println("���� ����");
				
				//select���� ������ ����!
				String sql="select * from member2";
				pstmt=con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();//������ ������ ����ޱ�!!
				
				while(rs.next()){
					System.out.println("�̸�"+rs.getString("name")+",����"+rs.getInt("age"));
				}

			}else{
				System.out.println("���� ����");		
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
			
				rs.close();
			}catch(SQLException e){
			
			}
		}
			if(rs!=null){
				try(con!=null){
					try(){
						rs.close();
					}catch(SQLException e){
					
					}

				
				}
			}
		}
	}
	public static void main(String[] args){
		//��ȸ�ϱ�(select)
		new MemberAPP();		
		
	}
}
