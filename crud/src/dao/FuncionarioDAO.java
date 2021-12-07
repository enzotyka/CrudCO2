package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Funcionario;
import classes.Veiculo;

public class FuncionarioDAO {
	
	public static boolean cadastrar(Funcionario func) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "INSERT INTO Funcionario (cpf, nome)"
					+"VALUES (?, ?)";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setString(1, func.getCpf());
			pst.setString(2, func.getNome());
						
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static ResultSet listarFuncionarios() {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM funcionario order by id desc";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {		
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de funcionarios.");
			return null;
		}
	}
	
	public static ResultSet listarFuncionarios(String nome) {
		Database db = new Database();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM funcionario WHERE nome like '%"+nome+"%' order by id desc";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		
		try {
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("erro na obetenção de funcionarios.");
			System.out.println(e);
			return null;
		}
	}
	
	
	public static boolean editarFuncionario(String id, String novoNome, String novoCPF) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "UPDATE funcionario SET (cpf, nome) = (?, ?) WHERE id = ?";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		
		try {
			pst.setString(1, novoNome);
			pst.setString(2, novoCPF);
			pst.setInt(3, Integer.parseInt(id));
			succes = (pst.executeUpdate() >0) ? true : false;
			
			return succes;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean excluirFuncionario(String id) {
		Database db = new Database();
		boolean succes = false;
		
		String sql = "DELETE FROM funcionario WHERE id = ?";
		
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
	
	public List<Funcionario> listarFuncionariosLS(){
		Database db = new Database();
		ResultSet rs = null;
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		
		String sql = "SELECT * FROM funcionario ORDER BY nome";
		
		PreparedStatement pst = (PreparedStatement) db.getPreparedStatement(sql);
		
		try {
			rs = pst.executeQuery();
			while(rs.next()) {
				Funcionario func = new Funcionario(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"));
				
				listaFuncionarios.add(func);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listaFuncionarios;
	}
}
