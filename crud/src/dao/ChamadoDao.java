package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Chamado;
import classes.Funcionario;
import classes.Veiculo;

public class ChamadoDao {
	
	public boolean cadastrar(Chamado chamado) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "INSERT INTO chamado (distanciakm, funcionario, veiculo)"
					+"VALUES (?, ?, ?)";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setDouble(1, chamado.getDistanciaKm());
			pst.setInt(2, chamado.getFuncionario().getId());
			pst.setInt(3, chamado.getVeiculo().getId());

			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static ResultSet listarChamados() {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT C.id, C.distanciakm AS autonomia, F.nome AS funcionario, V.marca AS veiculo "
				+ " FROM chamado C "
				+ " JOIN funcionario F ON F.id = C.funcionario "
				+ " JOIN veiculo V on V.id = C.veiculo ";
				
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de chamados.");
			return null;
		}
	}
	
	public static ResultSet listarChamados(int id) {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT C.id, C.distanciakm AS distancia, F.nome AS funcionario, V.marca AS veiculo "
				+ " FROM chamado C "
				+ " JOIN funcionario F ON F.id = C.funcionario "
				+ " JOIN veiculo V on V.id = C.veiculo "
				+ " where C.id = ?";
				
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			pst.setInt(1, id);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de chamados.");
			return null;
		}
	}
	
	public boolean excluirChamado(int id) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "DELETE FROM chamado WHERE id = ?";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setInt(1, id);
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean editarVeiculo(String id, double novaDistancia, Funcionario novoFuncionario, Veiculo novoVeiculo) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "UPDATE chamado SET (distanciakm, funcionario, veiculo) = (?, ?, ?) WHERE id = ?";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setDouble(1, novaDistancia);
			pst.setInt(2, novoFuncionario.getId());
			pst.setInt(3, novoVeiculo.getId());
			pst.setInt(4, Integer.parseInt(id));
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public ResultSet exibirChamado(int id){
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT C.id, C.distanciakm AS distancia, "
				+ " F.id AS codFunc, F.nome AS nomeFunc, F.cpf AS cpfFunc, "
				+ " V.id AS codVeic, V.marca AS modeloVeic, V.kmporlitro AS autonomiaVeic "
				+ " FROM chamado C "
				+ " JOIN funcionario F ON F.id = C.funcionario "
				+ " JOIN veiculo V on V.id = C.veiculo "
				+ " where C.id = ?";
				
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			pst.setInt(1, id);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de chamados.");
			return null;
		}
	}
	
	public static ResultSet exibirChamados(){
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT C.id, C.distanciakm AS distancia, "
				+ " V.kmporlitro AS autonomiaVeic "
				+ " FROM chamado C "
				+ " JOIN veiculo V on V.id = C.veiculo";
				
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de chamados.");
			return null;
		}
	}
}
