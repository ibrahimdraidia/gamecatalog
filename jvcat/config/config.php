<?php 
/*
 * Inclure les packages nécéssaires au fonctionnement complet du site.  
 */
namespace JVCAT\config;                         // Ce charge dans le package JVCAT/config
        use JVCAT\DB\SQL;                       // Utilise le package JVCAT/DB/SQL
	require_once "mysql_connection.php";    // Requis la classe static SQL
	
	 /*$Host = "ibrahimdraidia.com";
	 $Port = "3306";
         $Charset = "utf8";
	 $Username = "draidia2_afpa";
	 $Password = "afpa2016";
	 $DatabaseName = "draidia2_gamecatalog";*/
        
        /******DATABASE CONFIGURATION*******/
        $Host = "localhost";                        // Adrèsse de la base de donnée
	 $Port = "3306";                            // Port de la DB
         $Charset = "utf8";                         // Charset de la DB
	 $Username = "cyber";                       // Nom d'utilsiateur de la DB
	 $Password = "kevin";                       // Mot de pass de la DB
	 $DatabaseName = "draidia2_gamecatalog";    // Nom de la DB
         // Intialisation de la classe SQL, en lui passant les données...
	SQL::initialize($Host, $Port, $Charset, $Username, $Password, $DatabaseName);
	
        /******SITE CONFIGURATION*******/
	$title = "JV Catalog";                      // Titre du site
	$favicon = "#";                             // Favicon du site
        $css = "default";                           // CSS à charger
?>