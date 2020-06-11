package seventeen.group.GUI;

import seventeen.group.Entity.Price;
import seventeen.group.Service.Impl.PriceServiceImpl;
import seventeen.group.Service.PriceService;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: ModifyMenu1
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Modify menu 1.
 */
public class ModifyMenu1 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JTextField textField_2;

    /**
     * The Price.
     */
    Price price = new Price();

    /**
     * Create the application.
     *
     * @throws IOException the io exception
     */
    public ModifyMenu1() throws IOException {
		PriceService priceService = new PriceServiceImpl();
		this.price = priceService.getPrice();
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
		
		final JLabel lblNewLabel = new JLabel("Please write down the price you want to modify!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 90, 528, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Return");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new ModifyBegin();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(332, 386, 176, 61);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: Roman");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2.setBounds(38, 180, 285, 38);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.setFont(new Font("MV Boli", Font.BOLD, 22));
		textField.setBounds(147, 297, 176, 38);
		textField.setText(String.valueOf(price.getRamen()));
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(332, 297, 176, 38);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Now");
		lblNewLabel_2_3.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_3.setBounds(166, 240, 93, 38);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("After");
		lblNewLabel_2_5.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_5.setBounds(368, 240, 93, 38);
		panel.add(lblNewLabel_2_5);
		
		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtpnPrice.setText("Price(\uFFE1):");
		txtpnPrice.setEditable(false);
		txtpnPrice.setBackground(SystemColor.control);
		txtpnPrice.setBounds(38, 297, 132, 38);
		panel.add(txtpnPrice);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PriceService priceService = new PriceServiceImpl();
				if(!textField_2.getText().isEmpty() && priceService.chkPriceData(textField_2.getText()) != -1.00) {
					price.setRamen(Double.parseDouble(textField_2.getText()));
					try {
						priceService.chgPriceData(price);
						priceService.setPrice(price);
						lblNewLabel.setText("Ramen price has been changed!");
						//new ModifyMenu1();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				if(textField_2.getText().isEmpty())
					lblNewLabel.setText("Please write down the price you want to modify!");
				else if(priceService.chkPriceData(textField_2.getText()) == -1.00)
					lblNewLabel.setText("Please enter the correct price format.");
				textField.setText(String.valueOf(price.getRamen()));
				textField_2.setText("");
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);
	}
}