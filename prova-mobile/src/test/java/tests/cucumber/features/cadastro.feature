#language: pt
#encoding: utf-8
#autor: cintia.brito
#date: 18/05/2020

@android_cadastro
Funcionalidade: Cadastro de usuario
  Essa funcionalidade é efetuar um cadastro de cliente novo

  Eu como cliente
  Eu quero cadastrar uma conta
  Para que eu visualize meu castrado com sucesso

@android
Cenario: Realizar Cadastro usuario com sucesso
    Dado que estou na Home aplicativo da Centarauro
    E clico no menu
    E clico no link Clique aqui para entrar ou se cadastrar
    E clico no botao Quero criar uma conta
    Quando preenchar todos os campos para o cadatro Pessoa Fisica
    Entao retorno para home Home aplicativo da Centarauro