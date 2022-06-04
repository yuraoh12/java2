
public class Board1 {

import java.util.Scanner;

public class Board {

	ArticleRepository repo = new ArticleRepository();
	ArticleView articleView = new ArticleView();	
	Member loginedMember = null;
	
	Scanner sc = new Scanner(System.in);
	
	public Board() {
		repo.makeTestData();
		loginedMember = repo.getMemberByLoginId("hong123");
	}
	
	public void run() {	
		
		while (true) {
			
			String cmd = printInputCommand();

			if (cmd.equals("help")) {
				articleView.printHelp();

			} else if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
	}

	private String printInputCommand() {
		
		if(loginedMember != null) {
			System.out.printf("%s(%s))  >>  ", loginedMember.getNickname(), loginedMember.getLoginId());
			
		} else {				
			System.out.print(">>  ");
			
		}
		
		String cmd = sc.nextLine();
		
		return cmd;
	}
}
