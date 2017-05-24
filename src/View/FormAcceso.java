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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Domain.UsuarioCont;


@SuppressWarnings("serial")
public class FormAcceso extends JFrame {


	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField tfContrasena;
	private JButton btnAccesar;
  
	public FormAcceso() {
	
	
		setTitle("Ventana Iniciar Sesion");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setForeground(new Color(34, 139, 34));
		lblUsuario.setBounds(24, 122, 96, 27);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					tfContrasena.requestFocus();
	
				}
				
			}
		});
		
		tfUsuario.setToolTipText("Ingrese su nombre de usuario");
		tfUsuario.setForeground(new Color(34, 139, 34));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(128, 119, 156, 27);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setForeground(new Color(34, 139, 34));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasena.setBounds(24, 195, 110, 27);
		contentPane.add(lblContrasena);
		
		tfContrasena = new JPasswordField();
		
		tfContrasena.setToolTipText("Ingrese su contrase\u00F1a, por seguridad se mostrara en asterisco");
		tfContrasena.setForeground(new Color(34, 139, 34));
		tfContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfContrasena.setBounds(128, 193, 156, 27);
		contentPane.add(tfContrasena);
		
		JButton btnIcono = new JButton("");
		
		btnIcono.setFocusable(false);
		btnIcono.setFocusPainted(false);
		btnIcono.setBounds(139, 11, 78, 84);
		contentPane.add(btnIcono);
		
		 btnAccesar = new JButton("Acceder");
		
		btnAccesar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean estado;
				
				UsuarioCont unUser=new UsuarioCont();
				estado=unUser.iniciarSesion(tfUsuario.getText(),tfContrasena.getText());
				if (estado){
					hide();
				
				}
				else{
					tfUsuario.setText("");
					tfContrasena.setText("");
				}
			}

						
		});
		
		btnAccesar.setToolTipText("Haga clic luego de ingresar su usuario y contrase\u00F1a");
		btnAccesar.setFocusPainted(false);
		btnAccesar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAccesar.setForeground(new Color(34, 139, 34));
		btnAccesar.setBounds(128, 273, 102, 29);
		contentPane.add(btnAccesar);
}

}
