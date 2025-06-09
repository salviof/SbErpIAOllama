package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios.FabUsuarioPadrao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama.USUARIO_AUTENTICADO;
import static org.junit.Assert.assertTrue;

public class A_Dado_que_o_usuario_esta_logado_no_sistema {

	@Dado(EtapasFluxoOllamaAssunto.DADO_QUE_O_USUARIO_ESTA_LOGADO_NO_SISTEMA)
	public void implementacaoEtapa() {
		USUARIO_AUTENTICADO = (ItfUsuario) FabUsuarioPadrao.USUARIO_ATENDIMENTO.getRegistro();

		SBCore.getServicoSessao().logarEmailESenha(USUARIO_AUTENTICADO.getEmail(), USUARIO_AUTENTICADO.getSenha());
		SBCore.getServicoSessao().getSessaoAtual().getUsuario();
		SBCore.getServicoSessao().getSessaoAtual().isIdentificado();


		assertTrue("O usuario deve estar logado", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
	}
}