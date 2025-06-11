package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

import java.io.File;
import java.lang.UnsupportedOperationException;

public class G_Entao_a_sessao_e_limpa_e_o_historico_apagado {

    @Entao(EtapasFluxoOllamaAssunto.ENTAO_A_SESSAO_E_LIMPA_E_O_HISTORICO_APAGADO)
    public void implementacaoEtapa() {
        String caminhoArquivo = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/1_1.json";
        File arquivo = new File(caminhoArquivo);

        Assert.assertFalse("O arquivo nao deveria existir: " + caminhoArquivo, arquivo.exists());
    }
}