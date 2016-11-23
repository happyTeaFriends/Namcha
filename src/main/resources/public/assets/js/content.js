function createContent(){
    $.ajax({
      type: "POST",
      url: "content",
      data: $('#contentForm').serialize(),
      success: function(data){
        console.log(data);
      },
      dataType: 'json'
    });
}