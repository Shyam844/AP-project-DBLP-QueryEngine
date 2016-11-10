import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

public class DisplayWindow extends JFrame{
	
	private static final long serialVersionUID = 1L; //To make serealizable
	public JPanel leftPanel,rightPanel;
	private Query [] qList ;
	public DisplayWindow(String title) {
		setTitle(title);
		setLocationByPlatform(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//this.qList= qList;
		initializeAllPanels();
		add(leftPanel);
		add(rightPanel);
		setBounds(0, 0, 200, 200);
	}
	public DisplayWindow() {
		super("");
	}
	
	private void initializeAllPanels() {
		initializeLeftPanel();
		initializeRightPanel();
	}
	
	private void initializeLeftPanel()
	{
		leftPanel = new JPanel();
		Query [] qList =  {new QueryType1("Query1",leftPanel)};
		leftPanel.add(new ComboBox(qList));
		
		/*JComboBox<Query> queryList = new JComboBox<Query>(qList);
		queryList.setSelectedIndex(0);
		queryList.addActionListener(qList[0]);
		leftPanel.add(queryList);*/

/*		queryList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<Query> cb= (JComboBox<Query>)(e.getSource());
				int index = cb.getSelectedIndex();
				qList[index].attach();
			}
		});*/
	}
	private void initializeRightPanel()
	{
		rightPanel = new JPanel();
	}
	//Added comment
	private Dimension getScreensize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	

}
