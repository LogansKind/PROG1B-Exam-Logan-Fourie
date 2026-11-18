import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 15));

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mnuExit = new JMenuItem("Exit");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");
        mnuFile.add(mnuExit);
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        // Controls - Q2.2
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[]{
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        });
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        add(btnProcess);

        // Actions
        btnProcess.addActionListener(e -> processSale());
        mnuProcess.addActionListener(e -> processSale());
        mnuExit.addActionListener(e -> System.exit(0));
        mnuClear.addActionListener(e -> clearForm());
    }

    // Process Logic
    private void processSale() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Show Message Dialog
            String message = "Customer Name: " + customer +
                    "\nProduct: " + product +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
                out.println("DATA LOG");
                out.println("******************************************");
                out.println("Customer Name: " + customer);
                out.println("Product: " + product);
                out.println("VAT: R " + vat);
                out.println("COMMISSION: R " + commission);
                out.println("TOTAL: R " + total);
                out.println("******************************************");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Clear
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}