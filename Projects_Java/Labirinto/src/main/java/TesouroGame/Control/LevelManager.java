package TesouroGame.Control;

import TesouroGame.Model.LevelStatus;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

public class LevelManager {
    LevelStatus levelStatus;

    Gson gson = new Gson();

    public LevelManager(){
        try(Reader reader = new FileReader("LevelConfig.JSON")){
            levelStatus = gson.fromJson(reader, LevelStatus.class);
        }catch(FileNotFoundException e){
            System.out.println("Erro ao encontrar o arquivo");
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public LevelStatus getLevelStatus() {
        return levelStatus;
    }
}
