package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
