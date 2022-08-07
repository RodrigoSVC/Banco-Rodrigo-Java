import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if(valor > 500) {
            System.out.println("Você tem certeza que quer depositar todo esse valor? Y/N");
            Scanner ler = new Scanner(System.in);
            String certeza = ler.next().toUpperCase();
            if (certeza.equals("Y")) {
                saldo += valor;
                System.out.println("Operação completada com sucesso.");
            } else if (certeza.equals("N")) {
                System.out.println("Cancelando operação.");
            } else {
                System.out.println("Operação inválida, pulando...");
            }
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(valor > this.getSaldo()){
            System.out.println("Você não tem saldo suficiente.");
        }
        else{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular da conta: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número da conta: %d", this.numero));
        System.out.println(String.format("Saldo da conta: %.2f", this.saldo));
    }
}
