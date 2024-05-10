package controller;

import model.RomanConverter;
import view.DecimalRomano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RomanConverterController implements ActionListener {

    private RomanConverter romanConverter;
    private DecimalRomano decimalRomano;

    public RomanConverterController(DecimalRomano decimalRomano, RomanConverter romanConverter) {
        this.decimalRomano = decimalRomano;
        this.romanConverter = romanConverter;
        this.decimalRomano.convertirARomanoButton.addActionListener(this); // Agregar el controlador como listener al botón
    }

    public String convertirARomano(int numero) {
        return romanConverter.convertirARomano(numero);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == decimalRomano.convertirARomanoButton) {
            try {
                int numero = Integer.parseInt(decimalRomano.txtnumeroDecimal.getText());
                String numeroRomano = convertirARomano(numero);
                decimalRomano.labelnumeroRomano.setText(numeroRomano);
                decimalRomano.labelnumeroRomano.setVisible(true);
            } catch (NumberFormatException ex) {
                // Manejar la entrada inválida del usuario, por ejemplo, mostrando un mensaje de error
                System.err.println("Entrada inválida. Por favor ingrese un número decimal válido.");
            }
        }
    }
}

