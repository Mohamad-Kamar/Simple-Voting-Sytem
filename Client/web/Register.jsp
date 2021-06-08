

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>myaw</h1>
    <%-- start web service invocation --%><hr/>
    <%-- start web service invocation --%><hr/>
    <form method="POST">
            <br><input name="action" title="Invoke addID operation" type="SUBMIT" value="addID">
            (<input name="PARAMaddID0" title="addID parameter of type int" type="TEXT">)
            <br><hr>
        </form>
    <%
    try {
        out.println("Hey client, Enter your id:");
	newpackage.AuthServer_Service service = new newpackage.AuthServer_Service();
	newpackage.AuthServer port = service.getAuthServerPort();
	int id =0;
	// TODO process result here
	java.lang.String result = port.addID(id);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
        
        
    <%-- end web service invocation --%><hr/>


    </body>
</html>
