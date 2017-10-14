package wdhit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.ResultSet;

public class connectMysql {
	private Connection conn;
	private Statement stmt;
	
	public connectMysql(){
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		/*System.getenv("MYSQL_HOST_S"); 为从库，只读*/
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//System.out.println("f*ck");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/text?useSSL=false&characterEncoding=UTF-8", "root", "");
			//conn = DriverManager.getConnection("jdbc:mysql:// w.rdc.sae.sina.com.cn:3307/app_hitwd", "1jny5oxj0n", "zlxiwi24kk5m5zkjzh23l2h25zhxxihhw40l2k00");
			conn = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("Mysql succeed!");
			//System.out.println("f*ck");
			stmt = conn.createStatement();
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
	}
	
	//通过isbn读取图书
	public book getBook(String isbn){
		if(isbn.equals("")) return null;
       String sql =  "select * from book where isbn='" + isbn+"'";
       try{
		   ResultSet rs = stmt.executeQuery(sql);
		   if(rs.next()){
			   book newbook = new book();
			   newbook.setISBN(isbn);
			   if(null != rs.getString(1))
				   newbook.setTitle(new String(rs.getString(1).trim()));
			   if(null != rs.getString(2))
				   newbook.setPublishDate(new String(rs.getString(2).trim()));
			   if(null != rs.getString(3))
				   newbook.setPublisher(new String(rs.getString(3).trim()));
			   if(null != rs.getString(4))
				   newbook.setAuthorID(new String(rs.getString(4).trim()));
			   if(null != rs.getString(6))
				   newbook.setPrice(new String(rs.getString(6).trim()));
			   return newbook;
		   }
		   else
			   return null;
       }
       catch(Exception ex){
		   System.out.println(ex);
		   return null;
		   //System.exit(0);
       }
       
	}
	
