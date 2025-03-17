<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update Students Details</title>
		 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
		 
	</head>
	<body>
		<div class="container mt-4">
	        <h2>Update Student Password</h2>
	        <form action="UpdateServlet" method="post" onsubmit="return validatePasswords()">
	            <div class="mb-3">
	                <label>Student First Name:</label>
	                <input type="text" name="firstName" class="form-control" required>
	            </div>
	            <div class="mb-3">
	                <label>Password:</label>
	                <input type="password" id="password" name="password" class="form-control" required>
	            </div>
	            <div class="mb-3">
	                <label>Confirm Password:</label>
	                <input type="password" id="confirmPassword" class="form-control" required>
	            </div>
	            <button type="submit" class="btn btn-primary w-100">Update</button>
	        </form>
	    	 <div class="d-grid gap-2 mt-3">
	            <a href="dashboard.jsp" class="btn btn-primary">Back To View Students Details</a>
	        </div>
    </div>
    	
    	<script src="js/script.js"></script>
	</body>
</html>