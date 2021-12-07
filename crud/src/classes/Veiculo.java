package classes;
public class Veiculo {
	
	//ATRIBUTOS
	private int id ;
    private String Placa ;
    private String Marca;
    private double KmPorLitro;
	
	
	
	//CONSTRUTOR
	public Veiculo(int id, String Placa, String Marca, double KmPorLitro) {
		this.id = id;
		this.Placa = Placa;
        this.Marca = Marca;
        this.KmPorLitro = KmPorLitro;
	}
	
	public Veiculo(String Placa, String Marca, double KmPorLitro) {
		this.Placa = Placa;
        this.Marca = Marca;
        this.KmPorLitro = KmPorLitro;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return Placa;
	}
	
	public void setPlaca(String Placa) {
		this.Placa = Placa;
	}
	
	public String getMarca() {
		return Marca;
	}


	public double getKmPorLitro() {
		return KmPorLitro;
	}


	public void setKmPorLitro(double kmPorLitro) {
		KmPorLitro = kmPorLitro;
	}
	
	@Override
	public String toString() {
		return this.getMarca();
	}
}