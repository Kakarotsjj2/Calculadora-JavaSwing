import java.util.Stack;
public class EvaluarExpresiones {
    public static int prioridad(char operador){

        switch (operador){

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return 0;
        }
    }

    public static String infijaAPosfija(String expresion){

        StringBuilder salida = new StringBuilder();
        Stack<Character> operadores = new Stack<>();
        //Evalua cada caracter de la cadena que guardo la calculadora
        for(int i = 0; i < expresion.length(); i++){

            char c = expresion.charAt(i);

            // Si es un número
            if(Character.isDigit(c)){

                StringBuilder numero = new StringBuilder();
                boolean tienePunto = false;

                //Si el caracter anterior fue numero y de ahi le sigue otro numero entonces agrega otro numero a la pila de numeros
                while(i < expresion.length()) {

                    char actual = expresion.charAt(i);

                    if(Character.isDigit(actual)) {
                        numero.append(actual);
                    }
                    else if(actual == '.') {

                        if(tienePunto) {
                            throw new IllegalArgumentException(
                                    "Número inválido: más de un punto decimal"
                            );
                        }

                        tienePunto = true;
                        numero.append(actual);
                    }
                    else {
                        break;
                    }

                    i++;
                }
                //agrega a la salida el numero como tal completo que se coloco
                salida.append(numero);
                //agrega un espacio ya que como no es numero debe de ser operador
                salida.append(" ");
                //se quita menos uno al contador ya que la funcion como tal seguia y por ende
                //tiene un uno extra
                i--;
            }
            // Si es operador
            else{
            //Mientras el operador no este vacio y la prioridad de ese operador sea mayor o igual al que ya estaba en la "cima"
                while(!operadores.isEmpty() &&
                        prioridad(operadores.peek()) >= prioridad(c)){
                    //Saca el operador que ya estaba por el nuevo de mayor prioridad
                    salida.append(operadores.pop());
                    salida.append(" ");
                }
            //Sube ese operador como de primer prioridad
                operadores.push(c);
            }
        }

        while(!operadores.isEmpty()){

            salida.append(operadores.pop());
            salida.append(" ");
        }

        return salida.toString();
    }

    public static double evaluarPosfija(String posfija){

        Stack<Double> pila = new Stack<>();

        String[] tokens = posfija.split(" ");

        for(String token : tokens){

            if(token.isEmpty())
                continue;

            // Número
            if(Character.isDigit(token.charAt(0))){

                pila.push(Double.parseDouble(token));
            }
            else{

                double b = pila.pop();
                double a = pila.pop();

                double resultado = 0;

                switch(token.charAt(0)){

                    case '+':
                        resultado = a + b;
                        break;

                    case '-':
                        resultado = a - b;
                        break;

                    case '*':
                        resultado = a * b;
                        break;

                    case '/':
                        resultado = a / b;
                        break;
                }

                pila.push(resultado);
            }
        }

        return pila.pop();
    }


        public static void main(String[] args) {

        }

}
