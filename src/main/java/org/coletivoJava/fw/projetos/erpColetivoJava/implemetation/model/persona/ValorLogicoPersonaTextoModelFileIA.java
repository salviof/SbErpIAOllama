package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.persona;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona.ValorLogicoPersona;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona.ValoresLogicosPersona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoPersona(calculo = ValoresLogicosPersona.TEXTOMODELFILEIA)
public class ValorLogicoPersonaTextoModelFileIA
		extends
			ValorLogicoCalculoGenerico {

	ValorLogicoPersonaTextoModelFileIA(ItfCampoInstanciado pCampo) {
		super(pCampo);
	}
}