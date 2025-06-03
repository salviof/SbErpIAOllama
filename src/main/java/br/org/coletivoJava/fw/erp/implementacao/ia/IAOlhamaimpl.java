package br.org.coletivoJava.fw.erp.implementacao.ia;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfErpIA;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.ia.IAOlhama;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import jakarta.json.JsonObject;


@IAOlhama
public class IAOlhamaimpl extends RepositorioLinkEntidadesGenerico implements ItfErpIA {

    @Override
    public String personaCriarAtualizar(String pNomePersona, String pPromptSystem) {
        return FabApiRestOllamaAgenteModel.MODELO_CRIAR.getAcao(pNomePersona, pPromptSystem).getResposta().getRespostaTexto();
    }

    @Override
    public String obterResposta(String pNomePersona, String pMensagem) {
        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaChat.CONVERSA_OBTER_RESPOSTA_IA.getAcao(pNomePersona, pMensagem).getResposta();
        if (!resposta.isSucesso()) {
            return null;
        }
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        return respJson.getString("response");
    }

    @Override
    public String obterResposta(String pNomePersona, String pChaveConversa, String pMensagem, String pPromptSystem) {
        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaChat.CONVERSA_SESSAO.getAcao(pNomePersona, pChaveConversa, pMensagem, pPromptSystem).getResposta();
        if (!resposta.isSucesso()) {
            return null;
        }
        JsonObject respostaJson = resposta.getRespostaComoObjetoJson();
        if (respostaJson != null) {
            UtilOllamaConversas.adicionarMensagem(pChaveConversa, "assistant", respostaJson.toString(), null, null);
        }
        return respostaJson.getString("response");
    }

    @Override
    public String obterRespostaUsuarioLogado(String s) {
        return "";
    }

    @Override
    public String obterRespostaUsuarioLogado(ItfPersona itfPersona, String s) {
        return "";
    }

}
