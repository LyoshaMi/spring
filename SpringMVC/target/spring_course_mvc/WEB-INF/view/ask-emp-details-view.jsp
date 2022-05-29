<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>

<h2>Dear Employee, Please enter your details</h2>
<%--action напрямую связан с кнопкой submit  и делает переход на url showDetails--%>
<form:form action = "showDetails" modelAttribute="employee" method="get">
<%--Здесь срабатывают геттеры для полей Employee и поля будут null потому что вызывается конструктор
в нашей форме, а у нас только пустой конструктор--%>
    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Salary <form:input path="salary"/>
    <form:errors path="salary"/>
    <br>
    <br>
    Department <form:select path="department">
    <form:options items="${employee.departments}"/>
<%--    HARDCODED OPTION--%>
<%--    <form:option value="Information Technology" label="IT"/>--%>
<%--    <form:option value="Human Resources" label="HR"/>--%>
<%--    <form:option value="Sales" label="Sales"/>--%>
</form:select>
    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
<%--    HARDCODED OPTION--%>
<%--    BMW <form:radiobutton path="carBrend" value="BMW"/>--%>
<%--    Audi <form:radiobutton path="carBrend" value="Audi"/>--%>
<%--    MB <form:radiobutton path="carBrend" value="Mercedes-Benz"/>--%>
    <br><br>
    Foreign Language(s)
    <form:checkboxes path="languages" items="${employee.languageList}"/>
<%--    HARDCODED OPTION--%>
<%--    EN <form:checkbox path="languages" value="English"/>--%>
<%--    DE <form:checkbox path="languages" value="Deutch"/>--%>
<%--    FR <form:checkbox path="languages" value="French"/>--%>
    <br><br>
    Phone number <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    <%--после нажатия на кнопку "ОК" срабают сеттеры для полей нашего Employee--%>
    <input type="submit" value="OK">

</form:form>

</body>


</html>