package seventeen.group.GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @className: ManageLogin
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Manage login.
 */
public class ManageLogin extends JFrame {

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public ManageLogin() {
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Initialize.
	 */
	public void initialize() {
		frmRamenBuffetSystem = new JFrame();
		frmRamenBuffetSystem.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem.setBounds(100, 100, 582, 529);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		frmRamenBuffetSystem.setLocation((screenWidth - 582)/2, (screenHeight-529)/2);
		frmRamenBuffetSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("Please enter your manage password!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 125, 528, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 41, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=new String(passwordField_1.getPassword());
				if(password.equals("2020")) {
					frmRamenBuffetSystem.setVisible(false);
					new Manage();
				}
				else
					lblNewLabel.setText("Wrong password! Please try again!");
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(49, 366, 176, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Start();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(314, 366, 176, 61);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2.setBounds(20, 200, 118, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Display:");
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(21, 256, 117, 46);
		panel.add(lblNewLabel_2_1);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Display");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					String str=new String(passwordField_1.getPassword());
					textField.setText(str);
				}
				else
				{
					textField.setText(null);
				}
			}
		});

		chckbxNewCheckBox.setFont(new Font("MV Boli", Font.BOLD, 24));
		chckbxNewCheckBox.setBounds(372, 308, 118, 39);
		panel.add(chckbxNewCheckBox);

		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.setFont(new Font("MV Boli", Font.BOLD, 24));
		textField.setBounds(140, 256, 351, 46);
		panel.add(textField);
		textField.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("MV Boli", Font.BOLD, 24));
		passwordField_1.setBounds(140, 200, 350, 46);
		//void addKeyListener(KeyListener listener)
		passwordField_1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent keyEvent) {}
			@Override
			public void keyPressed(KeyEvent keyEvent) {}
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if(chckbxNewCheckBox.isSelected()) {
					String password=new String(passwordField_1.getPassword());
					textField.setText(password);
				}
				else
				{
					textField.setText(null);
				}
			}
		});
		passwordField_1.setEchoChar('*');
		panel.add(passwordField_1);
	}
}
