# language: pt
@FluxoOllama
Funcionalidade: Respostas personalizadas para diferentes personas
Como um usuário autenticado no sistema
Quero criar e interagir com diferentes personas
Para verificar se as respostas são personalizadas conforme o perfil

Cenário: Usuário cria personas após login e recebe respostas personalizadas
Dado que o usuário "atendimento" está logado no sistema
Quando o usuário cria uma persona chamada "João" com o perfil "adolescente"
E o usuário cria uma persona chamada "Dona Maria" com o perfil "idosa"
E "João" envia a mensagem "Oi, tudo bem?"
Então o sistema deve responder como um adolecente
E "Dona Maria" envia a mensagem "Oi, tudo bem?"
Então o sistema deve responder como uma senhora idosa.