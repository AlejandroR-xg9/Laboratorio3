import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<DoctorGeneral> doctors = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    private List<String> registro = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().createAndShowGui());
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Sistema de Doctores y Citas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JTabbedPane tabs = new JTabbedPane();

        
        JPanel doctorPanel = new JPanel(new BorderLayout());
        JPanel docForm = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.fill = GridBagConstraints.HORIZONTAL;

        JTextField dId = new JTextField(8);
        dId.setEditable(false);
    
    dId.setText(String.valueOf(doctors.size() + 1));
    dId.setText(String.valueOf(doctors.size() + 1));
        

        JTextField dNombre = new JTextField(12);
        String[] dDepartamentos = { "Doctor General","Terapeuta", "Radiología", "Farmaceutica", "Enfermería", "Cirujano"};
        JComboBox<String> dDepartamentoCombo = new JComboBox<>(dDepartamentos);
        JTextField dExperiencia = new JTextField(6);

        JTextField dSalario = new JTextField(8);

    JTextField dEspecializacion = new JTextField(10);
    String[] dOpc = { "Pediatría", "Medicina interna", "Medicina familiar" };
    JComboBox<String> dEspecialidad = new JComboBox<>(dOpc);

    JLabel dEspecialidadLabel = new JLabel("Especialidad (rol):");


        int row = 0;
        c.gridx = 0;
        c.gridy = row;
        docForm.add(new JLabel("ID:"), c);
        c.gridx = 1;
        docForm.add(dId, c);
        c.gridx = 2;
        docForm.add(new JLabel("Nombre:"), c);
        c.gridx = 3;
        docForm.add(dNombre, c);

        row++;
        c.gridx = 0;
        c.gridy = row;
        docForm.add(new JLabel("Departamento:"), c);
        c.gridx = 1;
        docForm.add(dDepartamentoCombo, c);
        c.gridx = 2;
        docForm.add(new JLabel("Experiencia (años):"), c);
        c.gridx = 3;
        docForm.add(dExperiencia, c);

        row++;
        c.gridx = 0;
        c.gridy = row;
        docForm.add(new JLabel("Salario base:"), c);
        c.gridx = 1;
        docForm.add(dSalario, c);
    

    row++;
    c.gridx = 0;
    c.gridy = row;
    docForm.add(dEspecialidadLabel, c);
    c.gridx = 1;
    docForm.add(dEspecialidad, c);
    
    
        

        String[] docCols = { "ID", "Nombre", "Departamento", "Exp", "Salario", "Especializacion", "Especialidad",
                "Tarifa", "Pacientes/día" };
        DefaultTableModel docModel = new DefaultTableModel(docCols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        JTable docTable = new JTable(docModel);

        JPanel docButtons = new JPanel();
        JButton docAdd = new JButton("Agregar Doctor");
    JButton docDelete = new JButton("Eliminar Doctor");
        docButtons.add(docAdd);
    docButtons.add(docDelete);

        
        JPanel efficiencyPanel = new JPanel(new BorderLayout());
        String[] efficiencyCols = { "Doctor", "Citas", "Horario" };
        DefaultTableModel efficiencyModel = new DefaultTableModel(efficiencyCols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable efficiencyTable = new JTable(efficiencyModel);
        efficiencyPanel.add(new JScrollPane(efficiencyTable), BorderLayout.CENTER);

        doctorPanel.add(docForm, BorderLayout.NORTH);
        doctorPanel.add(new JScrollPane(docTable), BorderLayout.CENTER);
        doctorPanel.add(docButtons, BorderLayout.SOUTH);


        
        JPanel citaPanel = new JPanel(new BorderLayout());
        JPanel citaForm = new JPanel(new GridBagLayout());
        GridBagConstraints cc = new GridBagConstraints();
        cc.insets = new Insets(4, 4, 4, 4);
        cc.fill = GridBagConstraints.HORIZONTAL;

    JTextField cId = new JTextField(8);
    cId.setEditable(false);
    cId.setText(String.valueOf(citas.size() + 1));
        JTextField cNombre = new JTextField(12);
        JComboBox<String> medicoCombo = new JComboBox<>();
        JTextField cFecha = new JTextField(10);
        JTextField cHora = new JTextField(8);
    String[] tipos = { "Consulta", "Terapia", "Seguimiento" };
    JComboBox<String> tipoCombo = new JComboBox<>(tipos);
        String[] estados = { "Pendiente", "Confirmada", "Cancelada" };
        JComboBox<String> estadoCombo = new JComboBox<>(estados);

        int cr = 0;
        cc.gridx = 0;
        cc.gridy = cr;
        citaForm.add(new JLabel("ID Cita:"), cc);
        cc.gridx = 1;
        citaForm.add(cId, cc);
        cc.gridx = 2;
        citaForm.add(new JLabel("Paciente Nombre:"), cc);
        cc.gridx = 3;
        citaForm.add(cNombre, cc);

        cr++;
        cc.gridx = 0;
        cc.gridy = cr;
        citaForm.add(new JLabel("Medico asignado:"), cc);
        cc.gridx = 1;
        cc.gridwidth = 3;
        citaForm.add(medicoCombo, cc);
        cc.gridwidth = 1;

        cr++;
        cc.gridx = 0;
        cc.gridy = cr;
        citaForm.add(new JLabel("Fecha (dd/mm/yyyy):"), cc);
        cc.gridx = 1;
        citaForm.add(cFecha, cc);
        cc.gridx = 2;
        citaForm.add(new JLabel("Hora (hh:mm):"), cc);
        cc.gridx = 3;
        citaForm.add(cHora, cc);

        cr++;
        cc.gridx = 0;
        cc.gridy = cr;
        citaForm.add(new JLabel("Tipo:"), cc);
        cc.gridx = 1;
        citaForm.add(tipoCombo, cc);
    

        cr++;
        cc.gridx = 0;
        cc.gridy = cr;
        citaForm.add(new JLabel("Estado:"), cc);
        cc.gridx = 1;
        citaForm.add(estadoCombo, cc);

        String[] citaCols = { "ID", "Paciente", "MedicoAsignado", "Fecha", "Hora", "Tipo", "Estado" };
        DefaultTableModel citaModel = new DefaultTableModel(citaCols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        JTable citaTable = new JTable(citaModel);

        JPanel citaButtons = new JPanel();
        JButton citaAdd = new JButton("Agregar Cita");
    JButton citaDelete = new JButton("Eliminar Cita");
        citaButtons.add(citaAdd);
    citaButtons.add(citaDelete);

        citaPanel.add(citaForm, BorderLayout.NORTH);
        citaPanel.add(new JScrollPane(citaTable), BorderLayout.CENTER);
        citaPanel.add(citaButtons, BorderLayout.SOUTH);

        
    tabs.addTab("Doctores", doctorPanel);
    tabs.addTab("Citas", citaPanel);
    tabs.addTab("Eficiencia", efficiencyPanel);

        JPanel payrollPanel = new JPanel(new BorderLayout());
        String[] payrollCols = {"Departamento", "NominaTotal"};
        DefaultTableModel payrollModel = new DefaultTableModel(payrollCols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        JTable payrollTable = new JTable(payrollModel);
        payrollPanel.add(new JScrollPane(payrollTable), BorderLayout.CENTER);
        tabs.addTab("Nómina", payrollPanel);

    JPanel registroPanel = new JPanel(new BorderLayout());
    JTextArea registroArea = new JTextArea();
    registroArea.setEditable(false);
    registroPanel.add(new JScrollPane(registroArea), BorderLayout.CENTER);
    tabs.addTab("Registro", registroPanel);

    for (String s : registro) {
        String display = s;
        int idx = s.indexOf(" - ");
        if (idx != -1) display = s.substring(idx + 3);
        registroArea.append(display + "\n");
    }

    updatePayroll(payrollModel);

        frame.add(tabs);

        
        java.util.Map<String, String[]> deptSpecs = new java.util.HashMap<>();
        deptSpecs.put("Doctor General", new String[]{"Pediatría", "Medicina interna", "Medicina familiar"});
        deptSpecs.put("Terapeuta", new String[]{"Física", "Ocupacional"});
        deptSpecs.put("Radiología", new String[]{"Rayos X", "Tomografía", "Resonancia Magnética"});
        deptSpecs.put("Farmaceutica", new String[]{"Vigente", "No vigente"});
        deptSpecs.put("Enfermería", new String[]{"Pediatría", "Medicina interna", "Medicina familiar"});
        deptSpecs.put("Cirujano", new String[]{"General", "Especialista"});

    
    java.util.Map<String, String> deptLabel = new java.util.HashMap<>();
    deptLabel.put("Doctor General", "Especialidad (rol):");
    deptLabel.put("Terapeuta", "Licencia:");
    deptLabel.put("Radiología", "Tipo de equipo:");
    deptLabel.put("Farmaceutica", "Licencia:");
    deptLabel.put("Enfermería", "Certificación:");
    deptLabel.put("Cirujano", "Tipo:");

        
        dDepartamentoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dep = (String) dDepartamentoCombo.getSelectedItem();
                String[] specs = deptSpecs.get(dep);
                boolean hasSpecs = specs != null && specs.length > 0;

    
                dEspecializacion.setVisible(hasSpecs);
                dEspecialidadLabel.setVisible(hasSpecs);
                dEspecialidad.setVisible(hasSpecs);

                
                String labelText = deptLabel.get(dep);
                if (labelText != null) dEspecialidadLabel.setText(labelText);

                if (hasSpecs) {
                    dEspecialidad.removeAllItems();
                    for (String s : specs) dEspecialidad.addItem(s);
                } else {
                    dEspecializacion.setText("");
                    dEspecialidad.removeAllItems();
                }
            }
        });

        
        ActionEvent ae = new ActionEvent(dDepartamentoCombo, ActionEvent.ACTION_PERFORMED, "init");
        for (ActionListener al : dDepartamentoCombo.getActionListeners()) al.actionPerformed(ae);

        
        docAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int id = doctors.size() + 1;
                    String nombre = dNombre.getText().trim();
                    String departamento = (String) dDepartamentoCombo.getSelectedItem();
                    int experiencia = Integer.parseInt(dExperiencia.getText().trim());
                    int salario = Integer.parseInt(dSalario.getText().trim());
                    String especializacion = "";
                    String especialidad = "";
                    
                    if (dEspecializacion.isVisible()) {
                        especializacion = dEspecializacion.getText().trim();
                    }
                    if (dEspecialidad.isVisible()) {
                        especialidad = (String) dEspecialidad.getSelectedItem();
                        
                    }

                    DoctorGeneral dg = new DoctorGeneral(id, nombre, departamento, experiencia, salario,
                            especializacion, especialidad);
                    dg.asignarCaracteristicas(especializacion);
                    dg.salario(salario);
                    doctors.add(dg);
                    appendLog(registroArea, "Doctor agregado: ID=" + dg.getId() + ", Nombre=" + dg.getNombre());
                    
                    String displayEspecializacion = dg.getEspecializacion() != null ? dg.getEspecializacion() : "";
                    String displayEspecialidad = dg.getEspecialidad() != null ? dg.getEspecialidad() : "";
                    
                    if (!deptSpecs.containsKey(dg.getDepartamento())) {
                        displayEspecializacion = "";
                        displayEspecialidad = "";
                    }
                    docModel.addRow(new Object[] { dg.getId(), dg.getNombre(), dg.getDepartamento(), dg.getExperiencia(), dg.getSalario(), displayEspecializacion, displayEspecialidad, dg.getTarifa(), dg.getPacientesporDia() });

                    
                    medicoCombo.addItem("Doctor: " + dg.getNombre() + " (ID:" + dg.getId() + ")");

                    
                    dId.setText(String.valueOf(doctors.size() + 1));
                    dNombre.setText("");
                    dDepartamentoCombo.setSelectedIndex(0);
                    dExperiencia.setText("");
                    dSalario.setText("");
                    dEspecializacion.setText("");
                    dEspecialidad.setSelectedIndex(0);

                    
                    updatePayroll(payrollModel);
                    updateEfficiency(efficiencyModel);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID, experiencia y salario deben ser números.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        


        
        citaAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = citas.size() + 1;
                    String paciente = cNombre.getText().trim();
                    String medicoAsignado = (String) medicoCombo.getSelectedItem();
                    String fecha = cFecha.getText().trim();
                    String hora = cHora.getText().trim();

                    if (paciente.isEmpty() || medicoAsignado == null || medicoAsignado.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Rellene paciente, médico, fecha y hora antes de crear la cita.", "Campos obligatorios", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String tipo = (String) tipoCombo.getSelectedItem();
                    String estado = (String) estadoCombo.getSelectedItem();

                    long count = citas.stream().filter(ci -> medicoAsignado.equals(ci.getMedicoAsignado())).count();
                    if (count >= 3) {
                        JOptionPane.showMessageDialog(frame, "El médico ya tiene el máximo de 3 citas.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    int selId = extractIdFromLabel(medicoAsignado);
                    String departamento = null;
                    for (DoctorGeneral dd : doctors) if (dd.getId() == selId) { departamento = dd.getDepartamento(); break; }
                    final String departamentoFinal = departamento;
                    String adjustedHora = hora;
                    if (departamentoFinal != null && adjustedHora != null && !adjustedHora.isEmpty()) {
                        boolean conflict = true;
                        int safety = 0;
                        while (conflict && safety < 24) {
                            final String checkHora = adjustedHora;
                            conflict = citas.stream().anyMatch(ci -> {
                                int otherId = extractIdFromLabel(ci.getMedicoAsignado());
                                if (otherId == -1) return false;
                                DoctorGeneral od = null;
                                for (DoctorGeneral ddd : doctors) if (ddd.getId() == otherId) { od = ddd; break; }
                                if (od == null) return false;
                                return departamentoFinal.equals(od.getDepartamento()) && checkHora.equals(ci.getHora());
                            });
                            if (conflict) {
                                adjustedHora = addOneHour(adjustedHora);
                                safety++;
                            }
                        }
                    }
                    Cita cita = new Cita(id, paciente, medicoAsignado, fecha, adjustedHora, tipo, estado);
                    citas.add(cita);
                    appendLog(registroArea, "Cita agregada: ID=" + cita.getId() + ", Paciente=" + cita.getNombre() + ", Medico=" + cita.getMedicoAsignado());
                    citaModel.addRow(new Object[] { cita.getId(), cita.getNombre(), cita.getMedicoAsignado(),
                            cita.getFecha(), cita.getHora(), cita.getTipo(), cita.getEstado() });
                    cId.setText(String.valueOf(citas.size() + 1));
                    cNombre.setText("");
                    cFecha.setText("");
                    cHora.setText("");
                    tipoCombo.setSelectedIndex(0);
                    estadoCombo.setSelectedIndex(0);
                    updateEfficiency(efficiencyModel);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "El ID de la cita debe ser un número.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        

        docDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sel = docTable.getSelectedRow();
                if (sel >= 0) {
                    int id = (int) docModel.getValueAt(sel, 0);
                    String nombre = (String) docModel.getValueAt(sel, 1);
                    docModel.removeRow(sel);
                    doctors.removeIf(d -> d.getId() == id);
                    appendLog(registroArea, "Doctor eliminado: ID=" + id + ", Nombre=" + nombre);
                    updatePayroll(payrollModel);
                    updateEfficiency(efficiencyModel);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione un doctor para eliminar.");
                }
            }
        });

 
        citaDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sel = citaTable.getSelectedRow();
                if (sel >= 0) {
                    int id = (int) citaModel.getValueAt(sel, 0);
                    String paciente = (String) citaModel.getValueAt(sel, 1);
                    citaModel.removeRow(sel);
                    citas.removeIf(c -> c.getId() == id);
                    appendLog(registroArea, "Cita eliminada: ID=" + id + ", Paciente=" + paciente);
                    cId.setText(String.valueOf(citas.size() + 1));
                    updateEfficiency(efficiencyModel);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione una cita para eliminar.");
                }
            }
        });


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updatePayroll(DefaultTableModel payrollModel) {
        java.util.Map<String, Integer> totals = new java.util.HashMap<>();
        for (DoctorGeneral dg : doctors) {
            int base = dg.getSalario();
            int tarifa = dg.getTarifa();
            int pacientes = dg.getPacientesporDia();
            int total = base + tarifa * pacientes;
            String dep = dg.getDepartamento();
            totals.put(dep, totals.getOrDefault(dep, 0) + total);
        }

        while (payrollModel.getRowCount() > 0) payrollModel.removeRow(0);
        for (java.util.Map.Entry<String, Integer> e : totals.entrySet()) {
            payrollModel.addRow(new Object[] { e.getKey(), e.getValue() });
        }
    }

    private void updateEfficiency(DefaultTableModel efficiencyModel) {
        
        while (efficiencyModel.getRowCount() > 0) efficiencyModel.removeRow(0);
        for (DoctorGeneral dg : doctors) {
            String doctorLabel = "Doctor: " + dg.getNombre() + " (ID:" + dg.getId() + ")";
            long count = citas.stream().filter(ci -> doctorLabel.equals(ci.getMedicoAsignado())).count();
    
            StringBuilder sb = new StringBuilder();
            citas.stream().filter(ci -> doctorLabel.equals(ci.getMedicoAsignado())).forEach(ci -> {
                if (sb.length() > 0) sb.append("; ");
                sb.append(ci.getFecha()).append(" ").append(ci.getHora());
            });
            efficiencyModel.addRow(new Object[] { doctorLabel, count, sb.toString() });
        }
    }

    private int extractIdFromLabel(String label) {
        if (label == null) return -1;
        int idx = label.indexOf("(ID:");
        if (idx == -1) return -1;
        int end = label.indexOf(')', idx);
        if (end == -1) return -1;
        String num = label.substring(idx + 4, end).trim();
        try { return Integer.parseInt(num); } catch (NumberFormatException e) { return -1; }
    }

    private String addOneHour(String hora) {
        if (hora == null || hora.isEmpty()) return hora;
        try {
            String[] parts = hora.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
            h = (h + 1) % 24;
            return String.format("%02d:%02d", h, m);
        } catch (Exception ex) {
            return hora;
        }
    }

    private void appendLog(JTextArea area, String text) {
        registro.add(text);
        area.append(text + "\n");
    }
}