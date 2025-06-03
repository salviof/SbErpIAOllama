package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Entao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

public class F_Entao_o_sistema_deve_responder_como_um_adolecente {
    @Entao(EtapasFluxoOllama.ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UM_ADOLECENTE)
    public void implementacaoEtapa() {
        String pastaArquivo = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/Joaoatendente.json";
        try {
            String content = new String(Files.readAllBytes(Paths.get(pastaArquivo)));
            JSONObject json = new JSONObject(content);
            Assert.assertTrue("O arquivo json possui o joao como resposta", json.getString("content").contains("Joao"));
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo o arquivo Json: " + e.getMessage(), e);
        } catch (org.json.JSONException e) {
			throw new RuntimeException("Error analisando o arquivo: " + e.getMessage(), e);
		}
	}
}