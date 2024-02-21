package ad.apiud6daniel.controlador;

import ad.apiud6daniel.modelo.Puntuacion;
import ad.apiud6daniel.repositorio.JuegoRepositorio;
import ad.apiud6daniel.repositorio.PuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/puntuacion")
public class PuntuacionControlador {
    @Autowired
    private PuntuacionRepositorio puntuacionRepositorio;

    @Autowired
    private JuegoRepositorio juegoRepositorio;


    //Todas las puntuaciones
    @GetMapping
    public List<Puntuacion> obtenerRepositorios() {
        return puntuacionRepositorio.findAll();
        //Al entrar en la url de arriba, se ejecuta
    }

    //Una puntuacion por su ID
    @GetMapping("/{id}")
    public Puntuacion obtenerRepositorioId(@PathVariable Long id) {
        Optional<Puntuacion> resultado = puntuacionRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Puntuacion no encontrada"));
    }

    //alta de una puntuacion
    @PostMapping("/juego/{id}")
    public Puntuacion crearPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion) {
        Puntuacion rec = juegoRepositorio.findById(id).map(
                juego -> {
                    puntuacion.setJuego(juego);
                    return puntuacionRepositorio.save(puntuacion);
                }
        ).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        return rec;
    }

    //actualizar puntuacion (PUT)
    @PutMapping("/{id}")
    public Puntuacion actualizarPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion) {
        return puntuacionRepositorio.findById(id).map(puntuacionTemp -> {
            puntuacionTemp.setCantidad(puntuacion.getCantidad());
            puntuacionTemp.setJugador(puntuacion.getJugador());
            return puntuacionRepositorio.save(puntuacionTemp);
        }).orElseThrow(() -> new RuntimeException("Puntuacion no encontrada"));
    }

    //eliminar Puntuacion (DELETE)
    @DeleteMapping("/{id}")
    public void eliminarPuntuacion(@PathVariable Long id) {
        puntuacionRepositorio.deleteById(id);
    }
}
