describe("content", function() {
	
	describe("when createContent is called", function() {
		beforeEach(function() {
			jasmine.Ajax.install();
		});

		afterEach(function() {
			jasmine.Ajax.uninstall();
		});

		it("should call with url content", function() {
			createContent();
			
			expect(jasmine.Ajax.requests.mostRecent().url).toBe('content');
		});
	});

	describe("when validateRequiredField is called", function() {

        describe("with empty field value", function() {
            it("should return invalid message", function() {
                var message = validateRequiredField('fieldName', '');

                expect(message.isValid).toBe(false);
            });
        });
        describe("with field value", function() {
            it("should return valid message", function() {
                var message = validateRequiredField('fieldName', 'sample value');

                expect(message.isValid).toBe(true);
            });
        });
    });

    describe("when buildMessage is called", function() {

        it("should return concatenated message", function() {
            var message = buildMessage([createMessage('กรุณากรอก category.'), createMessage('กรุณากรอก location.')]);

            expect(message).toBe("กรุณากรอก category.</br>กรุณากรอก location.");
        });

     });

});