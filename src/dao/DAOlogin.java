package dao;

import Interfaces.InterfaceLogin;
import conexion.Conexion;
import modelo.Login;
import otros.PropertiesBBDD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOlogin implements InterfaceLogin.InterfaceLoginDao {

    private static Connection conexion;
    private PropertiesBBDD propiedadesBBDD;

    String user;

    public DAOlogin() {
        try {
            conexion = Conexion.getConexion();
            propiedadesBBDD = new PropertiesBBDD();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertarNuevoUsuario(Login administrador) {

        String sql = "Insert into " + propiedadesBBDD.getTblLogin() + " values (?, ?, ?)";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, administrador.getUsuario());
            pStatement.setString(2, administrador.getContrasenia());
            pStatement.setInt(3, administrador.getPerUsuario());

            filasAfectadas = pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filasAfectadas != 0;
    }

    @Override
    public boolean borrarUsuario(Login administrador) {

        String sql = "Delete from "  + propiedadesBBDD.getTblLogin() + " where usuario=?;";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, administrador.getUsuario());
            filasAfectadas = pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filasAfectadas != 0;
    }

    @Override
    public String obtenerContraseniaPorUsuario(String usuario) {
        String sql = "Select CONTRASENIA from "  + propiedadesBBDD.getTblLogin() + " where usuario=?";
        String contraseniaObtenida = null;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, usuario);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                contraseniaObtenida = rSet.getString("contrasenia");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return contraseniaObtenida;

    }

    public int obtenerTipoUsuario(Login login) {
        String sql = "Select TIPOUSUARIO from "  + propiedadesBBDD.getTblLogin() + " where usuario=?";
        int tipo = -1;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, login.getUsuario());
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                tipo = Integer.parseInt(rSet.getString("tipousuario"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tipo;

    }

        public boolean borrarUsuario(String user) {

        String sql = "Delete from "  + propiedadesBBDD.getTblLogin() + " where usuario=?";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, user);
            filasAfectadas = pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filasAfectadas != 0;
    }
    @Override
    public boolean cambiarContrasenia(String user, String nuevaContrasenia) {

        String sql = "Update "  + propiedadesBBDD.getTblLogin() +  " set contrasenia=? where usuario=?";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, nuevaContrasenia);
            pStatement.setString(2, user);

            filasAfectadas = pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filasAfectadas != 0;

    }

    public boolean actualizarTipoUsuario(String user, int tipoUser) {

        String sql = "Update "  + propiedadesBBDD.getTblLogin() +  " set tipousuario=? where usuario=?";
        int filasAfectadas = 0;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setInt(1, tipoUser);
            pStatement.setString(2, user);

            filasAfectadas = pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filasAfectadas != 0;

    }
    @Override
    public Login comprobarExistenciaUsuario(String usuario) {
        user=usuario;
        String sql = "Select * from " + propiedadesBBDD.getTblLogin() + " where usuario=?";
        Login adminPrueba = null;
        try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
            pStatement.setString(1, usuario);
            ResultSet rset = pStatement.executeQuery();

            while (rset.next()) {
                adminPrueba = new Login(rset.getString("usuario"), rset.getString("contrasenia"),
                        rset.getInt("tipousuario"));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (adminPrueba != null) {
            return adminPrueba;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        DAOlogin das = new DAOlogin();
        Login log=new Login("admin","admin",1);
        System.out.println(das.obtenerTipoUsuario(log));
    }

}
