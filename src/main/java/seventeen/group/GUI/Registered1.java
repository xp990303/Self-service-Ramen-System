package seventeen.group.GUI;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @className: Registered1
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Registered 1.
 */
public class Registered1 extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * The Txtpn you already have.
     */
    JTextPane txtpnYouAlreadyHave = new JTextPane();

    /**
     * The Bill.
     */
    Bill bill;
    /**
     * The Customer.
     */
    Customer customer;

    /**
     * Create the application.
     *
     * @param bill     the bill
     * @param customer the customer
     */
    public Registered1(Bill bill, Customer customer) {
		this.bill = bill;
		this.customer = customer;
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
		
		JLabel lblNewLabel = new JLabel("Account already exists!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(90, 64, 361, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login2(bill);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(177, 374, 176, 61);
		panel.add(btnNewButton_1);

		setDocs("You already have an account!\r\nWe have sent you SMS and email!\r\nPlease check your SMS and email!\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("Customer ID:       ",Color.BLACK,true,22,"MV Boli");
		setDocs(customer.getUid()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Click Confirm to jump to the login interface!",Color.BLACK,true,22,"MV Boli");
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
	}
}