// Função que busca dinamicamente o código do Título a ser deletado, mostrando ao usuário a descrição desse título na mensagem de confirmação do modal

$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	
	// Recebe o botao que disparou o evento do html
	var button = $(event.relatedTarget);
	
	// Salva os campos do objeto disponilizados pelo Thymeleaf nas variaveis
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	// Definindo modal pra utilizacao dos metodos
	var modal = $(this);
	
	// Encontra action e form dentro do html
	var form = modal.find('form');
	var action = form.data('url-base');
	
	// Caso a string de action nao termine com barra, adiciona uma barra
	if (!action.endsWith('/')) {
		action+= '/';
	}
	
	// Adiciona a string do action o codigo do titulo
	form.attr('action', action + codigoTitulo);
	
	// Edita a mensagem do html com as informações do titulo a ser excluido
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');

});


// Toda vez que recarregar a página, procurar o especificado e chamar a funcao

$(function() {
	$('[rel="tooltip"]').tooltip();
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.'});
	
	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		
		
		response.done(function(response) {
		var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + response +'</span>');
			
			botaoReceber.hide();
		});
		
		response.fail(function(response) {
			console.log(response);
			alert('Erro recebendo cobrança');		
		});
		
		console.log('urlReceber', urlReceber);	
	});
});
