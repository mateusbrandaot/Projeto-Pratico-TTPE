package ttpe.projeto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import ttpe.projeto.exception.ProdutoInvalidoException;

public class Estoque {

    private Map<String, Produto> produtos = new HashMap<>();
   
    private List<Transacao> transacoes = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    public  Map<String, Produto> getProdutos(String produtoId) {
        return produtos;
    }
    
    public void adicionarTransacao (Transacao transacao) {
    	transacoes.add(transacao);
    }
    
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
 
    public int getQtdProdutoEmEstoque (String idproduto) {
    	Produto produto = produtos.get(idproduto);
    	int qtd = produto.getQuantidadeEmEstoque();
    	return qtd;
    }
    
    public Double QtdValorMonetarioEmEstoqueProduto (String idproduto) {
    	Produto produto = produtos.get(idproduto);
    	Double valor = produto.getQuantidadeEmEstoque() * produto.getPreco();
    	return valor;
    }
    
    public Produto getProdutoPorId(String id) throws ProdutoInvalidoException {
    	if(produtos.get(id) != null) {
    		return produtos.get(id);
    	} else {
    		throw new ProdutoInvalidoException("Produto não econtrado.");
    	} 
    }
    
    public Produto getProdutoPorNome(String nome) throws ProdutoInvalidoException {
    	Optional<Produto> produtoEncontrado = produtos.values().stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst();

        if(produtoEncontrado.isPresent()) {
        	return produtoEncontrado.get();
        } else {
        	throw new ProdutoInvalidoException("Produto não econtrado.");
        }
    }
    
    public Produto getProdutoPorCodigoBarra(String codigoBarra) throws ProdutoInvalidoException {
    	Optional<Produto> produtoEncontrado = produtos.values().stream()
                .filter(p -> p.getCodigoBarra().equals(codigoBarra))
                .findFirst();

        if(produtoEncontrado.isPresent()) {
        	return produtoEncontrado.get();
        } else {
        	throw new ProdutoInvalidoException("Produto não econtrado.");
        }

    }
}

