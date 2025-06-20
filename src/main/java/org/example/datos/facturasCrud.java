package org.example.datos;

import org.example.modelo.facturas;
import org.example.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class facturasCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/db_integrador?serverTimezone=UTC&useSSL=false";
    private final String user = "root";
    private final String password = "";

    // Metodo para conectar a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Metodos para el CRUD de facturas
    // Agregar pago
    public void agregarPago(facturas facturas) {
        String sql = "INSERT INTO facturas (nrofactura, nombreser, idusuario, fecha, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, facturas.getNrofactura());
            stmt.setString(2, facturas.getNombreser());
            stmt.setInt(3, facturas.getIdusuario());
            stmt.setDate(4, java.sql.Date.valueOf(facturas.getFecha()));
            stmt.setInt(5, facturas.getValor());
            stmt.executeUpdate();// Agregar pago
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //consultar pago
    public void consultarPago(int nrofactura) {
        String sql = "SELECT * FROM fcaturas WHERE nrofactura = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nrofactura);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Pago encontrado:");
                System.out.println("Nro Factura: " + rs.getInt("nrofactura"));
                System.out.println("Nombre Servicio: " + rs.getString("nombreser"));
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Valor: " + rs.getInt("valor"));
            } else {
                System.out.println("Pago no encontrado, numero de ID INEXISTENTE. intentelo con otra ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Actualizar pago
    public void actualizarPago(facturas facturas) {
        String sql = "UPDATE pago SET nombreser = ?, idusuario = ?, fecha = ?, valor = ? WHERE nrofactura = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, facturas.getNombreser());
            stmt.setInt(2, facturas.getIdusuario());
            stmt.setDate(3, java.sql.Date.valueOf(facturas.getFecha()));
            stmt.setInt(4, facturas.getValor());
            stmt.setInt(5, facturas.getNrofactura());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pago actualizado exitosamente.");
            } else {
                System.out.println("Pago no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar pago
    public void eliminarPago(int nrofactura) {
        String sql = "DELETE FROM facturas WHERE nrofactura = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nrofactura);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pago eliminado exitosamente.");
            } else {
                System.out.println("Pago no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // listar pagos
    public void listarPagos() {
        String sql = "SELECT * FROM facturas";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Nro Factura: " + rs.getInt("nrofactura"));
                System.out.println("Nombre Servicio: " + rs.getString("nombreser"));
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Valor: " + rs.getInt("valor"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar pago por ID
    public List<facturas> buscarFacturasxid(Integer nrofactura) {
        List<facturas> lbuscarfacturas = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT nrofactura, nombreser, idusuario, fecha, valor FROM facturas WHERE nrofactura = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, nrofactura);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Nro Factura: " + rs.getInt("nrofactura"));
                System.out.println("Nombre Servicio: " + rs.getString("nombreser"));
                System.out.println("ID Usuario: " + rs.getString("idusuario"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Valor: " + rs.getInt("valor"));
            } else {
                System.out.println("Pago no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lbuscarfacturas;
    }
}
