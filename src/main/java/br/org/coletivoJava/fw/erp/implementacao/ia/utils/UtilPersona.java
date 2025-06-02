package br.org.coletivoJava.fw.erp.implementacao.ia.utils;

import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.Persona;

public class UtilPersona {

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
}
