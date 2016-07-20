/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
    var username,pswd,name;
    
    username = document.getElementById("usrname").value;
    name = document.getElementById("name").value;
    pswd = document.getElementById("pwd").value;
    if(!/^[A-Za-z ]+$/.test(name)) {
        document.getElementById("nameError").innerHTML = "* name not valid";
        return false;
    }
    if(!/^[0-9a-zA-Z_.-]+$/.test(username)) {
        document.getElementById("usrError").innerHTML = "* username not valid";
        return false;
    }
    
    return true;
}
