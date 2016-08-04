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


//callback handler for form submit
$("#searchForm").submit(function(e)
{
    var postData = $(this).serializeArray();
    var formURL = $(this).attr("action");
    $.ajax(
    {
        url : "search",
        type: "GET",
        data: {
            searchKeyword: $(".search").val()
        },
        dataType: "JSON",
        success:function(msg, textStatus, jqXHR) 
        {
            //data: return data from server
            var resDiv = document.getElementById("resultTable");

                        var $table;
                        
                        
            
                        for (var i = 0; i < msg.length; i++) {
                            var it = msg[i];
                            if (i == 0) {
                                $table = '<audio id="searchaudio" style="background:#666;width:400px;padding:20px;" preload="auto" tabindex="0" controls="" type="audio/mpeg">\n\
                                <source type="audio/mp3" src="'+it.filePath+'">\n\
                                Sorry, your browser does not support HTML5 audio.\n\
                             </audio>\n\
                             <ul id="searchplaylist" style="background:#666;width:400px;padding:20px;">';

                            }
                            $table += '<li><a href="'+it.filePath+'">'+it.title+' by <strong>'+it.artistName+'</strong></a></li>\n\
                                    <a href="addToPlaylist?musicId='+it.musicId+'"><span class="glyphicon glyphicon-plus"></span></a>';

                        }
                        resDiv.innerHTML = $table+"</ul>";
                        /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var searchaudio;
var searchplaylist;
var searchtracks;
var searchcurrent;

searchinit();
$("#add,#my,#all").click(function () {
    searchaudio = $('#searchaudio');
    searchplaylist = $('#searchplaylist');
    tracks = playlist.find('li a');
    searchaudio[0].pause();
});
function searchinit(){
    current = 0;
    searchaudio = $('#searchaudio');
    searchplaylist = $('#searchplaylist');
    searchtracks = searchplaylist.find('li a');
    len = searchtracks.length - 1;
    searchaudio[0].volume = .50;
    searchaudio[0].pause();
    searchplaylist.find('li a').click(function(e){
        e.preventDefault();
        link = $(this);
        current = link.parent().index();
        searchrun(link, searchaudio[0]);
    });
    searchaudio[0].addEventListener('ended',function(e){
        current++;
        if(current == len){
            current = 0;
            link = searchplaylist.find('li a')[0];
        }else{
            link = searchplaylist.find('li a')[current];    
        }
        searchrun($(link),searchaudio[0]);
    });
}
function searchrun(link, player){
        player.src = link.attr('href');
        par = link.parent();
        par.addClass('active').siblings().removeClass('active');
        searchaudio[0].load();
        searchaudio[0].play();
}
        },
        error: function(jqXHR, textStatus, errorThrown) 
        {
            alert(textStatus);
            //if fails      
        }
    });
    e.preventDefault(); //STOP default action
    e.unbind(); //unbind. to stop multiple form submit.
});


function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {
    return split(term).pop();
}

$(document).ready(function() {

	$( "#search").autocomplete({
            source: function (request, response) {
                $.getJSON("getTags", {
	            tagName: extractLast(request.term)
	        }, function( data, status, xhr ) {
                response( data );
        });
	    },
            
	    search: function () {
                
	        // custom minLength
	        var term = extractLast(this.value);
	        if (term.length < 1) {
	            return false;
	        }
	    },
	    focus: function () {
	        // prevent value inserted on focus
	        return false;
	    },
	    select: function (event, ui) {

	        var terms = split(this.value);
	        // remove the current input
	        terms.pop();
	        // add the selected item
	        terms.push(ui.item.value);
	        // add placeholder to get the comma-and-space at the end
	        terms.push("");
	        this.value = terms.join(", ");
	        return false;
	    }
	});
	
});
