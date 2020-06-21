package gui;

import javax.swing.table.AbstractTableModel;
import model.listaKorisnika;

public class AbstractTableModelKorisnici extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return listaKorisnika.getInstance().getKorisnici().size();
	}

	@Override
	public int getColumnCount() {
		return listaKorisnika.getInstance().getColumnCount() ;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return listaKorisnika.getInstance().getValueAt(rowIndex, columnIndex);
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
		return listaKorisnika.getInstance().getColumnName(column);
	}

}