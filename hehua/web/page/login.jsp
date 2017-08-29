<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>

<%@ page import="org.jasig.cas.client.authentication.*"%>

<%@page import="org.jasig.cas.client.validation.Assertion"%>
<%@page import="org.jasig.cas.client.util.AbstractCasFilter"%>
<%@page import="org.jasig.cas.client.authentication.AttributePrincipal"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
	String username = principal.getName();
	
	String currentlogincookie = "{'username':'" + username + "'}";
	System.out.println(currentlogincookie+"****************");
	Cookie cookie = new Cookie("currentlogincookie", URLEncoder.encode(currentlogincookie, "UTF-8"));	
	response.addCookie(cookie);

%>

