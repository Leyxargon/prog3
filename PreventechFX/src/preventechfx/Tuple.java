/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

/**
 *
 * @author Dario
 */
public class Tuple {
    private String nome;
    private double lat;
    private double lon;
    private String via;
    private String cap;
    private String citta;
    private String prov;
    private double apertura;
    private double chiusura;
    
    public Tuple(String nome, double lat, double lon, String via, String cap, String citta, String prov, double apertura, double chiusura) {
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.prov = prov;
        this.apertura = apertura;
        this.chiusura = chiusura;
    }

    public Tuple() {
    }

    public String getNome() {
        return nome;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getVia() {
        return via;
    }

    public String getCap() {
        return cap;
    }

    public String getCitta() {
        return citta;
    }

    public String getProv() {
        return prov;
    }

    public double getApertura() {
        return apertura;
    }

    public double getChiusura() {
        return chiusura;
    }
    
    
}
