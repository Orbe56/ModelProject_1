package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import View.FormAcceso;
import View.FormConsultarCliente;
import View.FormConsultarTerreno;
import View.FormModificarCliente;
import View.FormModificarTerreno;
import View.FormRegistrarCliente;
import View.FormRegistrarTerreno;


@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {


	private JPanel contentPane;

	public MenuPrincipal() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Imagenes/IconoP.png")));
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIcono = new JButton("");
		btnIcono.setFocusPainted(false);
		btnIcono.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormAcceso login=new FormAcceso();
				login.setVisible(true);
			setVisible(false);
			}
		});
		btnIcono.setToolTipText("Al dar clic retorna a la ventana inicio de Sesion");
		btnIcono.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/IconoP.png")));
		btnIcono.setBounds(0, 0, 39, 39);
		contentPane.add(btnIcono);
		
		JButton btnRegCliente = new JButton("");
		btnRegCliente.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			FormRegistrarCliente regCliente;
			try {
				regCliente = new FormRegistrarCliente();
				regCliente.setVisible(true);
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			hide();
			}
		});
		btnRegCliente.setToolTipText("Al dar clic muestra ventana para registrar cliente");
		btnRegCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/registrarclien.png")));
		btnRegCliente.setBounds(237, 64, 81, 53);
		contentPane.add(btnRegCliente);
		
		JButton btnConsultarCliente = new JButton("");
		btnConsultarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FormConsultarCliente busCliente;
				try {
					busCliente = new FormConsultarCliente();
					busCliente.setVisible(true);
				} catch (ParseException e) {
			
				}
				
				setVisible(false);
				
				
				
			}
		});
		btnConsultarCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/consulcliente.png")));
		btnConsultarCliente.setToolTipText("Boton que al dar clic muestra ventana para buscar un cliente");
		btnConsultarCliente.setBounds(24, 147, 81, 53);
		contentPane.add(btnConsultarCliente);
		
		JButton btnModCliente = new JButton("");
		btnModCliente.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try{FormModificarCliente modCliente= new FormModificarCliente();
				modCliente.setVisible(true);
				hide();
				}catch(Exception e){}
				
			}
		});
		btnModCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/actuclient.png")));
		btnModCliente.setToolTipText("Pulse para modificar Cliente");
		btnModCliente.setBounds(469, 147, 74, 53);
		contentPane.add(btnModCliente);
		
		JButton btnRegTerreno = new JButton("");
		btnRegTerreno.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
			FormRegistrarTerreno regTerreno;
			try {
				regTerreno = new FormRegistrarTerreno();
				regTerreno.setVisible(true);
			} catch (ParseException e) {
				
			}
			
			hide();

			}
		});
		btnRegTerreno.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/terreno.png")));
		btnRegTerreno.setToolTipText("Muestra ventana para registrar terreno");
		btnRegTerreno.setBounds(76, 295, 81, 53);
		contentPane.add(btnRegTerreno);
		
		JButton btnConsultarTerreno = new JButton("");
		btnConsultarTerreno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormConsultarTerreno consTerr=new FormConsultarTerreno();
				consTerr.setVisible(true);
				setVisible(false);
			}
		});
		btnConsultarTerreno.setToolTipText("Muestra ventana que permite buscar datos de un terreno");
		btnConsultarTerreno.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/consultar.png")));
		btnConsultarTerreno.setBounds(443, 295, 74, 53);
		contentPane.add(btnConsultarTerreno);
		
		JButton btnModTerreno = new JButton("");
		btnModTerreno.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
					try{		
				FormModificarTerreno mf=new FormModificarTerreno();
				mf.setVisible(true);
				hide();
					}catch(Exception e){}
				

			}
		});
		btnModTerreno.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/actu.png")));
		btnModTerreno.setToolTipText("Al dar clic muestra ventana para modificar terreno");
		btnModTerreno.setBounds(260, 211, 81, 53);
		contentPane.add(btnModTerreno);
		
		JLabel lbRegCliente = new JLabel("Registrar Cliente");
		lbRegCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbRegCliente.setForeground(new Color(34, 139, 34));
		lbRegCliente.setBounds(220, 115, 121, 14);
		contentPane.add(lbRegCliente);
		
		JLabel lbConsultarCliente = new JLabel("Consultar Cliente");
		lbConsultarCliente.setForeground(new Color(34, 139, 34));
		lbConsultarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbConsultarCliente.setBounds(9, 211, 115, 14);
		contentPane.add(lbConsultarCliente);
		
		JLabel lbModCliente = new JLabel("Modificar Cliente");
		lbModCliente.setForeground(new Color(34, 139, 34));
		lbModCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbModCliente.setBounds(448, 211, 116, 14);
		contentPane.add(lbModCliente);
		
		JLabel lblRegTerreno = new JLabel("Registrar Terreno");
		lblRegTerreno.setForeground(new Color(34, 139, 34));
		lblRegTerreno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegTerreno.setBounds(61, 359, 121, 14);
		contentPane.add(lblRegTerreno);
		
		JLabel lbConsultarTerreno = new JLabel("Consultar Terreno");
		lbConsultarTerreno.setForeground(new Color(34, 139, 34));
		lbConsultarTerreno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbConsultarTerreno.setBounds(413, 361, 120, 10);
		contentPane.add(lbConsultarTerreno);
		
		JLabel lbModTerreno = new JLabel("Modificar Terreno");
		lbModTerreno.setForeground(new Color(34, 139, 34));
		lbModTerreno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbModTerreno.setBounds(237, 272, 134, 14);
		contentPane.add(lbModTerreno);
	}

}
