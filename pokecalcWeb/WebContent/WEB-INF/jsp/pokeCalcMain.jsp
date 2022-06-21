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

<div class="container-fluid">
	<form action="/pokecalc/calc" method="post">

	<div class="w-25">
		<div class="form-group">
			<label>攻撃側レベル</label>
			<input type="number" name="atLv" id ="atLv" value = "50"  min = "1" class="form-control" required>
		</div>
	</div>

	<div class="w-25">
		<div class="form-group">
			<label>技威力</label>
			<input type="number" name="move" id ="move" value = "100"  min = "1" class="form-control" required>
		</div>
	</div>

	<div class="w-25">
		<div class="form-group">
			<label>攻撃or特攻</label>
			<input type="number" name="atk" id ="atk" value = "182"  min = "1" class="form-control" required>
		</div>
	</div>

	<div class="w-25">
		<div class="form-group">
			<label>防御側レベル</label>
			<input type="number" name="dfLv" id ="dfLv" value = "50"  min = "1" class="form-control" required>
		</div>
	</div>

	<div class="w-25">
		<div class="form-group">
			<label>HP</label>
			<input type="number" name="hp" id ="hp" value = "145"  min = "1" class="form-control" required>
		</div>
	</div>

	<div class="w-25">
		<div class="form-group">
			<label>防御or特防</label>
			<input type="number" name="def" id ="def" value = "95"  min = "1" class="form-control" required>
		</div>
	</div>

<header>タイプ一致</header>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="match" id="match1" value = "0">
  		<label class="form-check-label" for="match1">
    不一致(1.0)
 		</label>
	</div>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="match" id="match2" value = "1" checked>
  		<label class="form-check-label" for="match2">
    一致(1.5)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="match" id="match3"  value = "2">
 		 <label class="form-check-label" for="match3">
    適応力(2.0)
  		</label>
	</div>

	<header>相性</header>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="cong" id="cong1" value = "0">
  		<label class="form-check-label" for="cong1">
    いまひとつ(1/4)
 		</label>
	</div>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="cong" id="cong2" value = "1" >
  		<label class="form-check-label" for="cong2">
    いまひとつ(1/2)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="cong" id="cong3"  value = "2" checked>
 		 <label class="form-check-label" for="cong3">
    等倍(1)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="cong" id="cong4"  value = "3">
 		 <label class="form-check-label" for="cong4">
    ばつぐん(2)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="cong" id="cong5"  value = "4">
 		 <label class="form-check-label" for="cong5">
    ばつぐん(4)
  		</label>
	</div>

	<header>ダメージ</header>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="damage" id="damage1" value = "0">
  		<label class="form-check-label" for="damage1">
    シングル(1.0)
 		</label>
	</div>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="damage" id="damage2" value = "1" checked>
  		<label class="form-check-label" for="damage2">
    ダブル(0.75)
  		</label>
	</div>

	<header>アイテム補正</header>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="atkitem" id="atkitem1" value = "0" checked>
  		<label class="form-check-label" for="atkitem1">
    なし
 		</label>
	</div>
	<div class="form-check form-check-inline">
  		<input class="form-check-input" type="radio" name="atkitem" id="atkitem2" value = "1" >
  		<label class="form-check-label" for="atkitem2">
    1.1
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="atkitem" id="atkitem3"  value = "2" >
 		 <label class="form-check-label" for="atkitem3">
    1.2(タイプ強化系)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="atkitem" id="atkitem4"  value = "3" >
 		 <label class="form-check-label" for="atkitem4">
    1.2(達人の帯)
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="atkitem" id="atkitem5"  value = "4">
 		 <label class="form-check-label" for="atkitem5">
    1.3
  		</label>
	</div>
	<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="atkitem" id="atkitem6"  value = "5">
 		 <label class="form-check-label" for="atkitem6">
    1.5
  		</label>
	</div>
		<div class="form-check form-check-inline">
 		 <input class="form-check-input" type="radio" name="atkitem" id="atkitem7"  value = "6">
 		 <label class="form-check-label" for="atkitem7">
    2.0
  		</label>
	</div>

		 <button type="reset" class="btn btn-primary">リセット</button>
		 <button type="submit" class="btn btn-primary">計算実行</button>
	</form>
</div>


<div class="border col-5">
        <br>
        <h2>計算結果</h2>
        <p><%= damage %></p>
        <br>
</div>



</body>
</html>