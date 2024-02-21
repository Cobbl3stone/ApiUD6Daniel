package ad.apiud6daniel.repositorio;

import ad.apiud6daniel.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego, Long> {

}
