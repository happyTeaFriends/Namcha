describe("content", function() {

	describe("when event list page is called", function() {
		beforeEach(function() {
			jasmine.Ajax.install();
		});

		afterEach(function() {
			jasmine.Ajax.uninstall();
		});

		it("should call with url event list page", function() {
			onloadListEvents();

			expect(jasmine.Ajax.requests.mostRecent().url).toBe('content');
		});
	});
});