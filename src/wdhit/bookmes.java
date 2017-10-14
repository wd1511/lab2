package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class bookmes extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String ISBN = request.getParameter("isbn");
		  connectMysql mm =new connectMysql();
		  book newbook = mm.getBook(ISBN);
		  if(newbook==null) return "error";
		  Author newauthor = mm.getAuthorname(newbook.getAuthorID());
		  request.setAttribute("newbook", newbook);
		  request.setAttribute("newauthor", newauthor);
		  //System.out.println(newbook.getISBN());
		  //System.out.println(newauthor.getCountry());
		  return "success";
	}
}
