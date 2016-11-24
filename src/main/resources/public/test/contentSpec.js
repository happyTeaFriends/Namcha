describe("content", function() {
	
	describe("when createContent is called.", function() {
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
});