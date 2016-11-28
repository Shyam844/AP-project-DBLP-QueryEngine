import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GuiLayoutManager implements ActionListener {
//Card layout
	private JPanel cards;
	private static int a=3;
	public void addComponentsToPane(Container pane)
	{
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		 	JPanel comboBoxPane = new JPanel(); 
		 	final String QUERY1 = "Query1";
			final String QUERY2 = "Query2";
	        String comboBoxItems[] = { QUERY1, QUERY2}; // added first combobox items
	        JComboBox<String> cb = new JComboBox(comboBoxItems);
	        System.out.println(pane.getLayout().toString());
	        pane.add(cb);
	        pane.add(new JButton("dhsgcvj"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)(cards.getLayout());  
		JComboBox<String > got = (JComboBox<String>)e.getSource();
		System.out.println(got.getItemAt((got.getSelectedIndex())));
		c1.show(cards,got.getItemAt((got.getSelectedIndex())));
		
		
		
	}
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        GuiLayoutManager demo = new GuiLayoutManager();
        demo.addComponentsToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public JPanel createAndGetCard1() {
    	
    	JPanel card1 = new JPanel();
    	String[] searchByList= {"By Name","By Author"};
    	 JComboBox<String> searchByComboBox = new JComboBox<>(searchByList); 
    	 searchByComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a new card to cards===============");
				JComboBox<String > jb  = (JComboBox<String>)e.getSource();
				System.out.println(jb.getSelectedIndex());
				if(jb.getSelectedIndex()==0)
				{
					card1.add(new JButton("0"));
					card1.setLayout(new BoxLayout(card1, BoxLayout.PAGE_AXIS));
					card1.revalidate();
					System.out.println("add new jbutton");
				}
				else if(jb.getSelectedIndex()==1)
				{
					
				}
				
				
				//card1.add(createFormSubType1(searchByList[jb.getSelectedIndex()]));
				//card1.add(createFormSubType1("Name"));
			}
		});
		card1.add(searchByComboBox);
		return card1;
	}
    public JPanel createAndGetCard2() {
    	
    	JPanel cardTemp = new JPanel();
    	String[] searchByList= {"By Author","By Title"};
    	 JComboBox<String> searchByComboBox = new JComboBox<>(searchByList); 
    	 searchByComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a new card to cards===============");
				
			}
		});
		cardTemp.add(searchByComboBox);
		return cardTemp;
	}
		
    public JPanel createFormSubType1(String byX) {
    	JPanel tPanel = new JPanel();
    	tPanel.add(new JLabel(byX));//ADD CHECKS
    	tPanel.add(new JLabel("Since Year"));
    	tPanel.add(new JLabel("Custom Range Start"));
    	tPanel.add(new JLabel("Custom Range End"));
    	ButtonGroup bg1 = new ButtonGroup();
    	bg1.add(new JRadioButton("Sort by year"));
    	bg1.add(new JRadioButton("Sort by relevance"));
    	

    	
    	
    	return tPanel;
    	
    }


}
