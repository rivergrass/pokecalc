package model;

public class PokeCalcLogic {
	String result;
	int atk;
	int moveValue;
	public String calc(PokeCalcStatus pcs) {
		//ダメージ計算

		//各種アイテム補正（ダメージに倍率がかかるもの以外）

		if(pcs.getDamageUp() == 1.1) {//技威力1.1
			atk =(int)pcs.getAtk();
			moveValue = (int)(pcs.getMove()*1.1);
		}
		else if(pcs.getDamageUp() == 1.2) {//技威力1.2
			atk =(int)pcs.getAtk();
			moveValue = (int)(pcs.getMove()*1.1999);
		}
		else if(pcs.getDamageUp() == 1.5) {//技威力1.5
			atk =(int)(pcs.getAtk()*1.5);
			moveValue = (int)pcs.getMove();
		}
		else if(pcs.getDamageUp() == 2.0) {//攻撃（特攻）実数値2倍
			atk =(int)(pcs.getAtk()*2.0);
			moveValue = (int)pcs.getMove();
		}
		else {
			atk =(int)pcs.getAtk();
			moveValue = (int)pcs.getMove();
		}


		int level = (int)pcs.getAtkLevel()*2/5+2;
		int move = (int)moveValue*atk/pcs.getDef();
		int levelMove=(int)level*move/50+2;

		//最大値を計算
		double totalDamage = levelMove * pcs.getTypeMatch()*pcs.getTypeCong();

		//ダメージに補正が乗るアイテムの計算
		if(pcs.getDamageUp() == 1.21) {//帯
			totalDamage = totalDamage*1.1999;
		}else if(pcs.getDamageUp() == 1.3) {//珠
			totalDamage = totalDamage*1.3;
		}else {

		}

		//ダブルダメージの処理
		if(pcs.getDoubleDamage() == 0.75) {
			totalDamage=totalDamage*pcs.getDoubleDamage();
		}

		//最小値を計算(乱数の範囲は*0.85～*1.00)
		double damageUnder =totalDamage*0.85;

		//hpの割合を計算(最大hpの何%分のダメージか)
		double damageMax =100*(Math.floor(totalDamage)/pcs.getHp());
		double damageMin =100*(Math.floor(damageUnder)/pcs.getHp());



		//結果を文章として格納
		result=(int)damageUnder+"～"+(int)totalDamage+"ダメージ("+String.format("%.2f",damageMin)+"%～"+String.format("%.2f",damageMax)+"%)";

		return result;
	}
}
