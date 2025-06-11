package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama;
import org.junit.Assert;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama.PERSONA_IA;

public class F_Quando_o_usuario_chega_no_limite_da_sessao {

	@Quando(EtapasFluxoOllamaAssunto.QUANDO_O_USUARIO_CHEGA_NO_LIMITE_DA_SESSAO)
	public void implementacaoEtapa() {
		try {
			String resposta = FluxoAssuntoOllama.OLLAMA.limparSessao(PERSONA_IA, SBCore.getUsuarioLogado());

			Assert.assertEquals("Sessão limpa com suceso", resposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}