package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

import java.lang.UnsupportedOperationException;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.FluxoAssuntoOllama.PERSONA_IA;

public class B_Quando_o_usuario_faz_uma_pergunta_sobre_um_dos_assuntos {

    @Quando(EtapasFluxoOllamaAssunto.QUANDO_O_USUARIO_FAZ_UMA_PERGUNTA_SOBRE_UM_DOS_ASSUNTOS)
    public void implementacaoEtapa() {

        PERSONA_IA.setId(1L);
        PERSONA_IA.setNome("CasanovaIA");
        String resposta = FluxoIAOllama.OLHAMA.obterResposta(PERSONA_IA, SBCore.getUsuarioLogado(), "Quais serviços a empresa oferece?");
        Assert.assertNotNull("A resposta veio nula: ", resposta);
    }
}