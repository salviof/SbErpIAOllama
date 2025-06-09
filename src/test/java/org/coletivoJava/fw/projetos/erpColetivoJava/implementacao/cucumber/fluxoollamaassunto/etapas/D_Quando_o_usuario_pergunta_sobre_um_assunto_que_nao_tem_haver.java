package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

import java.lang.UnsupportedOperationException;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama.PERSONA_IA;

public class D_Quando_o_usuario_pergunta_sobre_um_assunto_que_nao_tem_haver {

	@Quando(EtapasFluxoOllamaAssunto.QUANDO_O_USUARIO_PERGUNTA_SOBRE_UM_ASSUNTO_QUE_NAO_TEM_HAVER)
	public void implementacaoEtapa() {
		String resposta = FluxoIAOllama.OLHAMA.obterResposta(PERSONA_IA, SBCore.getUsuarioLogado(), "Qual o maior animal do mundo?");
		Assert.assertNotNull("A resposta veio nula: ", resposta);
	}
}