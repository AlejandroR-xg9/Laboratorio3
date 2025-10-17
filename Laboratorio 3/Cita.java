public class Cita {
    private int id;
    private String nombre;
    private String medicoAsignado;
    private String fecha;
    private String hora;
    private String tipo;
    private String estado;
    private String[] citas;

    public Cita(int id, String nombre, String medicoAsignado, String fecha, String hora, String tipo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.medicoAsignado = medicoAsignado;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void setCitas(String[] citas) {
        this.citas = citas;
    }

    public String[] getCitas() {
        return citas;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMedicoAsignado() {
        return medicoAsignado;
    }
    public void setMedicoAsignado(String medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
