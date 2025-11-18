package Financeiro;

/**
 * Representa informações financeiras básicas para cálculo de salário.
 */
public class Financeiro {
    public Vinculo vinculo;
    public double salarioBase;
    public boolean temValeTransporte;
    public boolean temValeAlimentacao;
    public boolean temIsencaoIr;
    public double adicionalSalario;
    public double salarioCalculado;

    public void calculaSalario() {
        double salario = salarioBase + adicionalSalario;
        if (!temIsencaoIr && vinculo == Vinculo.CLT) {
            salario -= salario * 0.1; // desconto simples de IR
        }
        salarioCalculado = salario;
    }
}
