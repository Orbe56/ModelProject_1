package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Domain.ClienteCont;
import View.MenuPrincipal;

@SuppressWarnings("serial")
public class FormRegistrarCliente extends JFrame {


	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDireccion;
	private JTextField tfCodEmp;
	private JFormattedTextField tfCedCliente;
	private JFormattedTextField tfTelefono;


	public FormRegistrarCliente() throws ParseException {
		
		setTitle("Ventana Registrar Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormRegistrarCliente.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menu=new MenuPrincipal();
				menu.setVisible(true);
				hide();
			}
		});
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.setFocusPainted(false);
		btnAtras.setIcon(new ImageIcon(FormRegistrarCliente.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(204, 30, 44, 42);
		contentPane.add(btnAtras);
		
		JLabel lbTitulo = new JLabel("Registrar Cliente");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTitulo.setForeground(new Color(34, 139, 34));
		lbTitulo.setBounds(10, 106, 439, 23);
		contentPane.add(lbTitulo);
		
		JLabel lbCedCliente = new JLabel("N\u00FAmero de C\u00E9dula:");
		lbCedCliente.setForeground(new Color(34, 139, 34));
		lbCedCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCedCliente.setBounds(30, 144, 117, 23);
		contentPane.add(lbCedCliente);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setForeground(new Color(34, 139, 34));
		lbNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbNombre.setBounds(30, 178, 93, 23);
		contentPane.add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido:");
		lbApellido.setForeground(new Color(34, 139, 34));
		lbApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbApellido.setBounds(30, 212, 93, 23);
		contentPane.add(lbApellido);
		
		JLabel lbDireccion = new JLabel("Direcci\u00F3n:");
		lbDireccion.setForeground(new Color(34, 139, 34));
		lbDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDireccion.setBounds(30, 256, 93, 23);
		contentPane.add(lbDireccion);
		
		JLabel lbTelefono = new JLabel("Tel\u00E9fono:");
		lbTelefono.setForeground(new Color(34, 139, 34));
		lbTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbTelefono.setBounds(30, 300, 93, 23);
		contentPane.add(lbTelefono);
		
		JLabel lbCodEmp = new JLabel("C\u00F3digo Empleado:");
		lbCodEmp.setForeground(new Color(34, 139, 34));
		lbCodEmp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCodEmp.setBounds(30, 347, 117, 23);
		contentPane.add(lbCodEmp);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char e= evt.getKeyChar();
				 if((!Character.isLetter(e))&&(e !=KeyEvent.VK_SPACE) )evt.consume();
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfApellido.requestFocus();
				}
			}
		});
		tfNombre.setToolTipText("Ingrese nombre del cliente");
		tfNombre.setForeground(new Color(0, 0, 0));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNombre.setColumns(10);
		tfNombre.setBounds(145, 178, 261, 23);
		contentPane.add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char e= evt.getKeyChar();
				 if((!Character.isLetter(e))&&(e !=KeyEvent.VK_SPACE) )evt.consume();
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
				
				tfDireccion.requestFocus();
				}
			}
		});
		tfApellido.setToolTipText("Ingrese apellido del cliente");
		tfApellido.setForeground(new Color(0, 0, 0));
		tfApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfApellido.setColumns(10);
		tfApellido.setBounds(145, 212, 261, 23);
		contentPane.add(tfApellido);
		
		tfDireccion = new JTextField();
		tfDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
				tfTelefono.requestFocus();
				}
			}
		});
		tfDireccion.setToolTipText("Introduzca la direcci\u00F3n del cliente");
		tfDireccion.setForeground(new Color(0, 0, 0));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(145, 256, 261, 23);
		contentPane.add(tfDireccion);
		
		tfCodEmp = new JTextField();
		tfCodEmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if((c<'0')||(c>'9')) e.consume();
			}
		});
		tfCodEmp.setToolTipText("Ingrese c\u00F3digo empleado");
		tfCodEmp.setForeground(new Color(0, 0, 0));
		tfCodEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCodEmp.setColumns(10);
		tfCodEmp.setBounds(145, 347, 261, 23);
		contentPane.add(tfCodEmp);
		
		
            MaskFormatter formato = new MaskFormatter("###-#######-#");
            formato.setPlaceholderCharacter('_');
            
            MaskFormatter form = new MaskFormatter("###-###-####");
            form.setPlaceholderCharacter('_');
		 tfCedCliente = new JFormattedTextField(formato);
		 tfCedCliente.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyPressed(KeyEvent e) {
		 		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		 			tfNombre.requestFocus();
		 		}
		 	}
		 });
		 tfCedCliente.setToolTipText("Ingrese n\u00FAmero de c\u00E9dula ");
		 tfCedCliente.setForeground(new Color(0, 0, 0));
		tfCedCliente.setBounds(145, 146, 261, 20);
		contentPane.add(tfCedCliente);
		
		 tfTelefono = new JFormattedTextField(form);
		 tfTelefono.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyPressed(KeyEvent e) {
		 		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		 			tfCodEmp.requestFocus();
		 		}
		 	}
		 });
		 tfTelefono.setToolTipText("Ingrese el num. de tel\u00E9fono");
		 tfTelefono.setForeground(new Color(0, 0, 0));
		tfTelefono.setBounds(145, 302, 261, 20);
		contentPane.add(tfTelefono);
		

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteCont unCliente=new ClienteCont();
				boolean estado=unCliente.crearCliente(tfCedCliente.getText(), tfNombre.getText(), tfApellido.getText(), tfDireccion.getText(), tfTelefono.getText(), tfCodEmp.getText());
				if(estado){
					tfCedCliente.setText("");
					tfNombre.setText("");
					tfApellido.setText("");
					tfDireccion.setText("");
					tfCodEmp.setText("");
					tfTelefono.setText("");
					
				}
			}
		});
		btnGuardar.setToolTipText("Dar clic para almacenar los datos");
		btnGuardar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGuardar.setFocusPainted(false);
		btnGuardar.setForeground(new Color(34, 139, 34));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(196, 392, 93, 23);
		contentPane.add(btnGuardar);
	
	}

}
