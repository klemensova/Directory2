package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.bean.Entry;
import cz.directory.dao.DirectoryDao;

public class UpdateCtrl implements ControllerInterface {
	private DirectoryDao instanceDao = new DirectoryDao();

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		Integer idDir =Integer.valueOf( request.getParameter("idDir"));
		
		String newFirstname = request.getParameter("firstname");
		String newSurname = request.getParameter("surname");
		String newPhoneNumber = request.getParameter("phoneNumber");
		Entry newEntry = new Entry();
		newEntry.setIdDir(idDir);
		newEntry.setFirstname(newFirstname);
		newEntry.setSurname(newSurname);
		newEntry.setPhoneNumber(newPhoneNumber);
		instanceDao.updateEntry(idDir, newEntry);

		return "/actionservlet?action=writeList";
	}

}
