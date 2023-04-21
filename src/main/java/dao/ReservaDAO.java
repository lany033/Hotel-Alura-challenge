package dao;

import factory.ConnectionFactory;
import modelo.Reserva;
import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
                statement.setDate(1,reserva.getFecha_entrada());
                statement.setDate(2,reserva.getFecha_salida());
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

    public List<Reserva> listar(){
        List<Reserva> resultado = new ArrayList<>();
        final Connection con = new ConnectionFactory().recuperaConexion();
        try(con){
            final PreparedStatement statement = con.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDAD, VALOR, FORMA_PAGO FROM RESERVAS");
            try(statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet){
                    while (resultSet.next()){
                        Reserva fila = new Reserva(resultSet.getInt("ID"),
                                resultSet.getDate("FECHA_ENTRADA"),
                                resultSet.getDate("FECHA_SALIDAD"),
                                resultSet.getDouble("VALOR"),
                                resultSet.getString("FORMA_PAGO"));
                        resultado.add(fila);
                    }
                }
            }
            return resultado;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
