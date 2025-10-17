public class Radiologia extends Datos {
    private String TipoDeEquipo;
    private int Tarifa;

    public Radiologia(int id, String nombre, String departamento, int experiencia, int salario, String especializacion, String TipoDeEquipo) {
        super(id, nombre, departamento, experiencia, salario, especializacion);
        this.TipoDeEquipo = TipoDeEquipo;
    }

            public String getTipoDeEquipo() {
                return TipoDeEquipo;
            }

            public int getTarifa() {
                return Tarifa;
            }
    public void asignarCaracteristicas(String especializacion) {

                super.asignarCaracteristicas(especializacion);
                
                if (this.TipoDeEquipo != null) {
                switch(this.TipoDeEquipo) {
                    case "Rayos X":
                        this.Tarifa = 40;
                        break;
                    case "Tomografía":
                        this.Tarifa = 60;
                        break;
                    case "Resonancia Magnética":
                        this.Tarifa = 55;
                        break;
                }
            }
        }
        @Override
        public void salario(int Salario){
            super.salario(Salario + Tarifa);
        }
}
