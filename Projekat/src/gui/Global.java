package gui;

public class Global {
    private static int index = 0;
    public static String globalTipKorisnika;

    public static String getGlobalTipKorisnika() {
		return globalTipKorisnika;
	}

	public static void setGlobalTipKorisnika(String globalTipKorisnika) {
		Global.globalTipKorisnika = globalTipKorisnika;
	}

	public static int getVar(){
        return Global.index;
    }

    public static void setVar(int var){
        Global.index = var;
    }
}
