#language: pt
Funcionalidade: Login

Cenário: Login com Sucesso
Dado que estou na tela Login
Quando insiro Login e Senha validos
Entao devo visualizar tela de listagem

Cenário: Login sem sucesso
Dado que estou na tela Login
Quando insiro Login e Senha invalidos
Entao devo visualizar mensagem de erro 

