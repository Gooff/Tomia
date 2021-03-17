package tomia.service;

public interface IWordEditor {
	
	String add(String s);

	String	add(String s, int position);

	String	remove(int fromPosition, int toPosition);

	String	italic(int fromPosition, int toPosition);

	String	bold(int fromPosition, int toPosition);

	String	underline(int fromPosition, int toPosition);

	String	redo();

	String	undo();

	void	print();
}
