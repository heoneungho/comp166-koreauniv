public class Enemy extends GameCharacter {
	public Enemy(int Stage, int Difficulty)	{
		if(Stage == 1)	{
			name_e = "���";
			HP_e = 300 + (100 * Difficulty);
			Cards_e = 2;
			ATK_e = 100 + (10 * Difficulty);
			DEF_e = 50 + (10 * Difficulty);
			EVA_e = 10;
			Spells_e = new String[] {"����[���� ��Ż ������]","��ž[�׷���Ƽ��Ʈ Ʈ����}","�ú�[��ⷳ ����]","���� �� ���� ���"};
		}	else if(Stage == 2)	{
			name_e = "���ڿ��� �����";
			HP_e = 500 + (200 * Difficulty);
			Cards_e = 3;
			ATK_e = 150 + (20 * Difficulty);
			DEF_e = 70 + (10 * Difficulty);
			EVA_e = 20;
			Spells_e = new String[] {"�ð�[�糪 ���̾�]","�Ӻ�[��̳ʽ� ���ڼ�]","","�� ���� �������̵��"};
		}	else if(Stage == 3)	{
			name_e = "������ ������";
			HP_e = 700 + (300 * Difficulty);
			Cards_e = 4;
			ATK_e = 200 + (30 * Difficulty);
			DEF_e = 90 + (10 * Difficulty);
			EVA_e = 30;
			Spells_e = new String[] {"�κ�[������]","�α�[�̷�������]","�ܸ��[�����]","������ �Ծ�� �� �׿����ɾ�"};
		}	else if(Stage == 4)	{
			name_e = "���̼� �쵿���� �̳���";
			HP_e = 900 + (400 * Difficulty);
			Cards_e = 5;
			ATK_e = 250 + (40 * Difficulty);
			DEF_e = 110 + (10 * Difficulty);
			EVA_e = 40;
			Spells_e = new String[] {"ȯ��[�����ָ�]","���[������ ��]","����[��������ָ��]","�� �峭���� �ƴϾ�"};
		}	else if(Stage == 5)	{
			name_e = "����� ��";
			HP_e = 1100 + (500 * Difficulty);
			Cards_e = 6;
			ATK_e = 300 + (50 * Difficulty);
			DEF_e = 130 + (10 * Difficulty);
			EVA_e = 50;
			Spells_e = new String[] {"�Ľ�[þ]","�Ľ�[��ȣ���]","�к�[������ ��п���]","�׸� �ڰ� �Ͼ�� ���׾��"};
		}	else if(Stage == 6)	{
			name_e = "�߰��ڷ� ���̸�";
			HP_e = 1300 + (600 * Difficulty);
			Cards_e = 7;
			ATK_e = 350 + (60 * Difficulty);
			DEF_e = 150;
			EVA_e = 60;
			Spells_e = new String[] {"�ų�[������ī�� �극��]","õ��[������ 13]","����[������ �ٴ�]","���ض� ��Ʈ!"};
		}
	}
}