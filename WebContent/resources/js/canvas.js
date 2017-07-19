function drawAgent(e) {
	console.log(e);
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	ctx.beginPath();
	ctx.moveTo(e.positionX, e.positionY);
	ctx.lineTo(e.positionX + e.pas * e.vitesseX, e.positionY + e.pas * e.vitesseY);
	ctx.lineCap = "round";
	ctx.stroke();
}

function drawEnvironment(positionX, positionY) {
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	ctx.beginPath();
	ctx.moveTo(positionX, positionY);
	ctx.lineTo(positionX + 5, positionY + 5);
	ctx.stroke();
}

function onMessage(message, channel, event) {
	if (message == "CLEAR")
		clearCanvas();
	else
		drawAgent(message);
}

function clearCanvas() {
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	var w = canvas.width;
	canvas.width = 1;
	canvas.width = w;
}