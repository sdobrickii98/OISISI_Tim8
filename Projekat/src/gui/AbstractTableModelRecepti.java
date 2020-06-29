package gui;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.ListaRecepata;

public class AbstractTableModelRecepti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public int getColumnCount() {
		// return ListaRecepata.getInstance().getColumnCount()+1;
		return ListaRecepata.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ListaRecepata.getInstance().getRecepti().size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex < 5) {
			return ListaRecepata.getInstance().getValueAt(rowIndex, columnIndex);
		} else if (columnIndex == 5) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}
	}

	@Override
	public String getColumnName(int column) {
		if (column >= ListaRecepata.getInstance().getColumnCount()) {
			// return kolonaLekovi;
		}
		return ListaRecepata.getInstance().getColumnName(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 5;
	}

}
