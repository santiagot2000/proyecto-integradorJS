package org.example.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ventasCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbintegrador";
    private final String user = "root";
    private final String password = "";

    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Metodos para el CRUD de ventas
    // Agregar venta
    public void agregarVenta(org.example.modelo.ventas venta) {
        String sql = "INSERT INTO ventas (idventa, fechaventa, montototal, estado, canaldeventa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venta.getIdventa());
            stmt.setDate(2, java.sql.Date.valueOf(venta.getFechaventa()));
            stmt.setInt(3, venta.getMontototal());
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
                System.out.println("Fecha Venta: " + rs.getDate("fechaventa"));
                System.out.println("Monto Total: " + rs.getInt("montototal"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Canal de Venta: " + rs.getString("canaldeventa"));
            } else {
                System.out.println("Venta no encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar venta
    public void actualizarVenta(org.example.modelo.ventas venta) {
        String sql = "UPDATE ventas SET fechaventa = ?, montototal = ?, estado = ?, canaldeventa = ? WHERE idventa = ?";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(venta.getFechaventa()));
            stmt.setInt(2, venta.getMontototal());
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

    // Consultar todas las ventas
    public void consultarTodasVentas() {
        String sql = "SELECT * FROM ventas";

        try (Connection conn = conectar(); var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Venta: " + rs.getInt("idventa"));
                System.out.println("Fecha Venta: " + rs.getDate("fechaventa"));
                System.out.println("Monto Total: " + rs.getInt("montototal"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Canal de Venta: " + rs.getString("canaldeventa"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
