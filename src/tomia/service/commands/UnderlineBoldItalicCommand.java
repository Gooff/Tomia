package tomia.service.commands;

public class UnderlineBoldItalicCommand implements Command {

	private StringBuffer text;
	private String oldText;
	private int positionFrom;
	private int positionTo;

	private String openTag ;
	private String closeTag ;

	
	
	public UnderlineBoldItalicCommand(StringBuffer text, int positionFrom, int positionTo, String openTag,
			String closeTag) {
		super();
		this.text = text;
		this.positionFrom = positionFrom;
		this.positionTo = positionTo;
		this.openTag = openTag;
		this.closeTag = closeTag;
	}

	@Override
	public void execute() {
		oldText=new String(text);
		text.insert(positionTo, closeTag);
		text.insert(positionFrom, openTag);

	}

	@Override
	public void undo() {
		text.delete(0, text.length());
		text.append(oldText);
	}

	@Override
	public void redo() {

		text.insert(positionFrom, openTag);
		text.insert(positionTo, closeTag);

	}

	@Override
	public String getName() {

		return "underline";
	}

}
