package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas;

import org.coletivoJava.fw.projetos.erpColetivoJava.api.EtapasFluxoOllamaAssunto;
import cucumber.api.java.pt.Entao;
import java.lang.UnsupportedOperationException;

public class E_Entao_a_IA_deve_responder_que_nao_sabe_e_para_tentar_um_outro_assunto {

	@Entao(EtapasFluxoOllamaAssunto.ENTAO_A_IA_DEVE_RESPONDER_QUE_NAO_SABE_E_PARA_TENTAR_UM_OUTRO_ASSUNTO)
	public void implementacaoEtapa() {
//		String arquivoJsonDaConversa = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/1_1.json";
//
//		try (InputStream input = Files.newInputStream(Paths.get(arquivoJsonDaConversa));
//             JsonReader reader = Json.createReader(input)) {
//			JsonObject objetoJson = reader.readObject();
//			JsonArray mensagens = objetoJson.getJsonArray("messages");
//			String respostaIA = null;
//
//			for (int i = mensagens.size() - 1; i >= 0; i--) {
//				JsonObject mensagme = mensagens.getJsonObject(i);
//				String role = mensagme.getString("role", "");
//				if (role.equals("assistant")) {
//					respostaIA = mensagme.getString("content", "").trim();
//					break;
//				}
//			}
//			if (respostaIA == null || respostaIA.isEmpty()) {
//				throw new AssertionError("A resposta da IA está vazia ou não foi encontrada.");
//			}
//
//			String[] palavrasEsperadas = {
//					"criação de sites",
//					"marketing digital",
//					"desenvolvimento de sistemas",
//					"automação de e-mails",
//					"SEO",
//					"Google Ads",
//					"redes sociais"
//			};
//
//			String finalRespostaIA = respostaIA;
//			boolean temAlgumAssuntoReconhecido = Arrays.stream(palavrasEsperadas)
//					.anyMatch(assunto -> finalRespostaIA.toLowerCase().contains(assunto.toLowerCase()));
//
//			Assert.assertTrue("A IA nao mencionou as palavras de algum dos assuntos ", temAlgumAssuntoReconhecido);
//		} catch (IOException e) {
//			throw new RuntimeException("Erro lendo o arquivo Json: " + e.getMessage(), e);
//		}
	}
}