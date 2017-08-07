<?php

define('hostname', 'localhost');
define('user', 'yds');
define('password', 'yds');
define('databaseName', 'yds');


$connect = mysqli_connect(hostname, user, password, databaseName);
$connect->set_charset("utf8")
?>

