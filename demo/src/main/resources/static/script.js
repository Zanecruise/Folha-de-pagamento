listEmpregador();
function listEmpregador() {
    fetch('/edit/empregador/list')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao obter empregadores');
            }
            return response.json();
        })
        .then(empregadores => {
            const selectEmpregador = document.getElementById('select-empregador'); // pegando o <select>
            selectEmpregador.innerHTML = ''; // Limpa o conteúdo atual do select de empregadores
            empregadores.forEach(empregador => {
                const option = document.createElement('option'); // cria as opções no select
                option.value = empregador.id; //adiciona como value o id do empregador
                option.textContent = empregador.nome; //coloca como texto principal o nome da empresa
                selectEmpregador.appendChild(option); // Adicionando a opção ao selectEmpregador
            });

            // Após preencher os empregadores, seleciona automaticamente o primeiro
            if (empregadores.length > 0) {
                const primeiroEmpregadorId = empregadores[0].id;
                listFuncionario(primeiroEmpregadorId); // Preenche os funcionários do primeiro empregador
            }
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}



function listFuncionario(id_empregador) {
    console.log(id_empregador);

    const selectFuncionario = document.getElementById('select-funcionario');
    selectFuncionario.innerHTML = ''; // Limpa o conteúdo atual do select de funcionários

    fetch('/edit/funcionario/list/' + id_empregador)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao obter funcionários');
            }
            return response.json();
        })
        .then(funcionarios => {
            console.log('Funcionários:', funcionarios);
            funcionarios.forEach(funcionario => {
                const option = document.createElement('option');
                option.value = funcionario.id;
                option.textContent = funcionario.nome;
                selectFuncionario.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}


function controllerIdFuncionario() {
    var selectFuncionario = document.getElementById('select-funcionario');
    var idFuncionario = selectFuncionario.value;
    console.log("O id do funcionario é: " + idFuncionario);

    fetch('/final/emitir-folha/' + idFuncionario, {
        method: 'POST'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao enviar ID do funcionário');
            }
            console.log('ID do funcionário enviado com sucesso');
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}

fetch('/download?filePath=' + encodeURIComponent(caminhoExcel), {
    method: 'GET'
})
.then(response => {
    if (!response.ok) {
        throw new Error('Erro ao baixar o arquivo');
    }
    return response.blob();
})
.then(blob => {
    const url = window.URL.createObjectURL(new Blob([blob]));
    const a = document.createElement('a');
    a.href = url;
    a.download = 'arquivo.xlsx'; // Nome do arquivo que será baixado
    document.body.appendChild(a);
    a.click();
    window.URL.revokeObjectURL(url);
})
.catch(error => {
    console.error('Erro:', error);
});




fetch('/confirm')
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao obter o boolean');
        }
        return response.json();
    })
    .then(confirm => {
        var confirmText = document.getElementById('confirm-emissao')
        if (confirm === true) {
            confirmText.innerText = 'Folha de Pagamento emitida com Sucesso!'
            confirmText.style.color = 'green';
            confirmText.style.display = 'block';
            listEmpregador();
        }
    })
    .catch(error => {
        console.error('Erro:', error);
    });

function ocultarConfirm() {
    document.getElementById('confirm-emissao').style.display = 'none';
}

