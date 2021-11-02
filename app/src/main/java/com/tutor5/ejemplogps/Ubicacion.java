package com.tutor5.ejemplogps;

public class Ubicacion {
    private String latitud;
    private String longitud;

    public Ubicacion(){

    }


    public Ubicacion(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }






    @Override
    public String toString() {
        return "ubicacion{" +
                "latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }

}
