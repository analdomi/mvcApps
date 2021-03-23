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
import java.util.Arrays;
import javax.swing.*;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    public static int FRAME_WIDTH = 800;
    public static int FRAME_HEIGHT = 455;

    private Model model;
    private View view;
    private AppFactory factory;

    protected JPanel controlPanel;

    private JFrame frame;

    public AppPanel(AppFactory factory) {
        this.factory = factory;
        this.model = this.factory.makeModel();
        this.view = this.factory.makeView(this.model);
        controlPanel = new JPanel();

        add(controlPanel);
        add(view);

        frame = new JFrame();
        setLayout((new GridLayout(1, 2)));
        controlPanel.setBackground(Color.pink);
        Container cp = frame.getContentPane();
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(this.factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
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

    protected void handleException(Exception e) {
        Utilities.error(e);
    }

    // Ask the user if they want to save any unsaved changes.
    private void askToSaveChanges() {
        if(model.unsavedChanges) {
            boolean saveChanges = Utilities.confirm("Would you like to save your changes?");
            if(saveChanges) {
                if(model.fileName != null) {
                    Utilities.save(model, false);
                } else {
                    Utilities.save(model, true);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();
        if (cmmd == "Save") {
            if(model.fileName != null) {
                Utilities.save(model, false);
            }
            else {
                Utilities.save(model, true);
            }
        } else if (cmmd == "SaveAs") {
            Utilities.save(model, true);
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
            model = factory.makeModel();
            view.setModel(model);
            model.fileName = null;
            model.unsavedChanges = false;
        } else if (cmmd == "Quit") {
            askToSaveChanges();
            System.exit(1);
        } else if (cmmd == "About") {
            Utilities.inform(factory.about());
        } else if (cmmd == "Help") {
            Utilities.inform(factory.getHelp());
        } else {
            factory.makeEditCommand(model, cmmd).execute();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
