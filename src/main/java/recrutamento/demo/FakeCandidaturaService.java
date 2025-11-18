package recrutamento.demo;

import recrutamento.dto.CandidaturaDTO;
import recrutamento.interfaces.ICandidaturaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serviço fake para simular o módulo de Candidatura durante a demo.
 */
public class FakeCandidaturaService implements ICandidaturaService {

    private final Map<String, CandidaturaDTO> storage = new HashMap<>();

    public void adicionar(CandidaturaDTO c) {
        storage.put(c.getId(), c);
    }

    @Override
    public CandidaturaDTO buscarPorId(String candidaturaId) {
        return storage.get(candidaturaId);
    }

    @Override
    public List<CandidaturaDTO> listarPorVaga(String vagaId) {
        return storage.values().stream()
                .filter(c -> c.getVagaId().equals(vagaId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<CandidaturaDTO> listarTodas() {
        return new ArrayList<>(storage.values());
    }
}
