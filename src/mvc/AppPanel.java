package mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    private Model model;
    private View view;
    private AppFactory factory;

    protected JPanel controlPanel;

    private JFrame frame;

    public AppPanel(AppFactory factory) {
        this.factory = factory;
        controlPanel = new JPanel();

        frame = new JFrame();
        Container cp = frame.getContentPane();
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.add(this);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New",  "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public void display() { frame.setVisible(true); }

    // Save model, prompt user for a file name
    private void saveFileAs() {
        ObjectOutputStream os = null;
        try {
            String fName = Utilities.getFileName(null, false);
            os = new ObjectOutputStream(new FileOutputStream(fName));
            os.writeObject(model);
            os.close();
            model.fileName = fName;
            model.unsavedChanges = false;
        } catch (Exception err) {
            if(os != null) Utilities.error(err);
        }
    }

    // Save model to currentFileName
    private void saveFile() {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(model.fileName));
            os.writeObject(model);
            os.close();
            model.unsavedChanges = false;
        } catch (Exception err) {
            if(os != null) Utilities.error(err);
        }
    }

    // Ask the user if they want to save any unsaved changes.
    private void askToSaveChanges() {
        if(model.unsavedChanges) {
            boolean saveChanges = Utilities.confirm("Would you like to save your changes?");
            if(saveChanges) {
                if(model.fileName != null) {
                    saveFile();
                } else {
                    saveFileAs();
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();
        if (cmmd == "Save") {
            if(model.fileName != null) {
                saveFile();
            }
            else {
                saveFileAs();
            }
        } else if (cmmd == "SaveAs") {
            saveFileAs();
        } else if (cmmd == "Open") {
            ObjectInputStream is = null;
            try {
                askToSaveChanges();
                String fName = Utilities.getFileName(null, true);
                is = new ObjectInputStream(new FileInputStream(fName));
                model = (Model)is.readObject();
                view.setModel(model);
                is.close();
                model.fileName = fName;
                model.unsavedChanges = false;

            } catch (Exception err) {
                if(is != null) Utilities.error(err.getMessage());
            }
        } else if (cmmd == "New") {
            askToSaveChanges();
            model = new Model();
            view.setModel(model);
            model.fileName = null;
            model.unsavedChanges = false;
        } else if (cmmd == "Quit") {
            askToSaveChanges();
            System.exit(1);
        } else if (cmmd == "About") {
            Utilities.inform(factory.getTitle());
        } else if (cmmd == "Help") {
            Utilities.inform(factory.getHelp());
        }
    }
}
