/* SessionFiction */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;

public class SessionFiction extends HttpServlet
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
  	  	
    	String bnm[]=req.getParameterValues("Fiction");
    	
    	String qty[]=new String[bnm.length];
    	ArrayList al1=new ArrayList();
  		ArrayList al2=new ArrayList();
  		for(int i=0;i<bnm.length;i++)
  		{
		  	qty[i]=req.getParameter(bnm[i]);
		  	al1.add(bnm[i]);
		  	al2.add(qty[i]);		  
  		}
  		
  		HttpSession HSession=req.getSession(true);
  		
  		ArrayList alo1 = (ArrayList)HSession.getValue("bNames");
  		ArrayList alo2 = (ArrayList)HSession.getValue("bQty");
  		
  		al1.addAll(alo1);
  		al2.addAll(alo2);
  		
		HSession.putValue("bNames",al1);
		HSession.putValue("bQty",al2);
		
		
		out.println("<html>");
		out.println("<title>Categories..</title>");
		out.println("<body bgcolor=gold >");
		
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
		
		out.println("<center><form action=\"http://localhost:8080/servlet/FinalList\">");
		out.println("<input type=submit value=\" Finalize List >>\"></form>");
		
		out.println("<font face=\"Maiandra GD\" color=black size=4>");
		out.println("Moves to final List..</center>");
		
		out.println("</font></body>");
		out.println("</html>");
        
   	}//service
}//class