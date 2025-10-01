<#include "base.ftl">

<@base title="Main Page" showLogout=true>
    <h1>Welcome, ${user!"unknown"}!</h1>
    <p>Login successful</p>
    <p><strong>Session ID:</strong> ${sessionId!"none"}</p>
</@base>