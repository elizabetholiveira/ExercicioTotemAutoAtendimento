package org.example.usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioScanner {

    Scanner entrada = new Scanner(System.in);

    public int respostaValida(){
        int selecao = 0;
        try {
            selecao = entrada.nextInt();
            if (selecao == 1) {
            } else if (selecao == 2) {
            } else {
                System.out.println("Opção inválida, tente novamente");
                selecao = 0;
            }
        } catch (InputMismatchException e){
            System.out.println("Formato inválido, para escolher o item, você deve informar o número dele");
            entrada.nextLine();
            selecao = 0;
        }
        return selecao;
    }

    public int respostaValidaFinal(){
        int selecao = 0;
        try {
            selecao = entrada.nextInt();
            if (selecao >= 1 && selecao <= 4) {
            } else {
                System.out.println("Opção inválida, tente novamente");
                selecao = 0;
            }
        } catch (InputMismatchException e){
            System.out.println("Formato inválido, para escolher a opção, você deve informar o número dela");
            entrada.nextLine();
            selecao = 0;
        }
        return selecao;
    }

    public int quantidade(){
        int quantidade = 0;
        try {
            System.out.println("Digite a quantidade desejada:");
            quantidade = entrada.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Quantidade inválida");
            quantidade = 0;
        }
        return quantidade;
    }

    public double pagamento(){
        double pagamento = 0;
        try {
            System.out.println("Digite o valor que deseja pagar:");
            pagamento = entrada.nextDouble();
        } catch (InputMismatchException e){
            pagamento = 0;
        }
        return pagamento;
    }
}
