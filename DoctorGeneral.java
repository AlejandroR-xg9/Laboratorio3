public class DoctorGeneral extends Datos {
            private String Especialidad;
            private int Tarifa;
            private int PacientesporDia;

            public DoctorGeneral(int id, String nombre, String departamento,int experiencia,int salario,String especializacion,String Especialidad) {
                super(id, nombre, departamento, experiencia, salario, especializacion);
                this.Especialidad = Especialidad;
            }

            public String getEspecialidad() {
                return Especialidad;
            }

            public int getTarifa() {
                return Tarifa;
            }

            public int getPacientesporDia() {
                return PacientesporDia;
            }
            
            @Override
            public void asignarCaracteristicas(String especializacion) {

                super.asignarCaracteristicas(especializacion);
                
                if (this.Especialidad != null) {
                switch(this.Especialidad) {
                    case "Pediatría":
                        this.Tarifa = 40;
                        this.PacientesporDia = 15;
                        break;
                    case "Medicina interna":
                        this.Tarifa = 60;
                        this.PacientesporDia = 25;
                        break;
                    case "Medicina familiar":
                        this.Tarifa = 55;
                        this.PacientesporDia = 30;
                        break;
                    }
                }
            }
            @Override
            public void salario(int Salario){
                super.salario(Salario + PacientesporDia * Tarifa);
            }
        }
    
