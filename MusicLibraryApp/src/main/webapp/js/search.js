/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
        // click on button submit
        $("#submit").on('click', function(){
            // send ajax
            $.ajax({
                type: "POST",
                url: "search",
                data: {
                   searchKeyword: $("#search").val()
                },
                dataType: "JSON",
                success : function(result) {
                    // you can see the result from the console
                    // tab of the developer tools
                    alert(result);
                    console.log(result);
                },
                error: function(xhr, resp, text) {
                    alert(1);
                    console.log(xhr, resp, text);
                }
            })
        });
    });

