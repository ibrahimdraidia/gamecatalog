<?php
// REQUIS POUR L'ACCES AUX ENTITEES ET BASE DE DONNEE !!!
        namespace JVCAT;
        use JVCAT\DB;
        $gameHandler = new DB\GameHandler; // Controlleur de l'objet "Game", voir son fichier pour connaitre ses fonctions ! (db/GameHandler.php)
        
        if(!isset($_GET['id'])){
                        echo "<h1>Aucun jeu selectionné.</h1>";
                         exit();
                    }
                    
                    $id_game = htmlspecialchars($_GET['id']);
                    $game = $gameHandler->getById($id_game);
                    if(($game->getId_game()) == null){
                        echo "<h1>Aucun jeu selectionné.</h1>";
                         exit();
                    }
                    ?><div id="fiche">
		<div class="imgFiche"><img src="<?php echo $game->getGame_pic(); ?>" alt="GAME TITLE"></div>
		
		<div class="infoFiche">
                    <h1>
                <?php
                    echo $game->getGame_name();
                ?>
                    </h1>	
		<p> 
		<STRONG> EDITEUR: </STRONG><?php
                $result = $gameHandler->getEditors($game);                  // Même principe, on récupère les éditeurs du jeu.                                   // On compte combien il y a de réponse pour y placer le " - " à la fin du texte rendu.
                    foreach ($result as $KEY => $editor) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
                        echo ($editor->getEditor_name())." ";                                       // On l'affiche.
                    }
                ?></br>
		<STRONG> DEVELOPPEUR: </STRONG><?php
				$result = $gameHandler->getDevelopers($game);                  // Même principe, on récupère les éditeurs du jeu.
                                $count = count($result);                                   // On compte combien il y a de réponse pour y placer le " - " à la fin du texte rendu.
				foreach ($result as $KEY => $dev) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
					echo ($dev->getDeveloper_name());                                       // On l'affiche.
                                        if(--$count > 0){
                                            echo " / ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                                        }
				}
				?></br>
                <br><STRONG> GENRE: </STRONG><?php
				$result = $gameHandler->getGenres($game);                  // Même principe, on récupère les éditeurs du jeu.
                                $count = count($result);                                      // On compte combien il y a de réponse pour y placer le " - " à la fin du texte rendu.
				foreach ($result as $KEY => $genre) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
					echo ($genre->getGenre_name());                                       // On l'affiche.
                                        if(--$count > 0){
                                            echo " / ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                                        }
				}
				?></br>
		<STRONG> PLATEFORME: </STRONG><?php
				$result = $gameHandler->getPlatforms($game);                  // Même principe, on récupère les éditeurs du jeu.             
                                $count = count($result);                         // On compte combien il y a de réponse pour y placer le " - " à la fin du texte rendu.
				foreach ($result as $KEY => $platform) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
					echo ($platform->getPlatform_name());                                       // On l'affiche.
                                        if(--$count > 0){
                                            echo " / ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                                        }
				}
				?></br>
		<br><STRONG> DATE: </STRONG><?php
			echo $game->getGame_date();
				?></br>
		<br><STRONG> DESCRIPTION: </STRONG><br><?php
			echo $game->getGame_summary();
				?></br>
		</p>
		</div>
                </div>
