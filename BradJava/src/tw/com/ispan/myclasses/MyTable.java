package tw.com.ispan.myclasses;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	private GiftDB db;
	
	public MyTable() throws Exception {
		
		db = new GiftDB();
		
		myModel = new MyModel();
		setModel(myModel);
		
	}
	
	
	private class MyModel extends DefaultTableModel {
		
	}
}
