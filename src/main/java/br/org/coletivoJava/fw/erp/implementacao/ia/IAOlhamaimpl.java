package br.org.coletivoJava.fw.erp.implementacao.ia;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfErpIA;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.ia.IAOlhama;

@IAOlhama
public class IAOlhamaimpl extends RepositorioLinkEntidadesGenerico
        implements
        ItfErpIA {

    @Override
    public String obterResposta(ItfPersona itfPersona, ItfUsuario itfUsuario,
            String s) {
        return null;
    }

    @Override
    public String obterResposta(
            ItfUsuario itfUsuario,
            String s) {
        return null;
    }

    @Override
    public String obterRespostaUsuarioLogado(
            ItfPersona itfPersona,
            String s) {
        return null;
    }

    @Override
    public String obterRespostaUsuarioLogado(String s) {
        return null;
    }

    @Override
    public boolean personaCriarAtualizar(ItfPersona pPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
