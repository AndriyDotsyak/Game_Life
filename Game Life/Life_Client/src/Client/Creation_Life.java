package Client;

public class Creation_Life {
    public static int field[][] = new int[22][22];

    public void Creation() {
        for(int i = 0; i < 22; i ++) {
            for(int j = 0; j < 22; j++) {
                field[i][j] = 0;
            }
        }

        for(int i = 0; i < 22; i ++) {
            for(int j = 0; j < 22; j++) {
                field[i][0] = -1;
                field[i][21] = -1;
                field[0][j] = -1;
                field[21][j] = -1;
            }
        }
    }

    public void New_Life() {
        field[19][19]=1;
        field[18][19]=1;
        field[19][18]=1;
        field[18][18]=1;
        field[3][3]=1;
        field[4][3]=1;
        field[2][3]=1;
        field[8][10]=1;
        field[9][10]=1;
        field[7][8]=1;
        field[8][9]=1;
        field[9][9]=1;
        field[10][9]=1;
    }
}
