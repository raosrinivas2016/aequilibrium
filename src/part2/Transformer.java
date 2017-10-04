package part2;

public class Transformer implements Comparable<Transformer>{
	private int ID,Strength,Intelligence,Speed,Endurance,Rank,Courage,Firepower,Skill;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Transformer(int id,String name,int Strength,int Intelligence,int Speed,int Endurance,int Rank,int Courage,int Firepower,int Skill)
	{	this.ID=id;
		this.name=name;
		this.Strength=Strength;
		this.Intelligence=Intelligence;
		this.Speed=Speed;
		this.Endurance=Endurance;
		this.Rank=Rank;
		this.Courage=Courage;
		this.Firepower=Firepower;
		this.Skill=Skill;
		}

	public int getStrength() {
		return Strength;
	}

	public void setStrength(int strength) {
		Strength = strength;
	}

	public int getIntelligence() {
		return Intelligence;
	}

	public void setIntelligence(int intelligence) {
		Intelligence = intelligence;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public int getEndurance() {
		return Endurance;
	}

	public void setEndurance(int endurance) {
		Endurance = endurance;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		Rank = rank;
	}

	public int getCourage() {
		return Courage;
	}

	public void setCourage(int courage) {
		Courage = courage;
	}

	public int getFirepower() {
		return Firepower;
	}

	public void setFirepower(int firepower) {
		Firepower = firepower;
	}

	public int getSkill() {
		return Skill;
	}

	public void setSkill(int skill) {
		Skill = skill;
	}
	
	public int overallRating()
	{
		
		return this.Strength+this.Intelligence+this.Speed+this.Endurance+this.Firepower;
	}

	public int compareTo(Transformer o) {
		int x=this.overallRating();
		if(x>o.overallRating())
		return 1;
		else if(x<o.overallRating())
		return -1;
		else
		return 0;
	}
}
