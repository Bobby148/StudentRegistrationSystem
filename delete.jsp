<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Delete Student Details</title>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	
	</head>
	<body>
		<div class="container mt-4">
		 <h2>Delete Student Details</h2>
	  		<div class="d-grid gap-2 mt-3">
				<a href="UpdateServlet?action=deleteAll" class="btn btn-success">Delete All Students</a>
				<a href="UpdateServlet?action=CSE" class="btn btn-info">Delete CSE Students</a>
	            <a href="UpdateServlet?action=ECE" class="btn btn-warning">Delete ECE Students</a>
	            <a href="UpdateServlet?action=EEE" class="btn btn-success">Delete EEE Students</a>
	            <a href="UpdateServlet?action=MECH" class="btn btn-info">Delete MECH Students</a>
	            <a href="UpdateServlet?action=CIVIL" class="btn btn-warning">Delete CIVIL Students</a>
	   		</div>
	   	</div>
	</body>
</html>