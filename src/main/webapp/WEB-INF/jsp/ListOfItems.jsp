<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<title>List of All Items</title>
</head>
<body>
<h1>List of All Items</h1>
<div>
<a href="${pageContext.request.contextPath}/items/listall">Home page</a>

</div>
<br/><br/>
<div class="container" >

		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="http://www.thymeleaf.org"> Thymeleaf -
					Plain </a>
				<ul class="nav">
					<li><a th:href="@{/}" href="home.html"> Home </a></li>
					<li><a th:href="@{/logout}" href="logout"> Logout </a></li>
				</ul>
			</div>
		</div>


<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
<br/><br/><br/>

<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0"  class="order-table table">
<thead>
<tr>
<th width="25px">Style</th><th width="150px">Color</th><th width="25px">Number in stock</th><th width="250px">Description</th><th width="80px">Add to Order</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${itemsList}">
<tr>
<td>${item.style}</td>
<td>${item.color}</td>
<td>${item.qty}</td>
<td id=${item.id}.html> <a  href="${pageContext.request.contextPath}/items/selected/${item.id}.html">${item.description} </a><br/>
</td>
<td> <button onclick="row_selected(this.parentElement)">Add to Order</button>
</td>

</tr>
</c:forEach>

</div>
</tbody>
</table>

<h1>Ordered Items</h1>
</br>
<form id="client-details"   action="${pageContext.request.contextPath}/client/order"  method="post">
Client name: 	<input type="text" name="clientname"><br></br></br>
Email address: 	<input type="text" name="emailaddr">
Pay method: 	<input type="text" name="paymethod">
<input type="submit" onclick="sumit_order()" value="Submit Order">
</form>
</br>

<button onclick="get_client_order_url()">List Client Orders </button>

</br>



<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0"  class="item-order-table table" id="selected_items_table">
<thead>
<tr>
<th width="25px">Style</th><th width="150px">Color</th><th width="25px">Order Number</th><th width="250px">Description</th><th width="80px">Remove item</th>
</tr>
</thead>

<tbody>
</tbody>
</table>

<br/><br/>


<script src="http://code.jquery.com/jquery-2.1.0.js"></script>
<script type="text/javascript">
     (function(document) {
	'use strict';

	var LightTableFilter = (function(Arr) {

		var _input;

		function _onInputEvent(e) {
			_input = e.target;
			var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
			Arr.forEach.call(tables, function(table) {
				Arr.forEach.call(table.tBodies, function(tbody) {
					Arr.forEach.call(tbody.rows, _filter);
				});
			});
		}

		function _filter(row) {
			var text, val;
			//text = row.textContent.toLowerCase(), 
			text = row.cells[0].textContent.toLowerCase();
			val = _input.value.toLowerCase();
			row.style.display = text.indexOf(val) ==0 ?  'table-row' : 'none';
		}

		return {
			init: function() {
				var inputs = document.getElementsByClassName('light-table-filter');
				Arr.forEach.call(inputs, function(input) {
					input.oninput = _onInputEvent;
				});
			}
		};
	})(Array.prototype);

	document.addEventListener('readystatechange', function() {
		if (document.readyState === 'complete') {
			LightTableFilter.init();
		}
	});

})(document);
     
	function row_selected(element) {
		var r, cells, cell, bt, num, xbt;

		num = prompt("Please enter order number", "2");

		if (isNaN(parseInt(num)) == true || num ==null) {
			return;
		}
		
		r = element.parentElement;
		cells = r.cells;
		cells[2]['tnum']=cells[2].innerHTML; 
		cells[2].innerHTML = num;
		
		
		cell = cells[cells.length - 1];
		
		var bt = document.createElement('button');
		bt.name = 'removeBt';
		
		bt.innerHTML="Remove Item";
		bt.onclick = function(){ row_remove(element); } ;
		xbt =cell.getElementsByTagName('button');
		cell.replaceChild(bt, xbt[0]);
		
		var table = document.getElementById("selected_items_table");
		
		table.appendChild(r);

	}
	
	
	function row_remove(element) {
		var r, cells, cell, bt, num, xbt;

		r = element.parentElement;
		
		cells = r.cells;
		cells[2].innerHTML = cells[2].tnum;
		cell = cells[cells.length - 1];

		bt = document.createElement('button');
		bt.name = 'addBt';
		
		bt.innerHTML="Add to Order";
		bt.onclick = function(){ row_selected(element); } ;
		xbt =cell.getElementsByTagName('button');
		cell.replaceChild(bt, xbt[0]);
		
		var table = document.getElementsByClassName("order-table table")[0];
		
		table.appendChild(r);
		
	}
	
	function get_client_details(){
		var form = document.getElementById("client-details");
		nobj = {
				'name':	form.elements[0].value,
				'emailaddr':	form.elements[1].value,
				'paymethod':	form.elements[2].value
		};
		var s = get_client_order_url();
		form.setAttribute("action", s);
		
		return nobj;		
	}
	
	function sumit_order(){
		var row;
		var rows = document.getElementById("selected_items_table").rows;
		var orderurl = rows[0].baseURI+'/order';
		orderurl = document.body.baseURI+'/order';
		var orders = [];
		var nobj=null;
		var rn = rows.length;
		
		nobj = get_client_details();
		orders.push(nobj);
		
		for(var k=1; k<rn;k++){
			row = rows[k];
			row.cells[3].id.replace(".html", "")
			nobj = {
					'itemid':		parseInt(row.cells[3].id.replace(".html", "")),
					'item_number':	parseInt(row.cells[2].innerHTML)
			};
			orders.push(nobj);
		}

		if(orders.length<1){
			return;
		}
		
		var form = document.getElementById("client-details");
    	addHidden(form, "client_order", JSON.stringify(orders));
    	form.submit();
		
		/*
		$.ajax({
	        url: orderurl,	       
	        data: JSON.stringify(orders),
	        type: "POST",
	         
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	            xhr.setRequestHeader("dataType", "json");
	        },
	        success: function(data) {
	            //alert("order list successfully sent");       
	        	var form = document.getElementById("client-details");
	        	addHidden(form, "client_order_id", data);
	        	form.submit();
	        }
			});//*/				
	}
	
	function get_client_order_url(){
				
		var s = "${pageContext.request.contextPath}/client/order";
		return s;		
		
	}
	function addHidden(theForm, key, value) {
	    // Create a hidden input element, and append it to the form:
	    var input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = key;'name-as-seen-at-the-server';
	    input.value = value;
	    theForm.appendChild(input);
	}
</script>
</body>
</html>