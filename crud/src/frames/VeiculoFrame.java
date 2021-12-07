package frames;
//import statement
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Funcionario;
import classes.Veiculo;
import dao.FuncionarioDAO;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import dao.VeiculoDao;
import framesManagers.Metodos;

import javax.swing.JTable;
import javax.swing.JScrollPane;

//create class and extend with JFrame
public class VeiculoFrame extends JFrame 
{
	//declare variable
	private JPanel contentPane;
	private JTextField PlacaVeiculo;
	private JTextField MarcaVeiculo;
	private JTextField AutonomiaVeiculo;
	private JTable veiculoTable;
	Metodos metodo = new Metodos();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VeiculoFrame() //constructor
	{
		//set frame title
		setTitle("New Frame");
		//set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//set bounds of the frame
		setBounds(100, 100, 840, 542);
		
		//create object of JPanel
		contentPane = new JPanel();
		//set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set ContentPane
		setContentPane(contentPane);
		//set null
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRUD Veiculo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 824, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 36, 804, 14);
		contentPane.add(lblNewLabel_1);
		
		PlacaVeiculo = new JTextField();
		PlacaVeiculo.setBounds(10, 52, 804, 20);
		contentPane.add(PlacaVeiculo);
		PlacaVeiculo.setColumns(10);
		
		MarcaVeiculo = new JTextField();
		MarcaVeiculo.setColumns(10);
		MarcaVeiculo.setBounds(10, 99, 804, 20);
		contentPane.add(MarcaVeiculo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 83, 804, 14);
		contentPane.add(lblNewLabel_1_1);
		
		AutonomiaVeiculo = new JTextField();
		AutonomiaVeiculo.setColumns(10);
		AutonomiaVeiculo.setBounds(10, 146, 804, 20);
		contentPane.add(AutonomiaVeiculo);
		
		JLabel lblNewLabel_1_2 = new JLabel("KM por litro:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 130, 804, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnCadastraVeiculo = new JButton("Criar Veiculo");
		btnCadastraVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo(PlacaVeiculo.getText(), MarcaVeiculo.getText(), Double.parseDouble(AutonomiaVeiculo.getText()));
				if(VeiculoDao.cadastrar(veiculo)){
					SuccesInsertion si = new SuccesInsertion();
					si.setVisible(true);
					metodo.fillDataJTableVeiculo(veiculoTable);
				}else {
					FailedInsertion fi = new FailedInsertion();
					fi.setVisible(true);
				}
			}
		});
		btnCadastraVeiculo.setBounds(10, 177, 270, 47);
		contentPane.add(btnCadastraVeiculo);
		
		JButton btnEditarVeiculo = new JButton("Editar Veiculo");
		btnEditarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = veiculoTable.getSelectedRow();
				String id = Integer.toString((int) veiculoTable.getValueAt(row, 0));  
				String placa = (String) veiculoTable.getValueAt(row, 1);
				String marca = (String) veiculoTable.getValueAt(row, 2);
				String autonomia = veiculoTable.getValueAt(row, 3).toString();
				metodo.editaVeiculo(id, placa, marca, autonomia);		
			}
		});
		btnEditarVeiculo.setBounds(290, 177, 244, 47);
		contentPane.add(btnEditarVeiculo);
		
		JButton btnBuscarVeiculo = new JButton("Buscar Veiculo");
		btnBuscarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					metodo.fillDataJTableVeiculo(veiculoTable, MarcaVeiculo.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscarVeiculo.setBounds(10, 234, 804, 23);
		contentPane.add(btnBuscarVeiculo);
		
		JButton btnExcluirVeiculo = new JButton("Excluir Veiculo");
		btnExcluirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = veiculoTable.getSelectedRow();
				String id = Integer.toString((int) veiculoTable.getValueAt(row, 0));  
				metodo.excluiVeiculo(id);
				metodo.fillDataJTableVeiculo(veiculoTable);
			}
		});
		btnExcluirVeiculo.setBounds(544, 177, 270, 47);
		contentPane.add(btnExcluirVeiculo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 268, 804, 224);
		contentPane.add(scrollPane);
		
		veiculoTable = new JTable();
		scrollPane.setViewportView(veiculoTable);
		
		metodo.fillDataJTableVeiculo(veiculoTable);
	}
}
