package swteam;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
 import java.sql.SQLException; 
 import java.sql.Statement; 
 
 public class DBA {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // jdbc ����̹� �ּ� 
	 static final String DB_URL = "jdbc:mysql://localhost:3306/gnb?useSSL=false"; // DB ���� �ּ� 
	 //localhost�� �����Ϸ��� �����ͺ��̽� �ּҸ� �Է��Ͻø� �˴ϴ�. localhost�� ����ϸ� �˴ϴ�.
	 //3306�� �����ͺ��̽��� �����Ҷ� ����ϴ� ���͹�ȣ�Դϴ�. ��ġ�Ҷ� ������ ��Ʈ��ȣ�� ����մϴ�.
	 //databasename���� �����Ϸ��� database�� name�� �Է����ݴϴ�. _gnb
	 
	 static final String USERNAME = "root"; // DB ID
	 static final String PASSWORD = "root"; // DB Password
	 
		public static void main(String[] args) {
			
			// MySql�� ����ϴ¿��� ��ü�� ������ݴϴ�.
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			System.out.print("User Table ���� : ");
			try {
				Class.forName(JDBC_DRIVER); //Class Ŭ������ forName()�Լ��� �̿��ؼ� �ش� Ŭ������ �޸𸮷� �ε� �ϴ� ���Դϴ�.
				//URL, ID, password�� �Է��Ͽ� �����ͺ��̽��� �����մϴ�.
				conn = DriverManager.getConnection(DB_URL,"root","root"); 
				
				// ���Ӱ���� ����մϴ�.
				if (conn != null){System.out.println("����");}
				else{System.out.println("����");}	
			}
			
			catch (ClassNotFoundException e) {
				System.out.println("Class Not Found Exection");
				e.printStackTrace();
			} 
			
            catch (SQLException e) {
				System.out.println("SQL Exception : " + e.getMessage());
				e.printStackTrace();
			}	

		}

	}


	

		 
