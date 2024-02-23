package ad.apiud6daniel.repositorio;

import ad.apiud6daniel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion, Long> {
    List<Puntuacion> findByJuegoId(long id);
    List<Puntuacion> findByJuegoIdOrderByCantidadDesc(long id);
    List<Puntuacion> findByJugador(String jugador);
}
