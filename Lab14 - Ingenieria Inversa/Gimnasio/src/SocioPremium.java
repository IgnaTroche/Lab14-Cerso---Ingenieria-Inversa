/* HERENCIA: SocioPremium "extends" Socio, o sea que ES un Socio, pero
  más específico. Hereda el nombre, la membresía y los métodos de Socio. */
public class SocioPremium extends Socio {

    public SocioPremium(String nombre, String apellido, String dni, double precio) {
        super(nombre, apellido, dni, precio);
    }

    // Redefinimos el método heredado para cambiar su comportamiento: el premium paga un 50% más.
    @Override
    public double calcularCuota() {
        return super.calcularCuota() * 1.5;
    }
}