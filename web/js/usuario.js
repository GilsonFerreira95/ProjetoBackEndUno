/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var rootURL = "http://localhost:8080/CadastroDeTarefas/webresources/usuarios/usuario";

var usuarioAtual;

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
    novoUsuario();
    return false;
});

$('#btnSalvar').click(function(){
    if($('#idUsuario'.val()===''))
        inserirUsuario();
    else
        editarUsuario();
    
    return false;
    
});

$('#btnDelete').click(function(){
   excluirUsuario();
   return false;
});

$('#listaUsuario a').live('click',function(){
   listarPorId($(this).data('identity')); 
});

function procurar(pesquisa){
    if (pesquisa === '')
        listarTodos();
    else
        procurarPorNome(pesquisa);
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
            console.log('pesquisaId sucesso: '+ dados.nome);
            usuarioAtual = dados;
            exibirDetalhes(usuarioAtual);
        }
    });
}

function novoUsuario(){
    $('#btnDelete').hide();
    usuarioAtual = {};
    exibirDetalhes(usuarioAtual);

}

function inserirUsuario(){
    console.log('inserirUsuario');
    $.ajax({
        type: 'POST',
        contentType: 'application/Json',
        url: rootURL + '/' + 'inserir',
        dataType: "json",
        dados: formParaJson(),
        success: function(dados, textStatus, jqXHR){
            alert('Usuario inserido com sucesso!');
            $('#btnDelete').show();
            $('idUsuario').val(dados.id);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou: ' + textStatus);
        }
    });
}

function editarUsuario(){
    console.log('editarUsuario');
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#idUsuario').val(),
        dataType: "json",
        success: function(dados, textStatus, jqXHR){
            alert('Usuario atualizado com sucesso!');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou: ' + textStatus);
        }
    });
}

function excluirUsuario(){
    console.log('deletarUsuario');
    $.ajax({
        type: 'DELETE',
        url: rootURL + '/' + $('#idUsuario').val(),
        success: function(dados, textStatus, jqXHR){
            alert('Usuario Excluido com sucesso!');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Falhou');
        }
    });
}

function listar(dados){
    var list = dados === null ? [] : (dados instanceof Array ? dados : [dados]);
    
    $('#listaUsuarios li').remove();
    $.each(list, function(index,usuario){
        $('#listaUsuarios').append('<li><a href="#" data-identity= "'+ usuario.id + '">' + usuario.nome+'</a></li>');
    });
}

function exibirDetalhes(usuario) {
    $('#idUsuario').val(usuario.id);
    $('#nome').val(usuario.nome);
    $('#endereco').val(usuario.endereco);
    $('#cargo').val(usuario.cargo);
    $('#horariosTrabalho').val(usuario.horariosTrabalho);
    
}

function formParaJson(){
    var idUsuario = $('#idUsuario').val();
    return JSON.stringify({
        "id" : idUsuario === "" ?null :idUsuario,
        "nome": $('#nome').val(),
        "endereco": $('#endereco').val(),
        "cargo": $('#cargo').val(),
        "horariosTrabalho": $('#horariosTrabalho').val()
    });
}


