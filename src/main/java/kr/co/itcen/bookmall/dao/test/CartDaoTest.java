package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

		public static void main(String[] args) {

			insertTest();
			selectTest();
		
		}

	
		public static void insertTest() {

			System.out.println("insert test---------------------------------------------------------");
			
			CartDao dao = new CartDao();

			CartVo vo1 = new CartVo();
			
			//vo1.setNo((long) 1);
			//vo1.setBook_no(10);
			vo1.setCount(12);
			vo1.setPrice(1000);
			vo1.setUser_no(1);;
			vo1.setBook_no(2);
			
			
			dao.insert(vo1);
			System.out.println(vo1);

		}

		private static void selectTest() {

			System.out.println("select test---------------------------------------------------------");
			CartDao dao = new CartDao();
			List<CartVo> list = dao.getList();

			for (CartVo vo : list) {
				System.out.println(vo);
			}
		}
	}
