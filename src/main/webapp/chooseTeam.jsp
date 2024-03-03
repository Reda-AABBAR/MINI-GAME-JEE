
<%@page import="com.model.Wizard"%>
<%@page import="com.model.Knight"%>
<%@page import="com.metie.CharacterPrototypeRegistry"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
	<%
	  Character[] groupe = (Character[]) request.getAttribute("groupe-table");
	  Integer i = (Integer)request.getAttribute("playersFill");
	  //String[] playersType = (String[]) request.getAttribute("playersType");
	  String[] imagesPath = (String[]) session.getAttribute("imagesPath");
	%>
	
	<% 
		session.setAttribute("groupe", groupe);
		session.setAttribute("playersFill", i);
		//session.setAttribute("playersType", playersType);
		session.setAttribute("imagesPath", imagesPath);
    %>
    <%
    	CharacterPrototypeRegistry characters = (CharacterPrototypeRegistry) session.getAttribute("characters");
    	if(characters == null)
    		characters = new CharacterPrototypeRegistry();
    	session.setAttribute("characters", characters);
    %>
	<div class="group-choose-container">
        <h1>Choose the players</h1>
        <div class="group-choose">
            
            <%
              Knight knight1 = (Knight) characters.getCharacters().get("knight1").copy();
              Knight knight2 = (Knight) characters.getCharacters().get("knight2").copy();
              Wizard wizard1 = (Wizard) characters.getCharacters().get("wizard1").copy();
              Wizard wizard2 = (Wizard) characters.getCharacters().get("wizard2").copy();
              Wizard wizard3 = (Wizard) characters.getCharacters().get("wizard3").copy();
            %>
            <div class="Players-Redistry">
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2><%=knight1.getName() %></h2>
                <label>pv : </label>
                <label><%= knight1.getPv() %></label><br>
				<form action="CreatePlayers" method="post">
                	<input name="player" class = "chooser" value=<%=knight1.getName()%>>
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2><%=knight2.getName() %></h2>
                <label>PV : </label>
                <label><%= knight2.getPv() %></label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player" class = "chooser" value=<%=knight2.getName()%>>
                	
                	<button type="submit">add</button>
                </form>
                
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2><%=wizard1.getName() %></h2>
                <label>PV : </label>
                <label><%= wizard1.getPv() %></label><br>
                <label>PM : </label>
                <label><%= wizard1.getMp()%></label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player" class = "chooser" value=<%=wizard1.getName()%>>
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2><%=wizard2.getName() %></h2>
                <label>PV : </label>
                <label><%= wizard2.getPv() %></label><br>
                <label>PM : </label>
                <label><%= wizard2.getMp()%></label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player" class = "chooser" value=<%=wizard2.getName()%>>
                	<button type="submit">add</button>
                </form>
            </div>
            <div class="player">
                <img src="img/wizard.jpg" alt="">
                <h2><%=wizard3.getName() %></h2>
                <label>PV : </label>
                <label><%= wizard3.getPv() %></label><br>
                <label>PM : </label>
                <label><%= wizard3.getMp()%></label><br>
                <form action="CreatePlayers" method="post">
                	<input name="player" class = "chooser" value=<%=wizard3.getName()%>>
                	<button type="submit">add</button>
                </form>
            </div>
            </div>
            <div class="clear"></div>
            <div class="team">
            <%if(groupe != null){ %>
                <div>
                    <label class="your-team-label">Your team : </label>
                </div>
                <%
	                	for(Character character : groupe)
	                	{ if(character != null){
	                			if(character instanceof Knight){%>
	                			<div class="player">
			                        <img src=<%="img/wizard.jpg" %> alt="">
			                        <h2><%=character.getName()%></h2>
			                        <label>PV : </label>
			                        <label><%= character.getPv()%></label>
		                    	</div>
		                    	<%}
	                			else if(character instanceof Wizard){%>
		                			<div class="player">
				                        <img src=<%="img/wizard.jpg" %> alt="">
				                        <h2><%=character.getName()%></h2>
				                        <label>PV : </label>
				                        <label><%= character.getPv()%></label><br>
				                        <label>PM : <%=((Wizard) character).getMp() %></label>
			                    	</div>
			                    <%} %>
	                		
	                	<%
	                	 }
	                	}
            }
                %>
                
            </div>
            <div class="clear"></div>
            <button class ="next" onclick="check(<%=i%>,<%=groupe.length%>)">next</button>
        </div>
        <div>
            
        </div>
    </div>
    <script src="index.js">
    const check = (i,lenth) => {
    	if(i < lenth)
    		alert("Your team have not complited!");
    	else
    		window.location.href = "Game";
    }
    </script>
    <% if(imagesPath != null)
    for(int j = 0; j < imagesPath.length;j++){
    	System.out.println(imagesPath[j]);
    }else{
    	System.out.println("image path is null");
    }
    
    %>
</body>
</html>