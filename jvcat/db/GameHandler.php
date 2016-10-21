<?php

/*
 * Contrôleur des jeux
 * Le coeur de la bête~
 * 
 * 
 * 
 */
namespace JVCAT\DB;                         // Ce charge dans le package JVCAT/DB
USE JVCAT\config;                           // Utilise les config du site
USE JVCAT\entity;                           // Et les entités
USE PDO;                                    // Ainsi que PDO pour la gestion de la base de donnée
include "./interfaces/CrudInterface.php";   // Inclus l'interface du CRUD
include "./config/mysql_connection.php";    // Inclus la connexion MySql
include "./entity/Entities.php";            // Inclus toutes les entités (vu qu'elles sont toutes utilent à Game)


class GameHandler implements CrudInterface{
	private $bdd;
	
	public function __construct() {
		$this->bdd = SQL::$bdd;     // A la construction du contrôlleur, on récupère dans la classe static SQL l'instance de la base de donnée connecté.
	}


	public function add() {
                
	}


	public function update() {
		
	}


	public function remove() {
		
	}

        
        /*
         * 
         * Toutes les fonctions de récupération des données constitue le contrôleur complet.
         * Première fonction commenté, ainsi qu'une fonction sur les liens via des tables relationel en ligne 303 !
         */
        
