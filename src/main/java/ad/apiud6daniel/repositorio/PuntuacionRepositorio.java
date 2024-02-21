package ad.apiud6daniel.repositorio;

import ad.apiud6daniel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion, Long> {
}
