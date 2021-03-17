package tomia.service.commands;



/* interface with the common methods for all commands in editor */


public interface Command {

	
	
	void execute();
	
	void undo();
	
	void redo();
	
	String getName();

}
