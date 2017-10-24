<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="css/jspstyle.css">
<html>
<head>

    <meta charset="UTF-8">

    <title>Transparent login form</title>


        <%
	long id = (long) 0;
	String email = (String) "";
	long  rights  = 0;
	if (request.getSession(false) != null) {
		id = (long) request.getSession(false).getAttribute("user_id");
		email = (String) request.getSession(false).getAttribute("email");
        rights = (long)request.getSession(false).getAttribute("rights") ;
	} else {
		response.sendRedirect("./index.html");
	}
%>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript">

                $(document).ready(function(){
                    $("#userslist").click(function(){
//                        alert("Clicked");
                        $.ajax({
                          url: 'PrintAllUserWithAjax.jsp',
                            success:function(data){
                              alert("success");
                                document.getElementById("tableprint").innerHTML = data;
                            }
                        })
                    });
                });

//      function PrintUsers()
//        {


        /*$.get("http://localhost:8080/PrintAllUserWithAjax.jsp" ,
            function (data) {
                $("#tableprint").append(data);
            });*/
//        }
    </script>
    <div id="header">
        <ul id="menu">
            <li><a href="/"><span>Home</span></a></li>
            <li><a href="/"><span>Tutorials</span></a></li>
            <li><a href="/"><span>Articles</span></a></li>
            <% if ( rights == 1 ) {
            %>
            <li><a id="userslist" onclick="function()"><span>List Users</span></a></li>
            <%
                }%>
            <li><a href="logout"><span>Logout</span></a></li>
        </ul>
        <%= id %>
        <%= email %>
        <%=   rights%>
    </div>
<body>

<div class="wrapper">

    <form action="wallet" method="post">
        <input type="text" name="wallet_name">
        <select name="categories" id="">
            <option value="1">option 1</option>
            <option value="2">option 1</option>
            <option value="3">option 1</option>
        </select>
        <input type="checkbox" name="check" value="Car" checked>
        <input type="submit" value="insert">
    </form>

</div>

<div    id = "tableprint">


</div>
<%--<header>
<ul>
    <li><%=id%>
    </li>
    <li><%=username%>
    </li>

    <li><a href="logout">Logout</a></li>
</ul>
</header>--%>


</body>
</html>
