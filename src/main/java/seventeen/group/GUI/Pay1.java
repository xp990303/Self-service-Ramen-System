package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;
import seventeen.group.Entity.Price;
import seventeen.group.Service.BillService;
import seventeen.group.Service.CustomerService;
import seventeen.group.Service.Impl.BillServiceImpl;
import seventeen.group.Service.Impl.CustomerServiceImpl;
import seventeen.group.Service.Impl.PriceServiceImpl;
import seventeen.group.Service.Impl.ReceiptServiceImpl;
import seventeen.group.Service.PriceService;
import seventeen.group.Service.ReceiptService;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: Pay1
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Pay 1.
 */
public class Pay1 extends JFrame{

	private JFrame frmRamenBuffetSystem;

	/**
	 * The Txtpn you already have.
	 */
	JTextPane txtpnYouAlreadyHave = new JTextPane();

	/**
	 * The Bill.
	 */
	Bill bill = new Bill();
	/**
	 * The Customer.
	 */
	Customer customer = new Customer();
	/**
	 * The Price.
	 */
	Price price = new Price();

	/**
	 * Create the application.
	 *
	 * @param bill     the bill
	 * @param customer the customer
	 * @throws IOException the io exception
	 */
	public Pay1(Bill bill, Customer customer) throws IOException {
		this.customer = customer;
		this.bill = bill;
		PriceService priceService = new PriceServiceImpl();
		price = priceService.getPrice();
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
		Document doc   =   txtpnYouAlreadyHave.getDocument();
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
		
		JLabel lblNewLabel = new JLabel("Please select the mode of payment!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(34, 64, 471, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Use stamps");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setStamp(customer.getStamp() - 10);
				CustomerService customerService = new CustomerServiceImpl();
				bill.setIfFree("Yes");
				bill.setPayoption("stamp");
				try {
					BillService billService = new BillServiceImpl();
					String billMsg = billService.getBillMsg(bill);
					billService.saveBillMsg(bill);
					ReceiptService receiptService = new ReceiptServiceImpl();
					receiptService.setReceipt(bill, customer);
					if(customerService.saveCustomer(customer) == 0){
						System.out.println("Ah, your program crash because of your customer file!");
						System.exit(0);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frmRamenBuffetSystem.setVisible(false);
				new Pay2(bill, price, customer);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		//btnNewButton_1.setBounds(23, 379, 176, 61);
		btnNewButton_1.setBounds(209, 379, 176, 61);
		if(customer.getStamp() < 10)  btnNewButton_1.setVisible(false);
		panel.add(btnNewButton_1);

		if (price.getChkDiscount() == 1){
			setDocs("HALF PRICE TODAY!\r\n",Color.RED,true,26,"MV Boli");
		}
		setDocs("Order information:\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("("+bill.getPacket()+")"+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Customer ID:       ",Color.BLACK,true,22,"MV Boli");
		setDocs(customer.getUid()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Customer Name:    ",Color.BLACK,true,22,"MV Boli");
		setDocs(customer.getSurname()+"\r\n",Color.BLUE,true,22,"MV Boli");
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
		setDocs(bill.getPrice()+"\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Virtual stamp:    ",Color.BLACK,true,22,"MV Boli");
		setDocs(customer.getStamp()+"\r\n",Color.RED,true,22,"MV Boli");
		setDocs("10 stamps can pay a bill!",Color.BLACK,true,22,"MV Boli");

		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 25));
		btnNewButton.setBounds(392, 379, 133, 61);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Cash/Card");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setStamp(customer.getStamp() + 1);
				CustomerService customerService = new CustomerServiceImpl();
				bill.setIfFree("No");
				bill.setPayoption("cash");
				bill.setUid("000000");
				try {
					BillService billService = new BillServiceImpl();
					billService.saveBillMsg(bill);
					ReceiptService receiptService = new ReceiptServiceImpl();
					receiptService.setReceipt(bill, customer);
					if(customerService.saveCustomer(customer) == 0){
						System.out.println("Ah, your program crash because of your customer file!");
						System.exit(0);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frmRamenBuffetSystem.setVisible(false);
				new Pay2(bill, price, customer);
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		//btnNewButton_1_1.setBounds(209, 379, 176, 61);
		btnNewButton_1_1.setBounds(23, 379, 176, 61);
		panel.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(67, 125, 405, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0);
	}
}