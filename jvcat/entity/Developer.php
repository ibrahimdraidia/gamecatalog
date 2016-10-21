<?php
namespace JVCAT\entity;

class Developer
{
	
	private $_id_developer;
        private $_id_game;
	private $_developer_name;
        
        public function __construct($id, $name, $id_game = null) {
            $this->setId_developer($id);
            $this->setDeveloper_name($name);
            $this->setId_game($id_game);
        }
	/****************************/
	public function getId_developer() {
		return $this->_id_developer;
	}
	public function setId_developer($_id_developer) {
		$this->_id_developer = $_id_developer;
	}
        /****************************/
	public function getDeveloper_name() {
		return $this->_developer_name;
	}
	public function setDeveloper_name($_developer_name) {
		$this->_developer_name = $_developer_name;
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