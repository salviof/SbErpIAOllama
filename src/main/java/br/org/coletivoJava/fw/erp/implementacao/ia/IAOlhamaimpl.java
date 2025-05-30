package br.org.coletivoJava.fw.erp.implementacao.ia;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfErpIA;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.ia.IAOlhama;

@IAOlhama
public class IAOlhamaimpl extends RepositorioLinkEntidadesGenerico implements ItfErpIA  {


    @Override
    public boolean personaCriarAtualizar(ItfPersona itfPersona) {
        return false;
    }

    @Override
    public String obterResposta(ItfPersona itfPersona, ItfUsuario itfUsuario, String s) {
        return "";
    }

    @Override
    public String obterResposta(
            ItfUsuario itfUsuario,
            String s) {
        return null;
    }

    @Override
    public String obterRespostaUsuarioLogado(String s) {
        return "";
    }

    @Override
    public String obterRespostaUsuarioLogado(ItfPersona itfPersona, String s) {
        return "";
    }

}
