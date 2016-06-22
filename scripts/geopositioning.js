function createDrivingDirectionsMap() {
	if(navigator.geolocation) {

		navigator.geolocation.getCurrentPosition(OnSuccess, OnError, {
			enableHighAccuracy: true,
			manimumAge: 1000,
			timeout: 500
		});
	}
	else {
		document.getElementById(map).innerHTML = "No support for geolocation";
	}
}

function OnSuccess(position) {

	showMap(
		position.coords.latitude,
		position.coords.longitude
		);
}

function OnError() {

	var mapDiv = document.getElementById("map");

}

function showMap(lat, long) {
	var directionService = new google.maps.DirectionsService();
	var directionsRenderer = new google.maps.DirectionsRenderer();

	var route = {
		origin: new google.maps.LatLng(lat, long),
		destination: "Grote Markt, Brussel",
		travelMode: google.maps.DirectionsTravelMode.DRIVING
	};

	var mapOption = {
		zoom: 10,
		center: new google.maps.LatLng(50.8504500, 4.3487800),
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	var map = new google.maps.Map(document.getElementById("map"), mapOption);
	directionsRenderer.setMap(map);
	directionService.route(route,function(result, status) {
		if(status === google.maps.DirectionsStatus.OK) {
			directionsRenderer.setDirections(result);
		}
	});
}