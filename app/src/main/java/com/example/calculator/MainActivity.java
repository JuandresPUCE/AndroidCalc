package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    Button buttonAdd, buttonRest,buttonMultiply , buttonDivision, buttonEqual;
    Button button1, button2, button3;
    Button button4, button5,button6;
    Button button7,button8,button9,button0;
    Button buttonDot, buttonClear, buttonSing;
    Button buttonPow;
    Button buttonRightBracket, buttonLeftBracket;

    Button buttonDelete;
    TextView textViewResult;
    TextView textViewOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPow = findViewById(R.id.buttonPow);
        buttonClear=findViewById(R.id.buttonClear);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonRest = findViewById(R.id.buttonRest);
        buttonMultiply = findViewById(R.id.buttonMultiplication);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonSing = findViewById(R.id.buttonSign);

                

        buttonRightBracket = findViewById(R.id.buttonRightBracket);
        buttonLeftBracket = findViewById(R.id.buttonLeftBracket);

        TextView textViewResult = findViewById(R.id.textViewSolution);
        TextView textViewOperation = findViewById(R.id.textViewOperation);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"0");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"+");
            }
        });

        buttonRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"*");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewOperation.setText(textViewOperation.getText()+"/");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textViewOperation.getText().toString();
                String replacestr = str.replace("÷", "/").replace("×", "*");
                Double result = evaluate(replacestr);
                String r = result.toString();
                textViewOperation.setText(r);
                textViewResult.setText(str);
            }
        });

        buttonSing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = textViewOperation.getText().toString();

                // Si textViewOperation está vacío, no se hace nada
                if (currentText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No hay número para cambiar de signo", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Verifica si el último carácter es un operador
                    char lastChar = currentText.charAt(currentText.length() - 1);

                    // Verifica el tipo de operador y elimina el operador
                    if (lastChar == '+') {
                        currentText = currentText.substring(0, currentText.length() - 1);
                    } else if (lastChar == '-') {
                        currentText = currentText.substring(0, currentText.length() - 1);
                    } else if (lastChar == '*') {
                        currentText = currentText.substring(0, currentText.length() - 1);
                    } else if (lastChar == '/') {
                        currentText = currentText.substring(0, currentText.length() - 1);
                    }

                    // Cambiar el signo del último número
                    double currentNumber = Double.parseDouble(currentText);
                    currentNumber = -currentNumber;
                    textViewOperation.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException e) {
                    // Manejar la excepción si el valor no es un número válido
                    Toast.makeText(MainActivity.this, "Número no válido", Toast.LENGTH_SHORT).show();
                } catch (StringIndexOutOfBoundsException e) {
                    // Manejar la excepción si no hay un operador para cambiar el signo
                    Toast.makeText(MainActivity.this, "No hay operador para cambiar el signo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String power= textViewOperation.getText().toString();
                if (power.isEmpty()){
                    Toast.makeText(MainActivity.this,"Coloque un numero valido", Toast.LENGTH_SHORT).show();
                }
                else{
                    textViewOperation.setText(textViewOperation.getText()+"^" + "");
                }
            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            boolean isFirstClearClick = true;
            @Override
            public void onClick(View v) {
                if (isFirstClearClick) {
                    // Si es la primera pulsación, borra el contenido de textViewResult
                    textViewResult.setText("");
                    Toast.makeText(MainActivity.this, "Borrando textViewResult", Toast.LENGTH_SHORT).show();
                    isFirstClearClick = false;
                } else {
                    // Si es la segunda pulsación, borra solo el contenido de textViewOperation
                    textViewOperation.setText("");
                    Toast.makeText(MainActivity.this, "Borrando textViewOperation", Toast.LENGTH_SHORT).show();
                    isFirstClearClick = true;
                }
            }
        });

        buttonLeftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText(textViewOperation.getText() + "(");
            }
        });

        buttonRightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText(textViewOperation.getText() + ")");
            }
        });

    }

    private Double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') {
                continue; // Ignorar espacios en blanco
            } else if (c == '(') {
                operators.push(c);
            } else if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(num.toString()));
                i--; // Retroceder un carácter para compensar el avance en el bucle
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyOperator(values, operators);
                }
                operators.pop(); // Eliminar el paréntesis izquierdo

                if (i + 2 < expression.length() && expression.charAt(i + 1) == '=' && expression.charAt(i + 2) == ' ') {
                    // Detectar expresiones en paréntesis seguidas de '= '
                    // Realizar la evaluación y almacenar el resultado
                    Double result = values.pop();
                    if (values.isEmpty()) {
                        return result;
                    } else {
                        return Double.NaN; // Error: expresión mal formada
                    }
                }
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && hasHigherPrecedence(c, operators.peek())) {
                    applyOperator(values, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            applyOperator(values, operators);
        }

        if (values.isEmpty()) {
            return 0.0;
        }

        return values.pop();
    }




    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private boolean hasHigherPrecedence(char op1, char op2) {
        if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) {
            return false;
        }
        if (op1 == '^' && (op2 == '+' || op2 == '-' || op2 == '*' || op2 == '/')) {
            return false;
        }
        return true;
    }

    private void applyOperator(Stack<Double> values, Stack<Character> operators) {
        char operator = operators.pop();
        double num2 = values.pop();
        double num1 = values.pop();
        double result = 0.0;

        try {
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        result = Double.NaN; // Cambiar a Double.NaN en lugar de lanzar una excepción
                    }
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;
            }

            values.push(result);
        } catch (ArithmeticException e) {
            // Manejar la excepción si ocurre un error de aritmética
            // Puedes personalizar el manejo de la excepción aquí, como mostrar un mensaje de error
            Toast.makeText(MainActivity.this, "Error de aritmética: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            // También puedes lanzar la excepción nuevamente si deseas que la aplicación se detenga
            // throw e;
        }
    }

}