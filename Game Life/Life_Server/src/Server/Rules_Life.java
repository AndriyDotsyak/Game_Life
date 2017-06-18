package Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Rules_Life {
    public static int[][] field;
    public static int[][] field_1 = new int[22][22];

    private int Resurrection = 0;
    private int Dies = 0;

    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public void Creation() {
        field = GSON.fromJson(Life_Server.JsonInput, int[][].class);

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                field_1[i][j] = 0;
            }
        }

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                field_1[i][0] = -1;
                field_1[i][21] = -1;
                field_1[0][j] = -1;
                field_1[21][j] = -1;
            }
        }
    }

    public void Dies() {
        for(int i = 0; i < 22; i ++) {
            for(int j = 0; j < 22; j++) {
                if(field[i][j] == 1) {
                    if(field[i-1][j-1] == 1) {
                        Dies ++;
                    }
                    if(field[i-1][j] == 1) {
                        Dies ++;
                    }
                    if(field[i-1][j+1] == 1) {
                        Dies ++;
                    }
                    if(field[i][j-1] == 1) {
                        Dies ++;
                    }
                    if(field[i][j+1] == 1) {
                        Dies ++;
                    }
                    if(field[i+1][j-1] == 1) {
                        Dies ++;
                    }
                    if(field[i+1][j] == 1) {
                        Dies ++;
                    }
                    if(field[i+1][j+1] == 1) {
                        Dies ++;
                    }

                    if(Dies == 2 || Dies == 3) {
                        field_1[i][j] = 1;
                    }
                    if(Dies <= 1 || Dies >= 4) {
                        field_1[i][j] = 0;
                    }
                }
                Dies = 0;
            }
        }
    }

    public void Resurrection() {
        for(int i = 0; i < 22; i ++) {
            for(int j = 0; j < 22; j++) {
                if(field[i][j] == 0) {
                    if(field[i-1][j-1] == 1) {
                        Resurrection ++;
                    }
                    if(field[i-1][j] == 1) {
                        Resurrection ++;
                    }
                    if(field[i-1][j+1] == 1) {
                        Resurrection ++;
                    }
                    if(field[i][j-1] == 1) {
                        Resurrection ++;
                    }
                    if(field[i][j+1] == 1) {
                        Resurrection ++;
                    }
                    if(field[i+1][j-1] == 1) {
                        Resurrection ++;
                    }
                    if(field[i+1][j] == 1) {
                        Resurrection ++;
                    }
                    if(field[i+1][j+1] == 1) {
                        Resurrection ++;
                    }

                    if(Resurrection == 3) {
                        field_1[i][j] = 1;
                    }
                }
                Resurrection = 0;
            }
        }
    }

    public void Reassignment () {
        for(int i = 0; i < 22; i ++) {
            for (int j = 0; j < 22; j++) {
                field[i][j] = field_1[i][j];
            }
        }

        Life_Server.JsonOutput = GSON.toJson(field);
    }
}
