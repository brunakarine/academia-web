package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
