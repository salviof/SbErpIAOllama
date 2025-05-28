/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coletivoJava.fw.projetos.Intranet_Marketing_Digital.implementacao.cucumber.iaollama;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ERPIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.IAOlhamaimpl;
import br.org.coletivoJava.testes.erp.ConfigCoreApiErpIA;
import br.org.coletivoJava.testes.erp.ConfigPercistenciaIa;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigPersistenciaPadrao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 *
 * @author salvio
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@FluxoOllama",
        glue = "org.coletivoJava.fw.projetos.sberpiaollama.implementacao.cucumber.fluxoollama.etapas",
        monochrome = false, dryRun = false
)
public class FluxoIAOllama extends TesteIntegracaoFuncionalidadeCucumber {

    public static IAOlhamaimpl OLHAMA = (IAOlhamaimpl) ERPIA.OLHAMA.getImplementacaoDoContexto();

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiErpIA(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPercistenciaIa());
    }

}
