<?php
/*
 * Inclure les packages nécéssaires au fonctionnement complet du site.  
 */
namespace JVCAT;                                    // Ce charge dans le Namespace JVCAT
        use JVCAT\DB;                               // Utilise le contenu du package JVCAT/DB (cotient les contrôleurs.)
	include "config/includes.php";              // inclus tout les fichiers à inclure pour charger les entités, contrôleurs, etc...
        
?>
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
 *          Autres pages commenté : "Accueil.php"
 *          Controleurs commenté : "db/GameHandler.php"
 *          Entité commenté : "entity/Game.php"
 * 
*	
*/

	
	require_once "config/config.php";                       // Configuration du site requis !
	
	if(isset($_GET['page'])) $getPage = $_GET['page'];      // Récupération de la page demandé
	?>

   <!-- Entête du site complet -->
    <head>
        <meta charset="UTF-8" />
        <title><?php echo $title; ?></title>
        <link rel="stylesheet" media="screen" type="text/css" title="defaut" href="CSS/<?php echo $css ?>.css">
        <link rel="icon" type="image/x-icon" href="<?php echo $title; ?>" />
    </head>
    <body>
    <!-- ****************** -->
    
		<?php
                $modules = "modules/";                          // Dossier des modules (entête menu, copyright en footer, etc...)
                
                include $modules."header.php";                  // Inclure le module de l'entête de page (menu)

                
                
		//                                              ------ Chargement de la page demandé -------
		if(isset($getPage)){ 				// Si une page est demandé,
                        $page = htmlspecialchars($getPage);     // stocke le nom de la page demandé de façon sécurisé
                        $getPage = $getPage.".php";             // définir le nom complet du fichier à charger.
			if (!file_exists($getPage)){            // Si cette page n'éxiste pas,
                                $page = "Accueil";              // Alors charger l'accueil par défaut.
                                $getPage = $page.".php";                               
			}
		}else{                                          // Si aucune page n'est demandé,
                        $page = "Accueil";                      // Charger l'accueil par défaut.
                        $getPage = $page.".php";
		}
                
                $page = str_replace("_", " ", $page);           // Remplace, après chargement de la page, les underscores du nom de la page par des éspaces.
                ?>
        
        
        <div class="corp"><h1><?php echo $title." - ".$page;    // Affichage des informations de la page : nom du site + page chargé.
        ?></h1> 
            <div class="box">
                <?php
                include $getPage;                               // charger la page demandé.
                ?></div></div><hr>
                <div class="corp" id="footer">
                    <?php
                    
                include $modules."footer.php";                  // Inclure le module de bas de page.
		?></div>

    </body>
</html>

