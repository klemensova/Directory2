package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cz.directory.bean.EntryList;
import cz.directory.dao.DirectoryDao;



public class SelectCtrl implements ControllerInterface {
	
	private DirectoryDao instanceDao = new DirectoryDao();
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	String newSurname = request.getParameter("select");
	System.out.println(newSurname);
	EntryList entrylist = instanceDao.selectEntry(newSurname);
	if(entrylist != null && entrylist.getEntrylist().size()  > 0) {
		
	request.setAttribute("entrylist", entrylist);
	}
	return "/index.jsp";

	
	

	}
}
