package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;

import static org.junit.Assert.assertNotNull;

public class E_Quando_o_usuario_envia_a_mensagem_perguntando_nome_e_idade_para_persona_joao {

    @Quando(EtapasFluxoOllama.QUANDO_O_USUARIO_ENVIA_A_MENSAGEM_PERGUNTANDO_NOME_E_IDADE_PARA_PERSONA_JOAO)
    public void implementacaoEtapa() {
        FluxoIAOllama.atualizarEntidadesDeclaradas();;
        Persona joao= FluxoIAOllama.PERSONA1_ADOLESCENTE;
        String resposta=  FluxoIAOllama.OLHAMA.obterResposta(joao,SBCore.getUsuarioLogado(),"Qual seu nome e sua idade?");
        assertNotNull("A resposta veio nula",resposta);
    }
}