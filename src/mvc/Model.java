package mvc;

public class Model extends Bean {
    public boolean unsavedChanges = false;
    public String fileName = null;

    public void changed() {
        unsavedChanges = true;
        firePropertyChange();
    }
}
