<!DOCTYPE html>
<%@page import="com.model.Character"%>
<html>
<head>
<meta charset="ISO-8859-1" >

<link rel="stylesheet" href="index.css">
<title>Game</title>
</head>
<body>
	
	<%System.out.println("game.jps est entrer.####################################################################");
	  Character[] group = (Character[]) session.getAttribute("groupe-table");
	  Character[] enemies = (Character[]) session.getAttribute("enemies");
	  Integer i = (Integer)session.getAttribute("playersFill");
	  Integer[] enemiesPv = (Integer[]) session.getAttribute("enemiesPv");
	  Integer[] charactersPv = (Integer[]) session.getAttribute("charactersPv");
	  String[] imagesPath = (String[]) session.getAttribute("imagesPath");
	  if(charactersPv == null){
	  	charactersPv = new Integer[i.intValue()];
	  	for(int j=0; j < charactersPv.length; j++){
		  	charactersPv[j] = group[j].getPv();
		  }
	  }
	  if(enemiesPv == null){
	  	enemiesPv = new Integer[i.intValue()];
	  	for(int j=0; j < enemiesPv.length; j++){
	  		enemiesPv[j] = enemies[j].getPv();
		  }
	  }
	  Integer counter = (Integer) session.getAttribute("counter");
	  
	  /* for(int p = 0; p < imagesPath.length; p++){
		  System.out.println("image " + p + " : " + imagesPath[p]);
	  } */
	  session.setAttribute("groupe-table", group);
	  session.setAttribute("enemies", enemies);
	  session.setAttribute("playersFill", i);
	  session.setAttribute("charactersPv", charactersPv);
	  session.setAttribute("enemiesPv", enemiesPv);
	  session.setAttribute("imagesPath", imagesPath);
	%>

	<div class="game">

       <% for (int j = 0; j < group.length; j++) { %>
		    <div id="player-<%= j %>" class="player-<%= j %> my-animation">
		        <h3 class="player-name"><%=group[j].getName()%></h3>
		        <div class="etat-character">
		            <div id="fill-<%=j%>" class="fill-player"></div>
		        </div>
		    </div>
		<% } %>
        <%System.out.println("pv de 1er player" + group[0].getPv()); %>
        <%for(int j=0; j < enemies.length; j++){
        	%>
        	<div id = "<%="enemy-"+j%>" class="<%="enemy-"+j%> my-annimation-enemy" onclick="Attacked(this.id)">
            <h3 class="enemy-name"><%=enemies[j].getName() %></h3>
            <div class="etat-enemy">
                <div id = "<%="enemy-fill-"+j%>" class="fill-enemy"></div>
            </div>
        </div>
        <% } %>
        
    </div>
    	
    
    <%-- <script>
   
    const damage = 10;
    function etat(){
    	
	<% for (int j = 0; j < group.length; j++) { %>
		var elem = document.getElementById("player-"+<%=j%>);
	    var blode_level = <%=group[j].getPv() * 100 / charactersPv[j]%>;
	    
	    
		var fill = document.getElementById('<%="fill-"+j%>');
	    if (blode_level > 0) {
	        fill.style.width = '<%=group[j].getPv() * 100 / charactersPv[j] + "%"%>' ;
	    }else{
	        fill.style.width = 0;
	    }
	   <%
	   System.out.println("l'etat de player " + j + "est : " + group[j].getPv() + "--------l'etat de player initiale " + j + "est : " + charactersPv[j]);
	   }%>
    }
    function etat_enemy(){
    	<% for (int j = 0; j < enemies.length; j++) { %>
    		var elem = document.getElementById("enemy-"+<%=j%>);
    	    var blode_level = <%=enemies[j].getPv() * 100 / enemiesPv[j]%>;
    	    
    		var fill = document.getElementById('<%="enemy-fill-"+j%>');
    	    if (blode_level > 0) {
    	        fill.style.width =  '<%=enemies[j].getPv() * 100 / enemiesPv[j] + "%"%>';
    	    }else{
    	        fill.style.width = '0';
    	    }
    	   <%
    	   	System.out.println("l'etat de enemy " + j + "est : " + enemies[j].getPv() + "------------l'etat de enemy initial " + j + "est : " + enemiesPv[j]);
    	   }%>
        }
    </script> --%>
    <script src="index.js"></script>
   

</body>
</html>