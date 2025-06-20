package org.example;

import org.example.datos.*;
import org.example.modelo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
                    System.out.println("6. Finalizar");
                    System.out.println("7. CRUD Empleados");
                    System.out.println("8. CRUD Usuarios");
                    System.out.println("9. CRUD Facturas");
                    System.out.println("10. CRUD Ventas");
                    System.out.println("11. Salir");
                    System.out.print("\n Seleccione una opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    switch (opcion){
                        case 1:
                            // Agregar servicio
                            System.out.println("Agregar Servicio");
                            System.out.print("Ingrese la id del servicio:");
                            Integer identServicio = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            System.out.print("Ingrese el nombre del servicio:");
                            String nombreServicio = sc.nextLine();
                            System.out.print("Ingrese las observaciones del servicio:");
                            String observaciones = sc.nextLine();
                            System.out.print("Ingrese el precio del servicio:");
                            int precio = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            System.out.print("Ingrese la duración del servicio:");
                            String duracion = sc.nextLine();
                            // Invocar el metodo para agregar el servicio
                            ser.agregarServicio(new servicio(identServicio, nombreServicio, observaciones, precio, duracion));
                            System.out.print("Servicio "+ identServicio + " agregado exitosamente.");
                            break;
                        case 2:
                            // Consultar servicio
                            System.out.println("Consultar Servicio");
                            System.out.print("Ingrese la id del servicio a consultar:");
                            Integer idServicioConsulta = sc.nextInt();
                            // Invocar el metodo para consultar el servicio
                            ser.consultarServicio(idServicioConsulta);
                            break;
                        case 3:
                            // Actualizar servicio
                            System.out.println("Actualizar Servicio");
                            System.out.print("Ingrese la id del servicio a actualizar:");
                            Integer idServicioActualizar = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            if (!ser.buscarServicioxid(idServicioActualizar).isEmpty()) {
                                System.out.print("Ingrese el nuevo nombre del servicio:");
                                String nuevoNombreServicio = sc.nextLine();
                                System.out.print("Ingrese las nuevas observaciones del servicio:");
                                String nuevasObservaciones = sc.nextLine();
                                System.out.print("Ingrese el nuevo precio del servicio:");
                                int nuevoPrecio = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer
                                System.out.print("Ingrese la nueva duración del servicio:");
                                String nuevaDuracion = sc.nextLine();
                                // Invocar el metodo para actualizar el servicio
                                ser.actualizarServicio(new servicio(idServicioActualizar, nuevoNombreServicio, nuevasObservaciones, nuevoPrecio, nuevaDuracion));
                                System.out.println("Servicio " + idServicioActualizar+ "actualizado exitosamente.");
                            }else {
                                System.out.println("El servicio con ID " + idServicioActualizar + " no existe.");
                            }
                            break;
                        case 4:
                            // Eliminar servicio
                            System.out.println("Eliminar Servicio");
                            System.out.print("Ingrese la id del servicio a eliminar:");
                            Integer idServicioEliminar = sc.nextInt();
                            // Invocar el metodo para eliminar el servicio
                            ser.eliminarServicio(idServicioEliminar);
                            System.out.println("Servicio de id " + idServicioEliminar +  " eliminado exitosamente.");
                            break;
                        case  5:
                            // listar servicios
                            System.out.println("listar Servicios");
                            ser.listarServicios();
                            break;
                        case 6:
                            // Finalizar
                            System.out.println("Finalizando el programa...");
                            break;
                        case 7:
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
                                System.out.println("6. Volver al menú principal");
                                System.out.print("\n Seleccione una opción: ");
                                opcionEmp = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionEmp) {
                                    case 1:
                                        // Agregar empleado
                                        System.out.println("Agregar Empleado");
                                        System.out.print("Ingrese la ID del empleado:");
                                        Integer idEmpleado = sc.nextInt();
                                        sc.nextLine(); // Limpiar el buffer
                                        System.out.print("Ingrese el nombre del empleado:");
                                        String nombreEmpleado = sc.nextLine();
                                        System.out.print("Ingrese el telefono del empleado:");
                                        String telefonoEmpleado = sc.nextLine();
                                        System.out.print("Ingrese el correo del empleado:");
                                        String correoEmpleado = sc.nextLine();
                                        System.out.print("Ingrese la dirección del empleado:");
                                        String direccionEmpleado = sc.nextLine();
                                        System.out.print("Ingrese la fecha de ingreso del empleado (YYYY-MM-DD):");
                                        String fechaIngresoEmpleado = sc.nextLine();
                                        // Invocar el metodo para agregar el empleado
                                        empC.agregarEmpleado(new empleados(idEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, direccionEmpleado, fechaIngresoEmpleado));
                                        System.out.println("Empleado " + idEmpleado + " agregado exitosamente.");
                                        break;
                                    case 2:
                                        // Consultar empleado
                                        System.out.println("Consultar Empleado");
                                        System.out.print("Ingrese la id del empleado a consultar:");
                                        String idEmpleadoConsulta = sc.nextLine();
                                        // Invocar el metodo para consultar el servicio
                                        empC.consultarEmpleado(idEmpleadoConsulta);
                                        break;
                                    case 3:
                                        // Actualizar empleado
                                        System.out.println("Actualizar Empleado");
                                        System.out.print("Ingrese la id del servicio a actualizar:");
                                        Integer idEmpleadoActualizar = sc.nextInt();
                                        sc.nextLine(); // Limpiar el buffer
                                        if (!empC.buscarEmpleadoxid(idEmpleadoActualizar).isEmpty()) {
                                            System.out.print("Ingrese el nuevo nombre del empleado:");
                                            String nuevoNombreEmpleado = sc.nextLine();
                                            System.out.print("Ingrese el nuevo telefono del empleado:");
                                            String nuevoTelefonoEmpleado = sc.nextLine();
                                            System.out.print("Ingrese el nuevo correo del empleado:");
                                            String nuevoCorreoEmpleado = sc.nextLine();
                                            System.out.print("Ingrese la nueva dirección del empleado:");
                                            String nuevaDireccionEmpleado = sc.nextLine();
                                            System.out.print("Ingrese la nueva fecha de ingreso del empleado (YYYY-MM-DD):");
                                            String nuevaFechaIngresoEmpleado = sc.nextLine();
                                            // Invocar el metodo para actualizar el servicio
                                            empC.actualizarEmpleado(new empleados(idEmpleadoActualizar, nuevoNombreEmpleado, nuevoTelefonoEmpleado, nuevoCorreoEmpleado, nuevaDireccionEmpleado, nuevaFechaIngresoEmpleado));
                                            System.out.println("Servicio " + idEmpleadoActualizar+ "actualizado exitosamente.");
                                        }else {
                                            System.out.println("El servicio con ID " + idEmpleadoActualizar + " no existe.");
                                        }
                                        break;
                                    case 4:
                                        // Eliminar empleado
                                        System.out.println("Eliminar Empleado");
                                        System.out.print("Ingrese la id del empleado a eliminar:");
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
                                        // Volver al menú principal
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionEmp != 6);
                            break;
                        case 8:
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
                                System.out.println("6. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionUsu = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionUsu) {
                                    case 1:
                                        // Agregar usuario
                                        System.out.println("Agregar Usuario");
                                        System.out.print("Ingrese la ID del usuario:");
                                        Integer idUsuario = sc.nextInt();
                                        sc.nextLine(); // Limpiar el buffer
                                        System.out.print("Ingrese el nombre del usuario:");
                                        String nombreUsuario = sc.nextLine();
                                        System.out.print("Ingrese el telefono del usuario:");
                                        String telefonoUsuario = sc.nextLine();
                                        System.out.print("Ingrese la dirección del usuario:");
                                        String direccionUsuario = sc.nextLine();
                                        System.out.print("Ingrese el correo del usuario:");
                                        String correoUsuario = sc.nextLine();
                                        // Invocar el metodo para agregar el usuario
                                        usuC.agregarUsuario(new usuarios(idUsuario, nombreUsuario, telefonoUsuario, direccionUsuario, correoUsuario));
                                        System.out.println("Usuario " + idUsuario + " agregado exitosamente.");
                                        break;
                                    case 2:
                                        // Consultar usuario
                                        System.out.println("Consultar Usuario");
                                        System.out.print("Ingrese la id del usuario a consultar:");
                                        String idUsuarioConsulta = sc.nextLine();
                                        // Invocar el metodo para consultar el usuario
                                        usuC.consultarUsuario(idUsuarioConsulta);
                                        break;
                                    case 3:
                                        // Actualizar usuario
                                        System.out.println("Actualizar Usuario");
                                        System.out.print("Ingrese la id del usuario a actualizar:");
                                        Integer idUsuarioActualizar = sc.nextInt();
                                        sc.nextLine(); // Limpiar el buffer
                                        if (!usuC.buscarUsuariosxid(idUsuarioActualizar).isEmpty()) {
                                            System.out.print("Ingrese el nuevo nombre del usuario:");
                                            String nuevoNombreUsuario = sc.nextLine();
                                            System.out.print("Ingrese el nuevo telefono del usuario:");
                                            String nuevoTelefonoUsuario = sc.nextLine();
                                            System.out.print("Ingrese la nueva dirección del usuario:");
                                            String nuevaDireccionUsuario = sc.nextLine();
                                            System.out.print("Ingrese el nuevo correo del usuario:");
                                            String nuevoCorreoUsuario = sc.nextLine();
                                            // Invocar el metodo para actualizar el usuario
                                            usuC.actualizarUsuario(new usuarios(idUsuarioActualizar, nuevoNombreUsuario, nuevoTelefonoUsuario, nuevaDireccionUsuario, nuevoCorreoUsuario));
                                            System.out.println("Usuario " + idUsuarioActualizar + " actualizado exitosamente.");
                                        } else {
                                            System.out.println("El usuario con ID " + idUsuarioActualizar + " no existe.");
                                        }
                                        break;
                                    case 4:
                                        // Eliminar usuario
                                        System.out.println("Eliminar Usuario");
                                        System.out.print("Ingrese la id del usuario a eliminar:");
                                        String idUsuarioEliminar = sc.nextLine();
                                        // Invocar el metodo para eliminar el usuario
                                        usuC.eliminarUsuario(idUsuarioEliminar);
                                        System.out.println("Usuario con id " + idUsuarioEliminar + " eliminado exitosamente.");
                                        break;
                                    case 5:
                                        // Listar usuarios
                                        System.out.println("Listar Usuarios");
                                        usuC.listarUsuarios();
                                        break;
                                    case 6:
                                        // Volver al menú principal
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionUsu != 6);
                            break;
                        case 9:
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
                                System.out.println("6. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionFac = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionFac) {
                                    case 1:
                                        // Agregar factura
                                        System.out.print("Ingrese ID del pago: ");
                                        int facT = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para facT
                                            facT = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el ID del pago.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        sc.nextLine(); // Limpiar el buffer
                                        System.out.print("Ingrese nombre del servicio: ");
                                        String nombreserviciofactura = sc.nextLine();
                                        System.out.print("Ingrese ID del usuario: ");
                                        Integer idusuariofactura = sc.nextInt();
                                        LocalDate pfecha = null; // Inicializar fecha como null
                                        boolean fechaValida = false;
                                        sc.nextLine(); // Limpiar el buffer
                                        while (!fechaValida) {
                                            System.out.print("Ingrese fecha (yyyy-MM-dd): ");
                                            String fechaStr = sc.nextLine(); // Leer como String
                                            try {
                                                pfecha = LocalDate.parse(fechaStr); // Intentar parsear
                                                fechaValida = true; // Si llega aquí, es válido
                                            } catch (DateTimeParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD (ej. 2024-05-28).");// El bucle seguirá pidiendo la fecha
                                            }
                                        }
                                        System.out.print("Ingrese valor del pago: ");
                                        int pvalor = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para pvalor
                                            pvalor = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el valor del pago.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        facturas pagoNuevo = new facturas(facT, nombreserviciofactura, idusuariofactura, pfecha, pvalor);
                                        facC.agregarPago(pagoNuevo);
                                        System.out.println("✔ Pago agregado correctamente.");
                                        break;
                                    case 2:
                                        // Consultar factura
                                        System.out.println("Consultar Factura");
                                        System.out.print("Ingrese la ID de la factura a consultar:");
                                        int idFacturaConsulta = sc.nextInt();
                                        // Invocar el metodo para consultar la factura
                                        facC.consultarPago(idFacturaConsulta);
                                        break;
                                    case 3:
                                        // Actualizar factura
                                        System.out.println("Actualizar Factura");
                                        System.out.print("Ingrese la ID de la factura a actualizar:");
                                        int idFacturaActualizar = sc.nextInt();
                                        System.out.print("Ingrese el nuevo nombre del servicio:");
                                        String nuevoNombreServicioFactura = sc.nextLine();
                                        System.out.print("Ingrese el nuevo ID del usuario:");
                                        Integer nuevoIdUsuarioFactura = sc.nextInt();
                                        LocalDate nuevaFechaFactura = null; // Inicializar fecha como null
                                        boolean fechaValidaFactura = false;
                                        while (!fechaValidaFactura) {
                                            System.out.print("Ingrese la nueva fecha (yyyy-MM-dd): ");
                                            String fechaStrFactura = sc.nextLine(); // Leer como String
                                            try {
                                                nuevaFechaFactura = LocalDate.parse(fechaStrFactura); // Intentar parsear
                                                fechaValidaFactura = true; // Si llega aquí, es válido
                                            } catch (DateTimeParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD (ej. 2024-05-28).");// El bucle seguirá pidiendo la fecha
                                            }
                                        }
                                        System.out.print("Ingrese el nuevo valor del pago:");
                                        int nuevoValorFactura = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para nuevoValorFactura
                                            nuevoValorFactura = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el nuevo valor del pago.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        facturas facturaActualizada = new facturas(idFacturaActualizar, nuevoNombreServicioFactura, nuevoIdUsuarioFactura, nuevaFechaFactura, nuevoValorFactura);
                                        facC.actualizarPago(facturaActualizada);
                                        System.out.println("Factura " + idFacturaActualizar + " actualizada exitosamente.");
                                        break;
                                    case 4:
                                        // Eliminar factura
                                        System.out.println("Eliminar Factura");
                                        System.out.print("Ingrese la ID de la factura a eliminar:");
                                        int idFacturaEliminar = sc.nextInt();
                                        // Invocar el metodo para eliminar la factura
                                        facC.eliminarPago(idFacturaEliminar);
                                        System.out.println("Factura con ID " + idFacturaEliminar + " eliminada exitosamente.");
                                        break;
                                    case 5:
                                        // Listar facturas
                                        System.out.println("Listar Facturas");
                                        facC.listarPagos();
                                        break;
                                    case 6:
                                        // Volver al menú principal
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionFac != 7);
                            break;
                        case 10:
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
                                System.out.println("6. Volver al menú principal");
                                System.out.print("\n opción: ");
                                opcionVen = sc.nextInt();
                                sc.nextLine(); // Limpiar el buffer

                                switch (opcionVen) {
                                    case 1:
                                        // Agregar venta
                                        System.out.print("Ingrese ID de la venta: ");
                                        int venT = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para facT
                                            venT = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el ID de la venta.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        LocalDate vfecha = null; // Inicializar fecha como null
                                        boolean fechaValida = false;
                                        sc.nextLine();
                                        while (!fechaValida) {
                                            System.out.print("Ingrese fecha (yyyy-MM-dd): ");
                                            String fechaStr = sc.nextLine(); // Leer como String
                                            try {
                                                vfecha = LocalDate.parse(fechaStr); // Intentar parsear
                                                fechaValida = true; // Si llega aquí, es válido
                                            } catch (DateTimeParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD (ej. 2024-05-28).");// El bucle seguirá pidiendo la fecha
                                            }
                                        }
                                        System.out.print("Ingrese el valor: ");
                                        int vvalor = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para vvalor
                                            vvalor = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el valor del monto total.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        sc.nextLine(); // Limpiar el buffer
                                        System.out.print("Ingrese el estado de la venta: ");
                                        String estadodeventa = sc.nextLine();
                                        System.out.print("Ingrese el canal de venta: ");
                                        String canaldeventa = sc.nextLine();
                                        ventas ventaNueva = new ventas(venT, vfecha, vvalor, estadodeventa, canaldeventa);
                                        venC.agregarVenta(ventaNueva);
                                        System.out.println("✔ Pago agregado correctamente.");
                                        break;
                                    case 2:
                                        // Consultar venta
                                        System.out.println("Consultar Venta");
                                        System.out.print("Ingrese la ID de la venta a consultar:");
                                        int idVentaConsulta = sc.nextInt();
                                        // Invocar el metodo para consultar la venta
                                        venC.consultarVenta(idVentaConsulta);
                                        break;
                                    case 3:
                                        // Actualizar venta
                                        System.out.println("Actualizar venta");
                                        System.out.print("Ingrese la ID de la venta a actualizar:");
                                        int idVentaActualizar = sc.nextInt();
                                        LocalDate nuevaFechaVenta = null; // Inicializar fecha como null
                                        boolean fechaValidaVenta = false;
                                        while (!fechaValidaVenta) {
                                            System.out.print("Ingrese la nueva fecha (yyyy-MM-dd): ");
                                            String fechaStrFactura = sc.nextLine(); // Leer como String
                                            try {
                                                nuevaFechaVenta = LocalDate.parse(fechaStrFactura); // Intentar parsear
                                                fechaValidaVenta = true; // Si llega aquí, es válido
                                            } catch (DateTimeParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD (ej. 2024-05-28).");// El bucle seguirá pidiendo la fecha
                                            }
                                        }
                                        System.out.print("Ingrese el nuevo valor:");
                                        int nuevoValorVenta = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para nuevoValorVenta
                                            nuevoValorVenta = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el nuevo valor del monto total.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        sc.nextLine(); // Limpiar el buffer
                                        System.out.print("Ingrese el nuevo estado de la venta:");
                                        String nuevoEstadoVenta = sc.nextLine();
                                        System.out.print("Ingrese el nuevo canal de venta:");
                                        String nuevoCanalVenta = sc.nextLine();
                                        ventas ventaActualizada = new ventas();
                                        venC.actualizarVenta(ventaActualizada);
                                        System.out.println("venta " + idVentaActualizar + " actualizada exitosamente.");
                                        break;
                                    case 4:
                                        // Eliminar venta
                                        System.out.println("Eliminar Venta");
                                        System.out.print("Ingrese la ID de la venta a eliminar:");
                                        int idVentaEliminar = sc.nextInt();
                                        // Invocar el metodo para eliminar la venta
                                        venC.eliminarVenta(idVentaEliminar);
                                        System.out.println("Venta con ID " + idVentaEliminar + " eliminada exitosamente.");
                                        break;
                                    case 5:
                                        // Listar ventas
                                        System.out.println("Listar Ventas");
                                        venC.listarVentas();
                                        break;
                                    case 6:
                                        // Volver al menú principal
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                }
                            }
                            while (opcionVen != 6);
                            break;
                        case 11:
                            // Salir del programa
                            System.out.println("Saliendo del programa...");
                            break;
                    }
                }
                while (opcion != 11);
                }
        }
        catch (SQLException e){
            System.out.println("Error de conexión con MySQL");
            e.printStackTrace();  // Para ver el detalle del error
        }finally {
            if (sc != null) {
                sc.close(); // Cerrar el scanner
            }
        }
    }
}
