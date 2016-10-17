<?php
namespace entity;

class Developer extends Platform
{
	private $_listDev;
	private $_id_developer;
	
	public function get_id_developer() {
		return $_id_developer;
	}


	public function set_id_developer($_id_developer) {
		$this->_id_developer = $_id_developer;
	}


	public function get_developer_name() {
		return $_developer_name;
	}


	public function set_developer_name($_developer_name) {
		$this->_developer_name = $_developer_name;
	}


	private String $_developer_name;
	

	public function Developer()
	{
		$_listDev = new ArrayList<>();
	}
	
	
	public function ArrayList<Developer> getListDevelopers()
	{
		
		return $_listDev;
	}
	

}
?>