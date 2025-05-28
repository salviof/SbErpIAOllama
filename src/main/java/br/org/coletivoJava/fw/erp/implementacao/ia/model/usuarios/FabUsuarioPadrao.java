package br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;


public enum FabUsuarioPadrao implements ItfFabrica {
    @InfoObjetoDaFabrica(id = 1L, nomeObjeto = "usuario_atendimento")
    USUARIO_ATENDIMENTO;

    @Override
    public Object getRegistro() {
        UsuarioSB usuario = new UsuarioSB();
        switch (this) {
            case USUARIO_ATENDIMENTO:
                usuario.setApelido("atendente");
                usuario.setNome("atendente");
                usuario.setEmail("atendimento@casanovadigital.com.br");
                usuario.setSenha("123");
                usuario.setGrupo(FabGrupoUsuario.USUARIO_ATENDIMENTO.getRegistro());
                break;

            default:
                throw new AssertionError(this.name());
        }
        return usuario;
    }
}
