package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PokeCalcLogic;
import model.PokeCalcStatus;


@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pokeCalcMain.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PokeCalcStatus pcs = new PokeCalcStatus();

		//リクエストパラメータ
		request.setCharacterEncoding("UTF-8");
		String atLv = request.getParameter("atLv");
		String move = request.getParameter("move");
		String atk = request.getParameter("atk");
		String dfLv = request.getParameter("dfLv");
		String hp = request.getParameter("hp");
		String def = request.getParameter("def");
		String match = request.getParameter("match");
		String cong = request.getParameter("cong");
		String doubleDamage = request.getParameter("damage");
		String atkItem =request.getParameter("atkitem");
		String helphands =request.getParameter("helphands");

		//ダメージ計算に必要な数値をint型、double型に格納

		pcs.setAtkLevel(Integer.parseInt(atLv));
		pcs.setMove(Integer.parseInt(move));
		pcs.setAtk(Integer.parseInt(atk));
		pcs.setDefLevel(Integer.parseInt(dfLv));
		pcs.setHp(Integer.parseInt(hp));
		pcs.setDef(Integer.parseInt(def));

		//ラジオボタンの選択により数値を選択

		if(match.equals("0")){
			pcs.setTypeMatch(1.0);
		}else if(match.equals("1")) {
			pcs.setTypeMatch(1.5);
		}else if(match.equals("2")) {
			pcs.setTypeMatch(2.0);
		}


		if(cong.equals("0")){
			pcs.setTypeCong(0.25);
		}else if(cong.equals("1")) {
			pcs.setTypeCong(0.5);
		}else if(cong.equals("2")) {
			pcs.setTypeCong(1);
		}else if(cong.equals("3")) {
			pcs.setTypeCong(2);
		}else if(cong.equals("4")) {
			pcs.setTypeCong(4);
		}

		if(doubleDamage.equals("0")){
			pcs.setDoubleDamage(1.0);
		}else if(doubleDamage.equals("1")) {
			pcs.setDoubleDamage(0.75);
		}

		if(atkItem.equals("0")){
			pcs.setDamageUpItem(1.0);
		}else if(atkItem.equals("1")) {
			pcs.setDamageUpItem(1.1);
		}else if(atkItem.equals("2")) {
			pcs.setDamageUpItem(1.2);
		}else if(atkItem.equals("3")) {
			pcs.setDamageUpItem(1.21);
		}else if(atkItem.equals("4")) {
			pcs.setDamageUpItem(1.3);
		}else if(atkItem.equals("5")) {
			pcs.setDamageUpItem(1.5);
		}else if(atkItem.equals("6")) {
			pcs.setDamageUpItem(2.0);
		}

		if(helphands.equals("0")) {
			pcs.setHelphands(1.0);
		}else if(helphands.equals("1")) {
			pcs.setHelphands(1.5);
		}else if(helphands.equals("2")){
			pcs.setHelphands(2.25);
		}

		//ダメージの計算
		PokeCalcLogic pcl = new PokeCalcLogic();
		String damage =pcl.calc(pcs);

		//リクエストスコープ
		request.setAttribute("damage", damage);
		request.setAttribute("typeMatch",match);
		request.setAttribute("typeCong", cong);
		request.setAttribute("doubleDamage", doubleDamage);
		request.setAttribute("atkItem", atkItem);
		request.setAttribute("helphands", helphands);


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pokeCalcMain.jsp");
		dispatcher.forward(request, response);
	}

}
