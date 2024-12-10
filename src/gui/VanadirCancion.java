/*
 * Created by JFormDesigner on Thu Apr 25 16:56:37 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import aplicacion.*;

/**
 * @author davra
 */
public class VanadirCancion extends JDialog {
    fachadaAplicacion fa;
    String usuarioActual;
    Integer idAlbum;
    boolean explicito;
    Integer contador;
    PasarCancionCallback callback;
    public VanadirCancion(Frame owner, fachadaAplicacion fa, String usuarioActual, Integer idAlbum, PasarCancionCallback callback) {
        super(owner);
        this.fa= fa;
        this.explicito = false;
        this.contador = 0;
        initComponents();
        this.usuarioActual = usuarioActual;
        this.idAlbum = idAlbum;
        this.callback = callback;

    }
    
    public int getContador(){
        return contador;
    }

    public void setContador(int contador){
        this.contador = contador;
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void bttAnadir(ActionEvent e) {
        // TODO add your code here
        if(buscadorDuracion.getText().isEmpty() || buscadorNombre.getText().isEmpty()){
            fa.muestraExcepcion("Completa los campos correspondientes antes de continuar.");
        }else{
            String nombreCancion = this.buscadorNombre.getText();
            String duracionCancion = this.buscadorDuracion.getText();
            String generoCancion = (String) this.comboBoxGenero.getSelectedItem();
            String idiomaCancion = (String) this.comboBoxIdioma.getSelectedItem();
            boolean letra = letraCancion.getText().isEmpty();

            //Cambiar DAO para que no necesite el idAlbum porque ya se le mete al crear la cancion a insertar
            Cancion cancion = new Cancion(nombreCancion, -1, duracionCancion, idiomaCancion,generoCancion, letra, 0, idAlbum, explicito);
            pasarCancion(cancion);

            contador++;

            //limpiar campos
            buscadorNombre.setText("");
            buscadorDuracion.setText("");
            letraCancion.setText("");
            comboBoxGenero.setSelectedIndex(0);
            comboBoxIdioma.setSelectedIndex(0);
            checkBoxExplicito.setSelected(false);
        }
    }


    private void pasarCancion(Cancion c){
        if(callback != null){
            callback.pasarCancion(c);
        }
    }
    

    private void checkBoxExplicito(ActionEvent e) {
        explicito = checkBoxExplicito.isSelected();
    }

    private void createUIComponents() {
        comboBoxIdioma = new JComboBox();
        // Definir los tipos de álbum disponibles
        String[] idiomas = {"Español", "Chino", "Gallego", "Portugues", "Ingles", "Cromañon", "Frances", "Italiano"};
        
        // Añadir los tipos de álbum al JComboBox
        for (String a : idiomas) {
            comboBoxIdioma.addItem(a);
        }
        //el color de fondo de la pestaña es #00d856
        comboBoxIdioma.setBackground(new Color(0, 216, 86));
        // Configuración del color de selección a un verde más oscuro
        comboBoxIdioma.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    c.setBackground(new Color(0, 153, 76)); // Un verde más oscuro, #00994C
                    c.setForeground(Color.WHITE); // Color de texto blanco para mejor contraste
                }
                return c;
            }
        });
        
        comboBoxGenero = new JComboBox();
        // Definir los tipos de álbum disponibles
        String[] generos = {"Pop", "Rock", "Rap", "Reggaeton", "Indie", "Techno", "Clasica"};
        for (String a : generos) {
            comboBoxGenero.addItem(a);
        }
        //el color de fondo de la pestaña es #00d856
        comboBoxGenero.setBackground(new Color(0, 216, 86));
        // Configuración del color de selección a un verde más oscuro
        comboBoxGenero.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    c.setBackground(new Color(0, 153, 76)); // Un verde más oscuro, #00994C
                    c.setForeground(Color.WHITE); // Color de texto blanco para mejor contraste
                }
                return c;
            }
        });
    }

    private void genero(ActionEvent e) {
        // TODO add your code here
    }

    private void idioma(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel3 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        buscadorNombre = new JTextField();
        buscadorDuracion = new JTextField();
        bttAnadir = new JButton();
        panel4 = new JPanel();
        label1 = new JLabel();
        label5 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        checkBoxExplicito = new JCheckBox();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane1 = new JScrollPane();
        letraCancion = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel3 ========
        {

            //---- label2 ----
            label2.setText("Nombre:");
            label2.setFont(new Font("Arial", Font.BOLD, 12));

            //---- bttAnadir ----
            bttAnadir.setText("A\u00d1ADIR");
            bttAnadir.setFont(new Font("Arial", Font.BOLD, 12));
            bttAnadir.setForeground(Color.white);
            bttAnadir.setBackground(new Color(0x00d856));
            bttAnadir.addActionListener(e -> {
			button2(e);
			bttAnadir(e);
		});

            //======== panel4 ========
            {
                panel4.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setText("CREAR CANCI\u00d3N");
                label1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                label1.setForeground(Color.white);

                //---- label5 ----
                label5.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(label1)
                            .addContainerGap(91, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(label1)
                            .addContainerGap(27, Short.MAX_VALUE))
                );
            }

            //---- label4 ----
            label4.setText("Duraci\u00f3n:");
            label4.setFont(new Font("Arial", Font.BOLD, 12));

            //---- label6 ----
            label6.setText("G\u00e9nero:");
            label6.setFont(new Font("Arial", Font.BOLD, 12));

            //---- checkBoxExplicito ----
            checkBoxExplicito.setText("Expl\u00edcito");
            checkBoxExplicito.setFont(new Font("Arial", Font.BOLD, 12));
            checkBoxExplicito.addActionListener(e -> checkBoxExplicito(e));

            //---- comboBoxIdioma ----
            comboBoxIdioma.setForeground(Color.white);
            comboBoxIdioma.addActionListener(e -> idioma(e));

            //---- label7 ----
            label7.setText("Idioma:");
            label7.setFont(new Font("Arial", label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize()));

            //---- comboBoxGenero ----
            comboBoxGenero.setForeground(Color.white);
            comboBoxGenero.addActionListener(e -> genero(e));

            //---- label8 ----
            label8.setText("Letra:");
            label8.setFont(new Font("Arial", Font.BOLD, 12));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(letraCancion);
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addComponent(label7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboBoxIdioma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addComponent(label8)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(92, 92, 92))))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscadorDuracion, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(checkBoxExplicito))
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(comboBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(bttAnadir)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7)
                            .addComponent(comboBoxIdioma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(label3)
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(buscadorDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8))
                                .addGap(32, 32, 32)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(comboBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(checkBoxExplicito))
                            .addComponent(scrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(bttAnadir)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;
    private JTextField buscadorNombre;
    private JTextField buscadorDuracion;
    private JButton bttAnadir;
    private JPanel panel4;
    private JLabel label1;
    private JLabel label5;
    private JLabel label4;
    private JLabel label6;
    private JCheckBox checkBoxExplicito;
    private JComboBox comboBoxIdioma;
    private JLabel label7;
    private JComboBox comboBoxGenero;
    private JLabel label8;
    private JScrollPane scrollPane1;
    private JTextArea letraCancion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
