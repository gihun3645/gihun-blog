package com.study.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // @Entity는 제일 밑에 있는게 좋다?
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne // Many = Board, User = One 한명의 유저가 여러개의 게시글 가함
    @JoinColumn(name="userId")
    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.


    @CreationTimestamp
    private Timestamp createDate;
}
