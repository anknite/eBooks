/* E-banking */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class Ebanking extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
    res.setContentType("text/html");
    int cost;
    PrintWriter out = res.getWriter();
    System.out.println("Ebanking");
    
    HttpSession Esession = req.getSession(true);
    cost=(Integer)Esession.getValue("ba");
    
    Integer billamt = new Integer(cost);
  	Esession.putValue("ba",billamt);
    
    out.println("<html>");
	out.println("<title>E-Banking..</title>");
	out.println("<body bgcolor=#737CA >");
	
	out.println("<form action=\"http://localhost:8080/servlet/EbThanks\">");
	
	out.println("<font size=36 align=center color=#ffd7ff>");
	out.println("<center>Payment mode: e-Banking</center></font>");
	
	out.println("<br><br><br><br>");
	
	out.println("<font size=4>Enter your user id:");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name=\"userid\">");
	out.println("<br><br>");
		
	out.println("<b>Enter your Bank name :");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("<input type=text name=\"bankname\"><br><br>");
		
	out.println("Enter your Bank account no :");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("<input type=text name=\"accno\"><br><br>");
		
	out.println("Bill amount:</b>");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs. &nbsp;");  
	out.println("<input type=text name=\"billamt\" value="+cost+">&nbsp;&nbsp;/-");
	out.println("</font><br><br><br><br>");
	
	out.println("<input type=submit value=\"submit\">");
	
	out.println("</form></body></html>");
  }//service
}//class
  