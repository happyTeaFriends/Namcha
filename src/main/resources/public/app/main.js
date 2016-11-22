define(['jquery'], function ($) {
    $.get('api/hello', function(data) {
    	$('#response').html(data);
    })
});