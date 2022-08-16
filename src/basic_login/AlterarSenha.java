package basic_login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlterarSenha extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8682312472632152394L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterNewPassword;
	
	public AlterarSenha(String nome) {
		
		setBounds(450, 360, 1024, 234);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField.setBounds(373, 35, 609, 67);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Enter");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pstr = textField.getText();
				try {
					System.out.println("Atualize a senha "+nome);
					System.out.println("Senha atualizada");
					
					String URL = "jdbc:mysql://localhost:3306/registro";
					String USER = "root";
					String PASS = "root";
					
					Connection con = (Connection) DriverManager.getConnection(URL, USER, PASS);
					
					PreparedStatement st = (PreparedStatement) con
							.prepareStatement("Update acesso set senha=? where nome=?");
					
					st.setString(1, pstr);
					st.setString(2, nome);
					st.executeUpdate();
					JOptionPane.showMessageDialog(btnSearch, "Senha atualizada com sucesso");
					
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				
			}
		});
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);
		
		lblEnterNewPassword = new JLabel("Digite nova senha:");
		lblEnterNewPassword.setFont(new Font("Tahome", Font.PLAIN, 30));
		lblEnterNewPassword.setBounds(45, 37, 326, 67);
		contentPane.add(lblEnterNewPassword);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}
