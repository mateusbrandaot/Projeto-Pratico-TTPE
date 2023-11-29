package ttpe.projeto.model;

public class Fornecedor {
	
	private int id;
	
	private String nome;
	
	private String contato;
	
	private String endereco;
	
	
	public Fornecedor(int id, String nome, String contato, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	
}
