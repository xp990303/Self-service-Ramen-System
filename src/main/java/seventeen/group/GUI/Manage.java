package seventeen.group.GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: Manage
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Manage.
 */
public class Manage extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * Instantiates a new Manage.
     */
    public Manage() {
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Create the frame.
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
		
		JLabel lblNewLabel_2 = new JLabel("Toroto Ramen");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(69, 39, 405, 74);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to the management interface!");
		// 其实这里是，如果前面加入了那个login的话，我们肯定有一个txt包含了管理员信息，如果里面存储了管理员的名字的话，
		// 这个JLabel的文字部分可以动态生成。 String Name = "xxxx"; new JLabel(Name);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_3.setBounds(10, 124, 528, 61);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("View statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Sales();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 21));
		btnNewButton.setBounds(177, 277, 185, 61);
		panel.add(btnNewButton);
		
		JButton btnModifyTheMenu = new JButton("Check the menu");
		btnModifyTheMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new CheckMenu();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnModifyTheMenu.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnModifyTheMenu.setBounds(177, 195, 185, 61);
		panel.add(btnModifyTheMenu);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Start();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(177, 358, 185, 61);
		panel.add(btnNewButton_1);
	}
}
