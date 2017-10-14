package wdhit;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class find2 extends ActionSupport {
	public String execute() throws Exception {
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String name = request.getParameter("name");
		 connectMysql mm =new connectMysql();
		 //System.out.println(name);
		 LinkedList<Author> newauthor = mm.getAuthorID(name);
		 if(newauthor==null||newauthor.size()==0)
		 {
			 System.out.println(111);
			 return "notfind";
		 }
		 else{
			 System.out.println(222);
			 request.setAttribute("newauthor", newauthor);
		 return "success";}
	}
}
