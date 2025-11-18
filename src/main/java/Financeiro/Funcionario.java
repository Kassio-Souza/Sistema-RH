package Financeiro;

import Seguranca.dominio.Pessoa;

/**
 * Funcionario simplificado utilizado pelo módulo Financeiro para cálculos em
 * memória. Integra com o domínio de segurança via herança de Pessoa.
 */
public class Funcionario extends Pessoa {
    public Financeiro financeiro;
    public Cargo cargo;
    public Departamento departamento;
    public boolean ativo;

    public Funcionario(Pessoa pessoa, Financeiro financeiro, Cargo cargo, Departamento departamento, boolean ativo) {
        super(pessoa != null ? pessoa.getId() : 0,
              pessoa != null ? pessoa.getNome() : "",
              pessoa != null ? pessoa.getFisicaOuJuridica() : "fisica",
              pessoa != null ? pessoa.getCpf_cnpj() : "",
              pessoa != null ? pessoa.getDataNascimento() : "",
              pessoa != null ? pessoa.getEmailPessoal() : "",
              pessoa != null ? pessoa.getTelefonePessoal() : "",
              pessoa != null ? pessoa.getEnderecoCompleto() : "");
        this.financeiro = financeiro;
        this.cargo = cargo;
        this.departamento = departamento;
        this.ativo = ativo;
    }
}
