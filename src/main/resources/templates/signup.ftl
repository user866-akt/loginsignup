<#include "base.ftl">

<@base title="Sign Up">
    <form method="post" action="/sign_up">
        Login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="sign up">
    </form>
    <a href="/login">Login</a>
</@base>