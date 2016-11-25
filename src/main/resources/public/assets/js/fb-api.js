 var facebookPost = {
    init: function(){
        facebookPost.loadFBSDK();
        facebookPost.logInFB();
    },

    loadFBSDK: function(){
        var id = 'facebook-jssdk';
        if ($('#'+id).length) {
            return;
        }

        var fbScript = $('<script>', {
            id: id,
            src: '//connect.facebook.net/en_US/all.js'
        });
        $('script:first').parent().append(fbScript);
    },

    logInFB: function(){
        window.fbAsyncInit = function() {
                    	FB.init({
                    		appId : '248154305601002',
                    		status : true, // check login status
                    		cookie : true, // enable cookies to allow the server to access the session
                    		xfbml : true // parse XFBML
                    	});
                    	FB.Event.subscribe('auth.authResponseChange', function(response) {
                    		// logout-unauthen
                    		if (response.authResponse == null | response.status == "unknow") {
                    			return;
                    		}

                    		if (response.status === 'connected') {
                    			facebookPost.postToFBPage();
                    			facebookPost.showHideFBBtn(true);
                    		} else if (response.status === 'not_authorized') {
                    			FB.login(function() {
                    				scope: 'publish_actions'
                    			});
                    			facebookPost.showHideFBBtn(false);
                    		} else {
                    			FB.login(function() {
                    				scope: 'publish_actions'
                    			});
                    			facebookPost.showHideFBBtn(false);
                    		}
                    	});
                };
    },

    postToFBPage: function(){
        $("#postBtn").click(function(){
        		facebookPost.callFBPost();
        		$('#myModal').modal('hide');
        	});
    },

    callFBPost: function(){
        var page_id = '1140298966047448';
        FB.api('/' + page_id, {
        		fields : 'access_token'
        	}, function(resp) {
        		if (resp.access_token) {
        			FB.api('/' + page_id + '/feed', 'post', {
        				message : $('#postText').val(),//constructMessage()
        				link : $('#postLink').val(),
        				access_token : resp.access_token
        			}, function(response) {
        				console.log(response);
        			});
        		}
        });
    },

    showHideFBBtn: function(isConnect){
    	if(isConnect) {
    		$("#fbLoginBtn").hide();
    		$("#postBtn").show();
    	} else {
    		$("#fbLoginBtn").show();
    		$("#postBtn").hide();
    	}
    },

    constructMessage: function(){
    	var message = 'Course: ';
    	message += $('#eventName').val();
    	message += ' period: ';
    	if (moment($('#start-date-field').val()).isSame(moment($('#end-date-field').val()))) {
    		message += $('#start-date-field').val();
    	} else {
    		message += $('#start-date-field').val() + ' to ' + $('#end-date-field').val();
    	}
    	message += ' at: ';
    	message += $('#location').val();
    	return message;
    }
 };

 $(document).ready(facebookPost.init);