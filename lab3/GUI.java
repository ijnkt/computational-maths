import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI extends JFrame {

    Data data = new Data();
    ChartPanel curPanel;

    public GUI(){
        super("Лабораторная #3");
        setBounds(190, 30, 1000, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel label_m = new JLabel("Выберите метод");
        JLabel label_eq = new JLabel("Выберите уравнение");
        JCheckBox subtitle1 = new JCheckBox("Решение нелинейных \nуравнений");
        JCheckBox subtitle2 = new JCheckBox("Решение систем \nнелинейных уравнений");
        subtitle1.setBounds(10, 5, 200, 30);
        JLabel text1a = new JLabel("Левая граница");
        JLabel text1b = new JLabel("Правая граница");
        JTextField a = new JTextField();
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Data.a = Double.parseDouble(((JTextField)e.getSource()).getText());
                } catch (NumberFormatException n){}

            }
        });
        JTextField b = new JTextField();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Data.b = Double.parseDouble(((JTextField)e.getSource()).getText());
                } catch (NumberFormatException n){}

            }
        });
        a.setBounds(120, 160, 90, 20);
        b.setBounds(120, 190, 90, 20);
        text1a.setBounds(10, 160, 100, 20);
        text1b.setBounds(10, 190, 100, 20);
        JTextArea warning1 = new JTextArea();
        warning1.setBounds(10, 250, 200, 52);
        warning1.setVisible(false);
        add(warning1);
        JTextArea warning2 = new JTextArea();
        warning2.setBounds(10, 550, 200, 66);
        warning2.setVisible(false);
        add(warning2);
        JLabel text_prec1 = new JLabel("Точность");
        text_prec1.setBounds(10, 220, 100, 20 );
        JTextField prec1 = new JTextField();
        prec1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.precision = Double.parseDouble((prec1).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.precision = Double.parseDouble((prec1).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        a.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.a = Double.parseDouble((a).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.a = Double.parseDouble((a).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        b.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.b = Double.parseDouble((b).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.b = Double.parseDouble((b).getText());
                    warning1.setVisible(false);
                } catch (NumberFormatException n){
                    warning1.setText("Неверный формат ввода!");
                    warning1.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        prec1.setBounds(120, 220, 90, 20);
        a.setVisible(false); b.setVisible(false); text1a.setVisible(false); text1b.setVisible(false); text_prec1.setVisible(false); prec1.setVisible(false);
        add(a);
        add(b);
        add(text1a);
        add(text1b);
        add(text_prec1);
        add(prec1);
        JTextField a_ = new JTextField();
        a_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Data.a = Double.parseDouble(((JTextField)e.getSource()).getText());
                } catch (NumberFormatException n){}

            }
        });
        JTextField b_ = new JTextField();
        b_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Data.b = Double.parseDouble(((JTextField)e.getSource()).getText());
                } catch (NumberFormatException n){}

            }
        });
        a_.setBounds(120, 460, 90, 20);
        b_.setBounds(120, 490, 90, 20);
        a_.setVisible(false); b_.setVisible(false);
        JLabel text2a = new JLabel("Введите х");
        JLabel text2b = new JLabel("Введите у");
        text2a.setBounds(10, 460, 100, 20);
        text2b.setBounds(10, 490, 100, 20);
        text2a.setVisible(false); text2b.setVisible(false);
        JLabel text_prec2 = new JLabel("Точность");
        JTextField prec2 = new JTextField();
        prec2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Data.precision = Double.parseDouble(((JTextField)e.getSource()).getText());
                } catch (NumberFormatException n){}

            }
        });
        text_prec2.setBounds(10, 520, 100, 20);
        prec2.setBounds(120, 520, 90, 20 );
        text_prec2.setVisible(false);
        prec2.setVisible(false);
        add(a_);
        add(b_);
        add(text2a);
        add(text2b);
        add(text_prec2);
        add(prec2);
        JButton all_methods = new JButton("Решить обоими методами");
        all_methods.setBounds(180, 620, 200, 20);
        all_methods.setVisible(false);
        add(all_methods);
        JTextArea answers = new JTextArea();
        answers.setBounds(380, 620, 400, 50);
        answers.setVisible(false);
        add(answers);
        prec2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.precision = Double.parseDouble((prec2).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.precision = Double.parseDouble((prec2).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        a_.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.x = Double.parseDouble((a_).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.x = Double.parseDouble((a_).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        b_.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    Data.y = Double.parseDouble((b_).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    Data.y = Double.parseDouble((b_).getText());
                    warning2.setVisible(false);
                } catch (NumberFormatException n){
                    warning2.setText("Неверный формат ввода!");
                    warning2.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        ActionListener handler1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (subtitle1.isSelected()) {
                    Data.systems = false;
                    subtitle2.setSelected(false);
                    a.setVisible(true);
                    b.setVisible(true);
                    text1a.setVisible(true);
                    text1b.setVisible(true);
                    text_prec1.setVisible(true);
                    prec1.setVisible(true);
                    all_methods.setVisible(true);
                    a_.setVisible(false); b_.setVisible(false);
                    text2a.setVisible(false); text2b.setVisible(false);
                    text_prec2.setVisible(false); prec2.setVisible(false);
                    warning2.setVisible(false);
                    makePlot();
                }
                else {
                    a.setVisible(false);
                    b.setVisible(false);
                    text1a.setVisible(false);
                    text1b.setVisible(false);
                    text_prec1.setVisible(false);
                    prec1.setVisible(false);
                    warning1.setVisible(false);
                    all_methods.setVisible(false);
                    answers.setVisible(false);
                }
            }
        };
        subtitle1.addActionListener(handler1);
        add(subtitle1);
        label_m.setBounds(10,  38, 100, 30);
        label_eq.setBounds(10, 100, 200, 30);
        add(label_m);
        add(label_eq);
        String[] methods = {"Метод половинного деления", "Метод хорд"};
        String[] equations = {"y = sin(x + 0.15 * x^2)", "y = 0.72 * x^4 - 5.3 * x^2 + x + 2"};
        JComboBox comboBox_m = new JComboBox(methods);
        comboBox_m.setSelectedItem(methods[0]);
        answers.setBounds(400, 620, 400, 50);
        answers.setVisible(false);
        add(answers);
        all_methods.addActionListener((e) -> {
            Data.both = true;
            warning1.setVisible(false);
            Solution.solve();
            makePlot();
            if (Solution.hasSolution) {
                addSolution(Solution.res_chordus, Solution.res_halves);
                answers.setText("МПД: х = " + String.format("%.6f", Solution.res_halves) + " за " + Solution.iteration_halves + " итераций.\n" +
                         "МX: х = " + String.format("%.6f", Solution.res_chordus) + " за " + Solution.iteration_chordus + " итераций.");
                answers.setVisible(true);
            }
            else{
                answers.setText("Выберите другие границы");
                answers.setVisible(true);
            }
        });
        ActionListener handler_m = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox j = (JComboBox)e.getSource();
                if ("Метод хорд".equals(j.getSelectedItem())){
                    Data.methodName = "Метод хорд";
                }
                if ("Метод половинного деления".equals(j.getSelectedItem())){
                    Data.methodName = "Метод половинного деления";
                }
            }
        };
        JComboBox comboBox_eq = new JComboBox(equations);
        comboBox_eq.setSelectedItem(equations[0]);
        ActionListener handler_eq = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data.equationStr = (String)comboBox_eq.getSelectedItem();
                makePlot();
            }
        };
        comboBox_eq.addActionListener(handler_eq);
        comboBox_m.addActionListener(handler_m);
        comboBox_m.setBounds(10, 68, 200, 20);
        comboBox_eq.setBounds(10, 130, 200, 20);
        add(comboBox_m);
        add(comboBox_eq);
        subtitle2.setBounds(10, 300, 200, 30);
        ActionListener handler2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (subtitle2.isSelected()) {
                    Data.systems = true;
                    subtitle1.setSelected(false);
                    a_.setVisible(true);
                    b_.setVisible(true);
                    text2a.setVisible(true);
                    text2b.setVisible(true);
                    text_prec2.setVisible(true);
                    prec2.setVisible(true);
                    a.setVisible(false); b.setVisible(false);
                    text1a.setVisible(false); text1b.setVisible(false);
                    text_prec1.setVisible(false); prec1.setVisible(false);
                    warning1.setVisible(false);
                    all_methods.setVisible(false);
                    answers.setVisible(false);
                    makePlot();
                }
                else {
                    a_.setVisible(false);
                    b_.setVisible(false);
                    text2a.setVisible(false);
                    text2b.setVisible(false);
                    text_prec2.setVisible(false);
                    prec2.setVisible(false);
                    warning2.setVisible(false);

                }

            }
        };
        subtitle2.addActionListener(handler2);
        add(subtitle2);
        JButton button = new JButton("Решить");
        button.setBounds(50, 620, 120, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Solution.solve();
                makePlot();
                if (!Data.systems) {
                    if (Solution.hasSolution) addSolution(Solution.doubleRes);
                    warning1.setText(Solution.res);
                    warning1.setVisible(true);
                    answers.setVisible(false);
                }
                else {
                    if (Solution.hasSolution) addSystemSolution(Solution.doubleResX, Solution.doubleResY);
                    warning2.setText(Solution.res);
                    warning2.setVisible(true);
                    answers.setVisible(false);
                }
            }
        });
        add(button);
        JLabel s_label1 = new JLabel("Выберите 1 уравнение");
        String[] system1 = {"y - 0.3*x^3 = 0", "4*x^2 - y - 3 = 0"};
        JComboBox comboBox1 = new JComboBox(system1);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("y - 0.3*x^3 = 0".equals(comboBox1.getSelectedItem())){
                    Data.equation1Str = "y - 0.3*x^3 = 0";
                    Data.system[0] = Data.equation1;
                    Data.JFunction[0][0] = Data.der_1_x;
                    Data.JFunction[0][1] = Data.der_1_y;
                    Data.equationsForPlot[0] = Data.eqForPlot1;
                    makePlot();
                }
                if ("4*x^2 - y - 3 = 0".equals(comboBox1.getSelectedItem())){
                    Data.equation1Str = "4*x^2 - y - 3 = 0";
                    Data.system[0] = Data.equation2;
                    Data.JFunction[0][0] = Data.der_2_x;
                    Data.JFunction[0][1] = Data.der_2_y;
                    Data.equationsForPlot[0] = Data.eqForPlot2;
                    makePlot();
                }
            }
        });
        String[] system2 = {"y - e^(-x) = 0", "sin(x) - y = 0"};
        JComboBox comboBox2 = new JComboBox(system2);
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("y - e^(-x) = 0".equals(comboBox2.getSelectedItem())){
                    Data.equation2Str = "y - e^(-x) = 0";
                    Data.system[1] = Data.equation3;
                    Data.JFunction[1][0] = Data.der_3_x;
                    Data.JFunction[1][1] = Data.der_3_y;
                    Data.equationsForPlot[1] = Data.eqForPlot3;
                    makePlot();
                }
                if ("sin(x) - y = 0".equals(comboBox2.getSelectedItem())){
                    Data.equation2Str = "sin(x) - y = 0";
                    Data.system[1] = Data.equation4;
                    Data.JFunction[1][0] = Data.der_4_x;
                    Data.JFunction[1][1] = Data.der_4_y;
                    Data.equationsForPlot[1] = Data.eqForPlot4;
                    makePlot();
                }
            }
        });
        JLabel s_label2 = new JLabel("Выберите 2 уравнение");
        s_label1.setBounds(10, 330, 200, 30);
        comboBox1.setBounds(10, 360, 200, 20);
        s_label2.setBounds(10, 390, 200, 30);
        comboBox2.setBounds(10, 420, 200, 20);
        add(s_label1); add(s_label2); add(comboBox1); add(comboBox2);
        makePlot();
        setVisible(true);
    }

    private void addSolution (double solution) {
        XYSeries point = new XYSeries("Solution");
        point.add(solution - data.precision, data.equation.apply(solution - data.precision));
        point.add(solution + data.precision, data.equation.apply(solution + data.precision));
        ((XYSeriesCollection) curPanel.getChart().getXYPlot().getDataset()).addSeries(point);
        curPanel.getChart().getXYPlot().getRenderer().setSeriesStroke(3, new BasicStroke(8.0f));
        curPanel.getChart().getXYPlot().getRenderer().setSeriesPaint(3, Color.ORANGE);
    }

    private void addSolution (double solution1, double solution2) {
            XYSeries point1 = new XYSeries("Solution by chordus");
            XYSeries point2 = new XYSeries("Solution by halves");
            point1.add(solution1 - data.precision, data.equation.apply(solution1 - data.precision));
            point1.add(solution1 + data.precision, data.equation.apply(solution1 + data.precision));
            point2.add(solution2 - data.precision, data.equation.apply(solution2 - data.precision));
            point2.add(solution2+ data.precision, data.equation.apply(solution2 + data.precision));
            ((XYSeriesCollection) curPanel.getChart().getXYPlot().getDataset()).addSeries(point1);
            ((XYSeriesCollection) curPanel.getChart().getXYPlot().getDataset()).addSeries(point2);
            curPanel.getChart().getXYPlot().getRenderer().setSeriesStroke(3, new BasicStroke(8.0f));
            curPanel.getChart().getXYPlot().getRenderer().setSeriesPaint(3, Color.MAGENTA);
            curPanel.getChart().getXYPlot().getRenderer().setSeriesStroke(4, new BasicStroke(8.0f));
            curPanel.getChart().getXYPlot().getRenderer().setSeriesPaint(4, Color.ORANGE);
    }
    private void addSystemSolution (double x, double y) {
        XYSeries point = new XYSeries("Solution");
        point.add(x - Data.precision, y);
        point.add(x, y);
        point.add(x, y + Data.precision);
        point.add(x, y);
        point.add(x + Data.precision, y);
        point.add(x, y);
        point.add(x, y - Data.precision);
        point.add(x, y);
        ((XYSeriesCollection) curPanel.getChart().getXYPlot().getDataset()).addSeries(point);
        curPanel.getChart().getXYPlot().getRenderer().setSeriesStroke(4, new BasicStroke(8.0f));
        curPanel.getChart().getXYPlot().getRenderer().setSeriesPaint(4, Color.MAGENTA);
    }

    public void makePlot() {
        if (!Data.systems) {
            if ("y = sin(x + 0.15 * x^2)".equals(data.equationStr)) {
                data.equation = (x) -> (Math.sin(x + 0.15 * x * x));
                data.leftBound = -6;
                data.rightBound = 6;
                data.topBound = 5;
                data.bottomBound = -5;
            }
            if ("y = 0.72 * x^4 - 5.3 * x^2 + x + 2".equals(data.equationStr)) {
                data.equation = (x) -> (0.72 * Math.pow(x, 4) - 5.3 * x * x + x + 2);
                data.leftBound = -3;
                data.rightBound = 3;
                data.topBound = 20;
                data.bottomBound = -15;
            }
            double step = (data.rightBound - data.leftBound) / data.STEPS;
            double t = data.leftBound - step, yt;
            XYSeries eqSeries = new XYSeries(data.equationStr);
            XYSeries xSeries = new XYSeries("X - axis");
            XYSeries ySeries = new XYSeries("Y - axis");
            for (int i = -1; i < data.STEPS; i++) {
                t += step;
                yt = data.equation.apply(t);
                eqSeries.add(t, yt);
            }
            xSeries.add(data.leftBound - 1, 0);
            xSeries.add(0, 0);
            xSeries.add(data.rightBound + 1, 0);
            ySeries.add(0, data.bottomBound);
            ySeries.add(0, 0);
            ySeries.add(0, data.topBound);
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(xSeries);
            dataset.addSeries(ySeries);
            dataset.addSeries(eqSeries);
            if (curPanel != null) {
                XYPlot plot = curPanel.getChart().getXYPlot();
                final XYItemRenderer renderer = plot.getRenderer();
                renderer.setSeriesPaint(0, Color.BLACK);
                renderer.setSeriesPaint(1, Color.BLACK);
                renderer.setSeriesPaint(2, Color.RED);
                renderer.setSeriesStroke(0, new BasicStroke(1.0f));
                renderer.setSeriesStroke(1, new BasicStroke(1.0f));
                renderer.setSeriesStroke(2, new BasicStroke(1.0f));
                curPanel.getChart().getXYPlot().setDataset(dataset);
                return;
            }
            JFreeChart chart = ChartFactory.createXYLineChart(" ", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);
            XYPlot plot = chart.getXYPlot();
            final XYItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, Color.BLACK);
            renderer.setSeriesPaint(1, Color.BLACK);
            renderer.setSeriesPaint(2, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(1.0f));
            renderer.setSeriesStroke(1, new BasicStroke(1.0f));
            renderer.setSeriesStroke(2, new BasicStroke(1.0f));
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBounds(250, 10, 700, 600);
            curPanel = chartPanel;
            add(chartPanel);
        }
        else {
            double yt1;
            double yt2;
            data.leftBound = -2;
            data.rightBound = 2;
            List<XYSeries> seriesList = new ArrayList<>();
            XYSeries eqSeries1 = new XYSeries(Data.equation1Str);
            XYSeries eqSeries2 = new XYSeries(Data.equation2Str);
            double step = (data.rightBound - data.leftBound) / data.STEPS;
            double t = data.leftBound - step, yt;
            for (int j = -1; j < data.STEPS; j++) {
                t += step;
                yt1 = Data.equationsForPlot[0].apply(t);
                yt2 = Data.equationsForPlot[1].apply(t);
                eqSeries1.add(t, yt1);
                eqSeries2.add(t, yt2);
            }
            seriesList.add(eqSeries1);
            seriesList.add(eqSeries2);
            XYSeries xSeries = new XYSeries("X - axis");
            XYSeries ySeries = new XYSeries("Y - axis");
            xSeries.add(data.leftBound - 1, 0);
            xSeries.add(0, 0);
            xSeries.add(data.rightBound + 1, 0);
            ySeries.add(0, data.bottomBound);
            ySeries.add(0, 0);
            ySeries.add(0, data.topBound);
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(xSeries);
            dataset.addSeries(ySeries);
            seriesList.forEach(dataset::addSeries);
            if (curPanel != null) {
                XYPlot plot = curPanel.getChart().getXYPlot();
                plot.setDataset(dataset);
                final XYItemRenderer renderer = plot.getRenderer();
                renderer.setSeriesPaint(0, Color.BLACK);
                renderer.setSeriesPaint(1, Color.BLACK);
                renderer.setSeriesPaint(2, Color.ORANGE);
                renderer.setSeriesPaint(3, Color.DARK_GRAY);
                renderer.setSeriesStroke(0, new BasicStroke(1.0f));
                renderer.setSeriesStroke(1, new BasicStroke(1.0f));
                renderer.setSeriesStroke(2, new BasicStroke(1.0f));
                renderer.setSeriesStroke(3, new BasicStroke(1.0f));
                return;
            }
            JFreeChart chart = ChartFactory.createXYLineChart(" ", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);
            XYPlot plot = chart.getXYPlot();
            final XYItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, Color.BLACK);
            renderer.setSeriesPaint(1, Color.BLACK);
            renderer.setSeriesPaint(2, Color.ORANGE);
            renderer.setSeriesPaint(3, Color.DARK_GRAY);
            renderer.setSeriesStroke(0, new BasicStroke(1.0f));
            renderer.setSeriesStroke(1, new BasicStroke(1.0f));
            renderer.setSeriesStroke(2, new BasicStroke(1.0f));
            renderer.setSeriesStroke(3, new BasicStroke(1.0f));
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBounds(250, 10, 700, 600);
            curPanel = chartPanel;
            add(chartPanel);
        }
    }
}
