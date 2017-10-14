package wdhit;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class upload extends ActionSupport {
   public String execute() throws Exception {
	   /*System.out.println("      ");*/
	  HttpServletRequest request = ServletActionContext.getRequest();
	  String title = request.getParameter("title");
	  String publishDate = request.getParameter("publishDate");
	  String publisher = request.getParameter("publisher");
	  String authorID = request.getParameter("authorID");
	  String ISBN = request.getParameter("ISBN");
	  String price = request.getParameter("price");
	  book newbook =new book();
	  newbook.setTitle(title);
	  newbook.setPublishDate(publishDate);
	  newbook.setPublisher(publisher);
	  newbook.setAuthorID(authorID);
	  newbook.setISBN(ISBN);
	  newbook.setPrice(price);
	  //System.out.println(publisher);
	  connectMysql mm =new connectMysql();
	  //System.out.println("sfasfsa");
	  boolean a=mm.saveBook(newbook);
	  Author newauthor=mm.getAuthorname(authorID);
	  if(a==false)
	  {
		 
		  return "error";
		  //System.out.println(newbook.getISBN());
		 
	  }
	  else if(newauthor==null)
	  {
		  
		  request.setAttribute("newbook", newbook);
		  return "new";
	  }
	  else
	  {
		  return "success";
	  }
	  //System.out.println("Title"+title);
	  //System.out.println("publishDate"+publishDate);
	  //request.setAttribute("Name", name);
	   
      
   }
}
