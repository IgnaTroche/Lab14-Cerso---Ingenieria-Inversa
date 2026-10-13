public class App {
    public static void main(String[] args) {
        Entrenador juan = new Entrenador("Juan", "Pérez", "30111222");
        Entrenador jorge = new Entrenador("Jorge", "González", "30111333");

        Gimnasio gym = new Gimnasio("Gimnasio XYZ");

        System.out.println("Gimnasio: " + gym.getNombre());

        // Las Especialidades las crea el Gimnasio por dentro (composición)
        gym.agregarEntrenador(juan);
        gym.agregarEntrenador(jorge);

        gym.crearEspecialidad("Spinning");
        gym.crearEspecialidad("Pesas");

        gym.asignarEntrenador("Spinning", juan);
        gym.asignarEntrenador("Pesas", jorge);

        gym.agregarSocio(new Socio("Igna", "Gómez", "45123456", 20000));
        gym.agregarSocio(new SocioPremium("Lucía", "Díaz", "44987654", 20000));
        
        for (Especialidad esp : gym.getEspecialidades()) {
            System.out.println("Especialidad: " + esp.getNombre());
            for (Entrenador e : esp.getEntrenadores()) {
                System.out.println("  - " + e.getNombreCompleto());
            }
        }
        for (Socio s : gym.getSocios()) {
            System.out.println(s.getNombreCompleto() + " | DNI " + s.getDni()
                    + " | Cuota: $" + s.calcularCuota());
        }

        System.out.println("Recaudación: $" + gym.recaudacionTotal());
    }
}