import controller.RomanConverterController;
import model.RomanConverter;
import view.DecimalRomano;

public class Main {
    public static void main(String[] args) {
        // Instancia del modelo
        RomanConverter romanConverter = new RomanConverter();

        // Instancia de la vista
        DecimalRomano decimalRomano = new DecimalRomano();

        // Instancia del controlador pasando la vista y el modelo como parámetros
        RomanConverterController controller = new RomanConverterController(decimalRomano, romanConverter);
    }
}

