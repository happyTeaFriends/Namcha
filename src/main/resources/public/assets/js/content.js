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
    messages.push(validateRequiredField('Category', data.category));
    messages.push(validateRequiredField('Event Name', data.eventName));
    messages.push(validateRequiredField('Start Date', data.startDate));
    messages.push(validateRequiredField('End Date', data.endDate));
    messages.push(validateRequiredField('Location', data.location));
    messages.push(validateRequiredField('Description', data.description));
    messages.push(validateDateRange(data.startDate, data.endDate));

    return _.filter(messages, function(msg){ return msg.isValid===false });

}

function validateRequiredField(fieldName, fieldValue) {

    if(!fieldValue){
       return createMessage('กรุณากรอก ' + fieldName);
    }
    return createMessage();
}

function validateDateRange(startDate, endDate) {
    var momentStartDate = moment(startDate);
    var momentEndDate = moment(endDate);

    if (momentStartDate.isAfter(momentEndDate)) {
        return createMessage('Start Date ต้องไม่เกิน End Date');
    }
    return createMessage();
}

function createMessage(msg) {
    return { errorMsg: msg, isValid: !msg };
}

function buildMessage(messages){
    return _.pluck(messages, 'errorMsg').join('</br>');
}