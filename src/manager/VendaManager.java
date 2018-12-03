/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Cliente;
import entity.Funcionario;
import entity.Venda;
import entity.Pagamento;
import entity.ItemVenda;
import entity.Produto;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anapedroso
 */
public class VendaManager extends ConexaoBD {

    private Venda ven;

    public VendaManager() {
        super();
    }

    //cria um objeto Venda
    public void iniciarVenda(Cliente cli, Funcionario fun) {

        ven = new Venda(cli, fun);

    }

    public void iniciarVenda(Funcionario func) {
        ven = new Venda(func);
    }

    //add produto na lista de venda...
    public boolean adicionarProdutoVenda(Produto prod, int qtd) {
        // mas antes recebe a quantidade atual
        int qtdAtual = prod.getQtdEstoque();
        //verifica se a quantidade atual é maior ou igual a quantidade a ser vendida
        if (qtdAtual >= qtd) {
            //se sim, coloca o novo item de venda
            ItemVenda novo = new ItemVenda(qtd, prod);
            ven.adicionarProdutoVenda(novo);
            return true;
        } //se não, retorna false indicando que item não foi inserido
        else {
            return false;
        }

    }

    public double calcularValorTotal() {
        double preco = 0;

        LinkedList<ItemVenda> listaItem;
        listaItem = ven.getItemVenda();
        for (ItemVenda a : listaItem) {
            preco += a.getQuantidade() * a.getProduto().getPreco();
        }
        return preco;
    }

    public void removerProdutoVenda(Produto prod) {
        ItemVenda exclui = new ItemVenda();
        LinkedList<ItemVenda> aa = new LinkedList<ItemVenda>();

        for (ItemVenda a : ven.getItemVenda()) {
            if (a.getProduto().getCodigoBarras() == prod.getCodigoBarras()) {
                continue;
            } else {
                aa.add(a);
            }

        }
        ven.setItemVenda(aa);

    }

    // registra pagamento no banco e retorna se registrou
    public void registraPagamento(double valorVenda) {

        ven.setValor(valorVenda);
        Cliente cli = ven.getCliente();
        //registra novo pagamento 
        Pagamento pag = new Pagamento(valorVenda, "Dinheiro", cli, ven);
        ven.setData("2018-12-03");
    }

    public boolean gerarComprovante() {
        try {
            FileWriter arq = new FileWriter("Comprovante-de-Venda.txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf("\t\t\t\t--------------BRINQUE FELIZ S.A.--------------%n");
            String nomeCliente = ven.getCliente().getNome();
            gravarArq.printf("%nNome Cliente:");
            gravarArq.printf("%s%n", ven.getCliente().getNome());
            String nomeFuncionario = ven.getFuncionario().getNome();
            gravarArq.printf("nNome Funcionario:");
            gravarArq.printf("%s%n", nomeFuncionario);
            LinkedList<ItemVenda> lista = ven.getItemVenda();

            gravarArq.printf(" Qtd ||\t\t\tNome Produto\t\t\t||    id     || Preço Unitario%n");
            for (ItemVenda a : lista) {
                String q = "     ||";
                String n = "                                               ||";
                String i = "          ||";
                String aux = "";

                String nome = a.getProduto().getNomeProduto();
                n = nome + n.substring(nome.length());
                int id = a.getProduto().getCodigoBarras();
                aux = id + "";
                i = aux + i.substring(aux.length());
                int qtd = a.getQuantidade();
                aux = qtd + "";
                q = aux + q.substring(aux.length());
                double precoUnitario = a.getProduto().getPreco();
                double precoParcial = precoUnitario * qtd;
                gravarArq.printf("%s%s%s%f%n", q, n, i, precoUnitario);
                gravarArq.printf("  %d  *  %f   =           %f    %n", qtd, precoUnitario, precoParcial);
            }
            gravarArq.printf("%n\t\t\t\t\t-----------------------------------------------%n");
            gravarArq.printf("Forma de Pagamento-------------------------------------Dinheiro%n");
            gravarArq.printf("Total-----------------------------------------------------%f%n", ven.getValor());

            arq.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public LinkedList<ItemVenda> retornaLista() {
        LinkedList<ItemVenda> lista = ven.getItemVenda();
        return lista;
    }

    // busca produto dentro da venda iniciada e retorna se o produto existe ou não
    public boolean buscaProdutoLista(Produto prod) {
        LinkedList<ItemVenda> lista = ven.getItemVenda();
        boolean teste = false;
        for (ItemVenda a : lista) {
            if (a.getProduto().equals(prod)) {
                teste = true;
            }
        }
        return teste;

    }

    public boolean finalizarVenda() {
        System.out.println("finalizar em BD");
        // pega a quantidade de itens da venda
        LinkedList<ItemVenda> list = ven.getItemVenda();
        int quantidade = 0;
        for (ItemVenda a : list) {
            quantidade += a.getQuantidade();
            System.out.println(quantidade);
        }

        boolean teste;
        try {
            //insere venda sem id(id é o banco q coloca)
            Statement statement = conn.createStatement();
            System.out.println(conn.isClosed());
            String sql = "INSERT INTO brinquefelizschema.venda (matriculafuncionario, idcliente, valor, data , qtdproduto)"
                    + " VALUES (" + ven.getFuncionario().getMatricula() + ", " + ven.getCliente().getIdCliente() + " ," + ven.getValor() + " ,'" + ven.getData() + "'," + quantidade + ")";

            System.out.println(sql);

            int r = statement.executeUpdate(sql);
            System.out.println(r);

            // seleciona idVenda
            String sqlidVenda = "SELECT idVenda "
                    + "FROM brinquefelizschema.venda"
                    + " WHERE matriculaFuncionario = " + ven.getFuncionario().getMatricula()
                    + "AND idCliente= " + ven.getCliente().getIdCliente()
                   // + "AND valor= " + ven.getValor()
                    + "AND qtdProduto= " + quantidade;

            System.out.println(sqlidVenda);
           
            ResultSet resultado = statement.executeQuery(sqlidVenda);
            System.out.println(resultado.toString());
            int idVenda;
            while (resultado.next()) {
                idVenda = resultado.getInt(1);
                ven.setIdVenda(idVenda);
                System.out.println(idVenda);
            }
            // insere pagamento no banco de dados
            String sqlPagamento = "INSERT INTO brinquefelizschema.pagamento (idVenda, valor, tipoPgto) VALUES ('" + ven.getIdVenda() + "', " + ven.getValor() + " , 'Dinheiro')";
            statement.executeUpdate(sqlPagamento);
            System.out.println(sqlPagamento);

            //insere cada item da lista no banco de dados
            for (ItemVenda a : list) {
                System.out.println("entrou no for");
                String sqlItem = "INSERT INTO brinquefelizschema.itemvenda (idvenda, codigobarras, quantidade) VALUES (" + ven.getIdVenda() + "," + a.getProduto().getCodigoBarras() + " , " + a.getQuantidade() + ")";

                statement.executeUpdate(sqlItem);
                System.out.println(sqlItem);
            }

            teste = true;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueManager.class.getName()).log(Level.SEVERE, null, ex);
            teste = false;
        }
        return teste;
    }

    public void cancelarVenda() {
        ven = null;
    }

}
