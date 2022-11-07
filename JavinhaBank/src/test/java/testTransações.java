import back.Cliente;
import back.Conta;
import back.ContaCorrente;
import back.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class testTransações {
    Cliente cliente1 = new Cliente();
    Cliente cliente2 = new Cliente();

    @Test
    void testDeSaque() {
        cliente1.setNome("Giovane");
        Conta conta = new ContaCorrente(cliente1);

        conta.depositar(100.50);
        conta.sacar(99);
        Assertions.assertEquals(conta.getSaldo(), 1,50);

    }

    @Test
    void testDeposito() {
        cliente1.setNome("Giovane");
        Conta conta = new ContaCorrente(cliente1);

        conta.depositar(100);
        Assertions.assertEquals(conta.getSaldo(), 100);

    }

    @Test
    void testTransferencia() {
        cliente1.setNome("Giovane");
        cliente2.setNome("Santiago");
        // Cliente 1
        Conta contaCorrenteCli1 = new ContaCorrente(cliente1);
        Conta contaPoupancaCli1 = new ContaPoupanca(cliente1);
        // Cliente 2
        Conta contaCorrenteCli2 = new ContaCorrente(cliente2);
        Conta contaPoupancaCli2 = new ContaPoupanca(cliente2);

        contaCorrenteCli1.depositar(100.50);

        // Transferencia entre conta poupança e corrente do mesmo cliente
        // Corrente para poupança

        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 100.50);
        Assertions.assertEquals(contaPoupancaCli1.getSaldo(), 0d);
        contaCorrenteCli1.transferir(50.50, contaPoupancaCli1);
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 50);
        Assertions.assertEquals(contaPoupancaCli1.getSaldo(), 50.50);
        // poupança para corrente
        contaPoupancaCli1.transferir(0.25, contaCorrenteCli1);
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 50.25);
        Assertions.assertEquals(contaPoupancaCli1.getSaldo(), 50.25);

        // Transferencia entre conta de clientes diferentes
        // Corrente para corrente
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 50.25);
        Assertions.assertEquals(contaCorrenteCli2.getSaldo(), 0d);
        contaCorrenteCli1.transferir(25,contaCorrenteCli2);
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 25.25);
        Assertions.assertEquals(contaCorrenteCli2.getSaldo(), 25d);
        // Poupança para poupança
        Assertions.assertEquals(contaPoupancaCli1.getSaldo(), 50.25);
        Assertions.assertEquals(contaPoupancaCli2.getSaldo(), 0d);
        contaPoupancaCli1.transferir(25, contaPoupancaCli2);
        Assertions.assertEquals(contaPoupancaCli1.getSaldo(), 25.25);
        Assertions.assertEquals(contaPoupancaCli2.getSaldo(), 25d);
        // Corrente para poupança
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 25.25);
        Assertions.assertEquals(contaPoupancaCli2.getSaldo(), 25d);
        contaCorrenteCli1.transferir(0.25,contaPoupancaCli2);
        Assertions.assertEquals(contaCorrenteCli1.getSaldo(), 25d);
        Assertions.assertEquals(contaPoupancaCli2.getSaldo(), 25.25);



    }


}
