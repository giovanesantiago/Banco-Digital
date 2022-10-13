import back.Cliente;
import back.Conta;
import back.ContaCorrente;
import back.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class testeCriacaoDeContas {
    Cliente cliente1 = new Cliente();
    Cliente cliente2 = new Cliente();
    Cliente cliente3 = new Cliente();


    @Test
    void testCriacaoContaCorrente() {
        // Criando 3 contas correntes para tres clientes direntes
        cliente1.setNome("Giovane1");
        cliente2.setNome("Giovane2");
        cliente3.setNome("Giovane3");


        Conta conta1 = new ContaCorrente(cliente1);
        Conta conta2 = new ContaCorrente(cliente2);
        Conta conta3 = new ContaCorrente(cliente3);

        // Verificando se todas as contas tem o mesmo numero de agencia
        Assertions.assertEquals(conta1.getAgencia(), conta2.getAgencia());
        Assertions.assertEquals(conta2.getAgencia(), conta3.getAgencia());

        // Verificando se numero das contas não são iguais
        Assertions.assertNotEquals(conta1.getNumeroConta(), conta2.getNumeroConta());
        Assertions.assertNotEquals(conta2.getNumeroConta(), conta3.getNumeroConta());

        // Verificando saldo zerado na criação
        Assertions.assertEquals(conta1.getSaldo(), 0d);
        Assertions.assertEquals(conta2.getSaldo(), 0d);
        Assertions.assertEquals(conta3.getSaldo(), 0d);


    }

    @Test
    void testCriacaoContaPoupanca() {
        // Criando 3 contas Poupança para tres clientes direntes
        cliente1.setNome("Giovane1");
        cliente2.setNome("Giovane2");
        cliente3.setNome("Giovane3");


        Conta conta1 = new ContaPoupanca(cliente1);
        Conta conta2 = new ContaPoupanca(cliente2);
        Conta conta3 = new ContaPoupanca(cliente3);

        // Verificando se todas as contas tem o mesmo numero de agencia
        Assertions.assertEquals(conta1.getAgencia(), conta2.getAgencia());
        Assertions.assertEquals(conta2.getAgencia(), conta3.getAgencia());

        // Verificando se numero das contas não são iguais
        Assertions.assertNotEquals(conta1.getNumeroConta(), conta2.getNumeroConta());
        Assertions.assertNotEquals(conta2.getNumeroConta(), conta3.getNumeroConta());

        // Verificando saldo zerado na criação
        Assertions.assertEquals(conta1.getSaldo(), 0d);
        Assertions.assertEquals(conta2.getSaldo(), 0d);
        Assertions.assertEquals(conta3.getSaldo(), 0d);


    }

    @Test
    void testCriacaoContaCorrenteEPoupanca() {
        // Criando 3 contas correntes e poupanca uma de cada para cada clientes
        cliente1.setNome("Giovane1");
        cliente2.setNome("Giovane2");
        cliente3.setNome("Giovane3");

        // CC - Conta Corrente | CP - Conta Poupança
        Conta conta1cc = new ContaPoupanca(cliente1);
        Conta conta1cp = new ContaPoupanca(cliente1);

        Conta conta2cc = new ContaPoupanca(cliente2);
        Conta conta2cp = new ContaPoupanca(cliente2);

        Conta conta3cc = new ContaPoupanca(cliente3);
        Conta conta3cp = new ContaPoupanca(cliente3);

        // Verificando se todas as contas tem o mesmo numero de agencia
        // Corrente
        Assertions.assertEquals(conta1cc.getAgencia(), conta2cc.getAgencia());
        Assertions.assertEquals(conta2cc.getAgencia(), conta3cc.getAgencia());
        // Poupança
        Assertions.assertEquals(conta1cp.getAgencia(), conta2cc.getAgencia());
        Assertions.assertEquals(conta2cp.getAgencia(), conta3cc.getAgencia());
        // Poupança e Corrente
        Assertions.assertEquals(conta1cc.getAgencia(), conta1cp.getAgencia());
        // Verificando somente conta1 pois se todas as cc são iguais e todas as cp são iguais,
        // então so precisa verifica se uma cc ou cp são iguais tambem

        // Verificando se numero das contas não são iguais
        // Corrente
        Assertions.assertNotEquals(conta1cc.getNumeroConta(), conta2cc.getNumeroConta());
        Assertions.assertNotEquals(conta2cc.getNumeroConta(), conta3cc.getNumeroConta());
        // Poupança
        Assertions.assertNotEquals(conta1cp.getNumeroConta(), conta2cp.getNumeroConta());
        Assertions.assertNotEquals(conta2cp.getNumeroConta(), conta3cp.getNumeroConta());
        // Poupança e Corrente
        Assertions.assertNotEquals(conta1cc.getNumeroConta(), conta1cp.getNumeroConta());
        Assertions.assertNotEquals(conta2cc.getNumeroConta(), conta2cp.getNumeroConta());
        Assertions.assertNotEquals(conta3cc.getNumeroConta(), conta3cp.getNumeroConta());
        Assertions.assertNotEquals(conta1cc.getNumeroConta(), conta2cp.getNumeroConta());
        Assertions.assertNotEquals(conta2cc.getNumeroConta(), conta3cp.getNumeroConta());
        Assertions.assertNotEquals(conta3cc.getNumeroConta(), conta1cp.getNumeroConta());
        Assertions.assertNotEquals(conta1cc.getNumeroConta(), conta3cp.getNumeroConta());
        Assertions.assertNotEquals(conta2cc.getNumeroConta(), conta1cp.getNumeroConta());
        Assertions.assertNotEquals(conta3cc.getNumeroConta(), conta2cp.getNumeroConta());



        // Verificando saldo zerado na criação
        //Corrente
        Assertions.assertEquals(conta1cc.getSaldo(), 0d);
        Assertions.assertEquals(conta2cc.getSaldo(), 0d);
        Assertions.assertEquals(conta3cc.getSaldo(), 0d);
        //Poupança
        Assertions.assertEquals(conta1cp.getSaldo(), 0d);
        Assertions.assertEquals(conta2cp.getSaldo(), 0d);
        Assertions.assertEquals(conta3cp.getSaldo(), 0d);


    }


}
