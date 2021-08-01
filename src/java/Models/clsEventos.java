/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class clsEventos {

    public clsEventos() {
        setStNombre("");
    }

    public int inCodigo;

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
    }

    public String getStUbicacion() {
        return stUbicacion;
    }

    public void setStUbicacion(String stUbicacion) {
        this.stUbicacion = stUbicacion;
    }

    public String getStParticipantes() {
        return stParticipantes;
    }

    public void setStParticipantes(String stParticipantes) {
        this.stParticipantes = stParticipantes;
    }

    public char getChTodoDia() {
        return chTodoDia;
    }

    public void setChTodoDia(char chTodoDia) {
        this.chTodoDia = chTodoDia;
    }

    public String getStFecha() {
        return stFecha;
    }

    public void setStFecha(String stFecha) {
        this.stFecha = stFecha;
    }

    public clsRelacionadoCon getObclsRelacionadoCon() {
        return obclsRelacionadoCon;
    }

    public void setObclsRelacionadoCon(clsRelacionadoCon obclsRelacionadoCon) {
        this.obclsRelacionadoCon = obclsRelacionadoCon;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }
    public String stNombre;
    public String stUbicacion;
    public String stParticipantes;
    public char chTodoDia;
    public String stFecha;
    public clsRelacionadoCon obclsRelacionadoCon;
    public String stDescripcion;
}
