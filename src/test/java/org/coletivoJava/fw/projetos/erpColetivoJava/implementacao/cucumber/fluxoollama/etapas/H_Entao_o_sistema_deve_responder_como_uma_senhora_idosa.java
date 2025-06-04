package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas;

import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllama;
import cucumber.api.java.pt.Entao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class H_Entao_o_sistema_deve_responder_como_uma_senhora_idosa {

    @Entao(EtapasFluxoOllama.ENTAO_O_SISTEMA_DEVE_RESPONDER_COMO_UMA_SENHORA_IDOSA)
    public void implementacaoEtapa() {
        String pastaArquivo = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/Maria_atendente.json";
        try {
            String conteudo = new String(Files.readAllBytes(Paths.get(pastaArquivo)));
            JSONObject json = new JSONObject(conteudo);
            JSONArray mensagensDaIA = json.getJSONArray("messages");
            boolean temAssistente = false;

            for (int i = 0; i < mensagensDaIA.length(); i++) {
                JSONObject message = mensagensDaIA.getJSONObject(i);
                if (message.has("role") && message.getString("role").equals("assistant")) {
                    temAssistente = true;
                    break;
                }
            }
            Assert.assertTrue("O JSON deveria ter pelo menos uma resposta do assistant", temAssistente);
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo o arquivo Json: " + e.getMessage(), e);
        } catch (org.json.JSONException e) {
            throw new RuntimeException("Error analisando o arquivo: " + e.getMessage(), e);
        }
    }
}