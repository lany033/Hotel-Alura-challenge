package controller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.util.List;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController(){
        var factory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }

    public List<Reserva> listar(){
        return reservaDAO.listar();
    }

    public void guardar(Reserva reserva){
        reservaDAO.guardar(reserva);
    }

    public int eliminar(Integer id){
        return reservaDAO.eliminar(id);
    }

}
