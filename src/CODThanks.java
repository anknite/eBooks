/* CODThanks */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class CODThanks extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  	{
	    res.setContentType("text/html");
	    int cost=0,flag=0;
	    PrintWriter out = res.getWriter();
	   
	   	HttpSession CODThankssession = req.getSession(true);
	    cost=(Integer)CODThankssession.getValue("ba");
	    
	    String usid=req.getParameter("uid");
	    String addr=req.getParameter("adrrs");
	    out.println("<html>");
	    Connection con;
        PreparedStatement pstmt;
	
	
		try
	  	{
		    
		   	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   	con = DriverManager.getConnection("jdbc:odbc:BookDb","","");
		    pstmt = con.prepareStatement("insert into cdv values(?,?,?)");
		    Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("Select * from Usertab");
			
			while(rs.next())
			{
				String user=rs.getString(5);
				
				if(user.equals(usid))
				{
			
		    pstmt.setString(1,addr);
		    pstmt.setString(2,usid);
		    pstmt.setInt(3,cost);
		    pstmt.executeUpdate();
					
					flag=1;
					 
					out.println("<title>Thnx..</title>");
					out.println("<body bgcolor=silver>");
					
					out.println("<font face=\"Papyrus\" size=14"); 
					
					out.println("align=center color=#2B3856>");
					out.println("<center><big>Thank You... !!");
					out.println("<br>for");
					out.println("<br>Shopping with us.");
					out.println("<br><br><br>");
					out.println("<marquee behavior=\"alternate\"><font ");
					
					out.println("face=\"Snap ITC\" size=4 color=green>");
					out.println("Have a nice day !!</font></marquee>");
					
					out.println("<form action=\"http://localhost:8080/servlet/FeedBack\">");
					
					out.println("<font size=4 color=#F6358A><b>");
					out.println("To feedback form <br><input type=submit value=GO..>");
					
					out.println(">></b></font></A>");
					out.println("</form></body>");
					
					break;	
				}
			}
		    
		    if(flag==0)
		    {
		    	 
		    	out.println("<title>COD..</title>");
				out.println("<body bgcolor=#737CA >");
				out.println("<form action=\"http://localhost:8080/servlet/CODThanks\">");
				
				out.println("<font size=36 align=center color=#ffd7ff>");
				out.println("<center>Payment mode: Cash on Delivery</center></font>");
				out.println("<br><br>");
				out.println("<A href=\"Pay1\"><font size=4 color=navy><b><< back</b></font></A>");
				out.println("<br><br><br>");
				
				out.println("<center><font size=4 face=\"Lucida Handwriting\" align=center color=maroon>");
				out.println("Sorry !! You have entered an incorrect");
				out.println("id <br>Enter again.. </font></center><br><br>");
				
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
				
				out.println("</form></body>");
				;
		   	}
			out.close();
		    
		    pstmt.close();
		    con.close();
		   
		}//try
	    catch(Exception e)
		{
	 		System.out.println("Exception Occurred:"+e);
		}
  	out.println("</html>)");
  	out.close();
  	
  	}//service
}//class