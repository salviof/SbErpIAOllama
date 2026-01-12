package br.org.coletivoJava.fw.erp.implementacao.ia.utils;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.AssuntosPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.FabAssuntosGenericos;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UtilConfiguracoesIA {

    public static String gerarPromptSystem(Persona pPersona) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("Você é o (a) ").append(pPersona.getNome()).append(". ");

        if (pPersona.getDescricao() != null) {
            prompt.append(pPersona.getDescricao()).append(" ");
        }
        if (pPersona.getObjetivo() != null) {
            prompt.append("Seu objetivo é: ").append(pPersona.getObjetivo()).append(". ");
        }
        if (pPersona.getTonalidade() != null) {
            prompt.append("Adote um tom ").append(pPersona.getTonalidade()).append(". ");
        }
        if (pPersona.getContexto() != null) {
            prompt.append("Contexto: ").append(pPersona.getContexto()).append(". ");
        }
        if (pPersona.getPublicoAlvo() != null) {
            prompt.append("Seu público-alvo são: ").append(pPersona.getPublicoAlvo()).append(". ");
        }
        if (pPersona.getIdioma() != null) {
            prompt.append("Interaja sempre em ").append(pPersona.getIdioma()).append(". ");
        }
        if (pPersona.getRegrasResposta() != null) {
            prompt.append("Regras: ").append(pPersona.getRegrasResposta()).append(". ");
        }
        if (pPersona.getInstrucoesAdicionais() != null) {
            prompt.append("Instruções adicionais: ").append(pPersona.getInstrucoesAdicionais()).append(". ");
        }
        if (pPersona.getTipoRespostasPadrao() != null) {
            prompt.append("Respostas padrão: ").append(pPersona.getTipoRespostasPadrao()).append(". ");
        }
        if (pPersona.getPalavrasProibidas() != null) {
            prompt.append("Evite as seguintes palavras: ").append(pPersona.getPalavrasProibidas()).append(". ");
        }
        if (pPersona.getLimitePalavras() > 0) {
            prompt.append("Limite sua resposta a ").append(pPersona.getLimitePalavras()).append(" palavras. ");
        }

        System.out.println("Prompt: " + prompt.toString().trim());
        return prompt.toString().trim();
    }

    public static String gerarPromptSystemComAssuntos(ComoUsuario pUsuario) {
        StringBuilder prompt = new StringBuilder();
        List<AssuntosPersona> assuntos = gerarAssuntosPadrao();
        prompt.append("Você é uma inteligência artificial treinada para responder sobre os seguintes assuntos relacionados ao nosso negócio:\n\n");
        prompt.append("E está conversando com o usuario *").append(pUsuario.getNome()).append("* seu email é ").append(pUsuario.getEmail()).append("e seu telefone é ").append(pUsuario.getTelefone()).append(" \n\n");
        for (AssuntosPersona assunto : assuntos) {
            prompt.append("Assunto: ").append(assunto.getAssunto()).append("\n");
            prompt.append("Descrição: ").append(assunto.getDescricao()).append("\n");
        }

        prompt.append("Seja preciso e educado. Se nao souber ou o assunto nao for igual a estes, responda: *Não fui configurado para esse tipo de assunto*");
        return prompt.toString();
    }

    private static List<AssuntosPersona> gerarAssuntosPadrao() {
        List<AssuntosPersona> assuntos = new ArrayList<>();
        AssuntosPersona assuntoProdutos = (AssuntosPersona) FabAssuntosGenericos.ASSUNTO_PRODUTO.getRegistro();
        AssuntosPersona assuntoSuporte = (AssuntosPersona) FabAssuntosGenericos.ASSUNTO_SUPORTE.getRegistro();
        AssuntosPersona assuntoAgendamento = (AssuntosPersona) FabAssuntosGenericos.ASSUNTO_AGENDAMENTO.getRegistro();

        assuntos.add(assuntoProdutos);

        return assuntos;
    }


}
