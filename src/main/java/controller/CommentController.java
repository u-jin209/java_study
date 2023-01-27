package controller;

import model.BoardDTO;
import model.CommentDTO;

import java.util.ArrayList;
import java.util.Date;

public class CommentController {

    private int nextId; //댓글번호
    private ArrayList<CommentDTO> list;

    public CommentController(){
        list = new ArrayList<>();
        nextId =1;
    }

    public void add(CommentDTO commentDTO){
        commentDTO.setId(nextId++);
        commentDTO.setEntryDate(new Date());
        list.add(commentDTO);
    }


    public ArrayList<CommentDTO> selectAll(int boardId){
        ArrayList<CommentDTO> temp =new ArrayList<>();
        for(CommentDTO c :list){
            if (c.getBoardId() == boardId){
                temp.add(new CommentDTO(c));
            }
        }
        return temp;
    }

    public CommentDTO selectOne(int id){
        CommentDTO c = new CommentDTO();
        c.setId(id);
        if (list.contains(c)){
            return new CommentDTO(list.get(list.indexOf(c)));
        }else{
            return null;
        }

    }

    // 게시물 고유 아이디로 댓글 리스트 반환하기
    public ArrayList<CommentDTO> selectByBoardId(int id) {
        ArrayList<CommentDTO> result = new ArrayList<>();
        for (CommentDTO c : list) {
            if (c.getBoardId() == id) {
                result.add(new CommentDTO(c));
            }
        }
        return result;
    }

    public void update(CommentDTO commentDTO){
        commentDTO.setModifyDate(new Date());
        list.set(list.indexOf(commentDTO),commentDTO);

    }

    public void delete(int id){
        CommentDTO c = new CommentDTO();
        c.setId(id);
        list.remove(c);
    }
}
