package br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.dto.DTO_SB_JSON_PROCESSADOR_GENERICO;
import br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona.DTOPersona;

import java.io.IOException;

public class JsonBindDTOPersona
		extends
			DTO_SB_JSON_PROCESSADOR_GENERICO<DTOPersona> {

	public JsonBindDTOPersona() {
		super(DTOPersona.class);
	}

	@Override
	public DTOPersona deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		return null;
	}
}