package mapper;


import model.KeywordStudyKey;

public interface KeywordStudyMapper {
    int deleteByPrimaryKey(KeywordStudyKey key);

    int insert(KeywordStudyKey record);

    int insertSelective(KeywordStudyKey record);
}