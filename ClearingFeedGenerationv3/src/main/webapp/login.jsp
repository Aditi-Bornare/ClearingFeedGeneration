<html>
  <title> Clearing feed Generation </title>
  <h1 style="text-align: center; color:whitesmoke"> Clearing Feed generator</h1>
<body style="margin: 0;
padding: 0;
background: linear-gradient(120deg,#2980b9, #8e44ad);
height: 100vh;
overflow: hidden;">

<div class="center" style="position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);
width: 400px;
background: white;
border-radius: 10px;
box-shadow: 10px 10px 15px rgba(0,0,0,0.05);"
>

    
<h1 style="text-align: center;
padding: 20px 0;
border-bottom: 1px solid silver;">Login Page<br>

${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="login" method="post" style="padding: 0 40px;
box-sizing: border-box;">
    <div class="txt_field" style="position: relative;
    border-bottom: 2px solid #adadad;
    margin: 30px 0;">

    
        <label style="position: absolute;
        top: 50%;
        left: 5px;
        color: #adadad;
        transform: translateY(-50%);
        font-size: 16px;
        pointer-events: none;
        transition: .5s;">Username</label>

      <input type="text"  name="username" required style="width: 50%;
        padding: 0 5px;
        height: 40px;
        font-size: 16px;
        border: none;
        background: none;
        outline: none;">
        </div>

        <div class="txt_field"  style="position: relative;
        border-bottom: 2px solid #adadad;
        margin: 30px 0;">

        <label style="position: absolute;
        top: 50%;
        left: 5px;
        color: #adadad;
        transform: translateY(-50%);
        font-size: 16px;
        pointer-events: none;
        transition: .5s;">Password</label>

        <input type="password" name="password"  required style="width: 50%;
        padding: 0 5px;
        height: 40px;
        font-size: 16px;
        border: none;
        background: none;
        outline: none;" >
        </div>

<input type="submit" value="submit" style="width: 100%;
height: 50px;
border: 1px solid;
background: #2691d9;
border-radius: 25px;
font-size: 18px;
color: #e9f4fb;
font-weight: 700;
cursor: pointer;
outline: none;">
</div>
</body>
</html>


