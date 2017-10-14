package wdhit;

public class Author {
	private String AuthorID;
	private String Name;
	private String Age;
	private String Country;
	
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setAuthorID(String myAuthorID){
		AuthorID=myAuthorID;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String myName){
		Name=myName;
	}
	
	public String getAge(){
		return Age;
	}
	
	public void setAge(String myAge){
		Age=myAge;
	}
	
	public String getCountry(){
		return Country;
	}
	
	public void setCountry(String myCountry){
		Country=myCountry;
	}
}
