<?php namespace JVCAT\config;
		use JVCAT\DB\SQL;
	require_once "mysql_connection.php";
	
	 $Host = "localhost";
	 $Port = "3306";
	 $Username = "cyber";
	 $Password = "kevin";
	 $DatabaseName = "bank";
	SQL::initialize($Host, $Port, $Username, $Password, $DatabaseName);
	
	$title = "Jeux Video Projet AFPA";
	$favicon = "#";
?>