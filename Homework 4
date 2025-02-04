import javax.swing.*;
import java.awt.*;

// Abstract class for sales calculations
abstract class SalesCalculator {
    // Abstract method for calculating sales
    public abstract void calculateSales(JTextField phonePriceField, JTextField phoneQuantityField,
                                        JTextField repairPriceField, JTextField repairHoursField,
                                        JLabel phoneTotalLabel, JLabel repairTotalLabel);
}

// Main class extending SalesCalculator
public class Main extends JFrame {
    private final JTextField phonePriceField;
    private final JTextField phoneQuantityField;
    private final JTextField repairPriceField;
    private final JTextField repairHoursField;
    private final JLabel phoneTotalLabel;
    private final JLabel repairTotalLabel;

    public Main() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        // Phone Sales Input
        JLabel phoneLabel = new JLabel("Phone Sales:");
        phoneLabel.setBounds(20, 20, 100, 20);
        phoneLabel.setForeground(Color.green);
        add(phoneLabel);

        phonePriceField = new JTextField("");
        phonePriceField.setBounds(130, 20, 80, 20);
        phonePriceField.setBackground(Color.black);
        phonePriceField.setForeground(Color.green);
        add(phonePriceField);

        phoneQuantityField = new JTextField("");
        phoneQuantityField.setBounds(220, 20, 80, 20);
        phoneQuantityField.setBackground(Color.black);
        phoneQuantityField.setForeground(Color.green);
        add(phoneQuantityField);

        // Repair Service Input
        JLabel repairLabel = new JLabel("Repair Services:");
        repairLabel.setBounds(20, 60, 120, 20);
        repairLabel.setForeground(Color.green);
        add(repairLabel);

        repairPriceField = new JTextField("");
        repairPriceField.setBounds(150, 60, 80, 20);
        repairPriceField.setBackground(Color.black);
        repairPriceField.setForeground(Color.green);
        add(repairPriceField);

        repairHoursField = new JTextField("");
        repairHoursField.setBounds(240, 60, 80, 20);
        repairHoursField.setBackground(Color.black);
        repairHoursField.setForeground(Color.green);
        add(repairHoursField);

        setPlaceholder(phonePriceField, "Price");
        setPlaceholder(phoneQuantityField, "Quantity");
        setPlaceholder(repairPriceField, "Price/hr");
        setPlaceholder(repairHoursField, "Hours");

        // Calculate Button
        JButton calculateButton = new JButton("Calculate Sales");
        calculateButton.setBounds(100, 100, 200, 30);
        calculateButton.setBackground(Color.green);
        calculateButton.setForeground(Color.black);
        calculateButton.setFocusPainted(false);
        add(calculateButton);

        // Output Labels
        phoneTotalLabel = new JLabel("Phone Sales: ₱0.0");
        phoneTotalLabel.setBounds(20, 150, 200, 20);
        phoneTotalLabel.setForeground(Color.green);
        add(phoneTotalLabel);

        repairTotalLabel = new JLabel("Repair Sales: ₱0.0");
        repairTotalLabel.setBounds(20, 180, 200, 20);
        repairTotalLabel.setForeground(Color.green);
        add(repairTotalLabel);

        // Action Listener for Button
        calculateButton.addActionListener(_ -> new SalesCalculatorImpl().calculateSales(
                phonePriceField, phoneQuantityField, repairPriceField, repairHoursField, phoneTotalLabel, repairTotalLabel));
    }

    private void setPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.GREEN);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
    }

    // Abstract class implementation
    private static class SalesCalculatorImpl extends SalesCalculator {
        @Override
        public void calculateSales(JTextField phonePriceField, JTextField phoneQuantityField,
                                   JTextField repairPriceField, JTextField repairHoursField,
                                   JLabel phoneTotalLabel, JLabel repairTotalLabel) {
            try {
                // Get phone details
                double phonePrice = Double.parseDouble(phonePriceField.getText());
                int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
                double phoneTotal = phonePrice * phoneQuantity;

                // Get repair details
                double repairPrice = Double.parseDouble(repairPriceField.getText());
                int repairHours = Integer.parseInt(repairHoursField.getText());
                double repairTotal = repairPrice * repairHours;

                // Display results
                phoneTotalLabel.setText("Phone Sales: ₱" + phoneTotal);
                repairTotalLabel.setText("Repair Sales: ₱" + repairTotal);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                phoneTotalLabel.setText("Phone Sales: ₱0.0");
                repairTotalLabel.setText("Repair Sales: ₱0.0");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
