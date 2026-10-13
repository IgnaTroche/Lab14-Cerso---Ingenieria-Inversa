import java.util.ArrayList;
import java.util.List;
//Los import son necesarios para poder utilizar el List y ArrayList que vienen de la librería de Java (java.util)

import java.util.Collections;
public class Gimnasio {
    private String nombre;

    /*AGREGACIÓN: el Gimnasio TIENE Socios, pero los Socios se crean
      afuera y se le pasan. Si el Gimnasio cierra, los Socios siguen existiendo.*/
    private List<Socio> socios = new ArrayList<>();

    /* AGREGACIÓN: igual con los Entrenadores. Se crean afuera (en App)
      y el Gimnasio solo guarda la referencia.*/
    private List<Entrenador> entrenadores = new ArrayList<>();

    // COMPOSICIÓN: las Especialidades se crean DENTRO del Gimnasio y no existen
    // sin él. Si el Gimnasio desaparece, sus Especialidades desaparecen con él.
    private final List<Especialidad> especialidades;

    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.socios = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.especialidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarSocio(Socio s) {
        socios.add(s);
    }

    public void agregarEntrenador(Entrenador e) {
        entrenadores.add(e);
    }

    public void crearEspecialidad(String nombreEspecialidad) {
        especialidades.add(new Especialidad(nombreEspecialidad));
    }

    public void asignarEntrenador(String nombreEspecialidad, Entrenador e) {
        // El entrenador tiene que trabajar en el gimnasio antes de ser asignado
        if (!entrenadores.contains(e)) {
            System.out.println("Primero hay que agregar al entrenador al gimnasio");
            return;
        }
        for (Especialidad esp : especialidades) {
            if (esp.getNombre().equals(nombreEspecialidad)) {
                esp.agregarEntrenador(e);
                return;
            }
        }
        System.out.println("No existe la especialidad: " + nombreEspecialidad);
    }

    public double recaudacionTotal() {
        double total = 0;
        for (Socio s : socios) {
            total += s.calcularCuota();
        }
        return total;
    }

    public List<Socio> getSocios() {
        return Collections.unmodifiableList(socios);
    }

    public List<Entrenador> getEntrenadores() {
        return Collections.unmodifiableList(entrenadores);
    }

    public List<Especialidad> getEspecialidades() {
        return Collections.unmodifiableList(especialidades);
    }
}