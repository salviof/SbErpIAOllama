package br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.dto.ItfDTOSBJSON;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import br.org.coletivoJava.fw.erp.implementacao.ia.json_bind_olhama.Persona.JsonBindDTOPersona;
import java.lang.String;
import java.lang.Long;

@JsonDeserialize(using = JsonBindDTOPersona.class)
public interface ItfDTOPersona extends ItfDTOSBJSON, ItfPersona {

	@Override
	public default String getDescricao() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getTipoPersona() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getTonalidade() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getObjetivo() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getRegrasResposta() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default int getLimitePalavras() {
		return (int) getValorPorReflexao();
	}

	@Override
	public default String getContexto() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getInstrucoesAdicionais() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getPublicoAlvo() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getIdioma() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getTipoRespostasPadrao() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getPalavrasProibidas() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default boolean isStatus() {
		return (boolean) getValorPorReflexao();
	}

	@Override
	public default String getTextoModelFileIA() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default boolean isTemImagemPequenaAdicionada() {
		return (boolean) getValorPorReflexao();
	}

	@Override
	public default String getSlugIdentificador() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getNomeUnicoSlug() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getNome() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getNomeCurto() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default String getIconeDaClasse() {
		return (String) getValorPorReflexao();
	}

	@Override
	public default Long getId() {
		return (Long) getValorPorReflexao();
	}
}