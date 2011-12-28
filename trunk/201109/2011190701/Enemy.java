public class Enemy extends GameCharacter {
	public Enemy(int Stage, int Difficulty)	{
		if(Stage == 1)	{
			name_e = "나즈린";
			HP_e = 300 + (100 * Difficulty);
			Cards_e = 2;
			ATK_e = 100 + (10 * Difficulty);
			DEF_e = 50 + (10 * Difficulty);
			EVA_e = 10;
			Spells_e = new String[] {"수부[레어 메탈 디텍터]","옥탑[그레이티스트 트레져}","시부[펜듈럼 가드]","물건 좀 작작 흘려"};
		}	else if(Stage == 2)	{
			name_e = "이자요이 사쿠야";
			HP_e = 500 + (200 * Difficulty);
			Cards_e = 3;
			ATK_e = 150 + (20 * Difficulty);
			DEF_e = 70 + (10 * Difficulty);
			EVA_e = 20;
			Spells_e = new String[] {"시계[루나 다이얼]","속부[루미너스 리코셰]","","이 망할 요정메이드들"};
		}	else if(Stage == 3)	{
			name_e = "콘파쿠 요유무";
			HP_e = 700 + (300 * Difficulty);
			Cards_e = 4;
			ATK_e = 200 + (30 * Difficulty);
			DEF_e = 90 + (10 * Difficulty);
			EVA_e = 30;
			Spells_e = new String[] {"인부[현세참]","인귀[미래영겁참]","단명검[명상참]","적당히 먹어라 이 잉여망령아"};
		}	else if(Stage == 4)	{
			name_e = "레이센 우동게인 이나바";
			HP_e = 900 + (400 * Difficulty);
			Cards_e = 5;
			ATK_e = 250 + (40 * Difficulty);
			DEF_e = 110 + (10 * Difficulty);
			EVA_e = 40;
			Spells_e = new String[] {"환파[적안최면]","산부[진실의 달]","월안[월토원격최면술]","난 장난감이 아니야"};
		}	else if(Stage == 5)	{
			name_e = "야쿠모 란";
			HP_e = 1100 + (500 * Difficulty);
			Cards_e = 6;
			ATK_e = 300 + (50 * Difficulty);
			DEF_e = 130 + (10 * Difficulty);
			EVA_e = 50;
			Spells_e = new String[] {"식신[첸]","식신[선호사념]","밀부[대사님의 비밀열쇠]","그만 자고 일어나라 주잉양반"};
		}	else if(Stage == 6)	{
			name_e = "야고코로 에이린";
			HP_e = 1300 + (600 * Difficulty);
			Cards_e = 7;
			ATK_e = 350 + (60 * Difficulty);
			DEF_e = 150;
			EVA_e = 60;
			Spells_e = new String[] {"신뇌[오모이카네 브레인]","천주[아폴로 13]","연단[수은의 바다]","일해라 니트!"};
		}
	}
}