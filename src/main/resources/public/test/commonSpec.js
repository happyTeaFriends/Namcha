describe("common", function() {
	
	describe("when call isEmpty()", function() {

		it("should return true when input text is empty", function() {
			expect(isEmpty("")).toBe(true);
		});
		
		it("should return false when input text is not empty", function() {
			expect(isEmpty("Not empty na krub.")).toBe(false);
		});
	});
});