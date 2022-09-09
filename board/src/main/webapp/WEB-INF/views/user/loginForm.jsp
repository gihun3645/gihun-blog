<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" class="form-control" placeholder="Enter Username" id="username">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <button id="btn-login" class="btn btn-primary">로그인</button>
        <a href="https://Kauth.KaKao.com/oauth/authorize?client_id=8a6d5178b09b361a2c830eb2d1215108&redirect_uri=http://localhost:8080/auth/KaKao/callback&response_type=code">
            <img height="38px" src="/image/kakao_login_medium.png">
        </a>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>