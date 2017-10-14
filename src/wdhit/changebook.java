package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class changebook extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String ISBN = request.getParameter("isbn");
		  book newbook;
		  connectMysql mm =new connectMysql();
		  newbook=mm.getBook(ISBN);
		  if(newbook==null) return "error";
		  request.setAttribute("newbook", newbook);
		  return "success";
	}
}
