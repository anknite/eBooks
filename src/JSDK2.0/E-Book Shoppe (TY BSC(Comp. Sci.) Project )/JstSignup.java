import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class JstSignup extends HttpServlet
{
   public void  init(ServletConfig config)throws ServletException
   {
     super.init(config);
   }

 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	res.setContentType("text/html");
        PrintWriter out =res.getWriter();
        
        
        out.println("<title>JstSign up..</title>");
						out.println("<body bgcolor=#FFFFCC");
						
						out.println("<form method=\"POST\" action=\"http://localhost:8080/servlet/Signup\">");
						
						out.println("<font size=50 color=green>");
						out.println("<center>NEW USER (Sign Up)</center>");
						out.println("</font>");
						out.println("<br><br>");
						out.println("<marquee behavior=\"alternate\" color=#0023FF>"); 
						out.println("Enter your information here..</marquee>");
						out.println("<br><br>");
										
						out.println("First Name :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"fname\"><br><br>");
						
						out.println("Last Name :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"lname\"><br><br>");
						
						out.println("Date of Birth :");
						out.println("&nbsp;<input type=text name=\"dob\"><br><br>");
						
						out.println("Gender :");
						out.println(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"gender\">");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("(note- Enter 'M' for male and 'F' for female )<br><br>");
						
						out.println("user id :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"uid\"><br><br>");
						
						out.println("Password :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=password name=\"pwd\"><br><br>");
						
						out.println("Address :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<textarea rows=5 columns=5 name=\"addr\"></textarea><br><br>");
						
						out.println("City :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"city\"><br><br>");
						
						out.println("State :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"state\"><br><br>");
						
						out.println("Country :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"country\"><br><br>");
						
						out.println("e-mail id :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"email\"><br><br>");
						
						out.println("<input type=submit name= \"submit\" value=\"submit\">");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input id=reset name=reset onclick=javascript:Reset() type=reset value=Reset>");
						out.println("</form></body>");
						out.println("</html>");
        
  	}//service
}//class