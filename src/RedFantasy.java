import java.util.Random;

/**
 * RedFantasy
 */
public class RedFantasy {
    String[] monsters = new String[22];
    int[] monstersPoint = new int[22];

    int[] playerMonsters = new int[5];
    int[] playerMonstersPoint = new int[5];

    int[] cpuMonsters = new int[5];
    int[] cpuMonstersPoint = new int[5];

    int cpuHp = 20;
    int playerHp = 20;

    Random rnd = new Random();

    public RedFantasy() {
        // init player/cpu monster array
        for (int i = 0; i < this.playerMonsters.length; i++) {
            this.playerMonsters[i] = -1;
            this.cpuMonsters[i] = -1;
        }
    }

    public void startPhase() {

        //Draw player's monster card
        // playerMonsters.length -3 ~ playerMonsters.length までのランダムなint型の数値をp1に代入する
        int p1 = this.rnd.nextInt(this.playerMonsters.length - 2) + 3;
        System.out.println("Player Draw " + p1 + " monsters");
        for (int i = 0; i < p1; i++) {
            int m = this.rnd.nextInt(this.monsters.length);
            this.playerMonsters[i] = m;
            this.playerMonstersPoint[i] = this.monstersPoint[m];
        }

        ////Draw cpu's monster card
        int p2 = this.rnd.nextInt(this.cpuMonsters.length -2 ) + 3;
        System.out.println("CPU Draw " + p2 + " monsters");
        for (int i = 0; i < p2; i++) {
            int m = this.rnd.nextInt(this.monsters.length);
            this.cpuMonsters[i] = m;
            this.cpuMonstersPoint[i] = this.monstersPoint[m];
        }

        System.out.println("--------------------");
        System.out.print("Player Monsters:");
        for(int i = 0; i < this.playerMonsters.length; i++){
            if(this.playerMonsters[i] != -1){
                System.out.print(this.monsters[this.playerMonsters[i]] + " ");
            }
        }
        System.out.print("\nCPU Monsters:");
        for(int i = 0; i < this.cpuMonsters.length; i++){
            if(this.cpuMonsters[i] != -1){
                System.out.print(this.monsters[this.cpuMonsters[i]] + " ");
            }
        }
        System.out.println("\n--------------------");
        System.out.print("Player Monster Point is ");
        int p3 = 0;
        for(int i = 0; i < this.playerMonsters.length; i++){
            if(this.playerMonsters[i] != -1){
                p3 = p3 + this.playerMonstersPoint[i];
            }
        }
        System.out.println(p3);

        System.out.print("CPU Monster Point is ");
        int p4 = 0;
        for(int i = 0; i < this.cpuMonsters.length; i++){
            if(this.cpuMonsters[i] != -1){
                p4 = p4 + this.cpuMonstersPoint[i];
            }
        }
        System.out.println(p4);
        System.out.println("--------------------");
        
        if(p3 > p4){
            System.out.println("Player Win!");
            this.cpuHp = this.cpuHp - (p3 - p4);
        }else if(p4 > p3){
            System.out.println("CPU Win!");
            this.playerHp = this.playerHp - (p4 - p3);
        }

        System.out.println("Player HP is " + this.playerHp);
        System.out.println("CPU HP is " + this.cpuHp);
        
        System.out.println("--------------------");
        
    }
    public int getPlayerHp(){
        return this.playerHp; 
    }

    public int getCpuHp(){
        return this.cpuHp;
    }

    public void setMonstersPoint(int[] tempMonstersPoint) {
        this.monstersPoint = tempMonstersPoint;
    }

    public void setMonsterZukan(String[] tempMonsters) {
        this.monsters = tempMonsters;
    }

}