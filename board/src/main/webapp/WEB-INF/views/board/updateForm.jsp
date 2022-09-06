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
        <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
    </div>
</form>
<button id="btn-update" class="btn btn-primary">등록</button>
</div>
<script>
    $('.summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>