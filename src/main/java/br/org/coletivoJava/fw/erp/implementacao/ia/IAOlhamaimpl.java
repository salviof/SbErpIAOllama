package br.org.coletivoJava.fw.erp.implementacao.ia;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfErpIA;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.ia.IAOlhama;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;


@IAOlhama
public class IAOlhamaimpl extends RepositorioLinkEntidadesGenerico implements ItfErpIA {

    @Override
    public String personaCriarAtualizar(String pNomePersona, String pPromptSystem) {
        return FabApiRestOllamaAgenteModel.MODELO_CRIAR.getAcao(pNomePersona, pPromptSystem).getResposta().getRespostaTexto();
    }

    @Override
    public String obterResposta(String pNomePersona, String pMensagem) {
        return FabApiRestOllamaChat.CONVERSA_OBTER_RESPOSTA_IA.getAcao(pNomePersona, pMensagem).getResposta().getRespostaTexto();
    }

    @Override
    public String obterResposta(
            ItfUsuario itfUsuario,
            String s) {
        return null;
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
