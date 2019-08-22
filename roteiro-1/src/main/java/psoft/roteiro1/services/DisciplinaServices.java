package psoft.roteiro1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import psoft.roteiro1.models.Disciplina;

@Service
public class DisciplinaServices {
	
	private List<Disciplina> listaDeDisciplinas = new ArrayList<>();
	
	public Disciplina addDisciplina(Disciplina disciplina) {
		listaDeDisciplinas.add(disciplina);
		return disciplina;
	}
	
	public List<Disciplina> ListarDisciplinas() {
		return listaDeDisciplinas;
	}
	
	public Disciplina disciplina(Integer id) {
		return listaDeDisciplinas.stream().filter(disciplina -> disciplina.getId().equals(id)).findFirst().get();
	}

	public Disciplina atualizaNomeDaDisciplina(Integer id, Disciplina disciplina) {
		Disciplina disciplinaAtual = listaDeDisciplinas.stream().filter(disc -> disc.getId().equals(id)).findFirst().get();
		disciplinaAtual.setNome(disciplina.getNome());
		return disciplinaAtual;
	}
	
	public Disciplina atualizaNotaDaDisciplina(Integer id, Disciplina disciplina) {
		Disciplina disciplinaAtual = listaDeDisciplinas.stream().filter(disc -> disc.getId().equals(id)).findFirst().get();
		disciplinaAtual.setNota(disciplina.getNota());
		return disciplinaAtual;
	}
	
	public Disciplina removeDisciplina(Integer id) {
		Disciplina disciplinaAtual = listaDeDisciplinas.stream().filter(disc -> disc.getId().equals(id)).findFirst().get();
		listaDeDisciplinas.remove(disciplinaAtual);
		return disciplinaAtual;
	}
	
	public List<Disciplina> ranking() {
		Collections.sort(listaDeDisciplinas);
		return listaDeDisciplinas;
	}
}
