import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class monedas {
    private JTextField origenTF;
    private JTextField destinoTF;
    private JButton convertirBTN;
    private JComboBox origenCB;
    private JComboBox destinoCB;
    private JLabel origenTxt;
    private JLabel destinoTxt;
    private JLabel auxiliarTxt;
    private JPanel mainPanel;

    public monedas() {
        origenCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //SI CAMBIA DE DIVISA ORIGEN, MUESTRA LA DIVISA ELEGIDA
                auxiliarTxt.setText(""+origenCB.getSelectedItem()+"-"+destinoCB.getSelectedItem());
            }
        });
        destinoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//SI CAMBIA DE DIVISA DESTINO, MUESTRA LA DIVISA ELEGIDA
                auxiliarTxt.setText(""+origenCB.getSelectedItem()+"-"+destinoCB.getSelectedItem());
            }
        });
        convertirBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double tarifasSeleccionada, resultado;
                //ORDEN DE ARREGLO DE TARIFAS = {MXN, COP, CLP, EUR, USD} PARA CADA DIVISA ORIGEN
                if (origenCB.getSelectedItem()=="USD"){ //USD (Dólares Estadounidense)
                    double[] tarifas={2037.20,429833,90275,98.09,100};
                    tarifasSeleccionada = tarifas[destinoCB.getSelectedIndex()];
                    resultado = Double.parseDouble(origenTF.getText())*tarifasSeleccionada/100;
                    destinoTF.setText(""+resultado);
                }
                else if (origenCB.getSelectedItem()=="MXN"){//MXN (Pesos Mexicanos)
                    double[] tarifas={100,21113.84,4427.08,4.81,4.91};
                    tarifasSeleccionada = tarifas[destinoCB.getSelectedIndex()];
                    resultado = Double.parseDouble(origenTF.getText())*tarifasSeleccionada/100;
                    destinoTF.setText(""+resultado);
                }
                else if (origenCB.getSelectedItem()=="COP") {//COP (Pesos Colombianos)
                    double[] tarifas={0.46,100,20.58,0.022,0.023};
                    tarifasSeleccionada = tarifas[destinoCB.getSelectedIndex()];
                    resultado = Double.parseDouble(origenTF.getText())*tarifasSeleccionada/100;
                    destinoTF.setText(""+resultado);
                }
                else if (origenCB.getSelectedItem()=="CLP"){//CLP (Pesos Chilenos)
                    double[] tarifas={2.26,476.12,100,0.11,0.11};
                    tarifasSeleccionada = tarifas[destinoCB.getSelectedIndex()];
                    resultado = Double.parseDouble(origenTF.getText())*tarifasSeleccionada/100;
                    destinoTF.setText(""+resultado);
                }
                else if (origenCB.getSelectedItem()=="EUR") {//EUR (Euro)
                    double[] tarifas={2081.41,438773.53,92161.91,100,102.08};
                    tarifasSeleccionada = tarifas[destinoCB.getSelectedIndex()];
                    resultado = Double.parseDouble(origenTF.getText())*tarifasSeleccionada/100;
                    destinoTF.setText(""+resultado);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DIVISAS");
        frame.setContentPane(new monedas().mainPanel);
        frame.setTitle("CONVERSOR DE DIVISAS");
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
