package tomia.service.commands;

public class RemoveCommand implements Command {

	private StringBuffer text;
	private String oldText;
	private int positionFrom;
	private int positionTo;

	public RemoveCommand(StringBuffer text, int positionFrom, int positionTo) {
		super();
		this.text = text;
		this.positionFrom = positionFrom;
		this.positionTo = positionTo;
	}

	@Override
	public void execute() {
		this.oldText = new String(text);

		text.delete(positionFrom, positionTo);

	}

	@Override
	public void undo() {

		text.delete(0, text.length());
		text.append(oldText);

	}

	@Override
	public void redo() {
		this.text.delete(positionFrom, positionTo);

	}

	@Override
	public String getName() {

		return "Remove fromTo position";
	}

}
