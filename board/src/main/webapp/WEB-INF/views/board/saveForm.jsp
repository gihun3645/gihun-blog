<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
<form>
    <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" placeholder="제목을 입력 하세요." id="title">
    </div>

    <div class="form-group">
        <label for="content">본문</label>
        <textarea class="form-control summernote" rows="5" id="content"></textarea>
    </div>
</form>
<button id="btn-save" class="btn btn-primary">등록</button>
</div>
<script>
    $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>