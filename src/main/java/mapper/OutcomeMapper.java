package mapper;


import model.Outcome;
import model.OutcomeKey;

public interface OutcomeMapper {
    int deleteByPrimaryKey(OutcomeKey key);

    int insert(Outcome record);

    int insertSelective(Outcome record);

    Outcome selectByPrimaryKey(OutcomeKey key);

    int updateByPrimaryKeySelective(Outcome record);

    int updateByPrimaryKey(Outcome record);
}