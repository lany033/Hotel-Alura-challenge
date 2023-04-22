package controller;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import modelo.Huesped;

import java.util.List;

public class HuespedController {
    private HuespedDAO huespedDAO;

    public HuespedController() {
        var factory = new ConnectionFactory();
        this.huespedDAO = new HuespedDAO(factory.recuperaConexion());
    }

    public void guardarHuesped(Huesped huesped, Integer reservaId){
        huesped.setReservaId(reservaId);
        System.out.println("Se setea el id: " + reservaId);
        huespedDAO.guardarHuesped(huesped);
    }

    public List<Huesped> listarHuesped(){
        return huespedDAO.listarHuesped();
    }

    public int eliminarHuesped(Integer id){
        return huespedDAO.eliminarHuesped(id);
    }
}
