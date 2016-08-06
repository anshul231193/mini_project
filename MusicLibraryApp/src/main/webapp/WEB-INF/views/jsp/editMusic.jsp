<%-- 
    Document   : editMusic
    Created on : 5 Aug, 2016, 3:38:43 PM
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
        <jsp:include page="headerAdmin.jsp" />
        <div class = "container">
        

                <div class="wrapper">
                    <c:if test="${not empty message}">
                    <div style= "width:420px;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
                    role="alert">
                        <strong>${message}!</strong>
                    </div>
                    </c:if>
                    <c:if test="${not empty msgAddPlaylist}">
                    <div style= "width:420px;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
                    role="alert">
                        <strong>${msgAddPlaylist}!</strong>
                    </div>
                    </c:if>
                    <form action="" method="post" name="AddMusic_Form" style="float:left;width:100%;" class="form-signin">       
                            <h3 class="form-signin-heading"> Edit a tune !!</h3>
                                  <hr class="colorgraph"><br>

                                  <div class="form-group">
                                      <label for="genre">Music Genre:</label>
                                      <input type="text" class="form-control" id="genre" name="genre" value="${music.musicGenre}" required="true" />
                                    </div>
                                     <div class="form-group">
                                      <label for="title">Title:</label>
                                      <input type="text" class="form-control" id="title" name="title" value="${music.title}" required="true" />
                                    </div>
                                    <div class="form-group">
                                      <label for="desc">Description:</label>
                                      <textarea class="form-control" rows="5" id="desc" name="desc" required="true">${music.description}</textarea>
                                    </div>
                                    <div class="form-group">
                                      <label for="lyrics">Lyrics:</label>
                                      <textarea class="form-control" rows="10" id="lyrics" name="lyrics" required="true">${music.lyrics}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="artistName">Artist Name:</label> 
                                        <input type="text" class="form-control" id="artistName" name="artistName" value="${music.artistName}" required="true" /> 
                                    </div>
                                    <div class="form-group">
                                      <label for="albumName">Album Name:</label>
                                      <input type="text" class="form-control" id="albumName" name="albumName" value="${music.albumName}" required="true" />
                                    </div>
                                    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
                                  <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Submit" type="Submit">Submit</button> 
                        </form>
                </div>
            </div>
    </body>
</html>
