function registerSubmitEvent(){
    $('#contentForm').submit(function(event){
        event.preventDefault();

        submitForm();
    });
}

function createContent(){
    $.ajax({
      type: "POST",
      url: "content",
      data: $('#contentForm').serialize(),
      success: createSuccess,
      error: createError,
      dataType: 'json'
    });
}

function createSuccess(){
    window.location.href = "/";
}

function createError(){
    alert("error");
}

function submitForm(){
    var data = $('#contentForm').serializeFormJSON();
    console.log("Data="+data);
    createContent();
}