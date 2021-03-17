package tomia.service.commands;



public class AddCommand implements Command {
	
	

	private StringBuffer text;
	private  String oldText;
	private String newText;


	public AddCommand(StringBuffer text, String newText) {

		this.text = text;
		this.newText = newText;
	}

	@Override
	public void execute() {
		oldText=new String(text);
		
		text.append(newText);

	}

	@Override
	public void undo() {
	text.delete(0, text.length());
	text.append(oldText);
		

	}

	@Override
	public void redo() {
		text.append(newText);

	}

	@Override
	public String getName() {

		return "Add text";
	}

}
