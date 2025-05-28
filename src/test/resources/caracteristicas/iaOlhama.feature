# language: pt
@FluxoOllama
Funcionalidade: Respostas personalizadas para diferentes personas
Como um usuário autenticado no sistema
Quero criar e interagir com diferentes personas
Para verificar se as respostas são personalizadas conforme o perfil

Cenário: Usuário cria personas após login e recebe respostas personalizadas
Dado que o usuário atendimento está logado no sistema
Quando o usuário cria uma persona chamada João com o perfil adolescente
E o usuário cria uma persona chamada maria com o perfil idosa
Entao duas personas são cadastradas no sistema
Quando o usuario envia a mensagem perguntando nome e idade para persona joao
Então o sistema deve responder como um adolecente
Quando  o usuario  envia a mensagem para Maria perguntando nome e idade
Então o sistema deve responder como uma senhora idosa