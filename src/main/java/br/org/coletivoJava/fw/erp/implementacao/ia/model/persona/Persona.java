package br.org.coletivoJava.fw.erp.implementacao.ia.model.persona;

import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@InfoObjetoSB(plural = "Personas", tags = "Persona", icone = "fa fa-users")
public class Persona extends EntidadeSimples implements ItfPersona {
    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO, descricao = "Curta descrição que define a persona de forma clara.", label = "Descrição")
    private String descricao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Define o tom de voz da persona (ex.: amigável, profissional, formal, casual).", label = "Tonalidade da resposta")
    private String tonalidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Define o objetivo da persona (ex.: resolver problemas, ajudar outras pessoas, etc.).", label = "Objetivo da resposta")
    private String objetivo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Regras para dizer quais as regras que a IA deve seguir", label = "Regras de Resposta")
    private String regrasResposta;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE, descricao = "Define o limite de palavras que a resposta pode ter.", label = "Limite de palavras")
    private int limitePalavras;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Contexto da interação, como área de atuação da persona ou detalhes relevantes.", label = "Contexto")
    private String contexto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Instruções especiais para guiar a IA em cenários específicos.", label = "Instruções Adicionais")
    private String instrucoesAdicionais;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Define o publico alvo quem a persona está se dirigindo (ex: possiveis clientes, criancas, idosos, adultos). Isso pode influenciar a linguagem e a complexidade da resposta. ")
    private String publicoAlvo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Idioma padrão em que a persona interagirá.", label = "Idioma Padrão")
    // TODO: depois conferir se vai ser enum
    private String idioma;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Tipos de respostas padrões que a IA irá fornecer de acordo com certas perguntas", label = "Tipos de resposta padrao")
    private String tipoRespostasPadrao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, descricao = "Palavras bloqueadas ou proibidas", label = "Palavras proibidas")
    private String palavrasProibidas;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO, descricao = "Definicao se a Persona está ativa ou inativa", label = "Status Persona")
    private boolean status;

    @Column(length = 10000)
    @InfoCampoValorLogico(nomeCalculo = "Texto modelfile ")
    private String textoModelFileIA;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTonalidade() {
        return tonalidade;
    }

    public void setTonalidade(String tonalidade) {
        this.tonalidade = tonalidade;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getRegrasResposta() {
        return regrasResposta;
    }

    public void setRegrasResposta(String regrasResposta) {
        this.regrasResposta = regrasResposta;
    }

    public int getLimitePalavras() {
        return limitePalavras;
    }

    public void setLimitePalavras(int limitePalavras) {
        this.limitePalavras = limitePalavras;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public String getInstrucoesAdicionais() {
        return instrucoesAdicionais;
    }

    public void setInstrucoesAdicionais(String instrucoesAdicionais) {
        this.instrucoesAdicionais = instrucoesAdicionais;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipoRespostasPadrao() {
        return tipoRespostasPadrao;
    }

    public void setTipoRespostasPadrao(String tipoRespostasPadrao) {
        this.tipoRespostasPadrao = tipoRespostasPadrao;
    }

    public String getPalavrasProibidas() {
        return palavrasProibidas;
    }

    public void setPalavrasProibidas(String palavrasProibidas) {
        this.palavrasProibidas = palavrasProibidas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTextoModelFileIA() {
        return textoModelFileIA;
    }

    public void setTextoModelFileIA(String textoModelFileIA) {
        this.textoModelFileIA = textoModelFileIA;
    }
}
