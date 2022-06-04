
public class Reply1 {


public class Reply {
	
	private int id;
	private int articleId;
	private String body;
	private String nickname;
	private String regDate;
	
	public Reply(int id, int articleId, String body, String nickname, String regDate) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.body = body;
		this.nickname = nickname;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
