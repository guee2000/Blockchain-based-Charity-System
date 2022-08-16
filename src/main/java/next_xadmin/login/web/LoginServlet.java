package next_xadmin.login.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next_xadmin.login.bean.LoginBean;
import next_xadmin.login.database.LoginDao;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String usrInput = request.getParameter("usrInput");
		String pwdInput = request.getParameter("pwdInput");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsrInput(usrInput);
		loginBean.setPwdInput(pwdInput);
	
		LoginDao loginDao = new LoginDao();
		
		PrintWriter out = response.getWriter();
		if(loginDao.validate(loginBean))
			{
			
			int showuserid = LoginDao.showUserId(loginBean);
			String showuserid1 = Integer.toString(showuserid);
			System.out.println(showuserid1);
			
			request.setAttribute("showuserid1",showuserid1); // set your String value in the attribute
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
//            out.println("<script src='https://code.jquery.com/jquery-2.1.3.min.js'</script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Login','successful!','success');");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("selectCharity.jsp");
            rd.include(request,response);
            
//            out.println("$(document).ready(setTimeout(function() {");
//            out.println("swal({'Log out','Successful!', 'success'},");
//            out.println("function() {");
//            out.println("window.location='login.jsp';");
//            out.println("});");
//            out.println("}), 1000)");
            
//			request.getRequestDispatcher("selectCharity.jsp").forward( request, response );
      
			request.getSession().setAttribute("showuserid1", showuserid1);

			String userstate = LoginDao.showuserstate(loginBean);
			System.out.println(userstate);
			request.getSession().setAttribute("userstate", userstate);

			
			}
		else {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<script language=JavaScript>");
            out.println("$(document).ready(function(){");
            out.println("swal('Login','failed!','error');");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.include(request,response);
//			response.sendRedirect("login.jsp");
		}
	}

}
