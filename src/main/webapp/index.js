// const annimation = (id,width,height,nbr_elements,img_url) => {
//     const elem = document.getElementById(id);
//     const freams_width = width / nbr_elements;
//     const img = url(img_url);
//     let p = 0;
//     elem.style.width = freams_width;
//     elem.style.height = height;
//     for (let i = 0; i < width; i = freams_width * p) {
//         elem.style.background = `${img}`;
//         elem.style.backgroundPosition = `${i}`;
//         p++;
//     }
// }
let players = new Array(5);

for(let i = 0; i < 5; i++){
	players[i] = document.getElementById("player-" + i);
}
let enemies = new Array(5);
for(let i = 0; i < 5; i++){
	enemies[i] = document.getElementById("enemy-" + i);
}
let nbrPlayers = 0;
for(let i = 0; i < 5; i++){
	if(players[i] != null)
		nbrPlayers++;
}
let counter = 0;
let positionx = new Array(nbrPlayers);
let positiony = new Array(nbrPlayers);
for(let i = 0; i < nbrPlayers; i++){
	positionx[i] = players[i].getBoundingClientRect().x;
	positiony[i] = players[i].getBoundingClientRect().y;
}

let positionx_enemy = new Array(nbrPlayers);
let positiony_enemy = new Array(nbrPlayers);
for(let i = 0; i < nbrPlayers; i++){
	positionx_enemy[i] = enemies[i].getBoundingClientRect().x;
	positiony_enemy[i] = enemies[i].getBoundingClientRect().y;
}
//--------------------------------------------------------------
/*var fill = document.getElementById('fill-0');
if(fill != null){
fill.style.width = '20%';
fill.style.backgroundColor='green';
}*/
//--------------------------------------------------------------
const animation = (id, width, height, nbr_elements, img_url) => {
    
    const elem = document.getElementById(id);
    let frames_width = width / nbr_elements;
    const img = `url(${img_url})`;
    /*elem.style.width = `${frames_width}px`;
    console.log(frames_width);
    elem.style.height = `${height}px`;*/
    elem.style.background = img;
    elem.style.backgroundSize = 'cover';
    let p = 0;
    const animateFrames = () => {
        let position ;
        if (p < nbr_elements) {
            // ce condition est pour le run-attack splite erreur solution
            //if(p < (nbr_elements/2))
            position=`-${86 * p}px 0`;
           /* else
            position=`-${(frames_width) * p}px 0`;*/
            elem.style.backgroundPosition = position;
            p++;
            setTimeout(animateFrames, 200); 
        }
    };

    animateFrames();
};

const animation2 = (id, width, height, nbr_elements, img_url) => {
    
    const elem = document.getElementById(id);
    let frames_width = width / nbr_elements;
    const img = `url(${img_url})`;
    // elem.style.width = `${frames_width}px`;
    elem.style.background = img;
    elem.style.backgroundSize = 'cover';
    let p = 0;
    const animateFrames = () => {
        let position ;
        if (p < nbr_elements) {
            position=`-${(frames_width) * p}px 0`;
            elem.style.backgroundPosition = position;
            p++;
            setTimeout(animateFrames, 200); 
        }
    };

    animateFrames();
};

const etatCharactaire = (id,pv,pv_initial) =>{
    const elem = document.getElementById(id);
    const blode_level = pv * 100 / pv_initial;
    

    if (blode_level > 0) {
        elem.style.width = `${blode_level}%`;
    }else{
        elem.style.width = 0;
    }
}

const play = (id)=>{
	document.getElementById(id).remove();
}

const check = (i,lenth) => {
	if(i < lenth)
		alert("Your team have not complited!");
	else
		window.location.href = "Game";
}


function updateCharacters() {
            characters.forEach(character => {
                character.position += 1; // Modifier la position selon vos besoins

                // Mettre à jour la position du personnage
                character.element.style.left = character.position + 'px';
            });

            // Demander la prochaine frame d'animation
            requestAnimationFrame(updateCharacters);
        }
 function charactersAnimation(){
	        /*for (let j = 0; j < 5; j++) {
	            animation('player-'+ j , 430, 86, 5, `elements/Fire vizard/Attack_1.png`);
	            Console.log("hi i'm excuted");
	         };*/
	          animation('player-0', 430, 86, 4, `elements/Fire vizard/Attack 2.png`);
 }

 const Attacked2 = (idEnemy) => {
					let player;
				    let enemy;
				    let enemyRect;
				    let originalPos;
				    let xa,ya;
				   if(counter >= 0 && counter < nbrPlayers){
					    enemy = document.getElementById(idEnemy);
		                player = document.getElementById('player-'+(counter));
		                /*originalPos = player.getBoundingClientRect();*/
		               /* xa = originalPos.x;
		                ya=originalPos.y;*/
		                enemyRect = enemy.getBoundingClientRect();
		                player.style.top  = (enemyRect.top) + "px"; 
		                player.style.left = (enemyRect.right - 142) + "px"; 
		                animation(player.id, 430, 86, 5, "elements/Fire vizard/Attack_2.png");
		                animation(enemy.id, 430, 86, 2, "elements/Red_Werewolf/Hurt.png");
		                //enemy.style.background = url('elements/Red_Werewolf/Idle.png');
		                enemy.style.backgroundPosition = '0 0';
		                enemy.style.backgroundSize = 'cover';
		                /*player.style.top = (xa) + "px"; 
		                player.style.left = (ya) + "px"; */
		                counter++;
		                console.log(counter);
				   } else if( counter == nbrPlayers){
					  for(let i = 0; i < nbrPlayers; i++){
						  	enemy = document.getElementById('enemy-'+i);
						  	originalPos = enemy.getBoundingClientRect();
					        player = document.getElementById('player-'+i);
					        playerRect = player.getBoundingClientRect();
					        enemy.style.top = (playerRect.y) + "px"; 
					        enemy.style.left = (playerRect.right - 142) + "px";
					        animation(enemy.id, 430, 86, 4, "elements/Red_Werewolf/Attack_2.png"); 
					        animation2(player.id, 120, 86, 2, "elements/Knight_1/Hurt.png");
					        /*enemy.style.background = url('elements/Red_Werewolf/Idle.png');*/
					        enemy.style.backgroundPosition = '0 0';
					        enemy.style.backgroundSize = 'cover';
					        enemy.style.top = (originalPos.y) + "px"; 
		                	enemy.style.left = (originalPos) + "px";
					  }
				   }
	            }
