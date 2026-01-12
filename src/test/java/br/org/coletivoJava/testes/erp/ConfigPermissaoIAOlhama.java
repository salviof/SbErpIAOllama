/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.ControllerIAPersonas;
import com.super_bits.modulos.SBAcessosModel.ConfigPermissoesAcessoModelAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ErroDadosDeContatoUsuarioNaoEncontrado;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.token.ItfTokenAcessoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimplesSomenteLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoGrupoUsuario;

import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.contato.ComoContatoHumano;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenusDeSessao;

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
    public ComoMenusDeSessao definirMenu(ComoGrupoUsuario pGrupo) {

        return new MenusDaSessao(new MenuSBFW());

    }

    @Override
    public boolean isObjetoPermitidoUsuario(ComoUsuario pUsuario, ComoEntidadeSimplesSomenteLeitura pObjeto) {

        return true;
    }

    @Override
    public ItfTokenAcessoDinamico gerarTokenDinamico(ComoFabricaAcoes pAcao, ComoEntidadeSimplesSomenteLeitura pItem, String pEmail) {
        return super.gerarTokenDinamico(pAcao, pItem, pEmail); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
