import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    Font myFont = new Font("Jazz LET", Font.ITALIC, 25);

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton plusButton, subButton, mulButton, divButton;
    JButton decButton,equButton,delButton,clearButton,minusButton;
    JPanel panel;

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(new Color(255,255,224));

        plusButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clearButton = new JButton("СЕ");
        minusButton = new JButton("+/-");

        functionButtons[0] = plusButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = minusButton;


        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(254,255,191));
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(218,252,203));
        }

        minusButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(new Color(255,255,225));
        //panel.setBackground(Color.pink);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(plusButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(minusButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args){

        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){ //для отображения цифр принажатии на кнопки
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){ //для точки
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == plusButton){ // +
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){ // -
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){ // *
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){ // делить
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){ //
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clearButton){ // очистить
            textField.setText("");
        }
        if(e.getSource() == delButton){ // удалить
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == minusButton){ // отрицание
            double minus = Double.parseDouble(textField.getText());
            minus = minus * -1;
            textField.setText(String.valueOf(minus));
        }
    }
}
