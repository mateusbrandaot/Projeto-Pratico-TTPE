import java.util.Date;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
	private Fornecedor fornecedorPadrao = new Fornecedor(1, "fornecedor test", "6198460585", "endere�o teste");
	private int qtdMinimaPadrao = 30;
	private Date dataAtualPadrao = new Date();

	

	private GerenciadorEstoqueService service = new GerenciadorEstoqueService();

	
	@Test
	public void testRegistrarTransacao()
			throws Exception {
		String idProduto = "1";
		int quantidade = 5;
		String tipoTransacao = "Venda";
		Produto produto = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao,
				qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
		Estoque estoque  = new Estoque();
		estoque.adicionarProduto(produto);
		boolean result = service.registrarTransacao(id, quantidade, tipoTransacao, empresaPadrao, empresaPadrao, estoque);
		Assertions.assertEquals(true, result);
	}
	
	 private static Stream<Arguments> registrarTransacaoArguments() {
	        return Stream.of(
	            Arguments.of("1", 5, "Venda", true),
	            Arguments.of("2", -1, "Venda", false), // Quantidade inv�lida
	            Arguments.of("inexistente", 5, "Venda", false), // ID de produto inexistente
	            Arguments.of("1", 5, "Recebimento", true),
	            Arguments.of("1", 5, "Devolu��o", true),
	            Arguments.of("1", 5, "Transferencia", true),
	            Arguments.of("1", 5, "TipoInvalido", false) // Tipo de transa��o inv�lido
	        );
	    }

	    @ParameterizedTest
	    @MethodSource("registrarTransacaoArguments")
	    void testRegistrarTransacaoParametrizado(String idProduto, int quantidade, String tipoTransacao, boolean resultadoEsperado) throws Exception {
	        Produto produtoMock = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao,
					qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
	        Estoque estoque  = new Estoque();
	        Empresa empresaDestino = new Empresa(2, "35737451000290", "FILIAL", "rua portugal");
	        estoque.adicionarProduto(produtoMock);
	        boolean resultado = service.registrarTransacao(idProduto, quantidade, tipoTransacao, empresaPadrao, empresaDestino, estoque);
	        Assertions.assertEquals(resultadoEsperado, resultado);
	    }
	
}
