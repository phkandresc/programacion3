package view;

import javax.swing.*;

public class DecimalRomano extends JFrame{
    public JPanel panel1;
    public JTextField txtnumeroDecimal;
    public JButton convertirARomanoButton;
    public JLabel labelnumeroRomano;

    public DecimalRomano() {
        // Inicializar los componentes
        txtnumeroDecimal = new JTextField(10);
        convertirARomanoButton = new JButton("Convertir");
        labelnumeroRomano = new JLabel("Resultado");

        // Crear el panel y agregar los componentes
        panel1 = new JPanel();
        panel1.add(new JLabel("Número Decimal:"));
        panel1.add(txtnumeroDecimal);
        panel1.add(convertirARomanoButton);
        panel1.add(labelnumeroRomano);

        // Configurar la ventana principal
        setTitle("Conversor Decimal a Romano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setVisible(true);
    }
}
