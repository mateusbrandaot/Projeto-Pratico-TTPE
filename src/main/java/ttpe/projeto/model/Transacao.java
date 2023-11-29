package ttpe.projeto.model;

import java.util.Date;

public class Transacao {

	    private Produto produto;
	    
	    private int quantidade;
	    
	    private Date dataTransacao;
	    
	    private String tipoTransacao; // Ex: "Venda", "Recebimento", "Devolução", etc.
	    
	    
		public Transacao(Produto produto, int quantidade, Date dataTransacao, String tipoTransacao) {
			
			this.produto = produto;
			this.quantidade = quantidade;
			this.dataTransacao = dataTransacao;
			this.tipoTransacao = tipoTransacao;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public Date getDataTransacao() {
			return dataTransacao;
		}

		public void setDataTransacao(Date dataTransacao) {
			this.dataTransacao = dataTransacao;
		}

		public String getTipoTransacao() {
			return tipoTransacao;
		}

		public void setTipoTransacao(String tipoTransacao) {
			this.tipoTransacao = tipoTransacao;
		}

	    

	
}
