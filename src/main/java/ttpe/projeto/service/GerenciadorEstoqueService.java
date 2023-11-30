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
			Produto produto = estoque.getProdutoPorId(idProduto);
			if (produto == null) {
				throw new Exception("Produto não encontrado.");
			}
			Date now = new Date();
			Transacao transacao = new Transacao(produto, quantidade, now, tipoTransacao);
			if (transacao.getQuantidade() < 0) {
				throw new ValorInvalidoException("quantidade transacao inválida.");
			}
			
			estoque.adicionarTransacao(transacao);

			switch (tipoTransacao) {
			case "Venda":
				transacaoVendaProduto(produto, quantidade);
				break;
			case "Recebimento":
				transacaoRecebimentoProduto(produto, quantidade);
				break;
			case "Devolução":
				transacaoDevolucaooProduto(produto, quantidade);
				break;
			case "Transferencia":
				transacaoTransferenciaProduto(produto, empresaOrigem, empresaDestino, quantidade);
				break;
			default:

				System.out.println("Tipo de transação não reconhecido: " + tipoTransacao);
				break;
			}
			return true;
		} catch (ProdutoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void transacaoVendaProduto(Produto produto, int quantidade) {
		produto.removerEstoque(quantidade);
	}

	public void transacaoRecebimentoProduto(Produto produto, int quantidade) {
		produto.adicionarEstoque(quantidade);
	}

	public void transacaoDevolucaooProduto(Produto produto, int quantidade) {
		produto.adicionarEstoque(quantidade);
	}

	public void transacaoTransferenciaProduto(Produto produto, Empresa empresaOrigem, Empresa empresaDestino,
			int quantidade) throws Exception {

		if (produto == null) {
			throw new Exception("Produto não encontrado.");
		}

		if (produto.getEmpresaDetentora().getId() != empresaOrigem.getId()) {
			throw new Exception("O produto não pertence à empresa de origem.");
		}

		if (produto.getQuantidadeEmEstoque() < quantidade) {
			throw new Exception("Quantidade em estoque insuficiente para transferência.");
		}

		produto.setEmpresaDetentora(empresaDestino);

	}
}
