package wdhit;

public class book {
	private String title;
	private String publishDate;
	private String publisher;
	private String authorID;
	private String ISBN;
	private String price;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String mytitle){
		title=mytitle;
	}
	
	public String getPublishDate(){
		return publishDate;
	}
	
	public void setPublishDate(String myPublishDate){
		publishDate=myPublishDate;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public void setPublisher(String myPublisher){
		publisher=myPublisher;
	}
	
	public String getAuthorID(){
		return authorID;
	}
	
	public void setAuthorID(String myAuthorID){
		 authorID=myAuthorID;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	public void setISBN(String myISBN){
		ISBN=myISBN;
	}
	
	public String getPrice(){
		return price;
	}
	
	public void setPrice(String myPrice){
		price=myPrice;
	}
	
}
