<#macro formInput id name label type="text" value="">
    <label for="${id}">${label}</label>
    <input type="${type}" id="${id}" name="${name}" value="${value}">
    <#if lastSearch??>Поиск для: ${lastSearch}<#else></#if>
</#macro>

<#macro table id rows>
    <table id="${id}" border="1px" cellspacing="2" border="1" cellpadding="5">
        <#list rows as row>
            <tr>

                <!--#list row as field-->
                    <td>${row.toString()}</td>
                <!--/#list-->
            </tr>
        </#list>
    </table>
</#macro>
