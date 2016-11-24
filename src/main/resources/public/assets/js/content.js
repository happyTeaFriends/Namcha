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
      data: $('#contentForm').serializeFormJSON(),
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
    if(isValid(data)){
        createContent();
    }
}

function isValid(data){
	var error = {};
	if (isCategoryNotValid(data.category)) {
		error.append("Category is empty. (เลือกด้วยนะครัชชชชช :P)");
	}
    //validate here
    return true;
}

function isCategoryNotValid(category) {
	return isEmpty(category);
}