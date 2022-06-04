package prohec;


import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	ArticleRepository repo = new ArticleRepository();
	ArticleView articleView = new ArticleView();

	Scanner sc = new Scanner(System.in);
	
	public void run() {	

		repo.makeTestData();
		
		while (true) {
			System.out.print(">>  ");
			String cmd = sc.nextLine();

			if (cmd.equals("help")) {
				articleView.printHelp();

			} else if (cmd.equals("add")) {
				addArticle();
				
			} else if (cmd.equals("list")) {
				articleView.printArticles(repo.getArticles());

			} else if (cmd.equals("update")) {
				updateArticle();
				articleView.printArticles(repo.getArticles());
				
			} else if(cmd.equals("search")) {
				searchArticles();				
				
			} else if(cmd.equals("read")) {
				readArticle();
				
			} else if(cmd.equals("delete")) {
				deleteArticle();
				
			} else if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
	}
	
	private void deleteArticle() {		
		System.out.print("삭제 할 게시물 번호 : ");
		int targetId = Integer.parseInt(sc.nextLine());
		
		Article article = repo.getArticleOne(targetId); 		
		repo.deleteArticle(article);		
		
		System.out.println("삭제가 완료되었습니다.");
		
	}

	private void readArticle() {
		
		System.out.print("상세보기 할 게시물 번호 : ");
		int targetId = Integer.parseInt(sc.nextLine());		
		
		Article article = repo.getArticleOne(targetId);
		
		if(article == null) {
			System.out.println("없는 게시물입니다.");
			
		} else {
			articleView.printArticleDetail(article);
		}
	}
	
	private void searchArticles() {
		
		System.out.print("검색 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Article> searchedList = repo.getSearchedArticleList(keyword);		
		articleView.printArticles(searchedList);
		
	}
	
	public void updateArticle() {
		// CRUD

		System.out.print("수정할 게시물 번호 : ");
		int targetId = Integer.parseInt(sc.nextLine());
		
		Article article = repo.getArticleOne(targetId);

		if(article == null) {
			System.out.println("없는 게시물입니다.");
		} else {		
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();
				
			repo.updateArticle(article, title, body);
	
			System.out.println("수정이 완료되었습니다.");
		}
//		printArticles();
		
	}

	public void addArticle() {
		System.out.print("제목 :");
		String title = sc.nextLine();

		System.out.print("내용 :");
		String body = sc.nextLine();
		
		repo.addArticle(title, body);
		System.out.println("게시물이 저장되었습니다.");

	}
	
	
}

