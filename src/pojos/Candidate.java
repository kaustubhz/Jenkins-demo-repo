package pojos;

public class Candidate {

	private int id; 
	private String name,politicalParty;
	private int votes;
	

	public Candidate(int id, String name, String politicalParty, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.politicalParty = politicalParty;
		this.votes = votes;
	}
	

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", politicalParty=" + politicalParty + ", votes=" + votes + "]";
	}

	
	
}
