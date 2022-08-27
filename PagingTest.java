package main;

public class PagingTest {

	public static void main(String[] args) {

		int currentPageNo = 7;
		int pageCountPerBlock = 5;
		int currentPageBlock = (int)Math.ceil((double)currentPageNo / pageCountPerBlock);
		int startPageNo = 1 + (pageCountPerBlock * (currentPageBlock - 1));
		
		System.out.println(currentPageBlock);
		
		// b : 1 , sp: 1 + (5 * (b-1))
		// b : 2 , sp: 1 + (5 * (b-1))
		// b : 3 , sp: 1 + (5 * (b-1))
		
		
		// cp: 1 ~ 5, b : 1  -> cp / 5 - 0.xxx, 2 / 5 -> 0.xxx, .... 5/5 -> 1
		// cp: 6 ~ 10, b : 2 -> 6 / 5 - 1.xxx,  7 / 5 -> 1.xxx,      10 / 6 -> 2
		// cp: 11 ~ 15, b : 3
		
		// 올림(현재페이지번호 / 페이지블럭당페이지개수) ==> 현재 페이지블럭번호
		
		int endPageNo = startPageNo + pageCountPerBlock;		
		
		for(int i = startPageNo; i < endPageNo; i++) {
			if(i == currentPageNo) {
				System.out.printf("[%d] ", i);				
			} else {
				System.out.printf("%d ", i);
			}
		}
		
		//System.out.println("[1] 2 3 4 5");
		
	}

}