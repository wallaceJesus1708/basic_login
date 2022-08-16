package basic_login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UsuarioLogin  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7824289339739799024L;

	
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel label;
	private JPanel contentPane;
	
	public UsuarioLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(423, 13, 273, 93);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481, 170, 281, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 286, 281, 68);
		contentPane.add(passwordField);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBackground(Color.black);
		lblUserName.setForeground(Color.black);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUserName.setBounds(250, 166, 193, 52);
		contentPane.add(lblUserName);
		
		JLabel lblPassWord = new JLabel("Password");
		lblPassWord.setForeground(Color.black);
		lblPassWord.setBackground(Color.black);
		lblPassWord.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassWord.setBounds(250, 286, 193, 52);
		contentPane.add(lblPassWord);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(545, 392, 162, 73);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				String URL = "jdbc:mysql://localhost:3306/registro";
				String USER = "root";
				String PASS = "root";
							
				try {
					Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASS);
					
					PreparedStatement st = (PreparedStatement) connection
							.prepareStatement("select nome, senha from acesso where nome=? and senha=?");
					
					st.setString(1, userName);
					st.setString(2, password);
					ResultSet rs = st.executeQuery();
					if(rs.next()) {
						dispose();
						Home ah = new Home(userName);
						ah.setTitle("Bem vindo");
						ah.setVisible(true);
						JOptionPane.showMessageDialog(btnNewButton, "Logado com sucesso");
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Usuário ou senha incorretos");
					}
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				
			}
		});
		
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setBounds(0,0,1008,562);
		contentPane.add(label);
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UsuarioLogin frame = new UsuarioLogin();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}

				
			}
		});
		
	}
	
	
}
