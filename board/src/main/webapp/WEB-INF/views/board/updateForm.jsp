<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
<form>
    <%--    자바스크립트에서 가져올 거임--%>
    <input type="hidden" id="id" value="${board.id}"/>
    <div class="form-group">
        <input value="${board.title}" type="text" class="form-control" placeholder="제목을 입력 하세요." id="title">
    </div>

    <div class="form-group">
        <div class="form-control" id="editor">${board.content}</div>
    </div>
</form>
<button id="btn-update" class="btn btn-primary">등록</button>
</div>
<!-- TOAST UI 하이라이트 플러그인 -->
<script src="https://uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script>
    const Editor = toastui.Editor;
    const editor = new toastui.Editor({
        el: document.querySelector("#editor"),
        height: "500px",
        initialEditType: "wysiwyg",
        language: "ko-KR",
        plugins: [Editor.plugin.codeSyntaxHighlight]
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>