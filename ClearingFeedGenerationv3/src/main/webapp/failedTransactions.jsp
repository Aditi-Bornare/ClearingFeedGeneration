<!-- PHP code to establish connection with the localserver -->
<!-- HTML code to display data in tabular format -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <title>Failed Transactions</title>
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
            background-color: #FF0000;
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
            <thead>
                <tr>
                    <th>TransactionRef</th>
                    <th>Value Date</th>
                    <th>Payer</th>
                    <th>Payee</th>
                    <th>Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactions}" var="transaction">
                    <tr>
                        <td>${transaction.transactionRef}</td>
                        <td>${transaction.valueDate}</td>
                        <td>${transaction.payerName}</td>
                        <td>${transaction.payeeName}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</body>
 
</html>