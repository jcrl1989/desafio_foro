package com.aluracursos.foro.foroAlura.domain.consulta.foro;

import jakarta.persistence.*;
import com.aluracursos.foro.foroAlura.domain.direccion.Direccion;
import lombok.EqualsAndHashCode;

@Table(name = "foros")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")
public class Foro {

    public static String getDireccion;
    public Long getID;
    public String getNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public TipoForo getTipoForo() {
        return tipoForo;
    }

    public void setTipoForo(TipoForo tipoForo) {
        this.tipoForo = tipoForo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private TipoForo tipoForo;

    @Embedded
    private Direccion direccion;

    public Foro(DatoRegiForo datoRegiForo) {
        this.activo = true;
        this.nombre = datoRegiForo.nombre();
        this.tipo = datoRegiForo.tipo();
        this.direccion =new Direccion(datoRegiForo.direccion(direccion));

    }

    public void actualizarDatos(DatoActualForo datoActualForo) {
        if (datoActualForo.nombre() != null){this.nombre =datoActualForo.nombre();}
        if (datoActualForo.tipo() != null){this.nombre =datoActualForo.tipo();}
        if (datoActualForo.direccion() != null){this.nombre = String.valueOf(datoActualForo.direccion());}

    }

    public void desactivarForo(){this.activo=false;}


    public Object tipo() {
        return null;
    }

    public Object GetTipo() {
        return null;
    }
}
