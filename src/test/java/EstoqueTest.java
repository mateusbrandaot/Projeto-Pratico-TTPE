import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ttpe.projeto.exception.DescricaoEmBrancoException;
import ttpe.projeto.exception.ProdutoInvalidoException;
import ttpe.projeto.exception.ValorInvalidoException;
import ttpe.projeto.model.Empresa;
import ttpe.projeto.model.Estoque;
import ttpe.projeto.model.Fornecedor;
import ttpe.projeto.model.Produto;

public class EstoqueTest {
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
   
    private Estoque estoque;

    @BeforeEach
    void setUp() throws DescricaoEmBrancoException, ValorInvalidoException {
        estoque = new Estoque();
        estoque.adicionarProduto(new Produto(id, nomePadrao, descricaoPadrao, codigoBarraPadrao, precoPadrao, qtdAtualPadrao, empresaPadrao, fornecedorPadrao, qtdMinimaPadrao, dataAtualPadrao)); // Exemplo
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void testGetProdutoPorId(String id) throws ProdutoInvalidoException {
        if (id.equals("2")) {
            Assertions.assertThrows(ProdutoInvalidoException.class, () -> {
                estoque.getProdutoPorId(id);
            });
        } else {
            Produto produto = estoque.getProdutoPorId(id);
            Assertions.assertNotNull(produto);
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"produto teste", "produto teste inexistente"})
    void testGetProdutoPorNome(String nome) throws ProdutoInvalidoException {
        if (nome.equals("produto teste inexistente")) {
            Assertions.assertThrows(ProdutoInvalidoException.class, () -> {
                estoque.getProdutoPorNome(nome);
            });
        } else {
            Produto produto = estoque.getProdutoPorId(id);
            Assertions.assertNotNull(produto);
        }
    }
   
    @ParameterizedTest
    @ValueSource(strings = {"00025163", "00000000"})
    void testGetProdutoPorCodigoBarra(String codigoBarra) throws ProdutoInvalidoException {
        if (codigoBarra.equals("00000000")) {
            Assertions.assertThrows(ProdutoInvalidoException.class, () -> {
                estoque.getProdutoPorCodigoBarra(codigoBarra);
            });
        } else {
            Produto produto = estoque.getProdutoPorId(id);
            Assertions.assertNotNull(produto);
        }
    }
}
