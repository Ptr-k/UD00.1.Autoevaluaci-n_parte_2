package Laboral;

public class CalculaNominas {
    public static void main(String[] args) {

        try {
            Empleado empl1 = new Empleado("James Cosling", "32000032R", 'M', 4, 7);
            Empleado empl2 = new Empleado("Ada Lovelace", "32000031R", 'F');

            // Se hace la primera llamada al método escribe.
            escribe(empl1, empl2);

            // Se incrementa los años y se cambia la categoría de los empleados.
            empl1.setCategoria(9);
            empl2.incrAnyo();
            System.out.println("\nNuevos empleados con nuevo sueldo:\n");
            escribe(empl1, empl2);
        } catch (DatosNoCorrectosException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escribe(Empleado empleado1, Empleado empleado2) {
        /**
         * Al ingresar dos empleados, este método imprime directamente sus atributos,
         * utilizando el método imprime de {@link Persona}.
         * Al igual que también utiliza {@link Nomina} para sacar el sueldo.
         */
        Nomina nom = new Nomina();

        System.out.println("Emplado Número 1:");
        empleado1.imprime();
        System.out.println("Saldo: " + nom.sueldo(empleado1));

        System.out.println("\nEmplado Número 2:");
        empleado2.imprime();
        System.out.println("Saldo: " + nom.sueldo(empleado2));
    }
}