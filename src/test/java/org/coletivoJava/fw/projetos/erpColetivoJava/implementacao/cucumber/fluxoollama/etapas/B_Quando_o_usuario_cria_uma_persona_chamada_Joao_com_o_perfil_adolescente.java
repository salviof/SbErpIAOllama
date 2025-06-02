package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama.PERSONA1_ADOLESCENTE;
import static org.junit.Assert.assertTrue;

public class B_Quando_o_usuario_cria_uma_persona_chamada_Joao_com_o_perfil_adolescente {

	@Quando(EtapasFluxoOllama.QUANDO_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_JOAO_COM_O_PERFIL_ADOLESCENTE)
	public void implementacaoEtapa() {


		FluxoIAOllama.PERSONA1_ADOLESCENTE.setNome("Joao");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setDescricao("tem 17 anos, responda e aja igual adolescente");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setTonalidade("amigável");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setObjetivo("interagir de forma empática");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setRegrasResposta("Respeitar sempre o tom jovem e descontraído");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setLimitePalavras(10);
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setContexto("comunicação adolescente");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setInstrucoesAdicionais("Fornecer exemplos simples e populares");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setPublicoAlvo("adolescentes e jovens adultos");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setIdioma("Português");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setTipoRespostasPadrao("curtas e informais");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setPalavrasProibidas("linguagem ofensiva");
		FluxoIAOllama.PERSONA1_ADOLESCENTE.setStatus(true);


		ItfResposta resposta = ControllerIAPersonas.personaSalvar(PERSONA1_ADOLESCENTE);
		resposta.getRetorno();

		assertTrue(resposta.isSucesso());
	}
}