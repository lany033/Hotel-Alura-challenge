package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
    private Integer id;
    private Date fecha_entrada;

    private Date fecha_salida;


    private Double valor;
    private String forma_de_pago;
    private Integer huespedId;

    public Reserva(Date fecha_entrada, Date fecha_salida, Double valor, String forma_de_pago){
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_de_pago = forma_de_pago;
    }

    public Reserva() {

    }

    public Reserva(int id, Date fecha_entrada, Date fecha_salida, double valor, String forma_de_pago) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_de_pago = forma_de_pago;
    }

    public Integer getId() {
        return id;
    }
    public Date getFecha_entrada() {
        return fecha_entrada;
    }
    public Date getFecha_salida() {
        return fecha_salida;
    }
    public Double getValor() {
        return valor;
    }
    public String getForma_de_pago() {
        return forma_de_pago;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(Integer huespedId) {
        this.huespedId = huespedId;
    }
}
