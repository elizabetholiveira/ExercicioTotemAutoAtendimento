package org.example.usuario;

public class UsuarioMenu {

    public void menuPrincipal(){
        System.out.println("----------");
        System.out.println("Boas-vindas ao nosso terminal de auto-atendimento! Selecione uma opção:");
        System.out.println("1. Lanche");
        System.out.println("2. Bebida");
        System.out.println("----------");
    }

    public void menuLanches(){
        System.out.println("----------");
        System.out.println("Você selecionou lanche! Escolha o tipo abaixo:");
        System.out.println("1. X-burger");
        System.out.println("2. X-salada");
        System.out.println("----------");
    }

    public void menuBebidas(){
        System.out.println("----------");
        System.out.println("Você selecionou bebida! Escolha o tipo abaixo:");
        System.out.println("1. Refrigerante");
        System.out.println("2. Suco");
        System.out.println("----------");
    }

    public void menuFinal(){
        System.out.println("----------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1. Incluir mais itens");
        System.out.println("2. Editar a quantidade de um item");
        System.out.println("3. Remover um item");
        System.out.println("4. Finalizar pedido");
        System.out.println("----------");
    }

    String alterar = "Selecione o tipo de pedido que deseja alterar a quantidade:";
    String remover = "Selecione o tipo de pedido que deseja remover:";

    public void menuTroca(String comando){
        System.out.println("----------");
        System.out.println(comando);
        System.out.println("1. X-burger");
        System.out.println("2. X-salada");
        System.out.println("3. Refrigerante");
        System.out.println("4. Suco");
        System.out.println("----------");
    }

    public void menuPagamento(){
        System.out.println("----------");
        System.out.println("Selecione o método de pagamento:");
        System.out.println("1. Cartão de crédito");
        System.out.println("2. Cartão de débito");
        System.out.println("3. Vale refeição");
        System.out.println("4. Dinheiro");
        System.out.println("----------");
    }
}
