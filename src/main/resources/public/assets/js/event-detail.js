
function getUrlParameter(url,sParam) {
	    var sPageURL = decodeURIComponent(url),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

function retrieveContent(id){
	$.ajax({
	      type: "GET",
	      url: "content/" + id,
	      success: retrieveSuccess,
	      error: retrieveError,
	      dataType: 'json'
	    });
}

function retrieveSuccess(data){
	//console.log(data);
	$('#category').val(data.category.toLowerCase().replace(/\b[a-z]/g, function(letter) { return letter.toUpperCase();}));
	$('#eventName').val(data.eventName);
	$('#start-date-field').val(moment(data.startDate).format('DD/MM/YYYY'));
	$('#end-date-field').val(moment(data.endDate).format('DD/MM/YYYY'));
	$('#location').val(data.location);
	$('#description').val(data.description);
	var url = '' + window.location.origin + '/event-view-share.html?id=' + data.id;
	if (url.indexOf('localhost') > -1) {
		url = url.replace('http://localhost:8080','https://namcha-dev.herokuapp.com');
	}
	$('#postLink').val(url);
}
function retrieveError(){
    //alert("error");
    window.location("index.html?error=true");
}
	
//Show/Hide Facebook Post Botton 
function showHidePostBtn(share){
	if(share){
		$('#facebookModalBtn').show();
	} else {
		$('#facebookModalBtn').hide();
	}
}
function postMessage () {
	 if (moment($('#start-date-field').val()).isBefore(moment())) {
		 showModal('Cannot Post Past Event');
	     return;
	} else {
		$('#postText').val(facebookPost.constructMessage());
		$("#myModal").modal('show');
	}
}
