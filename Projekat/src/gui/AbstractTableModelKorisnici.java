package gui;

import javax.swing.table.AbstractTableModel;

import model.ListaKorisnika;

public class AbstractTableModelKorisnici extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return ListaKorisnika.getInstance().getKorisnici().size();
	}

	@Override
	public int getColumnCount() {
		return ListaKorisnika.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ListaKorisnika.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		super.setValueAt(value, rowIndex, columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return ListaKorisnika.getInstance().getColumnName(column);
	}

}