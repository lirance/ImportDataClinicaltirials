package mapper;


import model.Interober;

public interface InteroberMapper {
    int deleteByPrimaryKey(Integer interoberId);

    int insert(Interober record);

    int insertSelective(Interober record);

    Interober selectByPrimaryKey(Integer interoberId);

    int updateByPrimaryKeySelective(Interober record);

    int updateByPrimaryKeyWithBLOBs(Interober record);

    int updateByPrimaryKey(Interober record);
}