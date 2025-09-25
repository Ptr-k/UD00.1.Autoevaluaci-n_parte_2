package Laboral;

public class Persona {
    // Atributos.
    public String nombre;
    public String dni;
    public char sexo;

    // Constructores.
    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }
    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    // Métodos.
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void imprime() {
        System.out.println("Nombre: " + dni + "\nSexo: " + sexo);
    }
}