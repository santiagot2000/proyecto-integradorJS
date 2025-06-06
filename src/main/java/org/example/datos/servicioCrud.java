package org.example.datos;

import org.example.modelo.servicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class servicioCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbintegrador";
    private final String user = "root";
    private final String password = "";

    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // Metodos para el CRUD de servicio
    // Agregar servicio
    public void agregarServicio(org.example.modelo.servicio servicio) {
        String sql = "INSERT INTO servicio (nombreser, observaciones, precio, duracion) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombreser());
            stmt.setString(2, servicio.getObservaciones());
            stmt.setInt(3, servicio.getPrecio());
            stmt.setString(4, servicio.getDuracion());
            stmt.executeUpdate(); // Agrega el servicio
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar servicio
    public void consultarServicio(Integer idservicio) {
        String sql = "SELECT * FROM servicio WHERE idservicio = ?";
        try (Connection conn = conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idservicio);
            java.sql.ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Servicio encontrado:");
                System.out.println("ID Servicio: " + rs.getInt("idservicio"));
                System.out.println("Nombre Servicio: " + rs.getString("nombreser"));
                System.out.println("Observaciones: " + rs.getString("observaciones"));
                System.out.println("Precio: " + rs.getInt("precio"));
                System.out.println("Duración: " + rs.getString("duracion"));
            } else {
                System.out.println("Servicio no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar servicio
    public void actualizarServicio(org.example.modelo.servicio servicio) {
        String sql = "UPDATE servicio SET nombreser = ?, observaciones = ?, precio = ?, duracion = ? WHERE idservicio = ?";
        try (Connection conn = conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombreser());
            stmt.setString(2, servicio.getObservaciones());
            stmt.setInt(3, servicio.getPrecio());
            stmt.setString(4, servicio.getDuracion());
            stmt.setInt(5, servicio.getIdservicio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar servicio
    public void eliminarServicio(Integer idservicio) {
        String sql = "DELETE FROM servicio WHERE idservicio = ?";
        try (Connection conn = conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idservicio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar servicios
    public List<servicio> listarVehiculos() {
        List<servicio> buscarServicio = new ArrayList<servicio>();
        String query = "SELECT * FROM servicio";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Servicio: " + rs.getInt("idservicio"));
                System.out.println("Nombre Servicio: " + rs.getString("nombreser"));
                System.out.println("Observaciones: " + rs.getString("observaciones"));
                System.out.println("Precio: " + rs.getInt("precio"));
                System.out.println("Duración: " + rs.getString("duracion"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buscarServicio;
    }

    // Buscar servicio por ID
    public List<servicio> buscarServicioxid(Integer idservicio) {
        List<servicio> lbuscarservicio = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT idservicio, nombreser, observaciones, precio, duracion FROM servicio WHERE idservicio = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idservicio);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                servicio sv = new servicio(
                        rs.getInt("idservicio"),
                        rs.getString("nombreser"),
                        rs.getString("observaciones"),
                        rs.getInt("precio"),
                        rs.getString("duracion")
                );
                //agregar el vehiculo a la lista
                lbuscarservicio.add(sv);
            }
        } catch (SQLException eror) {
            eror.printStackTrace();
        }
        return lbuscarservicio;
    }
}
