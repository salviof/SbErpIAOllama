/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ERPIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.FabAcaoIAOlhamaPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.InfoAcaoIAPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import br.org.coletivoJava.fw.erp.implementacao.ia.utils.UtilPersona;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;

/**
 * @author salvio
 */
public class ControllerIAPersonas extends ControllerAbstratoSBPersistencia {

    @InfoAcaoIAPersona(acao = FabAcaoIAOlhamaPersona.PERSONA_IA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema personaSalvar(Persona pPersona) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPersona), pPersona) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                ERPIA.OLHAMA.getImplementacaoDoContexto().personaCriarAtualizar(pPersona.getNome(), UtilPersona.gerarPromptSystem(pPersona));
            }
        }.getResposta();

    }

    @InfoAcaoIAPersona(acao = FabAcaoIAOlhamaPersona.PERSONA_IA_CTR_OBTER_RESPOSTA)
    public static ItfRespostaAcaoDoSistema novaConversa(Persona pPersona, String pMensagem){
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPersona), pPersona) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                ERPIA.OLHAMA.getImplementacaoDoContexto().obterResposta(pPersona.getNome(), pMensagem);
            }
        }.getResposta();
    }

}
