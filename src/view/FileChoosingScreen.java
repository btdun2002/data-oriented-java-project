package view;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.Util.StaticTexts;

public class FileChoosingScreen extends JFileChooser {
    File choosenFile = null;
    int response = this.showOpenDialog(null);
    private boolean approved;
    private boolean canceled;

    public FileChoosingScreen() {
        // Set the current directory as one that will be opened by calling super().
        super(new File(System.getProperty("user.dir")));

        // Restrict the file type to .csv.
        this.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv", "comma-seperated");
        this.setFileFilter(restrict);
        this.addChoosableFileFilter(restrict);

        // The if-else statement to validate that the user choosed a file in the
        // directory.
        if (response == JFileChooser.APPROVE_OPTION) {
            approved = true;
        } else if (response == JFileChooser.CANCEL_OPTION) {
            canceled = true;
        }

        if (this.response == JFileChooser.APPROVE_OPTION && this.getSelectedFile() != null) {
            File file = new File(this.getSelectedFile().getAbsolutePath());
            this.choosenFile = file;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), StaticTexts.noChoosingCSV,
                    "Lỗi",
                    JOptionPane.NO_OPTION);
            this.choosenFile = null;
        }
    }

    // The getFile() method return the path of the choosen file, which will be used
    // for multiple
    // operations in the future.
    public File getFile() {
        return this.choosenFile;
    }

    public boolean getCanceled() {
        return canceled;
    }

    public boolean getApproved() {
        return approved;
    }
}
