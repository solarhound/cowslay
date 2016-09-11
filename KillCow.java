package cowslay;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class KillCow extends Task<ClientContext>{

	int[] cowIds = {2808, 2805, 2806}; 
	
	public KillCow(ClientContext ctx){
		super(ctx);
	}
	
	@Override
	public boolean activate(){
		return ctx.inventory.count() < 28
				&& !ctx.npcs.select().id(cowIds).isEmpty()
				&& ctx.combat.health() >= 7
				&& ctx.players.local().animation() == -1;
	}
	
	@Override
	public void execute(){
		//TODO: kill cow, eat if lower than x%hp, pick up his hide, 
		//and pick up beef if health is you have less than hp lost on last kills/total hp
		Npc cow = ctx.npcs.nearest().poll();
		
		if (cow.inViewport() && !cow.inCombat()){ 
			cow.interact("Attack");
		} else if(!cow.inViewport() && !cow.inCombat()) {
			ctx.movement.step(cow);
			ctx.camera.turnTo(cow);
		}
	}
}
