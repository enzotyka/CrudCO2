package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Veiculo;


public class VeiculoDao {

	public static boolean cadastrar(Veiculo veiculo){
		Database db = new Database();
		boolean succes = false;
		
		String sql = "INSERT INTO Veiculo (placa, marca, kmporlitro)"
					+"VALUES (?, ?, ?)";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);

		try {
			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getMarca());
			pst.setDouble(3, veiculo.getKmPorLitro());
			
			succes = (pst.executeUpdate() >0) ? true : false;
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public List<Veiculo> listarVeiculos(){
		Database db = new Database();
		boolean succes = false;
		ResultSet rs = null;
		List<Veiculo> listaVeiculos = new ArrayList<>();
		
		String sql = "SELECT * FROM veiculo order by marca";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		try {
			rs = pst.executeQuery();
			while(rs.next()) {
				Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("placa"), rs.getString("marca"), rs.getDouble("kmporlitro"));
				
				listaVeiculos.add(veiculo);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listaVeiculos;
	}
	
	public static ResultSet listarVeiculosRS() {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM veiculo order by id desc";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de veiculos.");
			return null;
		}
	}
	
	public static ResultSet listarVeiculosRS(String marca) {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM veiculo where marca like '%"+marca+"%' order by id desc";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de veiculos.");
			return null;
		}
	}
	
	public static boolean excluirVeiculo(String id) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "DELETE FROM veiculo WHERE id = ?";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setInt(1, Integer.parseInt(id));
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean editarVeiculo(String id, String placa, String marca, String autonomia) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "UPDATE veiculo SET (placa, marca, kmporlitro) = (?, ?, ?) WHERE id = ?";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setString(1, placa);
			pst.setString(2, marca);
			pst.setDouble(3, Double.parseDouble(autonomia));
			pst.setInt(4, Integer.parseInt(id));
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