	//存储图书
	public boolean saveBook(book newbook){
		if(newbook.getISBN() == "") return false;//incorrect isbn
		String sql = "select * from book where isbn='" + newbook.getISBN() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
			if(rs.next()) return false;//the book exists in the database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		sql = "insert into book (title, publishDate, publisher, authorID, ISBN,price)"
				+ "values ('" + newbook.getTitle() + "','" + newbook.getPublishDate() + "','" + newbook.getPublisher() + "','"
				+ newbook.getAuthorID() + "','" + newbook.getISBN() + "','" + newbook.getPrice() + "')";
		try{
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return true;
	}
	
	//通过书名模糊查询
	public LinkedList<book> searchBook(String st){
		String sql = "select * from book where authorID='"+ st +"'";
		//System.out.println("111");
	    LinkedList<book> list = new LinkedList<book>();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				book newbook = new book();
				if(null != rs.getString(1))
					newbook.setTitle(new String(rs.getString(1).trim()));
				if(null != rs.getString(2))
					newbook.setPublishDate(new String(rs.getString(2).trim()));
				if(null != rs.getString(3))
					newbook.setPublisher(new String(rs.getString(3).trim()));
				if(null != rs.getString(4))
					newbook.setAuthorID(new String(rs.getString(4).trim()));
				if(null != rs.getString(5))
					newbook.setISBN(new String(rs.getString(5).trim()));
				if(null != rs.getString(6))
					newbook.setPrice(new String(rs.getString(6).trim()));
				list.add(newbook);
			}
			return list;
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    }
	    return null;
	}

	//通过作者名查询作者
	public LinkedList<Author> getAuthorID(String author){
		if(author.equals("")) return null;
       String sql =  "select * from Author where Name='" + author+"'";
       LinkedList<Author> list = new LinkedList<Author>();
       try{
		   ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()){
			   //System.out.println("safasfasf");
			   Author newauthor = new Author();
			   if(null != rs.getString(1))
				   newauthor.setAuthorID(new String(rs.getString(1).trim()));
			   if(null != rs.getString(2))
				   newauthor.setName(new String(rs.getString(2).trim()));
			   if(null != rs.getString(3))
				   newauthor.setAge(new String(rs.getString(3).trim()));
			   if(null != rs.getString(4))
				   newauthor.setCountry(new String(rs.getString(4).trim()));
			   //System.out.println("safasfasf");
			   list.add(newauthor);
		   }
       }
       catch(Exception ex){
		   System.out.println(ex);
		   System.exit(0);
       }
       return list;
	}

	//保存作者信息
	public boolean saveAuthor(Author newauthor){
		if(newauthor.getAuthorID() == "") return false;
		String sql = "select * from Author where authorID='" + newauthor.getAuthorID() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) return false;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		sql = "insert into Author (authorID, Name,Age,Country)"
				+ "values ('" + newauthor.getAuthorID() + "','" + newauthor.getName() + 
				"','" + newauthor.getAge() + "','" + newauthor.getCountry() + "')";
		try{
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return true;
	}

	//通过作者ID查询作者
	public Author getAuthorname(String authorID){
		if(authorID.equals("")) return null;
       String sql =  "select * from Author where AuthorID='" + authorID+"'";
       
       try{
		   ResultSet rs = stmt.executeQuery(sql);
		   if(rs.next()){
			   //System.out.println("safasfasf");
			   Author newauthor = new Author();
			   if(null != rs.getString(1))
				   newauthor.setAuthorID(new String(rs.getString(1).trim()));
			   if(null != rs.getString(2))
				   newauthor.setName(new String(rs.getString(2).trim()));
			   if(null != rs.getString(3))
				   newauthor.setAge(new String(rs.getString(3).trim()));
			   if(null != rs.getString(4))
				   newauthor.setCountry(new String(rs.getString(4).trim()));
			   System.out.println("safasfasf");
			   return newauthor;
		   }
		   else
			   return null;
       }
       catch(Exception ex){
		   System.out.println(ex);
		   System.exit(0);
       }
       return null;
	}

	//删除书籍
	public boolean deletebook(String ISBN){
		if(ISBN==null) return false;
	    String sql =  "delete from book where isbn ='" + ISBN +"'";
	    //System.out.println(ISBN);
	    try{
	    	//System.out.println("sfasfa");
			stmt.executeUpdate(sql);
			   
	    }
	    catch(Exception ex){
			   System.out.println(ex);
			   System.exit(0);
	    }
	    return true;
	}

	//修改书籍
	public boolean changebook(book oldbook,book newbook){
		//if(newbook==null) return false;
	    String sql;
	    //System.out.println(ISBN);
	    try{
	    	if(oldbook.getTitle()!=newbook.getTitle())
	    	{
	    		sql = "Update book set title ='" + newbook.getTitle() +"'where title ='"+oldbook.getTitle()+"'";
	    		stmt.executeUpdate(sql);
	    	}
	    	
	    	if(oldbook.getISBN()!=newbook.getISBN())
	    	{
	    		sql = "Update book set ISBN ='" + newbook.getISBN() +"'where ISBN ='"+oldbook.getISBN()+"'";
	    		stmt.executeUpdate(sql);
	    	}
			
	    	if(oldbook.getPrice()!=newbook.getPrice())
	    	{
	    		sql = "Update book set price ='" + newbook.getPrice() +"'where price ='"+oldbook.getPrice()+"'";
	    		stmt.executeUpdate(sql);
	    	}
	    	
	    	if(oldbook.getPublishDate()!=newbook.getPublishDate())
	    	{
	    		sql = "Update book set publishdate  ='" + newbook.getPublishDate() +"'where publishdate ='"+oldbook.getPublishDate()+"'";
	    		stmt.executeUpdate(sql);
	    	}
	    	
	    	if(oldbook.getPublisher()!=newbook.getPublisher())
	    	{
	    		sql = "Update book set publisher  ='" + newbook.getPublisher() +"'where publisher ='"+oldbook.getPublisher()+"'";
	    		stmt.executeUpdate(sql);
	    	}
	    	
	    	if(oldbook.getAuthorID()!=newbook.getAuthorID())
	    	{
	    		sql = "Update book set AuthorID  ='" + newbook.getAuthorID() +"'where AuthorID ='"+oldbook.getAuthorID()+"'";
	    		stmt.executeUpdate(sql);
	    	}
	    }
	    catch(Exception ex){
			   System.out.println(ex);
			   System.exit(0);
	    }
	    return true;
	}
}