const Attacked = async (idEnemy) => {
    let player;
    let enemy;
    let originalPos;
	
    if (counter >= 0 && counter < nbrPlayers) {
        enemy = document.getElementById(idEnemy);
        player = document.getElementById('player-' + counter);
        originalPos = enemy.getBoundingClientRect();

        player.style.top = (originalPos.top) + "px";
        player.style.left = (originalPos.right - 142) + "px";
        animation(player.id, 430, 86, 5, "elements/Fire vizard/Attack_2.png");
        animation(enemy.id, 430, 86, 2, "elements/Red_Werewolf/Hurt.png");

        await new Promise(resolve => setTimeout(resolve, 1000)); // Délai d'une seconde
        resetPositions();
		etat2();
        counter++;
    } else if (counter === nbrPlayers) {
        for (let i = 0; i < nbrPlayers; i++) {
            enemy = document.getElementById('enemy-' + i);
            player = document.getElementById('player-' + i);
            originalPos = player.getBoundingClientRect();

            enemy.style.top = (originalPos.top) + "px";
            enemy.style.left = (originalPos.right - 142) + "px";
            animation(enemy.id, 430, 86, 4, "elements/Red_Werewolf/Attack_2.png");
            animation2(player.id, 120, 86, 2, "elements/Knight_1/Hurt.png");
            await new Promise(resolve => setTimeout(resolve, 1000)); // Délai d'une seconde
            resetPositions();
            counter++;
            etat2();
        }
         counter = 0;
    }
      console.log(idEnemy);
    fetch('Attack?id=' + idEnemy)
            .then(response => {
                
               
              console.log('attacked');
            })
            .catch(error => console.error('Erreur lors de la requête vers la servlet "Attack":', error));
     
    
};

/*const resetPositions = () => {
    for (let i = 0; i < nbrPlayers; i++) {
        const player = document.getElementById('player-' + i);
        const enemy = document.getElementById('enemy-' + i);
        const playerOriginalPos = player.getBoundingClientRect();
        const enemyOriginalPos = enemy.getBoundingClientRect();

        player.style.top = (playerOriginalPos.top) + "px";
        player.style.left = (playerOriginalPos.right - 142) + "px";

        enemy.style.top = (enemyOriginalPos.top) + "px";
        enemy.style.left = (enemyOriginalPos.right - 142) + "px";
    }
};*/
const resetPositions = () => {
    for (let i = 0; i < nbrPlayers; i++) {
        const player = document.getElementById('player-' + i);
        const enemy = document.getElementById('enemy-' + i);
       

        player.style.top = (positiony[i]) + "px";
        player.style.left = (positionx[i]) + "px";
        enemy.style.top = (positiony_enemy[i]) + "px";
        enemy.style.left = (positionx_enemy[i]) + "px";
        player.style.background = 'url("elements/Knight_1/Attack 1.png")';
        enemy.style.background = 'url("elements/Red_Werewolf/Idle.png")';
        player.style.backgroundSize = 'cover';
        enemy.style.backgroundSize = 'cover';
    }
};

 const playerGetAttacked = (idPlayer,idEnemy,order) => {
	let player;
    let enemy;
    let playerRect;
   if( order > nbrPlayers && order <= nbrPlayers * 2 ){
	    enemy = document.getElementById(idEnemy);
        player = document.getElementById(idPlayer);
        playerRect = player.getBoundingClientRect();
        enemy.style.top = (playerRect.y) + "px"; 
        enemy.style.left = (playerRect.right - 142) + "px";
        animation(enemy.id, 430, 86, 4, "elements/Red_Werewolf/Attack_2.png"); 
        animation2(player.id, 120, 86, 2, "elements/Knight_1/Hurt.png");
        enemy.style.background = url('elements/Red_Werewolf/Idle.png');
        enemy.style.backgroundPosition = '0 0';
        enemy.style.backgroundSize = 'cover';
   }
}

 const etat2 = ()=>{
	   const xhr = new XMLHttpRequest();
	   xhr.open('GET','/game/Attack?command=data',true);
	   
	   xhr.onload = () =>{
		   if(xhr.status >= 200 && xhr.status < 300){
			   const characters = JSON.parse(xhr.responseText);
			   
			   for(p in characters.players){
				    var blode_level = characters.players[p].pv * 100 / characters.players[p].maxPV;
				    
				    
					var fill = document.getElementById('fill-'+characters.players[p].id);
				    if (blode_level > 0) {
				        fill.style.width = blode_level + '%';
				    }else{
				        fill.style.width = 0;
				    }
				}
				
				for(p in characters.enemies){
				    var blode_level = characters.enemies[p].pv * 100 / characters.enemies[p].maxPV;
					var fill = document.getElementById('enemy-fill-'+characters.enemies[p].id);
				    if (blode_level > 0) {
				        fill.style.width = blode_level + '%';
				    }else{
				        fill.style.width = 0;
				    }
				}
				
				
		   }else{
			   console.log('error');
		   }
	   }
	   xhr.send();
   }
   
   document.onload = etat2();