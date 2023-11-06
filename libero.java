
class Líbero extends JugadorMasValioso {
    private int errores;
    private int aces;
    private int totalServicios;
    private int recibosEfectivos;

    public Líbero(String nombre, String país, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, país);
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
        this.recibosEfectivos = recibosEfectivos;
        calcularEfectividad();
    }

    public void calcularEfectividad() {
        double efectividad = ((recibosEfectivos - errores) * 100.0 / (recibosEfectivos + errores)) + (aces * 100.0 / totalServicios);
        setEfectividad(efectividad);
    }

    private void setEfectividad(double efectividad) {
    }

    public String toString() {
        return "Líbero - " + super.toString() + ", Errores: " + errores + ", Aces: " + aces
                + ", Total Servicios: " + totalServicios + ", Recibos Efectivos: " + recibosEfectivos;
    }

    public String getNombre() {
        return null;
    }

    public String getPaís() {
        return null;
    }

    public String getErrores() {
        return null;
    }

    public String getAces() {
        return null;
    }

    public String getTotalServicios() {
        return null;
    }

    public String getRecibosEfectivos() {
        return null;
    }
}

class Pasador extends JugadorMasValioso {
    private int errores;
    private int aces;
    private int totalServicios;
    private int pases;
    private int fintas;

    public Pasador(String nombre, String país, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, país);
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
        this.pases = pases;
        this.fintas = fintas;
        calcularEfectividad();
    }

    public Pasador(String string, String string2, int i, int j, int k, int l) {
    }

    public void calcularEfectividad() {
        double efectividad = ((pases + fintas - errores) * 100.0 / (pases + fintas + errores)) + (aces * 100.0 / totalServicios);
        setEfectividad(efectividad);
    }

    private void setEfectividad(double efectividad) {
    }

    public String toString() {
        return "Pasador - " + super.toString() + ", Errores: " + errores + ", Aces: " + aces
                + ", Total Servicios: " + totalServicios + ", Pases: " + pases + ", Fintas: " + fintas;
    }
}

class AuxiliarOpuesto extends JugadorMasValioso {
    private int errores;
    private int aces;
    private int totalServicios;
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public AuxiliarOpuesto(String nombre, String país, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, país);
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
        calcularEfectividad();
    }

    public void calcularEfectividad() {
        double efectividad = ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0 / (ataques + bloqueosEfectivos + bloqueosFallidos + errores)) + (aces * 100.0 / totalServicios);
        setEfectividad(efectividad);
    }

    private void setEfectividad(double efectividad) {
    }

    public String toString() {
        return "AuxiliarOpuesto - " + super.toString() + ", Errores: " + errores + ", Aces: " + aces
                + ", Total Servicios: " + totalServicios + ", Ataques: " + ataques + ", Bloqueos Efectivos: " + bloqueosEfectivos
                + ", Bloqueos Fallidos: " + bloqueosFallidos;
    }
}



