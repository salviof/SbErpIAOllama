package br.org.coletivoJava.fw.erp.implementacao.ia.model.persona;

import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;

public enum FabAssuntosGenericos implements ComoFabrica {
    ASSUNTO_PRODUTO,
    ASSUNTO_SUPORTE,
    ASSUNTO_AGENDAMENTO;

    @Override
    public Object getRegistro() {
        AssuntosPersona assunto = new AssuntosPersona();

        switch (this) {
            case ASSUNTO_PRODUTO:
                assunto.setId(1L);
                assunto.setAssunto("Produtos e serviços oferecidos");
                assunto.setDescricao(
                        "Oferecemos serviços especializados nas seguintes áreas:\n"
                                + "- Criação de sites profissionais e personalizados\n"
                                + "- Gestão de marketing digital (Google Ads, redes sociais, SEO)\n"
                                + "- Desenvolvimento de sistemas sob demanda\n"
                                + "- Gerenciamento e automação de e-mails corporativos\n"
                                + "Sua função é responder dúvidas, apresentar os serviços e ajudar o cliente a entender como podemos atendê-lo com essas soluções."
                );
                break;
            case ASSUNTO_SUPORTE:
                assunto.setId(2L);
                assunto.setAssunto("Suporte e atendimento ao cliente");
                assunto.setDescricao(
                        "Atue como um assistente de suporte ao cliente.\n"
                                + "Ajude a esclarecer dúvidas, orientar sobre o uso dos nossos produtos e serviços, resolver problemas básicos e direcionar para atendimento humano quando necessário.\n"
                                + "Lembre - se de ser educado, claro e prestativo.Não invente informações — se não souber a resposta, diga que a equipe especializada irá entrar em contato.");
                break;
            case ASSUNTO_AGENDAMENTO:
                assunto.setId(3L);
                assunto.setAssunto("Agendamento de reuniões e contatos");
                assunto.setDescricao(
                        "Ajude o cliente a agendar um horário para uma reunião ou contato com nossa equipe.\n" +
                                "Informe sobre os horários disponíveis, colete informações necessárias (nome, e-mail, telefone), e diga que a equipe confirmará o agendamento.\n" +
                                "\n" +
                                "Se o cliente tiver dúvidas sobre o processo de agendamento, explique de forma simples e objetiva.");
                break;
        }

        return assunto;
    }
}
