package org.example.datos;

import org.example.modelo.servicio;
import org.example.modelo.usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuariosCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/db_integrador?serverTimezone=UTC&useSSL=false";
    private final String user = "root";
    private final String password = "";

    // Metodo para conectar a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // Metodos para el CRUD de usuarios
    // Agregar usuario
    public void agregarUsuario(org.example.modelo.usuarios usuario) {
        String sql = "INSERT INTO usuarios (idusuario, nombre, telefono, direccion, correo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getIdusuario());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getCorreo());
            stmt.executeUpdate(); // Agrega el usuario
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar usuario
    public void consultarUsuario(String idusuario) {
        String sql = "SELECT * FROM usuarios WHERE idusuario = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idusuario);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Correo: " + rs.getString("correo"));
            } else {
                System.out.println("Usuario no encontrado, numero de ID INEXISTENTE. intentelo con otra ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar usuario
    public void actualizarUsuario(org.example.modelo.usuarios usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, telefono = ?, direccion = ?, correo = ? WHERE idusuario = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getTelefono());
            stmt.setString(3, usuario.getDireccion());
            stmt.setString(4, usuario.getCorreo());
            stmt.setInt(5, usuario.getIdusuario());
            stmt.executeUpdate(); // Actualiza el usuario
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar usuario
    public void eliminarUsuario(String idusuario) {
        String sql = "DELETE FROM usuarios WHERE idusuario = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idusuario);
            stmt.executeUpdate(); // Elimina el usuario
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar usuarios
    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar usuarios por id
    public List<usuarios> buscarUsuariosxid(Integer idusuario) {
        List<usuarios> lbuscarusuarios = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT idservicio, nombreser, observaciones, precio, duracion FROM servicio WHERE idservicio = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idusuario);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Correo: " + rs.getString("correo"));
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lbuscarusuarios;
    }
}
