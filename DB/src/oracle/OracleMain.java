package oracle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.mindrot.jbcrypt.BCrypt;

public class OracleMain {

	public static void main(String[] args) {
		try 
			/* Task1. 드라이버 연결. (어플리케이션 전체에서 딱 1번만 수행)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 클래스 로드 성공");
			
			// Taks2. 드라이버를 연결했으면 DB에 계정 접속을 하자
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@211.183.7.61:1521:xe","user05","user05");
			System.out.println("success");
			*/
		
			//Task another 1.2 - 스트림으로 읽어서 연결하게 하기
			(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./db.txt")))){
			String driverClass = br.readLine(); //.txt파일의 첫줄만 읽어오기
			//System.out.println(driverClass); ◀ 제대로 읽었는지 확인해보는 과정
			String url = br.readLine();
			String account = br.readLine();
			String pw = br.readLine();
			
			// 상단에 클래스를 로드하고 연결객체 생성 방법은 동일. 즉 하드 코딩을 피하는 것
			// 이렇게 코딩하면 나중에 db.txt 파일에서 필요한 정보만 바꾸면 소스를 굳이 다시 고칠 필요가 없다!
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, account, pw);
			//System.out.println("success"); ◀ 제대로 연결 됐는지 확인해보는 과정
			
			
			/* Task3. 실제 데이터 삽입하기
			PreparedStatement pst = con.prepareStatement("insert into MD(num, code, itemname, price, quantity, transdate, userid)"
					+ "values(?,?,?,?,?,?,?)");
			
			pst.setInt(1, 1);
			pst.setString(2, "k101");
			pst.setString(3, "종합비타민");
			pst.setInt(4, 30000);
			pst.setInt(5, 1);
			
			// 3.1날짜를 만드는게 조금 과정이 많으니 잘봐두자
			Calendar cal = new GregorianCalendar(2020, 0, 31, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());  //SQL의 date를 import해야하는것 주의하자
			pst.setDate(6, transdate);
			
			pst.setString(7, "for486ses");
			
			
			//3.2. 삽입이 제대로 됐는지 확인 해봐야 한다.
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("insert completed");
			}
			else {
				System.err.println("insert error");
			}
			pst.close(); // 3.3. 사용했으면 pst 닫아주기
			*/
			
			/*Task4. 들어간 데이터 수정하기
			PreparedStatement pst = con.prepareStatement("update MD set price=?"
					+ "where num =?");
			
			pst.setInt(1, 32151);
			pst.setInt(2,1);
			
			
			//4.2. 수정이 제대로 됐는지 확인 해봐야 한다.
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("update completed");
			}
			else {
				System.err.println("update error");
			}
			pst.close(); // 4.3. 사용했으면 pst 닫아주기
			*/
			
			/*Task5. 들어간 데이터 삭제하기
			PreparedStatement pst = con.prepareStatement("delete from MD where num=?");
			pst.setInt(1,1);
			
			//5.1. 생성자 구문이 sql과 제일 유사. 기본키로만 지우면 된다.
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("delete completed");
			}
			else {
				System.err.println("update error");
			}
			pst.close(); // 5.2. 사용했으면 pst 닫아주기
			
			con.close();
			*/
			
			/* Task6. 암호화 해서 데이터 집어 넣기
			PreparedStatement pst = con.prepareStatement("insert into MD(num, code, itemname, price, quantity, transdate, userid)"
					+ "values(?,?,?,?,?,?,?)");
			
			pst.setInt(1, 1);
			pst.setString(2, "k101");
			pst.setString(3, BCrypt.hashpw("바다", BCrypt.gensalt())); //6.1공간이 64자리 이상인게 이거뿐이라 이거만 암호화 가능
			pst.setInt(4, 30000);
			pst.setInt(5, 1);
			
			Calendar cal = new GregorianCalendar(2020, 0, 31, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());  
			pst.setDate(6, transdate);
			
			pst.setString(7, "for486ses");
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("insert completed");
			}
			else {
				System.err.println("insert error");
			}
			pst.close(); 
			*/
			
			/*Task7. 암호화된 데이터 데이터 비교하기 (패스워드 조회하기에 쓰임)
			System.out.println(BCrypt.checkpw("터미네이터", BCrypt.hashpw("터미네이터", BCrypt.gensalt())));
			System.out.println(BCrypt.checkpw("터미네이터1", BCrypt.hashpw("터미네이터", BCrypt.gensalt())));
			System.out.println(BCrypt.hashpw("터미네이터", BCrypt.gensalt())); //이 라이브러리를 쓰면 이렇게 찍힌다
			System.out.println(BCrypt.hashpw("터미네이터", BCrypt.gensalt())); //두 개가 사람이 보면 다르게 생겼지만 실제로는 같은 값이다.
			// 나름의 알고리즘으로 값을 바꿔 버린 것
			 */
			
			/*Task8. 유효성 검사
			//데이터베이스에 데이터를 저장하거나 수정할 때 사용 할 수 없는 단어를 확인해서 저장하거나 수정해야 한다.
			//특히 SQL 예약어는 확인해서 데이터로 사용하지 못하도록 해야 한다.
			
			String [ ] stop_words = {"or", "and"};
			
			PreparedStatement pst = con.prepareStatement("insert into MD(num, code, itemname, price, quantity, transdate, userid)"
					+ "values(?,?,?,?,?,?,?)");
			
			pst.setInt(1, 1);
			
			String str = "orapple";
			
			// indexOf는 temp가 몇번째 있는지 검색해주는 메소드
			// 찾으면 찾은 위치를 리턴하고 없다면 -1을 리턴한다.
			for (String temp : stop_words) {
				if(str.indexOf(temp)>=0) {
					System.out.println("사용할 수 없는 단어가 포함되어 있습니다.");
					//return; 이렇게 하면 작업을 안해버리고 다시 입력을 받겠다는 UI에서 사용
					str= str.replace(temp, ""); //만약 이렇게 해버리면 ""안에 들어가는 문자열로 치환해버리겠다는 것(하면 안될것 같음)
				}
			}		
			pst.setString(2, str);
			pst.setString(3, "종합비타민");
			pst.setInt(4, 30000);
			pst.setInt(5, 1);
			
			Calendar cal = new GregorianCalendar(2020, 0, 31, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());  //SQL의 date를 import해야하는것 주의하자
			pst.setDate(6, transdate);
			
			pst.setString(7, "for486ses");
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("insert completed");
			}
			else {
				System.err.println("insert error");
			}
			pst.close(); 
			*/
			con.setAutoCommit(false);// commit을 만나거나 DDL, DCL을 성공할때까지 DB에 반영이 안된다.
			PreparedStatement pst = con.prepareStatement("insert into MD(num, code)"
					+ "values(?,?)");
			
			pst.setInt(1, 3);
			pst.setString(2, "푸른밤2");
			
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("insert completed");
			}
			else {
				System.err.println("insert error");
			}
			pst.close(); 
			
			pst.setInt(1, 4);
			pst.setString(2, "푸른밤3");
			
			result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("insert completed");
			}
			else {
				System.err.println("insert error");
			}
			pst.close(); 
			
			con.commit();
			
			
		}catch(Exception e) {
			System.err.println("에러 발생 : " + e.getMessage());
			e.printStackTrace();
		}
		

	}

}
