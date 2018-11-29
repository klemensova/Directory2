package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.bean.Entry;
import cz.directory.dao.DirectoryDao;

public class DeleteCtrl implements ControllerInterface  {
	
	private DirectoryDao instanceDao = new DirectoryDao();
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		Integer idDir =Integer.valueOf(request.getParameter("idRadio"));
		Entry newEntry = new Entry();
		newEntry.setIdDir(idDir);
		instanceDao.deleteEntry(idDir);
	
		// TODO Auto-generated method stub
		return  "/actionservlet?action=writeList";
	}

}
