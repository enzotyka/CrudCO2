package frames;
//import statement
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import framesManagers.Metodos;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Funcionario;

import dao.FuncionarioDAO;

import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;

//create class and extend with JFrame
public class FuncionarioFrame extends JFrame 
{
	
	Metodos metodos = new Metodos();
	//declare variable
	private JPanel contentPane;
	private JTextField NomeFunc;
	private JTextField CpfFunc;
	private JTable FuncionarioTable;
	/**
	 * Launch the application.
	 *

	/**
	 * Create the frame.
	 */
	public FuncionarioFrame() //constructor
	{
		setTitle("New Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 476);
		
		contentPane = new JPanel();
		//set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set ContentPane
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("CRUD Funcionario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 724, 14);
		contentPane.add(lblNewLabel);
		
		NomeFunc = new JTextField();
		NomeFunc.setBounds(10, 52, 704, 20);
		contentPane.add(NomeFunc);
		NomeFunc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 36, 704, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 83, 704, 14);
		contentPane.add(lblNewLabel_1_1);
		
		CpfFunc = new JTextField();
		CpfFunc.setColumns(10);
		CpfFunc.setBounds(10, 99, 704, 20);
		contentPane.add(CpfFunc);
		
		JButton btnCadastrarFuncionario = new JButton("Cadastrar Funcionario");
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario(CpfFunc.getText(), NomeFunc.getText());
				if(metodos.cadastraFuncionario(funcionario)){
					SuccesInsertion si = new SuccesInsertion();
					si.setVisible(true);
				}else {
					FailedInsertion fi = new FailedInsertion();
					fi.setVisible(true);
				}
				metodos.fillDataJTableFuncionario(FuncionarioTable);
			}
		});
		btnCadastrarFuncionario.setBounds(10, 130, 222, 51);
		contentPane.add(btnCadastrarFuncionario);
		
		JButton btnEditarFuncionario = new JButton("Editar funcionario");
		btnEditarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = FuncionarioTable.getSelectedRow();
				String id = Integer.toString((int) FuncionarioTable.getValueAt(row, 0));  
				String cpf = (String) FuncionarioTable.getValueAt(row, 1);
				String nome = (String) FuncionarioTable.getValueAt(row, 2);
				System.out.println(id);
				metodos.editaFuncionario(id, cpf, nome);		
			}
		});
		btnEditarFuncionario.setBounds(252, 130, 222, 51);
		contentPane.add(btnEditarFuncionario);
		
		JButton btnCadastrarFuncionario_1_1 = new JButton("Excluir funcionario");
		btnCadastrarFuncionario_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = FuncionarioTable.getSelectedRow();
				String id = Integer.toString((int) FuncionarioTable.getValueAt(row, 0));  
				metodos.excluiFuncionario(id);
				metodos.fillDataJTableFuncionario(FuncionarioTable);
			}
		});
		btnCadastrarFuncionario_1_1.setBounds(492, 130, 222, 51);
		contentPane.add(btnCadastrarFuncionario_1_1);
		
		JButton btnBuscarFuncionario = new JButton("Buscar Funcionario");
		btnBuscarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					metodos.fillDataJTableFuncionario(FuncionarioTable, NomeFunc.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscarFuncionario.setBounds(10, 192, 704, 24);
		contentPane.add(btnBuscarFuncionario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 704, 199);
		contentPane.add(scrollPane);
		
		FuncionarioTable = new JTable();
		FuncionarioTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(FuncionarioTable);
		

		metodos.fillDataJTableFuncionario(FuncionarioTable);

		

	}
}
