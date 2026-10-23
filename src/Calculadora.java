import javax.swing.*;

public class Calculadora {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnMulti;
    private JButton btnC;
    private JButton btnDelete;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnLess;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPlus;
    private JButton btn7;
    private JButton btnEqual;
    private JButton btnDot;
    private JButton btn0;
    private JButton btnDiv;
    private JTextField txtPantalla;
    private JPanel mainPanel;
    String expresion;
    public Calculadora() {
        btn1.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "1")
        );
        btn2.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "2")
        );
        btn3.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "3")
        );
        btn4.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "4")
        );
        btn5.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "5")
        );
        btn6.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "6")
        );
        btn7.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "7")
        );
        btn8.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "8")
        );
        btn9.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "9")
        );
        btn0.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "0")
        );
        btnPlus.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "+")
        );
        btnLess.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "-")
        );
        btnDiv.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "/")
        );
        btnMulti.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + "*")
        );
        btnDot.addActionListener(e ->
                txtPantalla.setText(txtPantalla.getText() + ".")
        );
        btnC.addActionListener(e ->
                txtPantalla.setText("")
        );
        btnDelete.addActionListener(e -> {
            String texto = txtPantalla.getText();

            if (!texto.isEmpty()) {

                texto = texto.substring(0, texto.length() - 1);

                txtPantalla.setText(texto);
            }
        });
        btnEqual.addActionListener(e -> {
            expresion = txtPantalla.getText();
            String posfija =
                    EvaluarExpresiones.infijaAPosfija(expresion);
            double resultado =
                    EvaluarExpresiones.evaluarPosfija(
                            posfija
                    );
            String resultadoPantalla=String.valueOf(resultado);
            txtPantalla.setText(resultadoPantalla);
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Basica");
        frame.setContentPane(new Calculadora().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
