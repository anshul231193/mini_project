/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//($document).ready(function(){
//        // click on button submit
//        $("#submit").on('click', function(){
//            // send ajax
//            $.ajax({
//                type: "POST",
//                url: "search",
//                data: {
//                   searchKeyword: $("#search").val()
//                },
//                dataType: "JSON",
//                success : function(result) {
//                    // you can see the result from the console
//                    // tab of the developer tools
//                    alert(result);
//                    console.log(result);
//                },
//                error: function(data, xhr, resp, text) {
//                    alert(data);
//                    console.log(xhr, resp, text);
//                }
//            })
//        });
//    });

//var searchRequest = null;
//
//    $(function () {
//        var minlength = 3;
//
//        $("#submit").on('click',function () {
//            value = $('#search').val();
//                    
//            if (value.length >= minlength) {
//                if (searchRequest !== null)
//                    searchRequest.abort();
//                searchRequest = $.ajax({
//                    type: "POST",
//                    url: "search",
//                    data: {
//                        searchKeyword: $("#search").val()
//                    },
//                    dataType: "JSON",
//                    success: function (msg) {
//
//
//                    //we need to check if the value is the same
//                    alert(msg);
//
//                        var resDiv = document.getElementById("resultTable");
//
////                    while(resTable.hasChildNodes()){
////                        resTable.removeChild(resTable.firstChild);
////                    }
//                        var $table
//
//                        for (var i = 0; i < msg.length; i++) {
//                            if (i == 0) {
//                                $table = '<table>\n\
//                                        <tr><td>S.No</td>\n\
//                                        <td>Song Name</td>\n\
//                                        <td>Artist Name</td>\n\
//                                        <td>Album Name</td></tr>\n';
//
//                            }
//
//
//                            $table += "<tr>";
//
//                            var it = msg[i];
//
//                            $table += "<td>" + (i + 1) + "</td>";
//
//                            $table += "<td>" + it.songName + "</td>";
//
//                            $table += "<td>" + it.artistName + "</td>";
//
//                            $table += "<td>" + it.albumName + "</td>";
//                            
//                            $table += "<td><input type=\"button\" onclick =\"buttonClick()\" value=\"Add to Playlist\"/></td>";
//
//                            $table += "</tr>";
//
//                            if (i == msg.length - 1) {
//                                $table += "</table>";
//
//                            }
//
//
//                        }
//
//
//
//
//                        resDiv.innerHTML = $table;
//
//
//
//                    },
//                    failure: function (msg) {
//                        alert("ajax failure function");
//
//                    }
//                });
//            }
//        });
//    });
//    


function madeAjaxCall(){
    alert(1);
 $.ajax({
  type: "post",
  url: "/search",
  cache: false,    
  data:'searchKeyword=' + $("#search").val(),
  datatype: "JSON",
  success: function(response){
   $('#resultTable').html("hi");
   var obj = JSON.parse(response);
//   $('#resultTable').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
  },
  error: function(xhr,status){
      alert(xhr.status);
   alert('Error while request..');
  }
 });
}
