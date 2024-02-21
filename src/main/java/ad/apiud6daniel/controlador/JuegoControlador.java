package ad.apiud6daniel.controlador;

import ad.apiud6daniel.modelo.Juego;
import ad.apiud6daniel.repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/juego")
public class JuegoControlador {

    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //Todos los juegos
    @GetMapping
    public List<Juego> obtenerJuegos() {
        return juegoRepositorio.findAll();
        //Al entrar en la url de arriba, se ejecuta
    }

    //Un juego por su ID
    @GetMapping("/{id}")
    public Juego obtenerJuegoId(@PathVariable Long id) {
        Optional<Juego> resultado = juegoRepositorio.findById(id);
        return resultado.orElseThrow(()-> new RuntimeException("Juego no encontrado"));
    }

    //Crear juego(POST)
    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoRepositorio.save(juego);
    }

    //actualizar juego(POST)
    @PostMapping("/{id}")
    public Juego actualizarJuego(@PathVariable Long id, @RequestBody Juego juego) {
        return juegoRepositorio.findById(id).map(juegoTemp -> {
            juegoTemp.setNombre(juego.getNombre());
            return juegoRepositorio.save(juegoTemp);
        }).orElseThrow(()-> new RuntimeException("Juego no encontrado"));
    }

    //eliminar juego (Delete)
    @DeleteMapping("/{id}")
    public void eliminarJuego(@PathVariable Long id) {
        juegoRepositorio.deleteById(id);
    }
}
