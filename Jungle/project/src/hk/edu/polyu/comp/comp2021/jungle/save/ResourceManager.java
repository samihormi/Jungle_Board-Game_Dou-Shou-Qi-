package hk.edu.polyu.comp.comp2021.jungle.save;
import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Saves the game into a file
 */
public class ResourceManager {
    /**
     *
     * @param data game
     * @param fileName name of file
     * @throws Exception
     */
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
            JOptionPane.showMessageDialog(null,"successfully saved");
        }
    }

    /**
     *
     * @param fileName name of file
     * @return saved game file
     * @throws Exception
     */
    public static Object load(String fileName) throws Exception {
        JFileChooser jfc = new JFileChooser(".");
        int status=jfc.showOpenDialog(null);
        if(status==JFileChooser.APPROVE_OPTION){
            System.out.println(jfc.getSelectedFile().getName());
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(jfc.getSelectedFile().getName())))) {
                return ois.readObject();
            }
        }
        return null;
    }
}