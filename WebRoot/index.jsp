<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html>
 <head></head>
   <body>
	<jsp:include page='<%="/servlet/bookServlet?type=homepageTypes"%>' flush="true" />	
   </body>
 </html>
