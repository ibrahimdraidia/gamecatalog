<?php
namespace JVCAT\entity;

class Genre
{
	
	private $_id_genre;
        private $_id_game;
	private $_genre_name;
        
        public function __construct($id, $name, $id_game = null) {
            $this->setId_genre($id);
            $this->setGenre_name($name);
            $this->setId_game($id_game);
        }
	/****************************/
	public function getId_genre() {
		return $this->_id_genre;
	}
	public function setId_genre($_id_genre) {
		$this->_id_genre = $_id_genre;
	}
        /****************************/
	public function getGenre_name() {
		return $this->_genre_name;
	}
	public function setGenre_name($_genre_name) {
		$this->_genre_name = $_genre_name;
	}
        /****************************/
	public function getId_game() {
		return $this->_id_game;
	}
	public function setId_game($_id_game) {
		$this->_id_game = $_id_game;
	}
	
	

}
?>