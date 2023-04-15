package modelo;

import java.time.LocalDate;

public class Reserva {
    private Integer id;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Double valor;
    private String forma_de_pago;
    private Integer huespedId;

    public Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, Double valor, String forma_de_pago){
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_de_pago = forma_de_pago;
    }

    public Reserva() {

    }

    public Integer getId() {
        return id;
    }
    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }
    public LocalDate getFecha_salida() {
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
