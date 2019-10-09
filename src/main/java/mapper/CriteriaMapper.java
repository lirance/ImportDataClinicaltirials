package mapper;


import model.Criteria;

public interface CriteriaMapper {
    int deleteByPrimaryKey(Integer criterId);

    int insert(Criteria record);

    int insertSelective(Criteria record);

    Criteria selectByPrimaryKey(Integer criterId);

    int updateByPrimaryKeySelective(Criteria record);

    int updateByPrimaryKeyWithBLOBs(Criteria record);

    int updateByPrimaryKey(Criteria record);
}