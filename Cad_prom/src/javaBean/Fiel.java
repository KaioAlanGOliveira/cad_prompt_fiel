package javaBean;

public class Fiel {

	private String nome;
	private String idade;
	private double cpf;
	private String telefone;

	public Fiel() {}
	
	public Fiel(String nome, String idade, double cpf, String telefone) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(double cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
