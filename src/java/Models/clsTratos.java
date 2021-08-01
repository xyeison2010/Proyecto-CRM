
package Models;

public class clsTratos {
    public int inCodigo;

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStImporte() {
        return stImporte;
    }

    public void setStImporte(String stImporte) {
        this.stImporte = stImporte;
    }

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
    }

    public String getStFechaCierre() {
        return stFechaCierre;
    }

    public void setStFechaCierre(String stFechaCierre) {
        this.stFechaCierre = stFechaCierre;
    }

    public String getStNumeroCuenta() {
        return stNumeroCuenta;
    }

    public void setStNumeroCuenta(String stNumeroCuenta) {
        this.stNumeroCuenta = stNumeroCuenta;
    }

    public clsFaseTrato getObclsFaseTrato() {
        return obclsFaseTrato;
    }

    public void setObclsFaseTrato(clsFaseTrato obclsFaseTrato) {
        this.obclsFaseTrato = obclsFaseTrato;
    }

    public clsTipoTrato getObclsTipoTrato() {
        return obclsTipoTrato;
    }

    public void setObclsTipoTrato(clsTipoTrato obclsTipoTrato) {
        this.obclsTipoTrato = obclsTipoTrato;
    }

    public double getDbProbabilidad() {
        return dbProbabilidad;
    }

    public void setDbProbabilidad(double dbProbabilidad) {
        this.dbProbabilidad = dbProbabilidad;
    }

    public String getStSiguientePaso() {
        return stSiguientePaso;
    }

    public void setStSiguientePaso(String stSiguientePaso) {
        this.stSiguientePaso = stSiguientePaso;
    }

    public double getDbIngresosEsperados() {
        return dbIngresosEsperados;
    }

    public void setDbIngresosEsperados(double dbIngresosEsperados) {
        this.dbIngresosEsperados = dbIngresosEsperados;
    }

    public clsFuentePosibleCliente getObclsFuentePosibleCliente() {
        return obclsFuentePosibleCliente;
    }

    public void setObclsFuentePosibleCliente(clsFuentePosibleCliente obclsFuentePosibleCliente) {
        this.obclsFuentePosibleCliente = obclsFuentePosibleCliente;
    }

    public String getStFuenteCampaña() {
        return stFuenteCampaña;
    }

    public void setStFuenteCampaña(String stFuente) {
        this.stFuenteCampaña = stFuente;
    }

    public String getStNombreContacto() {
        return stNombreContacto;
    }

    public void setStNombreContacto(String stNombreContacto) {
        this.stNombreContacto = stNombreContacto;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }
    public String stImporte;
    public String stNombre;
    public String stFechaCierre;
    public String stNumeroCuenta;
    public clsFaseTrato obclsFaseTrato;
    public clsTipoTrato obclsTipoTrato;
    public double dbProbabilidad;
    public String stSiguientePaso;
    public double dbIngresosEsperados;
    public clsFuentePosibleCliente obclsFuentePosibleCliente;
    public String stFuenteCampaña;
    public String stNombreContacto;
    public String stDescripcion;
}
