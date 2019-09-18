package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;


public class UserDaoTest {

	public static void main(String[] args) {

		insertTest();
		selectTest();
	
	}
	

	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		UserDao dao = new UserDao();
		UserVo vo1 = new UserVo();
		
		vo1.setUserName("김모모");
		vo1.setPhoneNumber("010-2032-2931");
		vo1.setEmail("sjke321@gmail.com");
		vo1.setPassword("129sdf");
		
		dao.insert(vo1);
		System.out.println(vo1);
		
		
		UserVo vo2 = new UserVo();
		
		vo2.setUserName("강모모");
		vo2.setPhoneNumber("010-1922-8219");
		vo2.setEmail("krkjd121@gmail.com");
		vo2.setPassword("129aedf");
		
		dao.insert(vo2);
		System.out.println(vo2);
		

	}
	
	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();

		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}
}
