//wd
package wdhit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class addAuthor extends ActionSupport {
	public String execute() throws Exception {
			   /*System.out.println("      ");*/
		HttpServletRequest request = ServletActionContext.getRequest();			
		String authorID = request.getParameter("authorID");
		//System.out.println(111+authorID);
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		Author newauthor=new Author();
		newauthor.setAuthorID(authorID);
		newauthor.setName(name);
		newauthor.setAge(age);
		newauthor.setCountry(country);
		connectMysql mm =new connectMysql();
		//System.out.println("sfasfsa");
		//System.out.println(222);
		boolean a=mm.saveAuthor(newauthor);
		//System.out.println(333);
		if(a==false)
		{
			return "error";
		}
		else
		{
			return "success";
		}
	}
}
