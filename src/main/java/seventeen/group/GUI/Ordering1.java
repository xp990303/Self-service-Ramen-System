package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
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
import java.util.Calendar;

/**
 * @className: Ordering1
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Ordering 1.
 */
public class Ordering1 extends JFrame{

	private JFrame frmRamenBuffetSystem1;

    /**
     * The Bill.
     */
    Bill bill = new Bill();
    /**
     * The Price.
     */
    Price price = new Price();

    /**
     * Create the application.
     *
     * @throws IOException the io exception
     */
    public Ordering1() throws IOException {
		PriceService priceService = new PriceServiceImpl();
		this.price = priceService.getPrice();
		initialize();
		frmRamenBuffetSystem1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRamenBuffetSystem1 = new JFrame();
		frmRamenBuffetSystem1.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem1.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem1.setBounds(100, 100, 582, 529);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		frmRamenBuffetSystem1.setLocation((screenWidth - 582)/2, (screenHeight-529)/2);
		frmRamenBuffetSystem1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem1.setVisible(false);
				new Start();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(187, 378, 176, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please choose staple food!");
		Calendar calendar = Calendar.getInstance();
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(90, 89, 361, 66);
		panel.add(lblNewLabel);
		if(weekDay == 4){
			lblNewLabel.setText("Thursday half price!");
		}
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 24, 405, 74);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "The staple food", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(42, 152, 455, 216);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Ramen   \uFFE1" + price.getRamen());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem1.setVisible(false);
				try {
					new Ordering2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 28));
		btnNewButton_2.setBounds(63, 26, 331, 59);
		panel_1.add(btnNewButton_2);
	}
}