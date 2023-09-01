<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Patient!</title>
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

						<h3 align="center">Patients Details</h3>
					</div>
			
	
				<div class=row
					style="margin-left: 150px; border: 1px solid black;">
				<form:form method="post" action="/update-patient" modelAttribute="patient">

					<div class="form-group">
								<label for="id" hidden="true">Id</label>
								<form:input type="number" cssClass="form-control" path="id"
									hidden="true" />
							</div>
							<div class="form-group">
								<label for="firstName">First Name</label>
								<form:input type="text" cssClass="form-control" path="firstName"
									placeholder="First name" />
									<div><form:errors path="firstName" cssStyle="color: orange;font-size: 17px;"/></div>
							</div>
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<form:input type="text" cssClass="form-control" path="lastName"
									placeholder="Last name" />
									<div><form:errors path="lastName" cssStyle="color: orange;font-size: 17px;"/></div>
									

							</div>

							<div class="form-group">
								<label for="mobile">Mobile Number</label>
								<form:input type="text" cssClass="form-control" path="mobile"
									placeholder="Mobile number" />
									<div><form:errors path="mobile" cssStyle="color: orange;font-size: 17px;"/></div>
									

							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<form:input type="text" cssClass="form-control" path="email"
									placeholder="email" />
									<div><form:errors path="email" cssStyle="color: orange;font-size: 17px;"/></div>
									

							</div>

							<div class="form-group">
								<label for="address">Address</label>
								<form:textarea type="text" cssClass="form-control"
									path="address" placeholder="address" />
									<div><form:errors path="address" cssStyle="color: orange;font-size: 17px;"/></div>
									

							</div>
							<div class="form-group">
								<label for="joinedDate">Joined Date</label>
								<form:input type="date" cssClass="form-control"
									path="joinedDate" />
									<div><form:errors path="joinedDate" cssStyle="color: orange;font-size: 17px;"/></div>
							

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