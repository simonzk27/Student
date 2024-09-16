<%-- 
    Document   : studentinfo
    Created on : 7/09/2024, 04:26:34 PM
    Author     : UUSARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                        <input type="submit" name="action" value="ViewAll" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
            <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach>
        </table>

        <h1>Curses Information</h1>
        <form action="./CurseServlet" method="POST">
            <table>
                <tr>
                    <td>Id Curso</td>
                    <td><input type="text" name="codCurso" value="${cursos.codCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombreCurso" value="${cursos.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>No. Creditos</td>
                    <td><input type="text" name="numCreditos" value="${cursos.numCreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${cursos.semestre}" /></td>
                </tr>
                <tr>
                    <td>No. Estudiantes Admitidos</td>
                    <td><input type="text" name="numEstudAdmitidos" value="${cursos.numEstudAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                        <input type="submit" name="action" value="ViewAll" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Id Curso</th>
            <th>Nombre Curso</th>
            <th>No. Creditos</th>
            <th>Semestre</th>
            <th>No. Estudiantes Admitidos</th>
            <c:forEach items="${allCurses}" var="cur">
                <tr>
                    <td>${cur.codCurso}</td>
                    <td>${cur.nombreCurso}</td>
                    <td>${cur.numCreditos}</td>
                    <td>${cur.semestre}</td>
                    <td>${cur.numEstudAdmitidos}</td>
                </tr>
            </c:forEach>
        </table>

        <h1>Estudiantes y Cursos</h1>
        <form action="./StudCurServlet" method="POST">
            <table>
                <tr>
                    <td>Id Curso</td>
                    <td><input type="text" name="codCurso" value="${studcurpk.codCurso}" /></td>
                </tr>
                <tr>
                    <td>Id Estudiante</td>
                    <td><input type="text" name="studentid" value="${studcurpk.studentid}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="ViewAll" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Id Curso</th>
            <th>Id Estudiante</th>
            <c:forEach items="${allIn}" var="stcur">
                <tr>
                    <td>${stcur.studcurPK.codCurso}</td>
                    <td>${stcur.studcurPK.studentid}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
