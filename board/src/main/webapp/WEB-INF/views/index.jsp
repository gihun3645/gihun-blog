<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <%@ include file="layout/header.jsp" %>

        <div class="container">

            <div class="card m-2" style="width:400px">
                <img class="card-img-top" src="https://avatars.githubusercontent.com/u/90669343?v=4" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">송바래</h4>
                    <p class="card-text">자바 백엔드 개발자 지망생입니다.</p>
                    <p class="card-text">오늘도 좋은 하루 되세요 ^^</p>
                    <a href="https://github.com/gihun3645" class="btn btn-primary">깃허브 바로가기</a>
                </div>
            </div>

<%--            <c:forEach var="board" items="${boards.content}">--%>
<%--                <div class="card m-2" style="width:400px">--%>
<%--                    <div class="card-body">--%>
<%--                        <h4 class="card-title">${board.title}</h4>--%>
<%--                        <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>

<%--            <ul class="pagination justify-content-center">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${boards.first}">--%>
<%--                        <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">< 이전</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">< 이전</a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                <c:forEach var="i" begin="1" end="${boards.totalPages}">--%>
<%--                    <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>--%>
<%--                </c:forEach>--%>

<%--                <c:choose>--%>
<%--                    <c:when test="${boards.last}">--%>
<%--                        <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">다음 ></a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">다음 ></a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--            </ul>--%>

        </div>


        <%@ include file="layout/footer.jsp" %>