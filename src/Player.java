import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int hp = 50;
    private int bonusPoint = 0;
    private List<Monster> monsters = new ArrayList<>();
    private List<Integer> history = new ArrayList<>();
    private Random rnd = new Random();

    public Player(String name) {
        this.name = name;
        history.add(hp);
    }

    public void drawMonsters(List<Monster> monsterZukan, int min, int max) {
        int num = rnd.nextInt(max - min + 1) + min;
        System.out.println(name + " Draw " + num + " monsters");

        monsters.clear();
        for (int i = 0; i < num; i++) {
            int index = rnd.nextInt(monsterZukan.size());
            Monster monster = monsterZukan.get(index);
            monsters.add(new Monster(monster.getName(), monster.getPoint()));
        }
    }

    public void rollDice() {
        int dice = rnd.nextInt(6) + 1;
        System.out.println(name + "のサイコロ: " + dice);
        if (dice == 1) {
            System.out.println("失敗！すべてのモンスターポイントが半分になる");
            for (Monster m : monsters) {
                m.setPoint(m.getPoint() / 2);
            }
        } else if (dice == 6) {
            System.out.println("クリティカル！すべてのモンスターポイントが倍になる");
            for (Monster m : monsters) {
                m.setPoint(m.getPoint() * 2);
            }
        } else {
            bonusPoint = dice;
        }
    }

    public int calculateTotalPoint() {
        int total = bonusPoint;
        for (Monster m : monsters) {
            total += m.getPoint();
        }
        System.out.println(name + "のモンスターポイント合計: " + total);
        return total;
    }

    public int getHp() {
        return hp;
    }

    public void decreaseHp(int amount) {
        hp -= amount;
    }

    public void addHistory() {
        history.add(hp);
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void showMonsters() {
        System.out.print(name + "のモンスターリスト: ");
        for (Monster m : monsters) {
            System.out.print(m.getName() + " ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
