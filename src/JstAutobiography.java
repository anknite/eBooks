/* JstAutobiography */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;

public class JstAutobiography extends HttpServlet
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
    	
    	out.println("<html>");
    	
    	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:BookDb","","");
		
			Statement st=con.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select * from Booktab");
				
			out.println("<title>Autobiography..</title>");
			out.println("<body bgcolor=pink >");
					
			out.println("<b><font face=\"Papyrus\" size=36><center>");
			out.println("<big>Categories..<br></big></center>");
					
					
					
			out.println("<form action=\"http://localhost:8080/servlet/JstCategory\">");
			out.println("<input type=submit value=\"<< To Category\"<br>");
					
			out.println("<font face=\"Mistral\" size=20 color=#208234><center>Autobiography</center></form>");
					
			out.println("<table align=center border=3 cellspacing=2 ");
			out.println("cellpadding=3 bgcolor=#EDDA74 bordercolor=#7D0541 width=75%>");
			out.println("<tr align=center>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Code</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Name<font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Author</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Price in Rs.</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Category</b></font></td>");
			out.println("</tr>");
				    
				    while(rs.next())
				    {
				      String sub=rs.getString(5);
				      if(sub.equals("Autobiography")==true)
				  	  {
						   out.println("<tr align=center>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getInt(3)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(1)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(2)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getInt(4)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+sub+"</font></td>");
						   out.println("</tr>");
					  }//if
    				}//while
    				
    				out.println("</font></table><br>");
					out.println("</body>");
		}//try
		catch(Exception e)
		{
		}
	}//service
}//class
  
					