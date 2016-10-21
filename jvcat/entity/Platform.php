<?php
namespace JVCAT\entity;

class Platform
{
	
	private $_id_platform;
        private $_id_game;
	private $_platform_name;
        
        public function __construct($id, $name, $id_game = null) {
            $this->setId_platform($id);
            $this->setPlatform_name($name);
            $this->setId_game($id_game);
        }
	/****************************/
	public function getId_platform() {
		return $this->_id_platform;
	}
	public function setId_platform($_id_platform) {
		$this->_id_platform = $_id_platform;
	}
        /****************************/
	public function getPlatform_name() {
		return $this->_platform_name;
	}
	public function setPlatform_name($_platform_name) {
		$this->_platform_name = $_platform_name;
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