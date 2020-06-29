package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class LekoviJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static LekoviJTable instance = null;

	public static LekoviJTable getInstance() {
		if (instance == null) {
			instance = new LekoviJTable();
		}
		return instance;
	}

	private TableRowSorter<AbstractTableModelLekovi> sorter;

	private LekoviJTable() {
		this.setModel(new AbstractTableModelLekovi());
		sorter = new TableRowSorter<>((AbstractTableModelLekovi) getModel());
		this.setRowSorter(sorter);
	}

	public void search(String query) {
		RowFilter<AbstractTableModelLekovi, Object> rf = null;
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
