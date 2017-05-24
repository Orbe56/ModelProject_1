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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Domain.TerrenoCont;
import View.MenuPrincipal;

@SuppressWarnings("serial")
public class FormRegistrarTerreno extends JFrame {


	private JPanel Fondo;
	private static JTextField tfCanTarea;
	private static JTextField tfFormAdqui;
	private static JTextField tfDireccion;
	private static JTextField tfFormRiego;
	private static JFormattedTextField ftfFecha;
	private static JFormattedTextField ftfCedCliente;


	public FormRegistrarTerreno() throws ParseException {
		
		setBackground(new Color(218, 165, 32));
		setTitle("Registrar Terreno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormRegistrarTerreno.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 493);
		Fondo = new JPanel();
		Fondo.setBackground(new Color(210, 180, 140));
		Fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Fondo);
		Fondo.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu=new MenuPrincipal();
				menu.setVisible(true);
				hide();
			}
		});
		btnAtras.setFocusPainted(false);
		btnAtras.setIcon(new ImageIcon(FormRegistrarTerreno.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(192, 11, 38, 42);
		Fondo.add(btnAtras);
		
		JLabel lbTitulo = new JLabel("Registrar Terreno");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setForeground(new Color(255, 255, 255));
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTitulo.setBounds(10, 97, 392, 21);
		Fondo.add(lbTitulo);
		
		JLabel lbCedCliente = new JLabel("C\u00E9dula del cliente:");
		lbCedCliente.setForeground(new Color(34, 139, 34));
		lbCedCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCedCliente.setBounds(10, 379, 126, 21);
		Fondo.add(lbCedCliente);
		
		JLabel lbCanTarea = new JLabel("Cantidad de Tarea:");
		lbCanTarea.setForeground(new Color(34, 139, 34));
		lbCanTarea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCanTarea.setBounds(10, 191, 126, 21);
		Fondo.add(lbCanTarea);
		
		JLabel lbFormAdquisicion = new JLabel("Forma Adquisici\u00F3n:");
		lbFormAdquisicion.setForeground(new Color(34, 139, 34));
		lbFormAdquisicion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFormAdquisicion.setBounds(10, 244, 136, 21);
		Fondo.add(lbFormAdquisicion);
		
		JLabel lbDireccion = new JLabel("Direcci\u00F3n:");
		lbDireccion.setForeground(new Color(34, 139, 34));
		lbDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDireccion.setBounds(10, 143, 126, 21);
		Fondo.add(lbDireccion);
		
		JLabel lbFecha = new JLabel("Fecha:");
		lbFecha.setForeground(new Color(34, 139, 34));
		lbFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFecha.setBounds(10, 330, 136, 21);
		Fondo.add(lbFecha);
		
		tfCanTarea = new JTextField();
		tfCanTarea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (!Character.isDigit(e.getKeyChar())&& e.getKeyChar()!='.'){
					e.consume();
				}
				if(e.getKeyChar()=='.'&& tfCanTarea.getText().contains(".")){
					e.consume();
				}
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
				tfFormAdqui.requestFocus();
				}
			}
		});
		tfCanTarea.setToolTipText("Ingrese cantidad de tarea del terreno");
		tfCanTarea.setForeground(new Color(0, 0, 0));
		tfCanTarea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCanTarea.setColumns(10);
		tfCanTarea.setBounds(140, 191, 235, 21);
		Fondo.add(tfCanTarea);
		
		tfFormAdqui = new JTextField();
		tfFormAdqui.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c= e.getKeyChar();
				 if((!Character.isLetter(c))&&(c !=KeyEvent.VK_SPACE) )e.consume();
					
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfFormRiego.requestFocus();
				}
			}
		});
		tfFormAdqui.setToolTipText("Ingrese manera en que se adquirio el terreno");
		tfFormAdqui.setForeground(new Color(0, 0, 0));
		tfFormAdqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFormAdqui.setColumns(10);
		tfFormAdqui.setBounds(140, 244, 235, 21);
		Fondo.add(tfFormAdqui);
		
		tfDireccion = new JTextField();
		tfDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					tfCanTarea.requestFocus();
					
				}
			}
		});
		tfDireccion.setToolTipText("Ingresar direcci\u00F3n del terreno");
		tfDireccion.setForeground(new Color(0, 0, 0));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(140, 143, 235, 21);
		Fondo.add(tfDireccion);
		
		 
		MaskFormatter form = new MaskFormatter("####-##-##");
		form.setPlaceholderCharacter('_');
		ftfFecha = new JFormattedTextField(form);
		ftfFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					ftfCedCliente.requestFocus();
				}
			}
		});
		ftfFecha.setToolTipText("Ingrese fecha en que se registra el terreno");
		ftfFecha.setForeground(new Color(0, 0, 0));
		ftfFecha.setBounds(141, 331, 234, 20);
		Fondo.add(ftfFecha);
		
		MaskFormatter forma = new MaskFormatter("###-#######-#");
		forma.setPlaceholderCharacter('_');
		ftfCedCliente = new JFormattedTextField(forma);
		ftfCedCliente.setToolTipText("Ingrese c\u00E9dula del cliente:");
		ftfCedCliente.setForeground(new Color(0, 0, 0));
		ftfCedCliente.setBounds(140, 380, 235, 20);
		Fondo.add(ftfCedCliente);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				TerrenoCont unTerreno=new TerrenoCont();
				
				unTerreno.CrearTerreno( tfDireccion.getText(),tfCanTarea.getText(),tfFormAdqui.getText(),tfFormRiego.getText(), ftfFecha.getText(),ftfCedCliente.getText());
				
			}
		});
		btnGuardar.setToolTipText("Al dar clic guardar los datos ingresados en los campos anteriores");
		btnGuardar.setFocusPainted(false);
		btnGuardar.setForeground(new Color(34, 139, 34));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(183, 402, 89, 23);
		Fondo.add(btnGuardar);
		
		JLabel lbFormRiego = new JLabel("Forma de Riego:");
		lbFormRiego.setForeground(new Color(34, 139, 34));
		lbFormRiego.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFormRiego.setBounds(10, 286, 136, 21);
		Fondo.add(lbFormRiego);
		
		tfFormRiego = new JTextField();
		tfFormRiego.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char e= evt.getKeyChar();
				 if((!Character.isLetter(e))&&(e !=KeyEvent.VK_SPACE) )evt.consume();
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					ftfFecha.requestFocus();
				}
			}
		});
		tfFormRiego.setToolTipText("Ingresa forma de regar el terreno");
		tfFormRiego.setForeground(new Color(0, 0, 0));
		tfFormRiego.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFormRiego.setColumns(10);
		tfFormRiego.setBounds(140, 287, 235, 21);
		Fondo.add(tfFormRiego);
		
	
	}
	public static void resultado(){
		JOptionPane.showMessageDialog(null, "Sus datos fueron almacenados exitosamente" );
		tfFormRiego.setText("");
		ftfCedCliente.setText("");
		tfDireccion.setText("");
		tfFormAdqui.setText("");
		tfCanTarea.setText("");
		ftfFecha.setText("");
	}
}
