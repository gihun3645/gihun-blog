<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>

<%--토스트 UI--%>
<div class="container">
    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="제목을 입력 하세요." id="title">
        </div>


        <div class="form-group">
            <div class="form-control" id="editor"></div>
        </div>


    </form>
    <button id="btn-save" class="btn btn-primary">등록하기</button>
</div>
<!-- TOAST UI 하이라이트 플러그인 -->
<script src="https://uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script>
    const Editor = toastui.Editor;
    const editor = new Editor({
        el: document.querySelector("#editor"),
        height: "600px",
        initialEditType: "markdown",
        placeholder: "내용을 입력해주세요",
        language: "ko-KR",
        plugins: [Editor.plugin.codeSyntaxHighlight]
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>