package TesouroGame.Control;

import TesouroGame.Model.TestPlayer;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LevelLoader {
    public static void main(String[] args) throws IOException {
        InputStream is = LevelLoader.class.getResourceAsStream("/LevelConfig.JSON");
        if(is == null){
            System.out.println("caminho N");
        }

        InputStreamReader reader = new InputStreamReader(is);
        Gson gson = new Gson();
        TestPlayer player = new Gson().fromJson(reader, TestPlayer.class);

        System.out.println(player);

    }
}
