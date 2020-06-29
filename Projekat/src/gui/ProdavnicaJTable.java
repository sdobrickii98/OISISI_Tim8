package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ProdavnicaJTable extends JTable {

	private static final long serialVersionUID = 1L;

	private static ProdavnicaJTable instance = null;

	public static ProdavnicaJTable getInstance() {
		if (instance == null) {
			instance = new ProdavnicaJTable();
		}
		return instance;
	}

	private TableRowSorter<AbstractTableModelProdavnica> sorter;

	public ProdavnicaJTable() {
		this.setModel(new AbstractTableModelProdavnica());
		sorter = new TableRowSorter<>((AbstractTableModelProdavnica) getModel());
		this.setRowSorter(sorter);
	}

	public void search(String query) {
		RowFilter<AbstractTableModelProdavnica, Object> rf = null;
		List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>();
		try {
			String text = query;
			String[] textArray = text.split(" ");

			for (int i = 0; i < textArray.length; i++) {
				rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 4));
			}

			rf = RowFilter.andFilter(rfs);

		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
}
