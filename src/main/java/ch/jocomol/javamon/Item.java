package ch.jocomol.javamon;

import ch.jocomol.javamon.javamon.Javamon;
import ch.jocomol.javamon.trainer.Human;

public class Item{

	private String type, name;
	private int strenght;
	private Javamon taker;
	private Human owner;

	public String toString() {
		String Output;

		Output = this.type + "/n";
		if (type == "heal") {
			Output += this.getStrenght();
		}
		return Output;

	}

	public Item(String type, String name, int strenght, Human owner)
	{
		this.setType(type);
		this.setOwner(owner);
		this.setStrenght(strenght);
		this.setName(name);
	}

	public void heal(Javamon taker)
	{
		this.setTaker(taker);

		if (this.getType() == "heal")
		{
			taker.setHealthPoints(taker.getHealthPoints() + this.getStrenght());
			//OUTPUT got healed whit strenght of this
			this.setStrenght(0);
		}
		else if (this.getType() == "depoison" && taker.isPoisoned() || taker.getRoundsPoisoned() > 0 && this.getType() == "depoison")
		{
			taker.setPoisoned(false);
			taker.setRoundsPoisoned(0);
			//OUTPUT got depoisoned
		}
		else if (this.getType() == "deburner" && taker.isBurning() || taker.getRoundsBurning() > 0 && this.getType() == "deburner")
		{
			taker.setBurning(false);
			taker.setRoundsBurning(0);
			//OUTPUT got deburned
		}
		else if (this.getType() == "reviverweak" && taker.isAlife() == false)
		{
			taker.setHealthPoints(50);
			taker.setIsdead(false);
			//OUTPUT got revied whit 50 HP
		}
		else if (this.getType() == "reviverstrong" && taker.isAlife() == false)
		{
			taker.setHealthPoints(100);
			taker.setIsdead(false);
			//OUTPUT got revived whit 100 HP
		}
	}
}
