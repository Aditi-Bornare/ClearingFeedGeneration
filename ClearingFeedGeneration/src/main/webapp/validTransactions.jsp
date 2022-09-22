<!-- PHP code to establish connection with the localserver -->
<?php
 

$user = 'root';
$password = 'Rutuja@123';
$database = 'dbr';
$servername='localhost:3306';
$mysqli = new mysqli($servername, $user,
                $password, $database);
 

if ($mysqli->connect_error) {
    die('Connect Error (' .
    $mysqli->connect_errno . ') '.
    $mysqli->connect_error);
}
 

$sql = " select * from main_table; ";
$result = $mysqli->query($sql);
$mysqli->close();
?>
<!-- HTML code to display data in tabular format -->
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <title>Valid Transactions</title>
    <!-- CSS FOR STYLING THE PAGE -->
    <style>
        table {
            margin: 0 auto;
            font-size: large;
            border: 1px solid black;
        }
 
        h1 {
            text-align: center;
            color: #006600;
            font-size: xx-large;
            font-family: 'Gill Sans', 'Gill Sans MT',
            ' Calibri', 'Trebuchet MS', 'sans-serif';
        }
 
        td {
            background-color: #E4F5D4;
            border: 1px solid black;
        }
 
        th,
        td {
            font-weight: bold;
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
 
        td {
            font-weight: lighter;
        }
    </style>
</head>
 
<body>
    <section>
        <h1>Transaction Status</h1>
        <!-- TABLE CONSTRUCTION -->
        <table>
            <tr>
                <th>Reference Id</th>
                <th>Value Date</th>
                <th>payer Account</th>
                <th>payer name</th>
            </tr>
            <!-- PHP CODE TO FETCH DATA FROM ROWS -->
            <?php
                // LOOP TILL END OF DATA
                while($rows=$result->fetch_assoc())
                {
            ?>
            <tr>
                <!-- FETCHING DATA FROM EACH
                    ROW OF EVERY COLUMN -->
                <td><?php echo $rows['transactionRef'];?></td>
                <td><?php echo $rows['valueDate'];?></td>
                <td><?php echo $rows['payerName'];?></td>
                <td><?php echo $rows['payerAccount'];?></td>
            </tr>
            <?php
                }
            ?>
        </table>
    </section>
</body>
 
</html>