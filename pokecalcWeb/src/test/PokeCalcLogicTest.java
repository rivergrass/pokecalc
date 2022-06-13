package test;

import model.PokeCalcLogic;
import model.PokeCalcStatus;

public class PokeCalcLogicTest {

	public static void main(String[] args) {
		String atLv = "50";
		String move = "130";
		String atk = "200";
		String dfLv = "50";
		String hp = "227";
		String def = "150";

		double typeMatch = 0;
		if(typeMatch == 0){
			typeMatch=1.5;
		}else {
			typeMatch=1;
		}

		double typeCong = 1.0;

		PokeCalcStatus pcs = new PokeCalcStatus();

		pcs.setAtkLevel(Integer.parseInt(atLv));
		pcs.setMove(Integer.parseInt(move));
		pcs.setAtk(Integer.parseInt(atk));
		pcs.setDefLevel(Integer.parseInt(dfLv));
		pcs.setHp(Integer.parseInt(hp));
		pcs.setDef(Integer.parseInt(def));
		pcs.setTypeMatch(typeMatch);
		pcs.setTypeCong(typeCong);

		PokeCalcLogic pcl = new PokeCalcLogic();
		String damage =pcl.calc(pcs);

		System.out.println(damage);
	}

}
