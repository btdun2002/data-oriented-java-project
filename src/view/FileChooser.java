package view;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser {
    File choosenFile = null;
    int response = this.showOpenDialog(null);

    public FileChooser() {
        // Set the current directory as one that will be opened by calling super().
        super(new File(System.getProperty("user.dir")));

        // Restrict the file type to .csv.
        this.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv", "comma-seperated");
        this.setFileFilter(restrict);
        this.addChoosableFileFilter(restrict);

        // The if-else statement to validate that the user choosed a file in the
        // directory.
        if (this.response == JFileChooser.APPROVE_OPTION && this.getSelectedFile() != null) {
            File file = new File(this.getSelectedFile().getAbsolutePath());
            this.choosenFile = file;
        } else {
            // JOptionPane.showMessageDialog(new JFrame(), StaticTexts.noChoosingCSV,
            // "Lỗi",
            // JOptionPane.NO_OPTION);

            // FIXME: Required feature to add some kind of notification to tell user about
            // the .csv files
            // as the only acceptable file type. Note that JOptionPane makes program cannot
            // stop.
            this.choosenFile = null;
        }
    }

    // The getFile() method return the path of the choosen file, which will be used
    // for multiple
    // operations in the future.
    public File getFile() {
        return this.choosenFile;
    }
}
