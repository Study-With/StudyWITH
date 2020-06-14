package swteam;
import java.sql.Connection; //db연결할 때 필요
import java.sql.DriverManager; //드라이버 구동시 필요
import java.sql.ResultSet; 
 import java.sql.SQLException; //예외처리시 필요
 import java.sql.Statement; 
 import java.sql.*;
 
 
 public class DBA2 { //db에서 데이터 들고오기
    public static Connection makeConnection() {
       
     String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // jdbc 드라이버 주소
     String DB_URL = "jdbc:mysql://localhost:3306/book_db";  //안돼면 ? 빼기.
    //db url
    //url매개변수는.. jdbc:mysql:subname 
    //subname은 데이터 베이스의 이름.
    //로컬 컴퓨터에 있는 db라면.... //localhost:3306/
    //localhost는 접속하려는 데이터베이스 주소를 입력하시면 됩니다. localhost를 사용하면 됩니다.
    //3306은 데이터베이스에 접속할때 사용하는 포터번호입니다. 설치할때 설정한 포트번호를 사용합니다.
    //databasename에는 접속하려는 database의 name을 입력해줍니다.
    
     String USERNAME = "root"; // DB ID
     String PASSWORD = "qmffld99@"; // DB Password
    
         
         // MySql에 사용하는여러 객체를 만들어줍니다.
         Connection conn = null; //db연결
         Statement stmt = null;
         ResultSet rs = null;
         
         //System.out.print("User Table 접속 : ");
         
         try {
            Class.forName(JDBC_DRIVER); 
            //jdbc_driver는 자바가 db에 접근할 수 있게하는 드라이버.
            //Class 클래스의 forName()함수를 이용 -> JDBC_DRIVER(jdbc driver 주소)를 프로그램 안으로 load.
            System.out.println("드라이버 load 성공");
            
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
            //db에 연결
            //DriverManager클래스의 getConnection()을 호출 -> db에 연결
            //URL, ID, password를 입력하여 데이터베이스에 접속합니다.
            System.out.println("데이터베이스 연결 성공");
            
            /*// 접속결과를 출력합니다.
            if (conn != null){System.out.println("성공");}
            else{System.out.println("실패");} */   
         }
         
         
         catch (ClassNotFoundException e) {//forName()은 ClassNotFoundException을 발생시킬 수 있음.
            System.out.println("드라이버 찾을 수 없음.");
            e.printStackTrace();
         }  
         
         
            catch (SQLException e) { //getconnection()은 SQLException을 발생시킬 수 있음.
            System.out.println("db 연결에 실패.");
            e.printStackTrace();
         }  
         
         return conn; 
      
    public static void main(String arg[]) throws SQLException { //main 함수
       Connection conn = makeConnection();  //db연결
       Statement stmt = conn.createStatement(); //db연결한것에 문장객체 생성
       ResultSet rs = stmt.executeQuery("SELECT * FROM books"); 
       //executeQuery는 query문 실행.
       //SELECT 문장은 쿼리(query)
       //SELECT 칼럼이름 FROM 테이블이름 (WHERE 조건) (ORDER BY 정렬방식) 
       //(),()는 필수는 아님.
       //SELECT 명령어 결과로 나오는 레코드의 집합 = Resultset rs (결과집합) 
       //반환된 ResultSet에는 추출된 모든 레코드가 들어있음.
       //하지만 우리는 한번에 하나의 레코드만 접근가능. 커서를 이용해서 접근.
       
       while (rs.next()) { //레코드 하나씩 처리.
    	   int id = rs.getInt("book_id");//getxxx는 레코드에서 칼럼값을 추출하는 메소드.
    	   //결과집합 rs에서 book_id를 하나씩 들고 온다 -> id에 저장.
    	   String title = rs.getString("title"); 
    	   //결과집합 rs에서 tilte를 하나씩 들고 온다 -> title(변수 이름)에 저장한다. 
    	   System.out.println(id + " " + title);
    	   //id 랑 title을 print 한다.
       }
       
      }

   }


