/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.usuarios.FabUsuarioPadrao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ItfConfigSBPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;

/**
 *
 * @author Salvio
 */
public class ConfigPercistenciaIa implements ItfConfigSBPersistencia {

    @Override
    public String bancoPrincipal() {
        return "SbErpIAModel";
    }

    @Override
    public String[] bancosExtra() {
        return new String[0];
    }

    @Override
    public String formatoDataBanco() {
        return UtilSBCoreDataHora.datahoraSistemaFr.toString();
    }

    @Override
    public String formatoDataUsuario() {
        return UtilSBCoreDataHora.horaUsuarioFr.toString();
    }

    @Override
    public String pastaImagensJPA() {
        return "/img";
    }

    @Override
    public void criarBancoInicial() {

    }

    @Override
    public Class<? extends ItfFabrica>[] fabricasRegistrosIniciais() {
        return new Class[]{
                FabUsuarioPadrao.class
        };
    }

}
