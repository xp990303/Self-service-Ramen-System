package seventeen.group.GUI;

import seventeen.group.Entity.Statistics;
import seventeen.group.Service.BillService;
import seventeen.group.Service.Impl.BillServiceImpl;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @className: Sales
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Sales.
 */
public class Sales extends JFrame{

	private JFrame frmRamenBuffetSystem;

    /**
     * The Txtpn you already have.
     */
    JTextPane txtpnYouAlreadyHave = new JTextPane();

    /**
     * The Statistics.
     */
    Statistics statistics = new Statistics();

    /**
     * Create the application.
     *
     * @throws IOException the io exception
     */
    public Sales() throws IOException {
		BillService billService = new BillServiceImpl();
		statistics = billService.getStatistic();
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
		
		JLabel lblNewLabel = new JLabel("Here is all the sales situation!");
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
		
		JButton btnNewButton_1 = new JButton("State");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new StatisticsGUI(statistics);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);

		setDocs("Statistics\r\n",Color.BLACK,true,22,"MV Boli");
		setDocs("Soup:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Soup-Tonkotsu       ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSoupTonkotsu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Soup-Shoyu          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSoupShoyu()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Soup-Shio           ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSoupShio()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Noodle-Soft         ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getNoodleSoft()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle-Medium      ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getNoodleMedium()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Noodle-Firm         ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getNoodleFirm()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Onion:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Onion-No            ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getOnionNo()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Onion-Little         ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getOnionLittle()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Onion-Lot           ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getOnionLot()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Nori:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Nori-Yes            ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getNoriY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Nori-No             ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getNoriN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Chashu:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Chashu-Yes          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getChashuY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Chashu-No           ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getChashuN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("BoiledEgg:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("BoiledEgg-Yes        ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getBoiledEggY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("BoiledEgg-No         ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getExtraNoriN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Spiciness-0          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness0()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness-1           ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness1()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness-2          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness2()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness-3          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness3()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness-4          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness4()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Spiciness-5          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getSpiciness5()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ExtraNori:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("ExtraNori-Yes       ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getExtraNoriY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ExtraNori-No        ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getExtraNoriN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("BambooShoots:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("BambooShoots-Yes   ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getBambooShootsY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("BambooShoots-No    ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getBambooShootsN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ExtraChashu:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("ExtraChashu-Yes     ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getChashuY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("ExtraChashu-No      ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getChashuN()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Pay option:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Cash                 ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getPayOption()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Stamp               ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getIfFreeY()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Packet:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Take-away           ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getPacketTakeAway()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Eat-in               ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getPacketEatIn()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Total:\r\n",Color.RED,true,22,"MV Boli");
		setDocs("Total Bill            ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getTotalBill()+"\r\n",Color.BLUE,true,22,"MV Boli");
		setDocs("Total Price          ",Color.BLACK,true,22,"MV Boli");
		setDocs(statistics.getTotalPrice()+"\r\n" ,Color.BLUE,true,22,"MV Boli");

		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setBounds(58, 125, 430, 244);
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