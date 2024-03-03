
<%@page import="com.model.Character"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>jeux</title>
</head>
<body>
<%Character[] groupe = (Character[]) request.getAttribute("groupe-table");%>
 <div class="group-choose-container">
        <h1>Choose the players</h1>
        <div class="group-choose">
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2>name 1</h2>
                <label>pv : </label>
                <label>100</label><br>
                <button>add</button>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2>name 2</h2>
                <label>pv : </label>
                <label>100</label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player-1" class = "chooser">
                	<button type="submit">add</button>
                </form>
                
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2>name 3</h2>
                <label>pv : </label>
                <label>100</label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player-1" class = "chooser">
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2>name 4</h2>
                <label>pv : </label>
                <label>100</label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player-1" class = "chooser">
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2>name 5</h2>
                <label>pv : </label>
                <label>100</label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player-1" class = "chooser">
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="clear"></div>
            <div class="team">
                <div>
                    <label>Your team : </label>
                </div>
                <div class="player">
                    <img src="img/wizard.jpg" alt="">
                    <h2>name 1</h2>
                    <label>pv : </label>
                    <label>100</label>
                </div>
            </div>
            <div class="clear"></div>
            <button class ="next">next</button>
        </div>
        <div>
            
        </div>
    </div>
 	<div class="group-number-container">
        <h1>Choose the number of players</h1>
        <div class="group-number">
        	<div>
        		<form class ="choose-Controleur" action="GroupChoose" method="post">
        		<input class = "chooser" name="group-Number" value="1">
        		<button class="choose-button" type="submit">1</button>
        		</form>
        	</div>
        	<div>
        		<form class ="choose-Controleur" action="GroupChoose" method="post">
        		<input class = "chooser" name="group-Number" value="2">
        		<button class="choose-button" type="submit">2</button>
        		</form>
        	</div>
        	<div>
        		<form class ="choose-Controleur" action="GroupChoose" method="post">
        		<input class = "chooser" name="group-Number" value="3">
        		<button class="choose-button" type="submit">3</button>
        		</form>
        	</div>
        	<div>
        		<form class ="choose-Controleur" action="GroupChoose" method="post">
        		<input class = "chooser" name="group-Number" value="4">
        		<button class="choose-button" type="submit">4</button>
        		</form>
        	</div>
        	<div>
        		<form class ="choose-Controleur" action="GroupChoose" method="post">
        		<input class = "chooser" name="group-Number" value="5">
        		<button class="choose-button" type="submit">5</button>
        	</form>
        	</div>
        </div>
    </div>
    <div id = "first-page" class="play-page">
        <div class="elements">
            <h1>Welcome to the game</h1>
            <button onclick="play('first-page')">Play</button>
        </div>
    </div>
    <script src="index.js"></script>
</body>
</html>