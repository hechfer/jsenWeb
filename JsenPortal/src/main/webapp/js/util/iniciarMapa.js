function initMap(){
	var uluru={lat: 19.432608, lng: -99.133208};
	var map = new google.maps.Map(document.getElementById('map'),{zoom:20, center:uluru});
	var marker = new google.maps.Marker({position: uluru, map:map});
};