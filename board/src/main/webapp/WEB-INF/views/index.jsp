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

            <c:forEach var="board" items="${boards}">
                <div class="card m-2" style="width:400px">
                    <div class="card-body">
                        <h4 class="card-title">${board.title}</h4>
                        <a href="#" class="btn btn-primary">상세보기</a>
                    </div>
                </div>
            </c:forEach>

        </div>


        <%@ include file="layout/footer.jsp" %>