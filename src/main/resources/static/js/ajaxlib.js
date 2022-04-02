function doajax(url,data){
	var xhr = new XMLHttpRequest();
	xhr.open('POST',url,true);
	xhr.setRequestHeader("content-type","application/json");
	xhr.send(data);
	return xhr;
}
