/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class clsTareas {
    public int inCodigo;

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStTitular() {
        return stTitular;
    }

    public void setStTitular(String stTitular) {
        this.stTitular = stTitular;
    }

    public String getStAsunto() {
        return stAsunto;
    }

    public void setStAsunto(String stAsunto) {
        this.stAsunto = stAsunto;
    }

    public String getStFechaVencimiento() {
        return stFechaVencimiento;
    }

    public void setStFechaVencimiento(String stFechaVencimiento) {
        this.stFechaVencimiento = stFechaVencimiento;
    }

    public String getStContacto() {
        return stContacto;
    }

    public void setStContacto(String stContacto) {
        this.stContacto = stContacto;
    }

    public String getStCuenta() {
        return stCuenta;
    }

    public void setStCuenta(String stCuenta) {
        this.stCuenta = stCuenta;
    }

    public clsEstadoTarea getObclsEstadoTarea() {
        return obclsEstadoTarea;
    }

    public void setObclsEstadoTarea(clsEstadoTarea obclsEstadoTarea) {
        this.obclsEstadoTarea = obclsEstadoTarea;
    }

    public clsPrioridad getObclsPrioridad() {
        return obclsPrioridad;
    }

    public void setObclsPrioridad(clsPrioridad obclsPrioridad) {
        this.obclsPrioridad = obclsPrioridad;
    }

    public char getChEnviarMensaje() {
        return chEnviarMensaje;
    }

    public void setChEnviarMensaje(char chEnviarMensaje) {
        this.chEnviarMensaje = chEnviarMensaje;
    }

    public char getChRepetir() {
        return chRepetir;
    }

    public void setChRepetir(char chRepetir) {
        this.chRepetir = chRepetir;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }
    public String stTitular;
    public String stAsunto;
    public String stFechaVencimiento;
    public String stContacto;
    public String stCuenta;
    public clsEstadoTarea obclsEstadoTarea;
    public clsPrioridad obclsPrioridad;
    public char chEnviarMensaje;
    public char chRepetir;
    public String stDescripcion;
}
