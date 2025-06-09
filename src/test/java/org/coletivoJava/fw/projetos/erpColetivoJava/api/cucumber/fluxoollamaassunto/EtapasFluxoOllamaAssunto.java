package org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.fluxoollamaassunto;
public enum EtapasFluxoOllamaAssunto {
	_DADO_QUE_O_USUARIO_ESTA_LOGADO_NO_SISTEMA, _QUANDO_O_USUARIO_FAZ_UMA_PERGUNTA_SOBRE_UM_DOS_ASSUNTOS, _ENTAO_A_IA_DEVE_RESPONDER_OS_ASSUNTOS_QUE_ELA_ENTENDEU, _QUANDO_O_USUARIO_PERGUNTA_SOBRE_UM_ASSUNTO_QUE_NAO_TEM_HAVER, _ENTAO_A_IA_DEVE_RESPONDER_QUE_NAO_SABE_E_PARA_TENTAR_UM_OUTRO_ASSUNTO, _QUANDO_O_USUARIO_CHEGA_NO_LIMITE_DA_SESSAO, _ENTAO_A_SESSAO_E_LIMPA_E_O_HISTORICO_APAGADO;

	public static final String DADO_QUE_O_USUARIO_ESTA_LOGADO_NO_SISTEMA = "que o usuário está logado no sistema";
	public static final String QUANDO_O_USUARIO_FAZ_UMA_PERGUNTA_SOBRE_UM_DOS_ASSUNTOS = "o usuario faz uma pergunta sobre um dos assuntos";
	public static final String ENTAO_A_IA_DEVE_RESPONDER_OS_ASSUNTOS_QUE_ELA_ENTENDEU = "a IA deve responder os assuntos que ela entendeu";
	public static final String QUANDO_O_USUARIO_PERGUNTA_SOBRE_UM_ASSUNTO_QUE_NAO_TEM_HAVER = "o usuario pergunta sobre um assunto que nao tem haver";
	public static final String ENTAO_A_IA_DEVE_RESPONDER_QUE_NAO_SABE_E_PARA_TENTAR_UM_OUTRO_ASSUNTO = "a IA deve responder que não sabe e para tentar um outro assunto";
	public static final String QUANDO_O_USUARIO_CHEGA_NO_LIMITE_DA_SESSAO = "o usuario chega no limite da sessao";
	public static final String ENTAO_A_SESSAO_E_LIMPA_E_O_HISTORICO_APAGADO = "a sessao e limpa e o historico apagado";
}