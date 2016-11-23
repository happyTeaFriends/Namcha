$(document).ready(function(){
	//Load the SDK asynchronously
	var js, id = 'facebook-jssdk', ref = document.getElementsByTagName('script')[0];
	if ($('#'+id).length > 0) {
		console.log(7);
		return;
	}
	js = document.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	ref.parentNode.insertBefore(js, ref);
	
	$("#facebookModal").click(function(){
		$('#postText').val(constructMessage());
	});
});
var token = "";
var userId = "";
window.fbAsyncInit = function() {
	FB.init({
		appId : '1821551991424709', // '259763817525266',
		status : true, // check login status
		cookie : true, // enable cookies to allow the server to access the
						// session
		xfbml : true
	// parse XFBML
	});
	FB.Event.subscribe('auth.authResponseChange', function(response) {
		console.log(response);
		// logout-unauthen
		if (response.authResponse == null | response.status == "unknow") {
			return;
		}
		token = response.authResponse.accessToken;
		userId = response.authResponse.userID;
		console.log("token:::" + token);
		console.log("userID::" + userId);
		if (response.status === 'connected') {
			enableAPI();
			showHideFBBtn(true);
		} else if (response.status === 'not_authorized') {
			FB.login(function() {
				scope: 'publish_actions'
			});
			showHideFBBtn(false);
		} else {
			FB.login(function() {
				scope: 'publish_actions'
			});
			showHideFBBtn(false);
		}
	});
};

function enableAPI() {
	console.log('Welcome!  Fetching your information.... ');
	getLoginProfile();
	$("#postBtn").click(function(){
		postToPage();
		$('#myModal').modal('hide');
	});
}
var loginProfile = {};
function getLoginProfile() {
	FB.api('/me', function(response) {
		console.log(response);
		loginProfile = response;
	});
}
function postToPage() {
	var page_id = '1216885925023943';
	FB.api('/' + page_id, {
		fields : 'access_token'
	}, function(resp) {
		if (resp.access_token) {
			FB.api('/' + page_id + '/feed', 'post', {
				message : $('#postText').val(),//constructMessage()
				link : 'http://www.youtube.com',
				access_token : resp.access_token
			}, function(response) {
				console.log(response);
			});
		}
	});
}
function showHideFBBtn(isConnect){
	if(isConnect) {
		$("#fbLoginBtn").hide();
		$("#postBtn").show();
	} else {
		$("#fbLoginBtn").show();
		$("#postBtn").hide();
	}
}
function constructMessage(){
	var message = 'Course: ';
	message += $('#eventname').val();
	message += ' period: ';
	message += $('#start-date-field').val() + ' to ' + $('#end-date-field').val();
	message += ' at: ';
	message += $('#location').val();
	return message;
}



