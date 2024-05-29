package Model;

public class NicomacoModel {
    private int filas;


    public void setFilas(int filas) {
        this.filas = filas;
    }

    public String calcularCubos(){
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= filas; i++){
            resultado.append(i).append("^3 = ").append(i * i * i).append("=");
            resultado.append(getImpares(i));
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public String getImpares(int n){
        StringBuilder impares = new StringBuilder();
        int inicio = (n*n)-n+1;
        int fin = (n*n)+n-1;
        for(int i = inicio; i <= fin; i=i+2){
            impares.append(i).append(" + ");
            if(i == fin)
                impares.delete(impares.length()-2, impares.length());
        }

        return impares.toString();
    }
}
