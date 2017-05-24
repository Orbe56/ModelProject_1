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
import Domain.Terreno;
import Domain.TerrenoCont;
import View.MenuPrincipal;

@SuppressWarnings("serial")
public class FormModificarTerreno extends JFrame {


	private JPanel Fondo;
	private static JTextField tfCodTerreno;
	private static JTextField tfCanTarea;
	private static JTextField tfFormAdqui;
	private static  JTextField tfFormRiego;
	private static JTextField tfDireccion;
	private static JFormattedTextField ftfFecha;
	private static JFormattedTextField ftfCedCliente;
	

	public FormModificarTerreno() throws ParseException {
		
		setTitle("Modificar Terreno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormModificarTerreno.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 486);
		Fondo = new JPanel();
		Fondo.setBackground(Color.WHITE);
		Fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Fondo);
		Fondo.setLayout(null);
		
		JLabel lbTitulo = new JLabel("Actualizar Informaci\u00F3n de Terreno");
		lbTitulo.setForeground(new Color(34, 139, 34));
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setBounds(100, 11, 401, 23);
		Fondo.add(lbTitulo);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu=new MenuPrincipal();
				menu.setVisible(true);
				hide();
			}
		});
		btnAtras.setToolTipText("Al dar clic retorna  a la ventana principal");
		btnAtras.setFocusPainted(false);
		btnAtras.setIcon(new ImageIcon(FormModificarTerreno.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(0, 0, 45, 40);
		Fondo.add(btnAtras);
		
		JLabel lbCodTerreno = new JLabel("C\u00F3digo Terreno:");
		lbCodTerreno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCodTerreno.setForeground(new Color(34, 139, 34));
		lbCodTerreno.setBounds(111, 58, 108, 29);
		Fondo.add(lbCodTerreno);
		
		tfCodTerreno = new JTextField();
		tfCodTerreno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c= e.getKeyChar();
				 if(!Character.isDigit(c))e.consume();
			}
		});
		tfCodTerreno.setToolTipText("Ingrese c\u00F3digo de terreno");
		tfCodTerreno.setForeground(new Color(0, 0, 0));
		tfCodTerreno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCodTerreno.setBounds(229, 58, 129, 29);
		Fondo.add(tfCodTerreno);
		tfCodTerreno.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								TerrenoCont unTerCtrl=new TerrenoCont();
								
								Terreno unTerreno=unTerCtrl.BuscarTerreno(tfCodTerreno.getText());
								if (unTerreno.resultado==true){
									tfDireccion.setText(unTerreno.getdireccion());
									tfDireccion.setEditable(true);
									tfCanTarea.setText(unTerreno.getcantidadTarea()+"");
									tfCanTarea.setEditable(true);
									tfFormAdqui.setText(unTerreno.getformAdquisicion());
									tfFormAdqui.setEditable(true);
									tfFormRiego.setText(unTerreno.getformaRiego());
									tfFormRiego.setEditable(true);
									ftfFecha.setText(unTerreno.getfechaTerreno());
									ftfFecha.setEditable(true);
									ftfCedCliente.setText(unTerreno.getcedCliente());
									ftfCedCliente.setEditable(true);
								
								
								}
					
				
			}
		});
		btnBuscar.setToolTipText("Dar clic para buscar informaci\u00F3n del terreno");
		btnBuscar.setForeground(new Color(34, 139, 34));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(386, 58, 89, 29);
		Fondo.add(btnBuscar);
		
		JLabel lbCedCliente = new JLabel("C\u00E9dula del Cliente:");
		lbCedCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbCedCliente.setForeground(new Color(34, 139, 34));
		lbCedCliente.setBounds(10, 365, 119, 23);
		Fondo.add(lbCedCliente);
		
		JLabel lblCantidadTarea = new JLabel("Cantidad Tarea:");
		lblCantidadTarea.setForeground(new Color(34, 139, 34));
		lblCantidadTarea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidadTarea.setBounds(10, 149, 119, 23);
		Fondo.add(lblCantidadTarea);
		
		JLabel lblFormaAdquisicion = new JLabel("Forma Adquisici\u00F3n:");
		lblFormaAdquisicion.setForeground(new Color(34, 139, 34));
		lblFormaAdquisicion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormaAdquisicion.setBounds(10, 203, 119, 23);
		Fondo.add(lblFormaAdquisicion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(new Color(34, 139, 34));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(10, 311, 119, 23);
		Fondo.add(lblFecha);
		
		MaskFormatter form = new MaskFormatter("####-##-##");
		form.setPlaceholderCharacter('_');
		 ftfFecha = new JFormattedTextField(form);
		ftfFecha.setEditable(false);
		ftfFecha.setForeground(new Color(0, 0, 0));
		ftfFecha.setToolTipText("Ingrese fecha ");
		ftfFecha.setBounds(133, 313, 263, 20);
		Fondo.add(ftfFecha);
		
		MaskFormatter forma = new MaskFormatter("###-#######-#");
		forma.setPlaceholderCharacter('_');
		
		 ftfCedCliente = new JFormattedTextField(forma);
		ftfCedCliente.setEditable(false);
		ftfCedCliente.setForeground(new Color(0, 0, 0));
		ftfCedCliente.setToolTipText("Ingrese c\u00E9dula del cliente");
		ftfCedCliente.setBounds(133, 367, 263, 20);
		Fondo.add(ftfCedCliente);
		
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
		});
		tfCanTarea.setEditable(false);
		tfCanTarea.setToolTipText(" cantidad de tarea del terreno");
		tfCanTarea.setForeground(new Color(0, 0, 0));
		tfCanTarea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCanTarea.setColumns(10);
		tfCanTarea.setBounds(133, 150, 263, 21);
		Fondo.add(tfCanTarea);
		
		tfFormAdqui = new JTextField();
		tfFormAdqui.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				 if((!Character.isLetter(c))&&(c !=KeyEvent.VK_SPACE) )e.consume();
			}
		});
		tfFormAdqui.setEditable(false);
		tfFormAdqui.setToolTipText("Forma en que obtuvo el terreno");
		tfFormAdqui.setForeground(new Color(0, 0, 0));
		tfFormAdqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFormAdqui.setColumns(10);
		tfFormAdqui.setBounds(133, 203, 263, 21);
		Fondo.add(tfFormAdqui);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TerrenoCont unTerreno=new TerrenoCont();

				
				unTerreno.ModificarTerreno(tfCodTerreno.getText(),tfDireccion.getText(), tfCanTarea.getText(), tfFormAdqui.getText(), tfFormRiego.getText(),ftfFecha.getText(), ftfCedCliente.getText());
			}
		});
		btnActualizar.setToolTipText("Clic para actualizar datos");
		btnActualizar.setForeground(new Color(34, 139, 34));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.setBounds(223, 401, 101, 23);
		Fondo.add(btnActualizar);
		
		JLabel lbFormRiego = new JLabel("Forma Riego:");
		lbFormRiego.setForeground(new Color(34, 139, 34));
		lbFormRiego.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFormRiego.setBounds(10, 254, 119, 23);
		Fondo.add(lbFormRiego);
		
		tfFormRiego = new JTextField();
		tfFormRiego.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				 if((!Character.isLetter(c))&&(c !=KeyEvent.VK_SPACE) )e.consume();
			}
		});
		tfFormRiego.setEditable(false);
		tfFormRiego.setToolTipText("Ingrese manera de regar");
		tfFormRiego.setForeground(new Color(0, 0, 0));
		tfFormRiego.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFormRiego.setColumns(10);
		tfFormRiego.setBounds(133, 257, 263, 21);
		Fondo.add(tfFormRiego);
		
		JLabel lblDirecci = new JLabel("Direcci\u00F3n:");
		lblDirecci.setForeground(new Color(34, 139, 34));
		lblDirecci.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDirecci.setBounds(10, 103, 119, 23);
		Fondo.add(lblDirecci);
		
		tfDireccion = new JTextField();
		tfDireccion.setEditable(false);
		tfDireccion.setToolTipText("Direcci\u00F3n del terreno");
		tfDireccion.setForeground(new Color(0, 0, 0));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(133, 104, 263, 21);
		Fondo.add(tfDireccion);

	}


	public static void resultado() {
		JOptionPane.showMessageDialog(null, "Los datos fueron modificados ");
		tfCodTerreno.setText("");
		tfDireccion.setText("");
		tfCanTarea.setText("");
		tfFormAdqui.setText("");
		ftfCedCliente.setText("");
		ftfFecha.setText("");
		tfFormRiego.setText("");
		tfCodTerreno.setEditable(true);
		tfDireccion.setEditable(false);
		tfCanTarea.setEditable(false);
		ftfCedCliente.setEditable(false);
		tfFormAdqui.setEditable(false);
		ftfFecha.setEditable(false);
		tfFormRiego.setEditable(false);
		
	}
}
