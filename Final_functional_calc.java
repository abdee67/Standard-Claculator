
import java.awt.*;
import java.awt.event.*;

class calculator extends Frame implements ActionListener {

    TextField text;
    Panel panel;
    String button[] = { "7", "8", "9",  "4", "5", "6", "1", "2", "3","+", "-", "*", "/", "=","C", "BACK", "0","CL" };
    Button btn[] = new Button[18];
    int A = 0, B = 0, output = 0;
    char opt;

    public calculator() {

        Font f = new Font("Helvetica", Font.PLAIN, 20);

        text = new TextField(20);
        text.setFont(f);
        panel = new Panel();
        add(text, "North");
        add(panel, "Center");
        panel.setLayout(new GridLayout(6,3));

        for (int i = 0; i < 18; i++) {

            btn[i] = new Button(button[i]);
            btn[i].setFont(f);
            btn[i].setForeground(Color.white);
            btn[i].setBackground(Color.black);
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        String str = ae.getActionCommand();

        if (str.equals("+")) {
            try {
                opt = '+';
                A = Integer.parseInt(text.getText());
                text.setText("");
            } catch (NumberFormatException f) {
                text.setText("Invalid Format");
                return;
            }
        } else if (str.equals("-")) {
            try {
                opt = '-';
                A = Integer.parseInt(text.getText());
                text.setText("");
            } catch (NumberFormatException f) {
                text.setText("Invalid Format");
                return;
            }
        } else if (str.equals("*")) {
            try {
                opt = '*';
                A = Integer.parseInt(text.getText());
                text.setText("");
            } catch (NumberFormatException f) {
                text.setText("Invalid Format");
                return;
            }
        } else if (str.equals("/")) {
            try {
                opt = '/';
                A = Integer.parseInt(text.getText());
                text.setText("");
            } catch (NumberFormatException f) {
                text.setText("Invalid Format");
                return;
            }
        } else if (str.equals("=")) {
            try {

                B = Integer.parseInt(text.getText());
            } catch (NumberFormatException f) {
                text.setText("INSERT NUMBERS FIRST");
                return;
            }
           
            switch (opt) {

                case '+':
                    output = A + B;
                    break;
                case '-':
                    output = A - B;
                    break;
                case '*':
                    output = A * B;
                    break;
                case '/':
                    output = A / B;
                    break;
            }
            text.setText(output + "");
            output = 0;
           
        } else if (str.equals("CL")) {
            text.setText("");
            A = B = 0;
            output = 0;
        }else if (str.equals("C")) {
            text.setText("");
        }
        else if (str.equals("BACK")) {
            String z, t;
            t = text.getText();
            try {
                z = t.substring(0, t.length() - 1);
            } catch (StringIndexOutOfBoundsException f) {
                return;
            }
            text.setText(z);
        } else {
            text.setText(text.getText() + str);
        }
    }

    public static void main(String args[]) {

        calculator m = new calculator();
        m.setTitle("Calculator by Abdulaziiz");
        m.setLocation(400,100);
        m.setSize(400, 550);
        m.setBackground(Color.BLACK);
        m.setForeground(Color.gray);
        m.setVisible(true);
    }
}
