package psoft.roteiro1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import psoft.roteiro1.models.Disciplina;
import psoft.roteiro1.services.DisciplinaServices;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaServices disciplinaServices;

	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplina>> listarTodas() {
		return new ResponseEntity<List<Disciplina>>(disciplinaServices.ListarDisciplinas(), HttpStatus.OK);
	}

	@GetMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplina> disciplina(@PathVariable(value = "id") Integer id) {
		Disciplina disc = disciplinaServices.disciplina(id);
		if (disc == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Disciplina>(disciplinaServices.disciplina(id), HttpStatus.OK);
		}
	}
	
	@GetMapping("/disciplinas/ranking")
	public ResponseEntity<List<Disciplina>> ranking() {
		return new ResponseEntity<List<Disciplina>>(disciplinaServices.ranking(), HttpStatus.OK);
	}

	@PostMapping("/disciplinas")
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody Disciplina disciplina) {
		return new ResponseEntity<Disciplina>(disciplinaServices.addDisciplina(disciplina), HttpStatus.OK);
	}

	@PutMapping("/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizaNomeDaDisciplina(@RequestBody Disciplina disciplina,
			@PathVariable(value = "id") Integer id) {
		try {
			return new ResponseEntity<Disciplina>(disciplinaServices.atualizaNomeDaDisciplina(disciplina, id),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizaNotaDaDisciplina(@RequestBody Disciplina disciplina,
			@PathVariable(value = "id") Integer id) {
		try {
			return new ResponseEntity<Disciplina>(disciplinaServices.atualizaNotaDaDisciplina(disciplina, id),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplina> removeDisciplina(@PathVariable(value = "id") Integer id) {
		try {
			return new ResponseEntity<Disciplina>(disciplinaServices.removeDisciplina(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
}
