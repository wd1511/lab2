package wdhit;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class chooseauthor extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String authorID = request.getParameter("authorID");
		  connectMysql mm =new connectMysql();
			
		  LinkedList<book> newbook = mm.searchBook(authorID);
		  if(newbook==null||newbook.size()==0)
			  return "notfind";
		  else
		  {
			  request.setAttribute("books", newbook); 
			  return "success";
		  }
		  
	}
}
