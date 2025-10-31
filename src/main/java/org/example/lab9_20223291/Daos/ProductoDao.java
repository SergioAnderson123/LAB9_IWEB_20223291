package org.example.lab9_20223291.Daos;

import org.example.lab9_20223291.Dto.CreacionyListadoDeProductosDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDao extends DaoBase {

    public ArrayList<CreacionyListadoDeProductosDto> listarProductos() {

        ArrayList<CreacionyListadoDeProductosDto> lista = new ArrayList<>();

    /* Cálculo del stock real restando lo que está
     en los carritos de todos los usuarios
    */
        String sql = "SELECT p.id_producto, p.nombre, c.nombre AS categoria_nombre, p.precio, " +
                "(p.stock - COALESCE(SUM(ci.cantidad), 0)) AS stock_calculado " +
                "FROM producto p " +
                "INNER JOIN categoria c ON (p.id_categoria = c.id_categoria) " +
                "LEFT JOIN carrito_item ci ON (p.id_producto = ci.id_producto) " +
                "GROUP BY p.id_producto, p.nombre, c.nombre, p.precio, p.stock " +
                "ORDER BY p.id_producto";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CreacionyListadoDeProductosDto dto = new CreacionyListadoDeProductosDto();
                // Llenar el DTO con los datos del ResultSet
                dto.setId(rs.getInt(1));
                dto.setNombre(rs.getString(2));
                dto.setCategoriaNombre(rs.getString(3));
                dto.setPrecio(rs.getBigDecimal(4));
                dto.setStockCalculado(rs.getInt(5));
                lista.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void crearProducto(int idCategoria, String nombre, String descripcion, java.math.BigDecimal precio, int stock) {

        String sql = "INSERT INTO producto (id_categoria, nombre, descripcion, precio, stock) VALUES (?,?,?,?,?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCategoria);
            pstmt.setString(2, nombre);
            pstmt.setString(3, descripcion);
            pstmt.setBigDecimal(4, precio);
            pstmt.setInt(5, stock);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
