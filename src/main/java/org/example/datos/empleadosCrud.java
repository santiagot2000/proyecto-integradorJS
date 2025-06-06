package org.example.datos;

import org.example.modelo.empleados;
import org.example.modelo.servicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empleadosCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbintegrador";
    private final String user = "root";
    private final String password = "";

    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Metodos para el CRUD de empleados
    // Agregar empleado
    public void agregarEmpleado(org.example.modelo.empleados empleado) {
        String sql = "INSERT INTO empleados (idEmpleado, nombre, telefono, correo, direccion, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empleado.getIdEmpleado());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getTelefono());
            stmt.setString(4, empleado.getCorreo());
            stmt.setString(5, empleado.getDireccion());
            stmt.setString(6, empleado.getFechaIngreso());
            stmt.executeUpdate(); // Agrega el empleado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar empleado
    public void consultarEmpleado(String idEmpleado) {
        String sql = "SELECT * FROM empleados WHERE idEmpleado = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEmpleado);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Empleado encontrado:");
                System.out.println("ID Empleado: " + rs.getString("idEmpleado"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Fecha Ingreso: " + rs.getString("fechaIngreso"));
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar empleado
    public void actualizarEmpleado(org.example.modelo.empleados empleado) {
        String sql = "UPDATE empleados SET nombre = ?, telefono = ?, correo = ?, direccion = ?, fechaIngreso = ? WHERE idEmpleado = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getTelefono());
            stmt.setString(3, empleado.getCorreo());
            stmt.setString(4, empleado.getDireccion());
            stmt.setString(5, empleado.getFechaIngreso());
            stmt.setInt(6, empleado.getIdEmpleado());
            stmt.executeUpdate(); // Actualiza el empleado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar empleado
    public void eliminarEmpleado(String idEmpleado) {
        String sql = "DELETE FROM empleados WHERE idEmpleado = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEmpleado);
            stmt.executeUpdate(); // Elimina el empleado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // listar empleados
    public void listarEmpleados() {
        String sql = "SELECT * FROM empleados";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Empleado: " + rs.getString("idEmpleado"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Fecha Ingreso: " + rs.getString("fechaIngreso"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar servicio por ID
    public List<empleados> buscarEmpleadoxid(Integer idempleado) {
        List<empleados> lbuscarempleado = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT idEmpleado, nombre, telefono, correo, direccion, fechaIngreso FROM empleados WHERE idempleado = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idempleado);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                empleados emp = new empleados (
                        rs.getInt( "idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getString("fechaIngreso")
                );
                //agregar el empleado a la lista
                lbuscarempleado.add(emp);
            }
        } catch (SQLException eror) {
            eror.printStackTrace();
        }
        return lbuscarempleado;
    }
}
