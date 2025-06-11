package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios.FabUsuarioPadrao;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabConfigOllama;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Dado;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama.USUARIO_AUTENTICADO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class A_Dado_que_o_usuario_atendimento_esta_logado_no_sistema {

    @Dado(EtapasFluxoOllama.DADO_QUE_O_USUARIO_ATENDIMENTO_ESTA_LOGADO_NO_SISTEMA)
    public void implementacaoEtapa() {
        USUARIO_AUTENTICADO = (ItfUsuario) FabUsuarioPadrao.USUARIO_ATENDIMENTO.getRegistro();

        SBCore.getServicoSessao().logarEmailESenha(USUARIO_AUTENTICADO.getEmail(), USUARIO_AUTENTICADO.getSenha());
        SBCore.getServicoSessao().getSessaoAtual().getUsuario();
        SBCore.getServicoSessao().getSessaoAtual().isIdentificado();

        assertTrue("O usuario deve estar logado", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
    }
}