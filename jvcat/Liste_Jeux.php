<?php
namespace JVCAT;
use JVCAT\DB;
$gameHandler = gameHandler(); // Controlleur de l'objet "Game", voir son fichier pour connaitre ses fonctions ! (db/GameHandler.php)
$limit = 100;
                                
                                if((!isset($_POST['search']) or $_POST['search'] == null) and (!isset($_GET['pf']) or $_GET['pf'] == null) and (!isset($_GET['genre']) or $_GET['genre'] == null)){
                                    $games = getAll($limit);
                                }elseif(isset($_GET['pf'])){
                                    $pf_id = trim(htmlspecialchars($_GET['pf']));
                                    $games = getAllByPlatform($pf_id, $limit);
                                }elseif(isset($_GET['genre'])){
                                    $genre_id = trim(htmlspecialchars($_GET['genre']));
                                    $games = getAllByGenre($genre_id, $limit);
                                }else{
                                    $search_field = trim(htmlspecialchars($_POST['search']));
                                    $filter_field = trim(htmlspecialchars($_POST['filter']));
                                    
                                    if($filter_field == 0){ // Recherche par nom
                                        $games = getAllByName($search_field, $limit);
                                    }elseif($filter_field == 1){ // Recherche par éditeur
                                        $games = getAllByEditor($search_field, $limit);
                                    }elseif($filter_field == 2){ // Recherche par développeur
                                        $games = getAllByDev($search_field, $limit);
                                    }
                                    
                                }
                                
                                
                                
                                if($games == null){
                                    echo "<h1>Aucun jeu trouvé.</h1>";
                                     exit();
                                }

?>
		<div class="listeJeux">
			<table>
				<tr>
                                        
					<th>Nom</th>
					<th>Genre</th>
					<th>Date</th>
					<th>Plateforme</th>
				</tr>
				<?php 
                                
                                
                                
				foreach ($games as $game) {


                                        $id_game = $game->getId_game();
					$nom = $game->getGame_name();
                                        $pic = $game->getGame_pic();
					$genres = $gameHandler->getGenres($game);
					$date = $game->getGame_date();
					$pf = $gameHandler->getPlatforms($game);


					?>
                                
                                <tr onmouseover="style='cursor: pointer;'" onclick="window.document.location='./?page=Fiche_Jeu&id=<?php echo $id_game;?>';">
                                             <td>
                                                 <a href="./?page=Fiche_Jeu&id=<?php echo $id_game;?>"><img src="<?php echo $pic; ?>" alt="<?php echo $nom; ?>"></a>
                                                <br><?php echo $nom; ?></td>
                                            
						<td><?php
                                                $count = count($genres);
                                                    foreach ($genres as $KEY => $genre) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
                                                            
                                                            echo ($genre->getGenre_name());                                       // On l'affiche.
                                                            if(--$count > 0){
                                                                echo " / ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                                                            }
                                                    }
						?></td>
						<td>
							<?php echo $date; ?>
						</td>
						<td>
                                                <?php
                                                $count = count($pf);
                                                    foreach ($pf as $KEY => $platform) {                      // Comme pour les jeux, pour chaque NOM d'éditeur,
                                                            echo ($platform->getPlatform_name());                                       // On l'affiche.
                                                            if(--$count > 0){
                                                                echo " / ";                                         // Plus d'éditeur à afficher, on termine avec " - "
                                                            }
                                                    }
                                                ?>
						</td>
					</tr>
				<?php	}?>
			</table>
		</div>
		
<?php
        
        function gameHandler(){
            $gamehandler = new DB\GameHandler;
            return $gamehandler;
        }

        function getAll($limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAll($limit);
            return $games;
        }
        
        function getAllByName($string, $limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAllByName($string, $limit);
            return $games;
        }
        
        function getAllByEditor($string, $limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAllByEditorName($string, $limit);
            return $games;
        }
        
        function getAllByDev($string, $limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAllByDeveloperName($string, $limit);
            return $games;
        }
        
        function getAllByPlatform($id, $limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAllByPlatformId($id, $limit);
            return $games;
        }
        
        function getAllByGenre($id, $limit){
            $gameHandler = gameHandler();
            $games = $gameHandler->getAllByGenreId($id, $limit);
            return $games;
        }

?>