package mapper;


import model.Location;

public interface LocationMapper {
    int deleteByPrimaryKey(Integer zip);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Integer zip);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}