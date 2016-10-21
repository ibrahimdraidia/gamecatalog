<?php
        // REQUIS POUR L'ACCES AUX ENTITEES ET BASE DE DONNEE !!!
        namespace JVCAT;
        use JVCAT\DB;
        $gameHandler = new DB\GameHandler; // Controlleur de l'objet "Game", voir son fichier pour connaitre ses fonctions ! (db/GameHandler.php)
        
        
        
                    $limit = 3; // Limite de jeux à afficher pour les fonctions d'affichage de tout les jeux
                    
                    // Affichage de tout les jeux
                    $result = $gameHandler->getAll($limit);                     // Récupère tout les jeux de la base de donnée (avec limite définis, sauf si NULL) et en faire un objet "Game"
                    echo "<br>GetAll($limit) (Limited by $limit) -> <br>";      // Affiche la commande execéuté
                    foreach($result as $gamesK => $game){                       // Pour chaque "Game" récupéré,
                                                                                //
                        echo ($game->getGame_Name())."<br>";                    // Afficher le "nom du Jeu"
                    }
                    
                    // Affichage de tout les jeux à venir
                    $result = $gameHandler->getAllToRelease($limit);            // Pareil que au dessus, mais avec une fonction qui sort uniquement les jeux à venir.
                    echo "<br>GetAllToRelease($limit) (Limited by $limit) -> <br>";
                    foreach($result as $gamesK => $game){
                        
                        echo ($game->getGame_Name())."<br>"; 
                    }
                    
                    // Affichage de tout les jeux PS4
                    $result = $gameHandler->getAllByPlatformId(2);            
                    echo "<br>GetAllPS4Games -> <br>";
                    foreach($result as $gamesK => $game){
                        
                        echo ($game->getGame_Name())."<br>"; 
                    }
                    
                    // Affichage de tout les jeux selon nom
                    $result = $gameHandler->getAllByName("Miku");            
                    echo "<br>GetAllMIKUGames -> <br>";
                    foreach($result as $gamesK => $game){
                        
                        echo ($game->getGame_Name())."<br>"; 
                    }
                    
                    // Affichage de tout les jeux selon nom d'éditeur
                    $result = $gameHandler->getAllByEditorName("Sega");            
                    echo "<br>GetAllSEGAGames -> <br>";
                    foreach($result as $gamesK => $game){
                        
                        echo ($game->getGame_Name())."<br>"; 
                    }
                    
                    // Affichage de tout les jeux selon nom développeur
                    $result = $gameHandler->getAllByDeveloperName("cry");            
                    echo "<br>GetAllCryptonGames -> <br>";
                    foreach($result as $gamesK => $game){
                        
                        echo ($game->getGame_Name())."<br>"; 
                    }
                    
                    // Affichage d'un jeu selon l'id,
                    $id = 4;                                                    // Définie quel jeu à récupérer, son ID. (on pourrai donc aussi le récupéré dans un objet jeu déjà récupéré.
                    $result = $gameHandler->getById($id);                       // Exemple : Liste de jeu cliquable, qui met en Get l'id du jeu, puis le récupérer dans cette fonction pour la fiche du jeu par exemple
                    $game = $result;                                            // Comme au dessus, "result" est devenue un objet, donc on y pointe "game" histoire d'avoir un Game, nommé game :p
                    echo "<br>GetById($id) -> ".($game->getGame_Name());        // Et on affiche l'unique résultat
                    echo " - ";
                    
                    // Editeur
                    $result = $gameHandler->getEditors($game);                  // Même principe, on récupère les éditeurs du jeu.
                    $count = count($result);                                    // On compte combien il y a de réponse pour y placer le " - " à la fin du texte rendu.
                    foreach ($result as $KEY => $editor) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
                        echo ($editor->getEditor_name())." ";                                       // On l'affiche.
                        if(--$count <= 0){
                            echo " - ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                        }
                    }
                    
                    // de son/ses Developpeurs
                    $result = $gameHandler->getDevelopers($game);               // Pareil pour les devs, les genres, et les plateformes.
                    $count = count($result);
                    foreach ($result as $KEY => $dev) {
                        echo $dev->getDeveloper_name()." ";
                        if(--$count <= 0){
                            echo " - ";
                        }
                    }
                    
                    // de son/ses Genres
                    $result = $gameHandler->getGenres($game);
                    $count = count($result);
                    foreach ($result as $KEY => $genre) {
                        echo $genre->getGenre_name()." ";
                        if(--$count <= 0){
                            echo " - ";
                        }
                    }
                    
                    // de son/ses Plateformes
                    $result = $gameHandler->getPlatforms($game);
                    $count = count($result);
                    foreach ($result as $KEY => $platform) {
                        echo $platform->getPlatform_name()." ";
                        if(--$count <= 0){
                            echo " - ";
                        }
                    }
                    
                    echo "<br><br>".$game->getGame_summary();
                    
                    ?>