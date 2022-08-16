package next_xadmin.register;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String fnameInput = request.getParameter("fnameInput");
		String lnameInput = request.getParameter("lnameInput");
		String stateInput = request.getParameter("stateInput");
		String phonenumInput = request.getParameter("phonenumInput");
		String emailInput = request.getParameter("emailInput");
		String pwdInput = request.getParameter("pwdInput");
		String pwdInput2 = request.getParameter("pwdInput2");

		PrintWriter out = response.getWriter();
		
		User user = new User(usrInput,fnameInput,lnameInput,stateInput,phonenumInput,emailInput,pwdInput);
		RegisterDao rDao = new RegisterDao();
		boolean result = rDao.checkexsist(user);
		System.out.println(result);
		if(rDao.checkexsist(user)) {
			  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
	          out.println("<script language=JavaScript>");
	          out.println("$(document).ready(function(){");
	          out.println("swal('Username','has been taken!','error');");
	          out.println("});");
	          out.println("</script>");
//			response.sendRedirect("memberRegistration.jsp");
	          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
	          rd.include(request,response);
		}
		else {
		 if(rDao.checkusername(usrInput)) {
			if(rDao.isWord(fnameInput)&& !(fnameInput.equals(lnameInput))) {
				if(rDao.isWord(lnameInput)) {
					if (rDao.validatePhone(phonenumInput)) {
						if (rDao.validateEmail(emailInput)) {
							if (pwdInput.equals(pwdInput2)){
								if (rDao.checkpass(pwdInput)) {
									String result1 = rDao.insert(user);
									if (result1 == "Data is entered successfully") {
									
										out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
							            out.println("<script language=JavaScript>");
							            out.println("$(document).ready(function(){");
							            out.println("swal('Register','successful!','success');");
							            out.println("});");
							            out.println("</script>");
						//				response.sendRedirect("login.jsp");
										RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
							            rd.include(request,response);
									
									}
								}
								else {
									  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
							          out.println("<script language=JavaScript>");
							          out.println("$(document).ready(function(){");
							          out.println("swal('Password','should contains at least 1 numeric character, 1 lower case, 1 uppercase and password length should be between 8 to 20!','error');");
							          out.println("});");
							          out.println("</script>");
					//				response.sendRedirect("memberRegistration.jsp");
							          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
							          rd.include(request,response);
								}
								
			
							}
							else {
								  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
						          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
						          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
						          out.println("<script language=JavaScript>");
						          out.println("$(document).ready(function(){");
						          out.println("swal('Password','does not match with Confirm Password!','error');");
						          out.println("});");
						          out.println("</script>");
				//				response.sendRedirect("memberRegistration.jsp");
						          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
						          rd.include(request,response);
							}
				
						}
						else {
							  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
					          out.println("<script language=JavaScript>");
					          out.println("$(document).ready(function(){");
					          out.println("swal('Email','not a valid email format','error');");
					          out.println("});");
					          out.println("</script>");
			//				response.sendRedirect("memberRegistration.jsp");
					          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
					          rd.include(request,response);
							}
		//		String result1 = rDao.insert(user);
		//		response.getWriter().print(result);
				
					}
					else {
						  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
				          out.println("<script language=JavaScript>");
				          out.println("$(document).ready(function(){");
				          out.println("swal('Phone Number','not a valid phone number format and please insert at least 10 or 11 numbers','error');");
				          out.println("});");
				          out.println("</script>");
		//				response.sendRedirect("memberRegistration.jsp");
				          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
				          rd.include(request,response);
						
					}
				}
				else {
					  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
			          out.println("<script language=JavaScript>");
			          out.println("$(document).ready(function(){");
			          out.println("swal('Last Name','not in the alphabet format or found spacing in your name!','error');");
			          out.println("});");
			          out.println("</script>");
	//				response.sendRedirect("memberRegistration.jsp");
			          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
			          rd.include(request,response);
				}
			}
			else {
				  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
		          out.println("<script language=JavaScript>");
		          out.println("$(document).ready(function(){");
		          out.println("swal('First Name','not in the alphabet format, found spacing in your name or same word with Last Name!','error');");
		          out.println("});");
		          out.println("</script>");
//				response.sendRedirect("memberRegistration.jsp");
		          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
		          rd.include(request,response);
			}
		}
		 else {
			  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	          out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	          out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
	          out.println("<script language=JavaScript>");
	          out.println("$(document).ready(function(){");
	          out.println("swal('Username','cannot fill in punctuation. Username length should be between 7 to 20 words!','error');");
	          out.println("});");
	          out.println("</script>");
//			response.sendRedirect("memberRegistration.jsp");
	          RequestDispatcher rd=request.getRequestDispatcher("memberRegistration.jsp");
	          rd.include(request,response);
		 }
		}
	}
}
