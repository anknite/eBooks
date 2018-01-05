/* FeedBack */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class FeedBack extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  	{
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    
	    out.println("<html>");
	    out.println("<title>feedback..</title>");
		out.println("<body bgcolor=#6C2DC7 >");
		
		out.println("<form action=\"http://localhost:8080/servlet/FeedSignin\">");
		
		out.println("<font face=\"Papyrus\" size=14 align=center color=gold>");
		out.println("<center><big>Feed back form !!</center></font><br>");
		out.println("<font size=4 >");
		
		out.println("Contact information:");
		out.println("<br><br><b>User id:");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<input type=text name=\"userid\">");
		out.println("<br><br>");
		
		out.println("Address:");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<textarea rows=4 columns=2 name=\"addrs\">");
		out.println("</textarea><br><br>");
		
		out.println("e-mail:");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<input type=textc name=\"email\"><br><br>");
		
		out.println("Comments:&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows=4 columns=4 name=\"cmt\">");
		out.println("</textarea><b></font><br><br><br>");
		
		out.println("<input type=\"submit\" value=\"sign in\">");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<button type=reset onclick=javascript:Reset() type=reset>clear</button>");
		out.println("<br><br>");
		out.println("<font face=\"Sylfaen\" size=6 color=#800000>All suggestions are welcomed..</font>");
		out.println("<br><br>");
		out.println("<center><font face=\"Lucida Calligraphy\" size=6 color=##123450>THANK YOU !!</font>");
		out.println("</html>");
  		out.close();
  	}//service
}//class
	   