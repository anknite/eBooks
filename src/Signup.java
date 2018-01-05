import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Signup extends HttpServlet
{
  	public void init(ServletConfig sc)throws ServletException
	{
	   super.init(sc);
	}

  	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
    	  Connection con;
		  PreparedStatement pst;
		  Statement st;
		  ResultSet rs;
		  int flag=0;
		  res.setContentType("text/Html");
		  PrintWriter out=res.getWriter();
		  
		  String fnm=req.getParameter("fname");
		  String lnm=req.getParameter("lname");
		  String date=req.getParameter("dob");
		  String gdr=req.getParameter("gender");
		  String usid=req.getParameter("uid");
		  String pswd=req.getParameter("pwd");
		  String adr=req.getParameter("addr");
		  String cty=req.getParameter("city");
		  String stat=req.getParameter("state");
		  String cntry=req.getParameter("country");
		  String eml=req.getParameter("email");
		  out.println("<html>");
  		try
  		{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		con=DriverManager.getConnection("jdbc:odbc:BookDb"," "," ");
    		pst=con.prepareStatement( "insert into Usertab values(?,?,?,?,?,?,?,?,?,?,?)");
		    st=con.createStatement();
		    rs=st.executeQuery("Select * from Usertab");
		    
		    while(rs.next())
		    {
		    	String user=rs.getString(5);
		    	if(user.equals(usid))
		    	{
		    		flag=1;
		    		
		    		out.println("<title>Sign up..</title>");
						out.println("<body bgcolor=#FFFFCC");
						
						out.println("<form method=\"POST\" action=\"http://localhost:8080/servlet/Signup\">");
						
						out.println("<font size=50 color=green>");
						out.println("<center>NEW USER (Sign Up)</center>");
						out.println("</font>");
						out.println("<br><br>");
						out.println("<marquee behavior=\"alternate\" color=#0023FF>"); 
						out.println("Enter your information here..</marquee>");
						out.println("<br><br>");
						
						out.println("<center><font size=4 face=\"Lucida Handwriting\" align=center color=purple>");
						out.println("Sorry !! the desired user id is not available <br>");
						out.println("Please enter a different user id.. ");
						out.println("</font></center><br>");
										
						out.println("First Name :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"fname\"><br><br>");
						
						out.println("Last Name :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"lname\"><br><br>");
						
						out.println("Date of Birth :");
						out.println("&nbsp;<input type=text name=\"dob\"><br><br>");
						
						out.println("Gender :");
						out.println(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"gender\">");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("(note- Enter 'M' for male and 'F' for female )<br><br>");
						
						out.println("user id :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"uid\"><br><br>");
						
						out.println("Password :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=password name=\"pwd\"><br><br>");
						
						out.println("Address :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<textarea rows=5 columns=5 name=\"addr\"></textarea><br><br>");
						
						out.println("City :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"city\"><br><br>");
						
						out.println("State :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"state\"><br><br>");
						
						out.println("Country :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"country\"><br><br>");
						
						out.println("e-mail id :");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input type=text name=\"email\"><br><br>");
						
						out.println("<input type=submit name= \"submit\" value=\"submit\">");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<input id=reset name=reset onclick=javascript:Reset() type=reset value=Reset>");
						out.println("</form></body>");
		    		
		    		break;
		    	}//if
		    }//while
		    	
		    if(flag==0)
		    {
		    	 pst.setString(1,fnm);
				 pst.setString(2,lnm);
				 pst.setString(3,date);
				 pst.setString(4,gdr);
				 pst.setString(5,usid);
				 pst.setString(6,pswd);
				 pst.setString(7,adr);
				 pst.setString(8,cty);
				 pst.setString(9,stat);
				 pst.setString(10,cntry);
				 pst.setString(11,eml);
				 pst.executeUpdate();
		     	 
		     	 out.println("<title>Sign up proceed..</title>");
					out.println("<body bgcolor=pink>");
					
					out.println("<form action=\"http://localhost:8080/servlet/Signin\">");
					out.println("<font size=36 align=center color=black>");
					out.println("You have successfully Signed up..");
					out.println("</font><br><br><br><br>");
					
					out.println("<center><font size=18 face=\"Script MT Bold\" color=navy>Thank You !!<br>");
					out.println("for registering with us");
					out.println("</font></center><br><br>");
					
					out.println("<font face=\"Tempus Sans ITC\" color=#804000><b>");
					out.println("Please click Back button for Signing in and getting started..</b>");
					out.println("<br><br>");
					out.println("<button type=submit><b><< back</b></back></button><br><br></font>");
					out.println("</body>");
		    
		    
		    
		    
		    }//if
     		
     		st.close();
     		pst.close();
    		con.close();
   
		}//try
    catch(Exception e)
	{
  		System.out.println("Exception Occurred:"+e);
	}
	out.println("</body></html>");
 }//service
}//class
  
      
    
