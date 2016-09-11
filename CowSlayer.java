package cowslay;
import org.powerbot.script.rt4.*;

import example.Chop;
import example.Drop;
import example.Task;

import org.powerbot.script.Script;
import org.powerbot.script.PollingScript;
import java.util.*;
@Script.Manifest(
		name = "Cow Slayer",
		description = "Slays cows and banks hides",
		properties = "rt4"
)

public class CowSlayer extends PollingScript<ClientContext> {

	private List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start(){
		taskList.addAll(Arrays.asList(new Looting(ctx),new EatBeef(ctx),new KillCow(ctx)));	
	}
	
	@Override
	public void poll(){
		for(Task task: taskList){
			if(task.activate()){
				task.execute();
			}
		}
	}

	@Override
	public void stop(){
		
	}
}
