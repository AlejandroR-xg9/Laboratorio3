public class Datos extends Personal {
    String especializacion;

    public Datos(int id, String nombre, String departamento, int experiencia, int salario, String especializacion) {
        super(id, nombre, departamento, experiencia, salario);
        this.especializacion = especializacion;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDepartamento() {
        return departamento;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public int getSalario() {
        return salario;
    }
    public String getEspecializacion() {
        return especializacion;
    }

    public void asignarCaracteristicas(String especializacion) {
        this.especializacion = especializacion;
    }
    public void salario(int Salario){
        this.salario = Salario;
    }
}
