import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import ttpe.projeto.exception.DescricaoEmBrancoException;
import ttpe.projeto.exception.ProdutoInvalidoException;
import ttpe.projeto.exception.ValorInvalidoException;
import ttpe.projeto.model.Estoque;
import ttpe.projeto.service.GerenciadorEstoqueService;

public class GerenciadorEstoqueServiceTest {

	   private Estoque estoque = new Estoque(); // Ou um mock, se apropriado
	   private GerenciadorEstoqueService service = new GerenciadorEstoqueService();

	    @Test
	    public void testRegistrarTransacaoFalha() throws DescricaoEmBrancoException, ValorInvalidoException, ProdutoInvalidoException {
	        String idProduto = "1";
	        int quantidade = 5;
	        String tipoTransacao = "Venda";
	        service.registrarTransacao(idProduto, quantidade, tipoTransacao, null, null);
	      
	    }
	
}
