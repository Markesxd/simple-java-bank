package models;

public abstract class Conta implements ContaInterface{
    private String agencia;
    private int numero;
    protected double saldo;
    private String cliente;
    private static int NUMERO_DE_CONTAS = 0;

    public Conta(String agencia, String cliente){
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = ++NUMERO_DE_CONTAS;
        System.out.printf("Número da conta: %d\n", this.numero);
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        if(!temSaldo(valor)){
            System.out.println("Seu saldo é insuficiente.");
            return;
        }
        this.saldo -= valor;
    }

    public void estrato(){
        System.out.println("--Estrato--");
        System.out.printf("Agencia: %s\n", this.agencia);
        System.out.printf("Número: %d\n", this.numero);
        System.out.printf("Saldo: %.2f\n", this.saldo);
        System.out.printf("Cliente: %s\n", this.cliente);
    }

    public void transferir(double valor, ContaInterface destinatario){
        if(!temSaldo(valor)){
            System.out.println("Seu saldo é insuficiente.");
            return;
        }
        this.sacar(valor);
        destinatario.depositar(valor);
    }

    private boolean temSaldo(double valor){
        return valor < this.saldo;
    }
}
