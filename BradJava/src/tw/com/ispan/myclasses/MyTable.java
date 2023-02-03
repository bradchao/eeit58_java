package tw.com.ispan.myclasses;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	private GiftDB db;
	
	public MyTable() throws Exception {
		
		db = new GiftDB();
		db.queryData("SELECT * FROM gift");
		
		myModel = new MyModel();
		setModel(myModel);
		
	}
	
	
	private class MyModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			// TODO Auto-generated method stub
			super.setValueAt(aValue, row, column);
		}
		
	}
}
