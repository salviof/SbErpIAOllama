package br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;


public enum FabUsuarioPadrao implements ItfFabrica {
    @InfoObjetoDaFabrica(id = 1L, nomeObjeto = "Usuario_atendimento")
    USUARIO_ATENDIMENTO,
    @InfoObjetoDaFabrica(id = 2L,nomeObjeto = "Usuario_admin")
    USUARIO_ADMINISTRADOR;

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
            case USUARIO_ADMINISTRADOR:
                usuario.setApelido("admin");
                usuario.setNome("admin");
                usuario.setEmail("admin@teste.com");
                usuario.setSenha("123456");
                usuario.setGrupo(FabGrupoUsuario.USUARIO_ADMINISTRADOR.getRegistro());
                break;
            default:
                throw new AssertionError(this.name());
        }
        return usuario;
    }
}
