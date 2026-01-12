package br.org.coletivoJava.fw.erp.implementacao.ia;

import br.org.coletivoJava.fw.api.erp.ia.IAOlhama;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfErpIA;
import br.org.coletivoJava.fw.api.erp.ia.escopo.ItfPersona;
import br.org.coletivoJava.fw.erp.implementacao.excecoes.ErroOllamaERP;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.AssuntosPersona;
import br.org.coletivoJava.fw.erp.implementacao.ia.model.persona.FabAssuntosGenericos;
import br.org.coletivoJava.fw.erp.implementacao.ia.utils.UtilConfiguracoesIA;
import br.org.coletivoJava.fw.erp.implementacao.ia.utils.UtilHistoricoConversa;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabConfigOllama;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import jakarta.json.JsonObject;

import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@IAOlhama
public class IAOlhamaImpl extends RepositorioLinkEntidadesGenerico implements ItfErpIA {
    private static final String LOCAL_ARQUIVOS_JSON = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/";
    private static final String PREFIXO_OBRIGATORIO = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/";


    @Override
    public String gerarPersona(String pNomePersona, String pPromptSystem, @Nullable String pTemplate, @Nullable Double pTemperature, @Nullable Boolean pStream, @Nullable String pQuantize) {
        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaAgenteModel.MODELO_CRIAR.getAcao(pNomePersona, pPromptSystem, pTemplate, pTemperature, pStream, pQuantize).getResposta();
        return resposta.toString();
    }

    @Override
    public String obterResposta(ItfPersona pPersona, ComoUsuario pUsuario, String pMensagem) {

        String chaveSessao = buildChaveSessao(pPersona, pUsuario);
        String promptSystem = UtilConfiguracoesIA.gerarPromptSystemComAssuntos(pUsuario);

        UtilHistoricoConversa.carregarHistoricoConversa(chaveSessao, pPersona, pMensagem, promptSystem);

        List<AssuntosPersona> assuntosComplementares = getAssuntosComplementaresDaInteracao(pPersona, pUsuario, pMensagem);
        for (AssuntosPersona assunto : assuntosComplementares) {
            UtilHistoricoConversa.carregarNovoSystem(chaveSessao, assunto.getDescricao());
        }

        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaChat.CONVERSA_SESSAO.getAcao(pPersona.getNome(),
                chaveSessao, pMensagem, promptSystem).getResposta();
        System.out.println("Resposta: " + resposta.getRespostaTexto());
        if (!resposta.isSucesso()) {
            return null;
        }
        JsonObject respostaJson = resposta.getRespostaComoObjetoJson();
        String respostaIA = respostaJson.getJsonObject("message").getString("content");
        if (respostaJson != null) {
            UtilHistoricoConversa.adicionarMensagem(chaveSessao, "assistant", respostaIA);
            return respostaJson.toString();
        }
        return null;
    }

    @Override
    public String obterRespostaUsuarioLogado(ItfPersona itfPersona, String s) {
        return "";
    }

    @Override
    public String limparSessao(ItfPersona itfPersona, ComoUsuario itfUsuario) throws ErroOllamaERP {

        String caminhoArquivoJsonConversa = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/"
                + itfUsuario.getId() + "_" + itfPersona.getId() + ".json";
        SBCore.getConfigModulo(FabConfigOllama.class).getRepositorioDeArquivosExternos().putConteudoRecursoExterno("nomeJson.json", "{conteudojson}");
        // SBCore.getConfigModulo(FabConfigOllama.class).getRepositorioDeArquivosExternos().getJsonListaObjeto("nomeJson.json");
        // String caminhoArquivo =
        //          SBCore.getConfigModulo(FabConfigOllama.class).getRepositorioDeArquivosExternos().getCaminhoArquivosRepositorio()+"nomeJson.json";


        String prefixoObrigatorio;
        if (SBCore.isEmModoDesenvolvimento()) {
            prefixoObrigatorio = PREFIXO_OBRIGATORIO;
        } else {
            throw new ErroOllamaERP("O sistema não está em modo desenvolvimento.");
//            prefixoObrigatorio = SBCore.getConfigModulo(FabConfigOllama.class).getPropriedade(FabConfigOllama.DIRETORIO_PASTA_RELEASE);
        }
        if (!caminhoArquivoJsonConversa.contains(prefixoObrigatorio)) {
            throw new ErroOllamaERP("A localizacao do arquivo " + caminhoArquivoJsonConversa + "não é está dentro de um subdiretorio de " + prefixoObrigatorio);
        }
        File arquivo = new File(caminhoArquivoJsonConversa);
        if (arquivo.exists()) {
            boolean deletado = arquivo.delete();
            if (deletado) {
                return "Sessão limpa com suceso";
            } else {
                throw new ErroOllamaERP("Não foi possivel apagar o arquivo da sessão");
            }
        } else {
            return "Arquivo de sessão não encontrado, nada há limpar";
        }
    }

    @Override
    public String limparSessaoUsuarioLogado(ItfPersona itfPersona) {
        return "";
    }

    private String buildChaveSessao(ItfPersona pPersona, ComoUsuario pUsuario) {
        return pPersona.getId() + "_" + pUsuario.getId() + ".json";
    }

    private Optional<AssuntosPersona> detectarAssunto(String pMensagem) {
        if (pMensagem.toLowerCase().contains("serviço") || pMensagem.toLowerCase().contains("criar site")) {
            return Optional.of((AssuntosPersona) FabAssuntosGenericos.ASSUNTO_PRODUTO.getRegistro());
        }
        if (pMensagem.toLowerCase().contains("suporte") || pMensagem.toLowerCase().contains("ajuda")) {
            return Optional.of((AssuntosPersona) FabAssuntosGenericos.ASSUNTO_SUPORTE.getRegistro());
        }
        if (pMensagem.toLowerCase().contains("agendar") || pMensagem.toLowerCase().contains("horário")) {
            return Optional.of((AssuntosPersona) FabAssuntosGenericos.ASSUNTO_AGENDAMENTO.getRegistro());
        }

        return Optional.empty();
    }

    private List<AssuntosPersona> getAssuntosComplementaresDaInteracao(ItfPersona persona, ComoUsuario pUsuario, String pNovaInteracao) {
        List<AssuntosPersona> assuntosDetectados = new ArrayList<>();
        Optional<AssuntosPersona> assuntoOpt = detectarAssunto(pNovaInteracao);
        if (assuntoOpt.isPresent()) {
            AssuntosPersona assuntoDetectado = assuntoOpt.get();
            assuntosDetectados.add(assuntoDetectado);
        }
        return assuntosDetectados;
    }


}
