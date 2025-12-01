/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes;

import com.super_bits.modulos.SBAcessosModel.controller.FabMenuAdmin;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCGeradorDeID;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ComoFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;

/**
 *
 *
 * ARQUIVO DE EXEMPLO, PARA INICIO DE APLICAÇÃO.
 *
 * REFATORE ESTA CLASSE COM OS MODULOS DO SEU SISTEMA
 *
 *
 * @author Salvio Furbino
 */
public enum FabModulosIA implements ComoFabricaModulo {

    ERP_IA;

    @Override
    public ItfModuloAcaoSistema getModulo() {
        ModuloIA modulo = new ModuloIA();
        modulo.setId((long) this.ordinal() + 1);
        modulo.setEnumVinculado(this);
        switch (this) {
            case ERP_IA:
                modulo.setNome("Módulo IA");
                modulo.setDescricao("Módulo interação com IA");
                break;

            default:
                throw new AssertionError(this.name());

        }
        modulo.setId(UtilCRCGeradorDeID.gerarIdUnicoObejtoVinculadoAFabrica(modulo));
        return modulo;
    }

    @Override
    public ModuloIA getRegistro() {
        return (ModuloIA) getModulo();
    }

    @Override
    public ComoFabricaMenu getMenuPadrao() {

        return FabMenuAdmin.ROOT;
    }
}
