package mapper;


import model.InteroberStudyKey;

public interface InteroberStudyMapper {
    int deleteByPrimaryKey(InteroberStudyKey key);

    int insert(InteroberStudyKey record);

    int insertSelective(InteroberStudyKey record);
}