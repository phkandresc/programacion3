package org.prueba.DibujarApp.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HacerFormas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JPanel panel;
    public JComboBox comboBox;
    public JRadioButton rdbtnContorno;
    public JRadioButton rdbtnRelleno;
    public JButton btnColorFigura;
    public JPanel lienzo;
    public JPanel panel_1;
    public JButton btnLimpiar;
    public JButton btnGrabar;
    public JButton btnRestaurar;
    public JLabel lblNewLabel;

    public HacerFormas() {
        setTitle("Dibujar figuras");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 670, 513);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(0, 0, 654, 70);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel = new JLabel("Forma:");
        lblNewLabel.setBounds(12, 25, 56, 20);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));

        comboBox = new JComboBox();
        comboBox.setBounds(78, 23, 204, 25);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rectangulo", "Ovalo", "RectRedondeado", "Linea"}));
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        rdbtnContorno = new JRadioButton("Contorno\r\n");
        rdbtnContorno.setBackground(SystemColor.activeCaption);
        rdbtnContorno.setBounds(298, 26, 71, 23);
        panel.add(rdbtnContorno);

        rdbtnRelleno = new JRadioButton("Con relleno");
        rdbtnRelleno.setBackground(SystemColor.activeCaption);
        rdbtnRelleno.setBounds(371, 26, 79, 23);
        panel.add(rdbtnRelleno);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbtnContorno);
        grupo.add(rdbtnRelleno);

        btnColorFigura = new JButton("Color de Figura");
        btnColorFigura.setFont(new Font("Arial", Font.PLAIN, 12));
        btnColorFigura.setBounds(491, 26, 117, 23);
        panel.add(btnColorFigura);

        lienzo = new JPanel();
        lienzo.setBorder(null);
        lienzo.setBackground(new Color(255, 255, 255));
        lienzo.setBounds(0, 71, 654, 357);
        contentPane.add(lienzo);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 427, 654, 47);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnLimpiar.setBounds(61, 11, 117, 23);
        panel_1.add(btnLimpiar);

        btnGrabar = new JButton("Grabar");
        btnGrabar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGrabar.setBounds(274, 11, 117, 23);
        panel_1.add(btnGrabar);

        btnRestaurar = new JButton("Restaurar");
        btnRestaurar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnRestaurar.setBounds(472, 11, 117, 23);
        panel_1.add(btnRestaurar);
    }

    public static void main(String[] args) {
        HacerFormas frame = new HacerFormas();
        frame.setVisible(true);
    }

}