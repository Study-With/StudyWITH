package swteam;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
 import java.sql.SQLException; 
 import java.sql.Statement; 
 import java.sql.*;
 
 
 public class DBA1 {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // jdbc ����̹� �ּ�
	 static final String DB_URL = "jdbc:mysql://localhost:3306/gnb/post"; 
	 //db url
	 //url�Ű�������.. jdbc:mysql:subname 
	 //subname�� ������ ���̽��� �̸�.
	 //���� ��ǻ�Ϳ� �ִ� db���.... //localhost:3306/gnb
	 //localhost�� �����Ϸ��� �����ͺ��̽� �ּҸ� �Է��Ͻø� �˴ϴ�. localhost�� ����ϸ� �˴ϴ�.
	 //3306�� �����ͺ��̽��� �����Ҷ� ����ϴ� ���͹�ȣ�Դϴ�. ��ġ�Ҷ� ������ ��Ʈ��ȣ�� ����մϴ�.
	 //databasename���� �����Ϸ��� database�� name�� �Է����ݴϴ�. _gnb
	 
	 static final String USERNAME = "root"; // DB ID
	 static final String PASSWORD = "qmffld99@"; // DB Password
	 
		public static void main(String[] args) {
			
			// MySql�� ����ϴ¿��� ��ü�� ������ݴϴ�.
			Connection conn = null; //db����
			Statement stmt = null;
			ResultSet rs = null;
			
			System.out.print("User Table ���� : ");
			
			try {
				Class.forName(JDBC_DRIVER); 
				//jdbc_driver�� �ڹٰ� db�� ������ �� �ְ��ϴ� ����̹�.
				//Class Ŭ������ forName()�Լ��� �̿� -> JDBC_DRIVER(jdbc driver �ּ�)�� ���α׷� ������ load.
				System.out.println("����̹� load ����");
				
				conn = DriverManager.getConnection(DB_URL,"root","qmffld99@"); 
				//db�� ����
				//DriverManagerŬ������ getConnection()�� ȣ�� -> db�� ����
				//URL, ID, password�� �Է��Ͽ� �����ͺ��̽��� �����մϴ�.
				System.out.println("�����ͺ��̽� ���� ����");
				
				// ���Ӱ���� ����մϴ�.
				if (conn != null){System.out.println("����");}
				else{System.out.println("����");}	
			}
			
			
			catch (ClassNotFoundException e) { //forName()�� ClassNotFoundException�� �߻���ų �� ����.
				e.printStackTrace();
			}  d
			
			
            catch (SQLException e) { //getconnection()�� SQLException�� �߻���ų �� ����.
				System.out.println("SQL Exception : " + e.getMessage());
				e.printStackTrace();
			}	

		}

	}


	

		 

