package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona.ValoresLogicosPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = Persona.class)
public @interface ValorLogicoPersona {

	ValoresLogicosPersona calculo();
}