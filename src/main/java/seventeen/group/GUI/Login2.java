package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.CustomerService;
import seventeen.group.Service.Impl.CustomerServiceImpl;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: Login2
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Login 2.
 */
public class Login2 extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * The Bill.
     */
    Bill bill;
    /**
     * The Customer.
     */
    Customer customer = new Customer();
	private JPasswordField passwordField;
	private JTextField textField;


    /**
     * Create the application.
     *
     * @param bill the bill
     */
    public Login2(Bill bill) {
		this.bill= bill;
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		final JLabel lblNewLabel = new JLabel("Please enter your membership number!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 126, 528, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 42, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(314, 366, 176, 61);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerService customerService = new CustomerServiceImpl();
				try {
					customer = customerService.getCustMsg(passwordField.getText());
					if(customer.getJudgeCode().equals("000")){
						frmRamenBuffetSystem.setVisible(false);
						new Pay1(bill, customer);
					}
					if(customer.getJudgeCode().equals("110")){
						System.out.println("Oh my god! We cannot find customer file...");
						System.exit(0);
					}
					if(customer.getJudgeCode().equals("111")){
						lblNewLabel.setText("This userID does not exit");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(49, 366, 176, 61);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number:");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2.setBounds(20, 209, 118, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Display:");
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(21, 265, 117, 46);
		panel.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("MV Boli", Font.BOLD, 24));
		passwordField.setEchoChar('*');
		passwordField.setBounds(140, 209, 350, 46);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD, 24));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(140, 265, 351, 46);
		panel.add(textField);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Display");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					String str = passwordField.getText();
					textField.setText(str);
				}
				else
					textField.setText(null);
			}
		});
		chckbxNewCheckBox.setFont(new Font("MV Boli", Font.BOLD, 24));
		chckbxNewCheckBox.setBounds(372, 317, 118, 39);
		panel.add(chckbxNewCheckBox);

	}
}