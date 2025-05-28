/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModulosIaOlhama(modulo = FabModulosIA.ERP_IA)
public enum FabAcaoIAOlhamaPersona implements ItfFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = Persona.class, nomeAcao = "Gerenciar Personas")
    PERSONA_IA_MB_GESTAO,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_LISTAR,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_NOVO,
    @InfoTipoAcaoFormulario() //TODO: Adicionar campos
    PERSONA_IA_FRM_EDITAR,
    PERSONA_IA_CTR_SALVAR_MERGE;
}
