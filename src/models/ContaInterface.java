package models;

public interface ContaInterface {
    void depositar(double valor);
    void sacar(double valor);
    void estrato();
    void transferir(double valor, ContaInterface destinatario);
}
