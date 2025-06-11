package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

public class G_Quando_o_usuario_envia_a_mensagem_para_Maria_perguntando_nome_e_idade {

	@Quando(EtapasFluxoOllama.QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PARA_MARIA_PERGUNTANDO_NOME_E_IDADE)
	public void implementacaoEtapa() {
//		ItfRespostaAcaoDoSistema resposta = ControllerIAPersonas.conversaChatComHistorico(FluxoIAOllama.PERSONA2_IDOSO, "Qual seu nome e sua idade? Responda com 5 palavras", SBCore.getUsuarioLogado(), UtilPersona.gerarPromptSystem(FluxoIAOllama.PERSONA2_IDOSO));
		ItfRespostaAcaoDoSistema resposta = ControllerIAPersonas.conversaChatComHistorico(FluxoIAOllama.PERSONA2_IDOSO, "Who is better Java or Kotlin?", SBCore.getUsuarioLogado(), ""); //UtilPersona.gerarPromptSystem(FluxoIAOllama.PERSONA2_IDOSO
		Assert.assertTrue(resposta.isSucesso());
	}
}