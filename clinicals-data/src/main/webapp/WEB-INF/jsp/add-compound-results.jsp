<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Results!</title>
<link href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
<%@ include file="common/form-styling.jspf"%>


</head>
<body>

	<%@ include file="common/navigation.jspf"%>


	<div class="container">
		<div class=col-xs-md-14>
		    <div class="row">
			   <div class="col-md-8">
					<div class="row">

						<h3 align="center">Compound Results of ${patient_name} ${p_id}</h3>
					</div>
				
			
			   
				<div class=row
					style="margin-left: 150px; border: 1px solid black;">
					<form:form method="post" action="/add-compound-result"
						modelAttribute="result">

						<div class="form-group">
							<label for="id" hidden="true">Id</label>
							<form:input type="number" cssClass="form-control" path="id"
								hidden="true" />
						</div>


						<div class="form-group">
							<label for="val">Value</label>
							<form:input type="text" cssClass="form-control" path="val"
								placeholder="Value" />

						</div>
						<div class="form-group">
							<label for="desc">Description</label>
							<form:textarea type="text" cssClass="form-control" path="desc"
								placeholder="description" />

						</div>

						<div class="form-group">
							<label for="date"></label> Taken Date
							<form:input type="date" cssClass="form-control" path="date"
								placeholder="date" />
							<div><form:errors path="date" cssStyle="color: orange;font-size: 17px;"/></div>
							

						</div>


						<div class="form-group">

							<label for="compound_id">Compound</label>
							<form:select cssClass="form-select" path="compound_id">
								<c:forEach items="${compounds}" var="i">
									<form:option value="${i.id}"> ${i.name}</form:option>
								</c:forEach>

							</form:select>

						</div>


						<div class="form-group">
							<form:input type="number" hidden="true"
								path="patient_id" value="${p_id}" />
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

	<%@ include file="common/footer.jspf"%>

</body>
</html>