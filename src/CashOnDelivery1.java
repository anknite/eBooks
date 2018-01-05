/* CashOnDelivery */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class CashOnDelivery1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
    res.setContentType("text/html");
    int cost;
    PrintWriter out = res.getWriter();
    System.out.println("CashOnDelivery");
    Connection con=null;
  	PreparedStatement pstmt=null;
    
    HttpSession CODsession = req.getSession(true);
    cost=(Integer)CODsession.getValue("ba");
    
   	Integer billamt = new Integer(cost);
  	CODsession.putValue("ba",billamt);
    
    out.println("<html>");
	out.println("<title>COD..</title>");
	out.println("<body bgcolor=#737CA >");
	out.println("<form action=\"http://localhost:8080/servlet/CODThanks\">");
	
	out.println("<font size=36 align=center color=#ffd7ff>");
	out.println("<center>Payment mode: Cash on Delivery</center></font>");
	out.println("<br><br>");
	out.println("<br><br><br>");
	out.println("<font face=\"Maiandra GD\" color=black size=4>");
	out.println("Enter your user id:");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");  
	out.println("<input type=text name=\"uid\">");
	out.println("<br><br>");
	
	out.println("<font face=\"Maiandra GD\" color=black size=4>");
	out.println("Enter your address for delivery:");   
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows=3 columns=3 name=\"adrrs\">");
	out.println("</textarea><br><br>");
	
	out.println("<font face=\"Maiandra GD\" color=black size=4>");
	out.println("Bill amount:&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Rs. &nbsp;");  
	out.println("<input type=text name=\"billamt\" value="+cost+">");
	out.println(" &nbsp;&nbsp;/-");
	out.println("<br><br><br><br>");
	out.println("<input type=submit value=\"submit\">");
	
	out.println("</form></body></html>");
	out.close();	
  }//service
}//class