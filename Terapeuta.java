public class Terapeuta extends Datos {
    private String Tipo;
    private int DuracionSesiones;

    public Terapeuta(int id, String nombre, String departamento, int experiencia, int salario, String especializacion, String Tipo) {
        super(id, nombre, departamento, experiencia, salario, especializacion);
        this.Tipo = Tipo;
    }
    @Override
    public void asignarCaracteristicas(String especializacion) {

        super.asignarCaracteristicas(especializacion);

        if (this.Tipo != null) {
            switch(this.Tipo) {
                case "Física":
                    this.DuracionSesiones = 30;
                    break;
                case "Ocupacional":
                    this.DuracionSesiones = 45;
                    break;
            }
        }
    }



    public String getTipo() {
        return Tipo;
    }



    public void setTipo(String tipo) {
        Tipo = tipo;
    }



    public int getDuracionSesiones() {
        return DuracionSesiones;
    }



    public void setDuracionSesiones(int duracionSesiones) {
        DuracionSesiones = duracionSesiones;
    }
}
