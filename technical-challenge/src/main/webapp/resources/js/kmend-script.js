/**
 * 
 */
function init() {
	$.ajax({
	    type : "GET",
	    url : "getUsers",
	    success: function(data) {
			buidPageData(data);
	    }
	});
}

$(function () {
    $('#rangeSelected').text($('#minimalSpend').val());
    $('#minimalSpend').on('input change', function () {
        $('#rangeSelected').text($(this).val());
    });

    $('#minimalSpend').on('mouseup', function () {
		updatePage($("#regions").val(), $(this).val());
    });
    $('#regions').on('change', function () {
		updatePage($(this).val(), $("#minimalSpend").val());
    });
});

function buidPageData(data) {
	buildLineChart(data);
	populateTable(data);
	configDataTable();
}

function buildLineChart(data) {
	var monthlyDataSet = getTotalByMonth(data);
	var cumulativeDataSet = getCumulative(monthlyDataSet);

	var canvas = document.getElementById('usersLineChart').getContext('2d');
	var lineChart = new Chart(canvas, {
	    type: 'line',
	    data: {
	        labels: MONTHS,
			datasets: [
				createDataset('Monthly', monthlyDataSet, 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 0.2)'),
				createDataset('Cumulative', cumulativeDataSet, 'rgba(255, 159, 64, 1)', 'rgba(255, 159, 64, 0.2)')
			]
	    },
		options: {
			responsive: true,
			plugins: {
				legend: {
					position: 'top',
				},
				title: {
					display: true,
					text: 'Coupon Cost x Month - Chart'
				}
			}
		}
	});	
}

function createDataset(label, data, borderColor, backgroundColor) {
	var dataset = {
		label: label,
		data: data,
		borderColor: borderColor,
		backgroundColor: backgroundColor,
	};
	return dataset;
}

function getTotalByMonth(data) {
	var totalByMonth = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	$.each(data, function(i, item) {
		totalByMonth[item.birthday-1] += 1;
	});
	return totalByMonth
}

function getCumulative(monthly) {
	var cumulative = [];
    monthly.reduce((prev, curr, i) =>  cumulative[i] = (prev + curr*5), 0);

	return cumulative
}

function populateTable(data) {
	var newRows = "";
	$.each(data, function(i, item) {
		newRows += "<tr>"+
			"<td>" + item.id + "</td>"+
			"<td>" + ("0" + item.birthday).slice(-2) + " - " + getMonth(item.birthday) + "</td>"+
			"<td>" + formatCurrency(item.spend) + "</td>"+
			"<td>" + item.region + "</td></tr>";		
	});
	$("#usersTable tbody:last-child").append(newRows);
}

function configDataTable() {
	$("#usersTable").DataTable();
}

function updatePage(region, minimalSpend) {
	clearData();
	
	$.ajax({
	    type : "GET",
	    url : "getUsers/"+ region +"/"+ minimalSpend,
	    success: function(data) {
			Chart.helpers.each(Chart.instances, function(chart){
				var monthlyDataSet = getTotalByMonth(data);
				var cumulativeDataSet = getCumulative(monthlyDataSet);

				chart.data.datasets.push(createDataset('Monthly', monthlyDataSet, 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 0.2)'));
				chart.data.datasets.push(createDataset('Cumulative', cumulativeDataSet, 'rgba(255, 159, 64, 1)', 'rgba(255, 159, 64, 0.2)'));

				chart.update();
			});
			populateTable(data);
			configDataTable();
	    }
	});
}

function clearData() {
	var table = $("#usersTable").DataTable();
	table.clear();
	table.destroy();
	Chart.helpers.each(Chart.instances, function(chart){
      	chart.data.datasets.pop();
      	chart.data.datasets.pop();
      	chart.update();
	});
}