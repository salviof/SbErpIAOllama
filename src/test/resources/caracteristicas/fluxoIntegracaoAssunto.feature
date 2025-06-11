# language: pt
  @FluxoOllamaAssunto
  Funcionalidade: Resposta de acordo com o assunto que o usuario selecionar

Cenario: Usuario pergunta à IA sobre um dos assuntos
Dado que o usuário está logado no sistema
Quando o usuario faz uma pergunta sobre um dos assuntos
Entao a IA deve responder os assuntos que ela entendeu
Quando o usuario pergunta sobre um assunto que nao tem haver
Entao a IA deve responder que não sabe e para tentar um outro assunto
Quando o usuario chega no limite da sessao
Entao a sessao e limpa e o historico apagado


