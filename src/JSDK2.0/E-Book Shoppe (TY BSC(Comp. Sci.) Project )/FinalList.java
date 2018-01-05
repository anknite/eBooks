/* FinalList */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;

public class FinalList extends HttpServlet
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
    	
    	HttpSession HSession=req.getSession(true);
    	ArrayList al1=(ArrayList)HSession.getValue("bNames");
 		ArrayList al2=(ArrayList)HSession.getValue("bQty");
 		
    	for(int i = 0 ; i < al1.size() ; i++)
    	{
    		System.out.println("Book : " + al1.get(i));
    	}
    	
    	out.println("<html>");
		
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:BookDb","","");
		
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("Select * from BookTab");
			int cost=0;
			
			out.println("<title>List..</title>");
			out.println("<body bgcolor=pink>");
			
			out.println("<font size=36 align=center color=#347235>");
			out.println("<center>Purchase List</center><br>");
			
			out.println("<A href=\"Signin\"><font size=4 face=\"Comic Sans MS\" color=maroon>");
			out.println("<< sign out</A><br>");
			
			out.println("<font face=\"Mistral\" size=10 color=navy> You have selected the following books for");
			out.println("purchase..!!</font><br><br>");
			
			out.println("<font face=\"Mistral\" size=20 color=#208234><center>Final List</center>");
					
			out.println("<table align=center border=3 cellspacing=2 ");
			out.println("cellpadding=3 bgcolor=#EDDA74 bordercolor=#7D0541 width=75%>");
			out.println("<tr align=center>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Code</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Name<font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Author</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Price in Rs.</font></b></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Category</b></font></td>");
			out.println("<td><font face=\"Rockwell\" size=3><b>Quantity</b></font></tr>");
			out.println("</tr>");


			System.out.println("Start Seearch...");
			for(int i=0;i<al1.size();i++)
			{
				rs.beforeFirst();
				while(rs.next())
				{
					String scode = rs.getString(3);
					System.out.println(scode + " " + al1.get(i));
					if(scode.equals((String)al1.get(i)))
					{
						int price = rs.getInt(4);
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+scode+"</font></td>");
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(1)+"</font></td>");
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(2)+"</font></td>");
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+price+"</font></td>");
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+rs.getString(5)+"</font></td>");
						out.println("<td><font face=\"MS Reference Sans Serif\" size=3>"+al2.get(i)+"</font></td>");
						out.println("</tr>");
					
						cost=cost+(Integer.parseInt((String)al2.get(i)))*price;   //cost calulation
					
					}//if
				}//while
			}//for
			
			
			Integer billamt=new Integer(cost);
			HSession.putValue("ba",billamt);
			
			
			
			out.println("<center><font face=\"Maiandra GD\" size=6>");
			
						
			out.println("<form action=\"http://localhost:8080/servlet/Pay1\">");
			out.println("Bill amount: <input type=text name=\"amt\" value="+cost+"><br><br>");
			out.println("<input type=\"submit\" value=\" Pay Now !!\">");
			out.println("<font face=\"High Tower Text\" color=black size=4>>> to payment mode..</font></form></body>");
			
			out.println("</html>");
			out.close();
     		rs.close();
     		st.close();
     		con.close();
		}//try

   		catch(Exception e)
  		{
    		System.out.println("Exception Occured:"+e);
  		}//catch
	}//service
}//class
			