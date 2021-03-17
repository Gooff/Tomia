package tomia.service;

import org.springframework.stereotype.Service;

import tomia.service.commands.AddCommand;
import tomia.service.commands.AddPositionCommand;

import tomia.service.commands.RemoveCommand;
import tomia.service.commands.UnderlineBoldItalicCommand;



@Service
public class WordEditorService implements IWordEditor {
	
	
	UndoManager undoManager=new UndoManager();
	
	StringBuffer text= new StringBuffer("");
	
	
	

	@Override
	public String add(String s) {
		
		if(s==null) s="";
		undoManager.execute(new AddCommand(text, s));
		return text.toString();
	}

	@Override
	public String add(String s, int position) {
		
		if(s==null) s="";
		if(position>text.length()||position<0) position=text.length();
		undoManager.execute(new AddPositionCommand(text, s, position));
		return text.toString();
	}

	@Override
	public String remove(int fromPosition, int toPosition) {
		fromToPositionCheck(fromPosition, toPosition);
		undoManager.execute(new RemoveCommand(text, fromPosition, toPosition));
		return text.toString();
	}

	@Override
	public String italic(int fromPosition, int toPosition) {
		fromToPositionCheck(fromPosition, toPosition);
		undoManager.execute(new UnderlineBoldItalicCommand(text, fromPosition, toPosition, "<i>","</i>"));
		return text.toString();
		
	}

	@Override
	public String bold(int fromPosition, int toPosition) {
		fromToPositionCheck(fromPosition, toPosition);
		undoManager.execute(new UnderlineBoldItalicCommand(text, fromPosition, toPosition, "<b>","</b>"));
		return text.toString();
	}

	@Override
	public String underline(int fromPosition, int toPosition) {
		fromToPositionCheck(fromPosition, toPosition);
		undoManager.execute(new UnderlineBoldItalicCommand(text, fromPosition, toPosition, "<u>","</u>"));
		return text.toString();
		
	}

	@Override
	public String redo() {
		undoManager.redo();
		return text.toString();
		
	}

	@Override
	public String undo() {
		undoManager.undo();
		return text.toString();
		
	}

	@Override
	public void print() {
		System.out.println(text);
		
	}

	
	
	private void fromToPositionCheck(int fromPosition, int toPosition) {
		
		if(toPosition>text.length()-1||toPosition<0) toPosition=text.length()-1;
		
if(fromPosition>toPosition||fromPosition>text.length()-1||fromPosition<0) 	fromPosition=toPosition;

		
		

}}
