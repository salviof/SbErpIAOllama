/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ERPIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.FabAcaoIAOlhamaPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.InfoAcaoIAPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

/**
 * @author salvio
 */
public class ControllerIAPersonas extends ControllerAbstratoSBPersistencia {

    @InfoAcaoIAPersona(acao = FabAcaoIAOlhamaPersona.PERSONA_IA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema personaSalvar(Persona pPersona) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPersona), pPersona) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                // ERPIA.OLHAMA.getImplementacaoDoContexto().personaCriarAtualizar(pPersona.getNome(), UtilPersona.gerarPromptSystem(pPersona));
                setRetorno(atualizarEntidade(pPersona, true));
            }
        }.getResposta();

    }

    @InfoAcaoIAPersona(acao = FabAcaoIAOlhamaPersona.PERSONA_IA_CTR_CHAT_SESSAO_CONVERSA)
    public static ItfRespostaAcaoDoSistema conversaChatComHistorico(Persona pPersona, String pMensagem, ComoUsuario pUsuario, String pPromptSystem) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPersona), pPersona) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                String chaveConversa = pPersona.getNome() + "_" + pUsuario.getNome();

                UtilOllamaConversas.adicionarMensagem(chaveConversa, "user", pMensagem, pPromptSystem, pPersona.getNome() + ":latest");

                JsonObject conversaAtualizada = UtilOllamaConversas.lerConversa(chaveConversa, pPromptSystem, pPersona.getNome() + ":latest");
                JsonArray mensagens = conversaAtualizada.getJsonArray("messages");
                JsonArrayBuilder builder = Json.createArrayBuilder();
                mensagens.forEach(builder::add);

                JsonObject req = Json.createObjectBuilder()
                        .add("model", pPersona.getNome() + ":latest")
                        .add("messages", builder.build())
                        .add("stream", false)
                        .add("keep_alive", "10m")
                        .build();
                String ultimaMensagem = mensagens.getJsonObject(mensagens.size() - 1).getString("content");

                String respostaIA = ERPIA.OLHAMA.getImplementacaoDoContexto().obterResposta(pPersona, pUsuario, pPromptSystem);
                System.out.println("Resposta IA: " + respostaIA);
            }
        }.getResposta();
    }

//    @InfoAcaoIAPersona(acao = FabAcaoIAOlhamaPersona.PERSONA_IA_CTR_OBTER_RESPOSTA_SEM_HISTORICO)
//    public static ItfRespostaAcaoDoSistema conversaChatSemHistorico(Persona pPersona, String pMensagem, ComoUsuario pUsuario,String pPromptSystem) {
//        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPersona), pPersona) {
//            @Override
//            public void regraDeNegocio() throws ErroRegraDeNegocio {
//                String chaveConversa = pPersona.getNome() + "_" + pUsuario.getNome();
//                String respostaIA = ERPIA.OLHAMA.getImplementacaoDoContexto().obterRespostaSemHistorico(pPersona.getNome() + ":latest", chaveConversa, pMensagem, pPromptSystem);
//                System.out.println("Resposta IA: " + respostaIA);
//            }
//        }.getResposta();
//    }


}
