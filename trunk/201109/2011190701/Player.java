public class Player extends GameCharacter {
	public Player(int Level, int Selection)	{
		if(Selection == 1)	{
			name_p = "히지리 뱌쿠렌";
			HP_p = 1000 + (300 * Level);
			Cards_p = 6;
			ATK_p = 200 + (50 * Level);
			DEF_p = 100 + (50 * Level);
			EVA_p = 10;
			Spells_p = new String[] {"길조 [극락의 보라색 구름길]","광마 [스타 마엘스트롬]","대마법 [마신복송]","비발[전설의 비공원반]","법의 세계에는 빛이 가득해"};
		}	else if(Selection == 2)	{
			name_p = "호라이산 카구야";
			HP_p = 800 + (150 * Level);
			Cards_p = 8;
			ATK_p = 160 + (40 * Level);
			DEF_p = 80 + (20 * Level);
			EVA_p = 30;
			Spells_p = new String[] {"신보 [부디스트 다이아몬드]","난제 [제비의 자안패]","신난제 [불멸하는 겨울의 검]","영야 되돌리기","달의 니트공주"};
		}	else if(Selection == 3)	{
			name_p = "시키에이키 야마자나두";
			HP_p = 900 + (200 * Level);
			Cards_p = 7;
			ATK_p = 180 + (45 * Level);
			DEF_p = 90 + (30 * Level);
			EVA_p = 20;
			Spells_p = new String[] {"죄부[방황하는 대죄]","심판 [길티 오어 낫 길티]","허언 [텅 오브 울프]","심판 [라스트 저지먼트]","낙원의 최고재판관"};
		}
	}
}