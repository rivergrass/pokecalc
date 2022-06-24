package model;

public class PokeCalcLogic {
	String result;
	int atk;
	double moveValue;
	public String calc(PokeCalcStatus pcs) {
		//ダメージ計算

		//各種アイテム補正（ダメージに倍率がかかるもの以外）

		//技威力にバフがかかる(item)
		if(pcs.getDamageUpItem() == 1.1) {//技威力1.1
			moveValue = pcs.getMove()*1.09985;
		}
		else if(pcs.getDamageUpItem() == 1.2) {//技威力1.2
			moveValue = pcs.getMove()*1.19995;
		}
		else {
			moveValue = pcs.getMove();
		}

		//技威力にバフがかかる(特性)


		//天候


		//フィールド



		//攻撃力にバフがかかる（持ち物）
		if(pcs.getDamageUpItem() == 1.5) {//技威力1.5
			atk =(int)(pcs.getAtk()*1.5);
		}
		else if(pcs.getDamageUpItem() == 2.0) {//攻撃（特攻）実数値2倍
			atk =(int)(pcs.getAtk()*2.0);
		}
		else {
			atk =pcs.getAtk();
		}

		//攻撃力にバフがかかる（特性）


		//防御にバフがかかる（持ち物）


		//防御力にバフがかかる（特性）


		//手助けの処理
		if(pcs.getHelphands() == 1.5) {//てだすけあり
			moveValue =(int) Math.round(moveValue*1.5);
		}else if(pcs.getHelphands() == 2.25) {//てだすけ２体分
			moveValue =(int)Math.round(moveValue*2.25);
		}else {

		}
		int level = (int)(pcs.getAtkLevel()*2)/5+2;
		int move = (int)moveValue*atk/pcs.getDef();

		//最大値を計算
		int totalDamage=(int)(level*move/50+2);

		//ダブルダメージの処理
		if(pcs.getDoubleDamage() == 0.75) {
			Double calcTotalDamage=totalDamage*pcs.getDoubleDamage();
			totalDamage=(int)Math.ceil(calcTotalDamage-0.5);
			}

		//ダメージに補正が乗るアイテム
		if(pcs.getDamageUpItem() == 1.21) {//帯
			totalDamage =(int) Math.floor(totalDamage*1.19995);
		}else if(pcs.getDamageUpItem() == 1.3) {//珠
			totalDamage =(int)Math.floor(totalDamage*1.29980);
		}else {

		}

		//ダメージに補正が乗る要素


		//最小値を計算(乱数の範囲は*0.85～*1.00)
		double damageUnder =Math.floor(totalDamage*0.85);

		//タイプ相性
		totalDamage =(int)Math.ceil(totalDamage * pcs.getTypeMatch()-0.5);
		damageUnder =(int)Math.ceil(damageUnder * pcs.getTypeMatch()-0.5);

		//タイプ一致
		totalDamage =(int) Math.floor(totalDamage * pcs.getTypeCong());
		damageUnder =(int) Math.floor(damageUnder * pcs.getTypeCong());

		//hpの割合を計算(最大hpの何%分のダメージか)
		double damageMax =100*(Math.floor(totalDamage)/pcs.getHp());
		double damageMin =100*(Math.floor(damageUnder)/pcs.getHp());

		//結果を文章として格納
		result=(int)damageUnder+"～"+totalDamage+"ダメージ("+String.format("%.2f",damageMin)+"%～"+String.format("%.2f",damageMax)+"%)";

		return result;
	}
}
