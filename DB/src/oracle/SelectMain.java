package oracle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectMain {

	public static void main(String[] args) {
		try
		(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./db.txt")))) {
			String driverClass = br.readLine();
			String url = br.readLine();
			String account = br.readLine();
			String pw = br.readLine();

			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, account, pw);
			PreparedStatement pst = con.prepareStatement("select * from MD");
			ResultSet rs = pst.executeQuery();
			
			/*
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			
			
			while(rs.next()) {
				Map <String, Object> map = new HashMap<String, Object>();
				map.put("num", rs.getInt("num"));
				map.put("code", rs.getString("code"));
				map.put("itemname", rs.getString(3));
				map.put("price", rs.getInt("price"));
				map.put("quantity", rs.getInt("quantity"));
				map.put("transdate", rs.getDate("transdate"));
				map.put("userid", rs.getString("userid"));
				
				// 하나의 행을 list에 저장
				list.add(map);
			}
				//list 데이터 출력
				for(Map <String, Object> map1:list) {
					System.out.println(map1.get("num"));
				}
				*/
			
			//DTO 클래스를 이용해서 리스트를 만드는 방법
			List <MD> list = new ArrayList<MD>();
			
			while (rs.next()) {
				
				MD md = new MD(); // 생성자를 그냥 바깥에 만들어 버리면 딱 한 번만 만들어버리기 때문에 결과가 하나만 나온다.
				// while문을 도는 동안 계속 생성해주는 구조가 되어야한다 << 특이하니까 기억해두자
				
				md.setNum(rs.getInt("num"));
				md.setCode(rs.getString("code"));
				md.setItemname(rs.getString("Itemname"));
				md.setPrice(rs.getInt("price"));
				md.setQuantity(rs.getInt("quantity"));
				md.setTransdate(rs.getDate("transdate"));
				md.setUserid(rs.getString("userid"));
				
				list.add(md);
				
			}

			for(MD md : list) {
				System.out.println(md);
				//필요한것만 뽑고 싶다면..?
				//System.out.println(md.getNum() + ":" + md.getItemname()); 이런식으로 뽑아내면 된다!
			}

				
				rs.close();
				pst.close();
				con.close();
			}catch(Exception e) {
				System.err.println("에러 발생 : " + e.getMessage());
				e.printStackTrace();
			}
			

		}

	}
