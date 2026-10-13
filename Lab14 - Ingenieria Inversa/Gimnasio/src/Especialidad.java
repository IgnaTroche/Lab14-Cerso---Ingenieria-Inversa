import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Especialidad {
    private String nombre;

    // AGREGACIÓN: la Especialidad TIENE Entrenadores, pero los Entrenadores
    // se crean afuera y se le pasan. Si la Especialidad desaparece,
    // los Entrenadores siguen existiendo.
    private List<Entrenador> entrenadores = new ArrayList<>();

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void agregarEntrenador(Entrenador e) {
        entrenadores.add(e);
    }

    public List<Entrenador> getEntrenadores() {
        return Collections.unmodifiableList(entrenadores);
    }
}