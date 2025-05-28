/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes;

import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModulosIaOlhama(modulo = FabModulosIA.ERP_IA)
public enum FabAcaoIAOlhamaPersona implements ItfFabricaDeAcoesPersistencia {

    //@InfoTipoAcaoGestaoEntidade(entidade = )
    PERSONA_IA_MB_GESTAO,
    PERSONA_IA_FRM_LISTAR,
    PERSONA_IA_FRM_NOVO,
    PERSONA_IA_FRM_EDITAR,
    PERSONA_IA_CTR_SALVAR_MERGE;
}
