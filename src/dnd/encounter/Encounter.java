package dnd.encounter;

public class Encounter {

	private int encounterID;
	private String description;
	private int turn;
	private int totalTurns;
	private int overallTurn;
	private Boolean updated;
	
	public int getEncounterID() {
		return encounterID;
	}
	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getOverallTurn() {
		return overallTurn;
	}
	public void setOverallTurn(int overallTurn) {
		this.overallTurn = overallTurn;
	}
	public Boolean getUpdated() {
		return updated;
	}
	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
    public int getTotalTurns() {
        return totalTurns;
    }
    public void setTotalTurns(int totalTurns) {
        this.totalTurns = totalTurns;
    }
	
}
