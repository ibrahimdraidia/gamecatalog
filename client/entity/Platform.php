<?php

namespace entity;

class Platform extends Type
{
	private $_id_platform;
	private $_platform;

	public function __construct()
	{
	}

	public function $getId_platform()
	{
		return $_id_platform;
	}

	public function setId_platform($_id_platform)
	{
		$this->_id_platform = $_id_platform;
	}

	public function getPlatform()
	{
		return $_platform;
	}

	public function setPlatform($_platform)
	{
		$this->_platform = $_platform;
	}

}
?>