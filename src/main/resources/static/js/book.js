// Function that gets the bookId to be deleted abd show the book's title in the modal confirmation

$('#deleteConfirmationModal').on('show.bs.modal', function(event) {
	
	// Receives the button that started the event in the html file
	var button = $(event.relatedTarget);
	
	// Saves the objects's field
	var bookId = button.data('id');
	var bookTitle = button.data('title');
	
	// Defines the variable modal in order to use the methods
	var modal = $(this);
	
	// Finds the fields action and form inside the html file
	var form = modal.find('form');
	var action = form.data('url-base');
	
	// In case the action string do not end with slash, add a slash
	if (!action.endsWith('/')) {
		action+= '/';
	}
	
	// Adds to the action string the bookId
	form.attr('action', action + bookId);
	
	// Adds to the message the title to be deleted
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + bookTitle + '</strong>?');

});


// Everytime the page refreshes it looks for the class and calls the function

$(function() {
	$('[rel="tooltip"]').tooltip();
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.'});
});
