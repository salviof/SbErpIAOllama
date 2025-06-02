package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.persona;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = Persona.class)
public enum CPPersona {
	_ID, _NOME, _DESCRICAO, _TONALIDADE, _OBJETIVO, _REGRASRESPOSTA, _LIMITEPALAVRAS, _CONTEXTO, _INSTRUCOESADICIONAIS, _PUBLICOALVO, _IDIOMA, _TIPORESPOSTASPADRAO, _PALAVRASPROIBIDAS, _STATUS, _TEXTOMODELFILEIA;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String descricao = "descricao";
	public static final String tonalidade = "tonalidade";
	public static final String objetivo = "objetivo";
	public static final String regrasresposta = "regrasResposta";
	public static final String limitepalavras = "limitePalavras";
	public static final String contexto = "contexto";
	public static final String instrucoesadicionais = "instrucoesAdicionais";
	public static final String publicoalvo = "publicoAlvo";
	public static final String idioma = "idioma";
	public static final String tiporespostaspadrao = "tipoRespostasPadrao";
	public static final String palavrasproibidas = "palavrasProibidas";
	public static final String status = "status";
	public static final String textomodelfileia = "textoModelFileIA";
}