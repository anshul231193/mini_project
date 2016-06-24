'use strict';

var cat = {name: "pussy", color: "white"}
cat.age = 3
cat.speak = function() { display("Meooow") }
cat.getName = function() { return this.name}
display(cat.name)
display(cat.age)
cat.speak();
display(cat.getName());
display(cat["name"]);
function abc() {
	this.name = "Pussy"
	this.color = "white"
}
var abc = new abc();
display(abc);

var anshul = Object.create(Object.prototype,
{
	name: {
		value:'fluffy',
		enumerable:true,
		writable:true,
		configurable:true
	},
	color: {
		value:"White",
		enumerable:true,
		writable:true,
		configurable:true
	}
})

display(anshul);

/*var arr = ['red', 'blue', 'green']
Object.defineProperty(Array.prototype,'last',{get: function() {
	return this[this.length-1]
}})
var last arr[arr.length-1]
display(last)
display(Array)*/

function Cat(name, color) {
	this.name = name;
	this.color = color;
}
Cat.prototype.age = 3
display(Cat.prototype)