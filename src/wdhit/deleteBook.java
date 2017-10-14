package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class deleteBook extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String ISBN = request.getParameter("ISBN");
		  connectMysql mm =new connectMysql();
		  book newbook=mm.getBook(ISBN);
		  if(newbook==null)
			  return "error";
		  else
		  {
			  request.setAttribute("newbook", newbook); 
			  return "success";
		  }
	}
}
