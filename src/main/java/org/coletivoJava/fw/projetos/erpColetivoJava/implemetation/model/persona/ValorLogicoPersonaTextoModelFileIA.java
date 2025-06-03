package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.persona;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona.ValorLogicoPersona;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona.ValoresLogicosPersona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoPersona(calculo = ValoresLogicosPersona.TEXTOMODELFILEIA)
public class ValorLogicoPersonaTextoModelFileIA extends ValorLogicoCalculoGenerico {

	public ValorLogicoPersonaTextoModelFileIA(ItfCampoInstanciado pCampo) {
		super(pCampo);

	}

	@Override
	public Object getValor(Object... pEntidade) {
		//TODO: FAZER O VALOR
		return getPersona().getDescricao();
	}
	public Persona getPersona() {
		return (Persona) getCampoInst().getObjetoRaizDoAtributo();
	}
}