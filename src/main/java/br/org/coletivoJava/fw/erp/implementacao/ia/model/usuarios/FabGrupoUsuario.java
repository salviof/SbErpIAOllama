/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios;

import com.super_bits.modulos.SBAcessosModel.model.GrupoUsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;

/**
 *
 * @author desenvolvedor
 */
public enum FabGrupoUsuario implements ItfFabrica {
    USUARIO_ATENDIMENTO;

    @Override
    public GrupoUsuarioSB getRegistro() {
        GrupoUsuarioSB novoGrupo = new GrupoUsuarioSB();
        switch (this) {
            case USUARIO_ATENDIMENTO:
                novoGrupo.setId(2L);
                novoGrupo.setNome("Grupo Atendimento");
                novoGrupo.setDescricao("Grupo com acesso ao menu Administrador");
                novoGrupo.setAtivo(true);
                break;

            default:
                throw new AssertionError(this.name());

        }
        return novoGrupo;
    }
}
