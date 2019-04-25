package com.eddyparga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class Ventana extends JFrame {

    public Ventana(){
        this.setTitle("BMI Calculator");
        this.setSize(250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel weightLabel = new JLabel("Peso");
        JTextField weightTextField = new JTextField(10);
        JLabel heightLabel = new JLabel("Altura");
        JTextField heightTextField = new JTextField(10);

        ButtonGroup options = new ButtonGroup();
        JRadioButton metricButton = new JRadioButton("Sistema Metrico");
        JRadioButton imperialButton = new JRadioButton("Sistema Imperial");

        final JTextField[] BMI = {new JTextField(20)};
        BMI[0].setEditable(false);
        JTextField rango = new JTextField(20);
        rango.setEditable(false);

        JButton calcularBMI = new JButton("Calcular");
        JButton borrar = new JButton("Borrar");

        metricButton.setSelected(true);

        Box peso = Box.createHorizontalBox();
        peso.add(weightLabel);
        peso.add(weightTextField);

        Box altura = Box.createHorizontalBox();
        altura.add(heightLabel);
        altura.add(heightTextField);

        Box radio = Box.createVerticalBox();
        options.add(metricButton);
        radio.add(metricButton);
        options.add(imperialButton);
        radio.add(imperialButton);

        Box resultados = Box.createVerticalBox();
        resultados.add(BMI[0]);
        resultados.add(rango);

        Box botones = Box.createHorizontalBox();
        botones.add(calcularBMI);
        botones.add(borrar);

        Box top = Box.createVerticalBox();
        top.add(peso);
        top.add(altura);
        top.add(radio);
        top.add(resultados);

        Container container = this.getContentPane();

        container.setLayout(new BorderLayout());
        container.add(top, BorderLayout.NORTH);
        container.add(botones, BorderLayout.SOUTH);


        metricButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightTextField.setText("Escribe tu altura en metros.");
                weightTextField.setText("Escribe tu peso en kilogramos.");
            }
        });

        imperialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightTextField.setText("Escribe tu altura en pies.");
                weightTextField.setText("Escribe tu peso en libras.");
            }
        });

        /*BMI[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double w;
                double h;
                double result;
                w=Double.parseDouble(String.valueOf(weightTextField));
                h=Double.parseDouble(String.valueOf(heightTextField));
                if (e.getSource()==metricButton){
                    result=w/Math.pow(h,2);
                } else {
                    w /= 2.20462;
                    h /= 3.28;
                    result=w/Math.pow(h,2);
                }
                if(e.getSource()==calcularBMI){

                }
                JTextField r = new JTextField(String.valueOf(result));
                BMI[0] = r;
                BMI[0].setText(String.valueOf(r));
            }
        });*/

        /*rango.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BMI[0].setText(String.valueOf(r) < 18.5)) {
                    rango.setText("Bajo");
                } else if (BMI >= 18.5 && BMI <= 24.9){
                    rango.setText("Normal");
                } else if (BMI >= 25.0 && BMI <= 29.9) {
                    rango.setText("Sobrepeso");
                } else if (BMI >= 30.0) rango.setText("Obeso");
            }
        });*/

        calcularBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==calcularBMI){
                    double w;
                    double h;
                    double result;
                    w=Double.parseDouble(weightTextField.getText());
                    h=Double.parseDouble(heightTextField.getText());
                    if (e.getSource()==metricButton){
                        result=w/Math.pow(h,2);
                    } else {
                        w /= 2.20462;
                        h /= 3.28;
                        result=w/Math.pow(h,2);
                    }
                    JTextField r = new JTextField(valueOf(result));
                    StringBuffer rr = new StringBuffer(10);
                    rr.append(r);
                    String re= rr.toString();
                    BMI[0] = r;
                    //BMI[0].setText(valueOf(r));
                    BMI[0].setText(String.valueOf(re));

                    if (result < 18.5) {
                        rango.setText("Bajo");
                    } else if (result >= 18.5 && result <= 24.9) {
                        rango.setText("Normal");
                    } else if (result >= 25.0 && result <= 29.9) {
                        rango.setText("Sobrepeso");
                    } else if (result >= 30.0) rango.setText("Obeso");
                }
            }
        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==borrar){
                    weightTextField.setText("");
                    heightTextField.setText("");
                    BMI[0].setText("");
                    rango.setText("");
                }
            }
        });



        this.setVisible(true);
    }
}
