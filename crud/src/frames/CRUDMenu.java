package frames;
//import statement
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//create class and extend with JFrame
public class CRUDMenu extends JFrame 
{
	//declare variable
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//main method
	public static void main(String[] args)
	{
	  /* It posts an event (Runnable)at the end of Swings event list and is
		processed after all other GUI events are processed.*/
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				//try - catch block
				try 
				{
					//Create object of OldWindow
					CRUDMenu frame = new CRUDMenu();
					//set frame visible true
					frame.setVisible(true);					
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CRUDMenu()//constructor 
	{
		//set frame title
		setTitle("Old Frame");
		//set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//set bounds of the frame
		setBounds(100, 100, 397, 203);
		//create object of JPanel
		contentPane = new JPanel();
		//set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set ContentPane
		setContentPane(contentPane);
		//set null
		contentPane.setLayout(null);
		
		//create object of JButton and set label on it
		JButton btnFuncionario = new JButton("Funcionario");
		//add actionListener
		btnFuncionario.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				FuncionarioFrame frame = new FuncionarioFrame();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		//set font of the Button
		btnFuncionario.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		//set bounds of the Button
		btnFuncionario.setBounds(10, 11, 113, 100);
		//add Button into contentPane
		contentPane.add(btnFuncionario);
		
		JButton btnCalculo = new JButton("Calculo de emiss\u00E3o de gases");
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCalculo framec = new FrameCalculo();
				framec.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCalculo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnCalculo.setBounds(10, 122, 357, 32);
		contentPane.add(btnCalculo);
		
		JButton btnVeiculo = new JButton("Veiculo");
		btnVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoFrame frame = new VeiculoFrame();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVeiculo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnVeiculo.setBounds(133, 11, 113, 100);
		contentPane.add(btnVeiculo);
		
		JButton btnChamado = new JButton("Chamado");
		btnChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChamadoFrame frame = new ChamadoFrame();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnChamado.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnChamado.setBounds(254, 11, 113, 100);
		contentPane.add(btnChamado);
	}
}