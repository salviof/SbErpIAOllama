/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulos.SBAcessosModel.ConfigPermissoesAcessoModelAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.token.ItfTokenAcessoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabricaAcoes;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimplesSomenteLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfGrupoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ItfMenusDeSessao;

import org.coletivojava.fw.api.objetoNativo.view.menu.MenuSBFW;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenusDaSessao;

/**
 *
 * @author desenvolvedor
 */
public class ConfigPermissaoIAOlhama extends ConfigPermissoesAcessoModelAbstrato {

    public ConfigPermissaoIAOlhama() {
        super(new Class[]{ControllerIAPersonas.class});

    }

    public ConfigPermissaoIAOlhama(Class[] pClassesControllers) {
        super(pClassesControllers);
    }

    @Override
    protected boolean persistirPermissoesNoBanco() {
        return true;
    }

    @Override
    public ItfMenusDeSessao definirMenu(ItfGrupoUsuario pGrupo) {

        return new MenusDaSessao(new MenuSBFW());

    }

    @Override
    public boolean isObjetoPermitidoUsuario(ItfUsuario pUsuario, ItfBeanSimplesSomenteLeitura pObjeto) {

        return true;
    }

    @Override
    public ItfTokenAcessoDinamico gerarTokenDinamico(ItfFabricaAcoes pAcao, ItfBeanSimplesSomenteLeitura pItem, String pEmail) {
        return super.gerarTokenDinamico(pAcao, pItem, pEmail); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
