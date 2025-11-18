package recrutamento.demo;

import recrutamento.dominio.Contratacao;
import recrutamento.persistencia.ContratacaoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryContratacaoRepository implements ContratacaoRepository {

    private final Map<String, Contratacao> storage = new HashMap<>();

    @Override
    public Contratacao salvar(Contratacao c) {
        storage.put(c.getId(), c);
        return c;
    }

    @Override
    public Optional<Contratacao> buscarPorId(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Contratacao> listarTodas() {
        return new ArrayList<>(storage.values());
    }
}
