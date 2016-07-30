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
            <li class="active"><a data-toggle="tab" href="#home">Add Music</a></li>
            <li><a data-toggle="pill" href="#menu1">My Music</a></li>
            <li><a data-toggle="pill" href="#menu2">All Music</a></li>
            <li><a data-toggle="pill" href="#menu3">Search Music</a></li>
        </ul>
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
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
            <div id="menu1" class="tab-pane fade">
              <h3>My Music</h3>
             <audio id="audio" preload="auto" tabindex="0" controls="" type="audio/mpeg">
                 <source type="audio/mp3" src="http://www.archive.org/download/bolero_69/Bolero.mp3">
                 Sorry, your browser does not support HTML5 audio.
             </audio>
            <ul id="playlist">
                <c:forEach items="${myMusicList}" var="music">
                <li><a href="<c:out value="${music.filePath}"/>"><c:out value="${music.title}"/></a></li>
<!--                <li><a href="http://www.archive.org/download/MoonlightSonata_755/Beethoven-MoonlightSonata.mp3">Moonlight Sonata - Beethoven</a></li>
                <li><a href="http://www.archive.org/download/CanonInD_261/CanoninD.mp3">Canon in D Pachabel</a></li>
                <li><a href="http://www.archive.org/download/PatrikbkarlChamberSymph/PatrikbkarlChamberSymph_vbr_mp3.zip">patrikbkarl chamber symph</a></li>-->
                </c:forEach>
            </ul>
            </div>
            <div id="menu2" class="tab-pane fade">
              <h3>All Music</h3>
              <ul id="playlist">
                <c:forEach items="${allMusicList}" var="music">
                <li><a href="<c:out value="${music.filePath}"/>"><c:out value="${music.title}"/></a></li>
<!--                <li><a href="http://www.archive.org/download/MoonlightSonata_755/Beethoven-MoonlightSonata.mp3">Moonlight Sonata - Beethoven</a></li>
                <li><a href="http://www.archive.org/download/CanonInD_261/CanoninD.mp3">Canon in D Pachabel</a></li>
                <li><a href="http://www.archive.org/download/PatrikbkarlChamberSymph/PatrikbkarlChamberSymph_vbr_mp3.zip">patrikbkarl chamber symph</a></li>-->
                </c:forEach>
            </ul>
            </div>
            <div id="menu3" class="tab-pane fade">
              <h3>Search a Tune!!</h3>
              <form id="searchForm" class="form-wrapper" method="POST" action="">
                <input type="text" name="search" id="search" class="search" placeholder="Search for..." required>
                <input type="hidden" id="csrfToken" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" value="go" onclick="madeAjaxCall();" id="submit">
              </form>
                <div  id = 'resultTable'></div><br>
              <c:forEach items="${searchMusic}" var="music">
                <li><a href="<c:out value="${music.filePath}"/>"><c:out value="${music.title}"/></a></li>
<!--                <li><a href="http://www.archive.org/download/MoonlightSonata_755/Beethoven-MoonlightSonata.mp3">Moonlight Sonata - Beethoven</a></li>
                <li><a href="http://www.archive.org/download/CanonInD_261/CanoninD.mp3">Canon in D Pachabel</a></li>
                <li><a href="http://www.archive.org/download/PatrikbkarlChamberSymph/PatrikbkarlChamberSymph_vbr_mp3.zip">patrikbkarl chamber symph</a></li>-->
                </c:forEach>
            </div>
        </div>
    </div>
        
    </body>
</html>
