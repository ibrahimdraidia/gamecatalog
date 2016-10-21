<?php
namespace JVCAT\entity;

class Game
{
    private $_id_game;              // Id du jeu
    private $_game_name;            // Nom du jeu
    private $_game_date;            // Date de sortie du jeu
    private $_game_pic;             // Image du jeu
    private $_game_summary;         // Résumé du jeu
    
    public $genres = array();       // Tableau des genres du jeu
    public $editors = array();      // Tableau des éditeurs du jeu
    public $devs = array();         // Tableau des développeurs du jeu
    public $platforms = array();    // Tableau des plateformes du jeu
	
	public function __construct($id, $name, $date, $pic, $summary)
	{
		$this->setId_game($id);
                $this->setGame_Name($name);
                $this->setGame_date($date);
                $this->setGame_pic($pic);
                $this->setGame_summary($summary);
                
	}
        /*****************************/
        public function getId_game(){
            return $this->_id_game;
        }
        public function setId_game($_id_game){
            $this->_id_game = $_id_game;
        }
         /*****************************/
        public function getGame_Name(){
            return $this->_game_name;
        }
        public function setGame_Name($_game_name){
            $this->_game_name = $_game_name;
        }
         /*****************************/
        public function getGame_date(){
            return $this->_game_date;
        }
        public function setGame_date($_game_date){
            $this->_game_date = $_game_date;
        }
         /*****************************/
        public function getGame_pic(){
            return $this->_game_pic;
        }
        public function setGame_pic($_game_pic){
            $this->_game_pic = "./img/games/".$_game_pic;           // Modifie, au moment de créer la variable, la forme du string afin d'y ajouter un chemind 'accès vers le dossier logique.
        }
         /*****************************/
        public function getGame_summary(){
            return $this->_game_summary;
        }
        public function setGame_summary($_game_summary){
            $this->_game_summary = $_game_summary;
        }
         /*****************************/
        public function getGame_editors(){
            return $this->_game_editors;
        }
        public function setGame_editors($_game_editors){
            $this->_game_editors = $_game_editors;
        }
        
         /*****************************/
        public function getGenres(){
            return $this->genres;
        }
        public function setGenres($genre){
            array_push($this->genres,$genre);
        }
        
        /*****************************/
        public function getEditors(){
            return $this->editors;
        }
        public function setEditors($editor){
            array_push($this->editors,$editor);
        }
	
}
?>