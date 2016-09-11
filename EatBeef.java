package cowslay;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class EatBeef extends Task<ClientContext> {

	public int[] beefId = {2142, 2143};
	public EatBeef(ClientContext ctx){
		super(ctx);
	}
	
	@Override
	public boolean activate(){
		return ctx.combat.health() < 5
				&& ctx.inventory.id(beefId).count() > 0;
	}
	
	@Override
	public void execute(){
		Item beef = ctx.inventory.id(beefId).first().poll();
		beef.interact("Eat");
	}
	
}
