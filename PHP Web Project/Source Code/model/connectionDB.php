<?php


class connectionDB
{
    var $host;
    var $user;
    var $password;
    var $database;
    var $connection;

    function set_connection($h,$u,$p,$d){
       $this->host=$h;
       $this->user=$u;
       $this->password=$p;
       $this->database=$d;
    }

    function open_connection(){
        $this->connection = new mysqli($this->host,$this->user,$this->password,$this->database);
    }

    function close_connection(){
        mysqli_close($this->connection);
    }

}
