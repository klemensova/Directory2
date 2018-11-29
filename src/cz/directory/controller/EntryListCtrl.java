package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.directory.bean.EntryList;
import cz.directory.dao.DirectoryDao;

public class EntryListCtrl implements ControllerInterface  {
 
	private DirectoryDao instanceDao = new DirectoryDao();

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		
		EntryList entrylist = instanceDao.loadEntrylist();
		request.setAttribute("entrylist", entrylist);
		
		// TODO Auto-generated method stub
		return "/index.jsp";
	}
	
	
}
