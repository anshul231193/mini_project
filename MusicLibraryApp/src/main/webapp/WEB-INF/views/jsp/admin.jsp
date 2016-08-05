<%-- 
    Document   : admin
    Created on : 5 Aug, 2016, 11:23:15 AM
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
        <link rel="stylesheet" href="css/remodal.css">
        <link rel="stylesheet" href="css/remodal-default-theme.css">
        <style>
          .remodal-bg.with-red-theme.remodal-is-opening,
          .remodal-bg.with-red-theme.remodal-is-opened {
            filter: none;
          }

          .remodal-overlay.with-red-theme {
            background-color: #f44336;
          }

          .remodal.with-red-theme {
            background: #fff;
          }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h3>All Music</h3>
              <c:if test="${not empty msgAddPlaylist}">
                    <div style= "width:420px;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
                    role="alert">
                        <strong>${msgAddPlaylist}!</strong>
                    </div>
              </c:if>
              <audio id="allaudio" style="background:#666;width:400px;padding:20px;" preload="auto" tabindex="0" controls="" type="audio/mpeg">
                 <source type="audio/mp3" src="${allMusicList[0].filePath}">
                 Sorry, your browser does not support HTML5 audio.
              </audio>
              <ul id="allplaylist" style="background:#666;width:400px;padding:20px;">
                <c:forEach items="${allMusicList}" var="music">
                    <li><a href="<c:out value="${music.filePath}"/>"><c:out value="${music.title}"/> by <strong>${music.artistName}</strong></a></li>
                    <a href="admin/updateMusic?musicId=${music.musicId}"><span class="glyphicon glyphicon-plus"></span></a>
                </c:forEach>
              </ul>
                <script src="js/allPlaylist.js" type="text/javascript"></script>
         </div>
    </body>
</html>
