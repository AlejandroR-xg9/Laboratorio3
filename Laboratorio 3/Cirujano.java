public class Cirujano extends Datos {
            private String Tipo;
            private String HorasDisponibles;
            private int BonoPorRiesgo;
            private int Tarifa;
            private int HorasRealizadas;

            public Cirujano(int id, String nombre, String departamento, int experiencia, int salario, String especializacion,String Tipo) {
                super(id, nombre, departamento, experiencia, salario, especializacion);
                this.Tipo = Tipo;
            }

            public String getTipo() {
                return Tipo;
            }

            public String getHorasDisponibles() {
                return HorasDisponibles;
            }

            public int getBonoPorRiesgo() {
                return BonoPorRiesgo;
            }
            @Override
            public void asignarCaracteristicas(String especializacion) {

                super.asignarCaracteristicas(especializacion);
                
                if (this.Tipo != null) {
                    switch(this.Tipo) {
                        case "General":
                            this.HorasDisponibles = "8 horas";
                            this.BonoPorRiesgo = 1000;
                            this.Tarifa = 50;
                            this.HorasRealizadas = 3;
                            break;
                        case "Especialista":
                            this.HorasDisponibles = "6 horas";
                            this.BonoPorRiesgo = 2000;
                            this.Tarifa = 75;
                            this.HorasRealizadas = 4;
                            break;
                    }
                }
            }
            @Override
            public void salario(int Salario){
                super.salario(Salario + BonoPorRiesgo+(HorasRealizadas*Tarifa));
            }
}
