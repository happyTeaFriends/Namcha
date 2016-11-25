describe("event-detail", function() {
	
	describe("when getParameterUrl is called", function() {
		it("should get content id from url", function() {
			var id = getUrlParameter('id=58356fa1039c10028446d368','id');
			expect(id).toBe('58356fa1039c10028446d368');
		});
	});
	
	describe("when retrieveContent is called", function() {
		beforeEach(function() {
			jasmine.Ajax.install();
		});

		afterEach(function() {
			jasmine.Ajax.uninstall();
		});

		it("should call content/{id}", function() {
			retrieveContent('58356fa1039c10028446d368');
			expect(jasmine.Ajax.requests.mostRecent().url).toBe('content/58356fa1039c10028446d368');
		});
	});
});