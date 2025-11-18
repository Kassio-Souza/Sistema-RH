package recrutamento.demo;

import recrutamento.dominio.Entrevista;
import recrutamento.persistencia.EntrevistaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryEntrevistaRepository implements EntrevistaRepository {

    private final Map<String, Entrevista> storage = new HashMap<>();

    @Override
    public Entrevista salvar(Entrevista e) {
        storage.put(e.getId(), e);
        return e;
    }

    @Override
    public Optional<Entrevista> buscarPorId(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Entrevista> listarPorCandidatura(String candidaturaId) {
        return storage.values().stream()
                .filter(e -> e.getCandidaturaId().equals(candidaturaId))
                .sorted((a, b) -> a.getDataHora().compareTo(b.getDataHora()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remover(String id) {
        storage.remove(id);
    }
}
