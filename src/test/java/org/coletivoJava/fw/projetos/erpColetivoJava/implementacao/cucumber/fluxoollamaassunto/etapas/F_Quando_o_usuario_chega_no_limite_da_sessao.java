package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.UnsupportedOperationException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class F_Quando_o_usuario_chega_no_limite_da_sessao {

	@Quando(EtapasFluxoOllamaAssunto.QUANDO_O_USUARIO_CHEGA_NO_LIMITE_DA_SESSAO)
	public void implementacaoEtapa() {
		String arquivoJsonDaConversa = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/1_1.json";
		try (InputStream input = Files.newInputStream(Paths.get(arquivoJsonDaConversa));
             JsonReader reader = Json.createReader(input)) {
			JsonObject objetoJson = reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}