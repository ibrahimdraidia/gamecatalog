<?php
namespace entity;

class Editor  extends Developer{
	
	private $_id_editor;
	private $_editor_name;
	
	public function getId_editor() {
		return $_id_editor;
	}
	public function setId_editor($_id_editor) {
		$this->_id_editor = $_id_editor;
	}
	public function getEditor_name() {
		return $_editor_name;
	}
	public function setEditor_name($_editor_name) {
		$this->_editor_name = $_editor_name;
	}
	
	

}
?>