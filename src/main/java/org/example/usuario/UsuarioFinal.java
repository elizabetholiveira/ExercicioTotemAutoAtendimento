package org.example.usuario;

public class UsuarioFinal {

    UsuarioMenu usuarioMenu = new UsuarioMenu();
    UsuarioScanner usuarioScanner = new UsuarioScanner();
    UsuarioCarrinho usuarioCarrinho = new UsuarioCarrinho();

    public void usuarioFinal(){
        boolean ativo = true;
        while (ativo) {
            int selecao = 0;
            while (selecao == 0) {
                usuarioMenu.menuPrincipal();
                selecao = usuarioScanner.respostaValida();
            }
            if (selecao == 1){
                selecao = 0;
                while (selecao == 0) {
                    usuarioMenu.menuLanches();
                    selecao = usuarioScanner.respostaValida();
                }
                if (selecao == 1){
                    usuarioCarrinho.calculoXburger(usuarioScanner.quantidade(), false);
                    usuarioCarrinho.verCarrinho();
                    selecao = 0;
                }
                if (selecao == 2) {
                    usuarioCarrinho.calculoXsalada(usuarioScanner.quantidade(), false);
                    usuarioCarrinho.verCarrinho();
                    selecao = 0;
                }
            }
            if (selecao == 2){
                selecao = 0;
                while (selecao == 0) {
                    usuarioMenu.menuBebidas();
                    selecao = usuarioScanner.respostaValida();
                }
                if (selecao == 1){
                    usuarioCarrinho.calculoRefri(usuarioScanner.quantidade(), false);
                    usuarioCarrinho.verCarrinho();
                    selecao = 0;
                }
                if (selecao == 2) {
                    usuarioCarrinho.calculoSuco(usuarioScanner.quantidade(), false);
                    usuarioCarrinho.verCarrinho();
                    selecao = 0;
                }
            }
            boolean ativo2 = true;
            while (ativo2) {
                while (selecao == 0) {
                    usuarioMenu.menuFinal();
                    selecao = usuarioScanner.respostaValidaFinal();
                }
                if (selecao == 1) { // incluir itens (reiniciar)
                    System.out.println();
                    ativo2 = false;
                }
                if (selecao == 2) { // alterar quantidade
                    selecao = 0;
                    int comida = 0;
                    int quantidade = 0;
                    while (selecao == 0) {
                        usuarioMenu.menuTroca(usuarioMenu.alterar);
                        comida = usuarioScanner.respostaValidaFinal();
                        if (comida == 0) {
                            break;
                        }
                        quantidade = usuarioScanner.quantidade();
                        if (quantidade == 0) {
                            break;
                        }
                        selecao = 1;
                    }
                    usuarioCarrinho.trocarQuantidade(comida, quantidade);
                }
                if (selecao == 3) { // remover item
                    selecao = 0;
                    int comida = 0;
                    while (selecao == 0){
                        usuarioMenu.menuTroca(usuarioMenu.remover);
                        comida = usuarioScanner.respostaValidaFinal();
                        if (comida == 0){
                            break;
                        }
                        selecao = 1;
                    }
                    if (comida == 1){ //x-burger
                        usuarioCarrinho.removerItem(usuarioCarrinho.xburgerQtdSql, usuarioCarrinho.xburgerValorSql);
                    }
                    if (comida == 2){ //x-salada
                        usuarioCarrinho.removerItem(usuarioCarrinho.xsaladaQtdSql, usuarioCarrinho.xsaladaValorSql);
                    }
                    if (comida == 3){ //refri
                        usuarioCarrinho.removerItem(usuarioCarrinho.refriQtdSql, usuarioCarrinho.refriValorSql);
                    }
                    if (comida ==4){ //suco
                        usuarioCarrinho.removerItem(usuarioCarrinho.sucoQtdSql, usuarioCarrinho.sucoValorSql);
                    }
                    usuarioCarrinho.verCarrinho();
                    selecao = 0;

                }
                if (selecao == 4) {
                    usuarioCarrinho.verCarrinho();
                    int pagamento = 0;
                    selecao = 0;
                    while (selecao == 0) {
                        usuarioMenu.menuPagamento();
                        pagamento = usuarioScanner.respostaValidaFinal();
                        selecao = pagamento;
                    }
                    if (pagamento == 4){
                        boolean pagar = true;
                        while (pagar) {
                            double valor = usuarioScanner.pagamento();
                            if (valor < usuarioCarrinho.valorTotal()) {
                                System.out.println("Valor inválido ou insuficiente");
                            } else if (valor > usuarioCarrinho.valorTotal()){
                                double troco = valor - usuarioCarrinho.valorTotal();
                                System.out.printf("O seu troco é: R$%,.2f%n", troco);
                                pagar = false;
                            }
                        }
                    }
                    System.out.println("Compra finalizada com sucesso! Boa refeição");
                    ativo = false;
                    ativo2 = false;
                    usuarioCarrinho.limparTudo();
                }
            }
        }
    }
}
