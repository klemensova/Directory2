package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.bean.Entry;
import cz.directory.bean.EntryList;
import cz.directory.dao.DirectoryDao;


public class ShowCtrl implements ControllerInterface {
	private DirectoryDao instanceDao = new DirectoryDao();

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		Integer idDir =Integer.valueOf(request.getParameter("idRadio"));
		
		EntryList seznam = instanceDao.showEntry(idDir);
		if(seznam != null) {
			Entry loadedEntry = seznam.getEntrylist().get(0);
			request.setAttribute("loadedEntry", loadedEntry);
		}
		// TODO Auto-generated method stub
		return "/update.jsp";
	

	}
}
