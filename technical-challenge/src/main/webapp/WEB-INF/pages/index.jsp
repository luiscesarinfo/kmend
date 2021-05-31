<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Manager</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Bootstrap -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

		<!-- DataTables -->
		<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

		<!-- Chart.js -->
		<script src="https://cdn.jsdelivr.net/npm/chart.js@3.3.1/dist/chart.min.js"></script>


		<script src="<c:url value="/resources/js/kmend-util.js" />"></script>
		<script src="<c:url value="/resources/js/kmend-script.js" />"></script>
	</head>
	<body>
		<form method="get" action=""></form>
		<div class="container">
			<h2>Users Line Chart</h2>
			<div class="container">
				<div class="row">
					<div class="col-sm">
					    <label for="minimalSpend">Minimal spend</label><br />
		    			<input type="range" id="minimalSpend" name="filterMinimalSpend" min="0" max="5000" value="0">
					    <label id="rangeSelected"></label>					
					</div>
					<div class="col-sm">
		    			<label for="regionDropdown">Select region:</label><br />
						<select name="regions" id="regions" style="width: 150px" >
							<option value="all">All regions</option>
							<option value="APAC">APAC</option>
							<option value="EUROPE">Europe</option>
							<option value="LATIN_AMERICA">Latin America</option>
							<option value="UNITED_STATES">United States</option>
						</select>
					</div>
				</div>
			</div>

			<canvas id="usersLineChart" width="400" height="100"></canvas>
			<br />
			<h2>Users Table</h2>
			<table id="usersTable" class="table table-sm table-striped" style="width:100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Birthday</th>
						<th>Spend</th>
						<th>Region</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</body>
	<script type="text/javascript">
	//<![CDATA[
		$(document).ready(function() {
			init();
		});
	//]]>
	</script>

</html>