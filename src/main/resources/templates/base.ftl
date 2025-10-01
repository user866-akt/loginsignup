<#macro base title="Default Title" showLogout=false>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
    </head>
    <body>
    <#if showLogout>
        <div style="float: right;">
            <a href="/logout">Logout</a>
        </div>
    </#if>

    <#nested>
    </body>
    </html>
</#macro>