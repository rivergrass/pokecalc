<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   String damage = (String)request.getAttribute("damage");
   if(damage==null){
	   damage="ここに計算結果が表示されます";
   }
   %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--bootStrapを利用できるようにする設定，そのままコピペして使う-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ダメージ計算</title>
</head>
<body>
<h1>ポケモン簡易ダメージ計算</h1>
<form action="/pokecalcWeb/calc" method="post">

		攻撃側レベル&nbsp;<input type="number" name="atLv" value = "50" min = "1" style="width:40px" required><br>
		技威力&emsp;&emsp;&emsp;
		<input type="number" name="move" value = "100" min = "1" style="width:40px" required><br>
		攻撃or特攻&emsp;&nbsp;<input type="number" name="atk" value = "182" min = "1" style="width:40px" required><br><br>
		防御側レベル&nbsp;<input type="number" name="dfLv" value = "50"  min = "1" style="width:40px" required><br>
		HP&emsp;&emsp;&emsp;&emsp;&emsp;<input type="number" name="hp" value = "145" style="width:40px" required><br>
		防御or特防&emsp;&nbsp;<input type="number" name="def" value = "95" min = "1" style="width:40px" required><br><br>
		一致: <label><input type="radio" name="match" value="0" >不一致(1.0)</label>
		<label><input type="radio" name="match" value="1"checked ="checked">一致(1.5)</label>
		<label><input type="radio" name="match" value="2">適応力(2.0)</label><br>
		相性:<label><input type="radio" name="cong" value="0">いまひとつ(1/4)</label>
		<label><input type="radio" name="cong" value="1">いまひとつ(1/2)</label>
		<label><input type="radio" name="cong" value="2"  checked ="checked">等倍(1)</label>
		<label><input type="radio" name="cong" value="3">ばつぐん(2)</label>
		<label><input type="radio" name="cong" value="4">ばつぐん(4)</label><br><br>
		ダメージ: <label><input type="radio" name="damage" value="0" >シングル(1.0)</label>
		<label><input type="radio" name="damage" value="1" checked ="checked">ダブル(0.75)</label>
		アイテム補正：<label><input type="radio" name="atkitem" value="0"  checked ="checked">なし</label>
		<label><input type="radio" name="atkitem" value="1">1.1</label>
		<label><input type="radio" name="atkitem" value="2" >1.2</label>
		<label><input type="radio" name="atkitem" value="3">1.3</label>
		<label><input type="radio" name="atkitem" value="4">1.5</label><br><br>
		<input type="reset" value="リセット">
		<input type="submit" value="計算実行">
		</form>
		<br>
		<fieldset style="width:400px">
		<legend>計算結果</legend>
		<p><%= damage %><br>
		</p>
		</fieldset>

</body>
</html>