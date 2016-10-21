<?php
namespace JVCAT\entity;

class Editor
{
	
	private $_id_editor;
        private $_id_game;
	private $_editor_name;
        
        public function __construct($id, $name, $id_game = null) {
            $this->setId_editor($id);
            $this->setEditor_name($name);
            $this->setId_game($id_game);
        }
	/****************************/
	public function getId_editor() {
		return $this->_id_editor;
	}
	public function setId_editor($_id_editor) {
		$this->_id_editor = $_id_editor;
	}
        /****************************/
	public function getEditor_name() {
		return $this->_editor_name;
	}
	public function setEditor_name($_editor_name) {
		$this->_editor_name = $_editor_name;
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