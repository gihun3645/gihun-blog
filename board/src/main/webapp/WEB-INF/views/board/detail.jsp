<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">


    <button class="btn btn-secondary" onclick="history.back()">목록으로</button>
    <c:if test="${board.user.id == principal.user.id}">
        <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
        <button id="btn-delete" class="btn btn-danger">삭제</button>
    </c:if>
    <br/><br/>
    <div>
        글 번호: <span id="id"><i>${board.id}</i></span>
        작성자: <span><i>${board.user.username}</i></span>
        작성시간: <span><i>${board.createDate}</i></span>
        조회수: <span><i>${board.count}</i></span>
    </div>
    <br/>
    <div class="form-group">
        <h3>${board.title}</h3>
    </div>
    <hr/>
<%--    토스트 UI 적용공간--%>
    <div class="form-group" id="viewer">
        ${board.content}
    </div>
    <hr/>


    <div class="card">

        <form>
            <input type="hidden" id="userId" value="${principal.user.id}"/>
            <input type="hidden" id="boardId" value="${board.id}"/>
            <div class="card-body"><textarea id="reply-content" class="form-control" rows="1"></textarea></div>
            <div class="card-footer"><button type="button" id="btn-reply-save" class="btn btn-primary">등록</button></div>
        </form>

    </div>
    <br/>


    <div class="card">
        <div class="card-header">댓글 리스트</div>
        <ul id="reply-box" class="list-group">
            <c:forEach var="reply" items="${board.replys}">
            <li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
                <div>${reply.content}</div>
                <div class="d-flex">
                    <div class="font-italic">작성자 : ${reply.user.username}&nbsp</div>
                    <div class="font-italic">작성시간 : ${reply.createDate}&nbsp</div>
                    <c:if test="${board.user.id == principal.user.id}">
                    <button onClick="index.replyDelete(${board.id}, ${reply.id})"class="badge">삭제</button>
                    </c:if>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>


</div>
<!-- Toast UI viewer -->
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-viewer.min.js"></script>
<!-- Toast UI 하이라이트 플러그인 -->
<script src="https://uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script>

    const viewer = new toastui.Editor({
        el: document.querySelector('#viewer'),
        viewer: true,
    });


</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>