package dao;

import factory.ConnectionFactory;
import modelo.Huesped;
import modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuespedDAO {
    final private Connection con;
    public HuespedDAO(Connection con) {
        this.con = con;
    }
    public void guardarHuesped(Huesped huesped){
        try(con) {
            var query = "INSERT INTO HUESPEDES"
                    + "(nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, reserva_id)"
                    + " VALUES(?,?,?,?,?,?)";

            final PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            try (statement){
                statement.setString(1,huesped.getNombre());
                statement.setString(2,huesped.getApellido());
                statement.setDate(3, huesped.getFecha_de_nacimiento());
                statement.setString(4, huesped.getNacionalidad());
                statement.setString(5, huesped.getTelefono());
                statement.setInt(6,huesped.getReservaId());
                System.out.println(huesped.getFecha_de_nacimiento());
                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet){
                    while (resultSet.next()) {
                        huesped.setId(resultSet.getInt(1));
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Huesped> listarHuesped() {
        List<Huesped> resultado = new ArrayList<>();
        final Connection con = new ConnectionFactory().recuperaConexion();
        try(con){
            final PreparedStatement statement = con.prepareStatement("SELECT ID, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, reserva_id FROM HUESPEDES");
            try(statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet){
                    while (resultSet.next()){
                        Huesped fila = new Huesped(resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("APELLIDO"),
                                resultSet.getDate("FECHA_DE_NACIMIENTO"),
                                resultSet.getString("NACIONALIDAD"),
                                resultSet.getString("telefono"),
                                resultSet.getInt("reserva_id"));
                        resultado.add(fila);
                    }
                }
            }
            return resultado;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int eliminarHuesped(Integer id){
        try(con) {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID = ?");
            try (statement){
                statement.setInt(1, id);
                statement.execute();
                System.out.println("Eliminando HUESPED " + id);
                return statement.getUpdateCount();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
