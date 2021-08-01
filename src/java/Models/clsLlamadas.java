package Models;

public class clsLlamadas {    

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStContacto() {
        return stContacto;
    }

    public void setStContacto(String stContacto) {
        this.stContacto = stContacto;
    }

    public String getStAsunto() {
        return stAsunto;
    }

    public void setStAsunto(String stAsunto) {
        this.stAsunto = stAsunto;
    }

    public clsRelacionadoCon getObclsRelacionadoCon() {
        return obclsRelacionadoCon;
    }

    public void setObclsRelacionadoCon(clsRelacionadoCon obclsRelacionadoCon) {
        this.obclsRelacionadoCon = obclsRelacionadoCon;
    }

    public clsTipoLlamada getObclsTipoLlamada() {
        return obclsTipoLlamada;
    }

    public void setObclsTipoLlamada(clsTipoLlamada obclsTipoLlamada) {
        this.obclsTipoLlamada = obclsTipoLlamada;
    }

    public String getStDetalles() {
        return stDetalles;
    }

    public void setStDetalles(String stDetalles) {
        this.stDetalles = stDetalles;
    }

    public String getStFecha() {
        return stFecha;
    }

    public void setStFecha(String stFecha) {
        this.stFecha = stFecha;
    }

    public int getInDuracion() {
        return inDuracion;
    }

    public void setInDuracion(int inDuracion) {
        this.inDuracion = inDuracion;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }

    public String getStResultado() {
        return stResultado;
    }

    public void setStResultado(String stResultado) {
        this.stResultado = stResultado;
    }

    public clsPropositoDeLaLlamada getObclsPropositoDeLaLlamada() {
        return obclsPropositoDeLaLlamada;
    }

    public void setObclsPropositoDeLaLlamada(clsPropositoDeLaLlamada obclsPropositoDeLaLlamada) {
        this.obclsPropositoDeLaLlamada = obclsPropositoDeLaLlamada;
    }
    
    public clsPropositoDeLaLlamada obclsPropositoDeLaLlamada;
    public clsRelacionadoCon obclsRelacionadoCon;
    public clsTipoLlamada obclsTipoLlamada;

    public int inCodigo;
    public String stContacto;
    public String stAsunto;
    public String stDetalles;
    public String stFecha;
    public int inDuracion;
    public String stDescripcion;
    public String stResultado;
}
