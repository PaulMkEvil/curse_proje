<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head th:insert="templatesforall :: head">
</head>

<body>
<section th:insert="templatesforall :: hero"></section>

<div>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Active</th>
            <th>Role</th>
            <th>Ban</th>
            <th>Change</th>
            <th>Information</th>
        </tr>
        <#list users as user>
        <tr>
            <th>${user.username}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Change</a></th>
            <th><a href="/user/${user.id}">Information</a></th>
        </tr>
        <#else>
        <h3>None users</h3>
    </#list>
    </table>
    <a href="/">Главная</a>
</div>--  end listing section  -->

<footer th:insert="templatesforall :: footer"></footer>

</body>
</html>