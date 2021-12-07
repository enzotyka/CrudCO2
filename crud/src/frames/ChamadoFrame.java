package frames;
//import statement
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

import java.util.List;

import classes.Chamado;
import classes.Funcionario;
import classes.Veiculo;
import dao.ChamadoDao;
import dao.FuncionarioDAO;
import dao.VeiculoDao;
import framesManagers.Metodos;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

//create class and extend with JFrame
public class ChamadoFrame extends JFrame 
{
	//declare variable
	private JPanel contentPane;
	private JTextField distanciaTf;
	private JTextField idChamado;
	ChamadoDao cDao = new ChamadoDao();
	private JTable chamadosTable;
	Metodos metodos = new Metodos();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChamadoFrame() //constructor
	{
		//set frame title
		setTitle("New Frame");
		//set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//set bounds of the frame
		setBounds(100, 100, 849, 538);
		
		//create object of JPanel
		contentPane = new JPanel();
		//set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set ContentPane
		setContentPane(contentPane);
		//set null
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRUD Chamado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 833, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Distancia (km):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 101, 22);
		contentPane.add(lblNewLabel_1);
		
		distanciaTf = new JTextField();
		distanciaTf.setBounds(10, 50, 813, 20);
		contentPane.add(distanciaTf);
		distanciaTf.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Carro:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 118, 101, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox cbVeiculo = new JComboBox();
		cbVeiculo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				VeiculoDao vDao = new VeiculoDao();
				List<Veiculo> listaVeiculos = vDao.listarVeiculos();
			
				cbVeiculo.removeAll();

				for(Veiculo lv : listaVeiculos) {
					cbVeiculo.addItem(lv);
				}
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		cbVeiculo.setBounds(10, 134, 404, 22);
		contentPane.add(cbVeiculo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Funcionario:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(419, 118, 101, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JComboBox cbFuncionario = new JComboBox();
		cbFuncionario.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				FuncionarioDAO fDao = new FuncionarioDAO();
				List<Funcionario> listaFuncionarios = fDao.listarFuncionariosLS();
			
				cbFuncionario.removeAll();

				for(Funcionario lf : listaFuncionarios) {
					cbFuncionario.addItem(lf);
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFuncionario.setBounds(419, 134, 404, 22);
		contentPane.add(cbFuncionario);
		
		JButton btnNewButton = new JButton("Abrir Chamado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double distancia = Double.parseDouble(distanciaTf.getText());
				Funcionario func = (Funcionario) cbFuncionario.getSelectedItem();
				Veiculo veiculo = (Veiculo) cbVeiculo.getSelectedItem();
				
				Chamado chamado = new Chamado(distancia, func, veiculo);
				
				cDao.cadastrar(chamado);
				
				metodos.fillDataJTableChamado(chamadosTable);
			}
		});
		btnNewButton.setBounds(10, 160, 200, 37);
		contentPane.add(btnNewButton);
		
		JButton btnEditarChamado = new JButton("Editar Chamado");
		btnEditarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = chamadosTable.getSelectedRow();
				String id = Integer.toString((int) chamadosTable.getValueAt(row, 0));  
				String distancia = chamadosTable.getValueAt(row, 1).toString();
				Funcionario func = (Funcionario) cbFuncionario.getSelectedItem();
				Veiculo veiculo = (Veiculo) cbVeiculo.getSelectedItem();
				cDao.editarVeiculo(id, Double.parseDouble(distancia), func, veiculo);
				metodos.fillDataJTableChamado(chamadosTable);
			}
		});
		btnEditarChamado.setBounds(214, 160, 200, 37);
		contentPane.add(btnEditarChamado);
		
		JButton btnExcluirChamado = new JButton("Excluir Chamado");
		btnExcluirChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = chamadosTable.getSelectedRow();
				String id = Integer.toString((int) chamadosTable.getValueAt(row, 0));  
				cDao.excluirChamado(Integer.parseInt(id));
				metodos.fillDataJTableChamado(chamadosTable);
			}
		});
		btnExcluirChamado.setBounds(420, 160, 200, 37);
		contentPane.add(btnExcluirChamado);
		
		JButton btnBuscarChamado = new JButton("Buscar Chamado");
		btnBuscarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idChamado.getText().equals("")) {
					metodos.fillDataJTableChamado(chamadosTable);
				}else{
					metodos.fillDataJTableChamado(chamadosTable, idChamado.getText());
				}
			}
		});
		btnBuscarChamado.setBounds(623, 160, 200, 37);
		contentPane.add(btnBuscarChamado);
		
		idChamado = new JTextField();
		idChamado.setColumns(10);
		idChamado.setBounds(10, 92, 813, 20);
		contentPane.add(idChamado);
		
		JLabel lblNewLabel_1_2 = new JLabel("Codigo (Obirgatorio apenas para busca de chamados):");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 64, 813, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 813, 280);
		contentPane.add(scrollPane);
		
		chamadosTable = new JTable();
		scrollPane.setViewportView(chamadosTable);
		
		metodos.fillDataJTableChamado(chamadosTable);
	}
}
