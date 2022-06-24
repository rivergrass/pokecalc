package model;

import java.io.Serializable;

public class PokeCalcStatus implements Serializable{


	private int atkLevel;
	private int move;
	private int atk;
	private int defLevel;
	private int hp;
	private int def;

	private double typeMatch;
	private double typeCong;
	private double doubleDamage;
	private double damageUpItem;
	private double helphands;

	private double damageMax;
	private double damageMin;

	public void setAtkLevel(int atkLevel) {
		this.atkLevel = atkLevel;
	}
	public void setMove(int move) {
		this.move = move;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDefLevel(int defLevel) {
		this.defLevel = defLevel;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setTypeMatch(double typeMatch) {
		this.typeMatch = typeMatch;
	}

	public void setTypeCong(double typeCong) {
		this.typeCong = typeCong;
	}
	public void setDoubleDamage(double doubleDamage) {
		this.doubleDamage = doubleDamage;
	}

	public void setDamageUpItem(double damageUpItem) {
		this.damageUpItem = damageUpItem;
	}

	public void setHelphands(double helphands) {
		this.helphands =helphands;
	}

	public void setDamageMax(double damageMax) {
		this.damageMax =damageMax;
	}

	public void setDamageMin(double damageMin) {
		this.damageMin =damageMin;
	}

	public int getAtkLevel() {
		return this.atkLevel;
	}

	public int getMove() {
		return this.move;
	}

	public int getAtk() {
		return this.atk;
	}

	public int getDefLevel() {
		return this.defLevel;
	}

	public int getHp() {
		return this.hp;
	}

	public int getDef() {
		return this.def;
	}

	public double getTypeMatch() {
		return this.typeMatch;
	}

	public double getTypeCong() {
		return this.typeCong;
	}

	public double getDoubleDamage() {
		return this.doubleDamage;
	}
	public double getDamageUpItem() {
		return this.damageUpItem;
	}
	public double getHelphands() {
		return this.helphands;
	}

	public double getDamageMax() {
		return this.damageMax;
	}

	public double getDamageMin() {
		return this.damageMin;
	}



}
