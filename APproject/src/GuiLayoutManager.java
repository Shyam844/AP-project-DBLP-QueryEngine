import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiLayoutManager implements ActionListener {
//Card layout
	private JPanel cards;
	public void addComponentsToPane(Container pane)
	{
		 	JPanel comboBoxPane = new JPanel(); //made a new panel to hold all the cards
			final String QUERY1 = "Query1";
			final String QUERY2 = "Query2";
			

	        String comboBoxItems[] = { QUERY1, QUERY2}; // added first combobox items
	        JComboBox<String> cb = new JComboBox(comboBoxItems);
	        cb.setEditable(false);
	        cb.addActionListener(this);
	        comboBoxPane.add(cb);
	        JPanel emptyCard = new JPanel();
	        JPanel card2 = new JPanel();
	        card2.add(new JTextField("TextField", 20));      
	        //Create the panel that contains the "cards".
	        cards = new JPanel(new CardLayout());
	        cards.add(emptyCard);
	        cards.add(createAndGetCard1(), QUERY1);
	        cards.add(card2, QUERY2);
	        
	        pane.add(comboBoxPane, BorderLayout.PAGE_START);
	        pane.add(cards, BorderLayout.CENTER);
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
				
			}
		});
		card1.add(searchByComboBox);
		return card1;
	}
    public JPanel createAndGetCard2() {
    	
    	JPanel card1 = new JPanel();
    	String[] searchByList= {"By Name","By Author"};
    	 JComboBox<String> searchByComboBox = new JComboBox<>(searchByList); 
    	 searchByComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a new card to cards===============");
				
			}
		});
		card1.add(searchByComboBox);
		return card1;
	}


}
