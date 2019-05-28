package dnd.domain.character;

public class AbilityScores {

	private int str;
	private int dex;
	private int con;
	private int intel;
	private int wis;
	private int cha;
	
	public AbilityScores(int[] abilityScoresArr) {
		this.str=abilityScoresArr[0];
		this.dex=abilityScoresArr[1];
		this.con=abilityScoresArr[2];
		this.intel=abilityScoresArr[3];
		this.wis=abilityScoresArr[4];
		this.cha=abilityScoresArr[5];
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}
	
	public String toString() {
		return "Str:" + str + " Dex: " + dex+ " Con: " + con +  " Int: " + intel+ " Wis: " + wis + " Char:" + cha; 
	}
	public String getEditableValues() {
		return str+","+dex+","+con+","+intel+","+wis+","+cha;
	}
	
}
