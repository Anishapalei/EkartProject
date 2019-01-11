<%@include file="Header.jsp"%>

<br/><br/>

<form action="paymentprocess" method="post">
<table align="center" width="40%" class="table table-bordered">
	<tr bgcolor="cyan"><td colspan="2">Payment Process </td></tr>
<tr>
		<td>Payment Mode </td>
		<td>
  		 <input type="radio" name="pmode" value="CC">Credit Card
		<input type="radio" name="pmode" value="CD">Cash On Delivery
		</td>
	</tr>
	
	
	<tr bgcolor="cyan">
		<td>Credit Card</td>
		<td><input type="text"pattern="^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$" name="ccard"/></td>
	</tr>
	
	<tr>
		<td>Validity <input type="text"pattern="^((0[1-9])|(1[0-2]))\/((2009)|(20[1-2][0-9]))$" name="validity"/></td>
		<td>CVV <input type="text" pattern="[3-9]\d\d" name="cvv"/></td>
	</tr>
	
	<tr bgcolor="cyan">
		<td> Name on Card</td>
		<td> <input type="text" pattern="[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$" name="cname"/></td>
	</tr>
	<tr>
		<td colspan="2"><center><input type="submit" value="Payment Process"/></center></td>
	</tr>
	
</table>
</form>