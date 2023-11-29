package ttpe.projeto.model;

import java.util.Date;

import ttpe.projeto.exception.DescricaoEmBrancoException;
import ttpe.projeto.exception.ValorInvalidoException;

public class Produto {
    
	private String id;
    
	private String nome;
    
	private String descricao;
	
	private String codigoBarra;
    
	private double preco;
    
	private int quantidadeEmEstoque;
	
	private Empresa empresaDetentora;

	private Fornecedor fornecedor;
	
	private int QtdMinimaEstoque;
	
	private Date validade ;
	
  
	public Produto(String id, String nome, String descricao, String codigoBarra, 
	             double preco, int quantidadeEmEstoque, 
	             Empresa empresaDetentora, Fornecedor fornecedor, int QtdMinimaEstoque, Date validade) 
	             throws DescricaoEmBrancoException, ValorInvalidoException {
	  if (nome == null || nome.trim().isEmpty() ||
	      codigoBarra == null || codigoBarra.trim().isEmpty() ||
	      descricao == null || descricao.trim().isEmpty()) {
	      throw new DescricaoEmBrancoException("Nome, código de barras ou descrição não podem estar em branco.");
	  }
	  
	  if (preco <= 0 || quantidadeEmEstoque <= 0) {
	      throw new ValorInvalidoException("Preço e quantidade em estoque devem ser maiores que zero.");
	  }

	  this.id = id;
	  this.nome = nome;
	  this.descricao = descricao;
	  this.codigoBarra = codigoBarra;
	  this.preco = preco;
	  this.quantidadeEmEstoque = quantidadeEmEstoque;
	  this.empresaDetentora = empresaDetentora;
	  this.fornecedor = fornecedor;
	  this.QtdMinimaEstoque = QtdMinimaEstoque;
	  this.validade = validade;
	}
    
	
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCodigoBarra() {
		return codigoBarra;
	}


	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}


	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}


	public Empresa getEmpresaDetentora() {
		return empresaDetentora;
	}


	public void setEmpresaDetentora(Empresa empresaDetentora) {
		this.empresaDetentora = empresaDetentora;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getQtdMinimaEstoque() {
		return QtdMinimaEstoque;
	}
	

	public void setQtdMinimaEstoque(int qtdMinimaEstoque) {
		QtdMinimaEstoque = qtdMinimaEstoque;
	}
	

	public Date getValidade() {
		return validade;
	}
	

	public void setValidade(Date validade) {
		this.validade = validade;
	}


    public void adicionarEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= quantidade;
            return true;
        } else {
            return false;
        }
    }
    
}
