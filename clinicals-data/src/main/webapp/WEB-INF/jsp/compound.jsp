<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compounds!</title>
<link href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%@ include file="common/navigation.jspf"%>


	<div class="container">
		<div class="col-xs-md-14">

			<div class="row" style="margin-bottom: 30px">



				<div
					class="row height d-flex justify-content-center align-items-center">

					<div class="col-md-10">
						<form action="/compound-search" method="get">
							<div class="row">


								<div class="col-md-8">

									<div class="search">
										<i class="fa fa-search"></i> <input type="text" name="name"
											class="form-control" placeholder="Search for a compound">
									</div>

								</div>

								<div class="col-md-3">

									<button class="btn btn-primary">Search</button>

									<a class="btn btn-success" href="/add-compound">Add+</a>
									




								</div>
							</div>
						</form>





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

							<th>Description</th>
							<th></th>
							<th></th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${compounds}" var="i">
							<tr>
								<td>${i.id}</td>
								<td>${i.name}</td>

								<td>${i.desc}</td>
								<td><a class="btn btn-success"
									href="/update-compound?id=${i.id}">Update</a></td>
								<td><a class="btn btn-danger"
									href="/delete-compound/${i.id}">Delete</a></td>

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