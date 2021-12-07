package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ChamadoDao;
import framesManagers.Metodos;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrameCalculo extends JFrame {

	private JPanel contentPane;
	private JTable ChamadoTable;
	Metodos metodos = new Metodos();
	ChamadoDao cDao = new ChamadoDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCalculo frame = new FrameCalculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCalculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1063, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 425, 496);
		contentPane.add(scrollPane);
		
		ChamadoTable = new JTable();
		scrollPane.setViewportView(ChamadoTable);
		
		JPanel panel = new JPanel();
		panel.setBounds(544, 11, 493, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados Chamado");
		lblNewLabel.setBounds(190, 5, 113, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 36, 66, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Distancia:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 61, 79, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 86, 230, 148);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Funcionario");
		lblNewLabel_2.setBounds(75, 5, 80, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Codigo:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 35, 67, 24);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Cpf:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(10, 70, 46, 24);
		panel_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Nome:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_1.setBounds(10, 105, 46, 24);
		panel_1.add(lblNewLabel_4_1_1_1);
		
		JLabel lblCodFunc = new JLabel("");
		lblCodFunc.setBounds(63, 42, 135, 14);
		panel_1.add(lblCodFunc);
		
		JLabel lblCpfFunc = new JLabel("");
		lblCpfFunc.setBounds(63, 77, 135, 14);
		panel_1.add(lblCpfFunc);
		
		JLabel lblNomeFunc = new JLabel("");
		lblNomeFunc.setBounds(63, 112, 135, 14);
		panel_1.add(lblNomeFunc);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(253, 86, 230, 148);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Veiculo");
		lblNewLabel_3.setBounds(90, 5, 49, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Codigo:");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_2.setBounds(10, 36, 67, 24);
		panel_1_1.add(lblNewLabel_4_1_2);
		
		JLabel lblCodVeiculo = new JLabel("");
		lblCodVeiculo.setBounds(63, 43, 135, 14);
		panel_1_1.add(lblCodVeiculo);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Modelo:");
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2.setBounds(10, 71, 67, 24);
		panel_1_1.add(lblNewLabel_4_1_1_2);
		
		JLabel lblModeloVeiculo = new JLabel("");
		lblModeloVeiculo.setBounds(63, 78, 135, 14);
		panel_1_1.add(lblModeloVeiculo);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Autonomia:");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_1_1.setBounds(10, 106, 80, 24);
		panel_1_1.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblAutonomia = new JLabel("");
		lblAutonomia.setBounds(84, 113, 135, 14);
		panel_1_1.add(lblAutonomia);
		
		JLabel lblCodChamado = new JLabel("");
		lblCodChamado.setBounds(60, 38, 106, 14);
		panel.add(lblCodChamado);
		
		JLabel lblDistanciaChamado = new JLabel("");
		lblDistanciaChamado.setBounds(70, 63, 113, 14);
		panel.add(lblDistanciaChamado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(544, 267, 493, 240);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(10, 87, 473, 20);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblResultado);
		
		JLabel lblResultado2 = new JLabel("");
		lblResultado2.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado2.setBounds(10, 118, 473, 20);
		panel_2.add(lblResultado2);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = ChamadoTable.getSelectedRow();
					int id = (int) ChamadoTable.getValueAt(row, 0);  
					ResultSet rs = cDao.exibirChamado(id);
					rs.next();
					lblCodFunc.setText(rs.getString("codFunc"));
					lblCpfFunc.setText(rs.getString("cpfFunc"));
					lblNomeFunc.setText(rs.getString("nomeFunc"));
					lblCodVeiculo.setText(rs.getString("codVeic"));
					lblModeloVeiculo.setText(rs.getString("modeloVeic"));
					lblAutonomia.setText(rs.getString("autonomiaVeic")+ " Km/l");
					lblCodChamado.setText(rs.getString("id"));
					lblDistanciaChamado.setText(rs.getString("distancia") + " KM");
					String co2Emitido = metodos.calculaEmissaoCO2(rs.getDouble("distancia"), rs.getDouble("autonomiaVeic"));
					lblResultado.setText("Durante o atendimento deste chamado,");
					lblResultado2.setText("foram emitidos " + co2Emitido + "Kg de CO2");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCalcular.setBounds(445, 11, 89, 245);
		contentPane.add(btnCalcular);
		
		metodos.fillDataJTableChamado(ChamadoTable);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String co2Emitido = metodos.calculaEmissaoCO2Total();
				lblResultado.setText("Durante o atendimento de todos os chamados,");
				lblResultado2.setText("foram emitidos " + co2Emitido + "Kg de CO2");
			}
		});
		btnTotal.setBounds(445, 262, 89, 245);
		contentPane.add(btnTotal);
	}
}
