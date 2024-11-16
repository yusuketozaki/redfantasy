import java.util.ArrayList;
import java.util.List;

public class Main {
    static RedFantasy rf = new RedFantasy();

    public static void main(String[] args) {

        setMonsters();

        while (true) {
            try {
                if (rf.getPlayerHp() > 0 && rf.getCpuHp() > 0) {
                    Thread.sleep(3000);
                    rf.startPhase();
                } else if (rf.getPlayerHp() <= 0) {
                    System.out.println("Playerは死んでしまった");
                    break;
                } else if (rf.getCpuHp() <= 0) {
                    System.out.println("CPUは死んでしまった");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Player History:");
        for (int hp : rf.getPlayerHistory()) {
            System.out.print(hp + "\t");
        }
        System.out.println("\nCPU History:");
        for (int hp : rf.getCpuHistory()) {
            System.out.print(hp + "\t");
        }
    }

    public static void setMonsters() {
        List<Monster> monsterZukan = new ArrayList<>();

        monsterZukan.add(new Monster("イガキン", 9));
        monsterZukan.add(new Monster("ナマチュウ", 3));
        monsterZukan.add(new Monster("イノウエン", 1));
        monsterZukan.add(new Monster("リョージィ", 2));
        monsterZukan.add(new Monster("アキモトン", 5));
        monsterZukan.add(new Monster("ゴージマ", 4));
        monsterZukan.add(new Monster("チュウデン", 6));
        monsterZukan.add(new Monster("ヅカホン", 8));
        monsterZukan.add(new Monster("ニシムラー", 7));
        monsterZukan.add(new Monster("サコーデン", 2));
        monsterZukan.add(new Monster("ウッチー", 5));
        monsterZukan.add(new Monster("ハヤッシー", 4));
        monsterZukan.add(new Monster("キーチー", 3));
        monsterZukan.add(new Monster("リョクン", 1));
        monsterZukan.add(new Monster("デコポン", 6));
        monsterZukan.add(new Monster("カミサン", 5));
        monsterZukan.add(new Monster("シスイ", 1));
        monsterZukan.add(new Monster("ジョナ", 7));
        monsterZukan.add(new Monster("ギダギダ", 2));
        monsterZukan.add(new Monster("ミッツー", 8));
        monsterZukan.add(new Monster("ゾエサン", 5));
        monsterZukan.add(new Monster("キタバー", 3));

        rf.setMonsterZukan(monsterZukan);
    }
}
