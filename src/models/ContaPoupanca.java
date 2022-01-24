package models;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String agencia, String cliente){
        super(agencia, cliente);
    }

    public void render(){
        super.saldo *= 1.05;
    }
}
