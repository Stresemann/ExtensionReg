<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

	<head>
		<title>First Web Application</title>
	</head>

	<body>
		    <%-- <font color="red">${errorMessage}</font>
		        <form method="post">
				        Name : <input type="text" name="name" />
					        Password : <input type="password" name="password" /> 
						        <input type="submit" />
							    </form> --%>
			<form:form method="POST"
          action="/register" modelAttribute="extension">
             <table>
                <tr>
                    <td><form:label path="key">Key</form:label></td>
                    <td><form:input path="key"/></td>
                </tr>
                <tr>
                    <td><form:label path="version">Version</form:label></td>
                    <td><form:input path="version"/></td>
                </tr>
                <tr>
                    <td>UserName : <input type="text" name="username" /></td>
					<td>Password : <input type="password" name="password" /> </td>
                    <td>URL : <input type="text" name="url" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
	</body>

</html>
