package controller;

import gui.AbstractTableModelLekovi;
import gui.LekoviJTable;

public class LekoviController {
	private static LekoviController instance = null;

	public static LekoviController getInstance() {
		if (instance == null) {
			instance = new LekoviController();
		}
		return instance;
	}

	private LekoviController() {
	}

	public void promenaPosleDeserijalizacije() {
		AbstractTableModelLekovi model = (AbstractTableModelLekovi) LekoviJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

}
