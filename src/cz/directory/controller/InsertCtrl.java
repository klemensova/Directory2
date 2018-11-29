package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.bean.Entry;
import cz.directory.dao.DirectoryDao;

public class InsertCtrl implements ControllerInterface {

	private DirectoryDao instanceDao = new DirectoryDao();
	
	
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		 String newFirstname = request.getParameter("firstname");
		 String newSurname = request.getParameter("surname");
		 String newPhoneNumber = request.getParameter("phoneNumber");
		 Entry newEntry = new Entry();
		 newEntry.setFirstname(newFirstname);
		 newEntry.setSurname(newSurname);
		 newEntry.setPhoneNumber(newPhoneNumber);
		 instanceDao.saveEntry(newEntry);
		 
		return "/actionservlet?action=writeList";
	}

}
