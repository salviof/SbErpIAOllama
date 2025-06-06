package br.org.coletivoJava.fw.erp.implementacao.ia.utils;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilHistoricoConversa {
    private static final String LOCAL_ARQUIVOS_JSON = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/";
    private static final String MODELO = "CasanovaIA:latest";

    public static File getArquivoConversa(String pChaveConversaSessao) {
        String endereco = LOCAL_ARQUIVOS_JSON + pChaveConversaSessao;
        return new File(endereco);
    }

    public static JsonObject carregarConversaExistente(String pChave) {
        File arquivo = getArquivoConversa(pChave);
        if (!arquivo.exists()) {
            return null;
        }

        try (JsonReader lerJson = Json.createReader(new FileReader(arquivo))) {
            return lerJson.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler conversa existente: " + e);
        }
    }

    public static JsonObject criarNovaConversa(String pChaveConversaSessao, String pPromptSystem, String pModel) {
        JsonArrayBuilder mensagens = Json.createArrayBuilder();

        if (pPromptSystem != null) {
            mensagens.add(Json.createObjectBuilder()
                    .add("role", "system")
                    .add("content", pPromptSystem));
        }

        JsonObject novaConversa = Json.createObjectBuilder()
                .add("model", pModel)
                .add("messages", mensagens.build())
                .build();

        salvarConversa(pChaveConversaSessao, novaConversa);
        return novaConversa;
    }

    public static void salvarConversa(String pChaveConversaSessao, JsonObject conversa) {
        try (JsonWriter writer = Json.createWriter(new FileWriter(getArquivoConversa(pChaveConversaSessao)))) {
            writer.writeObject(conversa);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar conversa: " + e);
        }
    }

    public static void adicionarMensagem(String pChave, String pRole, String pContent) {
        JsonObject conversa = carregarConversaExistente(pChave);
        if (conversa == null) {
            throw new IllegalStateException("Conversa inexistente. Crie a conversa antes de adicionar mensagens.");
        }

        JsonArray mensagensAntigas = conversa.getJsonArray("messages");
        JsonArrayBuilder mensagensNovasBuilder = Json.createArrayBuilder();

        mensagensAntigas.forEach(mensagensNovasBuilder::add);
        mensagensNovasBuilder.add(Json.createObjectBuilder()
                .add("role", pRole)
                .add("content", pContent));

        JsonObject novaConversa = Json.createObjectBuilder()
                .add("model", conversa.getString("model"))
                .add("messages", mensagensNovasBuilder.build())
                .build();

        salvarConversa(pChave, novaConversa);
    }

    public static JsonObject carregarHistoricoConversa(String pChaveConversa, ItfPersona itfPersona, String pMensagem, String pPromptSystem) {
        JsonObject conversa = carregarConversaExistente(pChaveConversa);
        if(conversa == null) {
            conversa = criarNovaConversa(pChaveConversa, pPromptSystem, itfPersona.getNome() + "latest");
        }

        adicionarMensagem(pChaveConversa, "user", pMensagem);
        JsonObject conversaAtualizada = carregarConversaExistente(pChaveConversa);
        JsonArray mensagens = conversaAtualizada.getJsonArray("messages");

        JsonArrayBuilder builder = Json.createArrayBuilder();
        mensagens.forEach(builder::add);
        return Json.createObjectBuilder()
                .add("model", itfPersona.getNome() + ":latest")
                .add("messages", builder.build())
                .add("stream", false)
                .add("keep_alive", "10m")
                .build();


        //        UtilOllamaConversas.adicionarMensagem(pChaveConversa, "user", pMensagem, pPromptSystem, "tinnyllama:1.1b");
//        JsonObject conversaAtualizada = UtilOllamaConversas.lerConversa(pChaveConversa, pPromptSystem, itfPersona.getNome() + ":latest");
//        JsonObject conversaAtualizada = UtilOllamaConversas.lerConversa(pChaveConversa, pPromptSystem, "tinnyllama:1.1b");
//        JsonArray mensagens = conversaAtualizada.getJsonArray("messages");
//        JsonArrayBuilder builder = Json.createArrayBuilder();
//        mensagens.forEach(builder::add);
//        String ultimaMensagem = mensagens.getJsonObject(mensagens.size() - 1).getString("content");

    }

    public static String carregarPersona(String pConfiguracaoPersona) {
        return pConfiguracaoPersona;
    }
}
