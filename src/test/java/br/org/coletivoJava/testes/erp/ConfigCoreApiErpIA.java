/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivoJava.fw.erp.implementacao.ia.controller.acoes.FabAcaoIAOlhamaPersona;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfiguradorCoreDeProjetoJarPersistenciaAbstrato;
import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;

/**
 * @author desenvolvedor
 */
public class ConfigCoreApiErpIA extends ConfiguradorCoreDeProjetoJarPersistenciaAbstrato {

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        pConfig.setClasseConfigPermissao(ConfigPermissaoIAOlhama.class);
        pConfig.setFabricaDeAcoes(new Class[]{FabAcaoIAOlhamaPersona.class});
    }

}
