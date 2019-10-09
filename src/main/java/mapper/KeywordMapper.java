package mapper;


import model.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(Integer keywordId);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer keywordId);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    Keyword select(Keyword record);
}