package myCalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainFrame extends JFrame {

    private TextPanel calcArea;
    private NumberPanel numberButtons;
    private ResultPanel resultArea;
    private OptionsPanel options;
    private OperatorsPanel operatorsPanel;
    private JButton submitButton;

    private StringBuilder sb;

    public MainFrame(String title) {

        super(title);

        calcArea = new TextPanel();
        numberButtons = new NumberPanel();
        resultArea = new ResultPanel();
        options = new OptionsPanel();
        operatorsPanel = new OperatorsPanel();
        submitButton = new JButton("Submit");

        sb = new StringBuilder();

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus L&F not found");
        }

        operatorsPanel.setCalculationListener(new CalculationListener() {
            public void encodedCalc(char calculation) {
                calcArea.appendText(calculation);
                sb.append(calculation);
            }
        });

        numberButtons.setCalculationListener(new CalculationListener() {
            public void encodedCalc(char calculation) {
                calcArea.appendText(calculation);
                sb.append(calculation);

            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcArea.clrScr();
                resultArea.clrScr();
                DoWork dw = new DoWork();
                resultArea.appendText(dw.calculate(sb.toString()).toString());
                sb.delete(0, sb.length());
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        /////////ROW 1
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.ipady = 30;
        gc.anchor = GridBagConstraints.NORTH;
        add(calcArea, gc);

        /////////ROW 2
        gc.ipady = 5;
        gc.gridx = 0;
        gc.gridy = 1;
        add(resultArea, gc);

        /////////ROW 3
        gc.gridx = 0;
        gc.gridy = 2;
        add(submitButton, gc);

        /////////ROW 4
        gc.ipady = 0;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 3;
        add(numberButtons, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(operatorsPanel, gc);

        /////////ROW 5
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 4;
        add(options, gc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }
}
