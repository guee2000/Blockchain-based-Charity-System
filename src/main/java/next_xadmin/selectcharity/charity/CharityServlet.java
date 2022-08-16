package next_xadmin.selectcharity.charity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next_xadmin.login.bean.LoginBean;
import next_xadmin.login.database.LoginDao;
import next_xadmin.register.RegisterDao;
import next_xadmin.register.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CharityServlet
 */
public class CharityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String projectId = (String) request.getSession().getAttribute("projectId");
		System.out.println(projectId);

		String AmountInput = (String) request.getSession().getAttribute("AmountInput");
		Long AmountInput1 = Long.parseLong(AmountInput);

		//retrieve userid from servlet
		String showuserid = (String) request.getSession().getAttribute("showuserid1");
		System.out.println(showuserid);
		int showuserid2 = Integer.parseInt(showuserid);
		
		//retrieve user state from servlet
		String showuserstate = (String) request.getSession().getAttribute("userstate");
		System.out.println(showuserstate);

		//pass the variable into the constructor
		Block block = new Block(projectId,AmountInput1,showuserid2,showuserstate);


		CharityDao cDao = new CharityDao();

		String result = cDao.insert(block);

		System.out.println(projectId);
		System.out.println(result);
		PrintWriter out = response.getWriter();
		if (projectId.equals("1001")  && result.equals("Transaction is successful!") ){
		
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Transaction','successful!','success');");
            out.println("});");
            out.println("</script>");
            
            RequestDispatcher rd=request.getRequestDispatcher("donationRecord1.jsp");
            rd.include(request,response);
		}
		else if (projectId.equals("1002") && result.equals("Transaction is successful!")) {
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Transaction','successful!','success');");
            out.println("});");
            out.println("</script>");
            
            RequestDispatcher rd=request.getRequestDispatcher("donationRecord2.jsp");
            rd.include(request,response);
		}
		else if (projectId.equals("1003") && result.equals("Transaction is successful!")) {
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Transaction','successful!','success');");
            out.println("});");
            out.println("</script>");
            
            RequestDispatcher rd=request.getRequestDispatcher("donationRecord3.jsp");
            rd.include(request,response);
            
//			out.println("<script type=\"text/javascript\">");
//		    out.println("alert('Transaction is successful!');");
//		    out.println("location='charityRecord3.jsp';");
//		    out.println("</script>");
            
           
		}
		else {
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Transaction','failed!','error');");
            out.println("});");
            out.println("</script>");
            
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.include(request,response);
			
		}
		
	}

}
