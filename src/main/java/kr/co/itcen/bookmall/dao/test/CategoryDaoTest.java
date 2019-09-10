package kr.co.itcen.bookmall.dao.test;

import java.util.List;


import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
		//insertTest();
		selectTest();
//		deleteAllTest();
	}

	
//	private static void deleteAllTest() {
//		
//		new ArtistDao().delete();
//		
//	}
	
//	public static void insertTest() {
//
//		System.out.println("insert test---------------------------------------------------------");
//		
//		BookDao dao = new BookDao();
//
//		BookVo vo1 = new BookVo();
//		
//		vo1.setCategoryNumber(1);
//		vo1.setTitle("90년대생이 온다");
//		vo1.setPrice((long) 50000);
//
//		dao.insert(vo1);
//		System.out.println(vo1);
//
//		ArtistVo vo2 = new ArtistVo();
//		vo2.setName("BTS");
//		dao.insert(vo2);
//		System.out.println(vo2);
//
//		ArtistVo vo3 = new ArtistVo();
//		vo3.setName("소녀시대");
//		dao.insert(vo3);
//		System.out.println(vo3);
//	}

	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();

		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}

