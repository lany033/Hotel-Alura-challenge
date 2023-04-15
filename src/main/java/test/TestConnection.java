package test;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();
        System.out.println("Cerrando la conexion");
        con.close();
    }
}
