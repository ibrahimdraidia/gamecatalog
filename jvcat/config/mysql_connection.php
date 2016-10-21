<?php  namespace JVCAT\DB;
		use PDO;
        class SQL{
            
			private static $SQL_Host;
			private static $SQL_Port;
            private static $SQL_Username;
            private static $SQL_Password;
            private static $SQL_Charset;
            private static $SQL_DatabaseName;
            public static $bdd;
            
            public static function initialize($host, $port, $charset, $user, $pass, $database){
				$SQL_Host = self::$SQL_Host = $host;
				$SQL_Port = self::$SQL_Port = $port;
                                $SQL_Charset = self::$SQL_Charset = $charset;
                $SQL_Username = self::$SQL_Username = $user;
                $SQL_Password = self::$SQL_Password = $pass;
                $SQL_DatabaseName = self::$SQL_DatabaseName = $database;
                try {
                    $bdd = self::$bdd = new PDO('mysql:
					host='.$SQL_Host.':'.$SQL_Port.';
					dbname='.$SQL_DatabaseName.';
					charset='.$SQL_Charset, 
					$SQL_Username, 
					$SQL_Password);
                    
                    
                }
                catch(PDOException $e){
                    echo "La connexion à la base de donnée à échoué, <br>code d'érreur : ".$e->getCode();
                }
            }
            public static function tryMe(){
                    echo "Try Me !";
            }
            
            function __deconstruct(){
                self::$bdd = null;
            }
        }
        
        
        