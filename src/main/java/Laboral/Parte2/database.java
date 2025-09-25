package Laboral.Parte2;

import java.sql.*;

public class database {
    public static void main(String[] args) {

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

        try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nominas", "root", "123456");
            Statement statm = conn.createStatement()) {

            statm.execute(tabla_empleados);
            statm.execute(tabla_nominas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
