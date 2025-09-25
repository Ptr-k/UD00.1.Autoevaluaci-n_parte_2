package Laboral.Parte2;

import Laboral.DatosNoCorrectosException;
import Laboral.Empleado;
import Laboral.Nomina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static void main(String[] args) {

        /**
         * Creación e insercción de datos en la base de datos, con sus debidas tablas
         * emepleado y nómina, en donde irán los empleados creados en los anteriores
         * ejercicios.
         */

        try {
            Empleado empl1 = new Empleado("James Cosling", "32000032R", 'M', 4,  7);
            Empleado empl2 = new Empleado("Ada Lovelace", "32000031R", 'F');
            Nomina nom = new Nomina();

            List<Empleado> lista = new ArrayList<>();
            lista.add(empl1);
            lista.add(empl2);

            // CREACIÓN DE LAS TABLAS
            String tabla_empleados = "CREATE TABLE IF NOT EXISTS Empleados ("
                    + " dni VARCHAR(9) PRIMARY KEY,  "
                    + " nombre VARCHAR(50) NOT NULL, "
                    + " sexo CHAR(1),   "
                    + " anyos INTEGER,   "
                    + " categoria INTEGER NOT NULL)";

            String tabla_nominas = "CREATE TABLE IF NOT EXISTS Nominas ("
                    + " sueldo INTEGER PRIMARY KEY,  "
                    + " empleado VARCHAR(9), "
                    + " FOREIGN KEY(empleado) REFERENCES Empleados(dni))";

            String crear_empleado = "INSERT INTO Empleados(dni, nombre, sexo, anyos, categoria) VALUES (?, ?, ?, ?, ?)";

            String crear_nomina = "INSERT INTO Nominas(sueldo, empleado) VALUES (?, ?)";

            // Creación de las tablas.
            try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nominas", "root", "123456");
                 Statement statm = conn.createStatement()) {

                statm.execute(tabla_empleados);
                statm.execute(tabla_nominas);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Crear e insertar los empleados en la base de datos.
            try {
                Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nominas", "root", "123456");
                PreparedStatement statm = conn.prepareStatement(crear_empleado); {
                    for (Empleado empleado : lista) {
                        statm.setString(1, empleado.dni);
                        statm.setString(2, empleado.nombre);
                        statm.setString(3, String.valueOf(empleado.sexo));
                        statm.setInt(4, empleado.anyos);
                        statm.setInt(5, empleado.getCategoria());
                        statm.execute();
            }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nominas", "root", "123456");
                PreparedStatement statm = conn.prepareStatement(crear_nomina);) {
                for (Empleado empleado : lista) {
                    statm.setInt(1, nom.sueldo(empleado));
                    statm.setString(2, empleado.dni);
                    statm.execute();
            }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }
    }
}
