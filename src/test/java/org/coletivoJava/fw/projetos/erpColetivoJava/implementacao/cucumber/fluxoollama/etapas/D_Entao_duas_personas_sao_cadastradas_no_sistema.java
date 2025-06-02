package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Entao;

import javax.persistence.EntityManager;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama.PERSONA1_ADOLESCENTE;
import static org.junit.Assert.assertTrue;

public class D_Entao_duas_personas_sao_cadastradas_no_sistema {

	@Entao(EtapasFluxoOllama.ENTAO_DUAS_PERSONAS_SAO_CADASTRADAS_NO_SISTEMA)
	public void implementacaoEtapa() {

		EntityManager em = UtilSBPersistencia.getNovoEM();
		try {
			ItfResposta resposta = ControllerIAPersonas.novaConversa(PERSONA1_ADOLESCENTE, "Qual sua idade");
			resposta.getRetorno();
			assertTrue(resposta.isSucesso());
		} finally {
			UtilSBPersistencia.fecharEM(em);
		}
	}
}