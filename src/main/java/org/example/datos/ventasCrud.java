package org.example.datos;

import org.example.modelo.ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ventasCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/db_integrador?serverTimezone=UTC&useSSL=false";
    private final String user = "root";
    private final String password = "";

    // Metodo para conectar a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Metodos para el CRUD de ventas
    // Agregar venta
    public void agregarVenta(org.example.modelo.ventas venta) {
        String sql = "INSERT INTO ventas (idventa, fecha, valor, estado, canaldeventa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venta.getIdventa());
            stmt.setDate(2, java.sql.Date.valueOf(venta.getFecha()));
            stmt.setInt(3, venta.getValor());
            stmt.setString(4, venta.getEstado());
            stmt.setString(5, venta.getCanaldeventa());
            stmt.executeUpdate(); // Agrega la venta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar venta
    public void consultarVenta(Integer idventa) {
        String sql = "SELECT * FROM ventas WHERE idventa = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idventa);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Venta encontrada:");
                System.out.println("ID Venta: " + rs.getInt("idventa"));
                System.out.println("Fecha Venta: " + rs.getDate("fecha"));
                System.out.println("valor: " + rs.getInt("valor"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Canal de Venta: " + rs.getString("canaldeventa"));
            } else {
                System.out.println("Venta no encontrada, numero de ID INEXISTENTE. intentelo con otra ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar venta
    public void actualizarVenta(org.example.modelo.ventas venta) {
        String sql = "UPDATE ventas SET fecha = ?, valor = ?, estado = ?, canaldeventa = ? WHERE idventa = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(venta.getFecha()));
            stmt.setInt(2, venta.getValor());
            stmt.setString(3, venta.getEstado());
            stmt.setString(4, venta.getCanaldeventa());
            stmt.setInt(5, venta.getIdventa());
            stmt.executeUpdate(); // Actualiza la venta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar venta
    public void eliminarVenta(Integer idventa) {
        String sql = "DELETE FROM ventas WHERE idventa = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idventa);
            stmt.executeUpdate(); // Elimina la venta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas las ventas
    public void listarVentas() {
        String sql = "SELECT * FROM ventas";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Venta: " + rs.getInt("idventa"));
                System.out.println("Fecha Venta: " + rs.getDate("fecha"));
                System.out.println("valor: " + rs.getInt("valor"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Canal de Venta: " + rs.getString("canaldeventa"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar ventas por id
    public List<ventas> buscarVentasxid(int idventa) {
        List<ventas> lbuscarventas = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT fecha, valor, estado, canaldeventa FROM ventas WHERE idventa = ?";


        try (Connection conn = conectar(); var stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idventa);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID Venta: " + rs.getInt("idventa"));
                System.out.println("Fecha Venta: " + rs.getDate("fecha"));
                System.out.println("valor: " + rs.getInt("valor"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Canal de Venta: " + rs.getString("canaldeventa"));
            } else {
                System.out.println("Venta no encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lbuscarventas;
    }
}
