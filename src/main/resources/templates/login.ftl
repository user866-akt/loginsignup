<#include "base.ftl">

<@base title="Login">
    <form method="post" action="/login">
        Login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>
    <a href="/sign_up">Sign up</a>
</@base>