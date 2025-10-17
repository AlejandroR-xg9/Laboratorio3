public class Enfermeria extends Datos{
            private String Turno;
            private String Certificacion;
    

            public Enfermeria(int id, String nombre, String departamento, int experiencia, int salario, String especializacion, String Certificacion) {
                super(id, nombre, departamento, experiencia, salario, especializacion);
                this.Certificacion = Certificacion;
            }

            public String getTurno() {
                return Turno;
            }

            public String getCertificacion() {
                return Certificacion;
            }
            @Override
            public void asignarCaracteristicas(String especializacion) {

                super.asignarCaracteristicas(especializacion);
                
                if (this.Certificacion != null) {
                switch(this.Certificacion) {
                    case "Pediatría":
                        this.Turno = "Diurno";
                        break;
                    case "Medicina interna":
                        this.Turno = "Vespertino";
                        break;
                    case "Medicina familiar":
                        this.Turno = "Nocturno";
                        break;
                }
            }
        }
        @Override
        public void salario(int Salario){
            if (Turno.equals("Nocturno")) {
                super.salario(Salario + 5000);
            }
            else {
                super.salario(Salario);
            }
        }
    }
