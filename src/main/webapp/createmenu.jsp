<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="savemenu" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" placeholder="Enter the Name"></td>
			</tr>

			<tr>
				<td>Description :</td>
				<td><input type="text" name="description"
					placeholder="Enter the Description"></td>
			</tr>

			<tr>
				<td>Price :</td>
				<td><input type="number" name="price"
					placeholder="Enter the Price"></td>
			</tr>

			<tr>
				<td>Offer :</td>
				<td><input type="text" name="offer"
					placeholder="Enter the Offer"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

</body>
</html>