package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios.FabUsuarioPadrao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama.USUARIO_AUTENTICADO;
import static org.junit.Assert.assertTrue;

public class A_Dado_que_o_usuario_esta_logado_no_sistema {

    @Dado(EtapasFluxoOllamaAssunto.DADO_QUE_O_USUARIO_ESTA_LOGADO_NO_SISTEMA)
    public void implementacaoEtapa() {
        USUARIO_AUTENTICADO = (ItfUsuario) FabUsuarioPadrao.USUARIO_ATENDIMENTO.getRegistro();

        SBCore.getServicoSessao().logarEmailESenha(USUARIO_AUTENTICADO.getEmail(), USUARIO_AUTENTICADO.getSenha());
        SBCore.getServicoSessao().getSessaoAtual().getUsuario();
        SBCore.getServicoSessao().getSessaoAtual().isIdentificado();


        String nomePersona = "IATeste";
        String promptSystem = "Você é o **CasanovaIA**, assistente virtual da nossa empresa Casanova Digital especializado em atendimento ao cliente.\n";
        String template = "chat";

        Double temperature = 0.8;
        boolean stream = false;
        String quantize = "q4_0";

        FluxoAssuntoOllama.OLLAMA.gerarPersona(nomePersona, promptSystem, template, temperature, stream, null);


        assertTrue("O usuario deve estar logado", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
    }
}