<?php
    if(isset($_POST['submit']))
    {
        $form_username = $_POST['rusername'];
        $form_password = $_POST['rpassword'];
        $form_email = $_POST['remail'];
    }

    if ($form_username == "admin")
    {
        echo "admin username is forbidden";
        exit;
    }

    $con = mysqli_connect("mysql", "root", "root", "db");
    if (!$con)
        die("Connection failed!" . mysqli_connect_error());

    $sql = "INSERT INTO users (id, username, password, email) VALUES ('0', '$form_username', '$form_password', '$form_email')";
    echo $sql . "<br>";

    if(mysqli_query($con, $sql))
        echo "Entries added!";
    mysqli_close($con);
?>