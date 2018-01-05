/* Payment */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class Pay1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
    res.setContentType("text/html");
    int cost=0;
    PrintWriter out = res.getWriter();
    System.out.println("Payment");
    
   	cost=Integer.parseInt(req.getParameter("amt"));
    Integer billamt = new Integer(cost);
  	
  	HttpSession hs = req.getSession(true);
  	hs.putValue("ba",billamt);
    
    out.println("<html>");
	out.println("<title>Payment..</title>");
	
	
	out.println("<body bgcolor=\"#FFD7FF\" background=\"cittext.gif\">");
	
	out.println("<b><font face=\"Papyrus\" size=36><center>");
	out.println("<big>Payment</big></center>");
	out.println("<left>");
	out.println("<A href=\"Signin\"><font size=4 face=\"Comic Sans MS\" color=#123456>");
	out.println("<< Signout</A>");
	out.println("</left></font></b><br>");
	
	out.println("<ul type=disc>");
	out.println("<font face=\"Maiandra GD\" color=black size=4>");
	out.println("<li type=square>Choose your payment mode..</li></font>");
	out.println("<font face=\"Mistral\" size=20>");
	
	out.println("<li><form action=\"http://localhost:8080/servlet/CashOnDelivery1\">");
	out.println("<input type=submit value=\"Cash on delivery\"></form></li>");
	
	out.println("<li><form action=\"http://localhost:8080/servlet/CreditCard1\">");
	out.println("<input type=submit value=\"Credit Card\"></form></li>");
	
	out.println("<li><form action=\"http://localhost:8080/servlet/Ebanking\">");
	out.println("<input type=submit value=\"E-Banking\"></form></li></ul></font>");
	out.println("<center><font face=\"Maiandra GD\" size=6>Bill amount: </font>&nbsp; &nbsp;"); 
	out.println("<font face=\"Lucida Sans Unicode\" size=4>Rs. &nbsp;");  
	out.println("<input type=text name=\"billamt\" value="+cost+">&nbsp;&nbsp;/-</font></center>");
	out.println("</form></body></html>");
  }//service
}//class
    
