/**
 * RedFantasy
 */
public class RedFantasy {
    String[] monsters = new String[22];
    int[] monstersPoint = new int[22];

    int[] playerMonsters = new int[22];
    int[] playerMonstersPoint = new int[22];

    int[] cpuMonsters = new int[22];
    int[] cpuMonstersPoint = new int[22];

    int cpuPoint = 10;
    int playerPoint = 10;

    public RedFantasy() {
        for (int i = 0; i < this.playerMonsters.length; i++) {
            this.playerMonsters[i] = -1;
            this.cpuMonsters[i] = -1;
        }
    }

    public void initDraw() {
        //Init monster card draw
        System.out.println(" 初期カードDraw! ");
        for (int a = 0; a < 5; a++) {
            int pHand = (int) (Math.random() * monsters.length);
            for (int i = 0; i < this.playerMonsters.length; i++) {
                if (this.playerMonsters[i] == -1) {
                    this.playerMonsters[i] = pHand;
                    this.playerMonstersPoint[i] = this.monstersPoint[pHand];
                    break;
                }
            }

            ////Draw cpu's monster card
            int cHand = (int) (Math.random() * monsters.length);
            for (int i = 0; i < this.cpuMonsters.length; i++) {
                if (this.cpuMonsters[i] == -1) {
                    this.cpuMonsters[i] = cHand;
                    this.cpuMonstersPoint[i] = this.monstersPoint[cHand];
                    break;
                }
            }
        }
    }

    public void startPhase() {

        //Draw player's monster card
        int pHand = (int) (Math.random() * monsters.length);
        for (int i = 0; i < this.playerMonsters.length; i++) {
            if (this.playerMonsters[i] == -1) {
                this.playerMonsters[i] = pHand;
                this.playerMonstersPoint[i] = this.monstersPoint[pHand];
                break;
            }
        }

        ////Draw cpu's monster card
        int cHand = (int) (Math.random() * monsters.length);
        for (int i = 0; i < this.cpuMonsters.length; i++) {
            if (this.cpuMonsters[i] == -1) {
                this.cpuMonsters[i] = cHand;
                this.cpuMonstersPoint[i] = this.monstersPoint[cHand];
                break;
            }
        }

        System.out.println("Player Draw :" + this.monsters[pHand]);
        System.out.print("Player's monsters:");

        //List current player's monster card
        for (int i = 0; i < this.playerMonsters.length; i++) {
            if (this.playerMonsters[i] != -1) {
                System.out.print(this.monsters[this.playerMonsters[i]] + " ");
            }
        }

        //List current cpu's monster card
        System.out.println("\nCPU Draw :" + this.monsters[cHand]);
        System.out.print("CPU's monsters:");
        for (int i = 0; i < this.cpuMonsters.length; i++) {
            if (this.cpuMonsters[i] != -1) {
                System.out.print(this.monsters[this.cpuMonsters[i]] + " ");
            }
        }

        System.out.println("\nPlayer Turn");

        //player Attack, cpu Deffence
        for (int i = 0; i < this.playerMonsters.length; i++) {
            if (this.playerMonsters[i] == -1)
                continue;
            else
                System.out.print(this.monsters[this.playerMonsters[i]] + "'s Attack ");

            int cpuDefSeed = (int) (Math.random() * this.cpuMonsters.length);
            for (int j = cpuDefSeed; j < this.cpuMonsters.length + cpuDefSeed; j++) {
                int cpuDef = j;
                if (cpuDef >= this.cpuMonsters.length)
                    cpuDef = cpuDef - this.cpuMonsters.length;
                if (this.cpuMonsters[cpuDef] != -1) {
                    if (this.cpuMonstersPoint[cpuDef] > this.playerMonstersPoint[i]) {
                        this.cpuMonstersPoint[cpuDef] = this.cpuMonstersPoint[cpuDef] - this.playerMonstersPoint[i];
                        System.out.println(this.monsters[this.cpuMonsters[cpuDef]] + "が防御した");
                    } else {
                        int damage = this.playerMonstersPoint[i] - this.cpuMonstersPoint[cpuDef];
                        System.out.print(this.monsters[this.cpuMonsters[cpuDef]] + "は死んでしまった．");
                        this.cpuMonsters[cpuDef] = -1;
                        System.out.println("CPUに" + damage + "のダメージ");
                        this.cpuPoint = this.cpuPoint - damage;
                    }
                    break;
                } else if (cpuDef >= this.cpuMonsters.length) {
                    int damage = this.playerMonstersPoint[i];
                    System.out.println("CPUに" + damage + "のダメージ");
                    this.cpuPoint = this.cpuPoint - damage;
                    break;
                }
            }
        }
        System.out.println("\nCPU Point is " + this.cpuPoint);

        System.out.println("\nCPU Turn");
        //cpu Atk・Player Def
        for (int i = 0; i < this.cpuMonsters.length; i++) {
            if (this.cpuMonsters[i] == -1)
                continue;
            else
                System.out.print(this.monsters[this.cpuMonsters[i]] + "'s Attack ");

            int playerDefSeed = (int) (Math.random() * this.playerMonsters.length);
            for (int j = playerDefSeed; j < this.playerMonsters.length + playerDefSeed; j++) {
                int def = j;
                if (def >= this.playerMonsters.length)
                    def = def - this.playerMonsters.length;
                if (this.playerMonsters[def] != -1) {
                    if (this.playerMonstersPoint[def] > this.cpuMonstersPoint[i]) {
                        this.playerMonstersPoint[def] = this.playerMonstersPoint[def] - this.cpuMonstersPoint[i];
                        System.out.println(this.monsters[this.playerMonsters[def]] + "が防御した");
                    } else {
                        int damage = this.cpuMonstersPoint[i] - this.playerMonstersPoint[def];
                        System.out.print(this.monsters[this.playerMonsters[def]] + "は死んでしまった．");
                        this.playerMonsters[def] = -1;
                        System.out.println("Playerに" + damage + "のダメージ");
                        this.playerPoint = this.playerPoint - damage;
                    }
                    break;
                } else if (def >= this.playerMonsters.length) {
                    int damage = this.cpuMonstersPoint[i];
                    System.out.println("Playerに" + damage + "のダメージ");
                    this.playerPoint = this.playerPoint - damage;
                    break;
                }
            }
        }
        System.out.println("\nPlayer Point is " + this.playerPoint);

        //player,cpuのmonster point回復

    }

    public void setMonstersPoint(int[] tempMonstersPoint) {
        this.monstersPoint = tempMonstersPoint;
    }

    public void setMonsterZukan(String[] tempMonsters) {
        this.monsters = tempMonsters;
    }

}