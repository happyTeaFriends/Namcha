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

    var messages = validate(data);
    if(_.findWhere(messages, {isValid: false})) {
        alert(buildMessage(messages));
        return;
    }

    createContent();
}

function validate(data){
    var messages = [];
    messages.push(validateRequiredField('category', data.category));
    messages.push(validateRequiredField('eventName', data.eventName));
    // Other field validate go here
    return messages;
}

function validateRequiredField(fieldName, fieldValue) {

    if(!fieldValue){
       return createMessage('Please specify ' + fieldName);
    }

    return createMessage();
}

function createMessage(msg) {
    return { errorMsg: msg, isValid: !msg };
}

function buildMessage(messages){
    return _.pluck(messages, 'errorMsg').join('</br>');
}