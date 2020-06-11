package seventeen.group.GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: ModifyBegin
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Modify begin.
 */
public class ModifyBegin extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * Instantiates a new Modify begin.
     */
    public ModifyBegin() {
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
		lblNewLabel_2.setBounds(69, 22, 405, 74);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to the management interface!");
		// 其实这里是，如果前面加入了那个login的话，我们肯定有一个txt包含了管理员信息，如果里面存储了管理员的名字的话，
		// 这个JLabel的文字部分可以动态生成。 String Name = "xxxx"; new JLabel(Name);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_3.setBounds(10, 89, 528, 61);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ingredients(Free)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new ModifyMenu2();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnNewButton.setBounds(146, 231, 246, 61);
		panel.add(btnNewButton);
		
		JButton btnModifyTheMenu = new JButton("Staple food");
		btnModifyTheMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new ModifyMenu1();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnModifyTheMenu.setFont(new Font("Segoe Print", Font.BOLD, 26));
		btnModifyTheMenu.setBounds(146, 160, 246, 61);
		panel.add(btnModifyTheMenu);
		
		JButton btnIngredientscharge = new JButton("Ingredients(Charge)");
		btnIngredientscharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new ModifyMenu3();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnIngredientscharge.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnIngredientscharge.setBounds(146, 302, 246, 61);
		panel.add(btnIngredientscharge);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new CheckMenu();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnReturn.setForeground(Color.BLUE);
		btnReturn.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnReturn.setBounds(146, 373, 246, 61);
		panel.add(btnReturn);
	}
}
