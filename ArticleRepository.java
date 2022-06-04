package prohec;

import java.util.ArrayList;

public class ArticleRepository {
	
	private ArrayList<Article> articles = new ArrayList<>();
	private int articleId = 4;		

	public void makeTestData() {		
		
		Article a1 = new Article(1, "제목1", "내용1");
		Article a2 = new Article(2, "제목2", "내용2");
		Article a3 = new Article(3, "제목3", "내용3");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
	}
	
	// C
	
	public void addArticle(String title, String body) {		
		
		Article article = new Article(articleId, title, body);
		articles.add(article);
		articleId++;
	}
	
	// R
	public Article getArticleOne(int id) {
		
		// id를 번호로 하는 게시물이 존재하는지, 존재하면 리턴.
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getId() == id) {
				return articles.get(i); 
			}
		}
		
		
		return null;
	}
	
	public ArrayList<Article> getSearchedArticleList(String keyword) {
		
		ArrayList<Article> searchedArticleList = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getTitle().contains(keyword)) {
				searchedArticleList.add(articles.get(i));
			}
		}
		
		return searchedArticleList;
	}
	
	public ArrayList<Article> getArticles() {
		return this.articles;
	}
	
	// U
	public void updateArticle(Article article, String title, String body) {
		article.setTitle(title);
		article.setBody(body);
	}
	
	// D
	public void deleteArticle(Article article) {
		articles.remove(article);
	}
}