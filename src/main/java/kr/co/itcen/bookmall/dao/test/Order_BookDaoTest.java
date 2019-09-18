package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDaoTest {

	public static void main(String[] args) {
		
		insertTest();
		selectTest();

	}
	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		Order_BookDao dao = new Order_BookDao();
		Order_BookVo vo1 = new Order_BookVo();

		vo1.setOrderNumber(1);
		vo1.setBookNumber(3);
		vo1.setAmount(19992);
		
		dao.insert(vo1);
		System.out.println(vo1);
		
		Order_BookVo vo2 = new Order_BookVo();

		vo2.setOrderNumber(1);
		vo2.setBookNumber(2);
		vo2.setAmount(10010);
		
		dao.insert(vo2);
		System.out.println(vo2);
	}

	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		Order_BookDao dao = new Order_BookDao();
		ArrayList list = dao.getList();
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}



