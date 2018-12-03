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

        Collection<ItemVenda> listaItem;
        listaItem = ven.getItemVenda();
        for (ItemVenda a : listaItem) {
            preco += a.getQuantidade() * a.getProduto().getPreco();
        }
        return preco;
    }

    public void removerProdutoVenda(Produto prod) {
        Collection<ItemVenda> novaLista;
        novaLista = ven.getItemVenda();
        novaLista.remove(prod);
        ven.setItemVenda(novaLista);
    }
    // registra pagamento no banco e retorna se registrou
    public void registraPagamento(double valorVenda) {
        ven.setValor(valorVenda);
        Cliente cli = ven.getCliente();
        //registra novo pagamento 
        Pagamento pag = new Pagamento(valorVenda, "Dinheiro", cli, ven);
        ven.setPagamento(pag);
        Calendar cal= new GregorianCalendar();
        String data =cal.getTime()+"";
        ven.setData(data.substring(0, 9));
    }

    public boolean gerarComprovante() {
        try {
            FileWriter arq = new FileWriter("Comprovante-de-Venda.txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf("\t\t\t\t--------------BRINQUE FELIZ S.A.--------------%n");
            String nomeCliente = ven.getCliente().getNome();
            gravarArq.printf("%nNome Cliente:");
            gravarArq.printf("%d%n", nomeCliente);
            String nomeFuncionario = ven.getFuncionario().getNome();
            gravarArq.printf("%nNome Funcionario:");
            gravarArq.printf("%d%n", nomeFuncionario);
            Collection<ItemVenda> lista = ven.getItemVenda();
            
            gravarArq.printf(" Qtd ||\t\t\tNome Produto\t\t\t||    id     || Preço Unitario%n");
            for (ItemVenda a : lista) {
                String q="     ||";
                String n="                                               ||";
                String i= "          ||";
                String aux="";
                String nome = a.getProduto().getNomeProduto();
                n=nome+n.substring(nome.length());
                int id = a.getProduto().getCodigoBarras();
                aux=id+"";
                i=aux+i.substring(aux.length());
                int qtd = a.getQuantidade();
                aux=qtd+"";
                q=aux+q.substring(aux.length());
                double precoUnitario = a.getProduto().getPreco();
                double precoParcial = precoUnitario * qtd;
                gravarArq.printf("%s%s%s%f%n", q, n, i, precoUnitario);
                gravarArq.printf("  %d  *  %f   =           %f    %n", qtd, precoUnitario, precoParcial);
            }
            gravarArq.printf("%n\t\t\t\t\t-----------------------------------------------%n");
            gravarArq.printf("Forma de Pagamento-------------------------------------%f%n", ven.getPagamento().getTipoPagamento());
            gravarArq.printf("Total-----------------------------------------------------%f%n", ven.getValor());

            arq.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean finalizarVenda() {
        // pega a quantidade de itens da venda
        Collection<ItemVenda> list= ven.getItemVenda();
        int quantidade = 0;
        for(ItemVenda a: list) quantidade+=a.getQuantidade();

        boolean teste = true;
        try{
            //insere venda sem id(id é o banco q coloca)
           Statement statement = conn.createStatement();
            String sql = "INSERT INTO venda(matriculaFuncionario, idCliente, valor, valor, data,qtdProduto)"
        +" VALUES ("+ven.getFuncionario().getMatricula()+", "+ven.getCliente().getIdCliente()+" ,"+ ven.getValor()+" ,"+ven.getData()+","+quantidade+")";
            statement.executeUpdate(sql);
            
            
            
            // seleciona idVenda
            String sqlidVenda="SELECT idVenda "
                             + "FROM venda"
                            + " WHERE matriculaFuncionario ="+ven.getFuncionario().getMatricula()
                            +"AND idCliente="+ven.getCliente().getIdCliente()
                            + "AND valor="+ven.getValor()+
                                "AND data="+ven.getData()+
                             "AND qtdProduto="+quantidade;
       
           ResultSet resultado = statement.executeQuery(sqlidVenda);
           int idVenda = resultado.getInt("idVenda");
           ven.setIdVenda(idVenda);
           
            // insere pagamento no banco de dados
            String sqlPagamento = "INSERT INTO pagamento(idVenda, valor, tipoPgto) VALUES (\'"+ven.getIdVenda()+"\', "+ven.getValor()+" , \'Dinheiro\')";
            statement.executeUpdate(sqlPagamento);
          
            
            //insere cada item da lista no banco de dados
            for(ItemVenda a: list){
                String sqlItem ="INSERT INTO ItemDeVenda(idVenda, codigoBarras, quantidade) VALUES ("+ven.getIdVenda()+","+a.getProduto().getCodigoBarras()+" , "+a.getQuantidade()+ ")";
            statement.executeUpdate(sqlItem);
            }
            
           
            
            teste= true;
            //sei la q q coloca nesse cath
           } catch (SQLException ex) {
              
              teste= false;
          }
        return false;
    }

    public void cancelarVenda() {
        ven=null;
    }

}