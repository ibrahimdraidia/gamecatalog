<?php namespace JVCAT; ?>
<!DOCTYPE html>
<html>
<?php

/*	
*	
*	Jeux Video Web Client - Index.php 
*	
*	Le site tourne entièrement sur cette page, elle va charger les pages demandé par le visiteur.
*	Elle charge aussi le fichier de configuration qui gère la connexion à la base de donnée, et le titre du site, etc...
*	Pour la sécurité du site, vous n'accedez JAMAIS à une autre page que "index.php" !
*	
*/

	// Configuration du site requis !
	require_once "config/config.php";
	// Récupération de la page demandé
	if(isset($_GET['page'])) $getPage = $_GET['page'];
	?>

    <head>
        <meta charset="UTF-8" />
        <title><?php echo $title; ?></title>
        <link rel="icon" type="image/x-icon" href="<?php echo $title; ?>" />
    </head>
    <body>
		<?php
		// 									------ Chargement de la page demandé -------
		if(isset($getPage)){ 				// Si une page est demandé,
			if (!file_exists($getPage)){ 	// mais que cette page n'éxiste pas,
				echo "Page introuvable !"; 	// alors afficher une érreur,
			}else{							// sinon,
				include $getPage;			// charger la page demandé.
			}
		}else{								// Si aucune page n'est demandé,	
			include "Accueil.php";			// Charger la page Accueil par défaut.
		}
		?>

		
    </body>
</html>