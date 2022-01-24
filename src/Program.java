import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class Program {
    private static List<ContaInterface> contas = new ArrayList<>(); 
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int a = 1;
        while(true){
            System.out.printf("Menu\n1) criar conta\n2) Extrato\n3) Depositar\n4) Sacar\n5) Transferir\n0) sair\n");
            a = scan.nextInt();
            scan.nextLine();
            switch(a){
                case 1:
                    criarConta();
                break;
                case 2:
                    estrato();
                break;
                case 3:
                    depositar();
                break;
                case 4:
                    sacar();
                break;
                case 5:
                    transferir();
                break;
                case 0:
                    scan.close();
                return;
                default:
                    System.out.println("Essa opção não existe");                
            };
        }
    }

    private static void criarConta(){
        System.out.printf("1) Conta Corrente\n2) Conta Poupança\n0) Voltar\n");
        int a = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o nome do cliente:");
        String cliente = scan.nextLine();
        System.out.println("Digite o número da Agencia:");
        String agencia = scan.nextLine();
        switch(a){
            case 1:
                contas.add(new ContaCorrente(agencia, cliente));
            break;
            case 2:
                contas.add(new ContaPoupanca(agencia, cliente));
            break;
            default:
                System.out.println("Essa opção não existe.");
                criarConta();
        }
    }

    private static void estrato(){
        System.out.println("Digite o número da conta:");
        int numeroDaConta = scan.nextInt();
        scan.nextLine();
        try {
            contas.get(numeroDaConta - 1).estrato();
        } catch (Exception e) {
            if(e instanceof IndexOutOfBoundsException)
            System.out.println("Essa conta não existe");
            else
            System.out.println("Algum erro aconteceu");
        }
    }

    private static void depositar(){
        System.out.println("Digite o número da conta:");
        int numeroDaConta = scan.nextInt();
        System.out.println("Digite o valor a ser depositado: ");
        double valor = scan.nextDouble();
        try {
            contas.get(numeroDaConta - 1).depositar(valor);
        } catch (Exception e) {
            if(e instanceof IndexOutOfBoundsException)
            System.out.println("Essa conta não existe");
            else
            System.out.println("Algum erro aconteceu");
        }
    }

    private static void sacar(){
        System.out.println("Digite o número da Conta:");
        int numeroDaConta = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o valor a ser sacado");
        double valor = scan.nextDouble();
        scan.nextLine();
        try {
            contas.get(numeroDaConta - 1).sacar(valor);
        } catch (Exception e) {
            if(e instanceof IndexOutOfBoundsException)
            System.out.println("Essa conta não existe");
            else
            System.out.println("Algum erro aconteceu");
        }
    }

    private static void transferir(){
        System.out.println("Digite o número da Conta:");
        int numeroDaConta = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a número da conta do beneficiario:");
        int numeroDaContaDoBeneficiario = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o valor a ser transferido");
        double valor = scan.nextDouble();
        scan.nextLine();
        try {
            contas.get(numeroDaConta - 1).transferir(valor, contas.get(numeroDaContaDoBeneficiario - 1));
        } catch (Exception e) {
            if(e instanceof IndexOutOfBoundsException)
            System.out.println("Essa conta não existe");
            else
            System.out.println("Algum erro aconteceu");
        }
    }
}