package mvc;

public abstract class Model extends Bean {
    public boolean unsavedChanges = false;
    public String fileName = null;

    public void changed() {
        unsavedChanges = true;
        firePropertyChange("model", 0, 1);
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean c) {
        unsavedChanges = c;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }
}