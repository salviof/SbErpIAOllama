/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes;

import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ItfFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author desenvolvedor
 */
@Entity
@InfoObjetoSB(tags = {"Modulo Casa Nova Digital"}, fabricaVinculada = FabModulosIA.class, plural = "Modulos Casa Nova Digital")
public class ModuloIA extends ModuloAcaoSistema {

    @Enumerated(EnumType.ORDINAL)
    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA)
    private FabModulosIA moduloFabIA;

    @Override
    public FabModulosIA getFabricaObjeto() {
        return moduloFabIA;
    }

    @Override
    public ItfFabricaModulo getEnumVinculado() {
        return moduloFabIA;
    }

    @Override
    public void setEnumVinculado(ItfFabrica pFabrica) {
        super.setEnumVinculado(pFabrica); //To change body of generated methods, choose Tools | Templates.
    }

}
