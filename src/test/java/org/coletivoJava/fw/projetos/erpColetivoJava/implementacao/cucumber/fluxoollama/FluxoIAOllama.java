/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import br.org.coletivoJava.testes.erp.ConfigCoreApiErpIA;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaIa;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;


@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@FluxoOllama",
        glue = "org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas",
        monochrome = false, dryRun = false
)
public class FluxoIAOllama extends TesteIntegracaoFuncionalidadeCucumber {

    public static Persona PERSONA1_ADOLESCENTE = new Persona();
    public static Persona PERSONA2_IDOSO = new Persona();
    public static ItfUsuario USUARIO_AUTENTICADO;

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiErpIA(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        gerarCodigoModelProjeto();
        SBPersistencia.configuraJPA(new ConfigPersistenciaIa());
    }

}
