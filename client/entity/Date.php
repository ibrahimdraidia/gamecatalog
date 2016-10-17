<?php
namespace entity;

class Date
{
	private $_date;
	
	public __construct()
	{
	}

	public function getDate()
	{
		return $_date;
	}

	public function setDate($_date)
	{
		$this->_date = $_date;
	}
}
?>