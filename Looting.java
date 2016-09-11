package cowslay;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GroundItem;

public class Looting extends Task<ClientContext>{

	boolean npcKilled = ctx.players.local().interacting().health() == 0;
	public int[] beefId = {2142, 2143};

	public Looting(ClientContext ctx){
		super(ctx);
	}
	@Override
	public boolean activate(){
		return ctx.inventory.count() < 28
				&& npcKilled;
	}
	
	public void execute(){
		GroundItem beef = ctx.groundItems.id(beefId).nearest().poll();
		beef.interact("Take");
	}
}
