package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
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

import Domain.Factura;
import Domain.FacturaCont;
import View.MenuPrincipalC;

@SuppressWarnings("serial")
public class FormConsultarPagos extends JFrame {
	

	private JPanel fondo;
	private static  JTextArea taMostrar;
	private static  JFormattedTextField ftfYear;


	public FormConsultarPagos() throws ParseException {
		
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormConsultarPagos.class.getResource("/Imagenes/IconoP - copia.ico")));
		setTitle("Consultar pagos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 442);
		fondo = new JPanel();
		fondo.setBackground(Color.WHITE);
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo);
		fondo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de los Terrenos Pagos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setBounds(10, 57, 404, 20);
		fondo.add(lblNewLabel);
		
		JLabel lbConsultar = new JLabel("A\u00F1o a consultar:");
		lbConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbConsultar.setForeground(new Color(34, 139, 34));
		lbConsultar.setBounds(33, 107, 120, 14);
		fondo.add(lbConsultar);
		
		 taMostrar = new JTextArea();
		 
		
		 taMostrar.setToolTipText("Muestra los terrenos pagos");
		 taMostrar.setFont(new Font("Verdana", Font.PLAIN, 12));
		 taMostrar.setForeground(new Color(0, 0, 0));
		 taMostrar.setEditable(false);
		
		 JScrollPane scroll = new JScrollPane(taMostrar);    
 scroll.setBounds(new Rectangle(33,165,362,228)); 
 fondo.add(scroll);
		
 MaskFormatter forma = new MaskFormatter("####");
	
 ftfYear = new JFormattedTextField(forma);
 ftfYear.setFont(new Font("Verdana", Font.PLAIN, 12));
	ftfYear.setToolTipText("Ingrese el a\u00F1o a consultar");
	ftfYear.setForeground(new Color(0, 0, 0));
	ftfYear.setBounds(163, 105, 89, 20);
	fondo.add(ftfYear);
 
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)  {
				
				taMostrar.setText("");
				
					FacturaCont buscar=new FacturaCont();
					buscar.consultarPagos(ftfYear.getText());	
			}
		});
		
		btnBuscar.setToolTipText("Clic aqui luego de ingresar el a\u00F1o");
		btnBuscar.setForeground(new Color(34, 139, 34));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(306, 103, 89, 23);
		fondo.add(btnBuscar);
		
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipalC volver=new MenuPrincipalC();
				volver.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setFocusPainted(false);
		btnAtras.setToolTipText("Retorna a la ventana principal");
		btnAtras.setIcon(new ImageIcon(FormConsultarPagos.class.getResource("/Imagenes/IconoP.png")));
		btnAtras.setBounds(192, 11, 43, 39);
		fondo.add(btnAtras);	
	}


	public static void mostrarPagos(ArrayList<Factura> unaFact) {
		
		taMostrar.append("Código	Fecha	Monto	Dirección  Terreno\n");
		if((unaFact.isEmpty()==false)){
			
			for(int i=0;i<unaFact.size();i++){
				taMostrar.append("\n"+unaFact.get(i).getCodigo()+"	"+unaFact.get(i).getFechaRegPago()+"	"+unaFact.get(i).getMonto()+"      "+unaFact.get(i).getDirreccion());
			}
		taMostrar.append("\n");
		
	}else{
		ftfYear.setValue(null);
	}
	}
}
