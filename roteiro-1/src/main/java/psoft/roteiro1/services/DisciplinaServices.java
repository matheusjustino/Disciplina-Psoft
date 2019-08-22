package psoft.roteiro1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psoft.roteiro1.dao.DisciplinaDAO;
import psoft.roteiro1.models.Disciplina;

@Service
public class DisciplinaServices {
	
	
	@Autowired
	DisciplinaDAO disciplinaDAO;
	
	public Disciplina addDisciplina(Disciplina disciplina) {
		return disciplinaDAO.save(disciplina);
	}
	
	public List<Disciplina> ListarDisciplinas() {
		return disciplinaDAO.findAll();
	}
	
	public Disciplina disciplina(Integer id) {
		return disciplinaDAO.findById(id);
	}
	
	public Disciplina atualizaNomeDaDisciplina(Disciplina disciplina, Integer id) {
		Disciplina disciplinaN = this.disciplina(id);
		disciplinaN.setNome(disciplina.getNome());
		return disciplinaDAO.save(disciplinaN);
	}
	
	public Disciplina atualizaNotaDaDisciplina(Disciplina disciplina, Integer id) {
		Disciplina disciplinaN = this.disciplina(id);
		disciplinaN.setNota(disciplina.getNota());
		return disciplinaDAO.save(disciplinaN);
	}
	
	public List<Disciplina> ranking() {
		return disciplinaDAO.ranking();
	}
	
	public Disciplina removeDisciplina(Integer id) {
		Disciplina disciplina = disciplinaDAO.findById(id);
		disciplinaDAO.delete(disciplina);
		return disciplina;
	}
}
