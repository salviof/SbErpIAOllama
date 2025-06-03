package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import br.org.coletivoJava.fw.erp.implementacao.ia.utils.UtilPersona;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

import java.lang.UnsupportedOperationException;

public class E_Quando_o_usuario_envia_a_mensagem_perguntando_nome_e_idade_para_persona_joao {

    @Quando(EtapasFluxoOllama.QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PERGUNTANDO_NOME_E_IDADE_PARA_PERSONA_JOAO)
    public void implementacaoEtapa() {
        ItfRespostaAcaoDoSistema resposta = ControllerIAPersonas.conversaChatComHistorico(FluxoIAOllama.PERSONA1_ADOLESCENTE, "Qual seu nome e sua idade? Responda com 5 palavras", SBCore.getUsuarioLogado(), UtilPersona.gerarPromptSystem(FluxoIAOllama.PERSONA1_ADOLESCENTE)); // colocar o valor logico aqui
        Assert.assertTrue(resposta.isSucesso());
    }
}