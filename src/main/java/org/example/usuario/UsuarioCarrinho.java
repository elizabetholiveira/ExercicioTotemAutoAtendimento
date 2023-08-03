package org.example.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.connection.Conexao.getConnection;

public class UsuarioCarrinho {

    // comidas

    double xburger = 10.00;
    double xsalada = 12.00;

    // bebidas

    double refri = 8.00;
    double suco = 6.00;

    private Statement statement;
    public UsuarioCarrinho(){
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void fecharConexao(){
        try{
            getConnection().close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    String verCarrinho = "select * from carrinho";

    // método cálculo xburger
    public void calculoXburger(int quantidade, boolean zerar){
        double total = quantidade * xburger;
        int qtdAnterior = 0;
        double valorAnterior = 0;
        try {
            if (zerar == false) {
                ResultSet resultSet = statement.executeQuery(verCarrinho);
                while (resultSet.next()) {
                    qtdAnterior = resultSet.getInt("qtdxburger");
                    valorAnterior = resultSet.getDouble("valorxburger");
                }
            }
            String sql1 = "update carrinho set qtdxburger = " + (quantidade + qtdAnterior) + ";";
            String sql2 = "update carrinho set valorxburger = " + (total + valorAnterior) + ";";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // método cálculo xsalada
    public void calculoXsalada(int quantidade, boolean zerar){
        double total = quantidade * xsalada;
        int qtdAnterior = 0;
        double valorAnterior = 0;
        try {
            if (zerar == false) {
                ResultSet resultSet = statement.executeQuery(verCarrinho);
                while (resultSet.next()) {
                    qtdAnterior = resultSet.getInt("qtdxsalada");
                    valorAnterior = resultSet.getDouble("valorxsalada");
                }
            }
            String sql1 = "update carrinho set qtdxsalada = " + (quantidade + qtdAnterior) + ";";
            String sql2 = "update carrinho set valorxsalada = " + (total + valorAnterior) + ";";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método cálculo refri
    public void calculoRefri(int quantidade, boolean zerar){
        double total = quantidade * refri;
        int qtdAnterior = 0;
        double valorAnterior = 0;
        try {
            if (zerar == false) {
                ResultSet resultSet = statement.executeQuery(verCarrinho);
                while (resultSet.next()) {
                    qtdAnterior = resultSet.getInt("qtdrefri");
                    valorAnterior = resultSet.getDouble("valorrefri");
                }
            }
            String sql1 = "update carrinho set qtdrefri = " + (quantidade + qtdAnterior) + ";";
            String sql2 = "update carrinho set valorrefri = " + (total + valorAnterior) + ";";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método cálculo suco
    public void calculoSuco(int quantidade, boolean zerar){
        double total = quantidade * suco;
        int qtdAnterior = 0;
        double valorAnterior = 0;
        try {
            if (zerar == false) {
                ResultSet resultSet = statement.executeQuery(verCarrinho);
                while (resultSet.next()) {
                    qtdAnterior = resultSet.getInt("qtdsuco");
                    valorAnterior = resultSet.getDouble("valorsuco");
                }
            }
            String sql1 = "update carrinho set qtdsuco = " + (quantidade + qtdAnterior) + ";";
            String sql2 = "update carrinho set valorsuco = " + (total + valorAnterior) + ";";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // método trocar quantidade
    public void trocarQuantidade(int comida, int quantidade){
        if (comida == 1){ //x-burger
            calculoXburger(quantidade, true);
        }
        if (comida == 2){ //x-salada
            calculoXsalada(quantidade, true);
        }
        if (comida == 3){ //refri
            calculoRefri(quantidade, true);
        }
        if (comida ==4){ //suco
            calculoSuco(quantidade, true);
        }
        verCarrinho();
    }

    // método ver carrinho
    public void verCarrinho(){
        int qtdxburger = 0;
        double valorxburger = 0.0;

        int qtdxsalada = 0;
        double valorxsalada = 0.0;

        int qtdrefri = 0;
        double valorrefri = 0.0;

        int qtdsuco = 0;
        double valorsuco = 0.0;

        System.out.println();
        System.out.println("----------");
        System.out.println("Carrinho:");
        try {
            ResultSet resultSet = statement.executeQuery(verCarrinho);
            while (resultSet.next()){
                qtdxburger = resultSet.getInt("qtdxburger");
                valorxburger = resultSet.getDouble("valorxburger");

                qtdxsalada = resultSet.getInt("qtdxsalada");
                valorxsalada = resultSet.getDouble("valorxsalada");

                qtdrefri = resultSet.getInt("qtdrefri");
                valorrefri = resultSet.getDouble("valorrefri");

                qtdsuco = resultSet.getInt("qtdsuco");
                valorsuco = resultSet.getDouble("valorsuco");
            }

            if (qtdxburger > 0){
                System.out.println();
                System.out.println("X-Burger (quantidade): " + qtdxburger);
                System.out.printf("Preço: R$%,.2f%n", valorxburger);
            }
            if (qtdxsalada > 0){
                System.out.println();
                System.out.println("X-Salada (quantidade): " + qtdxsalada);
                System.out.printf("Preço: R$%,.2f%n", valorxsalada);
            }
            if (qtdrefri > 0){
                System.out.println();
                System.out.println("Refrigerante (quantidade): " + qtdrefri);
                System.out.printf("Preço: R$%,.2f%n", valorrefri);
            }
            if (qtdsuco > 0){
                System.out.println();
                System.out.println("Suco (quantidade): " + qtdsuco);
                System.out.printf("Preço: R$%,.2f%n", valorsuco);
            }

            double valortotal = valorxburger + valorxsalada + valorrefri + valorsuco;

            String sql1 = "update carrinho set valortotal = " + valortotal + ";";
            statement.executeUpdate(sql1);

            System.out.println();
            System.out.printf("Valor total: R$%,.2f%n", valortotal);
            System.out.println("----------");
            System.out.println();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // método remover item
    String xburgerQtdSql = "qtdxburger";
    String xburgerValorSql = "valorxburger";
    String xsaladaQtdSql = "qtdxsalada";
    String xsaladaValorSql = "valorxsalada";
    String refriQtdSql = "qtdrefri";
    String refriValorSql = "valorrefri";
    String sucoQtdSql = "qtdsuco";
    String sucoValorSql = "valorsuco";

    public void removerItem(String quantidade, String valor){
        try{
            String sql1 = "update carrinho set " + quantidade + " = 0;";
            statement.executeUpdate(sql1);
            String sql2 = "update carrinho set " + valor + " = 0;";
            statement.executeUpdate(sql2);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método para limpar dados
    public void limparTudo(){
        removerItem(xburgerQtdSql,xburgerValorSql);
        removerItem(xsaladaQtdSql,xsaladaValorSql);
        removerItem(refriQtdSql,refriValorSql);
        removerItem(sucoQtdSql,sucoValorSql);
        try{
            String sql1 = "update carrinho set valortotal = 0;";
            statement.executeUpdate(sql1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método pra pegar o valor total
    public double valorTotal(){
        double valorTotal = 0;
        try {
            ResultSet resultSet = statement.executeQuery(verCarrinho);
            while (resultSet.next()) {
                valorTotal = resultSet.getDouble("valortotal");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return valorTotal;
    }
}
