package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class find extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String ISBN = request.getParameter("ISBN");
		  book newbook;
		  connectMysql mm =new connectMysql();
		 
		  newbook=mm.getBook(ISBN);
		  Author newauthor=mm.getAuthorname(newbook.getAuthorID());
		  //System.out.println("1111");
		 // System.out.println(newbook.getPublisher());
		  if(newbook==null)
		  {
			  return "notfind";
		  }
		  else
		  {
			  request.setAttribute("newbook", newbook);
			  request.setAttribute("newauthor", newauthor);
			  return "success";
		  }
	}

}
