public class Main {
    static RedFantasy rf = new RedFantasy();

    public static void main(String[] args) {

		setMonsters();
        int count=0;

        while (true) {
            try {
                Thread.sleep(1000);
                if(count>5) break;
                rf.startPhase();
                count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

        }

    }

    public static void setMonsters() {
		String tempMonsters[] = new String[22];
		int tempMonstersPoint[] = new int [22];
		tempMonsters[0]="イガキン";	tempMonstersPoint[0]=9;
		tempMonsters[1]="ナマチュウ";	tempMonstersPoint[1]=3;
		tempMonsters[2]="イノウエン";	tempMonstersPoint[2]=1;
		tempMonsters[3]="リョージィ";	tempMonstersPoint[3]=2;
		tempMonsters[4]="アキモトン";	tempMonstersPoint[4]=5;
		tempMonsters[5]="ゴージマ";	tempMonstersPoint[5]=4;
		tempMonsters[6]="チュウデン";	tempMonstersPoint[6]=6;
		tempMonsters[7]="ヅカホン";	tempMonstersPoint[7]=8;
		tempMonsters[8]="ニシムラー";	tempMonstersPoint[8]=7;
		tempMonsters[9]="サコーデン";	tempMonstersPoint[9]=2;
		tempMonsters[10]="ウッチー";	tempMonstersPoint[10]=5;
		tempMonsters[11]="ハヤッシー";	tempMonstersPoint[11]=4;
		tempMonsters[12]="キーチー";	tempMonstersPoint[12]=3;
		tempMonsters[13]="リョクン";	tempMonstersPoint[13]=1;
		tempMonsters[14]="デコポン";	tempMonstersPoint[14]=6;
		tempMonsters[15]="カミサン";	tempMonstersPoint[15]=5;
		tempMonsters[16]="シスイ";	tempMonstersPoint[16]=1;
		tempMonsters[17]="ジョナ";	tempMonstersPoint[17]=7;
		tempMonsters[18]="ギダギダ";	tempMonstersPoint[18]=2;
		tempMonsters[19]="ミッツー";	tempMonstersPoint[19]=8;
		tempMonsters[20]="ゾエサン";	tempMonstersPoint[20]=5;
		tempMonsters[21]="キタバー";	tempMonstersPoint[21]=3;

		rf.setMonsterZukan(tempMonsters);
        rf.setMonstersPoint(tempMonstersPoint);    
    }
}