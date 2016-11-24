describe("modal", function() {

	beforeEach(function() {
        spyOn($("#messageModalBody"), 'html');
        spyOn($("#messageModal"), 'modal')
    });

    it("should call (element).html", function() {
//        // Arrange
//        var contentHtml = "<b>This is modal msg.</b>"
//
//        // Action
//        showModal(contentHtml);
//
//        // Assert
//        expect($("#messageModalBody").html).toHaveBeenCalledWith(contentHtml);
//        expect($("#messageModal").modal).toHaveBeenCalledWith('show');
    });
});