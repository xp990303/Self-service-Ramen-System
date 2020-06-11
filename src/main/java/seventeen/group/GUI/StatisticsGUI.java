package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.MostPopMeal;
import seventeen.group.Entity.Statistics;
import seventeen.group.Service.BillService;
import seventeen.group.Service.Impl.BillServiceImpl;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: StatisticsGUI
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Statistics gui.
 */
public class StatisticsGUI extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

    /**
     * The Statistics.
     */
    Statistics statistics = new Statistics();
    /**
     * The Most pop meal.
     */
    MostPopMeal mostPopMeal = new MostPopMeal();

    /**
     * Create the application.
     *
     * @param statistics the statistics
     */
    public StatisticsGUI(Statistics statistics) {
		this.statistics = statistics;
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
		
		JLabel lblNewLabel = new JLabel("This is the sales report for last week!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 23));
		lblNewLabel.setBounds(38, 73, 470, 66);
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
				try {
					new Sales();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(332, 382, 176, 61);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2.setBounds(109, 149, 93, 38);
		panel.add(lblNewLabel_2);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MV Boli", Font.BOLD, 26));
		comboBox.setBounds(194, 149, 241, 38);
		comboBox.addItem("Soup");
	    comboBox.addItem("Noodles");
	    comboBox.addItem("Spring onion");
	    comboBox.addItem("Nori");
	    comboBox.addItem("Chashu");
	    comboBox.addItem("Boiled egg");
	    comboBox.addItem("Spiciness");
	    comboBox.addItem("Extra Nori");
	    comboBox.addItem("Extra boiled egg");
	    comboBox.addItem("Bamboo shoots");
	    comboBox.addItem("Extra Chashu");
		panel.add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Favorite:");
		lblNewLabel_2_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_2.setBounds(67, 260, 135, 38);
		panel.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setFont(new Font("MV Boli", Font.BOLD, 22));
		textField.setBounds(194, 205, 241, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.text);
		textField_1.setEditable(false);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_1.setColumns(10);
		textField_1.setBounds(194, 260, 241, 38);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total sales:");
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_1.setBounds(38, 205, 164, 38);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Individual sales:");
		lblNewLabel_2_1_1.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_1_1.setBounds(26, 318, 176, 38);
		panel.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("MV Boli", Font.BOLD, 22));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(194, 318, 241, 38);
		panel.add(textField_2);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 382, 176, 61);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillService billService = new BillServiceImpl();
				mostPopMeal = billService.getSelfMost(statistics, (String)comboBox.getSelectedItem());
				textField.setText(Integer.toString(statistics.getTotalBill()));
				textField_1.setText(mostPopMeal.getName());
				textField_2.setText(Integer.toString(mostPopMeal.getValue()));
			}
		});
		panel.add(btnNewButton_1);
	}
}