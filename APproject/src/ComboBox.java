import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBox extends JComboBox<Query> {
	//private Query [] qList;
	private JComboBox<Query> queryList; 
	public ComboBox(Query [] qList) {
		super(qList);
		setSelectedIndex(0);
		addActionListener(qList[0]);
		
	}
	
	

}
