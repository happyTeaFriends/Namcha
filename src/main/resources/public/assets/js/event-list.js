var formatTable = function () {
     $("th").css("color", "#ffffff");
     $("th").css("background-color", "#3275ad");
     $("td").css("vertical-align", "middle");
 };

 function dateFormatter(value, row) {
     return moment(value).format('DD/MM/YYYY');
 };

 function onloadListEvents(){
     var url = window.location.search.substring(1);
     var error = getUrlParameter(url, "error");
     if(error === "true"){
         $('#myModal').modal('show');
     }

     $.ajax({
         type : "GET",
         contentType : "application/json",
         url : "content",
         dataType : 'json',
         timeout : 100000,
         success : function(data) {
             console.log("SUCCESS: ", data);
             var $table = $('#table');
             $table.bootstrapTable({
                 data: data,
                 pagination: true
             });

             formatTable();
         },
         error : function(e) {
             console.log("ERROR: ", e);
         },
         done : function(e) {
             console.log("DONE");
         }
     });

 }

