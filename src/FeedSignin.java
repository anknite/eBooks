import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class FeedSignin extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  	{
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
    	int flag=0;
    	String usid=req.getParameter("userid");
	    String addr=req.getParameter("addrs");
	    String em=req.getParameter("email");
	    String comments=req.getParameter("cmt");
	    out.println("<html>");
	    Connection con;
        PreparedStatement pstmt;
        
        try
	  	{
		    
		   	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   	con = DriverManager.getConnection("jdbc:odbc:BookDb","","");
		    pstmt = con.prepareStatement("insert into feedback values(?,?,?,?)");
		    Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("Select * from Usertab");
		
			while(rs.next())
			{
				String user=rs.getString(5);
			
				if(user.equals(usid))
				{
			
		    		pstmt.setString(1,usid);
		    		pstmt.setString(2,addr);
		    		pstmt.setString(3,em);
		    		pstmt.setString(4,comments);
		    			System.out.println("heloo");
		    	//	pstmt.executeUpdate();
					System.out.println("values inserted here");
					flag=1;
					
					out.println("<title>Sign in..</title>");
					out.println("<body bgcolor=#737CA>");
					
					out.println("<form  action=\"http://localhost:8080/servlet/Signin\">");
					
					out.println("<font size=36 align=center color=#FFFC17>");
					out.println("<center>Sign In</center>");
					out.println("</font>");
					out.println("<br><br>");
					out.println("<font size=4 color=#FFF8C6> <marquee behavior=\"alternate\"> Type your id and password"); 
					
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
					
					out.println("</form></body>");
						break;	
				}//if
			}//while
		    
		    if(flag==0)
		    {
		    	out.println("<title>feedback..</title>");
				out.println("<body bgcolor=#6C2DC7 >");
				
				out.println("<form action=\"http://localhost:8080/servlet/FeedSignin\">");
				
				out.println("<font face=\"Papyrus\" size=14 align=center color=gold>");
				out.println("<center><big>Feed back form !!</center></font><br>");
				out.println("<font size=4 >");
				
				out.println("Contact information:");
				
				
				out.println("<center><font size=4 face=\"Lucida Handwriting\" align=center color=silver>");
				out.println("Sorry !! You have entered an incorrect user id <br>Enter again.. </font></center><br>");
				
				out.println("<b>User id:");
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
				out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				out.println("<button type=reset onclick=javascript:Reset() type=reset>clear</button>");
				out.println("<br><br>");
				out.println("<font face=\"Sylfaen\" size=6 color=#800000>All suggestions are welcomed..</font>");
				out.println("<br><br>");
				out.println("<center><font face=\"Lucida Calligraphy\" size=6 color=##123450>THANK YOU !!</font>");
		    }	
			
		    pstmt.close();
		    con.close();
		   
		}//try
	    catch(Exception e)
		{
	 		System.out.println("Exception Occurred:"+e);
		}
  			out.println("</html>");
			out.close();
		    
  	
  	}//service
}//class