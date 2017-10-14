package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class changeb extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String oldISBN = request.getParameter("oldisbn");
		  String title = request.getParameter("title");
		  String publishDate = request.getParameter("publishDate");
		  String publisher = request.getParameter("publisher");
		  String authorID = request.getParameter("authorID");
		  String ISBN = request.getParameter("ISBN");
		  String price = request.getParameter("price");
		  connectMysql mm =new connectMysql();
		  book oldbook = mm.getBook(oldISBN);
		  book newbook = new book();
		  
		  if(title==""||title==null)
			  newbook.setTitle(oldbook.getTitle());
		  else
			  newbook.setTitle(title);
		  
		  if(publishDate==""||publishDate==null)
			  newbook.setPublishDate(oldbook.getPublishDate());
		  else
			  newbook.setPublishDate(publishDate);
		  
		  if(publisher==""||publisher==null)
			  newbook.setPublisher(oldbook.getPublisher());
		  else
			  newbook.setPublisher(publisher);
		  
		  if(authorID==""||authorID==null)
			  newbook.setAuthorID(oldbook.getAuthorID());
		  else
			  newbook.setAuthorID(authorID);
		  
		  if(ISBN==""||ISBN==null)
			  newbook.setISBN(oldbook.getISBN());
		  else
			  newbook.setISBN(ISBN);
		  
		  if(price==""||price==null)
			  newbook.setPrice(oldbook.getPrice());
		  else
			  newbook.setPrice(price);
		  
		  System.out.println(newbook.getPrice());
		  boolean a=mm.changebook(oldbook, newbook);
		  if(oldbook.getAuthorID()!=newbook.getAuthorID())
		  {
			  
			  Author newauthor=mm.getAuthorname(newbook.getAuthorID());
			  if(newauthor==null)
			  {
				  request.setAttribute("newbook", newbook);
				  return "addauthor";
			  }
		  }
		  if(a==true)
		  {
			  request.setAttribute("newbook", newbook);
			  return "success";
		  }
		  else
			  return "error";
	}
}
