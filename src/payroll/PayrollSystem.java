package payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PayrollSystem extends JFrame {
    private ArrayList<payroll.Employee> employees;
    private JTextField nameField, idField, salaryField, bonusField;
    private JTextArea employeeListArea;

    public PayrollSystem() {
        employees = new ArrayList<>();

        // Setup JFrame
        setTitle("Payroll System");
        setSize(400, 500);  // Reduced size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Main layout
        setLayout(new BorderLayout(10, 10));

        // Employee details panel (form for inputs)
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new GridBagLayout());
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        JLabel idLabel = new JLabel("Employee ID:");
        idField = new JTextField(15);
        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField(15);
        JLabel bonusLabel = new JLabel("Bonus (Manager Only):");
        bonusField = new JTextField(15);

        // Add labels and fields to the employee panel
        employeePanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        employeePanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        employeePanel.add(idLabel, gbc);
        gbc.gridx = 1;
        employeePanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        employeePanel.add(salaryLabel, gbc);
        gbc.gridx = 1;
        employeePanel.add(salaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        employeePanel.add(bonusLabel, gbc);
        gbc.gridx = 1;
        employeePanel.add(bonusField, gbc);

        // Button panel for Add Employee button
        JPanel buttonPanel = new JPanel();
        JButton addEmployeeButton = new JButton("Add Employee");
        buttonPanel.add(addEmployeeButton);

        // Panel for employee list
        JPanel employeeListPanel = new JPanel();
        employeeListPanel.setLayout(new BorderLayout());
        employeeListPanel.setBorder(BorderFactory.createTitledBorder("Employee List"));

        employeeListArea = new JTextArea(10, 30);
        employeeListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeListArea);
        employeeListPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        add(employeePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(employeeListPanel, BorderLayout.SOUTH);

        // ActionListener for Add Employee button
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();
                double salary = 0;
                try {
                    salary = Double.parseDouble(salaryField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PayrollSystem.this, "Invalid salary input.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double bonus = 0;
                if (!bonusField.getText().isEmpty()) {
                    try {
                        bonus = Double.parseDouble(bonusField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(PayrollSystem.this, "Invalid bonus input.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Add employee to the list
                if (bonus == 0) {
                    payroll.RegularEmployee employee = new payroll.RegularEmployee(name, id, salary);
                    employees.add(employee);
                } else {
                    payroll.Manager manager = new payroll.Manager(name, id, salary, bonus);
                    employees.add(manager);
                }

                // Update employee list display
                updateEmployeeList();
            }
        });
    }

    // Update the list of employees displayed in the JTextArea
    private void updateEmployeeList() {
        employeeListArea.setText("");
        for (payroll.Employee emp : employees) {
            employeeListArea.append(emp.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PayrollSystem().setVisible(true);
            }
        });
    }
}
