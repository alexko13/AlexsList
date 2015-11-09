<jsp:useBean id="allListings" class="java.util.ArrayList"
	scope="application" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listings</title>
</head>
<body>

	<p><a href="index.html">Home</a></p>

	<h1>Listings Below</h1>

	<%for (Object listing : (allListings.toArray())) {%>
	<p><%=((String) listing)%></p>
	<%}%>

</body>
</html>