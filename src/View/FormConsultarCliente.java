package View;


import java.awt.Color;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Domain.Cliente;
import Domain.ClienteCont;
import View.MenuPrincipal;


@SuppressWarnings("serial")
public class FormConsultarCliente extends JFrame {

	private JPanel contentPane;
	
	 public static JTextArea taMostrar;
	private static JFormattedTextField ftfCedCliente;
	

	public FormConsultarCliente() throws ParseException {
		
		setTitle("Ventana Consultar Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormConsultarCliente.class.getResource("/Imagenes/AguAgro.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.setFocusPainted(false);
		btnAtras.setIcon(new ImageIcon(FormConsultarCliente.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
			MenuPrincipal retornar=new MenuPrincipal();
			retornar.setVisible(true);
			setVisible(false);
			}
		});
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.setBounds(252, 38, 43, 42);
		contentPane.add(btnAtras);
		
		JLabel lbCedCliente = new JLabel("N\u00FAmero de C\u00E9dula:");
		lbCedCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbCedCliente.setForeground(new Color(34, 139, 34));
		lbCedCliente.setBounds(61, 121, 128, 17);
		contentPane.add(lbCedCliente);
		
		taMostrar = new JTextArea();       
		taMostrar.setForeground(new Color(0, 0, 0));
		taMostrar.setToolTipText("Muestra informacion del cliente");
		taMostrar.setEditable(false);
		
		 JScrollPane scroll = new JScrollPane(taMostrar);    
 scroll.setBounds(new Rectangle(53,158,448,168)); 
 contentPane.add(scroll);

	MaskFormatter forma = new MaskFormatter("###-#######-#");
	forma.setPlaceholderCharacter('_');
  ftfCedCliente = new JFormattedTextField(forma);
  ftfCedCliente.setToolTipText("Ingrese n\u00FAmero de c\u00E9dula del cliente");
  ftfCedCliente.setForeground(new Color(0, 0, 0));
	ftfCedCliente.setBounds(189, 120, 156, 20);
	contentPane.add(ftfCedCliente);
		
		JButton btnBuscar = new JButton("Buscar");

			
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		   
				ClienteCont buscar=new ClienteCont();
					
						Cliente unCliente=buscar.BuscarCliente(ftfCedCliente.getText());
			
				if(unCliente.resultado==true){
					taMostrar.setText("");
					ftfCedCliente.setValue(null);
					taMostrar.append("\n"+" Cédula	  Nombre	 Apellido	 Teléfono	   Dirección"+"\n");
							taMostrar.append(unCliente.getCedula()+"	  "+unCliente.getNombre()+"	  "+unCliente.getApellido()+"	  "
								+ ""+unCliente.getTelefono()+"	   "+unCliente.getDireccion());
				}
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setForeground(new Color(34, 139, 34));
		btnBuscar.setToolTipText("Dar clic luego de ingresar el c\u00F3digo");
		btnBuscar.setBounds(387, 118, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Consultar Cliente Registrado");
		lblTitulo.setForeground(new Color(34, 139, 34));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 91, 510, 17);
		contentPane.add(lblTitulo);
		
	
}
}
