package recrutamento.demo;

import recrutamento.dto.FuncionarioDTO;
import recrutamento.interfaces.IFinanceiroService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação que registra os funcionários enviados pelo Recrutamento
 * durante a demonstração.
 */
public class RecordingFinanceiroService implements IFinanceiroService {

    private final List<FuncionarioDTO> registrados = new ArrayList<>();

    @Override
    public void cadastrarFuncionario(FuncionarioDTO funcionario) {
        registrados.add(funcionario);
    }

    public List<FuncionarioDTO> getRegistrados() {
        return registrados;
    }
}
