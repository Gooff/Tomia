package tomia.service;

import java.util.Stack;
import tomia.service.commands.Command;


/*this class helps to manage commands and save them to memory for undo() and redo() methods
 * 
 * 
 * */

public class UndoManager {
	
	
	private Stack<Command> undoStack = new Stack<Command>();
	private Stack<Command> redoStack = new Stack<Command>();

	public void execute(Command command) {

		command.execute();
		undoStack.push(command);
		redoStack.clear();

	}

	public void undo() {

		if (!undoStack.isEmpty()) {

			Command cmd = undoStack.pop();
			cmd.undo();
			redoStack.push(cmd);

		}
	}

	public void redo() {
		if (!redoStack.isEmpty()) {

			Command cmd = redoStack.pop();
			cmd.redo();
			undoStack.push(cmd);

		}
	}

}
