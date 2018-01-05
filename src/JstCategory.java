/* JstCategory */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class JstCategory extends HttpServlet
{
   public void  init(ServletConfig config)throws ServletException
   {
     super.init(config);
   }

 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	res.setContentType("text/html");
        PrintWriter out =res.getWriter();
        
        out.println("<html>");
		out.println("<title>Categories..</title>");
		out.println("<body bgcolor=gold >");
		
		out.println("<b><font face=\"Papyrus\" size=36 color= #806F7E><center>");
		out.println("<big>Category</big></center>");
		
		out.println("<ul type=disc>");
		out.println("<font face=\"Maiandra GD\" color=black size=4>");
		out.println("<li type=square>Choose your category..");
		out.println("</li></font><br>");
		
		out.println("<A href=\"JstFiction\"><font face=\"Mistral\" size=8 color=#208234><b>Fiction</b></A><br>");
		
		out.println("<A href=\"JstNonFiction\"><font face=\"Mistral\" size=8 color=#208234><b>Non-Fiction</b></A><br>");
		
		out.println("<A href=\"JstAutobiography\"><font face=\"Mistral\" size=8 color=#208234><b>Autobiography</b></A><br>");
		
		out.println("<A href=\"JstHistory\"><font face=\"Mistral\" size=8 color=#208234><b>History</b></A><br>");
	
		out.println("<A href=\"JstComics\"><font face=\"Mistral\" size=8 color=#208234><b>Comics</b></A></font><br><br>");
		
		out.println("<form action=\"http://localhost:8080/servlet/Signin\">");
		out.println("<input type=submit value=\"<< Sign In\">");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<A href=\"JstSignup\"><font face=\"Papyrus\"size=6 color=navy><b>Sign Up</b></A>");
		
		out.println("</font></form></body>");
		out.println("</html>");
        
   	}//service
}//class