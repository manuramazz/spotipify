/*
 * Created by JFormDesigner on Thu Apr 25 22:49:47 CEST 2024
 */

package gui;

import aplicacion.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author User
 */
public class VPodcast extends JFrame {
    fachadaAplicacion fa;
    Podcast podcast;
    List<Capitulo> capitulos;
    public VPodcast(fachadaAplicacion fa,Podcast podcast, List<Capitulo> capitulos) {
        this.fa=fa;
        this.podcast=podcast;
        this.capitulos=capitulos;
        initComponents();
        label9.setVisible(false);
        labelPodcast.setText(podcast.getNombre());
        String strArtistas=fa.obtenerArtistasDePodcast(podcast.getNombre());
        labelArtistas.setText(strArtistas);
        if(!capitulos.isEmpty()){
            labelCapitulo.setText(String.valueOf(capitulos.get(0).getNombre()));
        }
        List<String> nombresCaps = new ArrayList<>();
        for(Capitulo c: capitulos){
            nombresCaps.add(c.getNombre());
        }
        modeloListaBiblioteca modelo;
        modelo = (modeloListaBiblioteca) lista.getModel();
        modelo.agregarLista(nombresCaps);
    }

    private void createUIComponents() {
        lista = new JList();
        lista.setModel(new modeloListaBiblioteca());
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                labelCapitulo.setText((String)lista.getSelectedValue());
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        labelPodcast = new JLabel();
        labelCapitulo = new JLabel();
        labelArtistas = new JLabel();
        button1 = new JButton();
        label9 = new JLabel();
        labelDuracion = new JLabel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pista.png")));

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/fotos/play.png")));

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pistaizq.png")));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label6 ----
                label6.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

                //---- labelPodcast ----
                labelPodcast.setText("text");
                labelPodcast.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 24));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(45, Short.MAX_VALUE)
                            .addComponent(labelPodcast, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label6)
                            .addGap(54, 54, 54))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label6)
                                .addComponent(labelPodcast, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
            }

            //---- labelCapitulo ----
            labelCapitulo.setText("oops, no hay cap\u00edtulos");
            labelCapitulo.setFont(new Font("Franklin Gothic Demi", labelCapitulo.getFont().getStyle() | Font.BOLD, 16));

            //---- labelArtistas ----
            labelArtistas.setText("text");
            labelArtistas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));

            //---- button1 ----
            button1.setBackground(Color.black);

            //---- label9 ----
            label9.setText("00:00:00");
            label9.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- labelDuracion ----
            labelDuracion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //======== panel3 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(lista);
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(label9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label4)
                                        .addGap(37, 37, 37)
                                        .addComponent(label5))
                                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDuracion, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelArtistas, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addComponent(labelCapitulo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                        .addGap(25, 25, 25)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelCapitulo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(labelArtistas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDuracion)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label3)
                                            .addComponent(label5)
                                            .addComponent(label4))
                                        .addGap(18, 18, 18)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label9))
                                .addContainerGap(30, Short.MAX_VALUE))))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPanel panel2;
    private JLabel label6;
    private JLabel labelPodcast;
    private JLabel labelCapitulo;
    private JLabel labelArtistas;
    private JButton button1;
    private JLabel label9;
    private JLabel labelDuracion;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JList lista;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
