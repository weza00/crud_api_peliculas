package com.teo.crud_api_peliculas.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Actor implements Serializable {
    private Integer id;
    
    @SerializedName("pelicula_id")
    private Integer peliculaId;
    
    @SerializedName("nombre_actor")
    private String nombreActor;
    
    private String rol;
    
    @SerializedName("creada_en")
    private String creadaEn;

    public Actor() {}

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPeliculaId() { return peliculaId; }
    public void setPeliculaId(Integer peliculaId) { this.peliculaId = peliculaId; }

    public String getNombreActor() { return nombreActor; }
    public void setNombreActor(String nombreActor) { this.nombreActor = nombreActor; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getCreadaEn() { return creadaEn; }
    public void setCreadaEn(String creadaEn) { this.creadaEn = creadaEn; }
}
