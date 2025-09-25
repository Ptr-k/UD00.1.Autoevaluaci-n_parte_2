package Laboral.Parte2;

import Laboral.DatosNoCorrectosException;
import Laboral.Empleado;
import Laboral.Nomina;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculaNominas_p2 {
    public CalculaNominas_p2() throws FileNotFoundException, IOException, DatosNoCorrectosException {
    }

    public static void main(String[] args) {
        try (FileWriter wr = new FileWriter("empleados.txt")) {

            // Se crea el archivo de texto donde se imprime toda
            // la información de los empleados, junto a una nómina
            // para poder sacar el sueldo.
            Empleado empl1 = new Empleado("James Cosling", "32000032R", 'M', 4,  7);
            Empleado empl2 = new Empleado("Ada Lovelace", "32000031R", 'F');
            Nomina nom = new Nomina();

            // Para la conexión con la base de datos.
            Connection conn = null;
            PreparedStatement statement = null;

            // Se crea una lista para facilitar la impresión en el documento.
            List<Empleado> lista = new ArrayList();
            lista.add(empl1);
            lista.add(empl2);

            for (int i = 0; i < lista.size(); i++) {
                wr.write("\nEMPLEADO " + (i + 1) + ":");
                wr.write("\nNombre: " + lista.get(i).nombre);
                wr.write("\nDNI: " + lista.get(i).dni);
                wr.write("\nSexo: " + lista.get(i).sexo +"\n");
                wr.write("\nAños: " + lista.get(i).anyos);
                wr.write("\nCategoria: " + lista.get(i).getCategoria());
                wr.write("\nSueldo:" + nom.sueldo(lista.get(i)) + "\n");
            }

            try (FileOutputStream out = new FileOutputStream("saldo.dat")) {
                out.write(empl1.dni.getBytes(StandardCharsets.UTF_8));
                // llego a utilizar "out.write(10);" para separar las lineas, ya que es
                // de caracter binario.
                out.write(10);
                out.write(String.valueOf(nom.sueldo(empl1)).getBytes());
                out.write(10);
                out.write(empl2.dni.getBytes(StandardCharsets.UTF_8));
                out.write(10);
                out.write(String.valueOf(nom.sueldo(empl2)).getBytes());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("No se ha creado el archivo de texto.");

        } catch (DatosNoCorrectosException e) {
            System.out.println(e.getMessage());

        }

    }
}
