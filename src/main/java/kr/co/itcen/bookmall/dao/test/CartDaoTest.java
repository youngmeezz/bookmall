package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

		public static void main(String[] args) {

			insertTest();
			selectTest();
			//deleteAllTest();
			//updateTest(1, "사람은 무엇으로 사는가");
		}

		


//		private static void updateTest(int book_id, String name) {
//			// TODO Auto-generated method stub
//
//			System.out.println("update test---------------------------------------------------------");
//			
//			BookDao dao = new BookDao();
//			dao.update(book_id, name);
//			
//			List<BookVo> list = dao.getList();
//
//			for (BookVo vo : list) {
//				System.out.println(vo);
//			}
//			
//		}


		private static void deleteAllTest() {
			
			new CartDao().delete();
			
		}
		
		public static void insertTest() {

			System.out.println("insert test---------------------------------------------------------");
			
			CartDao dao = new CartDao();

			CartVo vo1 = new CartVo();
			
			vo1.setBookNumber(10);
			vo1.setUser_id((long) 5);
			vo1.setCount(12311);
			
			
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
