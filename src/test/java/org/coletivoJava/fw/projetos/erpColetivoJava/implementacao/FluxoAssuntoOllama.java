package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ERPIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.IAOlhamaImpl;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import br.org.coletivoJava.testes.erp.ConfigCoreApiErpIA;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaIa;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@FluxoOllamaAssunto",
        glue = "org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.fluxoollamaassunto.etapas",
        monochrome = false, dryRun = false
)
public class FluxoAssuntoOllama extends TesteIntegracaoFuncionalidadeCucumber {
    public static ComoUsuario USUARIO_AUTENTICADO;
    public static IAOlhamaImpl OLLAMA = (IAOlhamaImpl) ERPIA.OLHAMA.getImplementacaoDoContexto();
    public static Persona PERSONA_IA = new Persona();
    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiErpIA(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        gerarCodigoModelProjeto();
        SBPersistencia.configuraJPA(new ConfigPersistenciaIa());
    }
}
