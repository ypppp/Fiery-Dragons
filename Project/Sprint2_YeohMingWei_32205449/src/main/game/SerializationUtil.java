package game;

import java.io.*;

public class SerializationUtil {

    public static void saveState(AppState state, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(state);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static AppState loadState(String filename) {
        AppState state = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            state = (AppState) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return state;
    }
}
