/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;

/**
 *
 * @author salvio
 */
@InfoModulosIaOlhama(modulo = FabModulosIA.ERP_IA)
public enum FabAcaoIAOlhamaPersona implements ItfFabricaDeAcoesPersistencia {
    @InfoTipoAcaoGestaoEntidade(entidade = UsuarioSB.class, nomeAcao = "Gerenciar usuários")
    USUARIO_MB_GESTAO,
    @InfoTipoAcaoFormulario()
    USUARIO_FRM_LISTAR,
    @InfoTipoAcaoFormulario()
    USUARIO_FRM_NOVO,
    @InfoTipoAcaoFormulario()
    USUARIO_FRM_EDITAR,
    USUARIO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(comunicacao = FabTipoComunicacao.PERGUNTAR_SIM_OU_NAO, fraseComunicação = "A exclusão, será permanente, tem certeza que deseja EXCLUIR o [nome]")
    USUARIO_CTR_EXCLUIR,
    @InfoTipoAcaoController()
    USUARIO_CTR_ALTERAR_STATUS,

    @InfoTipoAcaoGestaoEntidade(entidade = Persona.class, nomeAcao = "Gerenciar Personas")
    PERSONA_IA_MB_GESTAO,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_LISTAR,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_NOVO,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_EDITAR,
    PERSONA_IA_CTR_OBTER_RESPOSTA,
    PERSONA_IA_CTR_CHAT_SESSAO_CONVERSA,
    PERSONA_IA_CTR_SALVAR_MERGE;
}
