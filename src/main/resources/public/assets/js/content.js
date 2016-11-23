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
    alert('ERROR OCCURRED');
}