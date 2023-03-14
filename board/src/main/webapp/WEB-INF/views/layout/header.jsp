<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>송바래의 클라우드 여행</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="naver-site-verification" content="1d90cf1ec3ff40cb92bc644374ae1c720eda8b72" />
        <%--네이버 사이트 등록--%>

        <%--제이쿼리--%>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.js"></script>

        <%--토스트 UI--%>
        <!-- Editor's Style -->
        <link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.css" />
        <script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
        <script src="https://uicdn.toast.com/editor/latest/i18n/ko-kr.min.js"></script>
        <!-- 토스트 UI viewer css -->
        <link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor-viewer.min.css" />
        <%--부스트트랩--%>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a class="navbar-brand" href="/">홈</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">

            <c:choose>
                <c:when test="${empty principal}">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/blog">블로그</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/loginForm">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/joinForm">회원가입</a>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/blog">블로그</a>
                        </li>
<%--                            <li class="nav-item">--%>
<%--                                    <a class="nav-link" href="/board/saveForm">글쓰기</a>--%>
<%--                            </li>--%>
                        <li class="nav-item">
                            <a class="nav-link" href="/user/updateForm">회원정보</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout">로그아웃</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
            </div>
        </nav>
        <br />

    </body>