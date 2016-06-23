'use strict';

var cat = {name: "pussy", color: "white"}
cat.age = 3
cat.speak = function() { display("Meooow") }

display(cat.name)
display(cat.age)
cat.speak();

function abc() {
	this.name = "Pussy"
	this.color = "white"
}
var abc = new abc();
display(abc);
