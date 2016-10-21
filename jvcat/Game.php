<?php
namespace JVCAT\entity;

class Game
{
    private $_id_game;
    private $_game_name;
    private $_game_date;
    private $_game_pic;
    private $_game_summary;
    
    public $genres = array();
    public $editors = array();
    public $devs = array();
    public $platforms = array();
	
	public function __construct($id, $name, $date, $pic, $summary)
	{
		$this->setId_game($id);
                $this->setGame_Name($name);
                $this->setGame_date($date);
                $this->setGame_pic($pic);
                $this->setGame_summary($summary);
                
                //$editors = $this->getEditors();
                //$this->setGame_editors($editors);
                
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
            $this->_game_pic = $_game_pic;
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
        /*****************************/
        public function getPlatforms(){
            return $this->platforms;
        }
        public function setPlatforms($platform){
            array_push($this->platforms,$platform);
        }
	
}
?>