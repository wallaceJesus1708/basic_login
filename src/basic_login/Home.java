package basic_login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965073239613736995L;
	private JPanel contentPane;
	
	public Home() {
		
	}
	
	public Home(String usuarioLogado) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setForeground(new Color(0,0,0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton, "Tem certeza");
				
				if(a == JOptionPane.YES_OPTION) {
					dispose();
					UsuarioLogin ul = new UsuarioLogin();
					ul.setTitle("usuário logado");
					ul.setVisible(true);
				}
				dispose();
				UsuarioLogin ul = new UsuarioLogin();
				
				ul.setTitle("usuário logado");
				ul.setVisible(true);
				
			}
		});
		
		btnNewButton.setBounds(247, 118, 491, 114);
		contentPane.add(btnNewButton);
		JButton button = new JButton("Aterar senha\r\n");
		button.setBackground(UIManager.getColor("Button.disabledForeground"));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlterarSenha as = new AlterarSenha(usuarioLogado);
				as.setTitle("Alterar Senha");
				as.setVisible(true);
				
			}
		});
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button.setBounds(247, 320, 491, 114);
		contentPane.add(button);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
