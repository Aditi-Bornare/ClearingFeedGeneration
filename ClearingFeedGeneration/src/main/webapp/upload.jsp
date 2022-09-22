<html>
<head>
  <title>Upload File</title>
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
      
      <form method="post" enctype="multipart/form-data" action="uploadfile">
        <div>
          <h3 style="text-align: center; color: black;">Please Choose your file and upload</h3>
        </div>
        <div style="padding-bottom:10px; padding-left: 35px;">
            <label style="color:black">Choose file:</label>
            <input type="file" name="file" style="align-items: center;"/>
          
        </div>
        <div style="padding-bottom:10px; padding-left: 35px;">
          <label style="color:black">Upload file:</label>
          <input type="submit" value="Upload" />
        </div>
      </form>
  </div>


</body>
</html>