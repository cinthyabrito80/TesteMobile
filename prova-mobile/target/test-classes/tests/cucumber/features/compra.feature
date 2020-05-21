#language: pt
#encoding: utf-8
#autor: cintia.brito
#date: 18/05/2020

@android_compra
Funcionalidade: Compra de produto
Essa funcionalidade é para efetuar uma compra de um produto qualquer

Eu como cliente
Eu quero acessar o aplicativo da Centauro
Para que eu possa efetuar uma compra

@android
Cenario: Efetuar uma compra de um produto
    Dado que estaja logada no aplicativo
    E pesquiso um produto
    E seleciono o produto
    E seleciono o tamanho do produto
    E clico no botão Comprar
    E clico em Ir o pagamento
    E seleciono opção Boleto Bancario
    Quando clico no botao Confirmar pagamento
    Então exibe uma mensagem Obrigado por comprar conosco