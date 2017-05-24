package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import View.FormAcceso;
import View.FormConsultarPagos;
import View.FormFacturarPago;

@SuppressWarnings("serial")
public class MenuPrincipalC extends JFrame {

	private JPanel contentPane;

	
	public MenuPrincipalC() {
		
		
		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalC.class.getResource("/Imagenes/AguAgro.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 283);
		contentPane = new JPanel();
		contentPane.setToolTipText("Retorna a la ventana del loggin");
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Al dar clic retorna a la ventana inicio de sesi\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				FormAcceso unAcceso=new FormAcceso();
				unAcceso.setVisible(true);
				hide();
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(MenuPrincipalC.class.getResource("/Imagenes/IconoP.png")));
		btnNewButton.setBounds(193, 0, 43, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
			
			FormConsultarPagos cp;
			try {
				cp = new FormConsultarPagos();
				cp.setVisible(true);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hide();
			
			}
		});
		btnNewButton_1.setToolTipText("Al dar clic muestra ventana consultar pagos");
		btnNewButton_1.setIcon(new ImageIcon(MenuPrincipalC.class.getResource("/Imagenes/conspag.png")));
		btnNewButton_1.setBounds(307, 100, 69, 81);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try{
				FormFacturarPago rp=new FormFacturarPago();
				rp.setVisible(true);
				hide();}catch(Exception e){
					
				}
						
			}
		});
		button.setToolTipText("Al dar clic muestra ventana registrar pagos");
		button.setFocusPainted(false);
		button.setIcon(new ImageIcon(MenuPrincipalC.class.getResource("/Imagenes/fact.png")));
		button.setBounds(70, 100, 69, 81);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Registrar Pagos");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(54, 187, 108, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblConsultarPagos = new JLabel("Consultar Pagos");
		lblConsultarPagos.setForeground(new Color(139, 69, 19));
		lblConsultarPagos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsultarPagos.setBounds(291, 187, 108, 15);
		contentPane.add(lblConsultarPagos);
		
		JLabel lblNewLabel_1 = new JLabel("Pagos De Terrenos");
		lblNewLabel_1.setBackground(SystemColor.window);
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Castellar", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 49, 414, 22);
		contentPane.add(lblNewLabel_1);
	}
	
}
