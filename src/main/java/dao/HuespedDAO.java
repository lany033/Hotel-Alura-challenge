package dao;

import modelo.Huesped;
import java.sql.*;

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
                statement.setDate(3, Date.valueOf(huesped.getFecha_de_nacimiento()));
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
}
