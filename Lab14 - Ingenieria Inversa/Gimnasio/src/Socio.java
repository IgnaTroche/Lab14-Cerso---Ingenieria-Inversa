/*REALIZACIÓN: Socio "implements" Cobrable, o sea que se compromete a 
  cumplir el contrato de la interfaz (tiene que definir calcularCuota). */
// HERENCIA: extends Persona (un Socio ES una Persona).
public class Socio extends Persona implements Cobrable {
    // COMPOSICIÓN: la Membresia se crea DENTRO del Socio y no existe sin él.
    private Membresia membresia;

    public Socio(String nombre, String apellido, String dni, double precio) {
        super(nombre, apellido, dni);
        this.membresia = new Membresia(precio);
    }

    @Override
    public double calcularCuota() {
        return membresia.getPrecioBase();
    }
}
