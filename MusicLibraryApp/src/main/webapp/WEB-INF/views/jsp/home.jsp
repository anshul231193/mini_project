<%-- 
    Document   : home
    Created on : 21 Jul, 2016, 1:46:37 PM
    Author     : anshul
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
    <jsp:include page="header.jsp" />
    <!-- You need this element to prevent the content of the page from jumping up -->
    <div class="header-fixed-placeholder"></div><br>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">Search Music</a></li>
            <li><a data-toggle="pill" href="#menu1">My Music</a></li>
            <li><a data-toggle="pill" href="#menu2">All Music</a></li>
            <li><a data-toggle="pill" href="#menu3">Add Music</a></li>
        </ul>
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
              <h3>HOME</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
            <div id="menu1" class="tab-pane fade">
              <h3>Menu 1</h3>
              <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            </div>
            <div id="menu2" class="tab-pane fade">
              <h3>Menu 2</h3>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
            <div id="menu3" class="tab-pane fade">
              <h3>Add Music</h3>
              <div class = "container">
        
        
        <div class="wrapper">
            <c:if test="${not empty message}">
            <div style= "width:420px;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
            role="alert">
                <strong>${message}!</strong>
            </div>
            </c:if>
            <form:form modelAttribute="addMusic" action="home?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" name="AddMusic_Form" style="float:left;width:100%;" class="form-signin">       
		    <h3 class="form-signin-heading"> Add a tune !!</h3>
			  <hr class="colorgraph"><br>
			  
			  <div class="form-group">
			      <label for="genre">Music Genre:</label>
                              <form:input path="musicGenre" type="text" class="form-control" id="genre" name="genre" required="true" />
			    </div>
                             <div class="form-group">
			      <label for="title">Title:</label>
			      <form:input path="title" type="text" class="form-control" id="title" name="title" required="true" />
			    </div>
			    <div class="form-group">
			      <label for="desc">Description:</label>
			      <form:textarea path="description" class="form-control" rows="5" id="desc" name="desc" required="true"></form:textarea>
                            </div>
			    <div class="form-group">
			      <label for="lyrics">Lyrics:</label>
			      <form:textarea path="lyrics" class="form-control" rows="10" id="lyrics" name="lyrics" required="true"></form:textarea>
                            </div>
                            <div class="form-group">
                                <label for="artistName">Artist Name:</label>
                                <form:input path="artistName" type="text" class="form-control" id="artistName" name="artistName" required="true" /> 
                            </div>
                            <div class="form-group">
			      <label for="albumName">Album Name:</label>
			      <form:input path="albumName" type="text" class="form-control" id="albumName" name="albumName" required="true" />
			    </div>
                            <div class="form-group">
			      <label for="fileName">Upload File:</label>
			      <form:input path="file" type="file" class="form-control" id="file" name="file" required="true" />
                              <div class="has-error">
                                <form:errors path="file" class="help-inline"/>
                              </div>
                            </div>
                          
<!--                            <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />-->
			  <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Submit" type="Submit">Submit</button> 
                </form:form>
	</div>
</div>
            </div>
        </div>
    </div>
    </body>
</html>
