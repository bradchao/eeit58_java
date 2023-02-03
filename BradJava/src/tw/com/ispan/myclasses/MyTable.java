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
		myModel.setColumnIdentifiers(db.getHeader());
		
	}
	
	public void delRow() {
		myModel.removeRow(getSelectedRow());
		repaint();
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
			db.updateData(row+1, column+1, (String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column > 0;
		}

		@Override
		public void removeRow(int row) {
			db.delRow(row+1);
		}
		
		
		
		
	}
}
