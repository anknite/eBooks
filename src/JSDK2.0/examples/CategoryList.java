/* Fiction */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;

public class CategoryList extends HttpServlet
{
   public void  init(ServletConfig config)throws ServletException
   {
     super.init(config);
   }

 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	res.setContentType("text/html");
        PrintWriter out =res.getWriter();
    	
    	Connection con = null;
    	Connection con1 = null;
		String userid = req.getParameter("signin");
	    String pwdid = req.getParameter("pass");
		out.println("<html>");
		int flag=0;
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:BookDb","","");
		
			Statement st=con.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select * from Usertab");
			
			while(rs.next())
			{
				String user=rs.getString(5);
				String pwd=rs.getString(6);
				
				
				if(user.equals(userid) && pwd.equals(pwdid))
				{
					flag=1;
					HttpSession HSession=req.getSession(true);
			        ArrayList al1=(ArrayList)HSession.getValue("bNames");
			 		ArrayList al2=(ArrayList)HSession.getValue("bQty");
			 		
			 		HSession.putValue("bNames",al1);
			 		HSession.putValue("bQty",al2);
			        
			        out.println("<html>");
					out.println("<title>Categories..</title>");
					out.println("<body bgcolor=gold >");
					out.println("<form action=\"http://localhost:8080/servlet/FinalList\">");
					out.println("<b><font face=\"Papyrus\" size=36 color= #806F7E><center>");
					out.println("<big>Category</big></center>");
					
					out.println("<ul type=disc>");
					out.println("<font face=\"Maiandra GD\" color=black size=4>");
					out.println("<li type=square>Choose your category..");
					out.println("</li></font><br>");
					
					out.println("<A href=\"FictionClick\"><font face=\"Mistral\" size=8 color=#208234><b>Fiction</b></A><br>");
					
					out.println("<A href=\"NonFictionClick\"><font face=\"Mistral\" size=8 color=#208234><b>Non-Fiction</b></A><br>");
					
					out.println("<A href=\"AutobiographyClick\"><font face=\"Mistral\" size=8 color=#208234><b>Autobiography</b></A><br>");
					
					out.println("<A href=\"HistoryClick\"><font face=\"Mistral\" size=8 color=#208234><b>History</b></A><br>");
				
					out.println("<A href=\"ComicsClick\"><font face=\"Mistral\" size=8 color=#208234><b>Comics</b></A></font><br><br>");
					
				
					out.println("<center><input type=submit value=\" Finalize List >>\"></form>");
					
					out.println("<font face=\"Maiandra GD\" color=black size=4>");
					out.println("Moves to final List..</center>");
					
					out.println("</font></body>");
						
				}//if
			}//while
			
			if(flag==0)
			{
				out.println("<html>");
				out.println("<title>Sign in..</title>");
				out.println("<body bgcolor=#737CA>");
				
				out.println("<form  action=\"http://localhost:8080/servlet/CategoryList\">");
				
				out.println("<font size=36 align=center color=#FFFC17>");
				out.println("<center>Sign In</center>");
				out.println("</font>");
				out.println("<br><br>");
				
				out.println("<font size=4 face=\"Lucida Handwriting\" align=center color=pink>");
				out.println("Sorry !! You have entered an incorrect<br>");
				out.println("user id or password<br>Enter again.. </font><br><br>");
				
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
				
				out.println("</form></body>");
			}		
		}//try
		
		catch(Exception e)
		{
		}

    out.println("</html>");
    
    }//service
}//class