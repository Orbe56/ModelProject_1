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
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Domain.FacturaCont;
import View.MenuPrincipalC;

@SuppressWarnings("serial")
public class FormFacturarPago extends JFrame {


	private JPanel Fondo;
	private static JTextField tfCodTerreno;
	private static JTextField tfPropietario;
	public static  JTextField tfMonto;
	private JTextField tfCodEmp;
	private static JFormattedTextField ftfCedCliente;
	private static JFormattedTextField ftfYear;
	

	public FormFacturarPago() throws ParseException {
		
		setTitle("Facturar Pago");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormFacturarPago.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		Fondo = new JPanel();
		Fondo.setBackground(new Color(224, 255, 255));
		Fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Fondo);
		Fondo.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Retorna al menu principal");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipalC menuPagos=new MenuPrincipalC();
				menuPagos.setVisible(true);
				hide();
			}
		});
		btnNewButton.setIcon(new ImageIcon(FormFacturarPago.class.getResource("/Imagenes/IconoP.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(238, 11, 40, 41);
		Fondo.add(btnNewButton);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setToolTipText("Boton que al dar clic muestra el monto, propietari@ y su codigo");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FacturaCont unaFactura= new FacturaCont();
				unaFactura.ConsultarDatos(tfCodTerreno.getText(),ftfYear.getText());
			}
		});
		btnConsultar.setFocusPainted(false);
		btnConsultar.setForeground(new Color(34, 139, 34));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(404, 92, 100, 23);
		Fondo.add(btnConsultar);
		
		JButton btnCancelar = new JButton("Borrar");
		btnCancelar.setToolTipText("Boton que al dar clic borra la informacion de todos los campos");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfCodTerreno.setText("");
				tfCodTerreno.setEditable(true);
				ftfYear.setText("");
				ftfYear.setEditable(true);
				tfMonto.setText("");
				tfPropietario.setText("");
				ftfCedCliente.setText("");
				tfCodEmp.setText("");
			}
		});
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setForeground(new Color(34, 139, 34));
		btnCancelar.setBounds(110, 229, 89, 23);
		Fondo.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo Terreno:");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 96, 100, 14);
		Fondo.add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("A\u00F1o a pagar:");
		lblFecha.setForeground(new Color(34, 139, 34));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(206, 96, 89, 14);
		Fondo.add(lblFecha);
		
		MaskFormatter forma = new MaskFormatter("###-#######-#");
		forma.setPlaceholderCharacter('_');
		ftfCedCliente = new JFormattedTextField(forma);
		ftfCedCliente.setForeground(new Color(0, 0, 0));
		ftfCedCliente.setToolTipText("Campo que muestra el n\u00FAmero de c\u00E9dula del cliente");
		ftfCedCliente.setEditable(false);
		ftfCedCliente.setBounds(125, 164, 159, 20);
		Fondo.add(ftfCedCliente);
		
		MaskFormatter form = new MaskFormatter("####");
		ftfYear = new JFormattedTextField(form);
		ftfYear.setForeground(new Color(0, 0, 0));
		ftfYear.setToolTipText("Ingrese a\u00F1o a pagar o consultar");
		ftfYear.setBounds(297, 94, 71, 20);
		Fondo.add(ftfYear);
		
		JLabel lblMonto = new JLabel("Propietari@:");
		lblMonto.setForeground(new Color(34, 139, 34));
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonto.setBounds(10, 135, 89, 17);
		Fondo.add(lblMonto);
		
		MaskFormatter formato = new MaskFormatter("##.##.####");
		formato.setPlaceholderCharacter('_');
		
		
		tfCodTerreno = new JTextField();
		tfCodTerreno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c))e.consume();
			}
		});
		tfCodTerreno.setToolTipText("Campo para ingresar el c\u00F3digo del terreno");
		tfCodTerreno.setForeground(new Color(0, 0, 0));
		tfCodTerreno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCodTerreno.setBounds(110, 93, 86, 20);
		Fondo.add(tfCodTerreno);
		tfCodTerreno.setColumns(10);
		
		tfPropietario = new JTextField();
		tfPropietario.setToolTipText("Campo que muestra nombre del propietario del terreno");
		tfPropietario.setEditable(false);
		tfPropietario.setForeground(new Color(0, 0, 0));
		tfPropietario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfPropietario.setColumns(10);
		tfPropietario.setBounds(109, 133, 259, 20);
		Fondo.add(tfPropietario);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setForeground(new Color(34, 139, 34));
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFactura.setBounds(10, 51, 494, 14);
		Fondo.add(lblFactura);
		
		JLabel label = new JLabel("Monto:");
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(291, 167, 46, 14);
		Fondo.add(label);
		
		tfMonto = new JTextField();
		tfMonto.setToolTipText("Campo que muestra el monto adeudado segun la fecha especificada");
		tfMonto.setEditable(false);
		tfMonto.setForeground(new Color(0, 0, 0));
		tfMonto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMonto.setColumns(10);
		tfMonto.setBounds(347, 164, 86, 20);
		Fondo.add(tfMonto);
		
		JLabel lblCodigoCliente = new JLabel("N\u00FAmero de C\u00E9dula:");
		lblCodigoCliente.setForeground(new Color(34, 139, 34));
		lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoCliente.setBounds(10, 163, 115, 23);
		Fondo.add(lblCodigoCliente);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setToolTipText("Boton que al dar clic almacena el pago del terreno");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturaCont unCtrlFactura=new FacturaCont();
				boolean estado=unCtrlFactura.Guardar( ftfYear.getText(), tfMonto.getText(), tfCodTerreno.getText(), tfCodEmp.getText(), ftfCedCliente.getText());
				
				if(estado==true){
					tfMonto.setText("");
					tfPropietario.setText("");
					ftfCedCliente.setText("");
					tfCodTerreno.setText("");
					tfCodEmp.setText("");
					ftfYear.setText("");
					ftfYear.setEditable(true);
					tfCodTerreno.setEditable(true);
				}
			}
		});
		btnRegistrar.setForeground(new Color(34, 139, 34));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBounds(316, 229, 100, 23);
		Fondo.add(btnRegistrar);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo Empleado:");
		lblCdigoEmpleado.setForeground(new Color(34, 139, 34));
		lblCdigoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoEmpleado.setBounds(10, 197, 123, 23);
		Fondo.add(lblCdigoEmpleado);
		
		tfCodEmp = new JTextField();
		tfCodEmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c))e.consume();
			}
		});
		tfCodEmp.setToolTipText("Campo para ingresar el c\u00F3digo del Empleado");
		tfCodEmp.setForeground(new Color(0, 0, 0));
		tfCodEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCodEmp.setColumns(10);
		tfCodEmp.setBounds(130, 195, 117, 20);
		Fondo.add(tfCodEmp);

	}


	public static void mostrarDatos(String propietario, String cedC, double valor) {
		tfCodTerreno.setEditable(false);
		ftfYear.setEditable(false);
		
		tfPropietario.setText(propietario);
		ftfCedCliente.setText(cedC);
		tfMonto.setText(valor+"");
		
	}
	

}
