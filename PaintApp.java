

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paintapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
/**
 *
 * @author ASUS
 */
public class PaintApp extends JFrame implements ActionListener {
    // Declare variables for text boxes, buttons, and labels
    private final JTextField lengthField;
    private final JTextField widthField;
    private final JTextField heightField;
    private final JTextField wallAreaField;
    private final JTextField tinsNeededField;
    private final JTextField totalCostField;
    private final JTextField valueAddedTaxField;
    private final JTextField changeField;
    private final JButton calculateButton;
    private final JButton clearButton;
    private final JLabel lengthLabel;
    private final JLabel widthLabel;
    private final JLabel heightLabel;
    private final JLabel wallAreaLabel;
    private final JLabel tinsNeededLabel;
    private final JLabel totalCostLabel;
    private final JLabel valueAddedTaxLabel;
    private final JLabel changeLabel;
    
     public PaintApp() {
        // Set up the graphical user interface
        setTitle("PaintApp");
        setSize(400, 300);
        setLayout(new GridLayout(10, 2));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        lengthLabel = new JLabel("Length (meters):");
        add(lengthLabel);
        lengthField = new JTextField();
        add(lengthField);

        widthLabel = new JLabel("Width (meters):");
        add(widthLabel);
        widthField = new JTextField();
        add(widthField);

        heightLabel = new JLabel("Height (meters):");
        add(heightLabel);
        heightField = new JTextField();
        add(heightField);

        wallAreaLabel = new JLabel("Wall Area (square meters):");
        add(wallAreaLabel);
        wallAreaField = new JTextField();
        wallAreaField.setEditable(false);
        add(wallAreaField);

        tinsNeededLabel = new JLabel("Tins Needed:");
        add(tinsNeededLabel);
        tinsNeededField = new JTextField();
        tinsNeededField.setEditable(false);
        add(tinsNeededField);

        totalCostLabel = new JLabel("Total Price incl VAT(R) :");
        add(totalCostLabel);
        totalCostField = new JTextField();
        totalCostField.setEditable(false);
        add(totalCostField);

        valueAddedTaxLabel = new JLabel("VAT(R)  :");
        add(valueAddedTaxLabel);
        valueAddedTaxField = new JTextField();
        valueAddedTaxField.setEditable(false);
        add(valueAddedTaxField);

        changeLabel = new JLabel("Change(R) :");
        add(changeLabel);
        changeField = new JTextField();
        changeField.setEditable(false);
        add(changeField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        
        
       
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            // Calculate the wall area, tins of paint needed, total cost, and value-added tax
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            double wallArea = length * width * 2 + width * height * 2 + height * length * 2;
            double tinsNeeded = Math.ceil(wallArea / 10);
            double paintPrice = 30.0;
            double valueAddedTax = tinsNeeded * paintPrice * 0.15;
            double totalCost = tinsNeeded * paintPrice + valueAddedTax;

// Output the total cost with VAT included
System.out.println("Total cost with VAT: " + totalCost);

            // Display the results
            wallAreaField.setText(String.format("%.2f", wallArea));
            tinsNeededField.setText(String.valueOf((int) tinsNeeded));
            totalCostField.setText(String.format("%.2f", totalCost));
            valueAddedTaxField.setText(String.format("%.2f", valueAddedTax));

            // Calculate and display the change
            double amount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Amount:"));
            double change = amount - totalCost ;
            changeField.setText(String.format("%.2f", change));
            
        } else if (e.getSource() == clearButton) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers only");
            // Clear all the text fields
            lengthField.setText("");
            widthField.setText("");
            heightField.setText("");
            wallAreaField.setText("");
            tinsNeededField.setText("");
            totalCostField.setText("");
            valueAddedTaxField.setText("");
            changeField.setText("");
        }
    }
    public static void main(String[] args) {
       PaintApp app = new PaintApp();
    }
    
}
