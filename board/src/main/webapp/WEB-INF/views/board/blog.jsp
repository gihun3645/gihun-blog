<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <%@ include file="../layout/header.jsp" %>

<div class="container">

    <c:forEach var="board" items="${boards.content}">
        <div class="card m-2" style="width:400px">
            <div class="card-body">
                <h4 class="card-title">${board.title}</h4>
                <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">< 이전</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">< 이전</a></li>
            </c:otherwise>
        </c:choose>

        <c:set var="startPage" value="${(boards.number / 5) * 5 + 1}" />
        <c:set var="endPage" value="${startPage + 4 > boards.totalPages ? boards.totalPages : startPage + 4}" />
        <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
        </c:forEach>

        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">다음 ></a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">다음 ></a></li>
            </c:otherwise>
        </c:choose>

    </ul>

</div>



        <%@ include file="../layout/footer.jsp" %>