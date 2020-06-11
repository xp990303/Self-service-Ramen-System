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
 * @className: Registered
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Registered.
 */
public class Registered extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

    /**
     * The Bill.
     */
    Bill bill;
    /**
     * The Customer.
     */
    Customer customer = new Customer();

    /**
     * Create the application.
     *
     * @param bill the bill
     */
    public Registered(Bill bill) {
		this.bill = bill;
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
		
		final JLabel lblNewLabel = new JLabel("Please enter your information!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
		lblNewLabel.setBounds(68, 72, 405, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First name");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 121, 113, 49);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last name");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 178, 113, 49);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Phone");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(10, 230, 113, 49);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(10, 282, 113, 49);
		panel.add(lblNewLabel_2_3);

		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(325, 389, 176, 61);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD, 20));
		//textField.setBounds(126, 133, 375, 33);
		textField.setBounds(126, 187, 375, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("MV Boli", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(126, 133, 375, 33);
		//textField_1.setBounds(126, 187, 375, 33);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("MV Boli", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(126, 237, 375, 33);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("MV Boli", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(126, 289, 375, 33);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Whether to send you weekly statistics report");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setFont(new Font("MV Boli", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(-8, 332, 375, 49);
		panel.add(lblNewLabel_2_3_1);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MV Boli", Font.BOLD, 18));
		comboBox.setBounds(354, 342, 67, 33);
		comboBox.addItem("Yes");
	    	comboBox.addItem("No");
		panel.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("MV Boli", Font.BOLD, 20));
		textField_4.setBounds(428, 342, 73, 33);
		panel.add(textField_4);
		textField_4.setText(customer.getMsgChk());
		if(textField_4.getText().isEmpty())		textField_4.setText("Yes");
		textField_4.setColumns(10);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText((String)comboBox.getSelectedItem());
			}
		});

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				customer.setSurname(textField.getText());
				customer.setFirname(textField_1.getText());
				customer.setMobile(textField_2.getText());
				customer.setEmail(textField_3.getText());

				CustomerService customerService = new CustomerServiceImpl();
				customer = customerService.chkCustomer(customer);
				if(customer.getJudgeCode().equals("111"))  lblNewLabel.setText("Please enter your name!");
				if(customer.getJudgeCode().equals("001"))  lblNewLabel.setText("Please enter Email/Tel!");
				if(customer.getJudgeCode().equals("010"))  lblNewLabel.setText("Incorrect first name format!");
				if(customer.getJudgeCode().equals("011"))  lblNewLabel.setText("Incorrect last name format!");
				if(customer.getJudgeCode().equals("100"))  lblNewLabel.setText("Incorrect Email format!");
				if(customer.getJudgeCode().equals("101"))  lblNewLabel.setText("Incorrect phone format!");
				if(customer.getJudgeCode().equals("000"))  {
					try {
						customer.setMobile(textField_2.getText());
						customer.setEmail(textField_3.getText());
						customer = customerService.chkExist(customer);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					if(customer.getJudgeCode().equals("000")){
						customer.setMsgChk(textField_4.getText());
						try {
							customer = customerService.chkCustomer(customer);
							customer = customerService.setCustomerMsg(customer);
							if(customer.getUid().isEmpty() || customerService.saveCustomer(customer) == 0){
								System.out.println("Uh-oh! Program crashed! File customer cannot be found!");
								System.exit(0);
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						frmRamenBuffetSystem.setVisible(false);
						new Registered2(bill, customer);
					}
					else{
						frmRamenBuffetSystem.setVisible(false);
						new Registered1(bill, customer);
					}
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(41, 389, 176, 61);
		panel.add(btnNewButton_1);
	}
}