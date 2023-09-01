<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compound Results!</title>
<link href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%@ include file="common/navigation.jspf"%>


	<div class="container">
		<div class="col-xs-md-14">


			<div class="row" style="margin-bottom: 30px">




				<div class="col-md-10">
					<div class="row">

						<div class="col-md-6"
							style="background-color: gray; margin-left: 250px; border: 1px solid black; padding-top: 8px; padding-bottom: 8px; padding-left: 8px; padding-right: 8px;">
							<table class="table table-striped">
								<thead>
									<tr class="table-light">
										<th>Patient Details:</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Name:</td>
										<td>${patient.firstName}</td>
									</tr>
									<tr>
										<td>Mobile:</td>
										<td>${patient.mobile}</td>
									</tr>
									<tr>
										<td>Email:</td>
										<td>${patient.email}</td>
									</tr>
									<tr>
										<td>Joined Date:</td>
										<td>${patient.joinedDate}</td>
									</tr>
									<tr>
										<td>address:</td>
										<td>${patient.address}</td>
									</tr>

								</tbody>
							</table>
						</div>






					</div>


					<div
						class="row height d-flex justify-content-center align-items-center"
						style="margin-top: 20px">


						<div class="col-md-8">

							<div class="search">
								<i class="fa fa-search"></i> <input type="text"
									class="form-control" placeholder="Search for a compound">
							</div>

						</div>

						<div class="col-md-3">

							<button class="btn btn-primary">Search</button>
							<a class="btn btn-success"
								href="/add-result-to-patient?patient_id=${patient.id}">Add+</a>



						</div>

					</div>







				</div>







			</div>





			<c:if test="${size<=0}">

				<div class="row">
					<h5 align="center" style="color: red">No data found......</h5>
				</div>
				<br>


			</c:if>







			<div class="row">
				<table class="table table-striped table-hover">
					<thead>
						<tr class="table-light">
							<th>Id</th>
							<th>Name</th>

							<th>Value</th>
							<th>Date</th>

							<th></th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${patient.results}" var="i">
							<tr>
								<td>${i.id}</td>
								<td>${i.compound.name}</td>

								<td>${i.val}</td>
								<td>${i.date}</td>

								<td><a class="btn btn-success"
									href="/update-result-to-patient?result_id=${i.id}">Update</a></td>


								<!--  <td><a class="btn btn-warning"
									href="/user/delete-todo/${i.id}">Delete</a></td>
								 -->




							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>

		</div>

	</div>
	<%@ include file="common/footer.jspf"%>


</body>
</html>