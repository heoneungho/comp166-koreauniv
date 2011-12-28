public class Player extends GameCharacter {
	public Player(int Level, int Selection)	{
		if(Selection == 1)	{
			name_p = "������ ����";
			HP_p = 1000 + (300 * Level);
			Cards_p = 6;
			ATK_p = 200 + (50 * Level);
			DEF_p = 100 + (50 * Level);
			EVA_p = 10;
			Spells_p = new String[] {"���� [�ض��� ����� ������]","���� [��Ÿ ������Ʈ��]","�븶�� [���ź���]","���[������ �������]","���� ���迡�� ���� ������"};
		}	else if(Selection == 2)	{
			name_p = "ȣ���̻� ī����";
			HP_p = 800 + (150 * Level);
			Cards_p = 8;
			ATK_p = 160 + (40 * Level);
			DEF_p = 80 + (20 * Level);
			EVA_p = 30;
			Spells_p = new String[] {"�ź� [�ε�Ʈ ���̾Ƹ��]","���� [������ �ھ���]","�ų��� [�Ҹ��ϴ� �ܿ��� ��]","���� �ǵ�����","���� ��Ʈ����"};
		}	else if(Selection == 3)	{
			name_p = "��Ű����Ű �߸��ڳ���";
			HP_p = 900 + (200 * Level);
			Cards_p = 7;
			ATK_p = 180 + (45 * Level);
			DEF_p = 90 + (30 * Level);
			EVA_p = 20;
			Spells_p = new String[] {"�˺�[��Ȳ�ϴ� ����]","���� [��Ƽ ���� �� ��Ƽ]","��� [�� ���� ����]","���� [��Ʈ ������Ʈ]","������ �ְ����ǰ�"};
		}
	}
}