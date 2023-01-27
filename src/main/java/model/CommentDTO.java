package model;

import java.util.Date;

public class CommentDTO {

    private int id; //댓글번호
    private int writerId; //회원번호
    private int boardId; //게시글번호
    private  String writerNickname; //회원 이름
    private String commentContent;//댓글 내용
    private Date entryDate;

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    private Date modifyDate;


    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    public  int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public boolean equals(Object o){
        if(o instanceof CommentDTO){
            CommentDTO c = (CommentDTO) o;
            return id == c.id;
        }return false;
    }

    public CommentDTO() {

    }
    public CommentDTO(CommentDTO origin){
        id = origin.id;
        commentContent = origin.commentContent;
        writerNickname = origin.writerNickname;
        writerId = origin.writerId;
        boardId = origin.boardId;
        modifyDate = origin.modifyDate;
        entryDate = origin.entryDate;

    }

    public CommentDTO(int id){
        this.id = id;
    }


}
