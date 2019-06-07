package dnd.encounter;

public class ActorEncounterDetails {

	private int encounterID;
	private int hp;
	private String status;
	private int deathSuccess;
	private int deathFailure;
	private int initiative;
	
	
	public int getEncounterID() {
		return encounterID;
	}
	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDeathSuccess() {
		return deathSuccess;
	}
	public void setDeathSuccess(int deathSuccess) {
		this.deathSuccess = deathSuccess;
	}
	public int getDeathFailure() {
		return deathFailure;
	}
	public void setDeathFailure(int deathFailure) {
		this.deathFailure = deathFailure;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
}
