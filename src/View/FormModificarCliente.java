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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Domain.Cliente;
import Domain.ClienteCont;
import View.MenuPrincipal;

@SuppressWarnings("serial")
public class FormModificarCliente extends JFrame {


	private JPanel contentPane;
	private static JTextField tfNombre;
	private static JTextField tfApellido;
	private static JTextField tfDireccion;
	private static JFormattedTextField ftfTelefono;
	private static JFormattedTextField ftfCedCliente;
	private static JTextField tfCodEmpleado;

	
	public FormModificarCliente() throws ParseException {
		
		setTitle("Modificar Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormModificarCliente.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCedCliente = new JLabel("N\u00FAmero de C\u00E9dula:");
		lbCedCliente.setForeground(new Color(128, 0, 0));
		lbCedCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCedCliente.setBackground(new Color(128, 0, 0));
		lbCedCliente.setBounds(10, 76, 115, 20);
		contentPane.add(lbCedCliente);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setForeground(new Color(128, 0, 0));
		lbNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbNombre.setBackground(new Color(128, 0, 0));
		lbNombre.setBounds(10, 121, 101, 20);
		contentPane.add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido:");
		lbApellido.setForeground(new Color(128, 0, 0));
		lbApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbApellido.setBackground(new Color(128, 0, 0));
		lbApellido.setBounds(10, 160, 101, 21);
		contentPane.add(lbApellido);
		
		JLabel lbDireccion = new JLabel("Direcci\u00F3n:");
		lbDireccion.setForeground(new Color(128, 0, 0));
		lbDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDireccion.setBackground(new Color(128, 0, 0));
		lbDireccion.setBounds(10, 204, 101, 20);
		contentPane.add(lbDireccion);
		
		JLabel lbTelefono = new JLabel("Tel\u00E9fono:");
		lbTelefono.setForeground(new Color(128, 0, 0));
		lbTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbTelefono.setBackground(new Color(128, 0, 0));
		lbTelefono.setBounds(10, 249, 101, 15);
		contentPane.add(lbTelefono);
		MaskFormatter forma = new MaskFormatter("###-#######-#");
		forma.setPlaceholderCharacter('_');
		 ftfCedCliente = new JFormattedTextField(forma);
		ftfCedCliente.setToolTipText("Ingrese n\u00FAmero de c\u00E9dula del cliente");
		ftfCedCliente.setForeground(new Color(0, 0, 0));
		ftfCedCliente.setBounds(128, 77, 188, 20);
		contentPane.add(ftfCedCliente);
		

		MaskFormatter form = new MaskFormatter("###-###-####");
		form.setPlaceholderCharacter('_');
		 ftfTelefono = new JFormattedTextField(form);
		ftfTelefono.setToolTipText("Ingrese tel\u00E9fono del cliente");
		ftfTelefono.setForeground(new Color(0, 0, 0));
		ftfTelefono.setEditable(false);
		ftfTelefono.setBounds(121, 247, 294, 20);
		contentPane.add(ftfTelefono);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClienteCont unCliente=new ClienteCont();
				
				unCliente.ModificarCliente(ftfCedCliente.getText(), tfNombre.getText(),tfApellido.getText(), tfDireccion.getText(), ftfTelefono.getText(),tfCodEmpleado.getText());
			}
		});
		btnActualizar.setToolTipText("Dar clic para  actualizar los datos");
		btnActualizar.setBackground(new Color(255, 255, 224));
		btnActualizar.setFocusPainted(false);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.setForeground(new Color(128, 0, 0));
		btnActualizar.setBounds(303, 322, 112, 23);
		contentPane.add(btnActualizar);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu=new MenuPrincipal();
				menu.setVisible(true);
				hide();
			}
		});
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.setFocusPainted(false);
		btnAtras.setIcon(new ImageIcon(FormModificarCliente.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(225, 11, 42, 41);
		contentPane.add(btnAtras);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClienteCont unClienteCtrl=new ClienteCont();
				Cliente unCliente=unClienteCtrl.BuscarCliente(ftfCedCliente.getText());
				if(unCliente.resultado==true){

					tfNombre.setText(unCliente.getNombre());
					tfNombre.setEditable(true);	
					tfApellido.setText(unCliente.getApellido());
					tfApellido.setEditable(true);
					tfDireccion.setText(unCliente.getDireccion());
					tfDireccion.setEditable(true);
					ftfTelefono.setText(unCliente.getTelefono());
					ftfTelefono.setEditable(true);
				}
			}
		});
		btnBuscar.setToolTipText("Dar clic para buscar la informaci\u00F3n del cliente");
		btnBuscar.setFocusPainted(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setForeground(new Color(128, 0, 0));
		btnBuscar.setBounds(326, 72, 89, 28);
		contentPane.add(btnBuscar);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char e= evt.getKeyChar();
				 if((!Character.isLetter(e))&&(e !=KeyEvent.VK_SPACE) )evt.consume();
				
			}
		});
		tfNombre.setEditable(false);
		tfNombre.setToolTipText("Campo que permite cambiar el nombre del cliente");
		tfNombre.setForeground(new Color(0, 0, 0));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNombre.setColumns(10);
		tfNombre.setBounds(121, 120, 294, 23);
		contentPane.add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char e= evt.getKeyChar();
				 if((!Character.isLetter(e))&&(e !=KeyEvent.VK_SPACE) )evt.consume();
				
			}
		});
		tfApellido.setEditable(false);
		tfApellido.setToolTipText("Campo que permite cambiar el apellido del cliente");
		tfApellido.setForeground(new Color(0, 0, 0));
		tfApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfApellido.setColumns(10);
		tfApellido.setBounds(121, 159, 294, 23);
		contentPane.add(tfApellido);
		
		tfDireccion = new JTextField();
		tfDireccion.setEditable(false);
		tfDireccion.setToolTipText("Campo que permite cambiar la direcci\u00F3n del cliente");
		tfDireccion.setForeground(new Color(0, 0, 0));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(121, 203, 294, 23);
		contentPane.add(tfDireccion);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo Empleado:");
		lblCdigoEmpleado.setForeground(new Color(128, 0, 0));
		lblCdigoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoEmpleado.setBackground(new Color(128, 0, 0));
		lblCdigoEmpleado.setBounds(10, 287, 115, 15);
		contentPane.add(lblCdigoEmpleado);
		
		tfCodEmpleado = new JTextField();
		tfCodEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c= e.getKeyChar();
				if((c<'0')||(c>'9')) e.consume();
			}
		});
		tfCodEmpleado.setToolTipText("Campo que permite cambiar el nombre del cliente");
		tfCodEmpleado.setForeground(new Color(0, 0, 0));
		tfCodEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCodEmpleado.setColumns(10);
		tfCodEmpleado.setBounds(121, 279, 294, 23);
		contentPane.add(tfCodEmpleado);
		
	
	}

public static void resultado(){
	
	JOptionPane.showMessageDialog(null, "Datos modificados");
	tfNombre.setText("");
	tfNombre.setEditable(false);
	
	tfApellido.setText("");
	tfApellido.setEditable(false);
	
	tfDireccion.setText("");
	tfDireccion.setEditable(false);
	
	ftfTelefono.setText("");
	ftfTelefono.setEditable(false);

	ftfCedCliente.setText("");
	
	tfCodEmpleado.setText("");
	
}
	

}
