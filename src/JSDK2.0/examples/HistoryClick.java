/* HistoryClick */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class HistoryClick extends HttpServlet
{
   public void  init(ServletConfig config)throws ServletException
   {
     super.init(config);
   }

 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	res.setContentType("text/html");
        PrintWriter out =res.getWriter();
        Connection con;

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:BookDb","","");
		
			Statement st=con.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select * from BookTab");
			
				out.println("<html>");
				out.println("<title>History..</title>");
					out.println("<body bgcolor=gold >");
					
					out.println("<b><font face=\"Papyrus\" size=36><center>");
					out.println("<big>Categories..<br></big></center>");
					
					
					
					out.println("<A href=\"Signin\"><font size=4 face=\"Comic Sans MS\" color=maroon>");
					out.println("<< sign out</A><br>");
					
					out.println("<ul type=disc>");
					out.println("<font face=\"Maiandra GD\" color=black size=4>");
					out.println("<li type=square>Please make your selection from the table below ..");
					out.println("</li></font><br><br>");
					
					out.println("<form action=\"http://localhost:8080/servlet/SessionHistory\">");
					out.println("<input type=\"submit\" value=\" Save to list\">");
					out.println("<font face=\"High Tower Text\" color=black size=4>>> moves Category..</font>");

					
					out.println("<font face=\"Mistral\" size=20 color=#208234><center>History</center>");
					
					out.println("<table align=center border=3 cellspacing=2 ");
					out.println("cellpadding=3 bgcolor=#EDDA74 bordercolor=#7D0541 width=75%>");
					out.println("<tr align=center>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Add to list</font></b></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Code</font></b></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Name<font></b></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Author</font></b></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Price in Rs.</font></b></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Category</b></font></td>");
					out.println("<td><font face=\"Rockwell\" size=3><b>Quantity</b></font></tr>");
					out.println("</tr>");
					
				    
				    while(rs.next())
				    {
				      String sub=rs.getString(5);
				      int s=rs.getInt(3);
				      if(sub.equals("History")==true)
				  	  {
						   out.println("<tr align=center>");
						   out.println("<td><input type=checkbox name=History value="+s+"></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+s+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(1)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(2)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getInt(4)+"</font></td>");
						   out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+sub+"</font></td>");
						   out.println("<td><input type=text name="+s+"></td>");
						   out.println("</tr>");
					  }//if
    				}//while
    				
    				out.println("</font></table><br></form>");
								
					out.println("</body>");
						
					
			}//try
		
		catch(Exception e)
		{
		}

    out.println("</html>");
    
    }//service
}//class