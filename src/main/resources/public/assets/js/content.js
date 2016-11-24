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
        showModal(buildMessage(messages));
        return;
    }

    createContent();
}

function validate(data){
    var messages = [];

    messages.push(validateRequiredField('category', data.category));
    messages.push(validateRequiredField('eventName', data.eventName));
    messages.push(validateRequiredField('startDate', data.startDate));
    messages.push(validateRequiredField('endDate', data.endDate));
    messages.push(validateRequiredField('location', data.location));
    messages.push(validateRequiredField('description', data.description));

    return _.filter(messages, function(msg){ return msg.isValid===false });

}

function validateRequiredField(fieldName, fieldValue) {

    if(!fieldValue){
       return createMessage('กรุณากรอก ' + fieldName);
    }

    return createMessage();
}

function createMessage(msg) {
    return { errorMsg: msg, isValid: !msg };
}

function buildMessage(messages){
    return _.pluck(messages, 'errorMsg').join('</br>');
}