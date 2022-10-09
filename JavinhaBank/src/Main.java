import contas.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente giovane = new Cliente();
        giovane.setNome("Giovane");

        Conta ccGiovane = new ContaCorrente(giovane);

        ccGiovane.depositar(100);

        Conta cpGiovane = new ContaPoupanca(giovane);

        ccGiovane.imprimirExtrato();
        cpGiovane.imprimirExtrato();

        /*ccGiovane.transferir(50, cpGiovane);

        ccGiovane.imprimirExtrato();
        cpGiovane.imprimirExtrato();*/


    }
}
