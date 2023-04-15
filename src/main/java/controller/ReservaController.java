package controller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController(){
        var factory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }

    public void guardar(Reserva reserva){
        //reserva.setHuespedId(huespedId);
        reservaDAO.guardar(reserva);
    }

}