        // SELECTIONNER TOUT LES JEUX DE LA DB
	public function getAll($limit = 0) {
            $games = null;                                                                                          // Intialisation du tableau de jeux à renvoyer.
            try{                                                                                                    // On essaye de...
                if($limit == 0){                                                                                    //  Si la limite est égal à zero (ce qu'elle l'est si non précisé.)
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` ORDER BY `NAME_GAME` ASC");                   //      Prépare la requête SQL "Séléctionner tout de Game trié par Name_Game Ascendant."
                    $query->execute();                                                                              //      Exécute la requête
                }else{                                                                                              //  Sinon
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` ORDER BY `NAME_GAME` ASC LIMIT :limit");      //      Prépare la même requête en ajouant l'information "Limiter à :limit résultats"
                    $query->bindValue(":limit", (int) trim($limit), PDO::PARAM_INT);                                //      Applique la variable $Limit à l'information :limit dans la requête
                    $query->execute();                                                                              //      Exécute la requête
                }                                                                                                   //  Fin
                
                while ($gamesBD = $query->fetch()){                                                                                                                         // Tant que il y a des résultats
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);   //  Créer un jeu avec le résultat
                    $games[] = $game;                                                                                                                                       //  Et l'ajouter à un tableau de Jeux
                }                                                                                                                                                           // Fin
            }catch(PDOException $e){                                                                                // Si y'a un soucis...
                $games = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();    // Il sera forcément d'origine SQL, et on récupère une érreur.
                
            }
            return $games;                                                                                          // On renvoi à la demande (dans la vue donc) notre tableau des jeux complet.
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB QUI CONTIENNENT UN NOM DONNE
	public function getAllByName($name, $limit = 0) {
            $name = "%".htmlspecialchars($name)."%";
            $games = null;
            try{
                if($limit == 0){
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE NAME_GAME LIKE :name ORDER BY `ID_GAME` DESC");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->execute();
                }else{
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE NAME_GAME LIKE :name ORDER BY `ID_GAME` DESC LIMIT :limit");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->bindValue(":limit", (int) $limit, PDO::PARAM_INT);
                    $query->execute();
                }
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB QUI CONTIENNENT UN NOM DE EDITEUR DONNE
	public function getAllByEditorName($name, $limit = 0) {
            $name = "%".htmlspecialchars($name)."%";
            $games = null;
            try{
                if($limit == 0){
                    $query = SQL::$bdd->prepare("SELECT game.* FROM `game` LEFT JOIN edits ON game.ID_GAME = edits.ID_GAME LEFT JOIN editor ON edits.ID_EDITOR = editor.ID_EDITOR WHERE editor.NAME_EDITOR LIKE :name ORDER BY game.ID_GAME DESC");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->execute();
                }else{
                    $query = SQL::$bdd->prepare("SELECT game.* FROM `game` LEFT JOIN edits ON game.ID_GAME = edits.ID_GAME LEFT JOIN editor ON edits.ID_EDITOR = editor.ID_EDITOR WHERE editor.NAME_EDITOR LIKE :name ORDER BY game.ID_GAME DESC LIMIT :limit");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->bindValue(":limit", (int) $limit, PDO::PARAM_INT);
                    $query->execute();
                }
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB QUI CONTIENNENT UN NOM DE EDITEUR DONNE
	public function getAllByDeveloperName($name, $limit = 0) {
            $name = "%".htmlspecialchars($name)."%";
            $games = null;
            try{
                if($limit == 0){
                    $query = SQL::$bdd->prepare("SELECT game.* FROM `game` LEFT JOIN develops ON game.ID_GAME = develops.ID_GAME LEFT JOIN developer ON develops.ID_DEV = developer.ID_DEV WHERE developer.NAME_DEV LIKE :name ORDER BY game.ID_GAME DESC");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->execute();
                }else{
                    $query = SQL::$bdd->prepare("SELECT game.* FROM `game` LEFT JOIN develops ON game.ID_GAME = develops.ID_GAME LEFT JOIN developer ON develops.ID_DEV = developer.ID_DEV WHERE developer.NAME_DEV LIKE :name ORDER BY game.ID_GAME DESC LIMIT :limit");
                    $query->bindValue(":name", (string) $name, PDO::PARAM_INT);
                    $query->bindValue(":limit", (int) $limit, PDO::PARAM_INT);
                    $query->execute();
                }
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB OU LA PLATEFORME CORRESPOND A UN ID
	public function getAllByGenreId($id) {
            $games = null;
            try{
                $query = SQL::$bdd->prepare("SELECT game.* FROM game LEFT JOIN of_the_genre AS ofgenre ON game.ID_GAME = ofgenre.ID_GAME LEFT JOIN `genre` ON ofgenre.ID_GENRE = genre.ID_GENRE WHERE genre.ID_GENRE = :id");
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);
                $query->execute();
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        
        // SELECTIONNER TOUT LES JEUX DE LA DB OU LA PLATEFORME CORRESPOND A UN ID
	public function getAllByPlatformId($id) {
            $games = null;
            try{
                $query = SQL::$bdd->prepare("SELECT game.* FROM game LEFT JOIN on_the_platform AS ofplatform ON game.ID_GAME = ofplatform.ID_GAME LEFT JOIN `platform` ON ofplatform.ID_PLATFORM = platform.ID_PLATFORM WHERE platform.ID_PLATFORM = :id");
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);
                $query->execute();
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB QUI ONT UNE SORTIE A VENIR
        public function getAllToRelease($limit = 0) {
            $games = null;
            try{
                if($limit == 0){
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE `RELEASE_DATE` > CURDATE() ORDER BY `RELEASE_DATE` ASC");
                    $query->execute();
                }else{
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE `RELEASE_DATE` > CURDATE() ORDER BY `RELEASE_DATE` ASC LIMIT :limit");
                    $query->bindValue(":limit", (int) trim($limit), PDO::PARAM_INT);
                    $query->execute();
                }
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUT LES JEUX DE LA DB QUI VIENNENT DE SORTIR
        public function getAllOut($limit = 0) {
            $games = null;
            try{
                if($limit == 0){
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE `RELEASE_DATE` <= CURDATE() ORDER BY `RELEASE_DATE` DESC");
                    $query->execute();
                }else{
                    $query = SQL::$bdd->prepare("SELECT * FROM `game` WHERE `RELEASE_DATE` <= CURDATE() ORDER BY `RELEASE_DATE` DESC LIMIT :limit");
                    $query->bindValue(":limit", (int) trim($limit), PDO::PARAM_INT);
                    $query->execute();
                }
                
                while ($gamesBD = $query->fetch()){
                    $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
                    $games[] = $game;
                }
            }catch(PDOException $e){
                $games[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $games;
		
	}
        
        // SELECTIONNER TOUTES LES PLATEFORMES DE LA DB
	public function getAllPlatforms() {
            $arrayOfObject = null;
            try{
                $query = SQL::$bdd->prepare("SELECT * FROM `platform` ORDER BY `ID_PLATFORM` DESC");
                $query->execute();
                
                while ($DB = $query->fetch()){
                    $object = new entity\Platform($DB['ID_PLATFORM'], $DB['NAME_PLATFORM']);
                    $arrayOfObject[] = $object;
                }
            }catch(PDOException $e){
                $arrayOfObject[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $arrayOfObject;
		
	}
        
        // SELECTIONNER TOUT LES GENRES DE LA DB
	public function getAllGenres() {
            $genres = null;
            try{
                $query = SQL::$bdd->prepare("SELECT * FROM `genre` ORDER BY `ID_GENRE` DESC");
                $query->execute();
                
                while ($genreDB = $query->fetch()){
                    $genre = new entity\Genre($genreDB['ID_GENRE'], $genreDB['NAME_GENRE']);
                    $genres[] = $genre;
                }
            }catch(PDOException $e){
                $genres[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $genres;
		
	}
        
        // SELECTIONNER UN JEU DE LA DB
        public function getById($id){
            $game = null;
            try{
                $query = SQL::$bdd->prepare("SELECT * FROM game WHERE ID_GAME = ?");
                $query->execute(array($id));
                $gamesBD = $query->fetch();
                $game = new \JVCAT\entity\Game($gamesBD['ID_GAME'], $gamesBD['NAME_GAME'], $gamesBD['RELEASE_DATE'], $gamesBD['PIC_GAME'], $gamesBD['SUMMARY_GAME']);
            }catch(PDOException $e){
                $game = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $game;
        }
        
        /*************************************/
        
        
        // SELECTIONNER GENRES DU JEU
        public function getGenres($game) {                                                          // Prend en paramètre un jeu dont on trouera en dessous tout les genres qui lui appartient, pour l'inclure dans son tableau de genres.
            $genres = null;                                                                         // Initialisation du tableau de genres à renvoyer.
            try{                                                                                    // On essaye...
                $id = $game->getId_game();                                                          //  On récupère l'ID qui servira à trouver les genres qui y correspond dans la table relationel.
                $query = SQL::$bdd->prepare("SELECT genre.* FROM game "                             //  On prépare une requête SQL "Séléctionne tout de 'genre' dans 'game'"...
                        . "LEFT JOIN of_the_genre AS ofgenre ON game.ID_GAME = ofgenre.ID_GAME "    //  "Relié par la table relationel 'of_the_genre' en tant que 'ofgenre' sur le 'ID' du 'Game' qui est le même dans 'Game' et 'ofgenre'"...
                        . "LEFT JOIN `genre` ON ofgenre.ID_GENRE = genre.ID_GENRE "                 //  "Relié par la table relationel 'ofgenre' sur le ID du 'Genre' qui est le même dans 'ofgenre' et 'Genre'"...
                        . "WHERE game.ID_GAME = :id");                                              //  "Là où 'ID' du 'Game' correspond à :id"
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);                          //  Applique la variable $id à l'information :id dans la requête
                $query->execute();                                                                  //  On éxécute la requête 
                
                while ($genreDB = $query->fetch()){                                                 //  Tant qu'il y a des resultats...
                    $genre = new entity\Genre($genreDB['ID_GENRE'], $genreDB['NAME_GENRE'], $id);   //      Créer un genre avec les données du resultat
                    $genres[] = $genre;                                                             //      L'ajouter au tableau de genres
                    $game->setGenres($genre);                                                       //      Ajouter le genre au tableau de genres de mon jeu
                }                                                                                   //  Fin
            }catch(PDOException $e){                                                                                // Encore une gestion des érreurs de PDO
                $genres[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $genres;                                                                         // Retourne à la vue les genres du jeu entré en paramètre.
		
	}
        
        // SELECTIONNER EDITEURS DU JEU
        public function getEditors($game) {
            $editors = null;
            try{
                $id = $game->getId_game();
                $query = SQL::$bdd->prepare("SELECT editor.* FROM game LEFT JOIN edits ON game.ID_GAME = edits.ID_GAME LEFT JOIN `editor` ON edits.ID_EDITOR = editor.ID_EDITOR WHERE game.ID_GAME = :id");
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);
                $query->execute();
                
                while ($editorDB = $query->fetch()){
                    $editor = new entity\Editor($editorDB['ID_EDITOR'], $editorDB['NAME_EDITOR'], $id);
                    $editors[] = $editor;
                    $game->setEditors($editor);
                }
            }catch(PDOException $e){
                $editors[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $editors;
		
	}
        
        // SELECTIONNER DEVELOPPEURS DU JEU
        public function getDevelopers($game) {
            $developers = null;
            try{
                $id = $game->getId_game();
                $query = SQL::$bdd->prepare("SELECT developer.* FROM game LEFT JOIN develops ON game.ID_GAME = develops.ID_GAME LEFT JOIN `developer` ON develops.ID_DEV = developer.ID_DEV WHERE game.ID_GAME = :id");
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);
                $query->execute();
                
                while ($devDB = $query->fetch()){
                    $developer = new entity\Developer($devDB['ID_DEV'], $devDB['NAME_DEV'], $id);
                    $developers[] = $developer;
                }
            }catch(PDOException $e){
                $developers[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $developers;
		
	}
        
        // SELECTIONNER PLATEFORMES DU JEU
        public function getPlatforms($game) {
            $platforms = null;
            try{
                $id = $game->getId_game();
                $query = SQL::$bdd->prepare("SELECT platform.* FROM game LEFT JOIN on_the_platform ON game.ID_GAME = on_the_platform.ID_GAME LEFT JOIN `platform` ON on_the_platform.ID_PLATFORM = platform.ID_PLATFORM WHERE game.ID_GAME = :id");
                $query->bindValue(":id", (int) trim($id), PDO::PARAM_INT);
                $query->execute();
                
                while ($platformDB = $query->fetch()){
                    $platform = new entity\Platform($platformDB['ID_PLATFORM'], $platformDB['NAME_PLATFORM'], $id);
                    $platforms[] = $platform;
                }
            }catch(PDOException $e){
                $platforms[] = "Une érreur dans la base de donnée est survenue, <br>code d'érreur : ".$e->getCode();
                
            }
            return $platforms;
		
	}
        

}
?>