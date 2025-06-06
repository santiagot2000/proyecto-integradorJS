package org.example;

import org.example.datos.*;
import org.example.modelo.empleados;
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
                    System.out.println("1. Agregar servicios");
                    System.out.println("2. Consultar servicios");
                    System.out.println("3. Actualizar servicios");
                    System.out.println("4. Eliminar servicios");
                    System.out.println("5. Listar servicios");
                    System.out.println("6. Buscar servicio por ID");
                    System.out.println("7. Finalizar");
                    System.out.println("8. CRUD Empleados");
                    System.out.println("9. CRUD Usuarios");
                    System.out.println("10. CRUD Facturas");
                    System.out.println("11. CRUD Ventas");
                    System.out.println("12. Salir");
                    System.out.print("\n Seleccione una opción: ");
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
                            // Invocar el metodo para agregar el servicio
                            ser.agregarServicio(new servicio(identServicio, nombreServicio, observaciones, precio, duracion));
                            System.out.println("Servicio"+ identServicio + "agregado exitosamente.");
                            break;
                        case 2:
                            // Consultar servicio
                            System.out.println("Consultar Servicio");
                            System.out.println("Ingrese la id del servicio a consultar:");
                            Integer idServicioConsulta = sc.nextInt();
                            // Invocar el metodo para consultar el servicio
                            ser.consultarServicio(idServicioConsulta);
                            break;
                        case 3:
                            // Actualizar servicio
                            System.out.println("Actualizar Servicio");
                            System.out.println("Ingrese la id del servicio a actualizar:");
                            Integer idServicioActualizar = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            if (!ser.buscarServicioxid(idServicioActualizar).isEmpty()) {
                                System.out.println("Ingrese el nuevo nombre del servicio:");
                                String nuevoNombreServicio = sc.nextLine();
                                System.out.println("Ingrese las nuevas observaciones del servicio:");
                                String nuevasObservaciones = sc.nextLine();
                                System.out.println("Ingrese el nuevo precio del servicio:");
                                int nuevoPrecio = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer
                                System.out.println("Ingrese la nueva duración del servicio:");
                                String nuevaDuracion = sc.nextLine();
                                // Invocar el metodo para actualizar el servicio
                                ser.actualizarServicio(new servicio(idServicioActualizar, nuevoNombreServicio, nuevasObservaciones, nuevoPrecio, nuevaDuracion));
                                System.out.println("Servicio" + idServicioActualizar+ "actualizado exitosamente.");
                            }else {
                                System.out.println("El servicio con ID " + idServicioActualizar + " no existe.");
                            }
                            break;
                        case 4:
                            // Eliminar servicio
                            System.out.println("Eliminar Servicio");
                            System.out.println("Ingrese la id del servicio a eliminar:");
                            Integer idServicioEliminar = sc.nextInt();
                            // Invocar el metodo para eliminar el servicio
                            ser.eliminarServicio(idServicioEliminar);
                            System.out.println("Servicio de " + idServicioEliminar +  "eliminado exitosamente.");
                            break;
                        case  5:
                            // listar servicios
                            System.out.println("listar Servicios");
                            ser.listarServicios();
                            break;
                        case 6:
                            // buscar servicio por ID
                            System.out.print("ID de servicio a buscar: ");
                            Integer buscarServicio = sc.nextInt();
                            //invocar el metodo de buscar vehiculo por placa
                            if (!ser.buscarServicioxid(buscarServicio).isEmpty()){
                                //recorrer la lista que devolvio el metodo buscarServicioxid
                                ser.buscarServicioxid(buscarServicio).forEach(servicio -> System.out.println(servicio.getNombreser()+ "-"+servicio.getObservaciones()+ "-"+servicio.getPrecio()+"-"+servicio.getDuracion()));
                            }else{
                                System.out.println("numero de ID INEXISTENTE. intentelo con otra ID");
                            }
                            break;
                        case 7:
                            // Finalizar
                            System.out.println("Finalizando el programa...");
                            break;
                        case 8:
                            // CRUD Empleados
                            int opcionEmp;
                            empleadosCrud empC = new empleadosCrud();

                            do {
                                System.out.println("\n CRUD Empleados \n");
                                System.out.println("1. Agregar Empleado");
                                System.out.println("2. Consultar Empleado");
                                System.out.println("3. Actualizar Empleado");
                                System.out.println("4. Eliminar Empleado");
                                System.out.println("5. Listar Empleados");
                                System.out.println("6. Buscar Empleado por ID");
                                System.out.println("7. Volver al menú principal");
                                System.out.print("\n Seleccione una opción: ");
                                opcionEmp = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionEmp) {
                                    case 1:
                                        // Agregar empleado
                                        System.out.println("Agregar Empleado");
                                        System.out.println("Ingrese la ID del empleado:");
                                        Integer idEmpleado = sc.nextInt();
                                        System.out.println("Ingrese el nombre del empleado:");
                                        String nombreEmpleado = sc.nextLine();
                                        System.out.println("Ingrese el telefono del empleado:");
                                        String telefonoEmpleado = sc.nextLine();
                                        System.out.println("Ingrese el correo del empleado:");
                                        String correoEmpleado = sc.nextLine();
                                        System.out.println("Ingrese la dirección del empleado:");
                                        String direccionEmpleado = sc.nextLine();
                                        System.out.println("Ingrese la fecha de ingreso del empleado (YYYY-MM-DD):");
                                        String fechaIngresoEmpleado = sc.nextLine();
                                        // Invocar el metodo para agregar el empleado
                                        empC.agregarEmpleado(new empleados(idEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, direccionEmpleado, fechaIngresoEmpleado));
                                        System.out.println("Empleado " + idEmpleado + " agregado exitosamente.");
                                        break;
                                    case 2:
                                        // Consultar empleado
                                        System.out.println("Consultar Empleado");
                                        System.out.println("Ingrese la id del empleado a consultar:");
                                        String idEmpleadoConsulta = sc.nextLine();
                                        // Invocar el metodo para consultar el servicio
                                        emp.consultarEmpleado(idEmpleadoConsulta);
                                        break;
                                    case 3:
                                        // Actualizar empleado
                                        System.out.println("Actualizar Empleado");
                                        System.out.println("Ingrese la id del servicio a actualizar:");
                                        Integer idEmpleadoActualizar = sc.nextInt();
                                        sc.nextLine(); // Limpiar el buffer
                                        if (!ser.buscarServicioxid(idEmpleadoActualizar).isEmpty()) {
                                            System.out.println("Ingrese el nuevo nombre del empleado:");
                                            String nuevoNombreEmpleado = sc.nextLine();
                                            System.out.println("Ingrese el nuevo telefono del empleado:");
                                            String nuevoTelefonoEmpleado = sc.nextLine();
                                            System.out.println("Ingrese el nuevo correo del empleado:");
                                            String nuevoCorreoEmpleado = sc.nextLine();
                                            System.out.println("Ingrese la nueva dirección del empleado:");
                                            String nuevaDireccionEmpleado = sc.nextLine();
                                            System.out.println("Ingrese la nueva fecha de ingreso del empleado (YYYY-MM-DD):");
                                            String nuevaFechaIngresoEmpleado = sc.nextLine();
                                            // Invocar el metodo para actualizar el servicio
                                            emp.actualizarEmpleado(new empleados(idEmpleadoActualizar, nuevoNombreEmpleado, nuevoTelefonoEmpleado, nuevoCorreoEmpleado, nuevaDireccionEmpleado, nuevaFechaIngresoEmpleado));
                                            System.out.println("Servicio" + idEmpleadoActualizar+ "actualizado exitosamente.");
                                        }else {
                                            System.out.println("El servicio con ID " + idEmpleadoActualizar + " no existe.");
                                        }
                                        break;
                                    case 4:
                                        // Eliminar empleado
                                        System.out.println("Eliminar Empleado");
                                        System.out.println("Ingrese la id del empleado a eliminar:");
                                        String idEmpleadoEliminar = sc.nextLine();
                                        // Invocar el metodo para eliminar el servicio
                                        empC.eliminarEmpleado(idEmpleadoEliminar);
                                        System.out.println("Empleado con id " + idEmpleadoEliminar + " eliminado exitosamente.");
                                        break;
                                    case 5:
                                        // Listar empleados
                                        System.out.println("Listar Empleados");
                                        empC.listarEmpleados();
                                        break;
                                    case 6:
                                        // Buscar empleado por ID
                                        System.out.print("ID de servicio a buscar: ");
                                        Integer buscarEmpleado = sc.nextInt();
                                        //invocar el metodo de buscar empleado por ID
                                        if (!emp.buscarEmpleadoxid(buscarEmpleado).isEmpty()){
                                            //recorrer la lista que devolvio el metodo buscarEmpleadoxid
                                            emp.buscarEmpleadoxid(buscarEmpleado).forEach(empleados ->
                                                    System.out.println(empleados.getIdEmpleado() + "-" + empleados.getNombre() + "-" + empleados.getTelefono() + "-" + empleados.getCorreo() + "-" +
                                                            empleados.getDireccion() + "-" + empleados.getFechaIngreso()));
                                        }else{
                                            System.out.println("numero de ID INEXISTENTE. intentelo con otra ID");
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionEmp != 7);
                            break;
                        case 9:
                            // CRUD usuarios
                            int opcionUsu;
                            usuariosCrud usuC = new usuariosCrud();
                            do {
                                System.out.println("\n CRUD Usuarios \n");
                                System.out.println("1. Agregar Usuario");
                                System.out.println("2. Consultar Usuario");
                                System.out.println("3. Actualizar Usuario");
                                System.out.println("4. Eliminar Usuario");
                                System.out.println("5. Listar Usuarios");
                                System.out.println("6. Buscar Usuario por ID");
                                System.out.println("7. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionUsu = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionUsu) {
                                    case 1:
                                        // Agregar usuario
                                        break;
                                    case 2:
                                        // Consultar usuario
                                        break;
                                    case 3:
                                        // Actualizar usuario
                                        break;
                                    case 4:
                                        // Eliminar usuario
                                        break;
                                    case 5:
                                        // Listar usuarios
                                        break;
                                    case 6:
                                        // Buscar usuario por ID
                                        break;
                                    case 7:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionUsu != 7);
                            break;
                        case 10:
                            // CRUD Facturas
                            int opcionFac;
                            facturasCrud facC = new facturasCrud();

                            do {
                                System.out.println("\n CRUD Facturas \n");
                                System.out.println("1. Agregar Factura");
                                System.out.println("2. Consultar Factura");
                                System.out.println("3. Actualizar Factura");
                                System.out.println("4. Eliminar Factura");
                                System.out.println("5. Listar Facturas");
                                System.out.println("6. Buscar Factura por ID");
                                System.out.println("7. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionFac = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionFac) {
                                    case 1:
                                        // Agregar factura
                                        break;
                                    case 2:
                                        // Consultar factura
                                        break;
                                    case 3:
                                        // Actualizar factura
                                        break;
                                    case 4:
                                        // Eliminar factura
                                        break;
                                    case 5:
                                        // Listar facturas
                                        break;
                                    case 6:
                                        // Buscar factura por ID
                                        break;
                                    case 7:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionFac != 7);
                            break;
                        case 11:
                            // CRUD Ventas
                            int opcionVen;
                            ventasCrud venC = new ventasCrud();

                            do {
                                System.out.println("\n CRUD Ventas \n");
                                System.out.println("1. Agregar Venta");
                                System.out.println("2. Consultar Venta");
                                System.out.println("3. Actualizar Venta");
                                System.out.println("4. Eliminar Venta");
                                System.out.println("5. Listar Ventas");
                                System.out.println("6. Buscar Venta por ID");
                                System.out.println("7. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionVen = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionVen) {
                                    case 1:
                                        // Agregar venta
                                        break;
                                    case 2:
                                        // Consultar venta
                                        break;
                                    case 3:
                                        // Actualizar venta
                                        break;
                                    case 4:
                                        // Eliminar venta
                                        break;
                                    case 5:
                                        // Listar ventas
                                        break;
                                    case 6:
                                        // Buscar venta por ID
                                        break;
                                    case 7:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionVen != 7);
                            break;
                    }
                }
                while (opcion != 11);
                }
        }
        catch (SQLException e){
            System.out.println("Error de conexión con MySQL");
        }

    }
}
