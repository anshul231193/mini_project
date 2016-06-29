/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateform() {
    var name = document.Register_Form.name.value;
    var regex = /^[a-zA-Z ]{2,30}$/;
    if (!regex.test(name)) {
        var invalid = document.getElementById("invalidName");
        invalid.style.display = "block";
        return false;
    }
    
    return true;
}
