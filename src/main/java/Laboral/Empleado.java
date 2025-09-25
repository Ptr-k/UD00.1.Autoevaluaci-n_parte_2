package Laboral;

public class Empleado extends Persona {
    /**
     * En esta clase, creada a partir de persona, se crean los empleados que
     * más tarde se utilizarán para calcular sus respectivas nóminas.
     * Se tiene que evitar utilizar:
     * <li>Una categoría menor a 1 o mayor a 10.</li>
     * <li>Años trabajados menores a 1.</li>
     * Se lanza un {@link DatosNoCorrectosException} si uno de esos errores suceden.
     */

    // Atributos.
    private int categoria;
    public int anyos;

    // Constructores de empleado.
    // Se crea una excepción para evitar que se ingresen datos erróneos.
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException  {
        super(nombre, dni, sexo);
        if(categoria < 1 || categoria > 10 || anyos < 0) {
            throw new DatosNoCorrectosException("Datos no correctos.");
        } else {
            this.categoria = categoria;
            this.anyos = anyos;
        }
    }
    public Empleado(String nombre, String dni, char sexo) {
        super(nombre, dni, sexo);
        this.categoria = 1;
        this.anyos = 0;
    }

    // Métodos.
    // Igual se crea una excepción en este método para evitar que se ingrese
    // una categoría que no sea posible.
    public void setCategoria(int categoria) throws DatosNoCorrectosException {
        /**
         * Ajusta la categoría por la indicada, asegurándose de que no
         * sea menor a 1 o mayor a 10, lanzando un {@link DatosNoCorrectosException}
         * en el caso que sus datos no sean válidos.
         */
        if(categoria <= 10 && categoria >= 1) {
            this.categoria = categoria;
        } else {
            throw new DatosNoCorrectosException("Datos no correctos.");
        }
    }
    public int getCategoria() {
        return categoria;
    }
    public void incrAnyo() {
        anyos =+ 1;
    }
    public void imprime() {
        System.out.println("Nombre:" + nombre + "\nDNI: " + dni + "\nSexo: " + sexo + "\nCategoria: " + categoria + "\nAños trabajados: " + anyos);
    }
}