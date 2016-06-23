var coffeeSales = new Array();
coffeeSales[0] = "Jan, 170";
coffeeSales[1] = "Feb, 320";

function createAxis(context, startx, starty, endx, endy) {
	context.beginPath();
	context.moveTo(startx,starty);
	context.lineTo(endx,endy);
	context.closePath();
	comtext.stroke();
}

function createBar(context, x, y, width, height) {
	context.beginPath();
	context.rect(x,y,width,height);
	context.closePath();
	context.stroke();
	context.fill();	
}

function drawChart() {
	var canvas = document.getElementById('barChart');
	if(canvas && canvas.getContext) {
		var context = canvas.getContext('2d');
		createBarChart(context,coffeeSales,30,20,(canvas.height-20),50);
	}
}