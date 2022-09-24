<!DOCTYPE html>
<html>
<head>
  <h1 style="text-align: center; color:whitesmoke">Feed generator</h1>
  <title>Upload status</title>
</head>
<body style="margin: 0;
            padding: 0;
            background: linear-gradient(120deg,#2980b9, #8e44ad);
            height: 100vh;
            overflow: hidden;">

    <div class="center"style="position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      width: 400px;
      background: white;
      border-radius: 10px;
      box-shadow: 10px 10px 15px rgba(0,0,0,0.05);">
      
      <div>
        <h3 style="color: white; text-align:center">Spring Boot - Upload Status</h1>
      </div>
      <div style="text-align: center;">
        ${message}
      </div>
      <div style="align-items: center; padding-bottom:10px; padding-top:10px; padding-left: 120px;">
        <a href="validtran"><button>View Transactions</button></a>
      </div>   
      
  </div>

</body>

</html>