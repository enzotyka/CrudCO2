package classes;
public class Chamado {
	
	//ATRIBUTOS
	private int id;
	private double DistanciaKm;
	private Funcionario funcionario;
	private Veiculo veiculo;
	//CONSTRUTOR
	public Chamado(double DistanciaKm) {
		this.DistanciaKm = DistanciaKm;
	}

	
    public Chamado(double DistanciaKm, Funcionario funcionario, Veiculo veiculo) {
    	this.DistanciaKm = DistanciaKm;
    	this.funcionario = funcionario;
    	this.veiculo = veiculo;
	}


	public double getDistanciaKm() {
		return DistanciaKm;
	}
	
	public void setDistanciaKm(double DistanciaKm) {
		this.DistanciaKm = DistanciaKm;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}