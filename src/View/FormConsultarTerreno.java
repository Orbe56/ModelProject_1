package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Domain.Terreno;
import Domain.TerrenoCont;
import View.MenuPrincipal;

@SuppressWarnings("serial")
public class FormConsultarTerreno extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfCodTerreno;
	private static JTextArea taMostrar;
	
	public FormConsultarTerreno() {
		
		setTitle("Ventana consultar Terreno");
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormConsultarTerreno.class.getResource("/Imagenes/IconoP.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.setFocusPainted(false);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				MenuPrincipal volver=new MenuPrincipal();
				volver.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.setIcon(new ImageIcon(FormConsultarTerreno.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(213, 31, 38, 42);
		contentPane.add(btnAtras);
		
		JLabel lbTitulo = new JLabel("Consultar Informaci\u00F3n de Terreno");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTitulo.setForeground(new Color(34, 139, 34));
		lbTitulo.setBounds(10, 103, 438, 16);
		contentPane.add(lbTitulo);
		
		 taMostrar = new JTextArea();
		taMostrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		taMostrar.setForeground(new Color(102, 51, 51));
		taMostrar.setEditable(false);
		taMostrar.setToolTipText("Muestra informaci\u00F3n del terreno");
		taMostrar.setBounds(30, 178, 385, 181);
		
        contentPane.add(taMostrar);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				taMostrar.setText("");
					
					TerrenoCont buscar=new TerrenoCont();
					Terreno unTerreno=buscar.BuscarTerreno(tfCodTerreno.getText());
					if(unTerreno.resultado==true){
					taMostrar.append("\n	Código Terreno: "+unTerreno.getcodTerreno());
					taMostrar.append("\n	Ubicación: "+unTerreno.getdireccion());
					taMostrar.append("\n	Cantidad de tareas: "+unTerreno.getcantidadTarea());
					taMostrar.append("\n	Forma de Adquisición: "+unTerreno.getformAdquisicion());
					taMostrar.append("\n	Tipo de Riego: "+unTerreno.getformaRiego());
					taMostrar.append("\n	Fecha de registro: "+unTerreno.getfechaTerreno());
					taMostrar.append("\n	cedPropietari@: "+unTerreno.getcedCliente());
					}
					
				
				
			}
		});
		btnBuscar.setToolTipText("Dar clic luego de ingresar el c\u00F3digo para buscar la informaci\u00F3n del terreno");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setForeground(new Color(34, 139, 34));
		btnBuscar.setBounds(306, 144, 89, 23);
		contentPane.add(btnBuscar);
		
		tfCodTerreno = new JTextField();
		tfCodTerreno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char e=evt.getKeyChar();
				if(e<'0'||e>'9')evt.consume();
			}
		});
		tfCodTerreno.setToolTipText("Ingrese c\u00F3digo del terreno");
		tfCodTerreno.setBounds(127, 144, 136, 20);
		contentPane.add(tfCodTerreno);
		tfCodTerreno.setColumns(10);
		
		JLabel lbCodTerreno = new JLabel("C\u00F3digo Terreno:");
		lbCodTerreno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbCodTerreno.setForeground(new Color(34, 139, 34));
		lbCodTerreno.setBounds(10, 147, 122, 16);
		contentPane.add(lbCodTerreno);
	
	}	
}
