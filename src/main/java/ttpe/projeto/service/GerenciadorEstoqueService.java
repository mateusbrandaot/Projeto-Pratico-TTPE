package ttpe.projeto.service;

import java.util.Date;

import ttpe.projeto.exception.ProdutoInvalidoException;
import ttpe.projeto.exception.ValorInvalidoException;
import ttpe.projeto.model.Empresa;
import ttpe.projeto.model.Estoque;
import ttpe.projeto.model.Produto;
import ttpe.projeto.model.Transacao;

public class GerenciadorEstoqueService {
	
	public boolean registrarTransacao(String idProduto, int quantidade, String tipoTransacao, Empresa empresaOrigem,
			Empresa empresaDestino, Estoque estoque) throws Exception {
		try {
			Produto produto;
			produto = estoque.getProdutoPorId(idProduto);
			if (produto == null) {
				throw new Exception("Produto não encontrado.");
			}
			Date now = new Date();
			Transacao transacao = new Transacao(produto, quantidade, now, tipoTransacao);
			if (transacao.getQuantidade() < 0) {
				throw new ValorInvalidoException("quantidade transacao inválida.");
			}
			estoque.adicionarTransacao(transacao);	
			return true;
		} catch (ProdutoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
