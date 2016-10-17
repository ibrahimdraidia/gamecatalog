<?php
namespace JVCAT\DB;

interface CrudInterface {
	
	public function add();
	public function update();
	public function remove();
	public function getAll();

}
?>