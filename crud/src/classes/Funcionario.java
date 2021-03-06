package classes;

public class Funcionario {
	
	private int id;
	private String cpf;
	private String nome;
	
	//CONSTRUTOR
	public Funcionario(int id, String cpf, String nome) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Funcionario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

}
