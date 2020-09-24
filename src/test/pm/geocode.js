var jsonData = pm.response.json();

var lat = jsonData.results[0].geometry.location.lat
var lng = jsonData.results[0].geometry.location.lng

pm.environment.set("SEP-LAT", lat);
pm.environment.set("SEP-LNG", lng);