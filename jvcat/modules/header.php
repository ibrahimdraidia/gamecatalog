<?php
        // REQUIS POUR L'ACCES AUX ENTITEES ET BASE DE DONNEE !!!
        namespace JVCAT;
        use JVCAT\DB;
        $gameHandler = new DB\GameHandler; // Controlleur de l'objet "Game", voir son fichier pour connaitre ses fonctions ! (db/GameHandler.php)
        ?>

<div id="header" class="box">
    <div id="header_navbar">
        <a href="./" title="Accueil" id="header_logo">
                        <img src="./css/img/gc-logo.png" alt="Accueil" />
        </a>
        <ul id="header_menu">
            <li><a href="./">Accueil</a></li>
            <li><a href="./?page=Liste_Jeux">Jeux</a></li>
            <li><div class="dropdown">
<a onclick="dropmenupf()" class="dropbtn">Plateforme</a>
  <div id="myDropdownpf" class="dropdown-content">
      <?php
        // Affichage de toutes les plateformes
        $result = $gameHandler->getAllPlatforms();                         
        foreach($result as $KEY => $OBJECT){ 
            $id = $OBJECT->getId_platform();
            echo "<a href=\"./?page=Liste_Jeux&pf=$id\">".
                    ($OBJECT->getPlatform_Name()).
                    "</a>";                    
        }
    ?>
  </div>
</div></li>
            <li><div class="dropdown">
<a onclick="dropmenugenre()" class="dropbtn">Genre</a>
  <div id="myDropdowngenre" class="dropdown-content">
      <?php
        // Affichage de tout les genres
        $result = $gameHandler->getAllGenres();                         
        foreach($result as $KEY => $OBJECT){
            $id = $OBJECT->getId_Genre();
            echo "<a href=\"./?page=Liste_Jeux&genre=$id\">".
                    ($OBJECT->getGenre_Name()).
                    "</a>";                    
        }
      ?>
  </div>
</div></li>
<li><a href="./?page=Contact">Contact</a></li>
        </ul> 
        
        <form action="./?page=Liste_Jeux" method="post" id="header_searchbox" >
                    <select name="filter">
                        <option value="0">Nom</option>
                        <option value="1">Editeur</option>
                        <option value="2">Développeur</option>
                    </select>
                    <input type="text" name="search">
                    <input type="submit" class="button" value="Rechercher">
        </form>
    </div>
</div>		
<br>




<script>
    function dropmenupf(){
        close();
        document.getElementById("myDropdownpf").classList.toggle('show');
    }
    function dropmenugenre(){
        close();
        document.getElementById("myDropdowngenre").classList.toggle('show');
    }
    window.onclick = function(event){
        if(!event.target.matches('.dropbtn')){
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for(i=0; i < dropdowns.length; i++){
                var openDropdown = dropdowns[i];
                if(openDropdown.classList.contains('show')){
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
    
    function close(){
        var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for(i=0; i < dropdowns.length; i++){
                var openDropdown = dropdowns[i];
                if(openDropdown.classList.contains('show')){
                    openDropdown.classList.remove('show');
                }
            }
    }
</script>