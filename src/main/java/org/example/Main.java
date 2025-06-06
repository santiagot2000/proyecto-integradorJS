package org.example;

import org.example.datos.*;
import org.example.modelo.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        // Generar la coneccional servidor y su base de datos
        empleadosCrud emp = new empleadosCrud();
        facturasCrud fac = new facturasCrud();
        servicioCrud ser = new servicioCrud();
        usuariosCrud usu = new usuariosCrud();
        ventasCrud ven = new ventasCrud();
        // Definir variables de tipo connection
        Connection cnx = null;
        try {
            cnx = ser.conectar();
            if (cnx != null && !cnx.isClosed()) {// credenciales correctas
                // Menu para CRUD servicios
                Integer opcion = 0;
                do {
                    System.out.println("\n CRUD servicios \n");
                    System.out.println("1. agregar servicios");
                    System.out.println("2. consultar servicios");
                    System.out.println("3. actualizar servicios");
                    System.out.println("4. eliminar servicios");
                    System.out.println("5. buscar servicio por ID");
                    System.out.println("6. CRUD Empleados");
                    System.out.println("8. CRUD Usuarios");
                    System.out.println("7. CRUD Facturas");
                    System.out.println("9. CRUD Ventas");
                    System.out.println("10. Salir");
                    System.out.print("\n opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    switch (opcion){
                        case 1:
                            // Agregar servicio
                            System.out.println("Agregar Servicio");
                            System.out.println("Ingrese la id del servicio:");
                            Integer identServicio = sc.nextInt();
                            System.out.println("Ingrese el nombre del servicio:");
                            String nombreServicio = sc.nextLine();
                            System.out.println("Ingrese las observaciones del servicio:");
                            String observaciones = sc.nextLine();
                            System.out.println("Ingrese el precio del servicio:");
                            int precio = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            System.out.println("Ingrese la duración del servicio:");
                            String duracion = sc.nextLine();
                            // Invocar el mérodo para agregar el servicio
                            ser.agregarServicio(new servicio(identServicio, nombreServicio, observaciones, precio, duracion));
                            System.out.println("Servicio agregado exitosamente.");
                            break;
                    }

                }
                while (opcion != 10);
                }
        }
        catch (SQLException e){
            System.out.println("Error de conexión con MySQL");
        }

    }
}
