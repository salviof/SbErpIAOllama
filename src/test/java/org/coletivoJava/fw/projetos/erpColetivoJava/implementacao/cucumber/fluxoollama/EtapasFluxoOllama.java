package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama;
public enum EtapasFluxoOllama {
	_DADO_QUE_O_USUARIO_ATENDIMENTO_ESTA_LOGADO_NO_SISTEMA, _QUANDO_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_JOAO_COM_O_PERFIL_ADOLESCENTE, _E_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_MARIA_COM_O_PERFIL_IDOSA, _ENTAO_DUAS_PERSONAS_SAO_CADASTRADAS_NO_SISTEMA, _QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PERGUNTANDO_NOME_E_IDADE_PARA_PERSONA_JOAO, _ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UM_ADOLECENTE, _QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PARA_MARIA_PERGUNTANDO_NOME_E_IDADE, _ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UMA_SENHORA_IDOSA;

	public static final String DADO_QUE_O_USUARIO_ATENDIMENTO_ESTA_LOGADO_NO_SISTEMA = "que o usuário atendimento está logado no sistema";
	public static final String QUANDO_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_JOAO_COM_O_PERFIL_ADOLESCENTE = "o usuário cria uma persona chamada João com o perfil adolescente";
	public static final String E_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_MARIA_COM_O_PERFIL_IDOSA = "o usuário cria uma persona chamada maria com o perfil idosa";
	public static final String ENTAO_DUAS_PERSONAS_SAO_CADASTRADAS_NO_SISTEMA = "duas personas são cadastradas no sistema";
	public static final String QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PERGUNTANDO_NOME_E_IDADE_PARA_PERSONA_JOAO = "o usuario envia a mensagem perguntando nome e idade para persona joao";
	public static final String ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UM_ADOLECENTE = "o sistema deve responder como um adolecente";
	public static final String QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PARA_MARIA_PERGUNTANDO_NOME_E_IDADE = "o usuario  envia a mensagem para Maria perguntando nome e idade";
	public static final String ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UMA_SENHORA_IDOSA = "o sistema deve responder como uma senhora idosa";
}