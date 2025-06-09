package br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona;

import br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona.ItfDTOPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona.JsonBindDTOPersona;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.dto.DTO_SBGENERICO;

public class DTOPersona extends DTO_SBGENERICO<ItfDTOPersona>
		implements
			ItfDTOPersona {

	public DTOPersona(String pJson) {
		super(JsonBindDTOPersona.class, pJson);
	}

	public DTOPersona() {
		super(null, null);
	}

	@Override
	public void setDescricao(String s) {

	}

	@Override
	public void setTonalidade(String s) {

	}

	@Override
	public void setObjetivo(String s) {

	}

	@Override
	public void setRegrasResposta(String s) {

	}

	@Override
	public void setLimitePalavras(int i) {

	}

	@Override
	public void setContexto(String s) {

	}

	@Override
	public void setInstrucoesAdicionais(String s) {

	}

	@Override
	public void setTipoPersona(String s) {

	}

	@Override
	public void setPublicoAlvo(String s) {

	}

	@Override
	public void setIdioma(String s) {

	}

	@Override
	public void setTipoRespostasPadrao(String s) {

	}

	@Override
	public void setPalavrasProibidas(String s) {

	}

	@Override
	public void setStatus(boolean b) {

	}

	@Override
	public void setTextoModelFileIA(String s) {

	}
}