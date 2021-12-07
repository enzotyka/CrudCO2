package framesManagers;

import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Chamado;
import classes.Funcionario;
import classes.Veiculo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.sql.ResultSet;

import dao.ChamadoDao;
import dao.Database;
import dao.FuncionarioDAO;
import dao.VeiculoDao;
import net.proteanit.sql.DbUtils;

public class Metodos {

	Database db = new Database();
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	public void fillDataJListFuncionario(JList jlist) {
		try {
			DefaultListModel model = new DefaultListModel();
			conn = db.connect();
			stmt = (Statement) conn.createStatement();
			rs = (ResultSet) stmt.executeQuery("SELECT * FROM Funcionario");
			while (rs.next()) {
				String funcionario = rs.getString("nome");
				model.addElement(funcionario);
			}
			jlist.setModel(model);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
	
	public void fillDataJTableFuncionario(JTable jtable){
		ResultSet rs = FuncionarioDAO.listarFuncionarios();
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void fillDataJTableFuncionario(JTable jtable, String nome) throws SQLException {
		ResultSet rs = FuncionarioDAO.listarFuncionarios(nome);
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void fillDataJTableVeiculo(JTable jtable){
		ResultSet rs = VeiculoDao.listarVeiculosRS();
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void fillDataJTableVeiculo(JTable jtable, String marca) throws SQLException {
		ResultSet rs = VeiculoDao.listarVeiculosRS(marca);
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void fillDataJTableChamado(JTable jtable){
		ResultSet rs = ChamadoDao.listarChamados();
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void fillDataJTableChamado(JTable jtable, String id){
		ResultSet rs = ChamadoDao.listarChamados(Integer.parseInt(id));
		jtable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public boolean editaFuncionario(String id, String cpf, String nome) {
		return FuncionarioDAO.editarFuncionario(id, cpf, nome);
	}
	
	public boolean editaVeiculo(String id, String placa, String marca, String autonomia) {
		return VeiculoDao.editarVeiculo(id, placa, marca, autonomia);
	}
	
	public boolean excluiFuncionario(String id) {
		return FuncionarioDAO.excluirFuncionario(id);
	}
	
	public boolean excluiVeiculo(String id) {
		return VeiculoDao.excluirVeiculo(id);
	}
	
	public boolean cadastraFuncionario(Funcionario func) {
		return(FuncionarioDAO.cadastrar(func));
	}
	
	public String calculaEmissaoCO2(double distancia, double autonomia) {
		double gasolinaGasta = distancia / autonomia;
		double co2Emitido = gasolinaGasta*0.73*0.75*3.7;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		return numberFormat.format(co2Emitido);
	}
	
	public String calculaEmissaoCO2Total() {
		double gasolinaGasta = 0;
		double co2Emitido = 0;
		try {
			ResultSet rs = ChamadoDao.exibirChamados();
			while (rs.next()) {
				gasolinaGasta = rs.getDouble("distancia")/rs.getDouble("autonomiaVeic");
				co2Emitido += gasolinaGasta*0.73*0.75*3.7;
			}
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			return numberFormat.format(co2Emitido);
		} catch (Exception e) {
			return null;
		}
		
		
	}
}
