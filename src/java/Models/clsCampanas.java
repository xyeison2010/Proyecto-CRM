/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class clsCampanas {
    public int inCodigo;

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public clsTipoCampana getObclsTipoCampana() {
        return obclsTipoCampana;
    }

    public void setObclsTipoCampana(clsTipoCampana obclsTipoCampana) {
        this.obclsTipoCampana = obclsTipoCampana;
    }

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
    }

    public clsEstadoCampana getObclsEstadoCampana() {
        return obclsEstadoCampana;
    }

    public void setObclsEstadoCampana(clsEstadoCampana obclsEstadoCampana) {
        this.obclsEstadoCampana = obclsEstadoCampana;
    }

    public String getStFechaInicio() {
        return stFechaInicio;
    }

    public void setStFechaInicio(String stFechaInicio) {
        this.stFechaInicio = stFechaInicio;
    }

    public String getStFechaFinalizacion() {
        return stFechaFinalizacion;
    }

    public void setStFechaFinalizacion(String stFechaFinalizacion) {
        this.stFechaFinalizacion = stFechaFinalizacion;
    }

    public double getDbIngresosEsperados() {
        return dbIngresosEsperados;
    }

    public void setDbIngresosEsperados(double dbIngresosEsperados) {
        this.dbIngresosEsperados = dbIngresosEsperados;
    }

    public double getDbCostePresupuestado() {
        return dbCostePresupuestado;
    }

    public void setDbCostePresupuestado(double dbCostePresupuestado) {
        this.dbCostePresupuestado = dbCostePresupuestado;
    }

    public double getDbCosteReal() {
        return dbCosteReal;
    }

    public void setDbCosteReal(double dbCosteReal) {
        this.dbCosteReal = dbCosteReal;
    }

    public String getStRespuestaEsperada() {
        return stRespuestaEsperada;
    }

    public void setStRespuestaEsperada(String stRespuestaEsperada) {
        this.stRespuestaEsperada = stRespuestaEsperada;
    }

    public int getInNumerosEnviados() {
        return inNumerosEnviados;
    }

    public void setInNumerosEnviados(int inNumerosEnviados) {
        this.inNumerosEnviados = inNumerosEnviados;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }
    public clsTipoCampana obclsTipoCampana;
    public String stNombre;
    public clsEstadoCampana obclsEstadoCampana;
    public String stFechaInicio;
    public String stFechaFinalizacion;
    public double dbIngresosEsperados;
    public double dbCostePresupuestado;
    public double dbCosteReal;
    public String stRespuestaEsperada;
    public int inNumerosEnviados;
    public String stDescripcion;
}
