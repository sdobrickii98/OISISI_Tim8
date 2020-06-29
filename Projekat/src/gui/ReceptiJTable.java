package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ReceptiJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ReceptiJTable instance = null;

	public static ReceptiJTable getInstance() {
		if (instance == null) {
			instance = new ReceptiJTable();
		}
		return instance;
	}

	private TableRowSorter<AbstractTableModelRecepti> sorter;

	private ReceptiJTable() {
		this.setModel(new AbstractTableModelRecepti());
		sorter = new TableRowSorter<>((AbstractTableModelRecepti) getModel());
		this.setRowSorter(sorter);
	}

	public void search(String query) {
		String[] parts = query.split(";"); // SPLITUJEMO PO ;
		Map<String, String> map = new HashMap<>();

		map.put("sifra", "");
		map.put("lekar", "");
		map.put("jmbg", "");
		map.put("datum", "");
		map.put("ukCena", "");

		for (int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if (splited.length > 1) {
				map.put(splited[0].toLowerCase(), splited[1]);
			}
		}

		List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>();

		rfs.add(RowFilter.regexFilter(".*" + map.get("sifra") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("lekar") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("jmbg") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("datum") + ".*", 3));
		rfs.add(RowFilter.regexFilter(".*" + map.get("ukCena") + ".*", 4));

		sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
}
