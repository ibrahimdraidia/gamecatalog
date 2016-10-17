<?php 
namespace entity;

class Type extends Date
{
	private $_id_type;
	private $_type;
	
	public function __construct()
	{
	}

	public function getId_type()
	{
		return $_id_type;
	}

	public function setId_type($_id_type)
	{
		$this->_id_type = $_id_type;
	}

	public function getType()
	{
		return $_type;
	}

	public function setType($_type)
	{
		$this->_type = $_type;
	}

}
?>