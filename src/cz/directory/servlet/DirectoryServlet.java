package cz.directory.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.controller.DeleteCtrl;
import cz.directory.controller.EntryListCtrl;
import cz.directory.controller.InsertCtrl;
import cz.directory.controller.SelectCtrl;
import cz.directory.controller.ShowCtrl;
import cz.directory.controller.UpdateCtrl;


/**
 * Servlet implementation class DirectoryServlet
 */
@WebServlet("/actionservlet")
public class DirectoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = "";
		
		String action = request.getParameter("action");
		
		switch(action) {
		
		case"add":
			InsertCtrl record = new InsertCtrl();
			redirect = record.handle(request, response);
			break;
		
	  case "writeList":
	    	EntryListCtrl writeList = new EntryListCtrl();
	        redirect = writeList.handle(request,response);
	    break;
		
		case"del":
			DeleteCtrl delEntry = new DeleteCtrl();
			redirect = delEntry.handle(request, response);
			break;
			
		case"edit":
			ShowCtrl writeEntry = new ShowCtrl();
			redirect = writeEntry.handle(request, response);
			break;
			
		case"update":
			UpdateCtrl updateEntry = new UpdateCtrl();
			redirect = updateEntry.handle(request, response);
			break;
			
		case"select":
			SelectCtrl selectEntry = new SelectCtrl();
			redirect = selectEntry.handle(request, response);
			break;
			
		}	
		
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher(redirect).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
