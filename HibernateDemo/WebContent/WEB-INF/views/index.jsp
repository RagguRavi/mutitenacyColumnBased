<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" >
	function saveEmployee() {
		var firstName = $("#firstName").val();
			var lastName = $("#lastName").val();
		var tenantId = $("#tenantId").val();
		
		var employee = {
				"firstName":firstName,
				"lastName":lastName,
				"tenantId":tenantId
		}
		console.log(employee)
		$.ajax({
			url : "employees/saveEmploye",
			type : "POST",
			dataType : 'json',
			contentType : "application/json",
			data : JSON.stringify(employee),
			beforeSend : function(xhr) {
				xhr.setRequestHeader('X-TenantID',tenantId)
			},
			success : function(data) {
				console.log(data)
			},
			complete : function() {

			},
			error : function(e, type, message) {
				console.error("Error in saving appointment: " + message);
			}
		});
	}
	
	function getEmployeList() {
		var tenantId = $("#findingTenantId").val();
		console.log(tenantId);
		$.ajax({
			url : "employees/listEmploye",
			type : "GET",
			contentType:"application/json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader('X-TenantID',tenantId);
			},
			success : function(data) {
				$("#tableBody").empty();
				for(var i=0;i<data.length;i++) {
					console.log(data[i]);
					var temp = data[i];
					var html = "<tr><td>"+temp.firstName+"</td><td>"+temp.lastName+"</td><td>"+temp.tenantId+"</td><tr>";
					$("#tableBody").append(html);
				}
			},
			complete : function() {

			},
			error : function(e, type, message) {/* priya57182 */
				console.error("Error in saving appointment: " + message);
			}
		});
	}
	
function getAllTenantEmployee() {
		$.ajax({
			url : "employees/check",
			type : "GET",
			contentType:"application/json",
			beforeSend : function(xhr) {
			},
			success : function(data) {
				console.log(data)
				$("#tableBody").empty();
				for(var i=0;i<data.length;i++) {
					console.log(data[i]);
					var temp = data[i];
					var html = "<tr><td>"+temp.firstName+"</td><td>"+temp.lastName+"</td><td>"+temp.tenantId+"</td><tr>";
					$("#tableBody").append(html);
				}
			},
			complete : function() {

			},
			error : function(e, type, message) {
				console.error("Error in saving appointment: " + message);
			}
		});
	}
</script>
<style type="text/css">
div {
margin: 10px

}
span {
margin-right: 10px;	
}

table, th, td {
    border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h2>Hello everyone in views</h2>
	<div id="addEmploye">
		<div><span>First Name</span><input type="text" name="firstName" id="firstName" placeholder="Enter first name"></div>
		<div><span>Last Name</span><input type="text" name="lastName" id="lastName" placeholder="Enter last name"></div>
		<div><button onclick="saveEmployee()">save employee</button></div>
	</div>
	<br/>
	<hr/>
	<br>
	<div>
		<div><button onclick="getEmployeList()">see Employee</button></div>
	</div>
	
	<div>
		<div><button onclick="getAllTenantEmployee()">Get All Employee</button></div>
	</div>

	<div>
		<table>
			<thead>
				<tr><th>First Name</th>
				<th>Last Name</th>
				<th>Tenant</th>
				</tr>
			</thead>
			<tbody id="tableBody">
			
			</tbody>
		</table>

	</div>
</body>

</html>	