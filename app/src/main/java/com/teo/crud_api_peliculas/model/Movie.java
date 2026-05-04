package com.teo.crud_api_peliculas.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private Integer id;
    private String titulo;
    private String director;
    private Integer anio;
    private String genero;
    
    @SerializedName("duracion_minutos")
    private Integer duracionMinutos;
    
    private Double calificacion;
    
    @SerializedName("creada_en")
    private String creadaEn;
    
    @SerializedName("actualizada_en")
    private String actualizadaEn;
    
    private List<Actor> actores;

    public Movie() {}

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }

    public Double getCalificacion() { return calificacion; }
    public void setCalificacion(Double calificacion) { this.calificacion = calificacion; }

    public String getCreadaEn() { return creadaEn; }
    public void setCreadaEn(String creadaEn) { this.creadaEn = creadaEn; }

    public String getActualizadaEn() { return actualizadaEn; }
    public void setActualizadaEn(String actualizadaEn) { this.actualizadaEn = actualizadaEn; }

    public List<Actor> getActores() { return actores; }
    public void setActores(List<Actor> actores) { this.actores = actores; }
}
