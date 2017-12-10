package be.pxl.collections.opdracht2;

public class RobotApp {

	public static void main(String[] args) {
		Robot robot = new Robot("R1");

		robot.addCommand(Action.MOVE, "move 1");
		robot.addCommand(Action.TALK, "talk 1");
		robot.addCommand(Action.MOVE, "move 2");
		robot.addCommand(Action.ATTACK, "attack 1");
		robot.addCommand(Action.ATTACK, "attack 2");
		robot.addCommand(Action.TURN, "turn 1");

		for (int i = 0; i < 10; i++) {
			System.out.println(robot.execute().display());
		}

	}
}
