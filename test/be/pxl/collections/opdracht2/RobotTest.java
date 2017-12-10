package be.pxl.collections.opdracht2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private Robot sut;

	@Before
	public void beforeEveryMethod() {
		sut = new Robot("RobotTest");
	}

	@Test
	public void addCommandIncreasesCommandListSize() {
		assertEquals(0, sut.numberOfCommands());

		sut.addCommand(Action.ATTACK, "attack");

		assertEquals(1, sut.numberOfCommands());

		sut.addCommand(Action.ATTACK, "attack");

		assertEquals(2, sut.numberOfCommands());
	}

	@Test
	public void executesTheFirstAddedCommand() {
		String value = "firstCommand";
		String expectedCommand = "ATTACK > " + value;
		;

		sut.addCommand(Action.ATTACK, value);
		sut.addCommand(Action.ATTACK, "attack");
		sut.addCommand(Action.TALK, "talk");
		sut.addCommand(Action.MOVE, "move");

		Robot.Command firstCommand = sut.execute();

		assertEquals(expectedCommand, firstCommand.display());
	}

	@Test
	public void deletesCommandAfterExecute() {
		String value = "firstCommand";

		sut.addCommand(Action.ATTACK, value);
		sut.addCommand(Action.ATTACK, "attack");

		Robot.Command firstCommand = sut.execute();
		Robot.Command secondCommand = sut.execute();

		assertNotEquals(secondCommand, firstCommand);
	}

	@Test
	public void commandIsNoneWhenNoCommandsLeft() {
		String expectedCommand = "NONE > none";

		sut.addCommand(Action.ATTACK, "attack");
		sut.execute();
		Robot.Command command = sut.execute();

		assertEquals(expectedCommand, command.display());
	}
}
