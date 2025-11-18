package recrutamento.demo;

import Seguranca.dominio.Usuario;
import recrutamento.dominio.Contratacao;
import recrutamento.dominio.Entrevista;
import recrutamento.dominio.RegimeContratacao;
import recrutamento.dominio.StatusVaga;
import recrutamento.dominio.Vaga;
import recrutamento.dto.CandidaturaDTO;
import recrutamento.servico.RecrutamentoService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Demonstração de ponta a ponta do módulo de Recrutamento
 * usando repositórios em memória e serviços fakes para
 * Candidatura e Financeiro.
 */
public class RecrutamentoDemo {

    public static void main(String[] args) {
        // Infra básica em memória
        var vagaRepo = new InMemoryVagaRepository();
        var entrevistaRepo = new InMemoryEntrevistaRepository();
        var contratacaoRepo = new InMemoryContratacaoRepository();
        var candidaturaService = new FakeCandidaturaService();
        var financeiroService = new RecordingFinanceiroService();

        // Serviço principal
        var service = new RecrutamentoService(
                vagaRepo,
                entrevistaRepo,
                contratacaoRepo,
                candidaturaService,
                financeiroService
        );

        // Usuários que irão acionar o serviço
        Usuario gestor = new Usuario(1, "gestor", "123", "GESTOR_RH",
                "Gestora Maria", "11111111111", "ATIVO", "RH");
        Usuario recrutador = new Usuario(2, "recrutador", "123", "RECRUTADOR_RH",
                "Recrutador Ana", "22222222222", "ATIVO", "RH");

        // 1) Gestor cria a vaga
        service.configurarUsuarioLogado(gestor);
        Vaga vaga = service.criarVaga(
                "Desenvolvedor Java",
                "TI",
                9500.0,
                "Java 17, SQL, integração",
                RegimeContratacao.CLT
        );
        service.atribuirRecrutador(vaga.getId(), recrutador.getCpf_cnpj());

        System.out.println("=== Vaga criada pelo gestor ===");
        System.out.println("ID: " + vaga.getId());
        System.out.println("Código amigável: " + vaga.getCodigo());
        System.out.println("Recrutador responsável: " + vaga.getRecrutadorResponsavelCpf());
        System.out.println();

        // 2) Novas candidaturas chegam do módulo de Candidatura
        CandidaturaDTO aprov = new CandidaturaDTO("cand-aprov", vaga.getId(), "33333333333", "APROVADO");
        CandidaturaDTO emAnalise = new CandidaturaDTO("cand-analise", vaga.getId(), "44444444444", "EM_ANALISE");
        candidaturaService.adicionar(aprov);
        candidaturaService.adicionar(emAnalise);

        // 3) Recrutador marca entrevista e solicita contratação
        service.configurarUsuarioLogado(recrutador);
        List<CandidaturaDTO> candidaturas = service.listarCandidaturasParaEntrevista();
        System.out.println("=== Candidaturas visíveis para o recrutador ===");
        candidaturas.forEach(c -> System.out.println("- " + service.montarRotuloCandidatura(c)));
        System.out.println();

        Entrevista entrevista = service.agendarEntrevista(
                aprov.getId(),
                LocalDateTime.now().plusDays(1),
                "Tech Lead",
                9.2,
                "Solicitar contratação"
        );
        System.out.println("Entrevista agendada: " + entrevista.getId() + " em " + entrevista.getDataHora());

        Contratacao solicitacao = service.solicitarContratacao(aprov.getId(), RegimeContratacao.CLT);
        System.out.println("Solicitação de contratação criada: " + solicitacao.getId());

        // 4) Gestor autoriza
        service.configurarUsuarioLogado(gestor);
        Contratacao autorizada = service.autorizarContratacao(solicitacao.getId());
        System.out.println("Contratação autorizada em: " + autorizada.getDataAutorizacao());

        // 5) Recrutador efetiva a contratação
        service.configurarUsuarioLogado(recrutador);
        service.efetivarContratacao(solicitacao.getId());
        System.out.println("Contratação efetivada e enviada ao Financeiro.");
        System.out.println();

        System.out.println("=== Funcionários registrados no Financeiro ===");
        financeiroService.getRegistrados().forEach(f ->
                System.out.println("- CPF " + f.getCpf() + " | Cargo " + f.getCargo() + " | Regime " + f.getRegime())
        );

        System.out.println();
        System.out.println("Status final da vaga: " + vagaRepo.buscarPorId(vaga.getId()).map(Vaga::getStatus).orElse(StatusVaga.ABERTA));
    }
}
