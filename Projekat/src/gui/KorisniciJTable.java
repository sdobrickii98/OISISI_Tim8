package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class KorisniciJTable extends JTable {

	private static final long serialVersionUID = 1L;

	private static KorisniciJTable instance = null;

	public static KorisniciJTable getInstance() {
		if (instance == null) {
			instance = new KorisniciJTable();
		}
		return instance;
	}

	private TableRowSorter<AbstractTableModelKorisnici> sorter;

	public KorisniciJTable() {
		this.setModel(new AbstractTableModelKorisnici());
		sorter = new TableRowSorter<>((AbstractTableModelKorisnici) getModel());
		this.setRowSorter(sorter);
	}

	public void search(String query) {
		RowFilter<AbstractTableModelKorisnici, Object> rf = null;
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
