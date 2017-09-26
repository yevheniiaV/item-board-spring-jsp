<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <title>Login or Register to your Account</title>

    <%--meta link--%>
    <%@ include file="common/meta.jsp" %>

</head>

<body>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/item-board_resources/js/materialize.js"/>"></script>

<%--header link--%>
<%@ include file="common/header.jsp" %>
<body>


<div class="section"></div>

<div style="width:100%">
    <br>
    <br>
    <br>
        <h5 class="indigo-text" style="text-align: center">Please, login into your account</h5>
        <h5 class="indigo-text" style="text-align: center">or Register</h5>

    <br>
    <br>
    <br>

    <div class="container" >
            <div class="z-depth-1 grey lighten-4 row" style="padding: 32px 48px 0px 48px; border: 1px solid #EEE; float: left; width: 30%;";>

                <form class="col s12" method="post">
                    <div class='row'>
                        <div class='col s12'>
                        </div>
                    </div>
                    <h5 class="indigo-text" style="text-align: center">Login</h5>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='email' name='email' id='email' />
                            <label for='email'>Enter your email</label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='password' name='password' id='password' />
                            <label for='password'>Enter your password</label>
                        </div>
                        <label style='float: right;'>
                            <a class='pink-text' href='#!'><b>Forgot Password?</b></a>
                        </label>
                    </div>

                    <br />
                        <div class='row' style="color: #26a69a">
                            <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo' style="width: 200px; margin-left:10%; margin-right:10%;">Login</button>
                        </div>
                </form>
            </div>
        </div>

    <div class="container" >
        <div class="z-depth-1 grey lighten-4 row" style="padding: 32px 48px 0px 48px; border: 1px solid #EEE; float: right; width: 45%; ";>

            <form class="col s12" method="post">
                <div class='row' style="width: 100%">
                    <div class='col s12'>
                    </div>
                    <h5 class="indigo-text" style="text-align: center">Register</h5>

                <div class='row' style="width: 50%; float: left">
                    <div class='input-field col s12'>
                        <input class='validate' type='email' name='email' id='emailRegister' />
                        <label for='email'>Enter your email</label>
                    </div>
                </div>

                <div class='row'style="width: 50%; float: right">
                    <div class='input-field col s12' >
                        <input class='validate' type='text' name='name' id='name' />
                        <label for='password'>Enter your name</label>
                    </div>
                </div>

                <div class='row' style="width: 50%; float: left">
                    <div class='input-field col s12'>
                        <input class='validate' type='password' name='password' id='passwordRegister' />
                        <label for='email'>Enter your password</label>
                    </div>
                </div>

                <div class='row'style="width: 50%; float: right">
                    <div class='input-field col s12' >
                        <input class='validate' type='password' name='password' id='passwordRepeat' />
                        <label for='password'>Repeat your password</label>
                    </div>
                </div>

                <div class='row' style="width: 50%; float: left">
                    <div class='input-field col s12'>
                        <input class='validate' type='tel' name='phone' id='phone' />
                        <label for='email'>Enter your phone</label>
                    </div>
                </div>

                <div class='row'style="width: 50%; float: right">
                    <div class='input-field col s12' >
                        <input class='validate' type="text" name='city' id='city' />
                        <label for='password'>Enter your city</label>
                    </div>
                </div>

                <br />
                    <center>
                <div class='row'>
                    <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo' style="width: 200px; margin-left:30%; margin-right:30%">Register</button>
                </div>
                    </center>
                </div>
            </form>
        </div>
    </div>

</div>
<br>
<br>
<br>
<br>






<%--footer link--%>
<%@ include file="common/footer.jsp" %>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

</body>



</html>