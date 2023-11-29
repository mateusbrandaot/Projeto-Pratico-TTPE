package ttpe.projeto.service;

import java.util.Date;

import ttpe.projeto.exception.DescricaoEmBrancoException;
import ttpe.projeto.exception.ProdutoInvalidoException;
import ttpe.projeto.exception.ValorInvalidoException;
import ttpe.projeto.model.Empresa;
import ttpe.projeto.model.Estoque;
import ttpe.projeto.model.Produto;
import ttpe.projeto.model.Transacao;

public class GerenciadorEstoqueService {
	
	private Estoque estoque;

	public void registrarTransacao(String idProduto, int quantidade, String tipoTransacao, Empresa empresaOrigem,
			Empresa empresaDestino) throws DescricaoEmBrancoException, ValorInvalidoException, ProdutoInvalidoException {
		
		Produto produto = estoque.getProdutoPorId(idProduto);
		Transacao transacao = new Transacao(produto, quantidade, new Date(), tipoTransacao);
		estoque.adicionarTransacao(transacao);
	}
}
