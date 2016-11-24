describe("modal", function() {

    $.prototype.modal = function(){};

	beforeEach(function() {
	    spyOn($.fn, 'html');
	    spyOn($.fn, 'modal');
    });

    it("should call (messageModalBody).html", function() {
        // Arrange
        var contentHtml = "<b>This is modal msg.</b>";

        // Action
        showModal(contentHtml);

        // Assert
        expect($("#messageModalBody").html).toHaveBeenCalledWith(contentHtml);
    });

    it("should call (messageModal).modal by passing 'show action'", function() {
        // Action
        showModal("");

        // Assert
        expect($("#messageModal").modal).toHaveBeenCalledWith('show');
    });

});