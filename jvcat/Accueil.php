<?php 	
/*
 * Inclure les packages nécéssaires au fonctionnement complet du site.  
 */
namespace JVCAT;                                // Ce charge dans le Namespace JVCAT
        use JVCAT\DB;                           // Utilise le contenu du package JVCAT/DB (cotient les contrôleurs.)
        $gameHandler = new DB\GameHandler();    // On récupère un Controlleur de l'objet "Game", voir son fichier pour connaitre ses fonctions ! (db/GameHandler.php)
?>

<!DOCTYPE html>
	<hr/><h1>PROCHAINES SORTIES</h1>
	<!-- MISE EN PLACE DU TABLEAU AVEC IMAGE DES JAQUETTES-->
    <div class="vignette"><table>
             <tr><?php
            $limit = 6;                                                             // On défini la limite de jeux à récupérer par demande.
            $games = $gameHandler->getAllToRelease($limit);                         // On récupère tout les jeux 'qui vont sortir', via le contrôleur, sous forme de tableau d'objets "Game".
           
            foreach ($games as $game) {                                             // Pour chaque jeu récupéré dans le tableau...


                                        $id_game = $game->getId_game();             // On récupère toutes les informations dont on a besoin de notre jeu via les Getter.
					$nom = $game->getGame_name();
                                        $pic = $game->getGame_pic();
					$genres = $gameHandler->getGenres($game);
					$date = $game->getGame_date();
					$pf = $gameHandler->getPlatforms($game);


					?>
            
	
		<td>                                                            <!-- N'OUBLIEZ DE REMPLACER LA SRC DE L'IMAGE !!!! | Réponse de Kévin : Fait ;) -->
                    
                                                                                <?php // On affiche les données dans un tableau pour chaque jeu. ?>
                    <a href="./?page=Fiche_Jeu&id=<?php echo $id_game; ?>"><img src="<?php echo $pic; ?>" alt="<?php echo $id_game; ?>"></a>    
                        
		</td>
	<?php	}                                                                   //  Fin de la boucle pour afficher chaque jeu récupéré. ?></tr>
</table></div><hr/> 
<h1>DERNIERES SORTIES</h1>
<div class="vignette">
<table>
	<tr><?php
            $limit = 6;                                                             // Comme au dessus, on défini une nouvelle limite.
            $games = $gameHandler->getAllOut($limit);                               // Et on refait la même chose, les même boucles, mais avec le Handler qui récupère cette fois tout jeux 'Qui vont sortir'
           
            foreach ($games as $game) {


                                        $id_game = $game->getId_game();
					$nom = $game->getGame_name();
                                        $pic = $game->getGame_pic();
					$genres = $gameHandler->getGenres($game);
					$date = $game->getGame_date();
					$pf = $gameHandler->getPlatforms($game);


					?>
            
	
		<td> <!-- N'OUBLIEZ DE REMPLACER LA SRC DE L'IMAGE !!!! -->
                    <a href="./?page=Fiche_Jeu&id=<?php echo $id_game; ?>"><img src="<?php echo $pic; ?>" alt="SELECT FROM TABLE TITRE"></a>
		</td>
	<?php	}                                                                   // Fin de la boucle.        ?></tr>
</table></div><hr/> 