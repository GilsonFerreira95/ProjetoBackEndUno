var rootURL = "http://localhost:8080/CadastroDeTarefas/webresources/tarefas";

var tarefaAtual;

$('#btnListar').on('click',function(){
    listarTodos();
});

$('#btnDelete').hide();

$('#btnPesquisa').on('click', function(){
    procurar($('#procura').val());
    e.preventDefault();
    return false;
});

$('#pesquisa').keypress(function(e){
    if(e.which === 13){
        pesquisar($('#pesquisa').val());
    }
    e.preventDefault();
    return false;
});

$('#btnNovo').click(function(){
    novaTarefa();
    return false;
});

$('#btnSalvar').click(function(){
    if($('#idTarefa'.val()===''))
        inserirTarefa();
    else
        editarTarefa();
    
    return false;
    
});

$('#btnDelete').click(function(){
   excluirTarefa();
   return false;
});

$('#listaTarefa a').on('click',function(){
   listarPorId($(this).data('identity')); 
});

function procurar(pesquisa){
    if (pesquisa === '')
        listarTodos();
    
}

function listarTodos(){
    console.log('listarTodos');
    $.ajax({
        type: 'GET',
        url: rootURL ,
        dataType: 'json',
        success: listar()
        
    });
}

function pesquisarPorId(id){
    console.log('pesquisaId:' + id);
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function(dados){
            $('#btnDelete').show();
            console.log('pesquisaId sucesso: '+ dados.descricao);
            tarefaAtual = dados;
            exibirDetalhes(tarefaAtual);
        }
    });
}

function novaTarefa(){
    $('#btnDelete').hide();
    tarefaAtual = {};
    exibirDetalhes(tarefaAtual);

}

function inserirTarefa(){
    console.log('inserirTarefa');
    $.ajax({
        type: 'POST',
        contentType: 'application/Json',
        url: rootURL + '/' + 'inserir',
        dataType: "json",
        dados: formParaJson(),
        success: function(dados, textStatus, jqXHR){
            alert('Tarefa inserida com sucesso!');
            $('#btnDelete').show();
            $('idUsuario').val(dados.id);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou: ' + textStatus);
        }
    });
}

function editarTarefa(){
    console.log('editarTarefa');
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#idUsuario').val(),
        dataType: "json",
        success: function(dados, textStatus, jqXHR){
            alert('Tarefa atualizada com sucesso!');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou: ' + textStatus);
        }
    });
}

function excluirTarefa(){
    console.log('deletarTarefa');
    $.ajax({
        type: 'DELETE',
        url: rootURL + '/' + $('#idTarefa').val(),
        success: function(dados, textStatus, jqXHR){
            alert('Tarefa Excluida com sucesso!');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou');
        }
    });
}

function listar(dados){
    var list = dados === null ? [] : (dados instanceof Array ? dados : [dados]);
    
    $('#listaTarefas li').remove();
    $.each(list, function(index,usuario){
        $('#listaTarefas').append('<li><a href="#" data-identity= "'+ tarefa.id + '">' + tarefa.descricao+'</a></li>');
    });
}

function exibirDetalhes(tarefa) {
    $('#idTarefa').val(tarefa.id);
    $('#descricao').val(tarefa.descricao);
    $('#tempoEstimado').val(tarefa.endereco);
    $('#categoria').val(tarefa.categoria);
    $('#situacao').val(tarefa.situacao);
    $('#idUsuario').val(tarefa.idUsuario);
    
}

function formParaJson(){
    var idTarefa = $('#idTarefa').val();
    return JSON.stringify({
        "id" : idTarefa === "" ?null :idTarefa,
        "descricao": $('#descricao').val(),
        "tempoEstimado": $('#tempoEstimado').val(),
        "categoria": $('#categoria').val(),
        "situacao": $('#situacao').val(),
        "idUsuario": $('#idUsuario').val()
    });
}
