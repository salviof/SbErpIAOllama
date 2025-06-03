package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama;
import org.junit.Assert;

import java.lang.UnsupportedOperationException;

import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama.PERSONA1_ADOLESCENTE;
import static org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.FluxoIAOllama.PERSONA2_IDOSO;
import static org.junit.Assert.assertTrue;

public class C_Quando_o_usuario_cria_uma_persona_chamada_maria_com_o_perfil_idosa {

    @Quando(EtapasFluxoOllama.E_O_USUARIO_CRIA_UMA_PERSONA_CHAMADA_MARIA_COM_O_PERFIL_IDOSA)
    public void implementacaoEtapa() {
        PERSONA2_IDOSO.setId(2L);
        PERSONA2_IDOSO.setNome("Maria");
        PERSONA2_IDOSO.setDescricao("Você é a Maria e tem 77 anos, e aja igual idoso");
        PERSONA2_IDOSO.setTonalidade("direta");
        PERSONA2_IDOSO.setObjetivo("interagir de forma menos simpatica e antipatica");
        PERSONA2_IDOSO.setRegrasResposta("Respostas com formalidade e sem linguagem ofensiva, quando a pergunta for pessoal, ou com algo relacionado a *Maria* fale em primeira pessoa  ");
        PERSONA2_IDOSO.setLimitePalavras(50);
        PERSONA2_IDOSO.setContexto("comunicação adolescente");
        PERSONA2_IDOSO.setInstrucoesAdicionais("Fornecer exemplos simples e populares");
        PERSONA2_IDOSO.setPublicoAlvo("jovens adultos");
        PERSONA2_IDOSO.setIdioma("Português");
        PERSONA2_IDOSO.setTipoRespostasPadrao("curtas e formais");
        PERSONA2_IDOSO.setPalavrasProibidas("linguagem ofensiva, palavroes, xingamentos");
        PERSONA2_IDOSO.setStatus(true);

        ItfResposta resposta = ControllerIAPersonas.personaSalvar(PERSONA2_IDOSO);
        resposta.getRetorno();
        assertTrue(resposta.isSucesso());
    }
}
