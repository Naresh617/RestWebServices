as<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo application</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- =========================pdf,excel,copy,csv================ -->
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css"></link>

<!-- =========================pdf,excel,copy,csv ended================ -->

<!-- =========================select ================ -->
<script src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.min.css"></link>
<!-- =========================select ended================ -->


<script type="text/javascript">
$(document).ready(function(){
	 $("#button").click(function(){
		 $('#ttable').empty();
		 $.ajax({
			  type: "GET",
			  url: "GetDataServlet",
			  success: function(data){
				  var obj = jQuery.parseJSON(data);
				  $("#ttable").append('<table class="table" id="getData"><thead><tr><th>Name</th><th>Age</th><th></th></tr></thead><tbody id="resultarea"></tbody></table>');
				 /*  $("#resultarea").append('<table class="table"><thead><tr><th>Name</th><th>Age</th></tr></thead><tbody>'); */
				  $.each(obj, function(key,value) {
					  $('#resultarea').append('<tr><td>'+value.name+'</td><td>'+value.age+'</td><td></td></tr>');
					}); 
				 
				  $('#getData').DataTable({
				        dom: 'Bfrtip',
				        buttons: [
				            'copy', 'csv', 'excel', 'pdf', 'print'
				        ],
				        columnDefs: [ {
				            orderable: false,
				            className: 'select-checkbox',
				            targets:   2
				        } ],
				        select: {
				            style:    'os',
				            selector: 'td:last-child'
				        },
				        order: [[ 1, 'asc' ]]
				       
				    });
			  }
		 
			});
	 });
	
});
</script>
</head>
<body>
<button id="button">ClickMe</button>
<br><br>
<%-- Today's date: <%= (new java.util.Date()).toLocaleString()%> --%>
<div id="ttable">
</div>
</body>
</html>