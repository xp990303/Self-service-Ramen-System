package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Price;
import seventeen.group.Service.Impl.BillServiceImpl;
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
 * @className: Ordering4
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Ordering 4.
 */
public class Ordering4 extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * The Txtpn order information.
     */
    JTextPane txtpnOrderInformation = new JTextPane();

    /**
     * The Bill.
     */
    Bill bill;
    /**
     * The Price.
     */
    Price price;

    /**
     * Create the application.
     *
     * @param bill the bill
     * @throws IOException the io exception
     */
    public Ordering4(Bill bill) throws IOException {

		PriceService priceService = new PriceServiceImpl();
		BillServiceImpl cb = new BillServiceImpl();
		this.price = priceService.getPrice();
		this.bill = cb.setBillMsg(bill);
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
		Document doc   =   txtpnOrderInformation.getDocument();
		try   {
			doc.insertString(doc.getLength(),   str,  attrSet);
		}
		catch   (BadLocationException e)   {
			System.out.println("BadLocationException:   "   +   e);
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
		
		JButton btnNewButton_1 = new JButton("Eat-in");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setPacket("Eat-in");
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 28));
		btnNewButton_1.setBounds(42, 378, 141, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Ordering3(bill);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 28));
		btnNewButton.setBounds(365, 378, 141, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please check the order!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(90, 89, 361, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 24, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Take-out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setPacket("Take-away");
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(204, 378, 141, 61);
		panel.add(btnNewButton_1_1);

		if (price.getChkDiscount() == 1){
            setDocs("HALF PRICE TODAY!\r\n",Color.RED,true,26,"MV Boli");
        }
		setDocs("Order information:\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("staple food:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Ramen           ",Color.BLACK,true,22,"MV Boli");
		setDocs(price.getRamen()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ingredients(Free):\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Soup             ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getSoup()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodles          ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getNood()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spring onion      ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getOnion()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Nori             ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getNori()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Chashu           ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getChashu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Boiled egg        ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getBoiledEgg()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness         ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getSpiciness()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ingredients:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Extra Nori       ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getExtraNori()+"   ",Color.BLUE,true,22,"MV Boli");
		setDocs(price.getExNori()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Extra Boiled egg  ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getExtraEgg()+"   ",Color.BLUE,true,22,"MV Boli");
		setDocs(price.getExEgg()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Bamboo Shoots   ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getBambooShoot()+"   ",Color.BLUE,true,22,"MV Boli");
		setDocs(price.getExBamboo()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Extra Chashu     ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getExtraChashu()+"   ",Color.BLUE,true,22,"MV Boli");
		setDocs(price.getExChashu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("Total amount:    ",Color.BLACK,true,22,"MV Boli");
		setDocs(bill.getPrice(),Color.RED,true,22,"MV Boli");
		txtpnOrderInformation.setEditable(false);
		txtpnOrderInformation.setBounds(42, 146, 451, 222);
		panel.add(txtpnOrderInformation);
		
		JScrollPane scrollPane = new JScrollPane(txtpnOrderInformation);
		scrollPane.setBounds(42, 146, 464, 222);
		panel.add(scrollPane);
		txtpnOrderInformation.setCaretPosition(0);
	}
}