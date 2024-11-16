import java.util.ArrayList;
import java.util.List;

public class RedFantasy {
    private List<Monster> monsterZukan = new ArrayList<>();
    private Player player;
    private Player cpu;

    public RedFantasy() {
        player = new Player("Player");
        cpu = new Player("CPU");
    }

    public void startPhase() {
        // モンスターを引く
        player.drawMonsters(monsterZukan, 3, 5);
        cpu.drawMonsters(monsterZukan, 3, 5);

        System.out.println("--------------------");
        player.showMonsters();
        cpu.showMonsters();
        System.out.println("--------------------");

        System.out.println("Battle!");
        // サイコロを振る
        player.rollDice();
        cpu.rollDice();

        System.out.println("--------------------");
        // ポイントを計算する
        int playerTotal = player.calculateTotalPoint();
        int cpuTotal = cpu.calculateTotalPoint();
        System.out.println("--------------------");

        // 勝敗を判定する
        if (playerTotal > cpuTotal) {
            System.out.println("Player Win!");
            cpu.decreaseHp(playerTotal - cpuTotal);
        } else if (cpuTotal > playerTotal) {
            System.out.println("CPU Win!");
            player.decreaseHp(cpuTotal - playerTotal);
        } else {
            System.out.println("Draw!");
        }

        System.out.println("Player HP is " + player.getHp());
        System.out.println("CPU HP is " + cpu.getHp());

        System.out.println("--------------------");
        // 対戦結果を記録する
        player.addHistory();
        cpu.addHistory();
    }

    public List<Integer> getPlayerHistory() {
        return player.getHistory();
    }

    public List<Integer> getCpuHistory() {
        return cpu.getHistory();
    }

    public int getPlayerHp() {
        return player.getHp();
    }

    public int getCpuHp() {
        return cpu.getHp();
    }

    public void setMonsterZukan(List<Monster> monsterZukan) {
        this.monsterZukan = monsterZukan;
    }
}
