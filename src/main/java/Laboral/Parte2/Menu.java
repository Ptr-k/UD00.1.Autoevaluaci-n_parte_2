package Laboral.Parte2;

import Laboral.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Creación de un menú que utilice la base de datos creada anteriormente.
 */

public class Menu {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nominas", "root", "123456")) {
            int opcion;
            Scanner sc = new Scanner(System.in);

            do {

                System.out.println("MENU");
                System.out.println("------------------------------------------------------------------");
                System.out.println("1. Mostrar la información existente de todos los empleados.");
                System.out.println("2. Mostrar salario existente de todos los empleados por DNI.");
                System.out.println("3. Modificar datos de empleado.");
                System.out.println("4. Recalcular y actualizar sueldo de un empleado.");
                System.out.println("5. Recalcular y actualizar sueldo de todos los empleados.");
                System.out.println("6. Realizar copia de seguridad.");
                System.out.println("7. Salir del programa.");

                System.out.println("------------------------------------------------------------------\n");
                System.out.print("\nSeleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    default:
                        System.out.println("Elija una opción válida");
                        break;
                    case 1:
                        List<Empleado> empleados = new ArrayList<>();
                        String consulta = "SELECT * FROM empleados ORDER BY nombre";

                        try(Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(consulta)) {

                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("Saliendo del programa.");
                        break;
                }
            } while (opcion != 7);

        } catch (SQLException e) {
            System.out.println("Hubo un error al acceder a la base de datos.");
            throw new RuntimeException(e);
        }
    }
}
