<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<title>Listings</title>
</head>
<body>

	<p><a href="index.html">Home</a></p>

	<h1>Listings</h1>
	<c:forEach var="listing" items="${listings}">
		<p><a href="Detail.do?listing=${listing.name}">${listing.name}</a></p>
	</c:forEach>
</body>
</html>