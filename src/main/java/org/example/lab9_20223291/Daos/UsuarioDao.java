package org.example.lab9_20223291.Daos;

import org.example.lab9_20223291.Beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DaoBase {


    public Usuario validarUsuario(String email, String password) {

        Usuario usuario = null;

        String sql = "SELECT * FROM usuario " +
                "WHERE email = ? AND password_hash = SHA2(?, 256) AND estado = 'ACTIVO'";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password); // Se envía el password en texto plano

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


}