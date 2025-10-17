public class Farmaceutica extends Datos {
            private String Licencia;
            private int PrescripcionesPorDia;

            public Farmaceutica(int id, String nombre, String departamento, int experiencia, int salario, String especializacion, String Licencia) {
                super(id, nombre, departamento, experiencia, salario, especializacion);
                this.Licencia = Licencia;
                
            }

            public String getLicencia() {
                return Licencia;
            }

            public int getPrescripcionesPorDia() {
                return PrescripcionesPorDia;
            }
            @Override
            public void asignarCaracteristicas(String especializacion) {

                super.asignarCaracteristicas(especializacion);
                
                if (this.Licencia != null) {
                switch(this.Licencia) {
                    case "Vigente":
                        this.PrescripcionesPorDia = 20;
                        break;
                    case "No vigente":
                        this.PrescripcionesPorDia = 0;
                        break;
                }
            }
        }
        @Override
        public void salario(int Salario){
            super.salario(Salario + PrescripcionesPorDia * 30);
        }
    }
