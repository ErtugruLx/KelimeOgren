<?php
 define('HOST','localhost');
 define('USER','yds');
 define('PASS','yds');
 define('DB','yds');
 
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 $con->set_charset('utf8');
 ?>
