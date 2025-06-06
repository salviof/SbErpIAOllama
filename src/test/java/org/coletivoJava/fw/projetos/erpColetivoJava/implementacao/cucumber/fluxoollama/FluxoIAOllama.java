/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ERPIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.IAOlhamaimpl;
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

/**
 *
 * @author salvio
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@FluxoOllama",
        glue = "org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollama.etapas",
        monochrome = false, dryRun = false
)
public class FluxoIAOllama extends TesteIntegracaoFuncionalidadeCucumber {

//    public static IAOlhamaimpl OLHAMA = (IAOlhamaimpl) ERPIA.OLHAMA.getImplementacaoDoContexto();

    public static Persona PERSONA1_ADOLESCENTE = new Persona();
    public static Persona PERSONA2_IDOSO = new Persona();
    public static ItfUsuario USUARIO_AUTENTICADO;

    // 1-> CRIAR UMA FABRICA DE DAODOS INICIAIS COM UM USUARIO atendimento@casanovadigital.com.br Ok
    // 2-> adicionar a fabrica no ConfigPercistenciaIa Ok
    // 3-> mover o objeto persona para este projeto. incluindo a entidade no perscistence.xml Ok
    // 4-> implementar o InfocampoValorLogico, que vai gerar o pronto da persona para a IA.
    // 5-> implementar os métodos que criam a persona,salvando a persona com o método ControllerIAPersonas.personaSalvar()
    // o persona salvar deve salvar no banco e atualizar o model na ia, se der erro ao salvar na IA,não deve permitir salvar a persona
    // seguir o fluxo dos testes
    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiErpIA(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        gerarCodigoModelProjeto();
        SBPersistencia.configuraJPA(new ConfigPersistenciaIa());
    }

}
