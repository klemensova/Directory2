package cz.directory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerInterface {

	public String handle(HttpServletRequest request, HttpServletResponse response);
}
