package be.pxl.collections.opdracht2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Robot {
	private String name;
	private Queue<Command> commands;

	{
		commands = new ArrayDeque<>();
	}

	public Robot(String name) {
		this.name = name;
	}

	public Command execute() {
		Command commandToExecute = commands.poll();

		return commandToExecute != null ? commandToExecute : new Command(Action.NONE, "none");
	}

	public void addCommand(Action action, String value) {
		commands.add(new Command(action, value));
	}

	public int numberOfCommands() {
		return commands.size();
	}

	public void setCommands(Queue<Command> commands) {
		this.commands = commands;
	}

	public Queue<Command> getCommands() {
		return commands;
	}

	protected class Command implements Comparable<Command> {
		private Action action;
		private String value;
		private int priority;

		public Command(Action action, String value) {
			this(action, value, 0);
		}

		public Command(Action action, String value, int priority) {
			this.action = action;
			this.value = value;
			this.priority = priority;
		}

		public int getPriority() {
			return priority;
		}

		public String display() {
			return action.toString() + " > " + value;
		}

		@Override
		public int compareTo(Command o) {
			return Integer.compare(o.getPriority(), this.getPriority());
		}
	}
}
