import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import ttpe.projeto.exception.DescricaoEmBrancoException;
import ttpe.projeto.exception.ValorInvalidoException;
import ttpe.projeto.model.Empresa;
import ttpe.projeto.model.Fornecedor;
import ttpe.projeto.model.Produto;

class ProdutoTest {

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
 

 @Test
 public void deveLancarExcecaoParaDescricaoEmBranco() {
     Assertions.assertThrows(DescricaoEmBrancoException.class, () -> {
         new Produto(id, "", descricaoPadrao, codigoBarraPadrao, precoPadrao, qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
     });
 }

 @Test
 public void deveLancarExcecaoParaValorInvalido() {
     Assertions.assertThrows(ValorInvalidoException.class, () -> {
         new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, -1.0, qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
     });
 }
	
 @Test
 public void deveCadastrarProdutoValido() {
     try {
     	Produto produto = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao, qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
         assertNotNull(produto);
     } catch (DescricaoEmBrancoException | ValorInvalidoException e) {
         fail("Não deveria lançar exceção para dados válidos.");
     }
 }
 
 @ParameterizedTest
 @ValueSource(ints = {1, 5, 10}) 
 void testAdicionarEstoque(int quantidade) throws DescricaoEmBrancoException, ValorInvalidoException {
     Produto produto = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao, quantidade, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
     int estoqueInicial = produto.getQuantidadeEmEstoque();
     
     produto.adicionarEstoque(quantidade);

     Assertions.assertEquals(estoqueInicial + quantidade, produto.getQuantidadeEmEstoque());
 }
 

 private static Stream<Arguments> removerEstoqueArguments() {
     return Stream.of(
         Arguments.of(5, 3, true),  
         Arguments.of(5, 5, true),
         Arguments.of(5, 6, false)
     );
 }

 @ParameterizedTest
 @MethodSource("removerEstoqueArguments")
 void testRemoverEstoque(int estoqueInicial, int quantidadeARemover, boolean resultadoEsperado) throws Exception {
 	Produto produto = new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao, estoqueInicial, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao);
     boolean resultado = produto.removerEstoque(quantidadeARemover);
     Assertions.assertEquals(resultadoEsperado, resultado);
 }
 
}
