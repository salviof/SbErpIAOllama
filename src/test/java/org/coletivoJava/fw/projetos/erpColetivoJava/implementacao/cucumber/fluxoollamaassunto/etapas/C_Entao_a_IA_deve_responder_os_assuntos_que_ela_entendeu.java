package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.UnsupportedOperationException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class C_Entao_a_IA_deve_responder_os_assuntos_que_ela_entendeu {

    @Entao(EtapasFluxoOllamaAssunto.ENTAO_A_IA_DEVE_RESPONDER_OS_ASSUNTOS_QUE_ELA_ENTENDEU)
    public void implementacaoEtapa() {
        String arquivoJsonDaConversa = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/1_1.json";

        try (InputStream input = new FileInputStream(arquivoJsonDaConversa);
             JsonReader reader = Json.createReader(input)) {
            JsonObject objetoJson = reader.readObject();
            JsonArray mensagens = objetoJson.getJsonArray("messages");
            String respostaIA = null;

            for (int i = mensagens.size() - 1; i >= 0; i--) {
                JsonObject mensagme = mensagens.getJsonObject(i);
                String role = mensagme.getString("role", "");
                if (role.equals("assistant")) {
                    respostaIA = mensagme.getString("content", "").trim();
                    break;
                }
            }
            if (respostaIA == null || respostaIA.isEmpty()) {
                throw new AssertionError("A resposta da IA está vazia ou não foi encontrada.");
            }

            String[] palavrasEsperadas = {
                    "criação de sites",
                    "marketing digital",
                    "desenvolvimento de sistemas",
                    "automação de e-mails",
                    "SEO",
                    "Google Ads",
                    "redes sociais"
            };

            String finalRespostaIA = respostaIA;
            boolean temAlgumAssuntoReconhecido = Arrays.stream(palavrasEsperadas)
                    .anyMatch(assunto -> finalRespostaIA.toLowerCase().contains(assunto.toLowerCase()));

            Assert.assertTrue("A IA nao mencionou as palavras de algum dos assuntos ", temAlgumAssuntoReconhecido);
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo o arquivo Json: " + e.getMessage(), e);
        }
    }
}