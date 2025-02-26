package TesouroGame.Control;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

public class LevelManager {
    Gson gson = new Gson();
    Reader reader = new FileReader("LevelConfig.JSON");

    public LevelManager() throws FileNotFoundException {
        System.out.println("erro arquivo não encontrado");
    }
}
