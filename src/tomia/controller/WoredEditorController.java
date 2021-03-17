package tomia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tomia.service.IWordEditor;

@RestController

public class WoredEditorController {

	@Autowired
	IWordEditor editor;

	@PostMapping(value = ApiConstants.ADD)
	public ResponseEntity<String> addText(@RequestBody String text) {

		if (text == null)
			return ResponseEntity.badRequest().body("Please enter text");

		return ResponseEntity.status(HttpStatus.OK).body(editor.add(text));
	}

	@PutMapping(value = ApiConstants.ADDPOSITION)
	public ResponseEntity<String> AddTextInPosition(@RequestParam(name = ApiConstants.POSITION_FROM) int position,
			@RequestBody String text) {

		return ResponseEntity.ok(editor.add(text, position));
	}

	@DeleteMapping(value = ApiConstants.REMOVE)
	public ResponseEntity<String> removeText(@RequestParam(name = ApiConstants.POSITION_FROM) int positionFrom,
			@RequestParam(name = ApiConstants.POSITION_TO) int positionTo) {

		return ResponseEntity.ok(editor.remove(positionFrom, positionTo));
	}

	@PutMapping(value = ApiConstants.ITALIC)
	public ResponseEntity<String> italic(@RequestParam(name = ApiConstants.POSITION_FROM) int positionFrom,
			@RequestParam(name = ApiConstants.POSITION_TO) int positionTo) {

		return ResponseEntity.ok(editor.italic(positionFrom, positionTo));
	}

	@PutMapping(value = ApiConstants.BOLD)
	public ResponseEntity<String> bold(@RequestParam(name = ApiConstants.POSITION_FROM) int positionFrom,
			@RequestParam(name = ApiConstants.POSITION_TO) int positionTo) {

		return ResponseEntity.ok(editor.bold(positionFrom, positionTo));

	}

	@PutMapping(value = ApiConstants.UNDERLINE)
	public ResponseEntity<String> underline(@RequestParam(name = ApiConstants.POSITION_FROM) int positionFrom,
			@RequestParam(name = ApiConstants.POSITION_TO) int positionTo) {

		return ResponseEntity.ok(editor.underline(positionFrom, positionTo));
	}

	@PutMapping(value = ApiConstants.REDO)
	public ResponseEntity<String> redo() {

		return ResponseEntity.ok(editor.redo());
	}

	@PutMapping(value = ApiConstants.UNDO)
	public ResponseEntity<String> undo() {

		return ResponseEntity.ok(editor.undo());
	}

	@GetMapping(value = ApiConstants.PRINT)
	public ResponseEntity<String> print() {

		return ResponseEntity.ok(editor.undo());
	}

}
