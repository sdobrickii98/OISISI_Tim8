package gui;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.ListaProdavnica;

public class AbstractTableModelProdavnica extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public int getColumnCount() {
			return ListaProdavnica.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
			return ListaProdavnica.getInstance().getProdavnica().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
				return ListaProdavnica.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:

		case 4:

		case 5:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
			return ListaProdavnica.getInstance().getColumnName(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 5;
	}

}
