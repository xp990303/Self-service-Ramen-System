package seventeen.group.GUI;

import seventeen.group.Entity.Available;
import seventeen.group.Entity.Price;
import seventeen.group.Service.AvailableService;
import seventeen.group.Service.Impl.AvailableServiceImpl;
import seventeen.group.Service.Impl.PriceServiceImpl;
import seventeen.group.Service.PriceService;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: CheckMenu
 * @author: Group 17
 * @date: 2020/5/21
 * @description: The type check menu.
 */
public class CheckMenu extends JFrame{

	private JFrame frmRamenBuffetSystem;

	/**
	 * The Txtpn you already have.
	 */
	JTextPane txtpnYouAlreadyHave = new JTextPane();

	/**
	 * The Available.
	 */
	Available available;
	/**
	 * The Price.
	 */
	Price price;

	/**
	 * Create the application.
	 *
	 * @throws IOException the io exception
	 */
	public CheckMenu() throws IOException {
		PriceService priceService = new PriceServiceImpl();
		this.price = priceService.getPrice();
		AvailableService availableService = new AvailableServiceImpl();
		this.available = availableService.getAvailableMsg();
		if(available.getJudgeCode().equals("01")){
			System.out.println("Ah, file Available has some problem.");
			System.exit(0);
		}
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Insert.
	 *
	 * @param str     the str
	 * @param attrSet the attr set
	 */
	public void insert(String str, AttributeSet attrSet){
		Document doc = txtpnYouAlreadyHave.getDocument();
		try {
			doc.insertString(doc.getLength(),   str,  attrSet);
		}
		catch (BadLocationException e) {
			System.out.println("BadLocationException:   " + e);
		}
	}

	/**
	 * Set docs.
	 *
	 * @param str      the str
	 * @param col      the col
	 * @param bold     the bold
	 * @param fontSize the font size
	 * @param name     the name
	 */
	public   void   setDocs(String   str,Color   col,boolean   bold,int   fontSize, String name){
		SimpleAttributeSet attrSet   =   new   SimpleAttributeSet();
		StyleConstants.setForeground(attrSet,   col);
		if(bold==true){
			StyleConstants.setBold(attrSet,   true);
		}
		StyleConstants.setFontSize(attrSet,   fontSize);
		StyleConstants.setFontFamily(attrSet,   name);
		insert(str,  attrSet);
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
		
		JLabel lblNewLabel = new JLabel("Here is all the menu information!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(38, 64, 470, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new ModifyBegin();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);

		setDocs("Price(GBP) of bill and status\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("staple food:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Ramen           ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getRamen()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ingredients(Free):\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Soup-Tonkotsu   ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getSoupTonkotsu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Soup-Shoyu      ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getSoupShoyu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Soup-Shio        ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getSoupShio()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle-Firm      ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getNoodleFirm()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle-Medium   ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getNoodleMedium()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle-Soft      ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getNoodleSoft()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Onion            ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getOnion()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Nori             ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getNori()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Chashu           ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getChashu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Boiled Egg        ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getBoiledEgg()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness         ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getSpiciness()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Bamboo          ",Color.BLACK,true,22,"MV Boli");
		setDocs("free   "+available.getBambooShoot()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ingredients:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Extra Nori       ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getExNori() + "   " + available.getNori()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Extra Bamboo    ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getExBamboo() + "   " + available.getBambooShoot() +"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Extra Egg        ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getExEgg() + "   " + available.getBoiledEgg() +"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Extra Chashu     ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getExChashu() + "   " + available.getChashu(),Color.BLUE,true,22,"MV Boli");

		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setBounds(66, 125, 406, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0);
		
		JButton btnNewButton_1_1 = new JButton("Return");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Manage();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(332, 386, 176, 61);
		panel.add(btnNewButton_1_1);
	}
}