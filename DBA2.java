package swteam;
import java.sql.Connection; //db������ �� �ʿ�
import java.sql.DriverManager; //����̹� ������ �ʿ�
import java.sql.ResultSet; 
 import java.sql.SQLException; //����ó���� �ʿ�
 import java.sql.Statement; 
 import java.sql.*;
 
 
 public class DBA2 { //db���� ������ ������
    public static Connection makeConnection() {
       
     String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // jdbc ����̹� �ּ�
     String DB_URL = "jdbc:mysql://localhost:3306/book_db";  //�ȵŸ� ? ����.
    //db url
    //url�Ű�������.. jdbc:mysql:subname 
    //subname�� ������ ���̽��� �̸�.
    //���� ��ǻ�Ϳ� �ִ� db���.... //localhost:3306/
    //localhost�� �����Ϸ��� �����ͺ��̽� �ּҸ� �Է��Ͻø� �˴ϴ�. localhost�� ����ϸ� �˴ϴ�.
    //3306�� �����ͺ��̽��� �����Ҷ� ����ϴ� ���͹�ȣ�Դϴ�. ��ġ�Ҷ� ������ ��Ʈ��ȣ�� ����մϴ�.
    //databasename���� �����Ϸ��� database�� name�� �Է����ݴϴ�.
    
     String USERNAME = "root"; // DB ID
     String PASSWORD = "qmffld99@"; // DB Password
    
         
         // MySql�� ����ϴ¿��� ��ü�� ������ݴϴ�.
         Connection conn = null; //db����
         Statement stmt = null;
         ResultSet rs = null;
         
         //System.out.print("User Table ���� : ");
         
         try {
            Class.forName(JDBC_DRIVER); 
            //jdbc_driver�� �ڹٰ� db�� ������ �� �ְ��ϴ� ����̹�.
            //Class Ŭ������ forName()�Լ��� �̿� -> JDBC_DRIVER(jdbc driver �ּ�)�� ���α׷� ������ load.
            System.out.println("����̹� load ����");
            
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
            //db�� ����
            //DriverManagerŬ������ getConnection()�� ȣ�� -> db�� ����
            //URL, ID, password�� �Է��Ͽ� �����ͺ��̽��� �����մϴ�.
            System.out.println("�����ͺ��̽� ���� ����");
            
            /*// ���Ӱ���� ����մϴ�.
            if (conn != null){System.out.println("����");}
            else{System.out.println("����");} */   
         }
         
         
         catch (ClassNotFoundException e) {//forName()�� ClassNotFoundException�� �߻���ų �� ����.
            System.out.println("����̹� ã�� �� ����.");
            e.printStackTrace();
         }  
         
         
            catch (SQLException e) { //getconnection()�� SQLException�� �߻���ų �� ����.
            System.out.println("db ���ῡ ����.");
            e.printStackTrace();
         }  
         
         return conn; 
      
    public static void main(String arg[]) throws SQLException { //main �Լ�
       Connection conn = makeConnection();  //db����
       Statement stmt = conn.createStatement(); //db�����ѰͿ� ���尴ü ����
       ResultSet rs = stmt.executeQuery("SELECT * FROM books"); 
       //executeQuery�� query�� ����.
       //SELECT ������ ����(query)
       //SELECT Į���̸� FROM ���̺��̸� (WHERE ����) (ORDER BY ���Ĺ��) 
       //(),()�� �ʼ��� �ƴ�.
       //SELECT ��ɾ� ����� ������ ���ڵ��� ���� = Resultset rs (�������) 
       //��ȯ�� ResultSet���� ����� ��� ���ڵ尡 �������.
       //������ �츮�� �ѹ��� �ϳ��� ���ڵ常 ���ٰ���. Ŀ���� �̿��ؼ� ����.
       
       while (rs.next()) { //���ڵ� �ϳ��� ó��.
    	   int id = rs.getInt("book_id");//getxxx�� ���ڵ忡�� Į������ �����ϴ� �޼ҵ�.
    	   //������� rs���� book_id�� �ϳ��� ��� �´� -> id�� ����.
    	   String title = rs.getString("title"); 
    	   //������� rs���� tilte�� �ϳ��� ��� �´� -> title(���� �̸�)�� �����Ѵ�. 
    	   System.out.println(id + " " + title);
    	   //id �� title�� print �Ѵ�.
       }
       
      }

   }


