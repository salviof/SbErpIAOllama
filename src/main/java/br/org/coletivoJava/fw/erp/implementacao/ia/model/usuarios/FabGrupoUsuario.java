/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.FabAcaoIAOlhamaPersona;
import com.super_bits.modulos.SBAcessosModel.model.GrupoUsuarioSB;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

/**
 *
 * @author desenvolvedor
 */
public enum FabGrupoUsuario implements ItfFabrica {
    USUARIO_CLIENTE, USUARIO_ATENDIMENTO, USUARIO_ADMINISTRADOR;

    @Override
    public GrupoUsuarioSB getRegistro() {
        GrupoUsuarioSB novoGrupo = new GrupoUsuarioSB();
        switch (this) {
            case USUARIO_CLIENTE:
                novoGrupo.setId(1L);
                novoGrupo.setNome("Grupo Anonimo");
                novoGrupo.setAtivo(true);
                novoGrupo.setPaginaInicial(FabAcaoIAOlhamaPersona.PERSONA_IA_MB_GESTAO);
                break;
            case USUARIO_ATENDIMENTO:
                novoGrupo.setId(2L);
                novoGrupo.setNome("Grupo Atendimento");
                novoGrupo.setDescricao("Grupo com acesso ao menu Atendimento");
                novoGrupo.setAtivo(true);
                novoGrupo.setPaginaInicial(FabAcaoIAOlhamaPersona.PERSONA_IA_MB_GESTAO);
                break;
            case USUARIO_ADMINISTRADOR:
                novoGrupo.setId(3L);
                novoGrupo.setNome("Grupo Administrador");
                novoGrupo.setDescricao("Grupo com acesso ao menu Administrador");
                novoGrupo.setAtivo(true);
                novoGrupo.setPaginaInicial(FabAcaoIAOlhamaPersona.USUARIO_MB_GESTAO);
                break;
            default:
                throw new AssertionError(this.name());
        }
        return novoGrupo;
    }
}
