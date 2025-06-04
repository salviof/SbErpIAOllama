package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

public class E_Quando_o_usuario_envia_a_mensagem_perguntando_nome_e_idade_para_persona_joao {

    @Quando(EtapasFluxoOllama.QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PERGUNTANDO_NOME_E_IDADE_PARA_PERSONA_JOAO)
    public void implementacaoEtapa() {
        ItfRespostaAcaoDoSistema resposta = ControllerIAPersonas.conversaChatComHistorico(FluxoIAOllama.PERSONA1_ADOLESCENTE, "What is JAVA?", SBCore.getUsuarioLogado(), "Answer me like a teenager");
        Assert.assertTrue(resposta.isSucesso());
    }
}