import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ttpe.projeto.model.Empresa;
import ttpe.projeto.model.Estoque;
import ttpe.projeto.model.Fornecedor;
import ttpe.projeto.model.Produto;
import ttpe.projeto.service.GerenciadorEstoqueService;

public class GerenciadorEstoqueServiceTest {


	private String id = "1";
	private String nomePadrao = "produto teste";
	private String descricaoPadrao = "Parafuso Phillips 6Mm X 41Mm";
	private String codigoBarraPadrao = "00025163";
	private double precoPadrao = 10.5;
	private int qtdAtualPadrao = 5;
	private Empresa empresaPadrao = new Empresa(1, "35737451000190", "MATRIZ", "rua portugal");
	private Fornecedor fornecedorPadrao = new Fornecedor(1, "fornecedor test", "6198460585", "endereço teste");
	private int qtdMinimaPadrao = 30;
	private Date dataAtualPadrao = new Date();

	private Estoque estoque  = new Estoque();

	private GerenciadorEstoqueService service = new GerenciadorEstoqueService();

	
	@Test
	public void testRegistrarTransacao()
			throws Exception {
		String idProduto = "1";
		int quantidade = 5;
		String tipoTransacao = "Venda";
		Produto produto = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao,
				qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
		estoque.adicionarProduto(produto);
		boolean result = service.registrarTransacao(id, quantidade, tipoTransacao, empresaPadrao, empresaPadrao, estoque);
		Assertions.assertEquals(true, result);
	}
	
}
