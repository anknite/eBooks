/* Signin */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public  class Signin extends HttpServlet
{
   public void  init(ServletConfig config)throws ServletException
   {
     super.init(config);
   }

 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	res.setContentType("text/html");
        PrintWriter out =res.getWriter();
    	
    	String bnm[]=null;
    	String qty[]=null;
    	ArrayList al1=new ArrayList();
  		ArrayList al2=new ArrayList();
  		
  		HttpSession HSession=req.getSession(true);
		HSession.putValue("bNames",al1);
		HSession.putValue("bQty",al2);
    	
    	
    
		String userid = req.getParameter("signin");
	    String pwdid = req.getParameter("pass");
    	out.println("<html>");
		out.println("<title>Sign in..</title>");
		out.println("<body bgcolor=#737CA>");
		
		out.println("<form  action=\"http://localhost:8080/servlet/CategoryList\">");
		
		out.println("<font size=36 align=center color=#FFFC17>");
		out.println("<center>Sign In</center>");
		out.println("</font>");
		out.println("<br><br>");
		out.println("<font size=4 color=#FFF8C6> <marquee behavior=\"alternate\"> Type your id and password ");
		
		out.println("here..</marquee></font>");
		out.println("<br><br><br><br>");
		
		out.println("<font size=6> Sign In id :");
		out.println("<input type=text name=\"signin\">");
		out.println("<br><br>");
		
		out.println("Password :");
		out.println("<input type=password name=\"pass\">");
		out.println("<br><br></font>");
		
		out.println("<input type=\"submit\" value=\"Sign in\">");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<button type=reset onclick=javascript:Reset() type=reset>clear</button>");
		out.println("<br><br><br><br>");
		
		out.println("</form></body></html>");

    }//service
}//class