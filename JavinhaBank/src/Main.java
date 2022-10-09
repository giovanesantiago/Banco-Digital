import back.Cliente;
import back.Conta;
import back.ContaCorrente;
import back.ContaPoupanca;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente;
        Conta cc;
        Conta cp = null;


        JOptionPane.showMessageDialog(null,
                "Bem vindo ao JavinhaBank ! ", "Javinha Bank",
                JOptionPane.INFORMATION_MESSAGE);

        String jaPossuiConta = String.valueOf(JOptionPane.showInternalConfirmDialog(null,
                " -- Ja tem conta em nosso Banco ? -- ", "Javinha Bank",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE));

        switch (jaPossuiConta) {
            case "1" :
                // Não tem conta
                System.out.println("Nao tem conta");
                cliente = new Cliente();
                cliente.setNome(JOptionPane.showInputDialog(" Digite seu nome :"));
                System.out.println(cliente.getNome());
                cc = new ContaCorrente(cliente);
                JOptionPane.showMessageDialog(null,
                        "Conta Criada com Sucesso, Anote as informações da proxima aba");
                cc.imprimirExtrato();
                //  Se vai criar uma poupança tambem
                boolean continua = true;
                int escolha = 0;
                do {
                    escolha =  Integer.parseInt(JOptionPane.showInputDialog("Escolha uma Opção : \n" +
                            "1 - Criar conta poupança \n" +
                            "2 - Continuar sem poupança."));
                    if(escolha == 1) {
                        cp = new ContaPoupanca(cliente);
                        JOptionPane.showMessageDialog(null,
                                "Conta Criada com Sucesso, Anote as informações da proxima aba");
                        cp.imprimirExtrato();
                        continua = false;
                    } else if (escolha == 2) {
                        continua = false;
                    }else {
                        JOptionPane.showMessageDialog(null,
                                "Escolha errada, Tente novamente.");
                    }
                } while (continua);
                // Processos de Contas
                continua = true;
                do {
                    double valor;
                    escolha =  Integer.parseInt(JOptionPane.showInputDialog("Escolha uma Opção : \n" +
                            "1 - Sacar \n" +
                            "2 - Depositar \n" +
                            "3 - Transferir para poupança\n" +
                            "4 - Transferir para corrente\n" +
                            "5 - Saldo Corrente : " + cc.getSaldo() + "\n" +
                            "6 - Saldo Poupança \n" +
                            "7 - Extrato \n" +
                            "8 - Sair"));
                    switch (escolha) {
                        // Sacar
                        case 1 :
                            // Pegando Valor
                            valor = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja sacar :"));
                            // Verificando saldo
                            if(valor <= cc.getSaldo()){
                                cc.sacar(valor); // Sacando
                                JOptionPane.showMessageDialog(null,
                                        "Valor sacado com sucesso \n" +
                                                "novo Saldo : " + cc.getSaldo());
                            }else {
                                JOptionPane.showMessageDialog(null,
                                        "Saldo insuficiente, Tente novamente.");
                            }
                            break;
                        // Depositando
                        case 2 :
                            valor = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja Depositar :"));
                            cc.depositar(valor);
                            JOptionPane.showMessageDialog(null,
                                    "Valor Depositado com sucesso \n" +
                                            "novo Saldo : " + cc.getSaldo());
                            break;
                        // Transferir para poupança
                        case 3 :
                            // Verificando se tem conta Poupança
                            if(cp == null) {
                                int escolha1;

                                escolha1 =  Integer.parseInt(JOptionPane.showInputDialog("Voce não tem poupança Deseja criar ? \n" +
                                        "1 - Criar conta poupança \n" +
                                        "2 - Continuar sem poupança."));
                                // Cadastrando conta poupança
                                if(escolha1 == 1) {
                                    cp = new ContaPoupanca(cliente);
                                    JOptionPane.showMessageDialog(null,
                                            "Conta Criada com Sucesso, Anote as informações da proxima aba");
                                    cp.imprimirExtrato();

                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Escolha errada, Tente novamente.");
                                }
                            }else {
                                // Tranferindo
                                valor = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja transferir :"));
                                // Verificando saldo
                                if(valor <= cc.getSaldo()){
                                    cc.transferir(valor, cp);
                                }else {
                                    JOptionPane.showMessageDialog(null,
                                            "Saldo insuficiente, Tente novamente.");
                                }
                                }
                            break;
                        case 4 :
                            // Verificando se tem conta Poupança
                            if(cp == null) {
                                int escolha1;

                                escolha1 = Integer.parseInt(JOptionPane.showInputDialog("V não tem poupança Deseja criar ? \n" +
                                        "1 - Criar conta poupança \n" +
                                        "2 - Continuar sem poupança."));
                                // Cadastrando conta poupança
                                if (escolha1 == 1) {
                                    cp = new ContaPoupanca(cliente);
                                    JOptionPane.showMessageDialog(null,
                                            "Conta Criada com Sucesso, Anote as informações da proxima aba");
                                    cp.imprimirExtrato();

                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Escolha errada, Tente novamente.");
                                }
                            } else {
                                // Tranferindo
                                valor = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja transferir :"));
                                // Verificando saldo
                                if(valor <= cp.getSaldo()){
                                    cp.transferir(valor, cc);
                                }else {
                                    JOptionPane.showMessageDialog(null,
                                            "Saldo insuficiente, Tente novamente.");
                                }
                            }
                            break;
                        case 6:
                            // Verificando se tem conta Poupança
                            if(cp == null) {
                                int escolha1;

                                escolha1 = Integer.parseInt(JOptionPane.showInputDialog("V não tem poupança Deseja criar ? \n" +
                                        "1 - Criar conta poupança \n" +
                                        "2 - Continuar sem poupança."));
                                // Cadastrando conta poupança
                                if (escolha1 == 1) {
                                    cp = new ContaPoupanca(cliente);
                                    JOptionPane.showMessageDialog(null,
                                            "Conta Criada com Sucesso, Anote as informações da proxima aba");
                                    cp.imprimirExtrato();

                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Escolha errada, Tente novamente.");
                                }
                            }else {
                                cp.imprimirExtrato();
                            }
                            break;
                        case 7 :
                            // Verificando se tem conta Poupança
                            if(cp == null) {
                                int escolha1;

                                escolha1 = Integer.parseInt(JOptionPane.showInputDialog("V não tem poupança Deseja criar ? \n" +
                                        "1 - Criar conta poupança \n" +
                                        "2 - Continuar sem poupança."));
                                // Cadastrando conta poupança
                                if (escolha1 == 1) {
                                    cp = new ContaPoupanca(cliente);
                                    JOptionPane.showMessageDialog(null,
                                            "Conta Criada com Sucesso, Anote as informações da proxima aba");
                                    cp.imprimirExtrato();

                                }
                            } else {
                                cc.imprimirExtrato();
                                cp.imprimirExtrato();
                            }
                            break;
                        case 8 :
                            continua = false;
                            JOptionPane.showMessageDialog(null,
                                    "Adeus Volte sempre .");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Escolha errada, Tente novamente.");
                    }
                } while (continua);
                break;
            case "0" :
                // Ja tem conta
                JOptionPane.showInputDialog("Digite numero da conta : ");
                JOptionPane.showMessageDialog(null, "Conta não encontrada !!", "Javinha Back"
                , JOptionPane.ERROR_MESSAGE);
                System.out.println("Ja tem conta");

            case "2" :
                // Sair
                System.out.println("Adeus");
                break;
            default:
                System.out.println("Error nenhuma opção escolhida!");
                break;
        }

        System.out.println("FIM .. ");



    }
}
