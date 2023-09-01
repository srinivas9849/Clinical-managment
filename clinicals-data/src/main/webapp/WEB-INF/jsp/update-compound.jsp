<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Todo!</title>
<link href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
<%@ include file="common/form-styling.jspf" %>


</head>
<body>

<%@ include file="common/navigation.jspf" %>


	<div class="container">
		<div class=col-xs-md-14>
			<div class="row">
			   <div class="col-md-8">
					<div class="row">

						<h3 align="center">Test Details</h3>
					</div>
			
	
				<div class=row
					style="margin-left: 150px; border: 1px solid black;">
				<form:form method="post" action="/update-compound" modelAttribute="compound">

					<div class="form-group">
						<label for="id" hidden="true">Id</label> 
						<form:input type="number" cssClass="form-control" path="id" hidden="true" />
					</div>
					<div class="form-group">
						<label for="name">Name</label> <form:input type="text"
							cssClass="form-control" path="name" placeholder="name"/>
							
					</div>
					<div class="form-group">
						<label for="desc">Description</label> <form:textarea type="text"
							cssClass="form-control" path="desc" placeholder="description"/>
							
					</div>
					
					<br>
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-success">Clear</button>
					<a class="btn btn-warning" href="/user/list-todos">Cancel</a>

				</form:form>
				</div>
				
					
			</div>








		</div>
		</div>


	</div>
	
	<%@ include file="common/footer.jspf" %>
	
</body>
</html>