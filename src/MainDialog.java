import org.dcm4che3.tool.storescu.StoreSCU;

import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField pathTextField;
    private JTextField dstTextField;
    private JTextPane textPane1;
    Properties properties = new Properties();

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
 /*       getRootPane().setDefaultButton(buttonOK);
        try {
            properties.load(new FileInputStream("prop.properties"));
        }
        catch(IOException e)
        {

        }
 */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
 //       dispose();
        String[] args = new String[]{"-c", dstTextField.getText(), pathTextField.getText() };
        StoreSCU.main(args);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
/*        if(args.length!=2)
        {
            System.out.println("Использование: JStoreScu destination (AETitle@Ip:Port) path (/Path to Dicom Images Folder)");
            return;
        }
        dialog.dstTextField.setName(args[0]);
   */
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
