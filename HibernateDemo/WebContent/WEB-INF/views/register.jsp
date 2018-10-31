<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
console.log('${user}'');
</script>
</head>

<body>

	<form action="/HibernateDemo/user/add"  method="post" id="userForm"  >
						<!-- To Show Global Error -->
						<div class="row">
							<div class="col-lg-4 col-md-4 col-sm-6">
								<div class="form-group">
		    						<label for="userName">Username *</label>
		    						<input type="text" name="userName">
		  						</div>
		  						
		  						<div class="form-group">
		    						<label for="Password">Password *</label>
		    						<input type="password" name="password">
		  						</div>
		  						
		  						<div class="form-group">
		    						<label for="firstName">First Name</label>
									<input type="text" name="firstName">
		  						</div>
		  						<div class="form-group">
		    						<label for="lastName">Last Name</label>
		    						<input type="text" name="lastName">
		  						</div>
		  						
		  						<div class="form-group">
		    						<label for="Email">Email</label>
									<input type="text" name="email">
		  						</div>
		  						
		  					
		  				</div>
		  				</div>
  						<input type="submit" value="Register User" class="btn btn-success">
					</form>
</body>
</html>