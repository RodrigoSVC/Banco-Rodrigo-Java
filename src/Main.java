import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente rodrigo = new Cliente();
        rodrigo.setNome("Rodrigo");

        Conta contaCliente = new ContaCorrente(rodrigo);
        Conta poupanca = new ContaPoupanca(rodrigo);

        Scanner check = new Scanner(System.in);
        System.out.println("Insira um valor para depositar em sua conta:");
        double deposito = check.nextDouble();
        contaCliente.depositar(deposito);
        System.out.println("Insira um valor para transferir para sua poupança:");
        double transferencia = check.nextDouble();
        contaCliente.transferir(transferencia, poupanca);

        contaCliente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
