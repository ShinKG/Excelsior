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
        if (($this->connection)->connect_error) {
            die("Connection failed: " . ($this->connection)->connect_error);
        }
        echo "Connected successfully";

    }

    function close_connection(){
        if(!is_null($this->connection))mysqli_close($this->connection);
    }

}

class credentialDB extends connectionDB{
    var $user_name;
    var $user_password;
    var $is_Student;

    function set_credential($u,$p,$iS){
        $this->user_name = $u;
        $this->user_password = $p;
        $this->is_Student = $iS;
    }

    function get_credential(){

        if(!is_null($this->connection)){

            if ($this->is_Student) {
                $sql = "SELECT studetn_id, password FROM students WEHRE student_id = $this->user_name AND $this->user_password";
            }else{
                $sql = "SELECT username, password FROM administrators WEHRE username = $this->user_name AND $this->user_password";
            }

            $result = mysqli_query($this->connection, $sql);
            if(mysqli_num_rows($result) > 0) return true;
            return false;
        }else {
            echo "Connection is not established";
            return false;
        }
    }
}

class registerDB extends connectionDB{
    
}
