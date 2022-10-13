package back;


import javax.swing.*;

public abstract class Conta implements iConta{
    private static final int AGENCIA_PADRAO = 1;
    private static  int SEQUENCIAL = 1;


    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente;

    // Construtor
    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Manipulando Saldo
    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    // Imprimir infos no extrato
    protected void imprimirInfosComuns(String tipoConta) {
        if(tipoConta.equals("cc")) {
            JOptionPane.showMessageDialog(null,
                    "Titular: " + this.cliente.getNome() +
                            "\n" + "Agencia: " + this.agencia +
                            "\n" + "Conta: " + this.numeroConta +
                            "\n" + "Saldo: " + this.saldo,
                    "=== Extrato Conta Corrente ===", JOptionPane.INFORMATION_MESSAGE);
        } else if (tipoConta.equals("cp")) {
            JOptionPane.showMessageDialog(null,
                    "Titular: " + this.cliente.getNome() +
                            "\n" + "Agencia: " + this.agencia +
                            "\n" + "Conta: " + this.numeroConta +
                            "\n" + "Saldo: " + this.saldo,
                    "=== Extrato Conta Poupança ===", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
