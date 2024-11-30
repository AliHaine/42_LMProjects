<?php
    if (isset($_POST['post'])) {
        $form_username = $_POST['rusername'];
        $form_password = $_POST['rpassword'];
        $form_email = $_POST['remail'];
    }

    // Check if the username is "admin"
    if ($form_username == "admin") {
        echo "admin username is forbidden";
        exit;
    }

    // Create a new SQLite connection
    $con = new SQLite3('./data/testdb.sqlite');  // Path to your SQLite database file

    if (!$con) {
        die("Connection failed!" . $con->lastErrorMsg());
    }

    // Prepare the SQL statement for insertion
    $sql = "INSERT INTO users (username, password, email) VALUES ('$form_username', '$form_password', '$form_email')";
    echo $sql . "<br>";

    // Execute the SQL query
    if ($con->exec($sql)) {
        echo "Entries added!";
    } else {
        echo "Error: " . $con->lastErrorMsg();
    }

    // Close the connection
    $con->close();
?>