package dao;

import modelo.Reserva;

import java.sql.*;
import java.time.ZoneId;

public class ReservaDAO {
    final private Connection con;
    public ReservaDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Reserva reserva){
        try(con) {
            var query = "INSERT INTO RESERVAS"
                    + "(fecha_entrada, fecha_salidad, valor, forma_pago)"
                    + " VALUES ( ?, ?, ?, ?)";

            final PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            try (statement){
                statement.setDate(1,Date.valueOf(reserva.getFecha_entrada()));
                statement.setDate(2,Date.valueOf(reserva.getFecha_salida()));
                statement.setDouble(3,reserva.getValor());
                statement.setString(4,reserva.getForma_de_pago());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet){
                    while (resultSet.next()) {
                        reserva.setId(resultSet.getInt(1));

                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
