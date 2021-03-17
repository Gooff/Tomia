package tomia.service.commands;

public class AddPositionCommand implements Command {

	private StringBuffer text;
	private String oldText;
	private String newText;
	private int position;

	public AddPositionCommand(StringBuffer text, String newText, int position) {
		super();
		this.text = text;
		this.newText = newText;
		this.position = position;
	}

	@Override
	public void execute() {
		this.oldText = new String(text);

		text.insert(position, newText);

	}

	@Override
	public void undo() {
		text.delete(0, text.length());
		text.append(oldText);

	}

	@Override
	public void redo() {

		text.insert(position, newText);

	}

	@Override
	public String getName() {

		return "Add in Position";
	}

}
