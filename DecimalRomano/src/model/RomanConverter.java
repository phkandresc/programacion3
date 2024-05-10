package model;

public class RomanConverter {
public String convertirARomano(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Número fuera de rango");
        }

        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] unidadesDeMil = {"", "M", "MM", "MMM"};

        int u = numero % 10;
        int d = (numero / 10) % 10;
        int c = (numero / 100) % 10;
        int um = (numero / 1000) % 10;

        return unidadesDeMil[um] + centenas[c] + decenas[d] + unidades[u];
    }
}
