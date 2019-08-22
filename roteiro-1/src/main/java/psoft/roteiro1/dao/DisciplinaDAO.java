package psoft.roteiro1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import psoft.roteiro1.models.Disciplina;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {
	
	@SuppressWarnings("unchecked")
	public Disciplina save(Disciplina disciplina);
	
	public Disciplina findById(Integer id);
	
	public List<Disciplina> findAll();
	
	@Query(value = "select u from Disciplina u order by u.nota DESC, u.id ASC")
	public List<Disciplina> ranking();
	
	public void deleteById(Integer id);
}
