package be.pxl.collections.opdracht3;

import java.util.PriorityQueue;

import be.pxl.collections.opdracht2.Action;
import be.pxl.collections.opdracht2.Robot;

public class PrioBot extends Robot {

	public PrioBot(String name) {
		super(name);
		setCommands(new PriorityQueue<>());
	}

	public void addCommand(Action action, String value, int priority) {
		getCommands().add(new Command(action, value, priority));
	}

}
