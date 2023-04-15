package modelo;

import java.time.LocalDate;

public class Huesped {
    private Integer id;
    private final String nombre;
    private String apellido;
    private LocalDate fecha_de_nacimiento;
    private String nacionalidad;
    private String telefono;
    private Integer reservaId;

    public Integer getReservaId() {
        return reservaId;
    }

    public Huesped(String nombre, String apellido, LocalDate fecha_de_nacimiento, String nacionalidad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }
}
