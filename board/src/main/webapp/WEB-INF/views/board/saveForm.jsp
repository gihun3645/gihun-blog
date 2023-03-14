<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>
<%--<div class="container">--%>
<%--<form>--%>
<%--    <div class="form-group">--%>
<%--        <input type="text" class="form-control" placeholder="제목을 입력 하세요." id="title">--%>
<%--    </div>--%>

<%--    <div class="form-group">--%>
<%--        <textarea class="form-control summernote" rows="5" id="content"></textarea>--%>
<%--    </div>--%>
<%--</form>--%>
<%--<button id="btn-save" class="btn btn-primary">등록</button>--%>
<%--</div>--%>
<%--<script>--%>
<%--    $('.summernote').summernote({--%>
<%--        placeholder: '내용을 입력하세요.',--%>
<%--        tabsize: 2,--%>
<%--    });--%>
<%--</script>--%>
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
<script>
    const editor = new toastui.Editor({
        el: document.querySelector("#editor"),
        height: "500px",
        initialEditType: "markdown",
        placeholder: "내용을 입력해주세요",
        language: "ko-KR",
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>