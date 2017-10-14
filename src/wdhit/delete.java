package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class delete extends ActionSupport {
	public String execute() throws Exception {
		   /*System.out.println("      ");*/
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String ISBN = request.getParameter("isbn");
		  connectMysql mm =new connectMysql();
		  boolean a = mm.deletebook(ISBN);
		  if (a==true)
			  return "success";
		  else
			  return "error";
	}
}
