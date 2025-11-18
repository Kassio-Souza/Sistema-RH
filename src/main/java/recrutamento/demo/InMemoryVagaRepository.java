package recrutamento.demo;

import recrutamento.dominio.RegimeContratacao;
import recrutamento.dominio.StatusVaga;
import recrutamento.dominio.Vaga;
import recrutamento.persistencia.VagaRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementação simples em memória para demonstrar o módulo de Recrutamento
 * sem depender de arquivos CSV.
 */
public class InMemoryVagaRepository implements VagaRepository {

    private final Map<String, Vaga> storage = new HashMap<>();

    @Override
    public Vaga salvar(Vaga v) {
        storage.put(v.getId(), v);
        return v;
    }

    @Override
    public Optional<Vaga> buscarPorId(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Vaga> listarTodos() {
        return storage.values().stream()
                .sorted(Comparator.comparing(Vaga::getDataAbertura))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remover(String id) {
        storage.remove(id);
    }

    @Override
    public List<Vaga> filtrar(String cargo,
                              String departamento,
                              StatusVaga status,
                              RegimeContratacao regime,
                              Double faixaMin,
                              Double faixaMax) {

        return listarTodos().stream()
                .filter(v -> cargo == null || v.getCargo().toLowerCase().contains(cargo.toLowerCase()))
                .filter(v -> departamento == null || v.getDepartamento().equalsIgnoreCase(departamento))
                .filter(v -> status == null || v.getStatus() == status)
                .filter(v -> regime == null || v.getRegime() == regime)
                .filter(v -> faixaMin == null || v.getSalarioBase() >= faixaMin)
                .filter(v -> faixaMax == null || v.getSalarioBase() <= faixaMax)
                .collect(Collectors.toList());
    }
}
