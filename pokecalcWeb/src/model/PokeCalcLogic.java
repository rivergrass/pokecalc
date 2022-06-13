package model;

public class PokeCalcLogic {
	String result;

	public String calc(PokeCalcStatus pcs) {
		//ダメージ計算
		int level = (int)pcs.getAtkLevel()*2/5+2;
		int move = (int)pcs.getMove()*pcs.getAtk()/pcs.getDef();
		int levelMove=(int)level*move/50+2;
		//最大値を計算
		double totalDamage = levelMove * pcs.getTypeMatch()*pcs.getTypeCong();

		//ダブルダメージの処理
		if(pcs.getDoubleDamage() == 0.75) {
			totalDamage=totalDamage*pcs.getDoubleDamage();
		}

		//最小値を計算(乱数の範囲は*0.85～*1.00)
		double damageUnder =totalDamage*0.85;


		//hpの割合を計算(最大hpの何%分のダメージか)
		double damageMax =100*(totalDamage/pcs.getHp());
		double damageMin =100*(damageUnder/pcs.getHp());

		//結果を文章として格納
		result=(int)damageUnder+"～"+(int)totalDamage+"ダメージ("+String.format("%.2f",damageMin)+"%～"+String.format("%.2f",damageMax)+"%)";

		return result;
	}
}
