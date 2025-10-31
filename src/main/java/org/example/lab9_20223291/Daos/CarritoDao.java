package org.example.lab9_20223291.Daos;

import org.example.lab9_20223291.Dto.AnadidoAlCarrritoyListadoDeProductosDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarritoDao extends DaoBase {

    public ArrayList<AnadidoAlCarrritoyListadoDeProductosDto> listarCarrito(int idUsuario) {

        ArrayList<AnadidoAlCarrritoyListadoDeProductosDto> lista = new ArrayList<>();

        // Consulta para el DTO del carrito
        String sql = "SELECT ci.id_item, ci.id_producto, p.nombre AS nombre_producto, " +
                "CONCAT(u.nombres, ' ', u.apellidos) AS nombre_usuario, " +
                "p.precio AS precio_unit, ci.cantidad, " +
                "(p.precio * ci.cantidad) AS subtotal " +
                "FROM carrito_item ci " +
                "INNER JOIN producto p ON (ci.id_producto = p.id_producto) " +
                "INNER JOIN usuario u ON (ci.id_usuario = u.id_usuario) " +
                "WHERE ci.id_usuario = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    AnadidoAlCarrritoyListadoDeProductosDto dto = new AnadidoAlCarrritoyListadoDeProductosDto();
                    dto.setIdItem(rs.getInt("id_item"));
                    dto.setIdProducto(rs.getInt("id_producto"));
                    dto.setNombreProducto(rs.getString("nombre_producto"));
                    dto.setNombreUsuario(rs.getString("nombre_usuario"));
                    dto.setPrecioUnit(rs.getBigDecimal("precio_unit"));
                    dto.setCantidad(rs.getInt("cantidad"));
                    dto.setSubtotal(rs.getBigDecimal("subtotal"));
                    lista.add(dto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Metodo para añadir al carrito:
    public void anadirAlCarrito(int idUsuario, int idProducto) {


        String sql = "INSERT INTO carrito_item (id_usuario, id_producto, cantidad) " +
                "VALUES (?, ?, 1) " + // Cantidad 1 por defecto
                "ON DUPLICATE KEY UPDATE cantidad = cantidad + 1";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idProducto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
